class ExecutionErrors extends Exception {
    public ExecutionErrors (String message) {
        super (message);
    }

    static String startMessage = "Введите математическое выражение в формате: 2 + 1 (арабскими цифрами) или V * VII (римскими цифрами)";
    static String repeatMessage = "Попробуйте еще раз. Калькулятор принимает на вход числа от 1 до 10.";
    static String negativeNumbersInRoman = "В римской системе нет отрицательных чисел";
    static String differentNumberSystemsUsed = "Недопустимо использовать разные системы счисления";
    static String isNotMathOperation = "Введенная строка не является математической операцией";
    static String invalidFormat = "Формат выражения не соответсвует условию задачи: Два операнда и один оператор";
}