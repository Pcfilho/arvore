public class Arvore {
    No raiz_arvore;

    public Arvore() {
        raiz_arvore = null;
    }

    public boolean arvore_vazia() {
        if (raiz_arvore == null) {
            return true;
        } else {
            return false;
        }
    }



    public No buscar(int e) throws Exception {
        if (arvore_vazia()) {
            return null;
        } else {
            Pilha pilha = new Pilha();
            pilha.add_last(raiz_arvore);
            while (!pilha.isEmpty()) {
                No auxiliar = pilha.remove_final();
                if (auxiliar.elemento == e) {
                    return auxiliar;
                }
                if (auxiliar.filho_direita != null) {
                    pilha.add_last(auxiliar.filho_direita);
                }
                if (auxiliar.filho_esquerda != null) {
                    pilha.add_last(auxiliar.filho_esquerda);
                }
            }
        }
        return null;
    }

    public void adicionar_esquerda(int e, int p) throws Exception {
        No novo = new No(e);
        if (!arvore_vazia()) {
            No pai = buscar(p);
            if (pai != null) {
                if (pai.filho_esquerda == null) {
                    pai.filho_esquerda = novo;
                } else {
                    throw new Exception("Nó já possui filho!");
                }
            } else {
                throw new Exception("Elemento inexistente!");
            }
        } else {
            raiz_arvore = novo;
        }
    }

    public void adicionar_direita(int e, int p) throws Exception {
        No novo = new No(e);
        if (!arvore_vazia()) {
            No pai = buscar(p);
            if (pai != null) {
                if (pai.filho_direita == null) {
                    pai.filho_direita = novo;
                } else {
                    throw new Exception("Nó já possui filho!");
                }
            } else {
                throw new Exception("Elemento inexistente!");
            }
        } else {
            raiz_arvore = novo;
        }
    }

}
