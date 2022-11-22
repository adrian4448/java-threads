public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Estoque estoque = new Estoque(6);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(estoque);
            threads[i].setName("Cliente " + i);

            threads[i].start();
        }
    }
}