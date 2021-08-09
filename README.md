# Ejemplo Spring Boot demo

Ejemplo sencillo de Spring Boot inicialmente sin uso de bbdd. 

El tomcat corre sobre localhost:8080, nos devuelve una lista de 10 contacto creados de forma dinámica.

***crearArrayContactos()***  -> Método que genera 10 contactos de forma dinámica.

## Clase Contacto

***Propiedades:*** 

* id -> identificador único (long)
* nombre -> nombre del contacto (string)
* fechaNacimiento -> fecha de nacimiento (string)
* email -> email del contacto (string)
* genero -> Enum con valores Mujer,Hombre,Indefinido 

***Métodos:***

Existen 3 constructores

También tenemos los get para cada una de las propiedades

**getEdad()** -> Método que nos devuelve la edad del contacto basándose en la fecha de nacimiento de éste.

**toString()** -> Método que nos devuelve en formato string los datos de un contacto incluida su edad.
