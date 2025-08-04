Proyecto POO - Unidad 4
Este proyecto implementa el clásico juego **Buscaminas** en **Java**, ejecutándose en consola.  
Fue desarrollado aplicando **Programación Orientada a Objetos (POO)**, el patrón **MVC**, manejo de **excepciones personalizadas**, persistencia de datos y principios de **código limpio**.

Tecnologías utilizadas
Java
Eclipse
Git y GitHub

▶️ Cómo ejecutar
Clona este repositorio
Importa el proyecto en Eclipse
Al importar se debera convertir en java para poder ejecutarse
Damos click derecho en el proyecto y en configure vemos que este la opcion convert to java
En caso de no estar la opcion ya mensionada debes ir a properties
Seleccionamos la opcion Proyect Facets
Despues seleccionamos la opcion de java
Para finalizar le pulsamos en Apply and Close
Asi se podra ejecutar el proyecto

🎯 Uso del Juego
El juego muestra un tablero de 10x10 oculto.

El jugador puede:

Descubrir una casilla: escribir la coordenada (Ej: A5).
Marcar una mina: escribir M A5.

El juego termina cuando:

Se descubren todas las casillas sin minas (Victoria).
Se selecciona una mina (Derrota).

📂 Estructura del Proyecto

buscaminas/

 ├── Main.java              # Punto de entrada
 
 ├── controlador/           # Controlador del juego
 
 ├── modelo/                # Lógica y datos
 
 ├── vista/                 # Interfaz en consola
 
 └── excepciones/           # Excepciones personalizadas

 💻 Ejemplo de Ejecución

 === Bienvenido al Buscaminas ===
 
   1 2 3 4 5 6 7 8 9 10
   
A  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■

B  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■

C  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■

...

Ingrese coordenada (ej: A5) o 'M A5' para marcar:



👨‍💻 Autor
Anddy Naranjo – Desarrollador principal
(Responsable de la implementación completa del proyecto)
