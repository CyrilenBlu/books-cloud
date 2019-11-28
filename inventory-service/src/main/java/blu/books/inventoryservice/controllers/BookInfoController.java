package blu.books.inventoryservice.controllers;

import blu.books.inventoryservice.model.BookInfo;
import blu.books.inventoryservice.services.BookInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
@SuppressWarnings("unused")
public class BookInfoController {
    private final BookInfoService infoService;

    public BookInfoController(BookInfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    private List<BookInfo> getBooks() {
        return infoService.findAll();
    }

    @GetMapping("/book-info/{id}")
    private BookInfo getBookById(@PathVariable Long id) {
        return infoService.findBookById(id);
    }
}
