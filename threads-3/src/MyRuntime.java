public class MyRuntime implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                if (i == 3) {
                    // faz com que a thread durma 1s
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } catch(Exception e) {
            System.out.println("Ocorreu um erro na thread" + Thread.currentThread().getName());
        }
    }
}
