package com.example.backenditem.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenditem.domain.Item;
import com.example.backenditem.domain.ItemService;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    // 全てのItem情報を返す
    // http://<ホスト名>:<ポート番号>/
    @GetMapping("/items")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    // 個別のItem情報を返す
    // http://<ホスト名>:<ポート番号>/{商品ID}
    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable("itemId") String itemId){
        return itemService.getItem(itemId);
    }

}
