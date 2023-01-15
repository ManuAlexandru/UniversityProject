package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import javax.persistence.*;

@Entity(name="ExpiredProduct")
@Table(name="ExpiredProduct")
public class ExpiredProductsDTO {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @Column(name="description")
    private String Description;
    @Column(name="title")
    private String Title;

    @Column(name="photo_route")
    private String PhotoRoute;
    @Column(name="user_id")
    private long user_id;


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
}
