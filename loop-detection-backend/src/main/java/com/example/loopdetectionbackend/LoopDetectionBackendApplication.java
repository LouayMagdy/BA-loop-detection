package com.example.loopdetectionbackend;

import com.example.loopdetectionbackend.service.GraphFactory;
import com.example.loopdetectionbackend.service.LoopDetectorService;
import com.example.loopdetectionbackend.service.SCCTarjanGetter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoopDetectionBackendApplication {

    public static void main(String[] args) {
//        int[][] edges = {{1, 2}, {1, 5}, {1, 8}, {2, 3}, {2, 7}, {2, 9}, {3, 1}, {3, 2}, {3, 4}, {3, 6}, {4, 5}, {5, 2}, {6, 4}, {8, 9}, {9, 8}};
//        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {3, 1}, {2, 4}, {4, 2}, {1, 3}};
//        LoopDetectorService service = new LoopDetectorService();
//        service.getLoops(edges);
//        System.out.println("=============\n" + service.getLoops());
        SpringApplication.run(LoopDetectionBackendApplication.class, args);
    }

}
