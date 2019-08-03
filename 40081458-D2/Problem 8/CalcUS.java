import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CalcUS {

    /**
     * This function is used to print the initial calculator selection menu.
     * */
    public static void printCalcType(){
        System.out.println("Please select which calculator you want ?");
        System.out.println("1) Basic Calculator") ;
        System.out.println("2) Scientific Calculator");
        System.out.println("3) Financial Calculator");
        System.out.println("Press q to quit.");
        System.out.println("Press h for history. \nPress c to clear history.\nPress ANS to get the previous answer\n");

    }

    /**
     * This function is used to validate the expression. It validates only binary operator which has two
     * operands.
     * @param exp is an expression that needs to be validated.
     * @return TRUE if the expression is valid, otherwise false.
     * */
    public static boolean validateExpB(String exp){
        String[] expSeg = exp.split(" ");
        if(expSeg.length == 3){
            if(expSeg[1].equals("+") || expSeg[1].equals("-") || expSeg[1].equals("*") || expSeg[1].equals("/") || expSeg[1].equals("%") || expSeg[1].equals("^")){
                try {
                    Float.parseFloat(expSeg[0]);
                    Float.parseFloat(expSeg[2]);
                    return true;
                } catch(NumberFormatException e){
                    return false;
                }
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * This function is used to validate the expression. It validates only unary operator which has only one
     * operand.
     * @param exp is an expression that needs to be validated.
     * @return TRUE if the expression is valid, otherwise false.
     * */
    public static boolean validateExpU(String exp){
        String[] expSeg = exp.split(" ");
        if(expSeg.length == 2){
            if(expSeg[0].equals("log") || expSeg[0].equals("ln") || expSeg[0].equals("R72")){
                try {
                    Float.parseFloat(expSeg[1]);
                    return true;
                } catch(NumberFormatException e){
                    return false;
                }
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * This function is used to print the Basic calculator menu.
     * */
    public static void printBasicMenu(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Basic Calculator");
        System.out.println("Please write expression in following form:");
        System.out.println("Operand<Space>Operator<Space>Operand");
        System.out.println("The Operand can be any real number.");
        System.out.println("Operator:");
        System.out.println("Addition +");
        System.out.println("Subtraction -");
        System.out.println("Multiplication *");
        System.out.println("Division /");
        System.out.println("Modulus %");
        System.out.println("ANS for previous answer");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Write an expression :");
    }

    /**
     * This function is used to print the Scientific calculator menu.
     * */
    public static void printScientificMenu(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Scientific Calculator.");
        System.out.println("Please write expression in following form for Binary operator:");
        System.out.println("Raise to :\nOperand<space>^<space>Operand");
        System.out.println("Please write expression in following form for Unary operator:");
        System.out.println("Operator<Space>Operand");
        System.out.println("Operator:");
        System.out.println("Logarithm(base 10): \nlog<Space>Operand");
        System.out.println("Natural log \nln<Space>Operand");
        System.out.println("The Operand can be any real number.");
        System.out.println("ANS for previous answer");
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * This function is used to print the Business calculator menu.
     * */
    public static void printBusinessMenu(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Financial Calculator");
        System.out.println("Please write expression in following form for Unary operator:");
        System.out.println("Rule of 72 :\nR72<space>RateOfInterest");
        System.out.println("The Operand can be any real number within 1 to 100.");
        System.out.println("ANS for previous answer");
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * This is main function that has control over all the activity.
     *
     * @param args is collection of command line arguments.
     * */
    public static void main(String[] args) {
        String ANS= "";
        //Print the welcome screen
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Welcome to CalcUS. \nYour friendly calculator.");
        System.out.println("---------------------------------------------------------------------");
        printCalcType();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Initiate calculators
        Calculator basic = new Calculator();
        ScientificCalc scientific = new ScientificCalc();
        BusinessCalc business = new BusinessCalc();

        try{
            String ch = br.readLine();
            String expression;
            //whi;e user does not press q, the loop iterates.
            while(!ch.equals("q")){
                //a switch case for various options and their corresponding activities.
                switch (ch){
                    case "1":
                        printBasicMenu();
                        expression = br.readLine();
                        if(validateExpB(expression)){
                            ANS = basic.equalOperator(expression);
                            System.out.printf("\nANS = %.2f \n",Float.parseFloat(ANS));
                        }else
                            System.out.println("Wrong format of expression! Please follow given format.");
                        break;
                    case "2":
                        printScientificMenu();
                        expression = br.readLine();
                        String[] exp = expression.split(" ");
                        if(exp.length == 2){
                            if(validateExpU(expression)){
                                ANS = scientific.equalOperator(expression);
                                System.out.printf("\nANS = %.6f \n",Float.parseFloat(ANS));
                            }else
                                System.out.println("Wrong format of expression! Please follow given format.");
                        }else if(exp.length == 3){
                            if(validateExpB(expression)){
                                ANS = scientific.equalOperator(expression);
                                System.out.println("ANS = " + ANS);
                            }else
                                System.out.println("Wrong format of expression! Please follow given format.");
                        }else
                            System.out.println("Wrong format of expression! Please follow given format.");
                        break;
                    case "3":
                        printBusinessMenu();
                        expression = br.readLine();
                        if(validateExpU(expression)){
                            ANS = business.equalOperator(expression);
                            System.out.printf("\nANS = %.4f \n",Float.parseFloat(ANS));
                            if(Float.parseFloat(ANS) == -1){
                                System.out.println("The Operand can be any real number within 1 to 100.");
                            }
                        }else
                            System.out.println("Wrong format of expression! Please follow given format.");
                        break;
                    case "c":
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Clearing History");
                        basic.clearHistory();
                        scientific.clearHistory();
                        business.clearHistory();
                        System.out.println("---------------------------------------------------------------------");
                        break;
                    case "h":
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("History:");
                        ArrayList<String> expressions = new ArrayList<>(basic.history.keySet());
                        ArrayList<String> answers = new ArrayList<>(basic.history.values());
                        for(int i = 0; i < expressions.size();i++)
                            System.out.println(expressions.get(i) + " = " + answers.get(i));
                        expressions = new ArrayList<>(scientific.history.keySet());
                        answers = new ArrayList<>(scientific.history.values());
                        for(int i = 0; i < expressions.size();i++)
                            System.out.println(expressions.get(i) + " = " + answers.get(i));
                        expressions = new ArrayList<>(business.history.keySet());
                        answers = new ArrayList<>(business.history.values());
                        for(int i = 0; i < expressions.size();i++)
                            System.out.println(expressions.get(i) + " = " + answers.get(i));
                        System.out.println("---------------------------------------------------------------------");
                        break;
                    case "ANS":
                        System.out.println("ANS = " + ANS);
                        break;
                    default:
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Wrong selection");
                        System.out.println("---------------------------------------------------------------------");
                }
                printCalcType();
                ch = br.readLine();
            }


        }catch(Exception e){
            System.out.println("Please enter valid numbers.");
        }
}
}
