package com.wladi.persistence;

import java.sql.SQLException;

import com.wladi.models.QueryResultModel;

public interface QuerySelector {

    QueryResultModel generateDataAndMetaData(String tableName) throws SQLException;

}


