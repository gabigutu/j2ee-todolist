package com.gabigutu.todolist.utils;

import com.gabigutu.todolist.dto.TodoElementDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static HibernateUtil hibernateUtil;
    private Session session;

    private HibernateUtil() { }

    public static HibernateUtil getInstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
            hibernateUtil.init();
        }
        return hibernateUtil;
    }

    private void init() {
        Configuration configuration = new Configuration();
        ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
        configuration.setProperties(applicationProperties.getProperties());
        configuration.addAnnotatedClass(TodoElementDTO.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public Session getSession() {
        return session;
    }
}
