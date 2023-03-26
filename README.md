# API Rest Reserva de Hoteles
Este proyecto aborda la **Práctica final para la *Formación Junior Java* de atSistemas**.


## **Base de datos - Postgresql** 
En el proyecto se adjuntan dos scripts *sql* que contienen la estructura de las tablas de la base de datos utilizada y los datos de prueba. 
 *  src/main/resources/estructura.sql
 *  src/main/resources/datos.sql

## **Pruebas** 
Según la configuración que he establecido en el fichero *application.properties*, la aplicación se ejecuta en el puerto 9000. Teniendo esto en cuenta, adjunto algunas pruebas para facilitar su uso:

 *  **Listar un hotel por id:**
 
    `http://localhost:9000/hoteles/2`
    
    * *Se controla el error si el id no existe* 
    
* **Listar hoteles:**

    `http://localhost:9000/hoteles/`
    
* **Crear hotel:**

    `http://localhost:9000/hoteles/nuevo`
    
   * *Recibe en el body el nuevo hotel:*

    `{
    "name": "Hotel Nuevo creado desde API",
    "category": "2"
    }`

* **Modificar hotel por id:**

    `http://localhost:9000/hoteles/6`

    * *Recibe en el body las modificaciones:*

     `{
    "name": "Hotel Nuevo MODIFICADO desde API",
    "category": "3"}`

* **Listar disponibilidades:**

    `http://localhost:9000/disponibilidad/`

* **Abrir disponibilidades:**

    `http://localhost:9000/disponibilidad/abrir?idHotel=2&fechaIni=2022-10-12&fechaFin=2022-10-17&rooms=2`

   * *Recibe por parámetros las fechas, fecha desde la que se quiere añadir la disponibilidad y fecha hasta la que se quiere añadir disponibilidad*

* **Consultar disponibilidad de hoteles entre dos fechas:**

    `http://localhost:9000/disponibilidad/buscar?desde=2022-10-14&hasta=2022-10-16`

    * *Recibe por parámetros las fechas, fecha desde la que se quiere consultar la disponibilidad y fecha hasta la que se quiere consultar disponibilidad*
    * *Devuelve la disponibilidad de los hoteles entre esas fechas*
    
* **Consultar reserva por su id:**
   `http://localhost:9000/reservas/2`
   * *Dado un id, devuelve la información de la reserva correspondiente*
   
* **Consultar hotel dado el id de una reserva:**
  `http://localhost:9000/reservas/hotel/4`
  * *Devuelve la información completa de un hotel dado el id de una reserva*

