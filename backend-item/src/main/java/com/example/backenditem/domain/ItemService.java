package com.example.backenditem.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private List<Item> allItems = Arrays.asList(
        new Item("10001", "ネックレス", "ジュエリ"),
        new Item("10002", "パーカー", "ファッション"),
        new Item("10003", "フェイスクリーム", "ビューティ"),
        new Item("10004", "サプリメント", "ヘルス"),
        new Item("10005", "ブルーベリー", "フード")
    );

    // 全てのItemリストを返すメソッド
    public List<Item> getAllItems() {
        return allItems;
    }

    // 個別のItemを返すメソッド
    public Item getItem(String itemId) {
        for (int i=0; i<allItems.size(); i++){
            if (allItems.get(i).getItemId().equals(itemId)) {
                return allItems.get(i);
            }
        }
        return null;    // itemIdが見つからなかったらnullを返す
    }

}
