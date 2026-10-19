public class MainJacobi {
    public static void main(String[] args) {
        // Cargamos la matriz y los vectores desde la clase externa
        double[][] A = DefMatriz.obtenerMatrizA();
        double[] b = DefMatriz.obtenerVectorB();
        double[] xD = DefMatriz.obtenerVectorXD();

        // Parametros de tolerancia y limite de iteraciones (la práctica pide tolerancia de 0.0001)
        double tol = 0.0001;
        int maxIter = 100;

        // Llamada al metodo resolver
        double[] solucion = MetodoJacobi.resolver(A, b, xD, tol, maxIter);

        // Imprimir el resultado final
        System.out.println("Solucion aproximada:");
        for (double val : solucion) {
            System.out.printf("[ %.5f ] ", val);
        }
        System.out.println();
    }

}


