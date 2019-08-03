import java.util.HashMap;

public class Calculator {
    HashMap<String,String> history; // a HashMap to store the expression as key and its solution as a value.

    /**
     * A public constructor to initialize history.
     * */
    public Calculator() {
        history = new HashMap<>();
    }

    /**
     * A simple Add function to add two real numbers.
     * @param a first number.
     * @param b second number.
     * @return a float value of addition of two numbers.
     * */
    public float add(float a, float b){
        return a+b;
    }

    /**
     * A simple subtraction function to subtract a real number from another.
     * @param a first number.
     * @param b second number.
     * @return a float value of subtraction of a real number with another.
     * */
    public float sub(float a, float b){
        return a-b;
    }

    /**
     * A simple multiplication function to multiply a real number with another.
     * @param a first number.
     * @param b second number.
     * @return a float value of multiplication of two numbers.
     * */
    public float mul(float a, float b){
        return a * b;
    }

    /**
     * A simple division function to divide a real number with another.
     * @param a first number.
     * @param b second number.
     * @return a float value of division of a real number with another.
     * */
    public float div(float a, float b){
        return a/b;
    }

    /**
     * A simple modulus function to get the remainder after the division.
     * @param a first number.
     * @param b second number.
     * @return a float value of remainder after division of a real number with another.
     * */
    public float modulus(float a, float b){
        return a%b;
    }

    /**
     * An equal to operator simulating method to return the value of the expression given.
     * @return It returns a String containing the value of the expression.
     * @param expression, Its a validated expression that needs to be computed.
     * */
    public String equalOperator(String expression){
        String ANS = "";
        String[] exp = expression.split(" ");
        switch (exp[1]){
            case "+":
                ANS = Float.toString(add(Float.parseFloat(exp[0]),Float.parseFloat(exp[2])));
                history.put(expression,ANS);
                return ANS;
            case "-":
                ANS = Float.toString(sub(Float.parseFloat(exp[0]),Float.parseFloat(exp[2])));
                history.put(expression,ANS);
                return ANS;
            case "*":
                ANS = Float.toString(mul(Float.parseFloat(exp[0]),Float.parseFloat(exp[2])));
                history.put(expression,ANS);
                return ANS;
            case "/":
                if(Float.parseFloat(exp[2]) <= 0)
                    return "";
                ANS = Float.toString(div(Float.parseFloat(exp[0]),Float.parseFloat(exp[2])));
                history.put(expression,ANS);
                return ANS;
            case "%":
                if(Float.parseFloat(exp[2]) <= 0)
                    return "";
                ANS = Float.toString(modulus(Float.parseFloat(exp[0]),Float.parseFloat(exp[2])));
                history.put(expression,ANS);
                return ANS;
        }
        return "";
    }

    /**
     * This function is used to clear history
     * */
    public void clearHistory(){
        history.clear();
    }
}
