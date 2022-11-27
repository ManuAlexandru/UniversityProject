package ro.UniversityProject.ProjectAPI.Models.DTOModels;

import javax.persistence.*;

@Entity(name="Roles")
public class Roles_dto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;
    @Column(name="name")
  private String Name;
}
