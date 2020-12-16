package com.ti.encuesta.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="tbl_encuesta")
public class Encuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique=true, nullable = false)
	@NotBlank(message = "Mail en Blanco")
	@Email(message = "Formato Invalido")
	private String mail;
	private int glosaopcion;
	
	public Encuesta() {
		
	}

	public Encuesta(Long id, String mail, int glosaopcion) {
		super();
		this.id = id;
		this.mail = mail;
		this.glosaopcion = glosaopcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getGlosaopcion() {
		return glosaopcion;
	}

	public void setGlosaopcion(int glosaopcion) {
		this.glosaopcion = glosaopcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Encuesta other = (Encuesta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encuesta [id=" + id + ", mail=" + mail + ", glosaopcion=" + glosaopcion + "]";
	}
	
}
