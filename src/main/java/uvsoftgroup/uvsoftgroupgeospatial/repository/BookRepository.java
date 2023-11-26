package uvsoftgroup.uvsoftgroupgeospatial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uvsoftgroup.uvsoftgroupgeospatial.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
}
