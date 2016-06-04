package Model;

import Model.Entidades.Aluno;

/**
 * Created by daniel on 4/6/2016.
 */
public class AlunoModel extends Model<Aluno> {
    @Override
    public boolean salvar(Aluno aluno) {
        return false;
    }

    @Override
    public boolean atualizar(Aluno aluno) {
        return false;
    }

    @Override
    public boolean editar(Aluno aluno) {
        return false;
    }

    @Override
    public boolean excluir(Aluno aluno) {
        return false;
    }
}
