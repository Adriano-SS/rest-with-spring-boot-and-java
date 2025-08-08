package github.com.Adriano_SS.controllers.mathController;

import github.com.Adriano_SS.controllers.mathController.converters.StringToDouble;
import github.com.Adriano_SS.controllers.mathController.operations.SimpleOperations;
import github.com.Adriano_SS.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math") //endpoint = uri base
public class MathController {

    //http://localhost:8080/math/sum/3/4 -> path variable
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        return new SimpleOperations().sum(StringToDouble.convert(numberOne), StringToDouble.convert(numberTwo));
    }

    //http://localhost:8080/math/subtraction/3/4 -> path variable
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        return new SimpleOperations().subtraction(StringToDouble.convert(numberOne), StringToDouble.convert(numberTwo));
    }

    //http://localhost:8080/math/division/3/4 -> path variable
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        return new SimpleOperations().division(StringToDouble.convert(numberOne), StringToDouble.convert(numberTwo));
    }

    //http://localhost:8080/math/multiplication/3/4 -> path variable
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        return new SimpleOperations().multiplication(StringToDouble.convert(numberOne), StringToDouble.convert(numberTwo));
    }

    //http://localhost:8080/math/mean/3/4 -> path variable
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        return new SimpleOperations().mean(StringToDouble.convert(numberOne), StringToDouble.convert(numberTwo));
    }

    //http://localhost:8080/math/square-root/3/4 -> path variable
    @RequestMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) {
        return new SimpleOperations().squareRoot(StringToDouble.convert(number));
    }
}
