package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ItemRepository extends CassandraRepository<Item, String> {}
