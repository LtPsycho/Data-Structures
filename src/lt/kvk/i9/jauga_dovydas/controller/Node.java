package lt.kvk.i9.jauga_dovydas.controller;

import lt.kvk.i9.jauga_dovydas.model.User;

class Node {
    protected int id;
    protected User user;
    protected Node next, prev;

    public Node() {
        next = null;
        prev = null;
        user = null;
    }

    public Node(int i, User d, Node n, Node p) {
        id = i;
        user = d;
        next = n;
        prev = p;
    }

    public Node getLinkNext() {
        return next;
    }

    public void setLinkNext(Node n) {
        next = n;
    }

    public Node getLinkPrev() {
        return prev;
    }

    public void setLinkPrev(Node p) {
        prev = p;
    }

    public User getObject() {
        return user;
    }

    public void setObject(User d) {
        user = d;
    }

    public String getUserName() {
        return user.getName();
    }

    public long getUserNumber() {
        return user.getNumber();
    }

    public float getUserPercent() {
        return user.getPercent();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}