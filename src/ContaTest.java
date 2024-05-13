import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ContaTest {

    @Test
    void testSacar() {
        Cliente cliente = new Cliente("Fulano");
        ContaCorrente cc = new ContaCorrente(cliente);
        cc.depositar(100);
        cc.sacar(50);
        assertEquals(50, cc.saldo, 0.001);
    }

    @Test
    void testDepositar() {
        Cliente cliente = new Cliente("Fulano");
        ContaPoupanca cp = new ContaPoupanca(cliente);
        cp.depositar(100);
        assertEquals(100, cp.saldo, 0.001);
    }

    @Test
    void testTransferir() {
        Cliente cliente1 = new Cliente("Fulano");
        Cliente cliente2 = new Cliente("Ciclano");
        ContaCorrente cc1 = new ContaCorrente(cliente1);
        ContaPoupanca cp2 = new ContaPoupanca(cliente2);

        cc1.depositar(100);
        System.out.println("Saldo inicial CC Fulano: " + cc1.saldo);
        System.out.println("Saldo inicial CP Ciclano: " + cp2.saldo);

        cc1.transferir(50, cp2);

        System.out.println("Saldo após transferência CC Fulano: " + cc1.saldo);
        System.out.println("Saldo após transferência CP Ciclano: " + cp2.saldo);

        assertEquals(50, cc1.saldo, 0.001);
        assertEquals(50, cp2.saldo, 0.001);
    }

    @Test
    void testImprimirExtratoContaCorrente() {
        Cliente cliente1 = new Cliente("Fulano");
        Cliente cliente2 = new Cliente("Ciclano");

        ContaCorrente cc1 = new ContaCorrente(cliente1);
        cc1.depositar(100);
        cc1.imprimirExtrato();

        ContaCorrente cc2 = new ContaCorrente(cliente2);
        cc2.depositar(100);
        cc2.imprimirExtrato();
    }

    @Test
    void testImprimirExtratoContaPoupanca() {
        Cliente cliente1 = new Cliente("Fulano");
        Cliente cliente2 = new Cliente("Ciclano");

        ContaPoupanca cp1 = new ContaPoupanca(cliente1);
        cp1.depositar(100);
        cp1.imprimirExtrato();

        ContaPoupanca cp2 = new ContaPoupanca(cliente2);
        cp2.depositar(100);
        cp2.imprimirExtrato();
    }

    public static void main(String[] args) {
        ContaTest contaTest = new ContaTest();
        contaTest.testSacar();
        contaTest.testDepositar();
        contaTest.testTransferir();
        contaTest.testImprimirExtratoContaCorrente();
        contaTest.testImprimirExtratoContaPoupanca();
    }
}