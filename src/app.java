import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class app {

	private final static HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {

		Map<Integer, Character> alfabetoNum = new HashMap<Integer, Character>() {
			private static final long serialVersionUID = 1L;

			{
				put(1, 'a');
				put(2, 'b');
				put(3, 'c');
				put(4, 'd');
				put(5, 'e');
				put(6, 'f');
				put(7, 'g');
				put(8, 'h');
				put(9, 'i');
				put(10, 'j');
				put(11, 'k');
				put(12, 'l');
				put(13, 'm');
				put(14, 'n');
				put(15, 'o');
				put(16, 'p');
				put(17, 'q');
				put(18, 'r');
				put(19, 's');
				put(20, 't');
				put(21, 'u');
				put(22, 'v');
				put(23, 'w');
				put(24, 'x');
				put(25, 'y');
				put(26, 'z');

			}
		};
		
		Map<Character, Integer> alfabetoChar = new HashMap<Character, Integer>() {
			private static final long serialVersionUID = 1L;

			{
				put('a', 1);
				put('b', 2);
				put('c', 3);
				put('d', 4);
				put('e', 5);
				put('f', 6);
				put('g', 7);
				put('h', 8);
				put('i', 9);
				put('j', 10);
				put('k', 11);
				put('l', 12);
				put('m', 13);
				put('n', 14);
				put('o', 15);
				put('p', 16);
				put('q', 17);
				put('r', 18);
				put('s', 19);
				put('t', 20);
				put('u', 21);
				put('v', 22);
				put('w', 23);
				put('x', 24);
				put('y', 25);
				put('z', 26);

			}
		};

		Resposta resposta = new Resposta();
		JSONParser parser = new JSONParser();
		char[] inputArray;
		ArrayList<Character> outputArray = new ArrayList<Character>();
		HttpResponse<String> response;

		response = sendGet();

		if (response.statusCode() == 200) {
			resposta = new Resposta((JSONObject) parser.parse(response.body()));
			inputArray = resposta.getCifrado().toLowerCase().toCharArray();

			for (char c : inputArray) {
				if (alfabetoChar.containsKey(c)) {
					outputArray.add(alfabetoNum.get(alfabetoChar.get(c) - resposta.getNumeroCasas()));
				} else {
					outputArray.add(c);
				}
			}

			System.out.println(resposta);
			System.out.println("Output: " + outputArray.stream().map(String::valueOf).collect(Collectors.joining()));
		} else {
			throw new RuntimeException("Error on get request. Error code: " + response.statusCode());
		}
		
	}

	private static HttpResponse<String> sendGet() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(
				"https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=43295bd47c5c3898776183067eac8df4ab0f4c46"))
				.build();

		return httpClient.send(request, HttpResponse.BodyHandlers.ofString());

	}

}
