package cw3;


public class ReturnObjectImpl implements ReturnObject{
    /**
     * Returns whether there has been an error
     * @return whether there has been an error
     */
    private boolean error;
    private Object obj;
    private ErrorMessage errorDet;

    public ReturnObjectImpl () {
        this.obj = null;
        this.error = false;
        this.errorDet = null;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setError(ErrorMessage ED) {
        error = true;
        errorDet = ED;
    }

    public boolean hasError() {
        if (error == true){
            return true ;
        } else {
            return false;
        }

    }
    public ErrorMessage getError() {
        if (hasError() == false) {
            return ErrorMessage.NO_ERROR;
        } else {
            return errorDet;
        }
    }

    /**
     * Returns the object wrapped in this ReturnObject, i.e. the
     * result of the operation if it was successful, or null if
     * there has been error.
     *
     * Note that the output of this method must be null if {@see
     * hasError} returns true, but the opposite is not true: if
     * {@see hasError} returns false, this method may or may not
     * return null.
     *
     * @return the return value from the method or null if there has been an
     *         error
     */
    public Object getReturnValue() {
        if (hasError() == true) {
            return null;
        } else {
            return obj;
        }
    }

}
