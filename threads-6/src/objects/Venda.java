package objects;

import java.util.Date;

public class Venda {

    public Venda(Integer codigo, Filial filial, Date dataVenda, Produto produto, Integer quantidade, Double valorVenda) {
        this.codigo = codigo;
        this.filial = filial;
        this.dataVenda = dataVenda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
    }

    private Integer codigo;
    private Filial filial;
    private Date dataVenda;
    private Produto produto;
    private Integer quantidade;
    private Double valorVenda;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
