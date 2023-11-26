package uvsoftgroup.uvsoftgroupgeospatial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uvsoftgroup.uvsoftgroupgeospatial.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
}
