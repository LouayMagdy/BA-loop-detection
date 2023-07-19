package com.example.loopdetectionbackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("loop-detection-server")
public class Controller {
    @PostMapping("/detect")
    public Response detectLoops(@RequestBody Request request){
        return null;
    }
}
