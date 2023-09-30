package org.example;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = -1;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        if (this.age == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean hasAddress() {
        if (this.address.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public OptionalInt getAge() {
        if (this.hasAge()) {
            return OptionalInt.of(this.age);
        } else {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (this.hasAge()) {
            this.age = this.age + 1;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder newPersonBuilder = new PersonBuilder();
        newPersonBuilder.setSurname(this.surname);
        newPersonBuilder.setAddress(this.address);
        newPersonBuilder.setAge(0);
        return newPersonBuilder;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name = " + name
                + ", surname = " + surname
                + ", age = " + age
                + ", address = " + address
                + '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode();
    }

}