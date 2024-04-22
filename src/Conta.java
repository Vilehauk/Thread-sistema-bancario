import java.util.ArrayList;

public class Conta {
    public String nome;
    private float saldo;
    private Banco banco;
    private ArrayList<Transacao> asPayer = new ArrayList<>();
    private ArrayList<Transacao> asReceiver = new ArrayList<>();
    
    public Conta(String nome,float saldo, Banco banco) {
        this.nome = nome;
        this.saldo = saldo;
        this.banco = banco;
        
        this.banco.addConta(this);
    }
    
    public void addAsReceiver(Transacao transacao) {
        this.asReceiver.add(transacao);
    }
    
    public ArrayList<Transacao> getAsReceiver() {
        return this.asReceiver;
    }
    
    public void addAsPayer(Transacao transacao) {
        this.asPayer.add(transacao);
    }
    
    public ArrayList<Transacao> getAsPayer() {
        return this.asPayer;
    }
    
    
    public float getSaldo() {
        return saldo;
    }
    
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public Banco getBanco() {
        return banco;
    }
}
