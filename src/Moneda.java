public record Moneda(String base_code,
                     String target_code,
                     double conversion_rate) {
    public double calcularResultado (double cantidad){
        return cantidad * conversion_rate;
    }
}
