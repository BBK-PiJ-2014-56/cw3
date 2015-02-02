package cw3;

/**
 *
 * @author James Thornton
 */

public class ArrayList implements List{
    private Object[] AL;
    public ArrayList() {
        AL = new Object[0];
    }

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of items currently in the list.
     *
     * @return the number of items currently in the list
     */
    public int size() {
        return AL.length;
    }

    /**
     * Returns the elements at the given position.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObject get(int index) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (isEmpty()) {
            rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
        } else if(index < 0 || index >= size()) {
            rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            rtn.setObj(AL[index]);
        }
        return rtn;
    }

    /**
     * Returns the elements at the given position and removes it
     * from the list. The indeces of elements after the removed
     * element must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObject remove(int index) {
        ReturnObjectImpl rtn = (ReturnObjectImpl) get(index);
        if (size() == 0) {
            rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
        } else if (index < 0 || index >= size()) {
            rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {

            Object[] temp = new Object[size() - 1];
            for (int i=0; i < index; i++) {
                temp[i] = AL[i];
            }
            for (int j = index+1; j < size(); j++) {
                temp[j-1] = AL[j];
            }
            AL = temp;
        }
        return rtn;

    }

    /**
     * Adds an element to the list, inserting it at the given
     * position. The indeces of elements at and after that position
     * must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param index the position at which the item should be inserted in
     *              the list
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         the item added or containing an appropriate error message
     */
    public ReturnObject add(int index, Object item) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (item == null) {
            rtn.setError(ErrorMessage.INVALID_ARGUMENT);
        } else if(index < 0 || index > size()) {
            rtn.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            rtn.setObj(item);
            extendArray();
            for (int j = size()-1; j > index; j--) {
                AL[j] = AL[j-1];
            }
            AL[index] = item;
        }
        return rtn;
    }

    /**
     * Adds an element at the end of the list.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         the item added or containing an appropriate error message
     */
    public ReturnObject add(Object item) {
        ReturnObjectImpl rtn = new ReturnObjectImpl();
        if (item == null) {
            rtn.setError(ErrorMessage.INVALID_ARGUMENT);
        } else {
            rtn.setObj(item);
            extendArray();
            AL[size()-1] = item;
        }
        return rtn;
    }

    /**
     * Extends the size of the Array
     */
    public void extendArray() {
        int index = size();
        Object[] temp = new Object[index + 1];
        for (int i=0; i < index; i++) {
            temp[i] = AL[i];
        }
        AL = temp;
    }
}

