package lt.kvk.i9.jauga_dovydas.controller;

import lt.kvk.i9.jauga_dovydas.model.User;


/**
 * Created by Dovydas on 11/5/2016.
 */
public class LinkedList {
    public static int uniqueID = 1;
    public int size;
    protected Node start;
    protected Node end;

    /* Constructor */
    public LinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /* Ideti i pradžią */
    public void insertAtStart(User user) {
        Node nextPointer = new Node(uniqueID, user, null, null);
        if (start == null) {
            nextPointer.setLinkNext(nextPointer);
            nextPointer.setLinkPrev(nextPointer);
            start = nextPointer;
            end = start;
        } else {
            nextPointer.setLinkPrev(end);
            end.setLinkNext(nextPointer);
            start.setLinkPrev(nextPointer);
            nextPointer.setLinkNext(start);
            start = nextPointer;
        }
        size++;
        uniqueID += 1;
    }

    //Ideti į poziciją
    public void insertAtPos(User user, int pos) {
        Node nextPointer = new Node(uniqueID, user, null, null);
        if (pos == 1) {
            insertAtStart(user);
            return;
        }
        Node pointer = start;
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node tmp = pointer.getLinkNext();
                pointer.setLinkNext(nextPointer);
                nextPointer.setLinkPrev(pointer);
                nextPointer.setLinkNext(tmp);
                tmp.setLinkPrev(nextPointer);
            }
            pointer = pointer.getLinkNext();
        }
        size++;
        uniqueID += 1;
    }

    public void deleteAtPosition(int position) {
        if (position == 1) // Jei pozicija lygi pirmam irašui
        {
            if (size == 1) {
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(end);
            end.setLinkNext(start);
            size--;
            return;
        }
        if (position == size) //Jei pazicija lygi paskutiniam yrašui
        {
            end = end.getLinkPrev();
            end.setLinkNext(start);
            start.setLinkPrev(end);
            size--;
        }
        Node pointer = start.getLinkNext();
        for (int i = 2; i <= size; i++) {
            if (i == position) {
                Node p = pointer.getLinkPrev();
                Node n = pointer.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size--;
                return;
            }
            pointer = pointer.getLinkNext();
        }
    }

    //Vaizdavimas
    public void display() {
        System.out.print(size + " elementų dvipusis ciklinis sarašas = \n");
        Node pointer = start;
        if (size == 0) {
            System.out.print("tuščias\n");
            return;
        }
        if (start.getLinkNext() == start) {
            System.out.println(start.getObject().getName() + ", " + start.getObject().getNumber() + ", " + start.getObject().getPercent());
            System.out.println(pointer.getObject().getName() + ", " + pointer.getObject().getNumber() + ", " + pointer.getObject().getPercent());
            return;
        }
        System.out.println(start.getObject().getName() + ", " + start.getObject().getNumber() + ", " + start.getObject().getPercent());
        pointer = start.getLinkNext();
        while (pointer.getLinkNext() != start) {
            System.out.println(pointer.getObject().getName() + ", " + pointer.getObject().getNumber() + ", " + pointer.getObject().getPercent());
            pointer = pointer.getLinkNext();
        }
        System.out.println(pointer.getObject().getName() + ", " + pointer.getObject().getNumber() + ", " + pointer.getObject().getPercent());
        //pointer = pointer.getLinkNext();
        //System.out.println(pointer.getObject().getName()+", "+pointer.getObject().getNumber()+", "+pointer.getObject().getPercent());
    }

    public String findAndReturnUser(String name) {
        if (start != null) {
            Node pointer = start;
            while (pointer.getLinkNext() != start) {
                if (name.equals(pointer.getUserName())) {
                    return pointer.getUserName();
                }
                pointer = pointer.getLinkNext();
            }
            if (name.equals(pointer.getUserName())) {
                return pointer.getUserName();
            }
        }
        return null;

    }

    public Node getNode(int position) {
        Node pointer = start.getLinkNext();
        for (int i = 1; i <= size; i++) {
            if (i == position) {
                Node n = pointer;
                return n;
            }
            pointer = pointer.getLinkNext();
        }
        return null;
    }

    public void sortListByNumber() {
        Node pointer = start;
        Node temp = new Node();
        boolean foundChange = true;
        int last = getSize() - 1;
        while (foundChange) {
            foundChange = false;
            for (int i = 0; i < last; i++) {
                if (pointer.getUserNumber() > pointer.getLinkNext().getUserNumber()) {
                    temp.setObject(pointer.getObject());
                    pointer.setObject(pointer.getLinkNext().getObject());
                    pointer.getLinkNext().setObject(temp.getObject());
                    foundChange = true;
                }
                pointer = pointer.getLinkNext();
                --last;
            }
        }
    }
}
