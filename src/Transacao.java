public class Transacao {
    private boolean pago=false;
    private Conta beneficiario;
    private Conta pagante;
    private float valor;
    
    public void efetuar() {
        if (!pago) {
            if((this.pagante.getSaldo()-this.valor) >= 0) {
                this.pagante.setSaldo(this.pagante.getSaldo()-this.valor);
                this.beneficiario.setSaldo(this.beneficiario.getSaldo()+this.valor);
                this.pago = true;
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("transação já efetuada!");
        }
    }
    
    public float getValor() {
        return this.valor;
    }
    
    public void mostrar() {
        System.out.println("Pagante: "+this.pagante.nome+" ; Beneficiario: "+this.beneficiario.nome+" ; valor: "+this.valor+" ; pago: "+pago);
    }
    
    public Transacao(Conta pagante, Conta beneficiario, float valor) {
        this.pagante = pagante;
        this.beneficiario = beneficiario;
        this.valor = valor;
        
        this.pagante.addAsPayer(this);
        this.beneficiario.addAsReceiver(this);
    }
}
