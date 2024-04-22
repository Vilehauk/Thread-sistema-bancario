import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class Loja {
    private Conta conta;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    
    public void pagarFuncionarios() {
        this.lock.lock();
        try {
            if (conta.getSaldo()>(this.funcionarios.size()*1400)) {
                for(int i=0;i<this.funcionarios.size();i++) {
                    this.conta.getBanco().transferencia(new Transacao(this.conta,this.funcionarios.get(i).getConta(),1400f));
                }
            }
        } catch(Exception e) {
            System.out.println("impossível de realizar pagamento devido a: "+e);
        } finally {
            this.lock.unlock();
        }
    }
    
    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }
    
    public Conta getConta() {
        return this.conta;
    }
    
    public Loja(Conta conta) {
        this.conta = conta;
    }
}
