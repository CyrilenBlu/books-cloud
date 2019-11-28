package blu.books.recordservice.services;

import blu.books.recordservice.exceptions.BooksNotFoundException;
import blu.books.recordservice.model.Book;
import blu.books.recordservice.model.BookInfoResponse;
import blu.books.recordservice.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final RestTemplate restTemplate;

    public BookService(BookRepository bookRepository, RestTemplate restTemplate) {
        this.bookRepository = bookRepository;
        this.restTemplate = restTemplate;
    }

    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        if (books.size() <= 0) {
            log.error("[findAllBooks] -> No Books Found");
            throw new BooksNotFoundException("No books were found.");
        }
        return books;
    }

    public List<Book> findAllByShelfNo(String shelfNo) {
        List<Book> books = bookRepository.findAllByShelfNo(shelfNo);
        if (books.size() <= 0) {
            log.error("[findAllBooksByShelfNo] -> No Books Found");
            throw new BooksNotFoundException("No books were found for this shelf.");
        }
        return books;
    }

    public Map<String, String> findBookInfo(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            log.error("[findBookInfo] -> No Book Found");
            throw new BooksNotFoundException("Book not found");
        }

        Book book = bookOptional.get();

        ResponseEntity<BookInfoResponse> bookInfoResponseEntity =
                restTemplate.getForEntity("http://inventory-service/v1/book-info/{id}",
                    BookInfoResponse.class,
                    id);
        BookInfoResponse bookBody = bookInfoResponseEntity.getBody();
        if (bookBody == null){
            log.error("[findBookInfo] -> Book Not Found, id: {}" , id);
            throw new BooksNotFoundException("Book could not be found");
        }

        Map<String, String> bookMap = new HashMap<>();
        bookMap.put("id", bookOptional.get().getId().toString());
        bookMap.put("title", bookOptional.get().getTitle());
        bookMap.put("ean", bookOptional.get().getEan());
        bookMap.put("shelfNo", bookOptional.get().getShelfNo());
        bookMap.put("price", String.valueOf(bookBody.getPrice()));
        bookMap.put("description", bookBody.getDescription());
        bookMap.put("pages", String.valueOf(bookBody.getPages()));
        bookMap.put("wordCount", String.valueOf(bookBody.getWordCount()));
        return bookMap;
    }
}
