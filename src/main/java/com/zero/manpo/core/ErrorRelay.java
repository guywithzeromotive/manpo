package com.zero.manpo.core;

/**
 * A data transfer object used to relay execution states and error messages
 * across application layers.
 * <p>
 * This wrapper allows methods to return both a success flag and a contextual
 * failure message together without relying on throwing checked exceptions.
 * </p>
 *
 * @author zeroNhatty
 * @version 0.1.1-SNAPSHOT
 * @since 0.1
 */
public class ErrorRelay {
    private boolean isSuccessful = false;
    private String errMsg = "";

    /**
     * Checks if the associated operation completed successfully.
     *
     * @return {@code true} if successful, otherwise {@code false}
     */
    public boolean isSuccessful(){
        return isSuccessful;
    }

    /**
     * Gets the error message associated with a failed operation.
     *
     * @return a descriptive error message string, or an empty string if successful
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * Sets the success status of the operation.
     *
     * @param isSuccessful {@code true} to mark as a success, {@code false} otherwise
     */
    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    /**
     * Sets the descriptive error message detailing the reason for failure.
     *
     * @param errMsg the detailed error message string
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
