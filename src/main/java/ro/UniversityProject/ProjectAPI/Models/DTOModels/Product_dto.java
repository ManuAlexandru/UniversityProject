package ro.UniversityProject.ProjectAPI.Models.DTOModels;

import javax.persistence.*;

@Entity(name="Products")
@Table(name="product")
public class Product_dto {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;
    @Column(name="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User_dto user_dto;
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

    public Product_dto() {
    }
}
