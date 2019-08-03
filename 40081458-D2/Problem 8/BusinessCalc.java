public class BusinessCalc extends Calculator {

    /**
     * This function calculates exponent. x^y (x raised to y).
     * @param x is any real number.
     * @param y is any real number.
     * @return a float value of x raised to y.
     * */
    private float raiseTo(float x,float y){
        float p = 1;
        for (int i = 1; i <= y; i++) {
            p = p * x;
        }
        return p;
    }

    /**
     * This function calculates the natural logarithm . ln(y).
     * @param y where n is any real number.
     * @return a float value for ln(y).
     * */
    private float naturalLog(float y){
        float sum = 0;
        float j = (y - 1) / (y + 1);
        for (int i = 1; i <= 999; i++) {
            float k = 2 * i - 1;
            sum += (1 / k) * (raiseTo(j,k));
        }
        return sum * 2;
    }

    /**
     * This function calculates the approximate number of years required to double the money over the given
     * Compound interest rate.
     * @param r Is a compound rate of interest that can be any real number between 1 to 100.
     * @return a float value of approximate years.
     * */
    public float ruleOf72(float r){
        float time = naturalLog(2)/(naturalLog(1+(r/100)));
        return time;
    }

    /**
     * An equal to operator simulating method to return the value of the expression given.
     * @return It returns a String containing the value of the expression.
     * @param expression, Its a validated expression that needs to be computed.
     * */
    public String equalOperator(String expression){
        String ANS = "";
        String[] exp = expression.split(" ");
        if(Float.parseFloat(exp[1]) > 0 && Float.parseFloat(exp[1]) <= 100){
            ANS = Float.toString(ruleOf72(Float.parseFloat(exp[1])));
            history.put(expression,ANS);
        }else
            ANS = "-1";
        return ANS;
    }
}
