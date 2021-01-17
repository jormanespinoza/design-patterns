package com.namroj;

import com.namroj.memento.Editor;
import com.namroj.memento.History;
import com.namroj.state.BrushTool;
import com.namroj.state.Canvas;
import com.namroj.state.EraseTool;
import com.namroj.state.SelectionTool;

public class Main {

    public static void main(String[] args) {

        //Memento Pattern
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        editor.restore(history.pop());

        System.out.println(editor.getContent());

        //State Pattern
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();

		canvas.setCurrentTool(new BrushTool());
		canvas.mouseDown();
		canvas.mouseUp();

		canvas.setCurrentTool(new EraseTool());
		canvas.mouseDown();
		canvas.mouseUp();
    }
}
