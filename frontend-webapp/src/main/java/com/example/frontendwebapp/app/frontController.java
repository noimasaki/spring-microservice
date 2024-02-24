package com.example.frontendwebapp.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.frontendwebapp.domain.itemService;

@Controller
public class frontController {

    // Logger生成
    // getLoggerの引数にClassオブジェクトを指定するとロガー名はそのクラスのFQDNとなる
    private static final Logger logger = LoggerFactory
        .getLogger(frontController.class);

    // 引数なしの場合はアプリケーションのコンテキストルート
    // http://<ホスト名>:<ポート番号>/ へのGET時に呼び出される
    @GetMapping
    public String home(){
        // ログ出力
        logger.info("アクセスログ");

        return "home";      // home.htmlをreturn
    }

    // http://<ホスト名>:<ポート番号>/login
    @GetMapping("/login")
    public String login(){
        return "login";     // login.htmlをreturn
    }

    // http://<ホスト名>:<ポート番号>/logout
    @GetMapping("/logout")
    public String logout(){
        return "logout";    // logout.htmlをreturn
    }

    // backend-item呼び出し
    // http://<ホスト名>:<ポート番号>/items
    @Autowired
    private itemService itemService;

    @GetMapping("/items")
    @ResponseBody
    public String items(){
        // @ResponseBodyアノテーションにより、バックエンドから返却した戻り値をそのまま文字情報としてreturn
        return itemService.getAllItems();
    }

}
