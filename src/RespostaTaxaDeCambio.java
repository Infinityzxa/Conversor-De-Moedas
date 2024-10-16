import java.util.Map;

public record RespostaTaxaDeCambio(String base_code, Map<String, Double> conversion_rates) {
}
