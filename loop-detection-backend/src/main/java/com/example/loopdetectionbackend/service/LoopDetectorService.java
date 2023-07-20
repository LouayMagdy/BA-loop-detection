package com.example.loopdetectionbackend.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
@Setter
public class LoopDetectorService {
    private GraphFactory graphFactory;
    private SCCTarjanGetter sccTarjanGetter;

    private Stack<Integer> stack;
    private Set<Integer> blockedSet;
    private Map<Integer, Set<Integer>> blockedMap;

    private Map<Integer, Integer> node_component;
    private Map<Integer, List<Integer>> adjList;

    private List<List<Integer>> loops;

    private int startIndex;


    public LoopDetectorService() {
        this.graphFactory = new GraphFactory();
        this.sccTarjanGetter = new SCCTarjanGetter();
        this.loops = new ArrayList<>();
    }

    public void getLoops(int[][] edges){
        this.graphFactory.makeGraph(edges);
        this.adjList = this.graphFactory.getAdjList();
        if(this.adjList.size() == 0) return;
        this.sccTarjanGetter.getSSCs(this.adjList);
        this.node_component = this.sccTarjanGetter.getNode_component();
        if(node_component.size() == 0) return;

        this.startIndex = this.sccTarjanGetter.getMinSCCItem();
        this.graphFactory.setNodeToNeglect(startIndex);

        this.stack = new Stack<>();
        this.blockedSet = new HashSet<>();
        this.blockedMap = new HashMap<>();
        findLoop(this.startIndex);
        getLoops(edges);
    }

    private boolean findLoop(int node){
        boolean loopFound = false;
        this.stack.add(node);
        this.blockedSet.add(node);

        List<Integer> neighbors = this.adjList.get(node);
        for (Integer neighbor : neighbors) {
            if(!Objects.equals(this.node_component.get(node), this.node_component.get(neighbor))) continue;
            if(neighbor == this.startIndex){
                this.stack.push(this.startIndex);
                List<Integer> loop = new ArrayList<>();
                loop.addAll(this.stack);
                this.stack.pop();
                this.loops.add(loop);
                loopFound = true;
            }
            else if (!this.blockedSet.contains(neighbor)) {
                boolean anotherLoop = findLoop(neighbor);
                loopFound = loopFound || anotherLoop;
            }
        }
        if(loopFound) this.unBlock(node);
        else{
            for (Integer neighbor: neighbors) {
                Set<Integer> blocked = blockedMap.getOrDefault(neighbor, new HashSet<>());
                blocked.add(node);
                if(blocked.size() == 1) blockedMap.put(neighbor, blocked);
            }
        }
        stack.pop();
        return loopFound;
    }

    private void unBlock(int node){
        this.blockedSet.remove(node);
        Set<Integer> blockedDueToNode = this.blockedMap.get(node);
        if(blockedDueToNode == null) return;
        for (Integer blocked: blockedDueToNode) {
            if(blockedDueToNode.contains(blocked)) unBlock(blocked);
        }
    }

    public List<List<Integer>> getLoops() {
        this.graphFactory = new GraphFactory();
        this.sccTarjanGetter = new SCCTarjanGetter();
        return loops;
    }
}
