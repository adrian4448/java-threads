public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRuntime(), "Thread 1");
        Thread thread2 = new Thread(new MyRuntime(), "\tThread 2");

        thread1.start();
        thread2.start();

        try {
            // este metodod join() faz com que uma thread (nesse caso a thread Main), aguarde a execucao de outras threads (thread1 e thread2)
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar as threads");
        }


        System.out.println("Fim da execucao");
    }
}