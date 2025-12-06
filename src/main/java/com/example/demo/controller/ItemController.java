package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemRepository repo;
    public ItemController(ItemRepository repo){this.repo=repo;}

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item req){
        if(req.getId()==null) req.setId(UUID.randomUUID());
        return ResponseEntity.ok(repo.save(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable UUID id){
        return repo.findById(id)
                   .map(ResponseEntity::ok)
                   .orElseGet(()->ResponseEntity.notFound().build());
    }
}