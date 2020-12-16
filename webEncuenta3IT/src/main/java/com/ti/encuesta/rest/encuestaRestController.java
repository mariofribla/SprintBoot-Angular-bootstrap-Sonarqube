package com.ti.encuesta.rest;

import javax.validation.Valid;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ti.encuesta.Entity.Encuesta;
import com.ti.encuesta.repository.EncuestaRepository;

@RestController
@RequestMapping("/")
public class encuestaRestController {
	
	@Autowired
	EncuestaRepository repositorio;
	
	String[][] opcionGlosa = { {"Ligth", "0"}
	                         , {"Sin Azucar", "0"}
	                         , {"Normal", "0"}
	                         , {"No tomo", "0"}};
	
	
	@GetMapping ("/index")
	public Encuesta index() {
		return new Encuesta();
	}
	
	@GetMapping ("/producto")
	public String[][] getProducto() {
		return opcionGlosa;
	}

	@PostMapping ("/registroencuesta")
	public String postRegistroEncuesta(@RequestBody @Valid Encuesta encuesta) {
		String mensaje = "Encuesta Registrada Existosamente...";
		try {
			if ( validaMail(encuesta.getMail()) ) {
				repositorio.save(encuesta); // Insert into tbl_encuesta() value (...);
				opcionGlosa[encuesta.getGlosaopcion()][1] = String.valueOf(Integer.parseInt(opcionGlosa[encuesta.getGlosaopcion()][1]) +1 );
			}
			else {
				mensaje= "Error: Email Invalido...";
			}
		}
		catch (Exception e) {
			mensaje = "Error: Encuesta Ya Registrada...";
			System.out.println ("ERROR:" + e.getMessage()+", "+e.getStackTrace());
	    }
		return mensaje;
	}
	
	// Function
	private static boolean validaMail(String mail) {
		   boolean validamail = true;
		   try {
			   validamail = EmailValidator.getInstance().isValid(mail);
		   } catch (Exception e) {
			   validamail = false;
		   }
		   return validamail;
	}

}
 