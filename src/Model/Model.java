package Model;

import Model.Entidades.Entidade;

/**
 * Created by daniel on 4/6/2016.
 */
public abstract class Model<T extends Entidade> {

    public abstract boolean salvar(T t);

    public abstract boolean atualizar(T t);

    public abstract boolean editar(T t);

    public abstract boolean excluir(T t);

}
