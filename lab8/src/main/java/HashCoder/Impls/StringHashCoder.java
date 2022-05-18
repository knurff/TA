package HashCoder.Impls;

import HashCoder.HashCoder;

public class StringHashCoder implements HashCoder {
    @Override
    public int getHashCode(Object o) {
        String s = (String) o;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = 31 * result + s.indexOf(i);
        }
        return result;
    }
}
