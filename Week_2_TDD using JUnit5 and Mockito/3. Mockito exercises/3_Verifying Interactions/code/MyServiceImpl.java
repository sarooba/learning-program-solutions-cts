package com.example;

public class MyServiceImpl {
    private MyApiInterface api;

    public MyServiceImpl(MyApiInterface api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
