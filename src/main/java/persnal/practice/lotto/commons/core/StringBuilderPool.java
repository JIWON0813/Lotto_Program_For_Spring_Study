package persnal.practice.lotto.commons.core;

import org.springframework.cglib.core.Block;

import java.util.LinkedList;
import java.util.Queue;

public class StringBuilderPool {

    static Queue<StringBuilder> stringBuilders = new LinkedList<StringBuilder>();

    public StringBuilderPool(){
        for(int i = 0 ; i < 10 ; i++){
            stringBuilders.add(new StringBuilder());
        }
    }
    public static synchronized StringBuilder take(){
        return stringBuilders.peek() != null ?stringBuilders.poll() : new StringBuilder();
    }

    public static String getString(StringBuilder stringBuilder){
        String result = stringBuilder.toString();
        stringBuilder.setLength(0);
        stringBuilders.add(stringBuilder);
        return result;
    }
}
