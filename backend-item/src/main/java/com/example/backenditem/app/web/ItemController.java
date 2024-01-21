package com.example.backenditem.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenditem.domain.model.Item;
import com.example.backenditem.domain.service.ItemService;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    // @GetMappingで"/items"へアクセスしたときにgetAllItems()を実行
    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
    // @GetMapping("/items")
    // public String getAllItems() {
    //     return "ALL items !!";
    // }

    // 全てのitemではなく、itemIdで個別の情報を返す
    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable("id") String id){
        return itemService.getItem(id);
    }
}