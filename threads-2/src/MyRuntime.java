public class MyRuntime implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                if (i == 3) {
                    // Faz com que a thread durma 1 segundo
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } catch(Exception e) {
            System.out.println("Ocorreu um erro ao rodar a thread");
        }
    }
}
