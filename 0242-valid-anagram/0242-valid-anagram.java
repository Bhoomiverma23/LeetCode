class Solution {
    public boolean isAnagram(String s, String t) {
        char string1[] = s.toCharArray();
        char string2[] = t.toCharArray();
        Arrays.sort(string1);
        Arrays.sort(string2);
        if(Arrays.equals(string1,string2)){
            return true;
        }
        else{
            return false;
        }
    }
}