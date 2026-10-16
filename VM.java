class VM {
    private Interpreter interpreter;
    public VM() {
        interpreter = new Interpreter();
    }
    public void run() {
        IO.print("> ");
        System.out.flush();
        while (true) {
            var line = IO.readln();
            if (line.matches("\\s*q\\s*")) break;
            IO.println(interpreter.doLine(line));
            IO.print("> ");
        }
    }
}
