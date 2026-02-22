public class Palindrome {
    
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<Character>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            result.addLast(c);
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        int n = word.length();
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        int n = word.length();
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;
            if (!cc.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
        }
        return true;
    }

}
