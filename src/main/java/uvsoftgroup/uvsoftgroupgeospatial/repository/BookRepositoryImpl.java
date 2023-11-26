package uvsoftgroup.uvsoftgroupgeospatial.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import uvsoftgroup.uvsoftgroupgeospatial.dto.BookDto;
import uvsoftgroup.uvsoftgroupgeospatial.model.Author;
import uvsoftgroup.uvsoftgroupgeospatial.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;
@Service
public class BookRepositoryImpl{

    @PersistenceContext
    private EntityManager em;

    public Page<BookDto> findAll(Integer page, Integer size) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<BookDto> query = builder.createQuery(BookDto.class);
        Root<Book> root = query.from(Book.class);
        Join<Book, Author> join = root.join("authorRe", JoinType.LEFT);
        query.multiselect(
                root.get("id"),
                root.get("author"),
                join.get("id"),
                join.get("name")
        );
        TypedQuery<BookDto> query1 = em.createQuery(query);
        query1.setFirstResult(page * size);
        query1.setMaxResults(size);
        List<BookDto> list = query1.getResultList();
        return new PageImpl<>(list, PageRequest.of(page, size), list.size());
    }


}
