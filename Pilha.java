package aulaas;

public class Pilha<T> {
	private Node<T> topo;

    private static class Node<T> {
        T dado;
        Node<T> proximo;

        Node(T dado) {
            this.dado = dado;
        }
    }

    public void push(T dado) {
        Node<T> novoNo = new Node<>(dado);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }

        T dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }

    public boolean isEmpty() {
        return topo == null;
    }

}
