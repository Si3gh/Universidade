package unicesumar.segundoBimestre.exception;

public class PessoaInvalidException extends RuntimeException{
    public PessoaInvalidException(String invalidField) {
        super("Campo vazio, ou preenchido incorretamente:" + invalidField);
    }
}
