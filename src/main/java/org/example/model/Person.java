package org.example.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Person")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;

    @OneToMany(mappedBy = "person")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Item> items;

    @OneToOne(mappedBy = "person")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Passport passport;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setPerson(this);
    }

    public void addItem(Item item) {
        if (this.items==null) {
            this.setItems(new ArrayList<>());
        }
        items.add(item);
        item.setPerson(this);
    }
}
