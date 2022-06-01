public class No {
    int elemento;
    No next_node;
    No filho_esquerda;
    No filho_direita;

    public No(int elemento) {
        this.elemento = elemento;
        this.filho_esquerda = null;
        this.filho_direita = null;
        this.next_node = null;
    }
}