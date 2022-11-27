package ro.UniversityProject.ProjectAPI.Models.DTOModels;

import javax.persistence.*;
import java.util.Date;
@Entity(name="Sold_Products")
public class SoldProduct_dto {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;
    private long UserId;
    private Date SoldDate;
    private long ProductId;
}
