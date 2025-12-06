package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("items")
@Getter
@Setter
public class Item {
    @PrimaryKey
    private String id;
    private String name;
    private String value;

}
