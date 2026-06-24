class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap <Character,Integer> f=new HashMap<>();
        HashMap <Character,Integer> s=new HashMap<>();
    for(char ch:ransomNote.toCharArray()){
            int current=f.getOrDefault(ch,0);
            int n=current+1;
            f.put(ch,n);
    }
    for(char ch:magazine.toCharArray()){
            int current=s.getOrDefault(ch,0);
            int n=current+1;
            s.put(ch,n);
    }
    for (char ch : f.keySet()) {
    if (f.getOrDefault(ch, 0) > s.getOrDefault(ch, 0)) {
        return false;
    }
}
return true;
}
}