package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ListController {
    @Autowired
    private List<String> list;

    @GetMapping("/list")
    public String printList() {
        return list.toString();

    }
}
