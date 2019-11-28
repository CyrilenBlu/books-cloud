package blu.books.inventoryservice.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "book_info")
public class BookInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double price;
    private String shelfNo;
    private String ean;
    private int pages;
    private int wordCount;
    private Date datePublished;
}
