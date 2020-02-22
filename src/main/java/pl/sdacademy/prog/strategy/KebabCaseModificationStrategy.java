package pl.sdacademy.prog.strategy;

public enum KebabCaseModificationStrategy implements TextModificationStrategy {

    //enum singleton
    INSTANCE;


    @Override
    public String modify(final String input) {
        final StringBuilder output = new StringBuilder(input.length());
        boolean shouldAddDash = false;
        for (final char c : input.trim().toLowerCase().toCharArray()) {
            if (!Character.isWhitespace(c)) {
                if (shouldAddDash && c != '-') {
                    output.append('-');
                    shouldAddDash = false;
                }
                if (c == '-') {
                    shouldAddDash = false;
                }
                output.append(c);
            } else {
                shouldAddDash = true;
            }
        }

        return output.toString();
    }
}
