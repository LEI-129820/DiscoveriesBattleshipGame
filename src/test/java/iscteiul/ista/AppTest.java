package iscteiul.ista;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Teste unitário simples da aplicação {@link App}, escrito em JUnit 3.
 * <p>
 * Por agora contém apenas um teste de arranque, que serve para confirmar que
 * a configuração dos testes do projeto (Maven e JUnit) está a funcionar.
 *
 * @author LEI-129851
 */
public class AppTest
        extends TestCase
{
    /**
     * Cria o caso de teste.
     *
     * @param testName nome do caso de teste
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * Devolve o conjunto de testes desta classe.
     *
     * @return a suite com todos os testes de {@link AppTest}
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Teste de arranque: verifica apenas que a infraestrutura de testes
     * executa corretamente (a asserção é sempre verdadeira).
     */
    public void testApp()
    {
        assertTrue( true );
    }
}