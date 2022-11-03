package shop.kokodo.sellerservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.kokodo.sellerservice.dto.response.Failure;

import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(FileUploadFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Failure FileUploadFailedException(FileUploadFailedException e) {
        log.info("[FileUploadFailedException] 파일 업로드 오류",e);
        return new Failure("파일 업로드 오류");
    }

    @ExceptionHandler(EmptyFileException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Failure EmptyFileException(EmptyFileException e) {
        log.info("[EmptyFileException] File Empty",e);
        return new Failure("File Empty");
    }

}
