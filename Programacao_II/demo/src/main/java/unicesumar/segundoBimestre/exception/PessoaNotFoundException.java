package unicesumar.segundoBimestre.exception;

public class PessoaNotFoundException extends RuntimeException{
    public PessoaNotFoundException() {
        super("Pessoa não encontrada");
    }
}
