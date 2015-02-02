package cw3;

/**
 * @author James Thornton
 */

public class SampleableListImpl implements SampleableList {

    private List internalList;

    public SampleableListImpl(List internalList) {
        this.internalList = internalList;
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
    public ReturnObject get(int index) {
        return internalList.get(index);
    }

    @Override
    public ReturnObject remove(int index) {
        return internalList.remove(index);
    }

    @Override
    public ReturnObject add(int index, Object item) {
        return internalList.add(index,  item);
    }

    @Override
    public ReturnObject add(Object item) {
        return internalList.add(item);
    }

    @Override
    public SampleableList sample() {
        FunctionalLinkedList FLL = new FunctionalLinkedList();
        SampleableList sampleList = new SampleableListImpl(FLL);
            for (int i = 0; i < size(); i = (i+2))
                sampleList.add(internalList.get(i).getReturnValue());
        return(sampleList);
        }
}
