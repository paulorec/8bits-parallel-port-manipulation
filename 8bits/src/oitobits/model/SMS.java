/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author paulo
 */
public class SMS {

	private static String apiId = "";
	private static String host = "";
	private static String pass = "";
	private static String user = "";

	public static final String MSG_ALARME_ARMADO = "Dispositivo Alarme foi armado.";
	public static final String MSG_ALARME_DESARMADO = "Alarme foi desarmado.";
	public static final String MSG_ALARME_ACIONADO = "Alarme foi acionado.";
	public static final String MSG_ALARME_DESLIGADO = "Alarme foi desligado.";

	public static String getApiId() {
		return apiId;
	}

	public static void setApiId(String apiId) {
		SMS.apiId = apiId;
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		SMS.host = host;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		SMS.pass = pass;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		SMS.user = user;
	}

	public static void enviar(String numero, String mensagem) throws MalformedURLException, IOException, Exception {
		SimpleDateFormat sd = new SimpleDateFormat("H:m:s");
		String hora = sd.format(new Date());

		mensagem += "\n------\n Sinalizacao: " + hora + "\n8bits corporation";
		mensagem = URLEncoder.encode(mensagem, "UTF-8");

		String alvo = host + "?user=" + SMS.user + "&password=" + SMS.pass + "&api_id=" + SMS.apiId + "&to=" + numero + "&text=" + mensagem;
		System.out.println(alvo);
		URL url = new URL(alvo);
		url.openConnection();
		InputStream in = url.openStream();
		HttpURLConnection conexaoUrl = (HttpURLConnection) url.openConnection();
		/**
		 * Verifica se a conexão foi estabelecida.
		 */

		if (conexaoUrl.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader entradaBuffer = new BufferedReader(new InputStreamReader(conexaoUrl.getInputStream()));

		} else
			throw new Exception("Não foi possivel estabelecer conexão");
	}
}
