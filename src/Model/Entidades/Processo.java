package Model.Entidades;

import Enums.Status;

/**
 * Created by daniel on 4/6/2016.
 */
public class Processo extends Entidade {
    private Contrato    contrato;
    private String      protocolo;
    private Status      status;

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
