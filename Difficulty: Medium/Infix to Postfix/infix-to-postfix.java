class Solution {
    public String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        map.put('^',3);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                res.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && st.peek()!='(' &&
                (map.getOrDefault(st.peek(),0) > map.getOrDefault(c,0) ||
                (map.getOrDefault(st.peek(),0) == map.getOrDefault(c,0) && c!='^')))
                {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.toString();
    }
}