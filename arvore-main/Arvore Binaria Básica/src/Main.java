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

        TreePrinter.show(arvore.raiz_arvore);

        System.out.println(arvore.buscar_pai(2).elemento);
        System.out.println(arvore.buscar_pai(4).elemento);
        System.out.println(arvore.buscar_pai(5).elemento);
        arvore.remover_elemento(4);
        System.out.println(arvore.buscar_pai(5).elemento);

        TreePrinter.show(arvore.raiz_arvore);

        arvore.remover_elemento(5);

        TreePrinter.show(arvore.raiz_arvore);

        arvore.remover_elemento(1);

        TreePrinter.show(arvore.raiz_arvore);

    }
}

//      1
//  2       3
//4
//
