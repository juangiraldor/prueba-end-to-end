Prueba Técnica - Analista de Calidad Automatizado (QA Automation)



Este repositorio contiene la solución al ejercicio 2: Automatización de Flujo Funcional (End-to-End), usando Java, Selenium WebDriver y TestNG.


** Tecnologías que se utilizaron

- Java 21.0.2
- Selenium WebDriver
- TestNG
- Maven
- Page Objects Model (POM)

** Descripción General

La prueba consiste en automatizar la creación de un artículo en un CMS, considerando las siguientes condiciones:

- El login contiene un reCAPTCHA, por lo tanto la prueba ingresa al sitio de forma automática, ingresa las credenciales y en el código se utiliza un "waiter" para realizar el paso del recaptcha de forma manual. Ya luego de esta espera se continúa el flujo automatizado.
- Se crea un artículo exitosamente.
- Se valida que el artículo sea creado y publicado correctamente.
- Se siguen buenas prácticas como el uso de POM, fixtures y datos parametrizados.

** Como ejecutar las pruebas.

- Abrir el proyecto en el IDE de preferencia (Yo lo realicé con IntelliJ)
- Abrir el archivo CrearArticuloTest.
- Dar clic en Run en la parte superior del IDE.
- Esperar que se ingresen las credenciales automáticamente
- Realizar el captcha manual (Se tienen configurados 20 segundos de espera)
- El resto de la prueba se ejecutará automáticamente.

** Reportes

- En la carpeta se incluyeron los reportes generados.

** Autor

- Juan Esteban Giraldo Ramirez
- QA Automation Engineer
- juanesgiraldo94@gmail.com | https://www.linkedin.com/in/juan-esteban-giraldo-ramirez/

