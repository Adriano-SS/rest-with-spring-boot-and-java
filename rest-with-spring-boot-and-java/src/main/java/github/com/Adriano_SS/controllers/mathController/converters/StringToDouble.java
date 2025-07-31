package github.com.Adriano_SS.controllers.mathController.converters;

public class StringToDouble {
    public static Double convert(String strNumber) throws UnsupportedOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedOperationException("Please, set a number!");
        String strNumberUSA = strNumber.replace(",", ".");
        if (!strNumberUSA.matches("[-+]?[0-9]*\\.?[0-9]+")) throw new UnsupportedOperationException("Please, set a numeric value!");
        return Double.parseDouble(strNumberUSA);
    }
}
