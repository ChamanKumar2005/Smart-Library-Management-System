package model;

public class Author {

    private String name;
    private String workplace;

    public Author() {
    }

    public Author(String name, String workplace) {
        this.name = name;
        this.workplace = workplace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Override
    public String toString() {
        return "Author{name='" + name + "', workplace='" + workplace + "'}";
    }
}
