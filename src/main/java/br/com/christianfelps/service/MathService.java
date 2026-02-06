package br.com.christianfelps.service;

import br.com.christianfelps.exception.UnsupportedMathOperationException;

public class MathService {

    public void validationIsNumeric(String numberOne, String numberTwo){
        validationIsNumeric(numberOne);
        validationIsNumeric(numberTwo);
    }
    public void validationIsNumeric(String numberOne){
        if(!isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
    }

    public static double convertToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
