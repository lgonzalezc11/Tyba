package com.AdvantageDemo.AdvantageDemoAutomatizacion.steps.InicioSesion;


import com.AdvantageDemo.AdvantageDemoAutomatizacion.pageobjects.InicioSesion.LoginPageObjects;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;



public class LoginSteps {

    static LoginPageObjects loginPageObjects;

    @Step
    public void AbrirUrl() {
        loginPageObjects.open();
        Serenity.getWebdriverManager().getWebdriver().manage().window().maximize();
    }

    @Step
    public void SeleccionarOpcion() {
        loginPageObjects.SeleccionarOpcion();
    }

    @Step
    public void FormularioInicioSesion(String user, String pass) {
        loginPageObjects.FormularioInicioSesion(user,pass);
    }

    @Step
    public void SeleccionBotonSignIn() {
        loginPageObjects.SeleccionBotonSignIn();
    }


    @Step
    public void ValidarUsuarioLogeado(String usuariopersona) {
        loginPageObjects.ValidarUsuarioLogeado(usuariopersona);
    }


}
