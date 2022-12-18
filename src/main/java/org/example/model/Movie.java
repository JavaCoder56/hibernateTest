package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_production")
    private int year_of_production;
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    public Movie() {
    }

    public Movie(String name, int year_of_production, Director director) {
        this.name = name;
        this.year_of_production = year_of_production;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(int year_of_production) {
        this.year_of_production = year_of_production;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ", year_of_production=" + year_of_production +
                '}';
    }
}
