class Interpreter {
    private Parser par;
    private Lexer lex;
    public Interpreter() {
        par = new Parser();
        lex = new Lexer();
    }
    public Double doLine(String line) {
        par.clear();
        var tokens = par.split(line);
        for (var tok: tokens) {
            if (lex.classify(tok)) {
                if (par.numberCount() == 0) {
                    System.err.println("Cannot start with an operator: " + tok);
                    return 0.0;
                }
                if (par.numberCount() == 1) {
                    System.err.println("Insufficient operators: " + tok);
                    return 0.0;
                }
                if (par.numberCount() < 2) {
                    System.err.println("Double operators not allowed: " + tok);
                    return 0.0;
                }
                Double a = par.popNumber();
                Double b = par.popNumber();
                var op = lex.getOp(tok);
                if (op == null) {
                    System.err.println("Unknown operator: " + tok);
                    return 0.0;
                }
                par.pushNumber(op.apply(a, b));
            } else {
                Double number = 0.0;
                try {
                    number = Double.parseDouble(tok);
                } catch (NumberFormatException e)  {
                    System.err.println("Unknown symbol: " + tok);
                    return number;
                }
                par.pushNumber(number);
            }
        }
        if (par.numberCount() != 1) {
            System.err.println("Operator not provided: " + par.popNumber());
            return 0.0;
        }
        return par.popNumber(); // If it doesn't work :((((
    }
}
