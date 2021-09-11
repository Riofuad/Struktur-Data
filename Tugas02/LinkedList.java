package com.tutorial;

public interface LinkedList {
    public void insertHead(int value);

    public void insertMiddle(int value, int position);

    public void insertEnd(int value);

    public void insertEndTest(int value);

    public void deleteHead();

    public void deleteMiddle(int position);

    public void deleteEnd();

    public void printNode();

    public void search(int key);
}
