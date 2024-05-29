package com.wladi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wladi.configuration.DatabaseConnection;
import com.wladi.models.JsonModel;
import com.wladi.models.QueryResultModel;
import com.wladi.models.SelectQueryModel;
import com.wladi.persistence.QuerySelector;

public class Component implements QuerySelector {

    private Connection connection;
    private JsonModel jsonModel;

    public Component(DatabaseConnection databaseConnection) throws SQLException {
        this.connection = databaseConnection.getConnection();
        this.jsonModel = new JsonModel();
    }

    @Override
    public QueryResultModel generateDataAndMetaData(String tableName) throws SQLException {
        SelectQueryModel queryModel = new SelectQueryModel(tableName);
        List<List<String>> results = new ArrayList<>();
        ResultSetMetaData metaData = null;
        try {
            PreparedStatement statement = connection.prepareStatement(queryModel.generateSQL());
            ResultSet resultSet = statement.executeQuery();
            metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
                results.add(row);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return new QueryResultModel(results, metaData);
    }

    public String createJson(String tableName) throws SQLException {
        QueryResultModel queryResult = generateDataAndMetaData(tableName);
        return jsonModel.jsonBuilder(queryResult);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
}
