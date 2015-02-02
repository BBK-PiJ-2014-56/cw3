package cw3;

/**
 * @author James Thornton
 */

public class StackImpl extends AbstractStack implements Stack{
    public StackImpl(List list) {
        super(list);
    }

    public ReturnObject add(Object item) {
        return internalList.add(item);
    }

    public ReturnObject get(int index) {
        return internalList.get(index);
    }

    public ReturnObject remove(int index) {
        return internalList.remove(index);
    }

    public ReturnObject add(int index, Object item) {
        return internalList.add(index, item);
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public void push(Object item) {
        internalList.add(0, item);
    }

    @Override
    public ReturnObject top() {
        if (isEmpty()) {
            ReturnObjectImpl rtn = (ReturnObjectImpl) get(0);
            rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
            return rtn;
        } else {
            return internalList.get(0);
        }
    }

    @Override
    public ReturnObject pop() {
        return internalList.remove(0);
    }
}
