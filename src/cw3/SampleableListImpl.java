package cw3;

/**
 * Created by jimjohn_thornton on 31/01/15.
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
