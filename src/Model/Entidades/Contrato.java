package Model.Entidades;

import Enums.Status;
import Enums.Tipos;

import java.util.Date;

/**
 * Created by daniel on 4/6/2016.
 */
public class Contrato extends Entidade{
    private Aluno   aluno;
    private Empresa empresa;
    private Empresa agenteIntegracao;
    private String  codigo;
    private int     cargaHoraria;
    private double  remuneracao;
    private Status  status;
    private Status  faseDoEstagio;
    private Tipos   tipo;
    private Date    dataInicial;
    private Date    dataFinal;
    private Date    dataEnvioAvaliacao;
    private Date    dataEntregaParaAluno;

    public Status getFaseDoEstagio() {
        return faseDoEstagio;
    }

    public void setFaseDoEstagio(Status faseDoEstagio) {
        this.faseDoEstagio = faseDoEstagio;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getAgenteIntegracao() {
        return agenteIntegracao;
    }

    public void setAgenteIntegracao(Empresa agenteIntegracao) {
        this.agenteIntegracao = agenteIntegracao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataEnvioAvaliacao() {
        return dataEnvioAvaliacao;
    }

    public void setDataEnvioAvaliacao(Date dataEnvioAvaliacao) {
        this.dataEnvioAvaliacao = dataEnvioAvaliacao;
    }

    public Date getDataEntregaParaAluno() {
        return dataEntregaParaAluno;
    }

    public void setDataEntregaParaAluno(Date dataEntregaParaAluno) {
        this.dataEntregaParaAluno = dataEntregaParaAluno;
    }
}

