public class Estoque implements Runnable {
    private Integer estoque = 0;

    @Override
    public void run() {
        comprarItem();
    }
    // synchronized faz com que o metodo seja executado por somente uma thread, fazendo um lock e pegando o valor correto da variavel estoque
    public synchronized void comprarItem() {
        try {
            if (estoque > 0) {
                System.out.println("O Cliente: " + Thread.currentThread().getName() + " Comprou o item " + estoque);
                // sleep didatico
                Thread.sleep(250);
                estoque--;
            } else {
                System.out.println("Acabou o estoque para o cliente:" + Thread.currentThread().getName());
            }
        } catch(Exception e) {
            System.out.println("Ocorreu um erro na execucao da thread:" + Thread.currentThread().getName());
        }
    }

    public Estoque(Integer estoque) {
        this.estoque = estoque;
    }
}
