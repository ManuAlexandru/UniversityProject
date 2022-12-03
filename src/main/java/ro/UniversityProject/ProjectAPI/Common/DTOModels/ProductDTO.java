package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import javax.persistence.*;

@Entity(name="Product")
@Table(name="Product")
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;
    @Column(name="start_price")
    private float StartPrice;
    @Column(name="actual_price")
    private float ActualPrice;
    @Column(name="description")
    private String Description;
    @Column(name="title")
    private String Title;
    @Column(name="photo_route")
    private String PhotoRoute;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserDTO user_DTO;

    public UserDTO getUser_dto() {
        return user_DTO;
    }

    public void setUser_dto(UserDTO user_DTO) {
        this.user_DTO = user_DTO;
    }
}
