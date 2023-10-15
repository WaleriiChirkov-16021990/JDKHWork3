package org.example.repositoryTask;

import org.example.repositoryTask.MyController;
import org.example.repositoryTask.MyService;
import org.example.repositoryTask.Person;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MyService<Person> personService = new MyService<>("src/main/java/org/example/repositoryTask/testDataBase.txt");
        MyController<Person> personController = new MyController(personService);
//        personController.add(new Person(1,"John", 31));
//        personController.add(new Person(2,"Carl", 33));
//        personController.add(new Person(3,"Misha", 45));
        System.out.println(personController.findAll().toString());
        System.out.println();
        System.out.println(personController.find(1).toString());
        personController.delete(personController.find(1));
        System.out.println(personController.findAll().toString());
        Person updatePerson = personController.find(1);
        updatePerson.setAge(300);
        updatePerson.setName("Kail");
        personController.update(personController.find(1), updatePerson);
        System.out.println(personController.findAll().toString());
        personController.save();
    }
}