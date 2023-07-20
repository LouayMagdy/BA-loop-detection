package com.example.loopdetectionbackend.service;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class SCCTarjanGetter {
    private Stack<Integer> stack;
    private boolean[] stackArr;
    private boolean[] visited;
    private int[][] times;
    private Map<Integer, List<Integer>> myGraph;

    private Map<Integer, Integer> node_component;
    private int startTime;
    private int sccCount ;
    private int minSCCItem ;

    private int size = Integer.MIN_VALUE;


    public void getSSCs(Map<Integer, List<Integer>> graph){
        if(size == Integer.MIN_VALUE){
            for (Integer node: graph.keySet()) {
                size = Math.max(size, node);
                List<Integer> neighbors = graph.get(node);
                for (Integer neighbor : neighbors)
                    size = Math.max(size, neighbor);
            }
            size++;
        }

        this.stack = new Stack<>();
        this.stackArr = new boolean[size];
        this.visited = new boolean[size];
        this.times = new int[size][2];
        this.myGraph = graph;
        this.node_component = new HashMap<>();

        this.startTime = 0;
        this.sccCount = 0;
        this.minSCCItem = Integer.MAX_VALUE;

        for(Integer node: graph.keySet()){
            this.visit(node);
        }
    }

    private void visit(int node){
        this.stack.add(node);
        this.stackArr[node] = true;
        this.visited[node] = true;
        this.times[node][0] = this.times[node][1] = this.startTime++;
        List<Integer> neighbors = myGraph.get(node);
        if (!myGraph.containsKey(node)){
            this.stack.pop();
            this.stackArr[node] = false;
            return;
        }
        for(Integer neighbor : neighbors){
            if(visited[neighbor] && stackArr[neighbor]) times[node][1] = Math.min(times[node][1], times[neighbor][0]);
            else if (!visited[neighbor]){
                visit(neighbor);
                times[node][1] = Math.min(times[node][1], times[neighbor][1]);
            }
        }
        if(times[node][0] == times[node][1]){
            int n = -1;
            List<Integer> scc = new ArrayList<>();
            while (n != node){
                n = stack.pop();
                scc.add(n);
                stackArr[n] = false;
            }
            if(scc.size() > 1){
                System.out.println(scc);
                for (Integer v: scc) {
                    this.minSCCItem = Math.min(this.minSCCItem, v);
                    this.node_component.put(v, this.sccCount);
                }
                this.sccCount++;
            }
        }
    }

}
