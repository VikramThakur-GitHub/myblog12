package com.myblog.myblog11.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}), //@Column(unique = true) : works the same || makes the data unique in those rows.
        @UniqueConstraint(columnNames = {"email"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //fetch = FetchType.EAGER -- EAGER will load all the tables in hibernate cache memory whereas LAZY will load only the required tables at the moment.
    //cascade = CascadeType.ALL -- Changes done in parent class will happen in child class as well.
    @JoinTable(name = "user_roles", // "user_roles" is the third table used to join two tables here.
    joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

}




















