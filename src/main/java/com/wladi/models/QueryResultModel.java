package com.wladi.models;

import java.sql.ResultSetMetaData;
import java.util.List;

public class QueryResultModel {

    private List<List<String>> data;
    private ResultSetMetaData metaData;

    public QueryResultModel(List<List<String>> data, ResultSetMetaData metaData) {
        this.data = data;
        this.metaData = metaData;
    }

    public List<List<String>> getData() {
        return data;
    }

    public ResultSetMetaData getMetaData() {
        return metaData;
    }

}