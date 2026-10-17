class Solution {
    public int passwordStrength(String password) {
        int sum = 0;
        Set<Character> s = new HashSet<>();
        for(char x: password.toCharArray()){
            s.add(x);
        }
        for(char ch : s){
            if(ch>='a' && ch<='z'){
                sum += 1;
            }
            if(ch>='A' && ch<='Z'){
                sum += 2;
            }
            if(ch>='0' && ch<='9'){
                sum += 3;
            }
            if(ch=='!' || ch=='@' || ch=='#' || ch=='$'){
                sum += 5;
            }
        }
        return sum;
    }
}