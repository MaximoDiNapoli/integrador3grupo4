public class Main {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol1 = new ArbolBinarioBusqueda();
        arbol1.insertar(5);
        arbol1.insertar(3);
        arbol1.insertar(7);

        ArbolBinarioBusqueda arbol2 = new ArbolBinarioBusqueda();
        arbol2.insertar(4);
        arbol2.insertar(2);
        arbol2.insertar(8);

        ArbolBinarioBusqueda arbolCombinado = ArbolBinarioBusqueda.combinarArboles(arbol1, arbol2);

        System.out.println("Árbol combinado (inorden): ");
        arbolCombinado.inorden(arbolCombinado.raiz);
    }
}
