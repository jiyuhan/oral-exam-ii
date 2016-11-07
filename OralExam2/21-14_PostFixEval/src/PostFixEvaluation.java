/**
 * Created by thomas on 10/29/16.
 */

public class PostFixEvaluation {

    private String postfixExpression;

    public PostFixEvaluation(String postfix){
        this.postfixExpression = postfix;
    }

    public int evaluatePostfixExpression() {
        int result = 0;
        StackInheritance<Integer> numberStack = new StackInheritance<>();
        int expressionLength = this.postfixExpression.length();
        char[] postfixExpressionCharArray = new char[expressionLength];
        int tempInt = 0;

        for(int i = 0; i < expressionLength; i++)
            postfixExpressionCharArray[i] = postfixExpression.charAt(i);

        for(int i = 0; i < expressionLength; i++) {
            if(postfixExpressionCharArray[i] == ')') break; // it stops if we run into a ')'
            else if(postfixExpressionCharArray[i] == ' ') {
                if(tempInt != 0) {
                    numberStack.push(tempInt);
                    System.out.format("\tnumber pushed: %d%n", tempInt);
                    tempInt = 0;
                }
            }
            else if(Character.isDigit(postfixExpressionCharArray[i])) {
                if(tempInt != 0) {
                    tempInt = tempInt * 10 + (Character.getNumericValue(postfixExpressionCharArray[i]));
                }
                else {
                    tempInt = Character.getNumericValue(postfixExpressionCharArray[i]);
                    System.out.format("\tnumber read: %d%n", tempInt);
                }
            }
            else {
                System.out.format("operator %c encountered... %n", postfixExpressionCharArray[i]);
                int operandA = numberStack.pop();
                System.out.format("\tnumber popped: %d%n", operandA);
                int operandB = numberStack.pop();
                System.out.format("\tnumber popped: %d%n", operandB);
                result = calculate(operandA, operandB, postfixExpressionCharArray[i]);
                System.out.format("calculated result with %c: %d%n", postfixExpressionCharArray[i], result);
                numberStack.push(result);

                System.out.format("\tnumber pushed: %d%n", result);
            }
        }

        result = numberStack.pop();
        return result;
    }

    /**
     *
     * @param op1       This one gets popped second
     * @param op2       This one gets popped first
     * @param operator  This one is gotten from the expression
     * @return          it returns the result of the expression
     */
    public int calculate(int op1, int op2, char operator) {
        int result = 0;

        switch(operator) {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op2 - op1; // op1 gets popped first, op2 gets popped second
                break;
            case '*':
                result = op1 * op2;
                break;
            case '/':
                result = op2 / op1; // op1 gets popped first, op2 gets popped second
                break;
            case '^':
                result = op2 ^ op1; // op1 gets popped first, op2 gets popped second
                break;
            case '%':
                result = op2 % op1;
                break;
        }
        return result;
    }
    public static void main(String[] args) {


        PostFixEvaluation postFixEvaluation1 = new PostFixEvaluation("6 2 + 5 * 8 4 / -)");
        System.out.printf("The result is: %d", postFixEvaluation1.evaluatePostfixExpression());



    }

}
