public class ArvoreBinariaBusca {
    No raiz;

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    public void adicionar(int valor) {
        if (raiz == null) {
            raiz = new No(valor);
        }
        else {
            adicionar(valor, raiz);
        }
    }

    private void adicionar(int valor, No raiz) {
        if (valor < raiz.elemento) {
            if (raiz.filho_esquerda == null) {
                raiz.filho_esquerda = new No(valor);
            }
            else {
                adicionar(valor, raiz.filho_esquerda);
            }
        }
        else if (valor > raiz.elemento) {
            if (raiz.filho_direita == null) {
                raiz.filho_direita = new No(valor);
            }
            else {
                adicionar(valor, raiz.filho_direita);
            }
        }
    }

    public boolean pesquisar(int valor) {
        if (raiz == null) {
            return false;
        }
        else {
            return pesquisar(valor, raiz);
        }
    }

    private boolean pesquisar(int valor, No raiz) {
        if (valor == raiz.elemento) {
            return true;
        }
        else if (valor < raiz.elemento) {
            if (raiz.filho_esquerda == null) {
                return false;
            }
            else {
                return pesquisar(valor, raiz.filho_esquerda);
            }
        }
        else if (valor > raiz.elemento) {
            if (raiz.filho_direita == null) {
                return false;
            }
            else {
                return pesquisar(valor, raiz.filho_direita);
            }
        }

        return false;
    }

    public void remover(int valor) {
        if (raiz != null) {
            remover(valor, raiz, null);
        }
    }

    private void remover(int valor, No raiz, No pai) {
        if (valor == raiz.elemento) {
            if (raiz.filho_esquerda == null && raiz.filho_direita == null) {      // Nó não tem filhos
                if (raiz == pai.filho_esquerda)    // Nó é filho esquerdo?
                    pai.filho_esquerda = null;
                else
                    pai.filho_direita = null;
            }
            else if (raiz.filho_esquerda != null && raiz.filho_direita == null) { // Nó tem um filho (esquerdo)
                if (raiz == pai.filho_esquerda)    // Nó é filho esquerdo?
                    pai.filho_esquerda = raiz.filho_esquerda;
                else
                    pai.filho_direita = raiz.filho_esquerda;
            }
            else if (raiz.filho_esquerda == null && raiz.filho_direita != null) { // Nó tem um filho (direito)
                if (raiz == pai.filho_esquerda)    // Nó é filho esquerdo?
                    pai.filho_esquerda = raiz.filho_direita;
                else
                    pai.filho_direita = raiz.filho_direita;
            }
            else if (raiz.filho_esquerda != null && raiz.filho_direita != null) { // Nó tem dois filhos
                raiz.elemento = menorValor(raiz.filho_direita);
                remover(raiz.elemento, raiz.filho_direita, raiz);
            }
        }
        else if (valor < raiz.elemento) {
            if (raiz.filho_esquerda != null)
                remover(valor, raiz.filho_esquerda, raiz);
        }
        else if (valor > raiz.elemento) {
            if (raiz.filho_direita != null)
                remover(valor, raiz.filho_direita, raiz);
        }
    }

    private int menorValor(No raiz) {
        if (raiz.filho_esquerda == null)
            return raiz.elemento;
        else
            return menorValor(raiz.filho_esquerda);
    }

    public void exibirPreOrdem() {
        if (raiz != null) {
            exibirPreOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirPreOrdem(No raiz) {
        System.out.print(raiz.elemento + " ");

        if (raiz.filho_esquerda != null) {
            exibirPreOrdem(raiz.filho_esquerda);
        }

        if (raiz.filho_direita != null) {
            exibirPreOrdem(raiz.filho_direita);
        }
    }

    public void exibirEmOrdem() {
        if (raiz != null) {
            exibirEmOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirEmOrdem(No raiz) {
        if (raiz.filho_esquerda != null) {
            exibirEmOrdem(raiz.filho_esquerda);
        }

        System.out.print(raiz.elemento + " ");

        if (raiz.filho_direita != null) {
            exibirEmOrdem(raiz.filho_direita);
        }
    }

    public void exibirPosOrdem() {
        if (raiz != null) {
            exibirPosOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirPosOrdem(No raiz) {
        if (raiz.filho_esquerda != null) {
            exibirPosOrdem(raiz.filho_esquerda);
        }

        if (raiz.filho_direita != null) {
            exibirPosOrdem(raiz.filho_direita);
        }

        System.out.print(raiz.elemento + " ");
    }
}