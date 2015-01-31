package cw3;

/**
 * Created by jimjohn_thornton on 31/01/15.
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    @Override
    public ReturnObject head() {
        return get(0);
    }

    @Override
    public FunctionalList rest() {
        FunctionalList FLL = new FunctionalLinkedList();
        if (isEmpty()) {
            return null;
        } else {
            remove(0);
            //FunctionalList noHead = new FunctionalArrayList();
            for (int i = 1; i < size(); i++)
                FLL.add(get(i).getReturnValue());
            return FLL;
        }
    }

}
