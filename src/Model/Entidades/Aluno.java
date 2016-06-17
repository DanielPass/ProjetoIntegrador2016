package Model.Entidades;

import Enums.Status;

import java.util.List;

/**
 * Created by daniel on 4/6/2016.
 */
public class Aluno extends Entidade{

    private String          matricula;
    private Curso           curso;
    private int             periodo;
    private String          email;
    private Status          status;
    private List<Contrato>  contratos;
    private List<Relatorio> relatorios;
    private String          telefone;
    private boolean         portadorDeficiencia;

    public boolean isPortadorDeficiencia() {
        return portadorDeficiencia;
    }

    public void setPortadorDeficiencia(boolean portadorDeficiencia) {
        this.portadorDeficiencia = portadorDeficiencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Relatorio> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
}
