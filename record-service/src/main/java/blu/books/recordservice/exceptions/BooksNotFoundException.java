package blu.books.recordservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BooksNotFoundException extends RuntimeException {
    public BooksNotFoundException() {
    }

    public BooksNotFoundException(String s) {
        super(s);
    }

    public BooksNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BooksNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public BooksNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
