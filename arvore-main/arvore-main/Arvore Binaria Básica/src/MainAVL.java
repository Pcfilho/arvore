public class MainAVL {
    public static void main(String[] args) {
        ArvoreAVL<Integer> arvoreAVL = new ArvoreAVL<Integer>();

        arvoreAVL.addNode(10);
        arvoreAVL.addNode(20);
        arvoreAVL.addNode(30);
        arvoreAVL.addNode(40);
        arvoreAVL.addNode(50);
        arvoreAVL.addNode(60);

        AVLTreePrinter.show(arvoreAVL.root);
    }
}
