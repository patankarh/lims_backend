package com.himanshupatankar.dbproject.models;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="scientists")
public class Scientist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;
    private Date date_of_birth;
    private String  role;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFirstName() { return first_name; }
    public void setFirstName(String firstName) { this.first_name = firstName; }
    public String getLastName() { return last_name; }
    public void setLastName(String lastName) { this.last_name = lastName; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Date getDateOfBirth() { return date_of_birth; }
    public void setDateOfBirth(Date dateOfBirth) { this.date_of_birth = dateOfBirth; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Scientist(String first_name, String last_name, String username, String password, String email, Date dateOfBirth, String role) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.date_of_birth = dateOfBirth;
        this.role = role;
    }

    public Scientist() {

    }


}
