package Enums;

/**
 * Created by daniel on 4/6/2016.
 */
public enum Status {

    /**
     * Status do aluno
     * ATIVO -> alunos matriculados no semestre letivo
     * INATIVO -> alunos não matriculados no semestre letivo
     */
    ATIVO,
    INATIVO,

    /**
     * Status do processo
     */
    EM_ANDAMENTO,
    INTERROMPIDO,
    CONCLUIDO,

    /**
     * Status do contrato
     * APROVADO -> o coordenador do curso aprova ao aluno a realização do estágio
     * REPROVADO -> o coordenador do curso não aprova que o aluno realiza o estágio
     * ENTREGUE -> o contrato foi retirado do Núcleo de Estágio e entregue ao aluno
     */
    APROVADO,
    REPROVADO,
    ENTREGUE
}
