package blu.books.inventoryservice.repositories;

import blu.books.inventoryservice.model.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface BookInfoRepository extends JpaRepository<BookInfo, Long> {
}
