package Core;

import org.springframework.cglib.core.Block;

import java.util.LinkedList;
import java.util.Queue;

public class StringBuilderPool {

    static Queue<StringBuilder> stringBuilders;
    static int index = 0;

    public StringBuilderPool(){
    }

    public StringBuilderPool(int capacity){
        stringBuilders = new LinkedList<StringBuilder>();
        for(int i = 0 ; i < capacity ; i++){
            stringBuilders.add(new StringBuilder());
        }
    }

    public static synchronized StringBuilder take(){
        return stringBuilders.peek() != null ?stringBuilders.poll() : new StringBuilder();
    }

    public static String getString(StringBuilder stringBuilder){
        String result = stringBuilder.toString();
        stringBuilders.add(stringBuilder.delete(0, stringBuilder.length()));
        return result;
    }
}
