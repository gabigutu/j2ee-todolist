package com.gabigutu.todolist.utils;

import org.hibernate.cfg.Environment;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Properties;

public class ApplicationProperties { // Singleton

    private static ApplicationProperties instance;
    private Properties properties;

    private ApplicationProperties() { }

    public static ApplicationProperties getInstance() {
        if (instance == null) {
            instance = new ApplicationProperties();
            instance.init();
        }
        return instance;
    }

    private void init() {
        properties = new Properties();
        initDatabaseProperties();
        initHibernateProperties();
    }

    private void initDatabaseProperties() {
        properties.setProperty("jdbc_driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("user", System.getenv("J2EE_DB_USER"));
        properties.setProperty("password", System.getenv("J2EE_DB_PASSWORD"));
        properties.setProperty("database_uri", System.getenv("J2EE_DB_URI"));
    }

    private void initHibernateProperties() {
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty(Environment.HBM2DDL_AUTO,"update");
        properties.setProperty(Environment.DRIVER, properties.getProperty("jdbc_driver"));
        properties.setProperty(Environment.USER, System.getenv("J2EE_DB_USER"));
        properties.setProperty(Environment.PASS, System.getenv("J2EE_DB_PASSWORD"));
        properties.setProperty(Environment.URL, System.getenv("J2EE_DB_URI"));
    }

    public Properties getProperties() {
        return properties;
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
