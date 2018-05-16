import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {

//1
    @Ignore
    @Test
    public void testSeparateTo(){
        Integer[] arr = {1,2,3,4,5,6,7,8};
        Integer[] out = {5,6,7,8};
        Assert.assertArrayEquals(out, Main.separateTo(arr, 4));
    }

    @Ignore
    @Test
    public void testSeparateTo1(){
        Integer[] arr = {4,4,4,7,7,4,7,7};
        Integer[] out = {7,7};
        Assert.assertArrayEquals(out, Main.separateTo(arr, 4));
    }

    @Ignore
    @Test
    public void testSeparateTo2(){
        Integer[] arr = {1,1,1,1,1,4};
        Integer[] out = {};
        Assert.assertArrayEquals(out, Main.separateTo(arr, 4));
    }

    @Ignore
    @Test( expected = RuntimeException.class)
    public void testSeparateTo3(){
        Integer[] arr = {1,2,3,1,5,6,7,8};
        Integer[] out = {1};
        Assert.assertArrayEquals(out, Main.separateTo(arr, 4));
    }

//2
    @Ignore
    @Test()
    public void testExistsArgs(){
        Integer[] arr = {1,2,3,4,5,6,7,8};
        Assert.assertTrue(Main.existsArgs(arr, 4, 1));
    }

    @Ignore
    @Test()
    public void testExistsArgs1(){
        Integer[] arr = {1,2,3,1,5,6,7,8};
        Assert.assertFalse(Main.existsArgs(arr, 4, 1));
    }

    @Ignore
    @Test()
    public void testExistsArgs2(){
        Integer[] arr = {4,2,3,4,5,6,7,8};
        Assert.assertFalse(Main.existsArgs(arr, 4, 1));
    }

    @Ignore
    @Test()
    public void testExistsArgs3(){
        Integer[] arr = {3,2,3,3,5,6,7,8};
        Assert.assertFalse(Main.existsArgs(arr, 4, 1));
    }



}


