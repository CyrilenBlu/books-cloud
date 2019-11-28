DELETE FROM book_info;

INSERT INTO book_info(id, title, description, price, shelf_no, ean, pages, word_count, date_published) VALUES
(1, 'Book1', 'bookdesc',200.00, '12a', 'ean1', 10, 420, TO_DATE('19/09/1999', 'DD/MM/YYYY')),
(2, 'Book2', 'bookdesc',505.00, '12a', 'ean2', 45, 2024, TO_DATE('25/11/1999', 'DD/MM/YYYY')),
(3, 'Book3', 'bookdesc',65.50, '1a', 'ean3', 15, 590, TO_DATE('14/02/1642', 'DD/MM/YYYY')),
(4, 'Book4', 'bookdesc',1000.50, '1b', 'ean4', 100, 10021, TO_DATE('15/12/2024', 'DD/MM/YYYY')),
(5, 'Book5', 'bookdesc',899.99, '1b', 'ean5', 80, 6592, TO_DATE('30/11/2015', 'DD/MM/YYYY'));