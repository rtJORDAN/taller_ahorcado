# taller_ahorcado
taller número 5 de lógica de programación

## 📌 Descripción del Proyecto

Este proyecto consiste en el desarrollo del juego clásico **Ahorcado** utilizando el lenguaje **Java**.

Las palabras del juego se cargan desde un archivo **CSV**, organizadas por categorías, permitiendo que el sistema sea dinámico, escalable y fácil de mantener.

El objetivo del taller es aplicar conceptos fundamentales de programación como:

- Manejo de Strings
- Uso de métodos (funciones)
- Lectura de archivos (CSV)
- Arreglos y matrices
- Control de flujo
- Modularización del código

---

## ⚙️ Funcionalidades

- Selección de categorías
- Palabras cargadas desde archivo CSV
- Selección aleatoria de palabras
- Sistema de intentos (máximo 6 errores)
- Visualización del ahorcado con ASCII art
- Mostrar letras acertadas
- Validación de entradas del usuario
- Menú interactivo en consola
- Sistema de pistas
- Manejo de errores
- 🎁 Easter Egg oculto

---

## 🧱 Estructura del Proyecto

```
taller_ahorcado/
│
├── Main.java
├── Juego.java
├── CargadorCSV.java
├── ConsoleInput.java
├── palabras.csv
└── README.md
```

---

## 📂 Formato del Archivo CSV

El archivo `palabras.csv` debe tener el siguiente formato:

```
categoria,palabra,pista
ANIMALES,elefante,mamifero grande de orejas grandes
TECNOLOGIA,computador,dispositivo electronico
PAISES,colombia,pais suramericano
```

### 🔹 Requisitos del CSV

- Categorías obligatorias:
  - ANIMALES
  - TECNOLOGIA
  - PAISES
  - COLOMBIA
  - PROGRAMACION

- Mínimo:
  - 10 palabras por categoría
  - 50 palabras en total

---

## ▶️ Instrucciones de Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/taller_ahorcado.git
cd taller_ahorcado
```

### 2. Compilar el proyecto

```bash
javac *.java
```

### 3. Ejecutar el programa

```bash
java Main
```

---

## 🎮 Uso del Programa

El programa muestra un menú con las siguientes opciones:

1. Jugar
2. Ver instrucciones
3. Tabla de récords
4. Salir

### Flujo del juego

1. Seleccionar categoría
2. Elegir palabra aleatoria
3. Mostrar palabra oculta (_ _ _ _)
4. Ingresar letras
5. Validar aciertos o errores
6. Ganar o perder

---

## 🧠 Lógica del Juego

- El usuario ingresa una letra por turno
- Si acierta → se revela en la palabra
- Si falla → aumenta el contador de errores
- Con 6 errores → pierde
- Si completa la palabra → gana

---

## 🧩 Métodos Implementados

- `mostrarAhorcado(int errores)`
- `mostrarPalabra(char[] estado)`
- `validarLetra(char letra, String palabra, char[] estado)`
- `seleccionarPalabraAleatoria(String[] lista, int categoria)`
- `estaCompleta(char[] estado)`
- `verificarEasterEgg(String nombre)`

---

## 🎨 ASCII Art

El juego incluye diferentes estados del ahorcado según el número de errores (0 a 6).

---

## 🥚 Easter Egg (Bonus)

Si el jugador ingresa el nombre:

```
XACARANA
```

Se activa el modo especial:

- Se revela la primera letra automáticamente
- Se desbloquea una categoría secreta
- Se muestra un ASCII art especial

---

## 👥 Integrantes del Equipo

- Nombre 1
- Nombre 2
- Nombre 3

---

## 🔗 Recursos Utilizados

- https://www.w3schools.com/java/java_strings.asp
- https://www.w3schools.com/java/java_methods.asp
- https://www.baeldung.com/java-csv-file-array
- Material de clase
- ConsoleInput.java proporcionado por el profesor
- Ejemplos de ASCII Hangman

---

## 📊 Criterios de Evaluación

- ✔️ Repositorio activo con commits de todos los integrantes  
- ✔️ Archivo palabras.csv completo  
- ✔️ Lectura correcta del CSV  
- ✔️ Lógica del juego funcional  
- ✔️ Uso correcto de métodos  
- ✔️ Menú con ASCII art  
- ✔️ Respuestas teóricas  
- ⭐ Bonus: Easter Egg implementado  

---

## 🧪 Consideraciones Técnicas

- Uso de `BufferedReader` para leer archivos
- Uso de `String.split()` para procesar CSV
- Manejo de excepciones (`try-catch`)
- Uso de `Math.random()` para selección de palabras
- Validación de entrada del usuario

---

## 📚 Conceptos Aplicados

- Strings en Java
- Arreglos (`char[]`, `String[]`)
- Métodos (con y sin retorno)
- Control de flujo (`if`, `switch`, `while`)
- Lectura de archivos
- Modularidad

---

## 🚀 Estado del Proyecto

🟡 En desarrollo
