package ro.UniversityProject.ProjectAPI.Models.DTOModels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Users")
@Table(name = "user")
public class User_dto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;
    @Column(name="first_name")
    private String FirstName;
    @Column(name="last_name")
    private String LastName;
    @Column(name="email")
    private String Email;
    @Column(name="password")
    private String Password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles_dto> roles_dtoes = new LinkedHashSet<>();

    public Set<Roles_dto> getRoles_dtoes() {
        return roles_dtoes;
    }

    public void setRoles_dtoes(Set<Roles_dto> roles_dtoes) {
        this.roles_dtoes = roles_dtoes;
    }

    @Override
    public String toString() {
        return "User_dto{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
