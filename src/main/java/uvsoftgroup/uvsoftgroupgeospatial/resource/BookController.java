package uvsoftgroup.uvsoftgroupgeospatial.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uvsoftgroup.uvsoftgroupgeospatial.dto.BookDto;
import uvsoftgroup.uvsoftgroupgeospatial.model.Book;
import uvsoftgroup.uvsoftgroupgeospatial.dto.BookRequest;
import uvsoftgroup.uvsoftgroupgeospatial.repository.BookRepositoryImpl;
import uvsoftgroup.uvsoftgroupgeospatial.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;
    private final BookRepositoryImpl  bookRepository;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody BookRequest request
    ) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<Page<BookDto>> findAllBooks(@RequestParam("page") Integer page,
                                                      @RequestParam("size") Integer size) {
        return ResponseEntity.ok(bookRepository.findAll(page, size));
    }


}
