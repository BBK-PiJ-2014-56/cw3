package cw3;

/**
 * Created by jimjohn_thornton on 24/01/15.
 */

public class LinkedList implements List{ //extends ArrayList

    private Node head;
    private int currentindex = 0;

    private static class Node
    {
        private Object data;
        private Node next;

        public Node(Object data, Node next)
        {
            this.data = data;
            this.next = next;
        }
        //public java.lang.Object getData(Node) {

        //}
    }

    public LinkedList() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        if (head == null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return currentindex;
    }

    @Override
    public ReturnObject get(int index) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (isEmpty() == true) {
            System.out.println("empty");
            rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
        } else if(index < 0 || index >= size()) {
            System.out.println("wrong index");
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
        if(isEmpty()) {
            rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
        } else if ((isEmpty() && index > 0) || index > size() || index < 0) {
            rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else if (index == 0 && size()>=1) {
            currentindex--;
            head = head.next;
            rtn.setObj(head.data);
        } else {
            currentindex--;
            //rtn.setObj(item);
            Node tmp = head;
            for (int i = 0; i < index-1; i++) {
                //iterate through list, index number of times return that object
                tmp = tmp.next;
            }
            tmp.next = tmp;
            rtn.setObj(tmp.data);
        }

        //if(cur == null) throw new RuntimeException("cannot delete");

        //delete cur node
        //prev.next = cur.next;
    return rtn;
    }

    @Override
    public ReturnObject add(int index, Object item) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (item == null) {
            rtn.setError(ErrorMessage.INVALID_ARGUMENT);
        } else {

            if ((isEmpty() == true && index > 0) || index > size() || index < 0) {
                rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else if (index == 0) {
                currentindex++;
                //Node tmp = head;
                //tmp.next = head;
                rtn.setObj(item);
                head = new Node(item, head);
            } else {
                currentindex++;
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

            currentindex++;
            if (isEmpty()==true) {
                head = new Node(item, head);

            } else {
                Node tmp = head;
                while(tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = new Node(item, null);

            }
        }
        return rtn;
    }
    public void viewArray() {
        for(int i =0; i< currentindex;i++){
            System.out.println(i + ":" );
        }
        System.out.println("");
    }
}

