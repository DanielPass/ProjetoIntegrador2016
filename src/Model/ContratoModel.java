package Model;

import Model.Entidades.Contrato;

/**
 * Created by daniel on 4/6/2016.
 */
public class ContratoModel extends Model<Contrato> {
    @Override
    public boolean salvar(Contrato contrato) {
        return false;
    }

    @Override
    public boolean atualizar(Contrato contrato) {
        return false;
    }

    @Override
    public boolean editar(Contrato contrato) {
        return false;
    }

    @Override
    public boolean excluir(Contrato contrato) {
        return false;
    }
}
