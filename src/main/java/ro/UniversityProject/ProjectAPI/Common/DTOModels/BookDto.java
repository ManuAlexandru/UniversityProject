package ro.UniversityProject.ProjectAPI.Common.DTOModels;

import javax.persistence.*;

@Entity(name="Book")
@Table(name = "Book")
public class BookDto {
        @javax.persistence.Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private long Id;

        @Column(name="author")
        public String author;
        @Column(name="name")
        public String name;
        @Column(name="year")
        public String year;

}
