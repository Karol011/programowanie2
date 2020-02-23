package pl.sdacademy.prog.memento;

public class EditorDemo {
    public static void main(String[] args) {
        final EditorTextMementoMenager mementoMenager = new EditorTextMementoMenager();
        final EditorText editorText = new EditorText();
        mementoMenager.addMemento(new EditorTextMemento(editorText));

        editorText.addText("first line");
        mementoMenager.addMemento(new EditorTextMemento(editorText));

        editorText.addText("second line");
        mementoMenager.addMemento(new EditorTextMemento(editorText));

        editorText.addText("fifth line", 5, WriteMode.APPEND);
        mementoMenager.addMemento(new EditorTextMemento(editorText));

        editorText.addText("new 3rd line", 3, WriteMode.REPLACE);
        mementoMenager.addMemento(new EditorTextMemento(editorText));

        editorText.addText(" 3rd line additioooon", 3, WriteMode.APPEND);
        mementoMenager.addMemento(new EditorTextMemento(editorText));

        editorText.getEditorTextValues().forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        mementoMenager.restore();
        mementoMenager.restore();
        final EditorTextMemento memento = mementoMenager.restore();
        editorText.restoreFromMemento(memento);

        editorText.getEditorTextValues().forEach((k, v) -> System.out.println(k + " " + v));

    }
}
