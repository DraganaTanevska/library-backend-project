package mk.ukim.finki.emt.lab2022.library.model;

import mk.ukim.finki.emt.lab2022.library.model.enumerations.Role;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private String username;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
    public User(){}

    public User(String username, String name, Role role) {
        this.username = username;
        this.name=name;
        this.role = role;
    }
}
