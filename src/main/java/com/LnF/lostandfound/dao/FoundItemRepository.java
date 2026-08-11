package com.LnF.lostandfound.dao;

import com.LnF.lostandfound.model.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoundItemRepository extends JpaRepository<FoundItem, Integer> {
    List<FoundItem> findByItemNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String desc);
    List<FoundItem> findByCategory(String category);
}
