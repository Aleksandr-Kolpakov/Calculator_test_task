class Calculator {

    static String operator;
    static int preResult;
    static String result;
    static DataVerification dv;

    Calculator(String input) throws ExecutionErrors {
        dv = new DataVerification(input);
    }


    public static void setValue(int x, int y, String op) throws ExecutionErrors {
        operator = op;

        if (!DataVerification.checkNumbersParameter(x, y)) {
            preResult = calculate(x, y);
            result = String.valueOf(preResult);
        } else {
            throw new ExecutionErrors(ExecutionErrors.repeatMessage);
        }
    }



    public static void setValue(String x, String y, String op) throws ExecutionErrors {
        operator = op;
        int preResult;
        int a = RomanNumbers.changeNumberSystem(x);
        int b = RomanNumbers.changeNumberSystem(y);

        if (!DataVerification.checkNumbersParameter(a, b)) {
            preResult = calculate(a, b);

            if (preResult <= 0) {
                throw new ExecutionErrors(ExecutionErrors.negativeNumbersInRoman);
            }

            result = String.valueOf(RomanNumbers.getResultInRomanNumber(preResult));

        } else {
            throw new ExecutionErrors(ExecutionErrors.repeatMessage);
        }
    }




    static int calculate(int x, int y) {
        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> 0;
        };
    }


    String getResult() {
        return String.valueOf(result);
    }

}

