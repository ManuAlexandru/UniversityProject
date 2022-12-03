package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RolesDTO roles_DTO = (RolesDTO) o;
        return Objects.equals(Id, roles_DTO.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
