public class Main {
    public static void main(String[] args) {
        var estrutura = new Estrutura();
        var garraColocadora = new Thread(new GarraColocadora(estrutura));
        var garraColetora = new Thread(new GarraColetora(estrutura));

        garraColocadora.start();
        garraColetora.start();
    }
}