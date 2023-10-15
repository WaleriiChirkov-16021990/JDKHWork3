package org.example.repositoryTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyService<T> implements MyRepository<T> {
    private final List<T> dataBase;
    private final String file;

    public MyService(List<T> dataBase, String file) {
        this.dataBase = dataBase;
        this.file = file;
    }

    public MyService(String file) {
        this.file = file;
        this.dataBase = new ArrayList<>();
    }

    @Override
    public void save() {
        try (FileWriter fileWriter = new FileWriter(this.file, false)) {
            this.dataBase.forEach(dataBase -> {
                try {
                    fileWriter.write(dataBase.toString() + "\n");
                    fileWriter.flush();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void add(T entity) {
        try (FileWriter fileWriter = new FileWriter(this.file, true)) {
            this.dataBase.add(entity);
            fileWriter.write(entity.toString() + "\n");
            fileWriter.flush();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(T entity) {
        this.dataBase.remove(entity);

    }

    @Override
    public void update(T entity, T update) {
        this.dataBase.set(this.dataBase.indexOf(entity), update);
    }

    @Override
    public T find(int id) {
        try {
            if (this.dataBase.size() >= id) {
                return this.dataBase.get(id);
            }
            throw new IllegalArgumentException("person not found");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        return this.dataBase;
    }

    @Override
    public void read() {
        File file = new File(this.file);
        if (file.exists() && !file.isDirectory()) {
            try (FileReader fileReader = new FileReader(file); BufferedReader fileBuffer = new BufferedReader(fileReader)) {
                String line;
                while ((line = fileBuffer.readLine())!= null) {
                        this.dataBase.add((T) Person.parse(line));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
//            throw new RuntimeException("File not found");
            System.out.println("File not found");
        }
    }

}
