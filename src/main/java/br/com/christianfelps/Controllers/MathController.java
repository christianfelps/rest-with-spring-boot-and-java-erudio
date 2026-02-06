package br.com.christianfelps.Controllers;

import br.com.christianfelps.service.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.christianfelps.service.MathService.convertToDouble;

@RestController
@RequestMapping("/math")
public class MathController {
    MathService mathService;

    // Requisição Soma
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        mathService.validationIsNumeric(numberOne, numberTwo);
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    // Requisição Subtração
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        mathService.validationIsNumeric(numberOne, numberTwo);
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // Requisição Multiplicação
    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        mathService.validationIsNumeric(numberOne, numberTwo);
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // Requisição divisão
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        mathService.validationIsNumeric(numberOne, numberTwo);
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    // Requisição Meida
    @RequestMapping("/media/{numberOne}/{numberTwo}")
    public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
        mathService.validationIsNumeric(numberOne, numberTwo);
        return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
    }
    // Requisição Raiz Quadrada
    @RequestMapping("/sqroot/{numberOne}")
    public Double sqRoot(@PathVariable("numberOne") String numberOne) throws Exception {
        mathService.validationIsNumeric(numberOne);
        return Math.sqrt(convertToDouble(numberOne));
    }
        // Square Root in for
        /*for (double i = 1; i <= convetedNumber ; i++) {
            if( i * i == convetedNumber) return i;
        }*/






}
