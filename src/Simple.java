import java.util.Iterator;
import java.util.LinkedList;

/**
 * A mutable object that maintains state. Components of state include textual data,
 * numerical data, logical data, and an infinite-length sequence of integers. The
 * parameters to the constructor establish the initial state of the object including
 * the characteristics of the numerical sequence.
 *
 * @author Ben LeDoux
 * @author Jimmy Morgan
 * @author Alex Ovick
 * @author Jon Bowen
 * @version 1.0
 */
public class Simple extends Object {
    private String text;
    private Number number;
    private Boolean truth;
    private int depth;

    private LinkedList<Integer> sequenceStack;
    private LinkedList<Integer> depthStack;

    /**
     * Constructs a Simple object using arbitrary values.
     */
    public Simple(){
        this.text = "default";
        this.number = 1;
        this.truth = false;
        this.depth = 1;

        sequenceStack = new LinkedList<Integer>();
        sequenceStack.push(1);

        depthStack = new LinkedList<Integer>();
    }

    /**
     * <p>Constructs a Simple object initialized to the specified values and sequence definition.</p>
     * <p>Sequence definition examples:</p>
     * <p><code>Simple(... {4, 9, 12}, 0)</code> defines sequence [4, 9, 12, 0, 0, 0, 0, ...]</p>
     * <p><code>Simple(... {7}, 1)</code> defines sequence [7, 7, 7, 7, 7, 7, ...]</p>
     * <p><code>Simple(... {3, 8}, 1)</code> defines sequence [3, 8, 8, 8, 8, 8, 8, ...]</p>
     * <p><code>Simple(... {2, 4}, 2)</code> defines sequence [2, 4, 6, 10, 16, 26, 42, 68, ...]</p>
     * <p><code>Simple(... {2, 4, 6, 8}, 3)</code> defines sequence [2, 4, 6, 8, 18, 32, 58, 108, ...] </p>
     * <p>The behavior of sequences for which depth is greater than number of the initial values is unspecified.</p>
     *
     * @param text     the textual data
     * @param number   the numerical data
     * @param truth    the logical data
     * @param initVals the initial values of the sequence
     * @param depth    after all initial values have been exhausted, the number of previous
     *                 (historical) values added together to calculate the next value of the sequence
     */
    public Simple(String text, Number number, Boolean truth,
                  Integer[] initVals, int depth) {
        this.text = text;
        this.number = number;
        this.truth = truth;

        sequenceStack = new LinkedList<Integer>();
        for (int i = initVals.length - 1; i >= 0; i--)
            sequenceStack.push(initVals[i]);

        if (0 <= depth)
            this.depth = Math.min(depth, initVals.length);
        else
            this.depth = 0;

        depthStack = new LinkedList<Integer>();

    }

    /**
     * Modifies the state by inverting the logical value.
     * <p>
     * If the logical state was true, it is changed to false.
     * If the logical state was false, it is changed to true.
     * </p>
     */
    public void flip() {
        truth = !truth;
    }

    /**
     * Accesses items of the sequence, in order, beginning with the initial values passed
     * into the constructor. The first invocation returns the initial element of the sequence
     * specified by the parameter to the constructor. Modifies state so that the subsequent
     * invocation will return the following item of the sequence.
     *
     * @return the item in the sequence corresponding to the number of times the method has been invoked
     */
    public Integer nextInSequence() {
        Integer val = sequenceStack.pop();
        depthStack.push(val);

        if (depthStack.size() > this.depth)
            depthStack.removeLast();

        if (sequenceStack.size() == 0) {
            Integer nextVal = 0;
            Iterator<Integer> it = depthStack.descendingIterator();
            while (it.hasNext())
                nextVal += it.next();
            sequenceStack.push(nextVal);
        }

        return val;
    }

    /**
     * Accesses the numerical component of state.
     *
     * @return the numeric status
     */
    public Number number() {
        return number;
    }

    /**
     * Accesses the textual component of state.
     *
     * @return the text status
     */
    public String text() {
        return text;
    }

    /**
     * Renders Simple object in the format: Simple[truth, number, "text"]
     */
    @Override
    public String toString() {
        return "Simple[" + truth.toString() + ", " + number.toString() + ", \"" + text + "\"]";
    }

    /**
     * Accesses the logical component of state
     *
     * @return the truth status
     */
    public Boolean truth() {
        return truth;
    }
}
