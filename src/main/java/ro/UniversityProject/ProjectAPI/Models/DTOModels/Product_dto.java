package ro.UniversityProject.ProjectAPI.Models.DTOModels;

import javax.persistence.*;

@Entity(name="Products")
@Table(name="product")
public class Product_dto {
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
    private User_dto user_dto;

    public User_dto getUser_dto() {
        return user_dto;
    }

    public void setUser_dto(User_dto user_dto) {
        this.user_dto = user_dto;
    }
}
