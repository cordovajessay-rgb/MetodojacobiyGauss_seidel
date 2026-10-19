public class MainGeneral {
    public static void main(String[] args) {
        // 1. Definición del Sistema (Obtenido de DefMatriz)
        double[][] A = DefMatriz.obtenerMatrizA();
        double[] b = DefMatriz.obtenerVectorB();
        double[] xD = DefMatriz.obtenerVectorXD();

        double tol = 0.0001;
        int maxIter = 100;

        // 2. Ejecución Método de Jacobi
        double[] solJacobi = MetodoJacobi.resolver(A, b, xD, tol, maxIter);
        System.out.println("--- RESULTADO MÉTODO DE JACOBI ---");
        for (int i = 0; i < solJacobi.length; i++) {
            System.out.printf("x%d = %.5f\n", (i + 1), solJacobi[i]);
        }

        // 3. Ejecución Método de Gauss-Seidel
        double[] solGaussSeidel = GaussSeidelMetodo.gaussSeidel(A, b, xD, tol, maxIter);
        System.out.println("\n--- RESULTADO MÉTODO DE GAUSS-SEIDEL ---");
        for (int i = 0; i < solGaussSeidel.length; i++) {
            System.out.printf("x%d = %.5f\n", (i + 1), solGaussSeidel[i]);
        }
    }
}