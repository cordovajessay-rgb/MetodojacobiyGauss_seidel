public class GaussSeidelMetodo {

    public static double[] gaussSeidel(double[][] A, double[] b, double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone();

        // Un solo vector que evoluciona al instante
        for (int iter = 0; iter < maxIter; iter++) {
            double[] xAnt = x.clone(); // Respaldamos el estado anterior para el error

            for (int i = 0; i < n; i++) {
                double suma = b[i]; // Arranca con el término independiente b_i

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        // Resta los términos con los valores ya actualizados de la iteración actual
                        suma -= A[i][j] * x[j];
                    }
                }

                // Despeje y actualización inmediata de la incógnita
                x[i] = suma / A[i][i];
            }

            // Criterio de convergencia usando la tolerancia establecida
            if (MetodoJacobi.calcularError(xAnt, x) < tol) {
                return x;
            }
        }
        return x;
    }
}