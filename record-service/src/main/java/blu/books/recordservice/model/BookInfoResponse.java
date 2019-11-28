package blu.books.recordservice.model;

import lombok.Data;

import java.sql.Date;

@Data
public class BookInfoResponse {
    private String title;
    private String description;
    private double price;
    private String shelfNo;
    private String ean;
    private int pages;
    private int wordCount;
    private Date datePublished;
}
