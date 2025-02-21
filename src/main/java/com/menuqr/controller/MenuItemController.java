package com.menuqr.controller;

import com.menuqr.model.MenuItem;
import com.menuqr.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    // Get all menu items
    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    // Add a new menu item
    @PostMapping
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    // Delete a menu item by ID
    @DeleteMapping("/{id}")
    public String deleteMenuItem(@PathVariable Long id) {
        menuItemRepository.deleteById(id);
        return "Menu item deleted!";
    }
}
