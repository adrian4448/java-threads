package objects;

public class Filial {

    public Filial(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    private Integer codigo;
    private String nome;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
