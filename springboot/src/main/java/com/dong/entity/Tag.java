package com.dong.entity;

import lombok.Data;

@Data
public class Tag {

    private int id;
    private String name;
    private String content;
    private int parent;
}
