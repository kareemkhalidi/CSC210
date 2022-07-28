/*
 * This file will hold all of your testcases. Remember, to run all
 * of your tests, right-click on 'RunTests.java' and select 'Run As' ->
 * JUnit Test.
 */
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class RecursionTestClass {
	
	/*
	 * Tests a 1 character substring at the start of the initial string
	 */
    @Test
    public void test_indexOf_test1() {
        int result = Recursion.indexOf("abcdefghijk", "a");
        System.out.println("indexOf(testcase 1), got " + result);
        assertEquals(0, result);
    }
    
    /*
	 * Tests a longer than 1 character substring at the start of the initial string
	 */
    @Test
    public void test_indexOf_test2() {
        int result = Recursion.indexOf("abcdefghijk", "abc");
        System.out.println("indexOf(testcase 2), got " + result);
        assertEquals(0, result);
    }
    
    /*
	 * Tests a 1 character substring in the middle of the initial string
	 */
    @Test
    public void test_indexOf_test3() {
        int result = Recursion.indexOf("abcdefghijk", "d");
        System.out.println("indexOf(testcase 3), got " + result);
        assertEquals(3, result);
    }
    
    /*
	 * Tests a longer than 1 character substring in the middle of the initial string
	 */
    @Test
    public void test_indexOf_test4() {
        int result = Recursion.indexOf("abcdefghijk", "def");
        System.out.println("indexOf(testcase 4), got " + result);
        assertEquals(3, result);
    }
    
    /*
	 * Tests a 1 character substring at the end of the initial string
	 */
    @Test
    public void test_indexOf_test5() {
        int result = Recursion.indexOf("abcdefghijk", "k");
        System.out.println("indexOf(testcase 5), got " + result);
        assertEquals(10, result);
    }
    
    /*
	 * Test a longer than 1 character substring at the end of the initial string
	 */
    @Test
    public void test_indexOf_test6() {
        int result = Recursion.indexOf("abcdefghijk", "ijk");
        System.out.println("indexOf(testcase 6), got " + result);
        assertEquals(8, result);
    }
    
    /*
	 * Tests an incorrect substring at the start of the initial string
	 */
    @Test
    public void test_indexOf_test7() {
        int result = Recursion.indexOf("abcdefghijk", "abdc");
        System.out.println("indexOf(testcase 7), got " + result);
        assertEquals(-1, result);
    }
    
    /*
	 * Tests an incorrect substring in the middle of the initial string
	 */
    @Test
    public void test_indexOf_test8() {
        int result = Recursion.indexOf("abcdefghijk", "degf");
        System.out.println("indexOf(testcase 8), got " + result);
        assertEquals(-1, result);
    }
    
    /*
	 * Tests an incorrect substring at the end of the initial string
	 */
    @Test
    public void test_indexOf_test9() {
        int result = Recursion.indexOf("abcdefghijk", "hikj");
        System.out.println("indexOf(testcase 9), got " + result);
        assertEquals(-1, result);
    }
    
    /*
	 * Tests that the method works when two empty strings are input
	 */
    @Test
    public void test_indexOf_test10() {
        int result = Recursion.indexOf("", "");
        System.out.println("indexOf(testcase 10), got " + result);
        assertEquals(0, result);
    }
    
    /*
	 * Tests that the method works when an empty string is input for s2
	 */
    @Test
    public void test_indexOf_test11() {
        int result = Recursion.indexOf("abcdefghijk", "");
        System.out.println("indexOf(testcase 11), got " + result);
        assertEquals(0, result);
    }
    
    /*
	 * Tests that the method works when an empty string is input for s1
	 */
    @Test
    public void test_indexOf_test12() {
        int result = Recursion.indexOf("", "abcdefghijk");
        System.out.println("indexOf(testcase 12), got " + result);
        assertEquals(-1, result);
    }
    
    /*
	 * Tests to see if method can remove even number at end of stack
	 */
    @Test
    public void test_removeEvenNumbers_test1() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(10);
    	testStack.push(5);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(5);
        Recursion.removeEvenNumbers(testStack, 1);
        System.out.println("removeEvenNumbers(testcase 1), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests to see if method can remove multiple even numbers at end of stack
	 */
    @Test
    public void test_removeEvenNumbers_test2() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(10);
    	testStack.push(10);
    	testStack.push(5);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(5);
        Recursion.removeEvenNumbers(testStack, 2);
        System.out.println("removeEvenNumbers(testcase 2), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests to make sure that putting in a k greater than the number of
	 * even numbers does not affect the method
	 */
    @Test
    public void test_removeEvenNumbers_test3() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(10);
    	testStack.push(10);
    	testStack.push(5);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(5);
        Recursion.removeEvenNumbers(testStack, 3);
        System.out.println("removeEvenNumbers(testcase 3), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests to make sure that removing even number from start of stack works
	 */
    @Test
    public void test_removeEvenNumbers_test4() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(5);
    	testStack.push(10);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(5);
        Recursion.removeEvenNumbers(testStack, 1);
        System.out.println("removeEvenNumbers(testcase 4), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests to make sure that removing multiple even numbers from start of stack works
	 */
    @Test
    public void test_removeEvenNumbers_test5() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(5);
    	testStack.push(10);
    	testStack.push(10);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(5);
        Recursion.removeEvenNumbers(testStack, 2);
        System.out.println("removeEvenNumbers(testcase 5), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests to make sure that removing even number from middle of stack works
	 */
    @Test
    public void test_removeEvenNumbers_test6() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(5);
    	testStack.push(10);
    	testStack.push(5);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(5);
    	expectedStack.push(5);
        Recursion.removeEvenNumbers(testStack, 1);
        System.out.println("removeEvenNumbers(testcase 6), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests to make sure that removing multiple even numbers from middle of stack works
	 */
    @Test
    public void test_removeEvenNumbers_test7() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(5);
    	testStack.push(10);
    	testStack.push(10);
    	testStack.push(5);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(5);
    	expectedStack.push(5);
        Recursion.removeEvenNumbers(testStack, 2);
        System.out.println("removeEvenNumbers(testcase 7), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests to make sure that having more even numbers than k doesn't just delete all evens
	 */
    @Test
    public void test_removeEvenNumbers_test8() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(5);
    	testStack.push(10);
    	testStack.push(10);
    	testStack.push(5);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(5);
    	expectedStack.push(10);
    	expectedStack.push(5);
        Recursion.removeEvenNumbers(testStack, 1);
        System.out.println("removeEvenNumbers(testcase 8), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests an all even positive number
	 */
    @Test
    public void test_evenDigits_test1() {
        int result = Recursion.evenDigits(246);
        System.out.println("evenDigits(testcase 1), got " + result);
        assertEquals(246, result);
    }
    
    /*
	 * Tests an all odd positive number
	 */
    @Test
    public void test_evenDigits_test2() {
        int result = Recursion.evenDigits(135);
        System.out.println("evenDigits(testcase 2), got " + result);
        assertEquals(0, result);
    }
    
    /*
	 * Tests an all even negative number
	 */
    @Test
    public void test_evenDigits_test3() {
        int result = Recursion.evenDigits(-246);
        System.out.println("evenDigits(testcase 3), got " + result);
        assertEquals(-246, result);
    }
    
    /*
	 * Tests an all even negative number
	 */
    @Test
    public void test_evenDigits_test4() {
        int result = Recursion.evenDigits(-135);
        System.out.println("evenDigits(testcase 4), got " + result);
        assertEquals(0, result);
    }
    
    /*
	 * Tests positive number with evens on the ends and in the middle
	 */
    @Test
    public void test_evenDigits_test5() {
        int result = Recursion.evenDigits(21212);
        System.out.println("evenDigits(testcase 5), got " + result);
        assertEquals(222, result);
    }
    
    /*
	 * Tests negative number with evens on the ends and in the middle
	 */
    @Test
    public void test_evenDigits_test6() {
        int result = Recursion.evenDigits(-21212);
        System.out.println("evenDigits(testcase 6), got " + result);
        assertEquals(-222, result);
    }
    
    /*
	 * Tests positive number with odds on the ends and in the middle
	 */
    @Test
    public void test_evenDigits_test7() {
        int result = Recursion.evenDigits(12121);
        System.out.println("evenDigits(testcase 7), got " + result);
        assertEquals(22, result);
    }
    
    /*
	 * Tests negative number with odds on the ends and in the middle
	 */
    @Test
    public void test_evenDigits_test8() {
        int result = Recursion.evenDigits(-12121);
        System.out.println("evenDigits(testcase 8), got " + result);
        assertEquals(-22, result);
    }
    
    /*
	 * Tests 0 as an input
	 */
    @Test
    public void test_evenDigits_test9() {
        int result = Recursion.evenDigits(0);
        System.out.println("evenDigits(testcase 9), got " + result);
        assertEquals(0, result);
    }
    
    /*
	 * Tests a normal stack to make sure its working
	 */
    @Test
    public void test_repeatStack_test1() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(1);
    	testStack.push(2);
    	testStack.push(3);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(1);
    	expectedStack.push(1);
    	expectedStack.push(2);
    	expectedStack.push(2);
    	expectedStack.push(3);
    	expectedStack.push(3);
        Recursion.repeatStack(testStack);
        System.out.println("repeatStack(testcase 1), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests a 1 element stack
	 */
    @Test
    public void test_repeatStack_test2() {
    	Stack<Integer> testStack = new Stack<>();
    	testStack.push(1);
    	Stack<Integer> expectedStack = new Stack<>();
    	expectedStack.push(1);
    	expectedStack.push(1);
        Recursion.repeatStack(testStack);
        System.out.println("repeatStack(testcase 2), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
	 * Tests a 0 element stack
	 */
    @Test
    public void test_repeatStack_test3() {
    	Stack<Integer> testStack = new Stack<>();
    	Stack<Integer> expectedStack = new Stack<>();
        Recursion.repeatStack(testStack);
        System.out.println("repeatStack(testcase 3), got " + testStack);
        assertEquals(expectedStack, testStack);
    }
    
    /*
     * Tests 0 element queue
     * */
    @Test
    public void test_doubleElements_test1() {
    	
    	Queue<Integer> testQueue = new LinkedList<>();
    	Queue<Integer> expectedQueue = new LinkedList<>();
    	Recursion.doubleElements(testQueue);
    	System.out.println("repeatStack(testcase 1), got " + testQueue);
    	assertEquals(expectedQueue, testQueue);
    	
    }
    
    /*
     * Tests 1 element queue
     * */
    @Test
    public void test_doubleElements_test2() {
    	
    	Queue<Integer> testQueue = new LinkedList<>();
    	testQueue.add(10);
    	Queue<Integer> expectedQueue = new LinkedList<>();
    	expectedQueue.add(20);
    	Recursion.doubleElements(testQueue);
    	System.out.println("repeatStack(testcase 2), got " + testQueue);
    	assertEquals(expectedQueue, testQueue);
    	
    }
    
    /*
     * Tests greater than 1 element queue
     * */
    @Test
    public void test_doubleElements_test3() {
    	
    	Queue<Integer> testQueue = new LinkedList<>();
    	testQueue.add(10);
    	testQueue.add(20);
    	testQueue.add(30);
    	Queue<Integer> expectedQueue = new LinkedList<>();
    	expectedQueue.add(20);
    	expectedQueue.add(40);
    	expectedQueue.add(60);
    	Recursion.doubleElements(testQueue);
    	System.out.println("repeatStack(testcase 3), got " + testQueue);
    	assertEquals(expectedQueue, testQueue);
    	
    }

    /*
     * Testing addition
     * */
    @Test
    public void test_evaluate_test1() {
    	Queue<Character> testQueue = new LinkedList<>();
    	testQueue.add('(');
    	testQueue.add('5');
    	testQueue.add('+');
    	testQueue.add('4');
    	testQueue.add(')');
    	int result = Recursion.evaluate(testQueue);
        System.out.println("evaluate(testcase 1), got " + result);
        assertEquals(9, result);
    }
    
    /*
     * Testing multiplication
     * */
    @Test
    public void test_evaluate_test2() {
    	Queue<Character> testQueue = new LinkedList<>();
    	testQueue.add('(');
    	testQueue.add('5');
    	testQueue.add('*');
    	testQueue.add('4');
    	testQueue.add(')');
    	int result = Recursion.evaluate(testQueue);
        System.out.println("evaluate(testcase 2), got " + result);
        assertEquals(20, result);
    }
    
    //(2 * (5 + 5))
    /*
     * Testing multiplication and addition
     * */
    @Test
    public void test_evaluate_test3() {
    	Queue<Character> testQueue = new LinkedList<>();
    	testQueue.add('(');
    	testQueue.add('2');
    	testQueue.add('*');
    	testQueue.add('(');
    	testQueue.add('5');
    	testQueue.add('+');
    	testQueue.add('5');
    	testQueue.add(')');
    	testQueue.add(')');
    	int result = Recursion.evaluate(testQueue);
        System.out.println("evaluate(testcase 3), got " + result);
        assertEquals(20, result);
    }
    
    /*
     * Testing empty queue
     * */
    @Test
    public void test_evaluate_test4() {
    	Queue<Character> testQueue = new LinkedList<>();
    	int result = Recursion.evaluate(testQueue);
        System.out.println("evaluate(testcase 4), got " + result);
        assertEquals(20, result);
    }
    
}
