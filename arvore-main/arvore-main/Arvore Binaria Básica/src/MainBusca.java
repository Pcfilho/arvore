public class MainBusca {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvoreBinariaBusca = new ArvoreBinariaBusca();

        arvoreBinariaBusca.adicionar(10);
        arvoreBinariaBusca.adicionar(11);
        arvoreBinariaBusca.adicionar(9);
        arvoreBinariaBusca.adicionar(8);
        arvoreBinariaBusca.adicionar(3);
        arvoreBinariaBusca.adicionar(30);
        arvoreBinariaBusca.adicionar(50);


        TreePrinter.show(arvoreBinariaBusca.raiz);
    }
}
