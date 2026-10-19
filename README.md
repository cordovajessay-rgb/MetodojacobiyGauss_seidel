# MetodojacobiyGauss_seidel
Este código implementa el Método Iterativo de Jacobi en el lenguaje Java para resolver un sistema de ecuaciones lineales de la forma \(Ax = b\). El programa calcula de manera progresiva una solución aproximada basándose en un vector inicial, deteniéndose cuando cumple con una tolerancia de error o alcanza un límite de iteraciones
#Estructura General del Código
El código está organizado dentro de la clase MetodoJacobi y se compone de dos métodos principales:
* resolver: Ejecuta el algoritmo iterativo de Jacobi, este método recibe la matriz de coeficientes (A), el vector de términos independientes (b), la aproximación inicial (xD), la tolerancia al error (tol) y el número máximo de iteraciones (maxIter).
* Inicialización: Clona el vector inicial para no modificar el original y crea un vector temporal llamado xNuevo para almacenar los cálculos de la iteración actual.
* Ciclo Principal (for de variable k): Controla las iteraciones globales del método hasta un máximo de maxIter.
* Cálculo de Variables:
	• Para cada fila i, calcula la sumatoria de los productos A[i][j]x[j] excluyendo los elementos de la diagonal principal (j=i).
	• Aplica la fórmula de despeje de Jacobi:
  xNuevo[i]=b[i]-suma/A[i][i].
* Criterio de Parada: Al finalizar cada iteración, llama a calcularError. Si el error es menor que la tolerancia (tol), el método termina anticipadamente y devuelve xNuevo.
* Actualización: Si no se cumple la tolerancia, actualiza el vector x clonando xNuevo para la siguiente iteración.
* calcularError: Mide la diferencia entre iteraciones consecutiva
* Calcula el error máximo absoluto (también conocido matemáticamente como la norma infinito , entre el vector de la iteración anterior y el nuevo.
* Compara componente por componente la diferencia absoluta: xNuevo[i] - xAnterior[i].
* Devuelve el valor de la diferencia más grande encontrada.
 #codigo de la clase principal
*Este código implementa el método numérico de Gauss-Seidel para resolver un sistema de ecuaciones lineales de la forma (Ax = b).
* Parámetros de Entrada:
• A: Matriz de coeficientes del sistema.
• b: Vector de términos independientes.
• xInicial: Vector con la aproximación inicial para las incógnitas.
• tol: Tolerancia máxima permitida para el error de convergencia.
• maxIter: Número máximo de iteraciones permitidas para evitar un bucle infinito.
*Inicialización: Obtiene la dimensión del sistema (n) y crea un clon de las aproximaciones iniciales en el vector x.
*Bucle de Iteraciones Principal: Ejecuta un ciclo iterativo hasta alcanzar maxIter. Al inicio de cada iteración, respalda el vector actual en xAnt para calcular el error más adelante.
* Cálculo de Incógnitas (Bucle i y j):
	• Para cada fila i, inicializa una variable suma con el valor de b[i].
	• Resta los productos de los elementos de la matriz A[i][j] por los valores actuales de las incógnitas x[j] (siempre que (j = i).
	• Actualización inmediata: Calcula el nuevo valor de x[i] dividiendo la suma acumulada entre el elemento de la diagonal principal A[i][i]. Al usar x[j] directamente en la misma iteración, aprovecha los valores ya actualizados en lugar de los del ciclo anterior.
  *Criterio de Parada: Utiliza una función externa (MetodoJacobi.calcularError) para medir la diferencia entre el vector anterior (xAnt) y el actual (x). Si este error es menor que la tolerancia (tol), detiene el proceso y devuelve la solución aproximada x.
  #DEFMATRIZ
*DefMatriz encargada de inicializar y proporcionar los datos numéricos (matriz y vectores) necesarios para resolver un sistema de ecuaciones lineales.
código se divide en tres métodos estáticos que devuelven los siguientes datos:
* obtenerMatrizA(): Devuelve una matriz bidimensional de 3×3 que representa los coeficientes de las variables en el sistema
*Es una matriz diagonalmente dominante, lo cual garantiza que el método de Gauss-Seidel convergerá a una solución
* obtenerVectorB(): Devuelve un vector unidimensional con los términos independientes del sistema.
* obtenerVectorX0(): Devuelve el vector de aproximación inicial con valores en cero para comenzar las iteraciones del algoritmo.

  

• Detectar posibles errores o fallas de lógica (como la división por cero en la diagonal).
• Modificar el código para calcular el error de forma nativa sin depender de otra clase.
• Traducir este algoritmo a otro lenguaje como Python, C++ o MATLAB.
