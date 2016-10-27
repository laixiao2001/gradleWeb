package com.test.common;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

/**
 * Created by svenlau on 2016/10/27.
 */
public class MyNamingStategy extends ImprovedNamingStrategy {
    public String classToTableName(String className){
        return StringHelper.unqualify(className).toUpperCase()+'S';
    }

    public String propertyToColumnName(String propertyName){
        return propertyName;
    }

    public String tableName(String tableName){
        return tableName;
    }

    public String columnName(String columnName){
        return columnName;
    }
}
