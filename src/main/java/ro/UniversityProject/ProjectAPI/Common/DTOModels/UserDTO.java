package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import javax.persistence.*;

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

    @Column(name="Role")
    public String role="User";

    public long getId() {
        return Id;
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
