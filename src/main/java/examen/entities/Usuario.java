package examen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Entidad {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombreUsuario")
	private String nombreUsuario;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "colorPreferido")
	private String colorPreferido;
	
	/**
	 * Constructor.
	 */
	public Usuario() {
		super();
	}
	
	@Override
	public String toString() {
		return nombreUsuario;
	}
	
	/// GETTERS & SETTERS ///

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getColorPreferido() {
		return colorPreferido;
	}

	public void setColorPreferido(String colorPreferido) {
		this.colorPreferido = colorPreferido;
	}
	
}
