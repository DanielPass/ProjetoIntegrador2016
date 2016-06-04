package Model;

import Model.Entidades.Empresa;

/**
 * Created by daniel on 4/6/2016.
 */
public class AgenteModel extends Model<Empresa> {
    @Override
    public boolean salvar(Empresa empresa) {
        return false;
    }

    @Override
    public boolean atualizar(Empresa empresa) {
        return false;
    }

    @Override
    public boolean editar(Empresa empresa) {
        return false;
    }

    @Override
    public boolean excluir(Empresa empresa) {
        return false;
    }
}
