package persnal.practice.lotto.Controller;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestControllerTests {

    @Test
    public void creation(){
        TestController testController = new TestController();
        assertThat(testController.getTest(), is("test=success test"));
    }

    @Test
    public void testGetHtml(){
        TestController testController = new TestController();
        assertThat(testController.getTestUrl(), is(""));
    }
}