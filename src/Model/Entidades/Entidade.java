package Model.Entidades;

/**
 * Created by daniel on 4/6/2016.
 */
public abstract class Entidade {

    private long    id;
    private String  nome;
    private boolean isDeletado;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDeletado() {
        return isDeletado;
    }

    public void setDeletado(boolean deletado) {
        isDeletado = deletado;
    }

    @Override
    public String toString() {
        return nome;
    }
}
