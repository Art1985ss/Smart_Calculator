package calculator;

import java.math.BigInteger;
import java.util.Arrays;

public enum Operator {

    ADD("+") {
        @Override
        public BigInteger execute(BigInteger a, BigInteger b) {
            return a.add(b);
        }
    },
    SUBTRACT("-") {
        @Override
        public BigInteger execute(BigInteger a, BigInteger b) {
            return a.subtract(b);
        }
    },
    MULTIPLY("*") {
        @Override
        public BigInteger execute(BigInteger a, BigInteger b) {
            return a.multiply(b);
        }
    },
    DIVIDE("/") {
        @Override
        public BigInteger execute(BigInteger a, BigInteger b) {
            return a.divide(b);
        }
    };

    private final String representation;

    Operator(String representation) {
        this.representation = representation;
    }

    public static Operator getByRepresentation(String representation) throws CalculatorException {
        return Arrays.stream(values()).filter(o -> o.representation.equals(representation))
                .findAny().orElseThrow(() ->
                        new CalculatorException("No operand with representation : " + representation));
    }

    public abstract BigInteger execute(BigInteger a, BigInteger b);
}
