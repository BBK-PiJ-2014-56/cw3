package cw3;

/**
 * @author James Thornton
 */

public class ReturnObjectImpl implements ReturnObject{
    private boolean error;
    private Object obj;
    private ErrorMessage errorDet;


    public ReturnObjectImpl () {
        this.obj = null;
        this.error = false;
        this.errorDet = null;
    }

    /**
     * Setter
     * @param obj sets object
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * sets error
     * @param ED sets error details
     */
    public void setError(ErrorMessage ED) {
        error = true;
        errorDet = ED;
    }
    /**
     * Returns whether there has been an error
     * @return whether there has been an error
     */
    public boolean hasError() {
        return error;
    }
    /**
     * Returns the error message.
     *
     * This method must return NO_ERROR if and only if
     * {@hasError} returns false.
     *
     * @return the error message
     */
    public ErrorMessage getError() {
        if (!hasError()) {
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
        if (hasError()) {
            return null;
        } else {
            return obj;
        }
    }

}
