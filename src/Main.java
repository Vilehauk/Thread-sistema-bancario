import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Loja> lojas = new ArrayList<>();
        Banco banco = new Banco();
        Caller caller = new Caller(new Conta("test1",10,banco),new Conta("test2",0,banco));
        
        lojas.add(new Loja(new Conta("Loja1",0,banco)));
        lojas.add(new Loja(new Conta("Loja2",0,banco)));
        
        Funcionario func1 = new Funcionario(new Conta("func1",0,banco),new Conta("func1 inves",0,banco),lojas.get(0));
        Funcionario func2 = new Funcionario(new Conta("func2",0,banco),new Conta("func2 inves",0,banco),lojas.get(0));
        Funcionario func3 = new Funcionario(new Conta("func3",0,banco),new Conta("func3 inves",0,banco),lojas.get(1));
        Funcionario func4 = new Funcionario(new Conta("func4",0,banco),new Conta("func4 inves",0,banco),lojas.get(1));
        
        Cliente clie1 = new Cliente(new Conta("cliente1",1000,banco),lojas);
        Cliente clie2 = new Cliente(new Conta("cliente2",1000,banco),lojas);
        Cliente clie3 = new Cliente(new Conta("cliente3",1000,banco),lojas);
        Cliente clie4 = new Cliente(new Conta("cliente4",1000,banco),lojas);
        Cliente clie5 = new Cliente(new Conta("cliente5",1000,banco),lojas);
        
        
        System.out.println("informações do banco:");
        banco.infoContas();
        banco.dinheiroTotal();
        
        System.out.println("inicio da simulação e informações das transações:");
        func1.start();
        func2.start();
        func3.start();
        func4.start();
        clie1.start();
        clie2.start();
        clie3.start();
        clie4.start();
        clie5.start();
        caller.start();
        
        
        boolean alldead = false;
        while(!alldead) {
            alldead = (clie1.interrupted());
            alldead = alldead && (clie2.interrupted());
            alldead = alldead && (clie3.interrupted());
            alldead = alldead && (clie4.interrupted());
            alldead = alldead && (clie5.interrupted());
        }
        
        System.out.println("todos os clientes sem dinheiro, resultado da simulação:");
        banco.infoContas();
        banco.dinheiroTotal();
    }
}
