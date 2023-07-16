package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springBootLesson.entity.Company;

@Repository
public interface CompanyRepository  extends JpaRepository<Company,Long> {
}
