package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import javax.persistence.*;

@Entity(name="WordCounter")
@Table(name = "WordCounter")
public class WordCounterDto {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @Column(name="word")
    public String insertedWord;

}
