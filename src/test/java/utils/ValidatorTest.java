package utils;

import com.zero.manpo.models.error.ErrorRelay;
import com.zero.manpo.utils.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    void testValidateProjectLink(){
        ErrorRelay err = new ErrorRelay();
        err.setErrMsg("Project Link Input is Empty!");
        assertEquals(err.getErrMsg(), Validator.validateProjectLink("").getErrMsg());
        assertEquals(err.isSuccessful(), Validator.validateProjectLink("").isSuccessful());

        err.setErrMsg("Couldn't reach remote repository");
        assertEquals(err.getErrMsg(), Validator.validateProjectLink("ello").getErrMsg());
        assertEquals(err.isSuccessful(), Validator.validateProjectLink("ello").isSuccessful());

        err.setErrMsg("Couldn't reach remote repository");
        assertEquals(err.getErrMsg(), Validator.validateProjectLink(" git@github.com:zeroNhatty/manpo.git ").getErrMsg());
        assertEquals(err.isSuccessful(), Validator.validateProjectLink(" git@github.com:zeroNhatty/manpo.git ").isSuccessful());

        err.setErrMsg("Couldn't reach remote repository");
        assertEquals(err.getErrMsg(), Validator.validateProjectLink("git@github.com:zeroNhatty/manpodweqdafs.git").getErrMsg());
        assertEquals(err.isSuccessful(), Validator.validateProjectLink("git@github.com:zeroNhatty/manpodweqdafs.git").isSuccessful());

        //we assume we have internet connection else it will fail
        err.setIsSuccessful(true);
        err.setErrMsg("");
        assertEquals(err.getErrMsg(), Validator.validateProjectLink("git@github.com:zeroNhatty/manpo.git").getErrMsg());
        assertEquals(err.isSuccessful(), Validator.validateProjectLink("git@github.com:zeroNhatty/manpo.git").isSuccessful());
    }
}
