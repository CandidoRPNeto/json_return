package com.wladi;

import java.util.ArrayList;
import java.util.List;

public class SelectQuery {

    private String tableName;
    private List<String> columns;
    private String whereClause;

    public SelectQuery(String tableName) {
        this.tableName = tableName;
        this.columns = new ArrayList<>();
    }

    public void addColumn(String column) {
        columns.add(column);
    }

    public void setWhereClause(String whereClause) {
        this.whereClause = whereClause;
    }

    public String generateSQL() {
        StringBuilder sql = new StringBuilder("SELECT ");
        if (columns.isEmpty()) {
            sql.append("*");
        } else {
            sql.append(String.join(", ", columns));
        }
        sql.append(" FROM ").append(tableName);
        if (whereClause != null) {
            sql.append(" WHERE ").append(whereClause);
        }
        return sql.toString();
    }
    
}
