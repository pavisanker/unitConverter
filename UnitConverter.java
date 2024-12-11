

import java.util.Scanner;

public class UnitConverter {

    public static void main(String[] args) {
        UnitConverter converter = new UnitConverter(); // Create an instance
        converter.run(); // Call the main logic
    }

    public void run() {
        int option;

        System.out.println("\n\t\tUnit Converter\n");
        System.out.println("1. Length Conversion");
        System.out.println("2. Weight Conversion\n");
        System.out.print("Enter your choice: ");

        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();

        switch (option) {
            case 1:
            System.out.println("\n\t\tLength Unit Converter\n");
            Length lengthConverter = new Length();
                lengthConverter.display();
                break;
            case 2:
             System.out.println("\n\t\tWeight Unit Converter\n");
                Weight weightConverter = new Weight();
                weightConverter.display();
                break;
            default:
                System.out.println("\nInvalid option!\n");
                break;
        }
        
        sc.close();

    }

    // Nested class to hold separated number and unit
    class SeparatedValue {
        String number;
        String unit;

        public SeparatedValue(String number, String unit) {
            this.number = number;
            this.unit = unit;
        }

        public SeparatedValue separator(String num) {
            StringBuilder numericPart = new StringBuilder();
            StringBuilder stringPart = new StringBuilder();

            for (char ch : num.toCharArray()) {
                if (Character.isDigit(ch) || ch == '.') { // Handle decimal numbers
                    numericPart.append(ch);
                } else {
                    stringPart.append(ch);
                }
            }

            return new SeparatedValue(numericPart.toString(), stringPart.toString());
        }
    }

    // Subclass for Length conversion
    class Length {
        double[][] lengtharray = {
                {1, 0.1, 0.001, 0.000001, 0.03937, 0.003281, 0.001094, 0.000000621371192},
                {10, 1, 0.01, 0.00001, 0.393701, 0.032808, 0.010936, 0.00000621371192},
                {1000, 100, 1, 0.001, 39.37008, 3.28084, 1.093613, 0.000621371192},
                {1000000, 100000, 1000, 1, 39370.08, 3280.84, 1093.613, 0.621371192},
                {25.4, 2.54, 0.0254, 0.0000254, 1, 0.083333, 0.027778, 0.00001578283},
                {304.8, 30.48, 0.3048, 0.0003048, 12, 1, 0.333333, 0.0001893939},
                {914.4, 91.44, 0.9144, 0.0009144, 36, 3, 1, 0.0005681818},
                {1609344, 160934.4, 1609.344, 1.609344, 63360, 5280, 1760, 1}};
        String[][] unitarray = {
                {"mmmmmm", "mmcmcm", "mmmm", "mmkmkm", "mminin", "mmftft", "mmydyd", "mmmimi"},
                {"cmmmmm", "cmcmcm", "cmmm", "cmkmkm", "cminin", "cmftft", "cmydyd", "cmmimi"},
                {"mmmmm", "mcmcm", "mmm", "mkmkm", "minin", "mftft", "mydyd", "mmimi"},
                {"kmmmmm", "kmcmcm", "kmmm", "kmkmkm", "kminin", "kmftft", "kmydyd", "kmmimi"},
                {"inmmmm", "incmcm", "inmm", "inkmkm", "ininin", "inftft", "inydyd", "inmimi"},
                {"ftmmmm", "ftcmcm", "ftmm", "ftkmkm", "ftinin", "ftftft", "ftydyd", "ftmimi"},
                {"ydmmmm", "ydcmcm", "ydmm", "ydkmkm", "ydinin", "ydftft", "ydydyd", "ydmimi"},
                {"mimmmm", "micmcm", "mimm", "mikmkm", "miinin", "miftft", "miydyd", "mimimi"}};

        Scanner sc = new Scanner(System.in);

        public void display() {
            System.out.print("Enter the value with unit(cm/m/km/in/ft/yd/mi): ");
            String num = sc.next();
            SeparatedValue ob2 = new SeparatedValue(null, null).separator(num);

            String number = ob2.number;
            String unit = ob2.unit;

            System.out.print("Convert to unit(cm/m/km/in/ft/yd/mi): ");
            String unitc = sc.next();

            for (int i = 0; i < lengtharray.length; i++) {
                for (int j = 0; j < lengtharray[i].length; j++) {
                    if (unitarray[i][j].equals(unit + unitc + unitc)) {
                        System.out.println("\n>>>\t" + number + unit + " = " +
                                (Double.parseDouble(number) * lengtharray[i][j]) + unitc + "\n");
                        return;
                    }
                }
            }
            System.out.println("\nInvalid conversion.\n");
        }
    }

    // Subclass for Weight conversion
    class Weight {
        double[][] weightarray = {
            {1, 0.001, 0.000001, 0.000035274, 0.00000220462}, // mg to other units
            {1000, 1, 0.001, 0.035274, 0.00220462},           // g to other units
            {1000000, 1000, 1, 35.274, 2.20462},              // kg to other units
            {28349.5, 28.3495, 0.0283495, 1, 0.0625},         // oz to other units
            {453592, 453.592, 0.453592, 16, 1}                // lb to other units
        };
        
        String[][] unitarray = {
            {"mgmg", "mgg", "mgkg", "mgoz", "mglb"},          // mg to other units
            {"gmg", "gg", "gkg", "goz", "glb"},               // g to other units
            {"kgmg", "kgg", "kgkg", "kgoz", "kglb"},          // kg to other units
            {"ozmg", "ozg", "ozkg", "ozoz", "ozlb"},          // oz to other units
            {"lbmg", "lbg", "lbkg", "lboz", "lblb"}           // lb to other units
        };

        Scanner sc = new Scanner(System.in);

        public void display() {
            System.out.print("Enter the value with unit(kg/mg/g/oz/lb): ");
            String num = sc.next();
            SeparatedValue ob2 = new SeparatedValue(null, null).separator(num);

            String number = ob2.number;
            String unit = ob2.unit;

            System.out.print("Convert to unit(kg/mg/g/oz/lb): ");
            String unitc = sc.next();

            for (int i = 0; i < weightarray.length; i++) {
                for (int j = 0; j < weightarray[i].length; j++) {
                    if (unitarray[i][j].equals(unit + unitc)) {
                        System.out.println("\n>>>\t" + number + unit + " = " +
                                (Double.parseDouble(number) * weightarray[i][j]) + unitc + "\n");
                        return;
                    }
                }
            }
            System.out.println("\nInvalid conversion.\n");
            
            sc.close();

        }
    }
    
}


