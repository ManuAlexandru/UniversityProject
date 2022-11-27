package ro.UniversityProject.ProjectAPI.Models.DTOModels;

import javax.persistence.*;

@Entity(name="User_Roles")
public class UserRoles_dto {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
private long Id;
    @Column(name="user_id")
private long UserId;
    @Column(name="role_id")
private long RoleId;

}
