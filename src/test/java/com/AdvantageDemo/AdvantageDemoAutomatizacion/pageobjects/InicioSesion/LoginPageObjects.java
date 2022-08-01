package com.AdvantageDemo.AdvantageDemoAutomatizacion.pageobjects.InicioSesion;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;

@DefaultUrl("https://www.advantageonlineshopping.com/#/")


public class LoginPageObjects extends PageObject {

    //Formulario Inicio Sesion
    //Icono Persona
    @FindBy(xpath = "//a[@id=\"hrefUserIcon\"]")
    private WebElement butonPersona;

    //Clic Tipo Documento
    @FindBy(id = "TipoDocumento")
    private WebElement clicTipoDoc;

    //Ingresar Usuario
    @FindBy(xpath = "//input[@name=\"username\"]")
    private WebElement inputUser;

    //Ingresar contraseña
    @FindBy(name = "password")
    private WebElement inputpass;

    //Boton Login
    @FindBy(id = "sign_in_btnundefined")
    private WebElement btnLogin;

    //Metodo Validar información
    //Validacion Login Exitoso
    @FindBy(xpath="//a[@id=\"menuUserLink\"]//following::span[contains(text(),'camilo')]")
    private WebElement lblValidacionLoginExitoso;


    public void SeleccionarOpcion() {
        butonPersona.click();
    }

    public void FormularioInicioSesion(String user, String pass) {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        inputUser.click();
        inputUser.clear();
        inputUser.sendKeys(user);

        inputpass.click();
        inputpass.clear();
        inputpass.sendKeys(pass);

        btnLogin.click();

    }


    public void SeleccionBotonSignIn() {
        btnLogin.click();
    }

    public void ValidarUsuarioLogeado(String usariopersona) {
        String lblValidarLoginExitoso = lblValidacionLoginExitoso.getText();
        assertThat(lblValidarLoginExitoso, containsText(usariopersona));
    }




}
