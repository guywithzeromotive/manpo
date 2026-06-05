package utils;

import com.zero.manpo.utils.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {

    @Test
    void testValidateProjectLink(){
        assertFalse(Validator.validateProjectLink("ello"));
        assertFalse(Validator.validateProjectLink(""));
        assertTrue(Validator.validateProjectLink("git@github.com:zeroNhatty/manpo.git"));
        assertTrue(Validator.validateProjectLink(" git@github.com:zeroNhatty/manpo.git "));
        assertFalse(Validator.validateProjectLink("git@github.com:zeroNhatty/manpodweqdafs.git"));
    }
}
