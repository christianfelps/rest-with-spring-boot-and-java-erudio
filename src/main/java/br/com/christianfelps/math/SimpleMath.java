package br.com.christianfelps.math;


public class SimpleMath {

    // Requisição Soma
    public Double sum( double numberOne, double numberTwo) {
        return (numberOne) + (numberTwo);
    }

    // Requisição Subtração
    public Double subtraction( double numberOne, double numberTwo) {
        return (numberOne) - (numberTwo);
    }

    // Requisição Multiplicação
    
    public Double multiplication( double numberOne, double numberTwo) {
        return (numberOne) * (numberTwo);
    }

    // Requisição divisão
    public Double division( double numberOne, double numberTwo) {
        
        return (numberOne) / (numberTwo);
    }

    // Requisição Meida
    public Double media( double numberOne, double numberTwo) {
        
        return ((numberOne) + (numberTwo))/2;
    }
    // Requisição Raiz Quadrada
    public Double sqRoot( double numberOne)  {
        return Math.sqrt((numberOne));
    }
    // Square Root in for
        /*for (double i = 1; i <= convetedNumber ; i++) {
            if( i * i == convetedNumber) return i;
        }*/
}
