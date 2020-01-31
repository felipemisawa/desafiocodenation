import org.json.simple.JSONObject;

public class Resposta {

	private int numeroCasas;
	private String token;
	private String cifrado;
	private String decifrado;
	private String resumoCriptografico;

	public Resposta() {
	}

	public Resposta(JSONObject response) {
		this.numeroCasas = (int)(long) response.get("numero_casas");
		this.token = (String) response.get("token");;
		this.cifrado = (String) response.get("cifrado");;
		this.decifrado = (String) response.get("decifrado");;
		this.resumoCriptografico = (String) response.get("resumo_criptografico");;
	}

	public int getNumeroCasas() {
		return numeroCasas;
	}

	public void setNumeroCasas(int numeroCasas) {
		this.numeroCasas = numeroCasas;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCifrado() {
		return cifrado;
	}

	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}

	public String getDecifrado() {
		return decifrado;
	}

	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}

	public String getResumoCriptografico() {
		return resumoCriptografico;
	}

	public void setResumoCriptografico(String resumoCriptografico) {
		this.resumoCriptografico = resumoCriptografico;
	}

	@Override
	public String toString() {
		return "Resposta [numeroCasas=" + numeroCasas + ", token=" + token + ", cifrado=" + cifrado + ", decifrado="
				+ decifrado + ", resumoCriptografico=" + resumoCriptografico + "]";
	}

}
