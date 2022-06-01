public class Lista {
    No lista_start;

    public Lista() {
        lista_start = null;
    }

    public boolean isEmpty() {
        return lista_start == null;
    }

    public int getSize() {
        int count = 0;
        No node = lista_start;
        while (node != null) {
            count++;
            node = node.next_node;
        }
        return count;
    }

    public void show() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia");
        } else {
            No aux = lista_start;
            StringBuilder message = new StringBuilder();
            while (aux.next_node != null) {
                message.append("{").append(aux.elemento).append("}").append("; ");
                aux = aux.next_node;
            }
            No ultimo = return_last();
            message.append("{").append(aux.elemento).append("}");
            System.out.println(message);
        }
    }

    public void add_last(int elemento) {
        No novo = new No(elemento);
        if (isEmpty()) {
            lista_start = novo;
        } else {
            No aux = lista_start;
            while (aux.next_node != null) {
                aux = aux.next_node;
            }
            aux.next_node = novo;
        }
    }

    public No remove_final() throws Exception {
        No removed;
        if (isEmpty()) {
            throw new Exception("Lista vazia");
        } else if (getSize() == 1) {
            removed = lista_start;
            lista_start = lista_start.next_node;
            return removed;
        } else {
            No aux = lista_start;
            removed = aux;
            while (removed.next_node != null) {
                aux = removed;
                removed = removed.next_node;
            }
            aux.next_node = null;
        }
        return removed;
    }

    public No return_last() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia");
        } else {
            No last = lista_start;
            while (last.next_node != null) {
                last = last.next_node;
            }
            return last;
        }
    }

    public No remove_start() throws Exception {
        No removed;
        if (isEmpty()) {
            throw new Exception("Lista vazia");
        } else {
            removed = lista_start;
            lista_start = lista_start.next_node;
            return removed;
        }
    }


}

