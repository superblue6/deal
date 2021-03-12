package com.kuaipao.user.bean;

import lombok.Data;

import java.util.List;
@Data
public class Cat {
    private String id;
    private String parentId;
    private String name;
    private List<Cat> children;
}
