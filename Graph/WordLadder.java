package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/word-ladder/description/

public class WordLadder {
    static class Pair{
        String w;
        int v;

        Pair(String w, int v){
            this.w = w;
            this.v = v;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<wordList.size(); i++){
            map.put(wordList.get(i), 1);
        }

        if(!map.containsKey(endWord))
            return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String w = p.w;
            int val = p.v;

            char[] s = w.toCharArray();

            if(w.equals(endWord))
                return val;
            
            for(int i=0; i<s.length; i++){
                char ch = s[i];

                for(char c = 'a'; c <= 'z'; c++){
                    if(c == ch)
                        continue;

                    s[i] = c;
                    String word = new String(s);
                    if(map.containsKey(word)){
                        q.offer(new Pair(word, val+1));
                        map.remove(word);
                    }
                }
                s[i] = ch;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
            "hot", "dot", "dog", "lot", "log", "cog"
        );

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}