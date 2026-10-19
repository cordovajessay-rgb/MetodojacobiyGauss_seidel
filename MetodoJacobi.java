public class MetodoJacobi {

    /**
     * Resuelve un sistema de ecuaciones lineales Ax = b mediante el método iterativo de Jacobi.
     *
     * @param A     Matriz de coeficientes (cuadrada)
     * @param b     Vector de términos independientes
     * @param xD    Vector de aproximacion inicial
     * @param tol   Tolerancia a error máximo permisivo
     * @param maxIter Numero maximo de iteraciones
     * @return       Vector con la solución aproximada
     */
    public static double[] resolver(double[][] A, double[] b, double[] xD, double tol, int maxIter) {
        int n = b.length;
        double[] x = xD.clone();
        double[] xNuevo = new double[n];

        // Ciclo principal de iteracion
        for (int k = 0; k < maxIter; k++) {

            // Calcula cada variable para la nueva iteracion
            for (int i = 0; i < n; i++) { // cada fila
                double suma = 0.0; // Tenemos que resetear la suma de cada fila

                // Sumatoria de los términos A[i][j] * x[j] excluyendo la diagonal (j != i)
                for (int j = 0; j < n; j++) { // <--- CORREGIDO: ahora usa j < n y j++
                    if (j != i) { // <--- CORREGIDO: ahora compara j != i
                        suma += A[i][j] * x[j];
                    }
                }

                // Formula de despeje de jacobi: (b[i] - suma) / A[i][i]
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            // 1. Verificamos si ya se cumplio la tolerancia de error para detenernos
            if (calcularError(x, xNuevo) < tol) {
                return xNuevo;
            }

            // 2. Si no se cumple, actualizamos el vector x para la siguiente iteracion
            x = xNuevo.clone();
        }

        return xNuevo;
    }

    /**
     * Calcula el error maximo absoluto entre dos vectores (Norma infinito)
     */
    public static double calcularError(double[] xAnt, double[] xNuevo) {
        double max = 0.0;
        for (int i = 0; i < xAnt.length; i++) {
            max = Math.max(max, Math.abs(xNuevo[i] - xAnt[i]));
        }
        return max;
    }

}