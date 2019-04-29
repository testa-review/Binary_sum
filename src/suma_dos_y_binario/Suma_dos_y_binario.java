/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suma_dos_y_binario;

/**
 *
 * @author sergio
 */
public class Suma_dos_y_binario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        solution("9999", "101");
    }

    public static String solution(String S, String T) {
        // write your code in Java SE 8
        String res = "";

        // int a binario
        String binS = binario(S);
        String binT = binario(T);

        //suma de binarios
        suma(binS, binT);

        return res;
    }

    private static String suma(String x, String y) {
        String res = "";
        String n = "";
        String m = "";

        //System.out.println("longitudes x & y: "+x.length() +" y "+y.length());
        if (x.length() < y.length()) {
            n = x;
            m = y;
        } else {
            n = y;
            m = x;
        }

        int longitud = m.length() - n.length();

        for (int i = 0; i < longitud; i++) {
            n = "0" + n;
        }

        //System.out.println("longitudes n & m: "+n +" y "+m);
        int precalc = 0;
        int lleva = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            precalc = Character.getNumericValue(n.charAt(i)) + Character.getNumericValue(m.charAt(i));
            System.out.println("PRECAL=" + precalc + " && LLEVA=" + lleva + ".");
            if (precalc == 2 && lleva == 0) {
                res = "0" + res;
                lleva = 1;
                System.out.println("caso 1");
            } else if (precalc == 2 && lleva == 1) {
                res = "1" + res;
                lleva = 1;
                System.out.println("caso 2");
            } else if (precalc == 1 && lleva == 0) {
                res = "1" + res;
                lleva = 0;
                System.out.println("caso 3");
            } else if (precalc == 1 && lleva == 1) {
                res = "0" + res;
                lleva = 1;
                System.out.println("caso 4");
            } else if (precalc == 0 && lleva == 0) {
                res = "0" + res;
                lleva = 0;
                System.out.println("caso 5");
            } else if (precalc == 0 && lleva == 1) {
                res = "1" + res;
                lleva = 0;
                System.out.println("caso 6");
            } else { // caso cuando es == 2 y lleva == 1
                System.out.println("caso default; con lleva = " + lleva);
                res = "5";
                System.out.println("caso 6 default");
            }

            System.out.println("FIN PROCESO: " + res.charAt(0) + " LLEVA:" + lleva);
        }
        if (lleva == 1) {
            res = "1" + res;
        }

        System.out.println("\n"+"TOTAL : " + res);
        return res;
    }

    private static String binario(String n) {

        int numero = Integer.parseInt(n);
        String total = "";

        while (numero > 0) {
            if (numero % 2 == 0) {

                numero = numero / 2;
                total = "0" + total;
            } else {
                numero = (numero - 1) / 2;
                total = "1" + total;
            }
        }

        System.out.println("/n"+"binario string " + n + " " + total);
        return total;
    }

}
