package iscteiul.ista;

import iscteiul.ista.battleship.Fleet;
import iscteiul.ista.battleship.Tasks;

/**
 * Classe principal da aplicação Battleship.
 * Serve como ponto de entrada principal para a execução da aplicação e demonstração das tarefas.
 * 
 * @author britoeabreu
 * @author adrianolopes
 * @author miguelgoulao
 */
public class App
{
    /**
     * Método principal que inicia a execução da aplicação.
     * Imprime uma mensagem de boas-vindas e executa as tarefas configuradas.
     *
     * @param args Argumentos da linha de comandos fornecidos durante a execução do programa.
     */
    public static void main( String[] args )
    {

        System.out.printf("\n***  Battleship Game ***\n");

        // Tasks.taskA();
        Tasks.taskB();
        //	Tasks.taskC();
        //	Tasks.taskD();
    }
}


