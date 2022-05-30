import java.io.OutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();
        arvore.adicionar_direita(1, 9999999);
        arvore.adicionar_direita(2, 1);
        arvore.adicionar_esquerda(3, 1);
        arvore.adicionar_direita(4, 2);
        arvore.adicionar_esquerda(5, 2);
        arvore.adicionar_direita(6, 3);
        arvore.adicionar_esquerda(7, 3);
        arvore.adicionar_direita(8, 4);
        arvore.adicionar_esquerda(9, 4);
        arvore.adicionar_direita(10, 5);
        arvore.adicionar_esquerda(10, 5);
        TreePrinter.show(arvore.raiz_arvore);
    }
}

//      1
//  2       3
//4
//
