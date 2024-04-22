public class Caller extends Thread{
    private Conta test1;
    private Conta test2;
    
    public Caller(Conta test1, Conta test2) {
        this.test1 = test1;
        this.test2 = test2;
    }
    
    public void run() {
        this.test1.getBanco().transferencia(new Transacao(this.test1,this.test2,this.test1.getSaldo()));
        this.test1.getBanco().infoContas();
        this.test1.getBanco().dinheiroTotal();
    }
}
