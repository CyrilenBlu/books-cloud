package blu.books.recordservice.controllers;

import blu.books.recordservice.model.Book;
import blu.books.recordservice.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1")
@SuppressWarnings("unused")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    private List<Book> getBooks(@RequestParam(name = "shelfNo", required = false) String shelfNo) {
        if (shelfNo != null)
            return service.findAllByShelfNo(shelfNo);
        return service.findAll();
    }

    @GetMapping("/book")
    private Map<String, String> getBookInfo(@RequestParam(name = "id", required = true) Long id) {
        return service.findBookInfo(id);
    }
}
