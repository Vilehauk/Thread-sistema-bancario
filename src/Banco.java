import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco{
    private ArrayList<Conta> contas = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    
    public void addConta(Conta conta) {
        this.contas.add(conta);
    }
    
    public void infoContas() {
        for(int i=0;i<this.contas.size();i++) {
            Conta cont = this.contas.get(i);
            System.out.println("nome: "+cont.nome+" ; valor: "+cont.getSaldo());
        }
    }
    
    public void dinheiroTotal() {
        float total = 0;
        for(int i=0;i<this.contas.size();i++) {
            total = total + this.contas.get(i).getSaldo();
        }
        System.out.println("dinheiro total: "+total);
    }
    
    public void transferencia(Transacao transacao) {
        this.lock.lock();
        try {
            transacao.efetuar();
            transacao.mostrar();
        } catch(Exception e) {
            System.out.println("Impossível de realizar transferência, devido a: "+e);
        } finally {
            this.lock.unlock();
        }
    }
    
    public Banco() {
    }
}
