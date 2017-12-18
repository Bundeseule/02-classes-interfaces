package de.fhro.inf.prg3.a02;


import org.w3c.dom.html.HTMLDListElement;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    //ATTRIBUTES

    private ListElement head;
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

    /**
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Get a new SimpeList instance with all items of this list which match the given filter
     *
     * @param filter SimpleFilter instance
     * @return new SimpleList instance
     */
    public SimpleList filter(SimpleFilter filter) {
        SimpleList result = new SimpleListImpl();
        for (Object o : this) {
            if (filter.include(o)) {
                result.add(o);
            }
        }
        return result;

    }

    /**
     * @inheritDoc
     */
    @Override
    public Iterator<Object> iterator() {
        return new SimpleIterator();
    }

    private class SimpleIterator implements Iterator<Object> {

        private ListElement current = head;

        /**
         * @inheritDoc
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * @inheritDoc
         */
        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }

    }

    /**
     * Helper class for the linked list
     * can be static because the ListElement does not need to access the SimpleList instance
     */
    private static Class ListElement

    {
        private Object item;
        private ListElement next;

        ListElement(Object item) {
        this.item = item;
        this.next = null;
    }

        /**
         * @return get object in the element
         */
        public Object getItem () {
        return item;
    }

        /**
         * @return successor of the ListElement - may be NULL
         */
        public ListElement getNext () {
        return next;
    }

        /**
         * Sets the successor of the ListElement
         * @param next ListElement
         */
        public void setNext () {
        this.next = next;
    }
    }


}
