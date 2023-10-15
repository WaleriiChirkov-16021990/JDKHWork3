package org.example.repositoryTask;

import java.util.Objects;

public class Person {
    private static int count;
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        count++;
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age) {
        this.id = ++count;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static Person parse(String s) {
        s = s.replace("Person{", "")
                .replace("}", "")
                .replace("id=", "")
                .replace("name=", "")
                .replace("'", "")
                .replace("age=", "");
        String[] list = s.split(",");

        return new Person(Integer.parseInt(list[0].strip())
                , list[1].strip()
                , Integer.parseInt(list[2].strip()));
    }
}
