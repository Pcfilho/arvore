import java.util.ArrayList;

public class ArvoreAVL<T> {
    TNode<T> root;

    public int getSize() {
        if (root == null)
            return 0;

        int size = 0;
        TNode<T> node;
        ArrayList<TNode<T>> v = new ArrayList<TNode<T>>();
        v.add(root);
        while (v.size() != 0) {
            node = v.remove(0);
            size++;
            if (node.getFilhoE() != null)
                v.add(node.getFilhoE());
            if (node.getFilhoD() != null)
                v.add(node.getFilhoD());
        }

        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int altura() {
        return altura(root);
    }

    public int altura(TNode<T> node) {
        return altura(node, 0);
    }

    private int altura(TNode<T> n, int a) {
        int altura = 0;
        if (n != null) {
            altura = a;
            altura = Math.max(altura, altura(n.getFilhoE(), a + 1));
            altura = Math.max(altura, altura(n.getFilhoD(), a + 1));
        }
        return altura;
    }

    public void addNode(T valor) {
        TNode<T> node = new TNode<T>(valor);
        if (root == null) {
            root = node;
        } else {
            addNode(node,root);
        }
    }

    private void addNode(TNode<T> node, TNode<T> pai) {
        if (compara(node.getValor(),pai.getValor()) > 0) {
            if (pai.getFilhoD() != null) {
                addNode(node,pai.getFilhoD());
            } else {
                node.setPai(pai);
                pai.setFilhoD(node);
                rebalanceamento(node);
            }
        } else if (compara(node.getValor(),pai.getValor()) < 0) {
            if (pai.getFilhoE() != null) {
                addNode(node,pai.getFilhoE());
            } else {
                node.setPai(pai);
                pai.setFilhoE(node);
                rebalanceamento(node);
            }
        }
    }

    public boolean removeNode(T valor) {
        TNode<T> node = root;

        while (node != null) {
            if (compara(valor,node.getValor()) < 0)
                node = node.getFilhoE();
            else if (compara(valor,node.getValor()) > 0)
                node = node.getFilhoD();
            else
                break;
        }

        if (node != null) {
            removeNode(node);
            return true;
        }

        return false;
    }

    private void removeNode(TNode<T> nodeRemove) {
        if (nodeRemove.getFilhoE() == null || nodeRemove.getFilhoD() == null) {
            removeFolha(nodeRemove);
        } else {
            TNode<T> node = nodeRemove.getFilhoD();
            while (node.getFilhoE() != null) {
                node = node.getFilhoE();
            }
            removeFolha(node);
            node.setPai(nodeRemove.getPai());
            node.setFilhoE(nodeRemove.getFilhoE());
            node.setFilhoD(nodeRemove.getFilhoD());
            if (node.getFilhoE() != null)
                node.getFilhoE().setPai(node);
            if (node.getFilhoD() != null)
                node.getFilhoD().setPai(node);
            if (nodeRemove != root) {
                if (nodeRemove.isFilhoE()) {
                    node.getPai().setFilhoE(node);
                } else {
                    node.getPai().setFilhoD(node);
                }
            } else {
                root = node;
            }
        }
    }

    private void removeFolha(TNode<T> node) {
        if (node.getFilhoE() == null && node.getFilhoD() == null) {
            if (node != root) {
                if (node.isFilhoE()) {
                    node.getPai().setFilhoE(null);
                } else {
                    node.getPai().setFilhoD(null);
                }
            } else {
                root = null;
            }
        } else if (node.getFilhoE() == null || node.getFilhoD() == null) {
            if (node.getFilhoE() == null) {
                if (node != root) {
                    node.getFilhoD().setPai(node.getPai());
                    if (node.isFilhoE()) {
                        node.getPai().setFilhoE(node.getFilhoD());
                    } else {
                        node.getPai().setFilhoD(node.getFilhoD());
                    }
                } else {
                    node.getFilhoD().setPai(null);
                    root = node.getFilhoD();
                }
            } else {
                if (node != root) {
                    node.getFilhoE().setPai(node.getPai());
                    if (node.isFilhoE()) {
                        node.getPai().setFilhoE(node.getFilhoE());
                    } else {
                        node.getPai().setFilhoD(node.getFilhoE());
                    }
                } else {
                    node.getFilhoE().setPai(null);
                    root = node.getFilhoE();
                }
            }
        }

        rebalanceamento(node.getPai());
    }

    private void rebalanceamento(TNode<T> node) {
        if (node != null) {
            if (Math.abs(fatorBalanceamento(node)) > 1)
                rotaciona(node);

            rebalanceamento(node.getPai());
        }
    }

    private int fatorBalanceamento(TNode<T> node) {
        if (node != null) {
            int altE = 0;
            int altD = 0;
            if (node.getFilhoE() != null) {
                altE = altura(node.getFilhoE()) + 1;
            }
            if (node.getFilhoD() != null) {
                altD = altura(node.getFilhoD()) + 1;
            }
            return altD - altE;
        }
        return 0;
    }

    private TNode<T> getMaiorFB(TNode<T> node) {
        if (Math.abs(fatorBalanceamento(node.getFilhoE())) >
                Math.abs(fatorBalanceamento(node.getFilhoD())))
            return node.getFilhoE();

        return node.getFilhoD();
    }

    private void rotaciona(TNode<T> node) {
        TNode<T> filho = getMaiorFB(node);
        if (fatorBalanceamento(node) > 0) {
            if (fatorBalanceamento(filho) < 0)
                rotacaoDireita(filho);
            rotacaoEsquerda(node);
        } else if (fatorBalanceamento(node) < 0) {
            if (fatorBalanceamento(filho) > 0)
                rotacaoEsquerda(filho);
            rotacaoDireita(node);
        }
    }

    private void rotacaoEsquerda(TNode<T> node) {
        TNode<T> filhoD = node.getFilhoD();
        if (node != root) {
            filhoD.setPai(node.getPai());
            if (node.isFilhoE()) {
                node.getPai().setFilhoE(filhoD);
            } else {
                node.getPai().setFilhoD(filhoD);
            }
            node.setFilhoD(filhoD.getFilhoE());
            if (filhoD.getFilhoE() != null)
                filhoD.getFilhoE().setPai(node);
            node.setPai(filhoD);
            filhoD.setFilhoE(node);
        } else {
            root = filhoD;
            filhoD.setPai(null);
            node.setFilhoD(filhoD.getFilhoE());
            if (filhoD.getFilhoE() != null)
                filhoD.getFilhoE().setPai(node);
            node.setPai(filhoD);
            filhoD.setFilhoE(node);
        }
    }

    private void rotacaoDireita(TNode<T> node) {
        TNode<T> filhoE = node.getFilhoE();
        if (node != root) {
            filhoE.setPai(node.getPai());
            if (node.isFilhoE()) {
                node.getPai().setFilhoE(filhoE);
            } else {
                node.getPai().setFilhoD(filhoE);
            }
            node.setFilhoE(filhoE.getFilhoD());
            if (filhoE.getFilhoD() != null)
                filhoE.getFilhoD().setPai(node);
            node.setPai(filhoE);
            filhoE.setFilhoD(node);
        } else {
            root = filhoE;
            filhoE.setPai(null);
            node.setFilhoE(filhoE.getFilhoD());
            if (filhoE.getFilhoD() != null)
                filhoE.getFilhoD().setPai(node);
            node.setPai(filhoE);
            filhoE.setFilhoD(node);
        }
    }

    public int compara(Object x, Object y) {
        if (x instanceof Number) {
            double a = ((Number)x).doubleValue();
            double b = ((Number)y).doubleValue();
            if (a > b)
                return 1;
            else if (a < b)
                return -1;
            else
                return 0;
        } else {
            String a = x.toString();
            String b = y.toString();
            return a.compareTo(b);
        }
    }
}