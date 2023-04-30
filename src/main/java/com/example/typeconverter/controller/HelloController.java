package com.example.typeconverter.controller;

import com.example.typeconverter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        String data = request.getParameter("data");// 문자타입 조회
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);
        return "ok";
    }
    @GetMapping("/hello-V2")
    public String HelloV2(@RequestParam Integer data){
        System.out.println("data = " + data);
        return "ok";
    }
    @GetMapping("/ip-port")
    public String IpPort(@RequestParam IpPort ipPort){
        System.out.println("ip = " + ipPort.getIp());
        System.out.println("ipPort = " + ipPort.getPort());
        return "OK";
    }




}
