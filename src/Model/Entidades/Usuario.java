package Model.Entidades;

import Enums.Tipos;

/**
 * Created by daniel on 4/6/2016.
 */
public class Usuario extends Entidade{
    private String      senha;
    private String      nomeUsuario;
    private Tipos       tipoUsuario;
    private String      email;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Tipos getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Tipos tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
