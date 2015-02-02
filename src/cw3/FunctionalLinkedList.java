package cw3;

/**
 * @author James Thornton
 */

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

    @Override
    public ReturnObject head() {
        return get(0);
    }

    @Override
    public FunctionalList rest() {

        if (isEmpty()) {
            return null;
        } else {
            FunctionalList FLL = new FunctionalLinkedList();
            for (int i = 1; i < size(); i++) {
                FLL.add(get(i).getReturnValue());
            }
            return FLL;
        }
    }

}
