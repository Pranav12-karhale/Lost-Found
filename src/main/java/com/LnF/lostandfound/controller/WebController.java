package com.LnF.lostandfound.controller;

import com.LnF.lostandfound.dao.FoundItemRepository;
import com.LnF.lostandfound.dao.LostItemRepository;
import com.LnF.lostandfound.model.FoundItem;
import com.LnF.lostandfound.model.LostItem;
import com.LnF.lostandfound.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WebController {

    @ModelAttribute("currentUri")
    public String currentUri(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @Autowired
    private LostItemRepository lostItemRepository;

    @Autowired
    private FoundItemRepository foundItemRepository;

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String dashboard(Model model) {
        long lostCount = lostItemRepository.count();
        long foundCount = foundItemRepository.count();

        model.addAttribute("lostCount", lostCount);
        model.addAttribute("foundCount", foundCount);
        // Simple logic for matched count for now
        model.addAttribute("matchedCount", 0);

        return "dashboard";
    }

    @GetMapping("/report-lost")
    public String reportLostForm(Model model) {
        model.addAttribute("lostItems", lostItemRepository.findAll());
        return "report-lost";
    }

    @PostMapping("/report-lost")
    public String submitLostItem(
            @RequestParam("itemName") String itemName,
            @RequestParam("category") String category,
            @RequestParam("location") String location,
            @RequestParam("lostDate") Date lostDate,
            @RequestParam("color") String color,
            @RequestParam("brand") String brand,
            @RequestParam("description") String description,
            @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

        LostItem item = new LostItem();
        item.setItemName(itemName);
        item.setCategory(category);
        item.setLocation(location);
        item.setLostDate(lostDate);
        item.setColor(color);
        item.setBrand(brand);
        item.setDescription(description);

        if (image != null && !image.isEmpty()) {
            item.setImagePath(fileService.saveFile(image));
        }

        lostItemRepository.save(item);
        return "redirect:/report-lost";
    }

    @GetMapping("/report-found")
    public String reportFoundForm(Model model) {
        model.addAttribute("foundItems", foundItemRepository.findAll());
        return "report-found";
    }

    @PostMapping("/report-found")
    public String submitFoundItem(
            @RequestParam("itemName") String itemName,
            @RequestParam("category") String category,
            @RequestParam("locationFound") String locationFound,
            @RequestParam("foundDate") Date foundDate,
            @RequestParam("color") String color,
            @RequestParam("brand") String brand,
            @RequestParam("description") String description,
            @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

        FoundItem item = new FoundItem();
        item.setItemName(itemName);
        item.setCategory(category);
        item.setLocationFound(locationFound);
        item.setFoundDate(foundDate);
        item.setColor(color);
        item.setBrand(brand);
        item.setDescription(description);

        if (image != null && !image.isEmpty()) {
            item.setImagePath(fileService.saveFile(image));
        }

        foundItemRepository.save(item);
        return "redirect:/report-found";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(value = "searchTerm", required = false) String searchTerm,
            @RequestParam(value = "category", required = false, defaultValue = "All") String category,
            @RequestParam(value = "type", required = false, defaultValue = "Both") String type,
            Model model) {

        // search for the controller.map to the SearchResult DTO.

        if ("Both".equals(type) || "Lost".equals(type)) {
            if (searchTerm != null && !searchTerm.isEmpty()) {
                model.addAttribute("lostResults", lostItemRepository
                        .findByItemNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchTerm, searchTerm));
            } else {
                model.addAttribute("lostResults", lostItemRepository.findAll());
            }
        }

        if ("Both".equals(type) || "Found".equals(type)) {
            if (searchTerm != null && !searchTerm.isEmpty()) {
                model.addAttribute("foundResults", foundItemRepository
                        .findByItemNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchTerm, searchTerm));
            } else {
                model.addAttribute("foundResults", foundItemRepository.findAll());
            }
        }

        return "search";
    }
}
