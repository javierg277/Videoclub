package org.example.model;

public class Cinta {
    private int id;
    private String name;
    private String director;

    public Cinta(int id, String name, String director) {
        this.id = id;
        this.name = name;
        this.director = director;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Cinta{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
