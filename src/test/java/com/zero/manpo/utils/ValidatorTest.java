package com.zero.manpo.utils;

import com.zero.manpo.models.error.ErrorRelay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ValidatorTest {

    @Test
    void testValidateProjectLink_WithEmptyInput() {
        ErrorRelay result = Validator.validateProjectLink("");

        assertFalse(result.isSuccessful());
        assertEquals("Project Link Input is Empty!", result.getErrMsg());
    }

    @Test
    void testValidateProjectLink_WithInvalidString() {
        ErrorRelay result = Validator.validateProjectLink("hello");

        assertFalse(result.isSuccessful());
        assertEquals("Couldn't reach remote repository", result.getErrMsg());
    }

    @Test
    void testValidateProjectLink_WithUntrimmedSpaces() {
        ErrorRelay result = Validator.validateProjectLink(" git@github.com:zeroNhatty/manpo.git ");

        assertFalse(result.isSuccessful());
        assertEquals("Couldn't reach remote repository", result.getErrMsg());
    }

    @Test
    void testValidateProjectLink_WithInternalSpaces() {
        ErrorRelay result = Validator.validateProjectLink("git@github.com:zeroNh atty/manpo.git");

        assertFalse(result.isSuccessful());
        assertEquals("Couldn't reach remote repository", result.getErrMsg());
    }

    @Test
    void testValidateProjectLink_WithNonExistentRepository() {
        ErrorRelay result = Validator.validateProjectLink("git@github.com:zeroNhatty/manpodweqdafs.git");

        assertFalse(result.isSuccessful());
        assertEquals("Couldn't reach remote repository", result.getErrMsg());
    }

    @Test
    void testValidateProjectLink_WithValidRepository() {
        // NOTE: This test requires active internet and valid environment git credentials to pass
        ErrorRelay result = Validator.validateProjectLink("git@github.com:zeroNhatty/manpo.git");

        assertTrue(result.isSuccessful());
        assertEquals("", result.getErrMsg());
    }
}