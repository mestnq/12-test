import org.junit.Assert;
import org.junit.Test;

public class Tests {

    private void testIntegerDecodeUnit(String nm, Integer expectedResult) {
        Integer actualResult = Integer.decode(nm);
        Assert.assertEquals("Tests failed", expectedResult, actualResult);
    }

    @Test(expected = NumberFormatException.class)
    public void checkZeroLength() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void checkPositionSign() {
        Integer.decode("0x+1");
    }

    @Test
    public void checkMinValue() {
        testIntegerDecodeUnit(Integer.MIN_VALUE + "", Integer.MIN_VALUE);
    }

    @Test
    public void checkMaxValue() {
        testIntegerDecodeUnit(Integer.MAX_VALUE + "", Integer.MAX_VALUE);
    }

    @Test
    public void checkHandleSign() {
        testIntegerDecodeUnit("-32", -32);
        testIntegerDecodeUnit("+32", +32);
    }

    @Test
    public void checkHandleRadixSpecifier() {
        testIntegerDecodeUnit("0x83", 131);
        testIntegerDecodeUnit("0X10", 16);
        testIntegerDecodeUnit("#46", 70);
        testIntegerDecodeUnit("0xaF", 175);
        testIntegerDecodeUnit("0020", 16);
    }

    @Test(expected = NullPointerException.class)
    public void checkNull() {
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void checkString() {
        Integer.decode("Shaking hands with the dark parts of my thoughts, no.");
    }
}