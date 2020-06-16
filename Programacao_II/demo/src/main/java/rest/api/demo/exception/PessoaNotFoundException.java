package rest.api.demo.exception;

public class PessoaNotFoundException extends RuntimeException{
    public PessoaNotFoundException() {
        super("Pessoa não encontrada");
    }
}
