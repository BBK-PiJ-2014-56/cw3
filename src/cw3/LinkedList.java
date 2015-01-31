package cw3;

/**
 * Created by jimjohn_thornton on 24/01/15.
 */

public class LinkedList implements List{ //extends ArrayList

    private Node head;
    //private int currentindex = 0;

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
        //return head == null;
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
        //return currentindex;
    }

    @Override
    public ReturnObject get(int index) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (isEmpty()) {
            rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
        } else if(index < 0 || index >= size()) {
            //System.out.println("wrong index");
            rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            //System.out.println("get shit");
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
                //currentindex--;
                //System.out.println(head.data);
                //System.out.println(head.next);
                head = head.next;
                //System.out.println(head);
                //if (size() == 0) {
                //    rtn.setObj(null);
                //} //else {
                    //rtn.setObj(head.data);
                //}
            } else {
                //currentindex--;
                //rtn.setObj(item);
                Node prevtmp = head;
                //System.out.println(prevtmp.data);
                for (int i = 0; i <= index - 2; i++) {
                    //iterate through list, index number of times return that object
                    prevtmp = prevtmp.next;
                    //System.out.println(prevtmp.data);
                }

                //prevtmp.next = prevtmp;
                Node nexttmp = prevtmp.next;
                        prevtmp.next = nexttmp.next;
                /*if (prevtmp.next == null) {
                    //nexttmp = null;
                    System.out.println(size());
                    head = null;
                    rtn.setObj(null);
                } else {
                    nexttmp = prevtmp.next.next;
                    //prevtmp.next = prevtmp.next.next; //nexttmp;
                    //iterate through list, index number of times return that object
                    //prevtmp = prevtmp.next;

                    //prevtmp.next = prevtmp.next.next; //nexttmp;


                    //System.out.println(nexttmp.data);
                    //rtn.setObj(tmp.data);
                }*/
                rtn.setObj(head.data);
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
                //currentindex++;
                //Node tmp = head;
                //tmp.next = head;
                rtn.setObj(item);
                head = new Node(item, head);
            } else {
                //currentindex++;
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

            //currentindex++;
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

