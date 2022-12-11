package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name="Role")
@Table(name="Role")
public class RolesDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;
    @Column(name="name")
  private String Name;

    @ManyToMany(mappedBy = "roles_dtoes")
    private Set<UserDTO> user_dtoes = new LinkedHashSet<>();

    public Set<UserDTO> getUser_dtoes() {
        return user_dtoes;
    }

    public void setUser_dtoes(Set<UserDTO> user_dtoes) {
        this.user_dtoes = user_dtoes;
    }


}
