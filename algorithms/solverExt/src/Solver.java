import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) )
 * ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * 1 + ( 2 + 3 ) * 4 * 5 = 101
 * 1 + 5 * 4 * 5 = 101
 * 1 + 5 * 20 = 101
 * 1 + 100 = 101
 * 20 / 4 = 5
 * (101 - 1) / 5 = 20
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN   = '(';
    private static final char RIGHT_PAREN  = ')';
    private static final char PLUS         = '+';
    private static final char MINUS        = '-';
    private static final char TIMES        = '*';
    private static final char DIVISION     = '/';
    private static int i = 0;

    private static int getUnar(String[] values) {
        i++;
        if (values[i-1].equals("("))
            return getExpression(values);
        return Integer.parseInt(values[i-1]);
    }

    private static int getTerm(String[] values) {
        int leftOperand = getUnar(values);
        while ((i<values.length) && (values[i].equals("*") || values[i].equals("/"))) {
            int q = i;
            i++;
            int rightOperand = getUnar(values);
            if (values[q].equals("*"))
                leftOperand *= rightOperand;
            else
                leftOperand /= rightOperand;
        }
        return leftOperand;
    }

    private static int getExpression(String[] values) {
        int leftOperand = getTerm(values);
        while ((i<values.length) && (values[i].equals("+") || values[i].equals("-"))) {
            int q = i;
            i++;
            int rightOperand = getTerm(values);
            if (values[q].equals("+"))
                leftOperand += rightOperand;
            else
                leftOperand -= rightOperand;
            if (i<values.length && values[i].equals(")")) {
                i++;
                return leftOperand;
            }
        }
        return leftOperand;
    }

    private static double evaluate(String[] values) {
        return getExpression(values);
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(evaluate(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
