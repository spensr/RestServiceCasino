# RestServiceCasino
 Api ruleta de apuestas.
 El api cumple las siguientes funciones:
  Creación de nuevas ruletas que devuelva el id de la nueva ruleta creada
  Apertura de ruleta que permite las posteriores peticiones de apuestas, devuelve un estado de confirmación que la operación fue exitosa o denegada
  Valida las apuestas numericas entre el 0 y 36
  Valida las apuestas de color negro o rojo
  Valida la apuestas maxima de 10000 dólares
  Cierre de apuestas, devuelve el resultado de las apuestas hechas desde su apertura hasta el cierre.
  Lista de ruletas creadas con sus estados (Abierta o cerrada).
