package com.example.frontendwebapp.app.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

///////////////////////////////////////////////////////////////////////
// @ConfigurationProperties を利用することで、application.ymlの値を取得できる
//  - prefix = "service"をしていることで、「service」階層を指定
//  - 変数String dns を宣言することで、service階層配下のdnsフィールドを取得
// ========== application.yml ==========
// service:
//     dns: http://xxxx.com ←private String dns; に格納される
//     username: Taro
//     pw: hogehoge
// =====================================
///////////////////////////////////////////////////////////////////////

@Component
@ConfigurationProperties(prefix = "service")
public class ServiceProperties {

    private String dns;

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getDns(){
        return dns;
    }
}
