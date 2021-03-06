package pl.sdacademy.prog.memento;

import java.util.TreeMap;

public class EditorText {

    private TreeMap<Integer, String> editorTextValues = new TreeMap<>();

    public TreeMap<Integer, String> getEditorTextValues() {
        return editorTextValues;
    }

    public void addText(final String textToAdd) {
        final int newLineIndex = editorTextValues.size() + 1;
        editorTextValues.put(newLineIndex, textToAdd);
    }

    public void addText(final String textToAdd, final int lineNum, final WriteMode writeMode) {
        validateLineNumber(lineNum);
        if (lineNum > editorTextValues.size()) {
            handleNewLineCreation(lineNum, textToAdd);
        } else {
            handleExsistingLineEdit(lineNum, textToAdd, writeMode);
        }
    }

    private void validateLineNumber(final int lineNum) {
        if (lineNum <= 0) {
            throw new IllegalArgumentException("Line number equal or below 0");
        }
    }

    private void handleNewLineCreation(final int lineNum, final String textToAdd) {
        for (int i = editorTextValues.size() + 1; i < lineNum; i++) {
            editorTextValues.put(i, "");
        }
        editorTextValues.put(lineNum, textToAdd);
    }

    private void handleExsistingLineEdit(final int lineNum, final String textToAdd, final WriteMode writeMode) {
        if (writeMode == WriteMode.APPEND) {
            editorTextValues.replace(lineNum, editorTextValues.get(lineNum) + textToAdd);
        } else if (writeMode == WriteMode.REPLACE) {
            editorTextValues.replace(lineNum, textToAdd);
        }
    }

    public void restoreFromMemento(final EditorTextMemento memento) {
        editorTextValues = new TreeMap<>(memento.getSavedEditorTextValues());
    }


}
