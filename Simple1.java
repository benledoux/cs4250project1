

/**
 * @author Ben Doux
 * @author Jimmy Morgan
 * @author Alex Ovick
 * @version 1.0
 */

public class Simple extends Object{
    private String text;
    private Number number;
    private Boolean truth;
    private Integer[] initVals;
    private int depth;

    /**
     * @author Jimmy Morgan
     * Constructs a Simple object using arbitrary values.
     */
    public Simple(){
        this.text = "";
        this.number = ;
        this.truth = false;
        this.depth = 1;
        this.initVals = new Integer[1];
    }

    /**
     * @author Jimmy Morgan
     * Constructs a Simple object initialized to the specified values and sequence definition.
     * 
     * @param text      the textual data
     * @param number    the numerical data
     * @param truth     the logical data
     * @param initVals  the initial values of the sequence
     * @param depth     after all initial values have been exhausted, the number of previous (historical) values added together to calculate the next value of the sequence
     */
    public Simple(String text, Number number, Boolean truth, 
           Integer[] initVals, int depth){
               this.text = text;
               this.number = number;
               this.truth = truth;
               this.depth = depth;
               this.initVals = initVals.clone();

    }
    
    /**
     * @author
     * Modifies the state by inverting the logical value.
     * 
     * <p> 
     *  If the logical state was true, it is changed to false.
     *  If the logical state was false, it is changed to true.
     * </p>
     */
    public void flip(){
        truth = !truth;
    }

    /**
     * @author
     * Accesses items of the sequence, in order.
     * 
     * <p> 
     * Brigins with initial values passed into constructor
     * The first invocation returns the initial element of the sequence specified by the parameter to the constructor
     * Modifies state so that the subsequent invocation will return the following item of the sequence.
     * </p>
     * 
     * @return the item in the sequence corresponding to the number of times the method has been invoked
     */
    public Integer nextInSequence(){

    }

    /**
     * Accesses the numerical component of state.
     * 
     * @return the numeric status
     */
    public Number number(){
        return number;
    }

    /**
     * @author
     * Accesses the textual component of state.
     * 
     * @return the text status
     */
    public String text(){
        return text;
    }

    /**
     * @author
     * Renders Simple object in the format: Simple[truth, number, "text"]
     */
    @Override
    public String toString(){
        return "Simple[" + truth.toString() + ", " + number.toString() + ", \"" + text + "\"]";
    }

    /**
     * @author
     * Accesses the logical component of state
     * 
     * @return the truth status
     */
    public Boolean truth(){
        return truth;
    }
}
