package cw3;

/**
 * @author James Thornton
 */

public class LinkedList implements List{ //extends ArrayList

    private Node head;

    private static class Node
    {
        private Object data;
        private Node next;

        public Node(Object data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int i = 0;
        if (!isEmpty()) {
            i = 1;
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
                i++;
            }
        }
    return i;
    }

    @Override
    public ReturnObject get(int index) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (isEmpty()) {
            rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
        } else if(index < 0 || index >= size()) {
            rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            Node tmp = head;
            for (int i = 0; i<index; i++) {
                //iterate through list, index number of times return that object
                tmp = tmp.next;
            }
            rtn.setObj(tmp.data);
        }
    return rtn;

    }

    @Override
    public ReturnObject remove(int index) {

        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (isEmpty()) {
            rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
        } else if (index >= size() || index < 0) {
            rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            if (index == 0 && size() >= 1) {
                rtn.setObj(head.data);
                head = head.next;
            } else {
                Node prevtmp = head;
                for (int i = 0; i <= index - 2; i++) {
                    //iterate through list until you get to the object before the index and link it to the end of
                    prevtmp = prevtmp.next;
                }
                Node nexttmp = prevtmp.next;
                prevtmp.next = nexttmp.next;
                rtn.setObj(prevtmp.next);
            }
        }

    return rtn;
    }

    @Override
    public ReturnObject add(int index, Object item) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (item == null) {
            rtn.setError(ErrorMessage.INVALID_ARGUMENT);
        } else {
            if ((isEmpty() && index > 0) || index > size() || index < 0) {
                rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else if (index == 0) {
                rtn.setObj(item);
                head = new Node(item, head);
            } else {
                rtn.setObj(item);
                Node tmp = head;
                for (int i = 0; i < index-1; i++) {
                    //iterate through list, index number of times return that object
                    tmp = tmp.next;
                }
                tmp.next = new Node(item, tmp.next);
            }
        }
        return rtn;
    }

    @Override
    public ReturnObject add(Object item) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (item == null) {
            rtn.setError(ErrorMessage.INVALID_ARGUMENT);
        } else {
            rtn.setObj(item);
            if (isEmpty()) {
                head = new Node(item, head);
            } else {
                Node tmp = head;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = new Node(item, null);
            }
        }
        return rtn;
    }
}

