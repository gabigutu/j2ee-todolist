package com.gabigutu.todolist;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "todoServlet", value = "/todo-servlet")
public class TodoServlet extends HttpServlet {

    private String filename;
    private TodoList todoList;

    public void init() {
        todoList = new TodoList();
        filename = "mylist.todo";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("Your request: " + action);
        switch (action) {
            case "saveToFile":
                System.out.println("Save to file " + filename);
                todoList.save(filename);
                break;
            case "addElement":
                String title = req.getParameter("title");
                System.out.println("Add element " + title);
                todoList.addElement(title);
                // save to database
                break;
            default: throw new IOException("IOException: Operation Not Supported");
        }

        resp.setStatus(200);
    }

    public void destroy() {
    }
}