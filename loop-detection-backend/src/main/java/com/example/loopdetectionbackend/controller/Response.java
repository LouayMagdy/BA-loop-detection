package com.example.loopdetectionbackend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Response {
    List<List<Integer>> loops;
}
