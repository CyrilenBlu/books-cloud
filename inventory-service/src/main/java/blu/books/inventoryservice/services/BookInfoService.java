package blu.books.inventoryservice.services;

import blu.books.inventoryservice.model.BookInfo;
import blu.books.inventoryservice.repositories.BookInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Table(name = "book_info")
public class BookInfoService {
    private final BookInfoRepository infoRepository;

    public BookInfoService(BookInfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public List<BookInfo> findAll() {
        return infoRepository.findAll();
    }

    public BookInfo findBookById(Long id) {
        Optional<BookInfo> bookInfoOptional = infoRepository.findById(id);
        if (!bookInfoOptional.isPresent())
            throw new RuntimeException("Error");

        return bookInfoOptional.get();
    }
}
