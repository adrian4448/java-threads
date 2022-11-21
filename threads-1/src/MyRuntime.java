public class MyRuntime implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } catch(Exception e) {
            System.out.println("Ocorreu um erro ao rodar a thread");
        }
    }
}
