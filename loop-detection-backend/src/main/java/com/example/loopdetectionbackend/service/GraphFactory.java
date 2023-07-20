package com.example.loopdetectionbackend.service;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class GraphFactory {
    private Map<Integer, List<Integer>> adjList;
    private Integer nodeToNeglect;

    public GraphFactory() {
        this.nodeToNeglect = -1;
        this.adjList = new HashMap<>();
    }

    public void makeGraph(int[][] edges){
        this.adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0] <= nodeToNeglect || edges[i][1] <= nodeToNeglect) continue;
            List<Integer> neighbours = this.adjList.getOrDefault(edges[i][0], new ArrayList<>());
            neighbours.add(edges[i][1]);
            if(neighbours.size() == 1) this.adjList.put(edges[i][0], neighbours);
        }
    }

    public List<List<Integer>> getSelfLoops(int[][] edges){
        List<List<Integer>> selfLoops = new ArrayList<>();
        for (int[] edge: edges) {
            if (edge[0] == edge[1]){
                List<Integer> selfLoop = new ArrayList<>();
                selfLoop.add(edge[0]);
                selfLoop.add(edge[1]);
                selfLoops.add(selfLoop);
            }
        }
        return selfLoops;
    }
}
