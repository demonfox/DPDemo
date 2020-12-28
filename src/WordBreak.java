import java.util.HashSet;

class WordBreak {
    public int backtrackingTime = 0;
    public int dpTime = 0;

    public boolean wordBreakBacktracking(String s, HashSet<String> dict, String answer) {
        // System.out.println(s + " " + answer);
        if (s.length() == 0) {
            System.out.println(answer + ", time cost: " + backtrackingTime);
            return true;
        } else {
            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);// add one char at a time
                backtrackingTime++;
                // check if word exists in dictionary
                if (dict.contains(word)) {
                    // add word to the answer and make a recursive call
                    if (wordBreakBacktracking(s.substring(index + 1), dict, answer + word + " ")) {
                        return true;
                    } else {
                        // Using "word" as part of the answer does not work, so backtrack
                        index++;
                    }
                } else {
                    // the current "word" does not exist in the dict, so continue to next char
                    index++;
                }
            }
            return false;
        }
    }

    public boolean wordBreakDP(String s, HashSet<String> dict, HashSet<String> memory, String answer) {
        if (s.length() == 0) {
            // this is the branch where we have found an answer
            System.out.println(answer + ", time cost: " + dpTime);
            return true;
        } else if (memory.contains(s)) {
            // this is the branch where we know from past knoledge that we
            // would not find an answer down this path
            dpTime++;
            System.out.println("Ha: " + s);
            return false;
        } else {
            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);// add one char at a time
                dpTime++;
                if (dict.contains(word)) {
                    if (wordBreakDP(s.substring(index + 1), dict, memory, answer + word + " ")) {
                        return true;
                    } else {
                        // Using "word" as part of the answer does not work, so backtrack
                        index++;
                    }
                } else {
                    // the current "word" does not exist in the dict, so continue to next char
                    index++;
                }
            }
            // we reach here because for the current iteration on string "s", there is no answer
            // for it, so let's memorize that to avoid computing this again in the future
            System.out.println("Added: " + s);
            memory.add(s);
            return false;
        }
    }
    
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        dict.add("this");
        dict.add("is");
        dict.add("cat");
        dict.add("dog");
        dict.add("catdogthis");
        String s = "catdongthisdogcatthis";

        WordBreak ws = new WordBreak();
        if(!ws.wordBreakBacktracking(s, dict, ""))
            System.out.println("Cannot break the word, time cost: " + ws.backtrackingTime);
        HashSet<String> memory = new HashSet<String>();
        if(!ws.wordBreakDP(s, dict, memory, ""))
            System.out.println("Cannot break the word, time cost: " + ws.dpTime);

        dict.clear();
        dict.add("cat");
        dict.add("dog");
        dict.add("catdog");
        dict.add("catdogthis");
        s = "catdogthis";
        memory.clear();
        if(!ws.wordBreakBacktracking(s, dict, ""))
            System.out.println("Cannot break the word, time cost: " + ws.backtrackingTime);
        if(!ws.wordBreakDP(s, dict, memory, ""))
            System.out.println("Cannot break the word, time cost: " + ws.dpTime);
    }
}