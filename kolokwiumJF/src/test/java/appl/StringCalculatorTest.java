package appl;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void TestOfAdd() {
        StringCalculator a = new StringCalculator();
        a.Add("test");
        a.Add("test2");
        Assert.assertEquals( "testtest2",a.getResult() );
    }

    @Test
    public void TestOfMult4Times() {
        StringCalculator a = new StringCalculator();
        a.Add("test");
        a.Multiply(4);
        Assert.assertEquals("testtesttesttest",a.getResult() );
    }
    @Test
    public void TestOfMult5Times() {
        StringCalculator a = new StringCalculator();
        a.Add("test");
        a.Multiply(5);
        Assert.assertEquals("testtesttesttesttest",a.getResult() );
    }
}