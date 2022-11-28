package com.jun.todo.controller;

import com.jun.todo.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String testController(){
        return "Hello World!";
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("hello world, i'm responseEntity, and you got 400");
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(responseDTO);
    }
}
