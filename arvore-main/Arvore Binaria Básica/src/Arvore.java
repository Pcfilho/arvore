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

    public No buscar_pai(int e) throws Exception {
        if (arvore_vazia()) {
            return null;
        } else {
            Pilha pilha = new Pilha();
            pilha.add_last(raiz_arvore);
            while (!pilha.isEmpty()) {
                No auxiliar = pilha.remove_final();
                int elemento_direita;
                int elemento_esquerda;

                if (auxiliar.filho_direita == null) {
                    elemento_direita = -1;
                } else {
                    elemento_direita = auxiliar.filho_direita.elemento;
                }

                if (auxiliar.filho_esquerda == null) {
                    elemento_esquerda = -1;
                } else {
                    elemento_esquerda = auxiliar.filho_esquerda.elemento;
                }

                if (elemento_direita == e || elemento_esquerda == e) {
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

    public No remover_elemento(int e) throws Exception {
        No removido;
        if (!arvore_vazia()) {
            removido = buscar(e);
            if (removido != null) {
                No esquerda = removido.filho_esquerda;
                No direita = removido.filho_direita;
                No pai = buscar_pai(e);
                if (esquerda == null && direita == null) {
                    if (pai.filho_esquerda == removido) {
                        pai.filho_esquerda = null;
                    }
                    else {
                        pai.filho_direita = null;
                    }
                }
                else if (esquerda != null && direita != null){
                    if (pai.filho_esquerda == removido){
                        pai.filho_esquerda = esquerda;
                        while (esquerda.filho_esquerda != null) {
                            esquerda = esquerda.filho_esquerda;
                        }
                        esquerda.filho_esquerda = direita;
                    }
                    else {
                        pai.filho_direita = direita;
                        while (direita.filho_direita != null){
                            direita = direita.filho_direita;
                        }
                        direita.filho_direita = esquerda;
                    }
                }
                else {
                    if (pai.filho_esquerda == removido) {
                        if (esquerda == null) {
                            pai.filho_esquerda = direita;
                        } else {
                            pai.filho_esquerda = esquerda;
                        }
                    } else {
                        if (direita == null) {
                            pai.filho_direita = esquerda;
                        } else {
                            pai.filho_direita = direita;
                        }
                    }
                }
            }
        }
        else {
            throw new Exception("Estrutura vazia!");
        }
        return removido;
    }

    public Lista varredura_largura() throws Exception {
        Lista lista = new Lista();
        if (arvore_vazia()) {
            return null;
        }
        else {
            Pilha fila = new Pilha();
            fila.add_last(raiz_arvore);
            while (!fila.isEmpty()){
                No aux = fila.remove_start();
                lista.add_last(aux.elemento);
                if (aux.filho_esquerda != null) {
                    fila.add_last(aux.filho_esquerda);
                }
                if (aux.filho_direita != null) {
                    fila.add_last(aux.filho_direita);
                }
            }
        }
        return lista;
    }

}
