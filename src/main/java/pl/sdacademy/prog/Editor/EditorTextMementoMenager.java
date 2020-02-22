package pl.sdacademy.prog.Editor;

import java.util.ArrayDeque;
import java.util.Deque;

public class EditorTextMementoMenager {
    private Deque<EditorTextMemento> mementos = new ArrayDeque<>();

    //deque jako stos
    public void addMemento(final EditorTextMemento memento) {
        mementos.push(memento);
    }

    public EditorTextMemento restore() {
        return mementos.pop();
    }

}
