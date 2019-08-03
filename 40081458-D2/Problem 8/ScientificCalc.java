public class ScientificCalc extends Calculator {


    /**
     * This function calculates the logarithm to the base 10. log_10(n).
     * @param n where n is any real number.
     * @return a float value for log_10(n).
     * */
    public float log10(float n){
        float value = naturalLog(n);
        float base = naturalLog(10);
        float result = value / base;
        return result;
    }

    /**
     * This function calculates exponent. x^y (x raised to y).
     * @param x is any real number.
     * @param y is any real number.
     * @return a float value of x raised to y.
     * */
    public float raiseTo(float x,float y){
        float p = 1;
        for (int i = 1; i <= y; i++) {
            p = p * x;
        }
        return p;
    }

    /**
     * This function calculates the natural logarithm . ln(x).
     * @param x where n is any real number.
     * @return a float value for ln(x).
     * */
    public float naturalLog(float x){
        float sum = 0;
        float j = (x - 1) / (x + 1);
        for (int i = 1; i <= 999; i++) {
            float k = 2 * i - 1;
            sum += (1 / k) * (raiseTo(j,k));
        }
        return sum * 2;
    }

    /**
     * An equal to operator simulating method to return the value of the expression given.
     * @return It returns a String containing the value of the expression.
     * @param expression, Its a validated expression that needs to be computed.
     * */
    public String equalOperator(String expression){
        String ANS = "";
        String[] exp = expression.split(" ");
        if(exp.length == 2){
            switch (exp[0]){
                case "ln":
                    ANS = Float.toString(naturalLog(Float.parseFloat(exp[1])));
                    break;
                case "log":
                    ANS = Float.toString(log10(Float.parseFloat(exp[1])));
                    break;
            }
        }
        else
            ANS = Float.toString(raiseTo(Float.parseFloat(exp[0]),Float.parseFloat(exp[2])));
        history.put(expression,ANS);
        return ANS;
    }
}
