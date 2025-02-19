package org.example.model;

import org.example.model.nodes.NodeString;

public class LinkedListString {

    private NodeString first;

    public LinkedListString() {
        this.first = null;
    }

    public void add(String a) {
        if(this.first == null) {
            this.first = new NodeString(a, null);
            return;
        }

        NodeString candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new NodeString(a, null));
    }

    public void remove() {
        if(this.first == null) {
            throw new RuntimeException("No se puede eliminar de una lista vacía");
        }

        if(this.first.getNext() == null) {
            this.first = null;
            return;
        }

        NodeString backup = this.first;
        NodeString candidate = this.first.getNext();
        while(candidate.getNext() != null) {
            backup = candidate;
            candidate = candidate.getNext();
        }

        backup.setNext(null);
    }

    public int length() {
        if(this.first == null) {
            return 0;
        }

        int count = 1;
        NodeString candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
            count++;
        }

        return count;
    }

    public String get(int index) {
        if(index < 0) {
            throw new RuntimeException("El índice no puede ser negativo");
        }
        int size = length();
        if(index >= size) {
            throw new RuntimeException("El índice está fuera de rango");
        }

        if(index == 0) {
            return this.first.getValue();
        }

        int count = 1;
        NodeString candidate = this.first.getNext();
        while(candidate.getNext() != null) {
            if(count == index) {
                return candidate.getValue();
            }
            candidate = candidate.getNext();
            count++;
        }

        return "";
    }
}
