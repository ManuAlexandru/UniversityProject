package ro.UniversityProject.ProjectAPI.Models.DTOModels;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name="Roles")
public class Roles_dto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;
    @Column(name="name")
  private String Name;

    @ManyToMany(mappedBy = "roles_dtoes")
    private Set<User_dto> user_dtoes = new LinkedHashSet<>();

    public Set<User_dto> getUser_dtoes() {
        return user_dtoes;
    }

    public void setUser_dtoes(Set<User_dto> user_dtoes) {
        this.user_dtoes = user_dtoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Roles_dto roles_dto = (Roles_dto) o;
        return Objects.equals(Id, roles_dto.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
