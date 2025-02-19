package org.example.model.nodes;

public class NodeString {

    private String value;
    private NodeString next;

    public NodeString(String value, NodeString next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NodeString getNext() {
        return next;
    }

    public void setNext(NodeString next) {
        this.next = next;
    }
}
