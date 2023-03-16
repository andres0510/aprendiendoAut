package com.aprendiendoaut.test.controller;

import com.aprendiendoaut.test.dto.Persona;
import com.aprendiendoaut.test.helpers.Report;
import com.aprendiendoaut.test.page.wappi.PageWappiCabezal;
import com.aprendiendoaut.test.page.wappi.PageWappiFormulario;
import com.aprendiendoaut.test.page.wappi.PageWappiIniciarSesion;
import com.aprendiendoaut.test.utils.Utilidades;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WappiController {

    public static void iniciarSesion (String usuario, String contrasena){
        PageWappiIniciarSesion pageWappiIniciarSesion = new PageWappiIniciarSesion();
        pageWappiIniciarSesion.ingresarUsuario(usuario);
        pageWappiIniciarSesion.ingresarContrasena(contrasena);
        pageWappiIniciarSesion.clickBtnIngresar();

    }

    public static void seleccionarOpcionMenu (String opcionMenu){
        PageWappiCabezal pageWappiCabezal = new PageWappiCabezal();
        switch (opcionMenu){
            case "Inicio":
                pageWappiCabezal.clickBtnInicio();
                break;
            case "Cupones":
                pageWappiCabezal.clickBtnCupones();
                break;
            case "Mis Pedidos":
                pageWappiCabezal.clickBtnMisPedidos();
                break;
            case "Informacion Personal":
                pageWappiCabezal.clickBtnInformacionPersonal();
                break;
            default:
                Report.reportFail(
                    String.format("La opción %s no existe en el menú",opcionMenu)
                );
                break;
        }
    }


    public static void ingresarDatos (Persona persona){
        PageWappiFormulario pageWappiFormulario = new PageWappiFormulario();
        String rutaImagen = String.format("%s\\src\\main\\resources\\files\\pato.avif",System.getProperty("user.dir"));
        pageWappiFormulario.ingresarImagen(rutaImagen);
        pageWappiFormulario.ingresarUsuario(persona.getNombre());
        pageWappiFormulario.ingresarApellido(persona.getApellido());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNacimiento = sdf.format(persona.getFechaNacimiento());
        pageWappiFormulario.ingresarFechaNacimiento(fechaNacimiento);

        switch (persona.getPais()){
            case "Argentina":
                pageWappiFormulario.clickPaisArgentina();
                break;
            case "Colombia":
                pageWappiFormulario.clickPaisColombia();
                break;
            case "Estados Unidos":
                pageWappiFormulario.clickPaisEstadosUnidos();
                break;
            default:
                Report.reportFail(
                        String.format("La opción %s no se encuentra en la lista",persona.getPais())
                );
                break;
        }

        switch (persona.getSexo()){
            case "Masculino":
                pageWappiFormulario.clickSexoMasculino();
                break;
            case "Femenino":
                pageWappiFormulario.clickSexoFemenino();
                break;
            default:
                Report.reportFail(
                        String.format("La opción %s no está especificada",persona.getSexo())
                );
            break;
        }
    }

    public static void guardarDatos(){
        PageWappiFormulario pageWappiFormulario = new PageWappiFormulario();
        pageWappiFormulario.clickBtnGuardar();
    }

    public static void validarMensaje(){
        String mensajeExitoso = "Tu información se guardó correctamente";
        PageWappiFormulario pageWappiFormulario = new PageWappiFormulario();
        String mensajeModal = pageWappiFormulario.obtenerTextoModal();
        Assert.assertEquals(mensajeExitoso, mensajeModal);
        pageWappiFormulario.clickBtnCerrarModal();
    }

    public static void validarDatosActualizados(Persona usuario){


        PageWappiFormulario pageWappiFormulario = new PageWappiFormulario();
        String nombreUsuario = pageWappiFormulario.obtenerNombre();
        Assert.assertEquals(nombreUsuario, usuario.getNombre());

        String apellidoUsuario = pageWappiFormulario.obtenerApellido();
        Assert.assertEquals(apellidoUsuario, usuario.getApellido());

        //String paisUsuario = pageWappiFormulario.obtenerPais();
        //Assert.assertEquals(paisUsuario, usuario.getPais());

        String fechaNacimientoUsuario = pageWappiFormulario.obtenerFechaNacimiento();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNacimiento = sdf.format(usuario.getFechaNacimiento());
        Assert.assertEquals(fechaNacimientoUsuario, fechaNacimiento);


        String sexoUsuario="";
       if (pageWappiFormulario.validarCheckSexoFemenino() && !pageWappiFormulario.validarCheckSexoMasculino()){
           sexoUsuario="Femenino";
       }
       else
       if (!pageWappiFormulario.validarCheckSexoFemenino() && pageWappiFormulario.validarCheckSexoMasculino()){
           sexoUsuario="Masculino";
       }
       else
       if (pageWappiFormulario.validarCheckSexoFemenino() && pageWappiFormulario.validarCheckSexoMasculino()){
           Report.reportFail("Se encuentran seleccionados ambos radioButtom del sexo del usuario");
       }
       else{
           Report.reportFail("No se encuentran seleccionados ninguno de los radioButtom del sexo del usuario");
       }
       Assert.assertEquals(sexoUsuario, usuario.getSexo());


        //Todo validar campo Pais actualizado

    }
}

