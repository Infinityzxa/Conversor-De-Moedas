import java.io.IOException;

public class ServicoConversorDeMoedas {

    private final ApiHttpClient apiHttpClient;

    public ServicoConversorDeMoedas(ApiHttpClient apiHttpClient) {
        this.apiHttpClient = apiHttpClient;
    }

    public double converterMoeda(RespostaTaxaDeCambio resposta, String moedaBase, String moedaDestino, double valor) {
        if (resposta.conversion_rates().containsKey(moedaDestino)) {
            double taxaDeConversao = resposta.conversion_rates().get(moedaDestino);
            return valor * taxaDeConversao;
        } else {
            return -1;
        }
    }

    public RespostaTaxaDeCambio obterTaxasDeCambio(String moedaBase) throws IOException, InterruptedException, IOException {
        return apiHttpClient.obterTaxasDeCambio(moedaBase);
    }
}
