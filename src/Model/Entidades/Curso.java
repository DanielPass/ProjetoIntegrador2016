package Model.Entidades;

/**
 * Created by daniel on 4/6/2016.
 */
public class Curso extends Entidade {
    private int     quantidadePeriodos;
    private String  nomeCoordenador;

    public int getQuantidadePeriodos() {
        return quantidadePeriodos;
    }

    public void setQuantidadePeriodos(int quantidadePeriodos) {
        this.quantidadePeriodos = quantidadePeriodos;
    }

    public String getNomeCoordenador() {
        return nomeCoordenador;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nomeCoordenador = nomeCoordenador;
    }
}
