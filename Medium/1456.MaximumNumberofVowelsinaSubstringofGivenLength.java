class Solution {
    public int maxVowels(String s, int k) {
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> vowels = new ArrayList<>();
        for(char c: s.toCharArray()){
            list.add(c);
        }
        String vowel = "aeiou";
        for(char c: vowel.toCharArray()){
            vowels.add(c);
        }
        int left = 0;
        int ans = 0;
        int count = 0;
        int c = 0;
        for(int right = 0;right<s.length();right++){
            char ch = list.get(right);
            System.out.println(ch);
            if(vowels.contains(ch)){
                c++;
                System.out.println(c);
            }
            count++;
            if(count == k){
                ans = Math.max(ans, c);
                char lef = list.get(left);
                if(vowels.contains(lef)){
                    c = c-1;
                }
                left++;
                count--;
            }
            }
        return ans;
    }
}
