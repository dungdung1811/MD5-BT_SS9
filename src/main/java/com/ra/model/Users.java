package com.ra.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String userName;
    private String email;
    private String password;
    private Boolean status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name= "role_id"))
    private Set<Role> roles;


}
