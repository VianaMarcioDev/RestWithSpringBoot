package br.com.zup;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

   @RequestMapping(value = "/sum/numberOne/numberTwo", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new Exception();
        }
        Double sum = convertToDouble (numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    private double convertToDouble(String numberTwo){
        return 1D;
    }

    private boolean isNumeric(String number) {
        return false;
    }
}
