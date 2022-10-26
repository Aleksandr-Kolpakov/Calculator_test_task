class DataVerification {

    String input;
    static String[] array;

    //--------------------------------------------------------------------

    DataVerification(String input) throws ExecutionErrors {
        this.input = input;
        array = input.split("\\s");

        checkExpressionLength();
    }


    public static String[] getArray() {
        return array;
    }


    //----------------------------------------------------------------------------------

    static void checkExpressionLength() throws ExecutionErrors {
        if ((getArray().length) == 3) {
            checkOperatorCompliance();
        } else if ((getArray().length) < 3) {
            throw new ExecutionErrors(ExecutionErrors.isNotMathOperation);
        } else {
            throw new ExecutionErrors(ExecutionErrors.invalidFormat);
        }
    }

    //----------------------------------------------------------------------------------

    static void checkOperatorCompliance() throws ExecutionErrors {
        if (checkOperator(getArray()[1])) {
            checkOperandType();
        } else {
            throw new ExecutionErrors(ExecutionErrors.isNotMathOperation);
        }
    }

    //----------------------------------------------------------------------------------

    static void checkOperandType() throws ExecutionErrors {
        if (checkOperandIsNumber(getArray()[0]) && checkOperandIsNumber(getArray()[2])) {
            Calculator.setValue(getOperand(getArray()[0]), getOperand(getArray()[2]), getArray()[1]);
        } else if (checkRomanNumbers(getArray()[0]) && checkRomanNumbers(getArray()[2])) {
            Calculator.setValue(String.valueOf(getArray()[0]), String.valueOf(getArray()[2]), getArray()[1]);
        } else {
            throw new ExecutionErrors(ExecutionErrors.differentNumberSystemsUsed);
        }
    }


    //----------------------------------------------------

    public static boolean checkOperator(String operator) {
        return switch (operator) {
            case "+", "-", "*", "/" -> true;
            default -> false;
        };
    }

    //----------------------------------------------------

    public static boolean checkOperandIsNumber(String operand) {
        try {
            Integer.parseInt(operand);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //----------------------------------------------------

    static int getOperand(String operand) {
        return Integer.parseInt(operand);
    }

    //----------------------------------------------------

    public static boolean checkNumbersParameter(int a, int b) {
        return (a < 1 || a > 10 || b < 1 || b > 10);
    }

    //----------------------------------------------------

    public static boolean checkRomanNumbers(String str) {
        try {
            RomanNumbers.valueOf(str);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}



