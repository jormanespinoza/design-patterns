package com.namroj.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> editorStates = new ArrayList<>();

    public void push(EditorState editorState) {
        editorStates.add(editorState);
    }

    public EditorState pop() {
        int lastIndex = editorStates.size() - 1;
        if (lastIndex < 0) {
            return new EditorState("");
        }
        EditorState lastEditorState = editorStates.get(lastIndex);
        editorStates.remove(lastEditorState);

        return lastEditorState;
    }
}
