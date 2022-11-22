public class GarraColocadora implements Runnable {
    private Estrutura e;

    public GarraColocadora(Estrutura e) {
        this.e  = e;
    }

    @Override
    public void run() {
        try {
            while (true) {
                /*
                    Nesse contexto, o syncronized serve para lockar o objeto Estrutura, notificando as outras threads quando a estrutura
                    estiver com um objeto para ser retirado, e aguardando o objeto ser retirado para colocar outro novamente
                */
                synchronized (e) {
                    while (!e.vazia) {
                        e.wait();
                    }
                    e.vazia = false;
                    System.out.println("Objeto colocado");
                    e.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na execucao da thread" + Thread.currentThread().getName());
        }
    }
}
