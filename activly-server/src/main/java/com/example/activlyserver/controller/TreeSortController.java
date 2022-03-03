package com.example.activlyserver.controller;

import com.example.activlyserver.treesort.TreeSort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/treeSort")
@RequiredArgsConstructor
public class TreeSortController {
    
    
    @PostMapping
    public List<Integer> sortArray(@RequestBody List<Integer> array){
        if(array.size() ==0 ){
            return new ArrayList<>();
        }
        TreeSort treeSort = new TreeSort();
        return treeSort.sort(array);
    }
    
}
