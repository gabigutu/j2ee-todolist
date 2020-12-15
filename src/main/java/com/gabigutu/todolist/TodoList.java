package com.gabigutu.todolist;

import java.io.*;
import java.util.ArrayList;
import jdk.internal.joptsimple.internal.Strings;

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
        if (!file.exists()) throw new IOException("IOException: File does not exist: " + file.getAbsolutePath());

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            do {
                String line = bufferedReader.readLine();
                if(Strings.isNullOrEmpty(line)) break;
                parseLine(line);
            } while (true);
            bufferedReader.close();
        } catch (IOException e) {
            throw new IOException("IOException: " + e.getMessage());
        }
    }

    public void save(String filename) throws IOException  {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println("Trying to save to file " + filename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        System.out.println("There are " + todoElements.size() + " elements");
        for(TodoElement todoElement : todoElements) {
            bufferedWriter.write(
                    todoElement.getTitle() + ':' + todoElement.getDone() + "\n"
            );
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }


}
