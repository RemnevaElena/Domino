package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BoneClickHandler implements EventHandler<MouseEvent> {

    private final HandleFunction function;
    private final int first, second;
    public BoneClickHandler(HandleFunction handleFunction, int first, int second) {
        this.function = handleFunction;
        this.first = first;
        this.second = second;
    }

    @Override
    public void handle(MouseEvent event) {
        function.action(first, second);
    }


    public interface HandleFunction {
        void action(int first, int second);
    }
}
