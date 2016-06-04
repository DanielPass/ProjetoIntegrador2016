package Model;

import Model.Entidades.Curso;

/**
 * Created by daniel on 4/6/2016.
 */
public class CursoModel extends Model<Curso> {
    @Override
    public boolean salvar(Curso curso) {
        return false;
    }

    @Override
    public boolean atualizar(Curso curso) {
        return false;
    }

    @Override
    public boolean editar(Curso curso) {
        return false;
    }

    @Override
    public boolean excluir(Curso curso) {
        return false;
    }
}
