package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import javax.persistence.*;

@Entity(name="BoughtProduct")
@Table(name="BoughtProduct")
public class BoughtProductsDTO {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @Column(name="bought_price")
    private float BoughtPrice;
    @Column(name="description")
    private String Description;
    @Column(name="title")
    private String Title;
    @Column(name="photo_route")
    private String PhotoRoute;
    @Column(name="user_id")
    private long user_id;
    @Column(name="buyer")
    private long buyer_id;

    public long getId() {
        return Id;
    }

    public float getBoughtPrice() {
        return BoughtPrice;
    }

    public void setBoughtPrice(float boughtPrice) {
        BoughtPrice = boughtPrice;
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

    public String getPhotoRoute() {
        return PhotoRoute;
    }

    public void setPhotoRoute(String photoRoute) {
        PhotoRoute = photoRoute;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(long buyer_id) {
        this.buyer_id = buyer_id;
    }
}
