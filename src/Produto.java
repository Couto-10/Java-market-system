public class Produto {


    private String nome;
    private int codigo;
    private String categoria;
    private double preco;
    private int quantidade;

    public Produto(String nome,int codigo, String categoria, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }
    public String getNome(){
        return nome;
    }
    public String getCategoria(){
        return categoria;
    }
    public int getCodigo(){
        return codigo;
    }
    public double getPreco(){
        return preco;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
}
