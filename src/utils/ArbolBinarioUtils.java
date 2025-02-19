package utils;

import implementation.ArbolBinario;
import implementation.Nodo;

public class ArbolBinarioUtils {

    public static Nodo interseccion(Nodo a1, Nodo a2) {
        if (a1 == null || a2 == null) {
            return null;
        }
        if (a1.valor == a2.valor) {
            Nodo nuevo = new Nodo(a1.valor);
            nuevo.izq = interseccion(a1.izq, a2.izq);
            nuevo.der = interseccion(a1.der, a2.der);
            return nuevo;
        } else {
            return null;
        }
    }

    public static ArbolBinario interseccionar(ArbolBinario arbol1, ArbolBinario arbol2) {
        ArbolBinario resultado = new ArbolBinario();
        Nodo raizInterseccion = interseccion(arbol1.getRaiz(), arbol2.getRaiz());
        setRaiz(resultado, raizInterseccion);
        return resultado;
    }

    private static void setRaiz(ArbolBinario arbol, Nodo nuevaRaiz) {
        try {
            java.lang.reflect.Field field = ArbolBinario.class.getDeclaredField("raiz");
            field.setAccessible(true);
            field.set(arbol, nuevaRaiz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
