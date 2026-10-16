import java.util.HashMap;
import java.util.function.BinaryOperator;

class Lexer {
    private HashMap<String, BinaryOperator<Double>> ops;
    public Lexer() {
        ops = new HashMap<>();
        ops.put("+", (a, b) -> (a + b));
        ops.put("-", (a, b) -> (a - b));
        ops.put("/", (a, b) -> (a / b));
        ops.put("*", (a, b) -> (a * b));
        ops.put("max", (a, b) -> Double.max(a, b));
        ops.put("min", (a, b) -> Double.min(a, b));
        ops.put("^", (a, b) -> Math.pow(a, b));
        ops.put("||", (a, b) -> Double.max(a, b));
        ops.put("&&", (a, b) -> a.equals(b) ? 1.0 : 0.0);
        ops.put("|", (a, b) -> Double.parseDouble(
            String.valueOf(a.longValue()) + String.valueOf(b.longValue())
        ));
        ops.put(">", (a, b) -> a > b ? 1.0 : 0.0);
        ops.put("<", (a, b) -> a < b ? 1.0 : 0.0);

    }
    public Boolean classify(String token) {
        var check = ops.getOrDefault(token, null);
        if (check == null) return false; // This is a Double
        return true; // This is an Op
    }
    public BinaryOperator<Double> getOp(String key) {
        return ops.getOrDefault(key, null);
    }
}
