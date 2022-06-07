
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

//        arvore.varredura_largura().show();
//        arvore.varredura_profundidade_vlr().show();
//        arvore.varredura_profundidade_lvr().show();
//        arvore.varredura_profundidade_lrv().show();
        arvore.exibirEmOrdem();
        arvore.exibirPosOrdem();
    }
}
