# Trilateracion

La triletaracion consiste en hallar la posicion de un objetivo teniendo en cuenta su posicion relativa a 3 puntos de referencia, mediante los cuales se puede intersectar el punto objetivo. 

## Algoritmo

Para calcular la posicion de la nave enemiga se realiza el siguiente procedimiento.

### Paso 1
Se toman dos Satelites como referencia. Para esto, se cambia el sistema de coordenadas para que el origen se encuentre en el primer satelite. 
Satelite1 => $Centro(h1, k1)$
Satelite2 => $Centro(h2, k2)$
Para esto la nueva posicion del primer satelite es $(0,0)$
La nueva posicion del segundo satelite es $(h2-h1, k2-k1)$

### Paso 2
Ahora se procede a rotar el sistema de coordenadas para que el segundo satelite se encuentre sobre el eje X.

Ahora la nueva posicion del satelite 2 es $(r cos(\alpha-\theta), r sin(\alpha-\theta))$
Donde, 
$(r,\alpha)$ => son las coordenadas polares de la posicion del satelite,
$\theta$ => El angulo de rotación del sistema de coordenadas. Para este caso particular $\theta = \alpha$.

### Paso 3
Una vez están alineados sobre el eje X se procede a calcular la intersección de los circulos en el eje X.
Para esto se aplica la fórmula
$x = \frac{h_3^2-r_2^2+r_1^2}{2h_3}$
Donde, 
$h_3$, es la posicion en el eje X del satelite 2 trasladado y rotado.
$r_2$, es la distancia medida del satelite 2 hasta el punto objetivo.
$r_1$, es la distancia medida del satelite 1 hasta el punto objetivo.

### Paso 4
Con el valor de $x$ hallado, se procede a calcular $y$. 
Se puede obtener dos posibles resultados, de acuerdo a la siguiente fórmula
$y_1 = \sqrt{r_1^2 - x^2}$
$y_2= -\sqrt{r_1^2 - x^2}$

### Paso 5
Se obtiene dos puntos posibles de solucion
$(x, y_1)$ o $(x, y_2)$

### Paso 6
Se realizan los pasos 1 a 5 con los satelites 1 y 3 para obtener los puntos solucion entre estos dos
$(x_1, y_3)$ o $(x_1, y_4)$

### Paso 7
Se comparan los 4 puntos solucion obtenidos en los pasos 5 y 6, si se encuentran al menos dos iguales entonces será el resultado de la trilateración. Si no se encuentra un par de puntos iguales entonces no tiene solución.