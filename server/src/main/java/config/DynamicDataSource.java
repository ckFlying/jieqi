package config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * create by wjwang on ${date}
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("determineCurrentLookupKey start"+DataSourceContextHolder.getDS());
        return DataSourceContextHolder.getDS();
    }
}
