package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *working with number at different bases
 * @author Sepehr79
 */
public class BaseNumber {

    private String number;
    private String base;
    private final HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>() {{put('0', 0);put('1', 1);
    put('2', 2);put('3', 3);
    put('4', 4);put('5', 5);
    put('6', 6);put('7', 7);
    put('8', 8);put('9', 9);
    put('A', 10);put('B', 11);
    put('C', 12);put('D', 13);
    put('E', 14);put('F', 15);
    }};

    /**
     *
     * @throws WrongBaseFormatException if base number is bigger than number.
     */
    public BaseNumber(String number, String base) throws WrongBaseFormatException {
        this.number = number;
        this.base = base;

        if(number.matches(".*[a-zG-Z].*")){
            throw new WrongBaseFormatException("wrong characters, valid characters are A to F");
        }
        for(int i = 0 ; i < number.length() ; i++){
            if( hashMap.get(number.charAt(i)) >= Integer.parseInt(base)){
                throw new WrongBaseFormatException("Some digits of number is more than its base");
            }
        }
    }
    public BaseNumber(String number) throws WrongBaseFormatException {
        this.number = number;
        this.base = "10";

        if(number.matches(".*[a-zA-Z].*")){
            throw new WrongBaseFormatException("for decimal numbers you should enter characters between 0 to 9");
        }
    }

    /**
     *
     * @return number at base 10.
     */
    public String convertToBaseTen(){
        int sum = 0;

        for (int i = number.length() - 1 ; i >= 0 ; i--){
            sum += hashMap.get(number.charAt(i)) * Math.pow(Integer.parseInt(base), number.length() - 1 - i);
        }
        this.number = String.valueOf(sum);
        this.base = String.valueOf(10);

        return number;
    }

    /**
     *
     * @param base new base of number.
     * @return number at base you want.
     */
    public String convertToBase(String base){
        int baseOfNumber = Integer.parseInt(base);
        int number = Integer.parseInt(convertToBaseTen());
        Stack<Character> stack = new Stack<>();

        while(number != 0) {
            for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == number % baseOfNumber) {
                    stack.push(entry.getKey());
                }
            }
            number = number / baseOfNumber;
        }

        this.number = "";
        while (!stack.isEmpty()){
            this.number += stack.pop();
        }
        this.base = String.valueOf(baseOfNumber);

        return this.number;
    }

    //getters and setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws WrongBaseFormatException {
        this.number = number;

        if(number.matches(".*[a-zG-Z].*")){
            throw new WrongBaseFormatException("wrong characters, valid characters are A to F");
        }
        for(int i = 0 ; i < number.length() ; i++){
            if( hashMap.get(number.charAt(i)) >= Integer.parseInt(base)){
                throw new WrongBaseFormatException("Some digits of number is more than its base");
            }
        }
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.convertToBase(base);
    }
}


/**
 * our Exception to control inputs at
 */
class WrongBaseFormatException extends Exception{

    public  WrongBaseFormatException(){
        super();
    }
    public WrongBaseFormatException(String message){
        super(message);
    }

    @Override
    public String toString(){
        String text = "Wrong format of inout numbers";
        return (!(this.getMessage() == null))? text + ": " + this.getMessage(): text;
    }
}
