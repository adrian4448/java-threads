import objects.Filial;
import objects.Produto;
import objects.Venda;

import java.util.List;

public class AtualizaProduto implements Runnable {

    public AtualizaProduto(Filial filial, List<Venda> vendas, List<Produto> produtos) {
        this.filial = filial;
        this.vendas = vendas;
        this.produtos = produtos;
    }

    private Filial filial;
    private List<Venda> vendas;
    private List<Produto> produtos;

    @Override
    public void run() {
        validarVendas();
    }

    private synchronized void validarVendas() {
        System.out.println("Rodando a Thread " + Thread.currentThread().getName());
        vendas.forEach(venda -> {
            try {
                if (filial.getCodigo() == venda.getFilial().getCodigo()) {
                    var produto = produtos.get(produtos.indexOf(venda.getProduto()));
                    synchronized (produtos) {
                        removerEstoque(produto);
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao processar a Thread");
            }
        });
    }

    private void removerEstoque(Produto produto) {
        if (produto.getQuantidadeEstoque() != produto.getQuantidadeMinima()) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1);
            System.out.println("Produto: " + produto.getNome() + " Agora tem em estoque: " + produto.getQuantidadeEstoque());
        } else {
            System.out.println("Nao e possivel remover estoque do produto: " + produto.getNome());
        }
    }
}
