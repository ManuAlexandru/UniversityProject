package ro.UniversityProject.ProjectAPI.Models.DTOModels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Product_dto> comments = new ArrayList<>();

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
