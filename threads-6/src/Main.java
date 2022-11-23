import objects.Filial;
import objects.Produto;
import objects.Venda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Filial> filialList = new ArrayList<>();
        List<Produto> produtoList = new ArrayList<>();
        List<Venda> vendaList = new ArrayList<>();

        createFakeDatabase(filialList, produtoList, vendaList);

        // listar estoques
        for (int i = 0; i < 10; i++) {
            System.out.println("\t Produto: " + produtoList.get(i).getNome() + " Possui em estoque: " + produtoList.get(i).getQuantidadeEstoque());
            System.out.println("\t Produto: " + produtoList.get(i).getNome() + " Possui em estoque MINIMO de: " + produtoList.get(i).getQuantidadeMinima());
        }

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AtualizaProduto(filialList.get(i), vendaList, produtoList), "Thread " + i);
            threads[i].start();
        }
    }

    private static void createFakeDatabase(List<Filial> filialList, List<Produto> produtoList, List<Venda> vendaList) {
        for (int i = 0; i < 10; i++) {
            var filial = new Filial(i, "Filial " + i);
            filialList.add(filial);

            var produtoEstoque = new Random().nextInt(50);
            var produto = new Produto(i, "Produto " + i, produtoEstoque, new Random().nextInt(produtoEstoque + 1));
            produtoList.add(produto);
        }

        for (int i = 0; i < 200; i++) {
            var venda = new Venda(i,
                    filialList.get(new Random().nextInt(10)),
                    new Date(),
                    produtoList.get(new Random().nextInt(10)),
                    1,
                    new Random().nextDouble(100));

            vendaList.add(venda);
        }
    }
}