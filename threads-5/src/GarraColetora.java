public class GarraColetora implements Runnable {
    private Estrutura e;

    public GarraColetora(Estrutura e) {
        this.e = e;
    }

    @Override
    public void run() {
        try {
            while (true) {
                /*
                    Nesse contexto, o syncronized serve para lockar o objeto Estrutura, notificando as outras threads quando a estrutura
                    estiver vazia para colocar outro objeto, e aguardando o objeto ser colocado para retira-lo
                */
                synchronized (e) {
                    while (e.vazia) {
                        e.wait();
                    }
                    e.vazia = true;
                    System.out.println("Objeto retirado");
                    e.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na execucao da thread" + Thread.currentThread().getName());
        }
    }
}
