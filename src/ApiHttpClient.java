import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class ApiHttpClient {

    private final String apiKey;
    private final String baseUrl = "https://v6.exchangerate-api.com/v6/";

    public ApiHttpClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public RespostaTaxaDeCambio obterTaxasDeCambio(String moedaBase) throws IOException, InterruptedException {
        String url = baseUrl + apiKey + "/latest/" + moedaBase;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            return gson.fromJson(response.body(), RespostaTaxaDeCambio.class);
        } else {
            System.out.println("Erro: Não foi possível obter as taxas de câmbio. Código de status: " + response.statusCode());
            return null;
        }
    }
}
