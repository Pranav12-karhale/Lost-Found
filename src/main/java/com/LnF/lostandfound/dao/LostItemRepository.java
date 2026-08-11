package com.LnF.lostandfound.dao;

import com.LnF.lostandfound.model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostItemRepository extends JpaRepository<LostItem, Integer> {
    List<LostItem> findByItemNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String desc);
    List<LostItem> findByCategory(String category);
}
