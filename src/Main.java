public class Main {
    public static void main(String[] args) {

        String number1 = "4500225431034521337"; //Visa 19 digits
        String number2 = "3543165612310831077"; //JCB 19 digits
        String number3 = "4929129325971379"; //Visa 16 digits
        String number4 = "5421675037770723"; // Master Card 16 digits
        String number5 = "375806368248842"; // American Express 15 digits
        String number6 = "36086491453020"; // Diners Club - International 14 digits
        String number7 = "30303928854472"; // Diners Club - Carte Blanche 14 digits

        System.out.println(String.format("Result is %s", isValidCardNumber(number1) ? "OK" : "FAIL"));
        System.out.println(String.format("Result is %s", isValidCardNumber(number2) ? "OK" : "FAIL"));
        System.out.println(String.format("Result is %s", isValidCardNumber(number3) ? "OK" : "FAIL"));
        System.out.println(String.format("Result is %s", isValidCardNumber(number4) ? "OK" : "FAIL"));
        System.out.println(String.format("Result is %s", isValidCardNumber(number5) ? "OK" : "FAIL"));
        System.out.println(String.format("Result is %s", isValidCardNumber(number6) ? "OK" : "FAIL"));
        System.out.println(String.format("Result is %s", isValidCardNumber(number7) ? "OK" : "FAIL"));
    }

    public static boolean isValidCardNumber(String number) {
        if (number == null) {
            return false;
        }

        if (number.length() != 16) {
            return false;
        }

        long result = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit;
            try {
                digit = Integer.parseInt(number.charAt(i) + "");
            } catch (NumberFormatException e) {
                return false;
            }

            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            result += digit;
        }

        return (result != 0) && (result % 10 == 0);
    }
}