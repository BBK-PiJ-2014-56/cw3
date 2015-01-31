package cw3;

/**
 * Created by jimjohn_thornton on 31/01/15.
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

        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void push(Object item) {

    }

    @Override
    public ReturnObject top() {
        return null;
    }

    @Override
    public ReturnObject pop() {
        return null;
    }
}
