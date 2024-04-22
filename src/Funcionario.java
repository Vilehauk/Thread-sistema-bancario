public class Funcionario extends Thread{
    private int index=0;
    private Conta conta;
    private Conta investimentos;
    private Loja loja;
    
    public void investir(float investimento) {
        this.conta.getBanco().transferencia(new Transacao(this.conta,this.investimentos,0.2f*investimento));
    }
    
    public Conta getConta() {
        return this.conta;
    }
    
    public void run() {
        while(!Thread.interrupted()) {
            this.loja.pagarFuncionarios();
            if(this.index < (this.conta.getAsReceiver().size())) {
                this.investir(this.conta.getAsReceiver().get(this.index).getValor());
                this.index++;
            }
        }
    }
    
    public Funcionario(Conta conta, Conta investimentos, Loja loja) {
        this.conta = conta;
        this.investimentos = investimentos;
        this.loja = loja;
        
        this.loja.addFuncionario(this);
    }
}
