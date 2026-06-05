package com.zero.manpo.utils;

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
 * @version 0.1-SNAPSHOT
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
     * @return {@code true} if the repository is reachable and valid;
     * {@code false} if the link is invalid, blank, or unreachable within the timeout period
     *
     * @since 0.1
     * @see <a href="https://git-scm.com/docs/git-ls-remote">Git ls-remote Documentation</a>
     */
    public static boolean validateProjectLink(String projLink) {
        if (projLink == null || projLink.isBlank()) {
            return false;
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
                return false;
            }

            int exitCode = process.exitValue();
            System.out.println("Git process exited with code: " + exitCode);

            return exitCode == 0;

        } catch (IOException e) {
            System.err.println("Git command executable not found: " + e.getMessage());
            return false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

}
