# Minimización de Autómatas Finitos Deterministas (AFD)  
*(Kozen, 1997 – Lecture 14)*

## Descripción
Este proyecto implementa la **minimización de autómatas finitos deterministas (AFD)** utilizando el algoritmo de **refinamiento de particiones**, descrito en *Kozen, 1997 – Lecture 14*.  

El programa toma la descripción de uno o varios autómatas, identifica los estados equivalentes y muestra los pares de estados indistinguibles en **orden lexicográfico**.

---

## ⚙️ Características
- Lectura de múltiples AFD a través de la entrada estándar.  
- Soporte para alfabetos de cualquier tamaño.  
- Implementación del algoritmo de **refinamiento iterativo de clases de equivalencia**.  
- Salida con los pares de estados equivalentes en el formato requerido: (i, j) (x, y) ...

donde cada línea corresponde a un caso de prueba.

---

## Formato de Entrada
1. Número de casos de prueba `c`.  
2. Para cada AFD:  
 - Número de estados `n`.  
 - Símbolos del alfabeto separados por espacio.  
 - Conjunto de estados finales separados por espacio.  
 - Tabla de transiciones con `n` filas (una por cada estado).  

---

##  Formato de Salida
- Para cada caso, se imprimen todos los **pares de estados equivalentes** en orden lexicográfico.  
- Cada par se representa como `(i, j)`.  
- Los pares se separan por un espacio.  
- Cada línea de salida corresponde a un AFD.  

---

##  Ejemplo de Ejecución

### Entrada
- 4
- 6
- a b
- 1 2 5
- 0 1 2
- 1 3 4
- 2 4 3
- 3 5 5
- 4 5 5
- 5 5 5
- 6
- a b
- 3 4 5
- 0 1 2
- 1 3 4
- 2 4 3
- 3 5 5
- 4 5 5
- 5 5 5
- 6
- a
- 1 4
- 0 1
- 1 2
- 2 3
- 3 4
- 4 5
- 5 0
- 4

### Salida esperada

- (1, 2) (3, 4)
- (1, 2) (3, 4) (3, 5) (4, 5)
- (0, 3) (1, 4) (2, 5)
- (0, 1)


---

##  Ejecución

### En Java
Compilar:
```bash
javac Main.java
```
## Referencia

D. Kozen, Automata and Computability, Lecture 14, 1997.

## Autores
- Emmanuel Castaño Sepúlveda
- Jerónimo Conteras Sierra

## Clase 
Adolfo Ándres Castro Sánchez
5465 - Lenguajes Formales

