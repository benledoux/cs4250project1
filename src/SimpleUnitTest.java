import java.util.*;

public class SimpleUnitTest {
        public static void UnitTest(Simple simpleObject) {
		System.out.println("UNIT TEST: \n" + 
		"Boolean truth() Method: " + simpleObject.truth());
		
		System.out.println("Number number() Method: " + simpleObject.number());

		System.out.println("String text() Method: " + simpleObject.text());

		simpleObject.flip();
		
		System.out.println("Void flip() Method: " + simpleObject.truth());

		System.out.println("Integer nextInSequence() Method: " + simpleObject.nextInSequence() + ", " + simpleObject.nextInSequence() + ", " + 
		simpleObject.nextInSequence() + ", " + simpleObject.nextInSequence() + ", " + simpleObject.nextInSequence());

		System.out.println("String toString() Method: " + simpleObject.toString());		
        }

	public static void main(String[] args)  {
		System.out.println("UNIT TEST FOR SIMPLE CLASS" +
		"\nTEST 1 (DEFAULT VALUES)" +
		"\nBoolean truth() method: false" +
		"\nNumber number() method: 1" +
		"\nVoid flip() method: true" +
		"\nInteger nextInSequence method: 1, 1, 1, 1, 1" +
		"\nString toString() Method: Simple[true, 1, default]\n");
		
		Simple defaultSimpleTest = new Simple();
		UnitTest(defaultSimpleTest);

		Integer[] unitTestSequenceList2 = new Integer[] {4, 9, 12};

		System.out.println("\nTEST 2 (Sample Text, 3, false, {4, 9, 12), 0)" +
                "\nBoolean truth() method: false" +
                "\nNumber number() method: 3" +
                "\nVoid flip() method: true" +
                "\nInteger nextInSequence method: 4, 9, 12, 0, 0" +
                "\nString toString() Method: Simple[true, 3, Sample Text]\n");
		
		Simple customSimpleTest2 = new Simple("Sample Text", 3, false, unitTestSequenceList2, 0);
		UnitTest(customSimpleTest2);

		Integer[] unitTestSequenceList3 = new Integer[] {2, 4, 6, 8};

                System.out.println("\nTEST 3 (Unit Test 3, 576432, true, {2, 4, 6, 8), 3)" +
                "\nBoolean truth() method: true" +
                "\nNumber number() method: 576432" +
                "\nVoid flip() method: false" +
                "\nInteger nextInSequence method: 2, 4, 6, 8, 18" +
                "\nString toString() Method: Simple[false, 576432, Unit Test 2]\n");

                Simple customSimpleTest3 = new Simple("Unit Test 3", 576432, true, unitTestSequenceList2, 3);
                UnitTest(customSimpleTest3);

		Integer[] unitTestSequenceList4 = new Integer[] {800, 300, 1};

                System.out.println("\nTEST 3 (Misordered Sequence, 314, true, {800, 300, 1), 3)" +
                "\nBoolean truth() method: true" +
                "\nNumber number() method: 314" +
                "\nVoid flip() method: false" +
                "\nInteger nextInSequence method: 800, 300, 1, 1101, 1402" +
                "\nString toString() Method: Simple[false, 314, Misordered Sequence]\n");

                Simple customSimpleTest4 = new Simple("Misordered Sequence", 314, true, unitTestSequenceList4, 3);
                UnitTest(customSimpleTest4);
	}
}
