package org.example;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
                throw new IllegalArgumentException ("Возраст не может быть отрицательным");
            } else {
                this.age = age;
            }
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не заданы обязательные атрибуты: имя или фамилия");
        } else {
            if (this.age == -1) {
                Person pers = new Person(name, surname);
                pers.setAddress (this.address);
                return pers;
            } else {
                Person pers = new Person(name, surname, age);
                pers.setAddress (this.address);
                return pers;
            }
        }
    }
}
