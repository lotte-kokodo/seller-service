package shop.kokodo.sellerservice.exception;

public class EmptyFileException extends RuntimeException{

    public EmptyFileException(){}

    public EmptyFileException(String msg){
        super(msg);
    }
}
