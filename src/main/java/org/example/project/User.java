package org.example.project;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    private int user_id;

    @Column(nullable = false, unique = true)  // username darf nicht null sein und muss einzigartig sein
    private String username;

    @Column(nullable = false) // password nicht null sein
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Termin> termine;  // Ein Benutzer kann mehrere Termine haben

    // Getter und Setter
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }
}
