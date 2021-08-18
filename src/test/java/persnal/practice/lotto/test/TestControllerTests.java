package persnal.practice.lotto.test;

import org.junit.Test;
import persnal.practice.lotto.test.TestController;

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