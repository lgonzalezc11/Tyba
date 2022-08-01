package com.AdvantageDemo.AdvantageDemoAutomatizacion.definitions.InicioSesion;


import com.AdvantageDemo.AdvantageDemoAutomatizacion.steps.InicioSesion.LoginSteps;
import com.AdvantageDemo.AdvantageDemoAutomatizacion.toolbox.VideoRecorderTask;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import javax.swing.*;

/**
 * @author Leidy Gonzalez
 */

public class LoginDefinition {

        @Managed(driver="chrome")
        private String  prueba;
        VideoRecorderTask video;

        @Before(value = "@CP1_Login_Exitoso")

        public void configuracionInicialnombredelCPPrueba() {
            try {
                prueba = "@CP1_Login_Exitoso";
                video = new VideoRecorderTask();
                video.startRecording(prueba);
            } catch (Exception e) {
            }
        }

    @Steps
    LoginSteps loginSteps;

    @Given("^Que me encuentro en la pagina de advantage demo$")
    public void que_me_encuentro_en_la_pagina_de_advantage_demo() {
        loginSteps.AbrirUrl();
    }

    @Given("^Selecciono la opcion de Icono Persona$")
    public void selecciono_la_opcion_de_Icono_Persona() {
        loginSteps.SeleccionarOpcion();
    }

    @When("^Escribo usuario ([^\"]*) y la contrasena ([^\"]*)$")
    public void escribo_usuario_y_la_contrasena(String user, String pass) {
        loginSteps.FormularioInicioSesion(user,pass);}


    @When("^Seleciono el boton de SIGN IN$")
    public void seleciono_el_boton_de_sing_in() {
        loginSteps.SeleccionBotonSignIn();
    }


    @Then("^Valida que el nombre del icono persona ([^\"]*) sea igual al usuario logeado$")
    public void valida_que_el_nombre_del_icono_persona_sea_igual_al_usuario_logeado(String usuariopersona) {
        loginSteps.ValidarUsuarioLogeado(usuariopersona);
    }


        @After
        public void finalizar() {
            try{
                video.stopRecording();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
