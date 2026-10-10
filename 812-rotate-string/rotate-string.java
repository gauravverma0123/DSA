class Solution {
    public boolean rotateString(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        String concatenated= s1+s1;
        
        return concatenated.contains(s2);
    }
}