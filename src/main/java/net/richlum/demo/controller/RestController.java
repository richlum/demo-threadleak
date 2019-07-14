package net.richlum.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.richlum.demo.controller.TenantContext;


@Controller
@ResponseBody
public class RestController {

    @GetMapping("/")
    public String booyah(){
        TenantContext.tenant.set("booyah");
        System.out.println(TenantContext.tenant.get() + " , thread " 
            + Thread.currentThread().getId() + " : " + Thread.currentThread().getName());
        return "Booyah!";
    }


    @GetMapping(value = "/hi")
    @ResponseBody
    public String hello(){
        System.out.println("hello..." + TenantContext.tenant.get() + " , thread: " 
            + Thread.currentThread().getId() + " : " + Thread.currentThread().getName());
        return "Hello World";
    }
    @GetMapping(value = "/error")
    public String err(){
        System.out.println("oops"  + Thread.currentThread().getId() + " : " + Thread.currentThread().getName());
        return "OOOPS!";
    }
    
}