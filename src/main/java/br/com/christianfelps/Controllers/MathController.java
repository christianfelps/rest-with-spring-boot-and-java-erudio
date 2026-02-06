package br.com.christianfelps.Controllers;


import br.com.christianfelps.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.christianfelps.request.converters.NumberConverter.convertToDouble;
import static br.com.christianfelps.request.converters.NumberConverter.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

 private SimpleMath simpleMath = new SimpleMath();

    // Requisição Soma
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        isNumeric(numberOne); isNumeric(numberTwo);
        return simpleMath.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // Requisição Subtração
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        isNumeric(numberOne); isNumeric(numberTwo);
        return simpleMath.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // Requisição Multiplicação
    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        isNumeric(numberOne); isNumeric(numberTwo);
        return simpleMath.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // Requisição divisão
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        isNumeric(numberOne); isNumeric(numberTwo);
        return simpleMath.division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // Requisição Meida
    @RequestMapping("/media/{numberOne}/{numberTwo}")
    public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        isNumeric(numberOne); isNumeric(numberTwo);
        return simpleMath.media(convertToDouble(numberOne), convertToDouble(numberTwo));
    }
    // Requisição Raiz Quadrada
    @RequestMapping("/sqroot/{numberOne}")
    public Double sqRoot(@PathVariable("numberOne") String numberOne) throws Exception {
        isNumeric(numberOne);
        return simpleMath.sqRoot(convertToDouble(numberOne));
    }
        // Square Root in for
        /*for (double i = 1; i <= convetedNumber ; i++) {
            if( i * i == convetedNumber) return i;
        }*/






}
