package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import de.huxhorn.sulky.ulid.ULID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
	public static final ULID ULID = new ULID();
	private final ItemRepository repo;
    public ItemController(ItemRepository repo){this.repo=repo;}

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item req){
        if(req.getId()==null) req.setId(ULID.nextULID());
        return ResponseEntity.ok(repo.save(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable String id){
        return repo.findById(id)
                   .map(ResponseEntity::ok)
                   .orElseGet(()->ResponseEntity.notFound().build());
    }
}
