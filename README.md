# CandidateSeek



#  Instalación y Configuración
*   Prerrequisitos
    Asegúrate de tener las siguientes herramientas instaladas en tu sistema:

    *   Java 21
    *   Maven
    *   Un IDE compatible con Java (IntelliJ, Eclipse, etc.)

#  Tecnologías Utilizadas
*   Spring Boot 3.3.4: Framework principal para la construcción de la aplicación.
*   Spring Security: Utilizado para la autenticación y autorización de usuarios.
*   JSON Web Tokens (JWT): Para gestionar la autenticación basada en tokens.
*   MySql Database: Base de datos para el desarrollo y las pruebas.
*   JPA (Java Persistence API): Para el mapeo y la interacción con la base de datos.
*   Tomcat: Servidor web embebido.
*   Maven: Gestión de dependencias y construcción del proyecto.

# Pasos para la Instalación
1. Clona el repositorio del proyecto:
    -   git clone https://github.com/JefersonCaceres/CandidateSeek.git
2. con el IDE abre el proyecto
    -   CandidateSeek
3. Compila el proyecto utilizando Maven: 
    -   mvn clean install
4. Ejecuta la aplicación:
    -   mvn spring-boot:run
La aplicación estará disponible en http://localhost:8091/

# Endpoints de la API
*   Login
    -   Para poder interactuar con los demás endpoints de la API, es necesario autenticarse primero y obtener un token JWT. Este token se usará en el encabezado de todas las solicitudes protegidas.(en este caso son todos los endpoint a excepcion del login)
    *   URL: http://localhost:8091/login
    *   Metodo: POST
    *   Descripción: Autenticación del usuario, genera un token JWT.
    *   Body (JSON): { "username": "user","password": "123456"}
    *   Respuesta: Devuelve el token JWT que se utilizará en los siguientes endpoints para autenticación.
    *    copia ese token ya que lo usaremos para poder autentificar la peticion
    *   abrimos cualquier endpoint nos vamos a la pestaña llamada Authorization
    *   en Auth type buscamos bearer token y ahi pegamos el Token de esa manera podemos usar las peticiones
# La coleccion de postman la dejare en el proyecto, \postman aqui encontraran una coleccion con todos los endpoint 