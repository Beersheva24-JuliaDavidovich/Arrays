package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer arg0, Integer arg1) { 
        int result = 0;
        if(arg0 % 2 == 0 && arg1 % 2 != 0){
            result = -1;
        }else if(arg0 % 2 == 0 && arg1 % 2 == 0) {
            result = arg0 - arg1;
        }else if(arg0 % 2 != 0 && arg1 % 2 != 0) {
            result = arg1 - arg0;
        }else if(arg0 % 2 != 0 && arg1 % 2 == 0) {
            result = 1;
        }
        return result;
        // int result;
        // if(arg0 % 2 == 0) {
        //     if(arg1 % 2 == 0) {
        //         result = arg0.compareTo(arg1);
        //     }else {
        //         result = -1;
        //     }
        // } else{
        //     if(arg1 % 2 == 0) {
        //         result = 1;
        //     }else {
        //         result = arg0.compareTo(arg1) * -1;
        //     }
        // } 
        // return result;
    }

}
