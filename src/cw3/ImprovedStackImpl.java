package cw3;

/**
 * @author James Thornton
 */

public class ImprovedStackImpl implements ImprovedStack {

    private List internalList;
    public ImprovedStackImpl(List list) {
        internalList = list;
    }

    @Override
    public ImprovedStack reverse() {
        ImprovedStackImpl reverseList = new ImprovedStackImpl(new ArrayList());
        for (int i=0; i < size(); i++) {
            reverseList.push(internalList.get(i).getReturnValue());
        }
        return reverseList;
    }

    @Override
    public void remove(Object object) {

        for (int i=0; i < size(); i++) {
            Object listObject = internalList.get(i).getReturnValue();
            if (object.equals(listObject)) {
                internalList.remove(i);
                i--;
            }
        }
    }

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
        return internalList.get(0);
    }

    @Override
    public ReturnObject pop() {
        return internalList.remove(0);
    }
}
