package cw3;

/**
 * @author James Thornton
 */

public class FunctionalArrayList extends ArrayList implements FunctionalList {
    @Override
    public ReturnObject head() {
        //ReturnObjectImpl rtn = new ReturnObjectImpl();
        //if(isEmpty()) {
            //rtn.setError(ErrorMessage.EMPTY_STRUCTURE);
            //return rtn;
        //} else {
            //rtn = get(0);
        //}
        return get(0);
    }

    @Override
    public FunctionalList rest() {
        FunctionalList noHead = new FunctionalArrayList();
        if (isEmpty()) {
            return null;
        } else {
            //FunctionalList noHead = new FunctionalArrayList();
            for (int i = 1; i < size(); i++)
                noHead.add(get(i).getReturnValue());
            //noHead.remove(0);
            return noHead;
        }
    }
}
