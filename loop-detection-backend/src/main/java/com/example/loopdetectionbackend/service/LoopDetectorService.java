package com.example.loopdetectionbackend.service;

import com.example.loopdetectionbackend.controller.Request;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoopDetectorService {
    private List<List<Integer>> adjList;
    private State[] states;

    public int[] detectLoop(Request request){
        this.setAdjList(request.getNodesNum(), request.getEdges());
        this.setStates(request.getNodesNum());

    }

    private void getSCC(){}

    private void applyJohnsonAlgorithm(){}

    private void setAdjList(int nodesNum, int[][] edges){
        this.adjList = new ArrayList<>();
        for (int i = 0; i < nodesNum; i++) this.adjList.add(new ArrayList<>());
        for(int[] edge : edges) this.adjList.get(edge[0]).add(edge[1]);
    }

    public void setStates(int nodesNum) {
        this.states = new State[nodesNum];
        for (int i = 0; i < nodesNum; i++) this.states[i] = State.Unprocessed;
    }
}
