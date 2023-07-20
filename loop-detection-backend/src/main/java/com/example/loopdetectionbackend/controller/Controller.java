package com.example.loopdetectionbackend.controller;

import com.example.loopdetectionbackend.service.LoopDetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("loop-detection-server")
public class Controller {
    @Autowired
    private LoopDetectorService loopDetectorService;

    @PostMapping("/detect")
    public ResponseEntity<Response> detectLoops(@RequestBody Request request){
        this.loopDetectorService.getLoops(request.edges);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(loopDetectorService.getLoops()));
    }
}
