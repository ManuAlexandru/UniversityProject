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
    @Column(name = "start_date")
    private long createdDate;
    @Column(name = "end_date")
    private long endDate;
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

    public long getId() {
        return Id;
    }

    public float getStartPrice() {
        return StartPrice;
    }

    public void setStartPrice(float startPrice) {
        StartPrice = startPrice;
    }

    public float getActualPrice() {
        return ActualPrice;
    }

    public void setActualPrice(float actualPrice) {
        ActualPrice = actualPrice;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getPhotoRoute() {
        return PhotoRoute;
    }

    public void setPhotoRoute(String photoRoute) {
        PhotoRoute = photoRoute;
    }
}
