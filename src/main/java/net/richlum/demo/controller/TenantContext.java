package net.richlum.demo.controller;

public class TenantContext{
    public static ThreadLocal<String> tenant = new ThreadLocal<String>();

    public static void clear(){
        tenant.remove();
    }

}