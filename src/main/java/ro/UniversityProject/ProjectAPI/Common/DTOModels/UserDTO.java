package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name="People")
@Table(name = "People")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;
    @Column(name="first_name")
    public String FirstName;
    @Column(name="last_name")
    public String LastName;
    @Column(name="email")
    public String Email;
    @Column(name="password")
    public String Password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RolesDTO> roles_dtoes = new LinkedHashSet<>();

    public Set<RolesDTO> getRoles_dtoes() {
        return roles_dtoes;
    }

    public void setRoles_dtoes(Set<RolesDTO> roles_dtoes) {
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
