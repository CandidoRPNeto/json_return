package com.wladi.models;

public class SelectQueryModel {

    private String tableName;

    public SelectQueryModel(String tableName) {
        this.tableName = tableName;
    }

    public String generateSQL() {
        return String.format("SELECT * FROM %s", tableName);
    }
    
}
