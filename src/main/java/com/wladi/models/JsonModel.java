package com.wladi.models;

import java.sql.SQLException;
import java.util.List;

public class JsonModel {

    public String jsonBuilder(QueryResultModel queryResult) throws SQLException {
        List<List<String>> allResults = queryResult.getData();
        int columnCount = queryResult.getMetaData().getColumnCount();
        String[] columnNames = new String[columnCount];

        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = queryResult.getMetaData().getColumnName(i + 1);
        }

        StringBuilder jsonBuilder = new StringBuilder();

        for (List<String> row : allResults) {
            jsonBuilder.append("  {\n");

            String[] keyValuePairs = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                keyValuePairs[i] = formatJsonField(columnNames[i], row.get(i));
            }

            jsonBuilder.append("    ");
            jsonBuilder.append(String.join(",\n    ", keyValuePairs));
            jsonBuilder.append("\n  }");
            if (allResults.indexOf(row) < allResults.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        return jsonBuilder.toString();
    }

    private static String formatJsonField(String key, String value) {
        if (value == null) {
            return String.format("\"%s\": null", key);
        } else {
            return String.format("\"%s\": \"%s\"", key, value);
        }
    }

}
