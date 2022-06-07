public class TNode<T> {
    private T valor;
    private TNode<T> pai;
    private TNode<T> filhoE;
    private TNode<T> filhoD;

    public TNode(T valor) {
        this(valor,null,null,null);
    }

    public TNode(T valor, TNode<T> pai) {
        this(valor,pai,null,null);
    }

    public TNode(T valor, TNode<T> pai, TNode<T> filhoE, TNode<T> filhoD) {
        this.valor = valor;
        this.pai = pai;
        this.filhoE = filhoE;
        this.filhoD = filhoD;
    }

    public T getValor() {
        return valor;
    }

    public TNode<T> getPai() {
        return pai;
    }

    public TNode<T> getFilhoE() {
        return filhoE;
    }

    public TNode<T> getFilhoD() {
        return filhoD;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setPai(TNode<T> pai) {
        this.pai = pai;
    }

    public void setFilhoE(TNode<T> filhoE) {
        this.filhoE = filhoE;
    }

    public void setFilhoD(TNode<T> filhoD) {
        this.filhoD = filhoD;
    }

    public boolean isFilhoE() {
        return (this.getPai().getFilhoE() == this);
    }
}