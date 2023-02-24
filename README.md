# konecta}

#Tecnologia
	
	Apache Maven 3.8.5
	java 8
	JPA H2	
	Swagger 2.9.2
	Spring Boot 2.7.9
	
	
#Descripcion

	Aplicacion Creada para el proceso de seleccion de la compañia Konecta

	software para la cafetería de una de sus sedes, que
	permita almacenar y gestionar el inventario de sus productos.
	Este software debe permitir crear, editar, eliminar y listar todos los productos registrados
	en el sistema.
	Adicionalmente, se debe contar con un módulo que permita realizar la venta de un
	producto, el cual recibirá el ID del producto como parámetro y la cantidad del producto
	vendido. El software debe actualizar el campo de stock restando la cantidad del producto
	vendido y registrar en una tabla la venta realizada (si el producto no cuenta con stock
	mayor a cero debe mostrar un mensaje informando que no es posible realizar la venta).
	
#Configuracion

	Realizar el clone del repositorio y ejecutar el comando mvn install para la descarga de las dependencias

		mvn clean install -DSkipTest
	
	Ejecutar proyecto 
	
		mvnw spring-boot:run
		
	en tu navegador url localhost:8080/api/swagger-ui.html para verificar documentacion Swagger.
	
	En el archivo ubicado en resources/data.sql se encuentran los datos de prueba
		

