package com.zero.manpo.utils;

import com.zero.manpo.models.error.ErrorRelay;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Provides utility functions for validating inputs.
 * <p>
 * This class acts as a helper layer for managing external process execution
 * such as local Git commands.
 * </p>
 *
 * @author zeroNhatty
 * @version 0.1.1-SNAPSHOT
 * @since 0.1
 */

public class Validator {

    /**
     * Validates if a Git remote repository link is reachable and valid.
     * <p>
     * Note: The provided link must be trimmed before being passed into this method,
     * otherwise leading or trailing spaces will cause verification to fail.
     * </p>
     *
     * @param projLink the remote Git repository URL to validate
     * @return {@code ErrorRelay.isSuccessful = true} if the repository is reachable and valid;
     * {@code  ErrorRelay.isSuccessful = false} if the link is invalid, blank, or unreachable within the timeout period
     *
     * @since 0.1
     * @see <a href="https://git-scm.com/docs/git-ls-remote">Git ls-remote Documentation</a>
     */
    public static ErrorRelay validateProjectLink(String projLink) {
        ErrorRelay err = new ErrorRelay();

        if (projLink == null || projLink.isBlank()) {
            err.setErrMsg("Project Link Input is Empty!");
            return err;
        }

        String[] cmd = {"git", "ls-remote", projLink};
        ProcessBuilder pb = new ProcessBuilder(cmd);

        pb.redirectError(ProcessBuilder.Redirect.DISCARD);
        pb.redirectOutput(ProcessBuilder.Redirect.DISCARD);

        try {
            Process process = pb.start();

            boolean finished = process.waitFor(5, TimeUnit.SECONDS);

            if (!finished) {
                process.destroyForcibly();
                err.setErrMsg("git Authentication Timeout!");
                return err;
            }

            int exitCode = process.exitValue();

            if (exitCode == 0) {
                err.setIsSuccessful(true);
            } else {
                err.setErrMsg("Couldn't reach remote repository");
                System.out.println("Exit Code: " + exitCode);
            }
            return err;

        } catch (IOException e) {
            err.setErrMsg("Git command executable not found: " + e.getMessage());
            return err;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            err.setErrMsg("Thread Interruption: " + e.getMessage());
            return err;
        }
    }

}
