import java.util.ArrayList;

class Parser {
    private ArrayList<Double> numbers;
    public Parser() {
        numbers = new ArrayList<>();
    }
    public void clear() {
        numbers.clear();
    }
    public void pushNumber(Double nr) {
        numbers.add(nr);
    }
    public Double popNumber() {
        Double aux = numbers.removeLast();
        return aux;
    }
    public String[] split(String line) {
        return line.trim().split("\\s+");
    }
    public int numberCount() {
        return numbers.size();
    }

    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (var e: numbers) {
            sb.append(e.toString() + " ");
        }
        return sb.toString();
    }
}
