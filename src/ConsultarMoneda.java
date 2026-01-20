import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    Moneda buscarMoneda(String monedaBase, String monedaTarget) {

        URI direction = URI.create("https://v6.exchangerate-api.com/v6/8a2e144896ba194a5bebc4fb/pair/" + monedaBase + "/" + monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Moneda.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("La Moneda no existe");
            }
    }
}
