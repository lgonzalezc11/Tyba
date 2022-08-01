#Author: Leidy Viviana Gonzalez Canaria
#Correo: leidyvivi_12outlook.com

@Login
Feature: Inicio Sesion
  Como usuario de la pagina advantage Demo quiero iniciar sesion con credenciales correctas

#Login Exitoso
  @CP1_Login_Exitoso
  Scenario Outline: Login_Exitoso
  Ingreso a la url de advantage demo doy clic en el icono personas diligencio mis credenciales correctas e ingreso exitosamente
    Given Que me encuentro en la pagina de advantage demo
    And Selecciono la opcion de Icono Persona
    When Escribo usuario <usuario> y la contrasena <password>
    And Seleciono el boton de SIGN IN
    Then Valida que el nombre del icono persona <usuariopersona> sea igual al usuario logeado

    Examples:
      | usuario | password  |usuariopersona|
      | camilo  | Camilo1 |camilo   |


