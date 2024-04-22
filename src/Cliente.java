import java.util.ArrayList;

public class Cliente extends Thread{
    private ArrayList<Loja> lojas = new ArrayList<>();
    private int index=0;
    private Conta conta;
    
    public void run() {
        while(!Thread.interrupted()) {
            if(this.conta.getSaldo()>0) {
                this.comprar();
            } else {
                this.interrupt();
            }
        }
    }
    
    public void comprar() {
        if(this.conta.getSaldo() >= 200) {
            this.conta.getBanco().transferencia(new Transacao(this.conta,this.lojas.get(this.index).getConta(),200));
            this.index = (this.index+1)%this.lojas.size();
        }
    }
    
    public void setLojas(ArrayList<Loja> lojas) {
        this.lojas = lojas;
    }
    
    public Cliente(Conta conta,ArrayList<Loja> lojas) {
        this.conta = conta;
        this.lojas = lojas;
    }
}
