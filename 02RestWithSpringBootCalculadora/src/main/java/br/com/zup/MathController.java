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

    private double convertToDouble(String strNumber){
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
       if (strNumber == null) return false;
       String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\\\.?[0-9]+");
    }
}
