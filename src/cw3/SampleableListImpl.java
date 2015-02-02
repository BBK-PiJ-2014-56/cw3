package cw3;

/**
 * @author James Thornton
 */

public class SampleableListImpl extends FunctionalLinkedList implements SampleableList {
    @Override
    public SampleableList sample() {
        SampleableList sampleList = new SampleableListImpl();
            for (int i = 0; i < size(); i = (i+2))
                sampleList.add(get(i).getReturnValue());
        return(sampleList);
        }


}
