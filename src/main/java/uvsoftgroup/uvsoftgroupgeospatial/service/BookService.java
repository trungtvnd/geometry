package uvsoftgroup.uvsoftgroupgeospatial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uvsoftgroup.uvsoftgroupgeospatial.dto.BookRequest;
import uvsoftgroup.uvsoftgroupgeospatial.model.Book;
import uvsoftgroup.uvsoftgroupgeospatial.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public void save(BookRequest request) {
        Book book = Book.builder()
                .id(request.getId())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();
        repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
}
