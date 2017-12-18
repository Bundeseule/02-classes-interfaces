package de.fhro.inf.prg3.a02;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList {

    //ATTRIBUTES

    private Element head;
    private int size;


    //CONSTRUCTOR
    //implements a SimpleListImpl, the head is null, so the list is empty
    public SimpleListImpl() {
        head = null;
    }

    /**
     * Add on object to the end of the list
     *
     * @param item item to add
     */
    public void add(Object item) {
        /*
        special case empty list
        if this case is true, add creates a new list by giving head a new ListElement
         */
        if (head == null) {
            head = new ListElement(item);
        } else {
            /*
            any other list strength
            current list element is head
            if there are next items in the list, this item is head until the head is at the end
             */
            ListElement current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new ListElement(item));
        }
        size++;
    }

    public SimpleList filter(SimpleFilter filter) {

    }


}
