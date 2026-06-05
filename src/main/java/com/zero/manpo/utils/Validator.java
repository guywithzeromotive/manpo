package com.zero.manpo.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Validator {

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
