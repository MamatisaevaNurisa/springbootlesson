package peaksoft.springBootLesson.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "company_name")
    private String companyName;
    @Column(name= "located_country")
    private String locatedCountry;
    @Column(name= "director_name")
    private String directorName;

@CreatedDate
    private LocalDate localDate;

}
