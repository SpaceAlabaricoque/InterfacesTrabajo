package holo;

public class User {
	private String nombre;
	private String apellidos;
	private String password;
	private String nick;
	private String correo;
	private static String globalNick;
	
	private void user(String nombre, String apellidos, String password, String nick, String correo){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.nick = nick;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}
	
	public static String getGlobalNick() {
		return globalNick;
	}
	
	public static void setGlobalNick(String nick) {
		globalNick = nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
