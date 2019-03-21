package com.clk.datasource.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @program: data_source
 * @description: MyRoutingDataSource
 * @author: Reagan Li
 * @create: 2019-03-21 10:32
 **/
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
