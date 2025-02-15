// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.starrocks.sql.optimizer.dump;

import com.starrocks.catalog.Resource;
import com.starrocks.catalog.Table;
import com.starrocks.catalog.View;
import com.starrocks.sql.ast.StatementBase;
import com.starrocks.sql.optimizer.statistics.ColumnStatistic;

import java.util.Map;

public interface DumpInfo {
    default void setOriginStmt(String stmt) {
    }

    default void setStatement(StatementBase statement) {
    }

    default void addException(String exception) {
    }

    default void addTable(String dbName, Table table) {
    }

    default void addView(String dbName, View view) {
    }

    default void addTableStatistics(Table table, String column, ColumnStatistic columnStatistic) {
    }

    default void addPartitionRowCount(Table table, String partition, long rowCount) {
    }

    default void addResource(Resource resource) {
    }

    default void addHMSTable(String resourceName, String dbName, String tableName) {
    }

    default Map<String, Map<String, Map<String, HiveMetaStoreTableDumpInfo>>> getHmsTableMap() {
        return null;
    }

    default HiveMetaStoreTableDumpInfo getHMSTable(String resourceName, String dbName, String tableName) {
        return new HiveTableDumpInfo();
    }

    default void reset() {
    }
}
