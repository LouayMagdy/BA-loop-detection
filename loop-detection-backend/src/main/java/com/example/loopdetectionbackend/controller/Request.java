package com.example.loopdetectionbackend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    int[][] edges;
    int nodesNum;
}
