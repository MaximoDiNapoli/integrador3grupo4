package implementation;

public class ArbolBinario {

    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(int valor) {
        this.raiz = insertarRecursivo(this.raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izq = insertarRecursivo(actual.izq, valor);
        } else {
            actual.der = insertarRecursivo(actual.der, valor);
        }
        return actual;
    }

    public void inOrder() {
        inOrderRec(this.raiz);
        System.out.println();
    }

    private void inOrderRec(Nodo nodo) {
        if (nodo != null) {
            inOrderRec(nodo.izq);
            System.out.print(nodo.valor + " ");
            inOrderRec(nodo.der);
        }
    }
}
