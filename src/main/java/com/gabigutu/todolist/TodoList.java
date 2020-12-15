package com.gabigutu.todolist;

import java.io.*;
import java.util.ArrayList;

public class TodoList {

    ArrayList<TodoElement> todoElements;

    public TodoList() {
        todoElements = new ArrayList<>();
    }

    private void parseLine(String line) {
        String[] parts = line.split(":");
        String title = parts[0];
        boolean done = Boolean.parseBoolean(parts[1]);
        addElement(title, done);
    }

    public void addElement(String title) {
        addElement(title, false);
    }

    public void addElement(String title, boolean done) {
        TodoElement todoElement = new TodoElement(title);
        todoElement.setDone(done);
        todoElements.add(todoElement);
    }

    public void load(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) throw new IOException("IOException: File does not exist");

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            do {
                String line = bufferedReader.readLine();
                if ("".equals(line)) continue;
                if (null == line) break;

                parseLine(line);
            } while (true);
            bufferedReader.close();
        } catch (IOException e) {
            throw new IOException("IOException: " + e.getMessage());
        }
    }

    public void save(String filename) throws IOException  {
        File file = new File(filename);
//        if (file.exists()) TODO: ask user if overwrite

        BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter(file));
        for(TodoElement todoElement : todoElements) {
            bufferedWriter.write(
                    todoElement.getTitle() + ':' + todoElement.getDone() + "\n"
            );
        }

        bufferedWriter.close();
    }


}
