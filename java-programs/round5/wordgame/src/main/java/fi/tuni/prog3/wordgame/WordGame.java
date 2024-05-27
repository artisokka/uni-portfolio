/* Janika Ranta
 * K96384
 */
package fi.tuni.prog3.wordgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordGame {

    private WordGameState state = new WordGameState("", 0, 0, 0);
    private boolean isActive = false;
    private ArrayList<String> wordList = new ArrayList<>();
    private String guessed = "";

    public static class WordGameState {
        private String word;
        private String realWord;
        private int mistakes;
        private int mistakeLimit;
        private int missingChars;

        private WordGameState(String word_, int mistakes_, int mistakeLimit_,
                int missingChars_) {
            word = word_;
            mistakes = mistakes_;
            mistakeLimit = mistakeLimit_;
            missingChars = missingChars_;

        }

        public String getWord() {
            return word;
        }

        public int getMistakes() {
            return mistakes;
        }

        public int getMistakeLimit() {
            return mistakeLimit;
        }

        public int getMissingChars() {
            return missingChars;
        }
    }

    public WordGame(String wordFileName) throws IOException {
        var wordFile = new BufferedReader(new FileReader(wordFileName));
        String line;
        while ((line = wordFile.readLine()) != null) {
            wordList.add(line);
        }
    }

    public void initGame(int wordIndex, int mistakeLimit) {

        this.state.realWord = wordList.get(wordIndex % wordList.size());
        this.state.mistakeLimit = mistakeLimit;
        this.state.missingChars = this.state.realWord.length();
        this.state.mistakes = 0;
        isActive = true;
        this.state.word = "";
        this.guessed = "";

        for (int i = 0; i < this.state.realWord.length(); i++) {
            this.state.word += "_";
        }
    }

    public boolean isGameActive() {
        return isActive;
    }

    public WordGameState getGameState() throws GameStateException {
        if (!isActive) {
            throw new GameStateException(
                    "There is currently no active word game!");
        }
        return state;
    }

    public WordGameState guess(char c) throws GameStateException {
        if (!isActive) {
            throw new GameStateException(
                    "There is currently no active word game!");
        } else {
            String x = "" + Character.toLowerCase(c);

            if (this.state.realWord.contains(x)) {
                if (guessed.contains(x) == this.state.realWord.contains(x)) {
                    this.state.mistakes++;
                }
                else {
                    guessed += x;
                    String iterate = this.state.realWord;
                    int i = 0;
                    for (char y : iterate.toCharArray()) {

                        if (Character.toLowerCase(c) == y) {

                            // this.state.word =
                            StringBuilder str = new StringBuilder(
                                    this.state.word);
                            str.setCharAt(i, y);
                            this.state.word = str.toString();
                            this.state.missingChars--;
                        }
                        i++;
                    }
                    if (this.state.missingChars <= 0) {
                        isActive = false;
                    }
                }
            } else {
                this.state.mistakes++;
                if (this.state.mistakes > this.state.mistakeLimit) {
                    this.state.word = this.state.realWord;
                    isActive = false;
                }
            }
        }
        return state;
    }

    public WordGameState guess(String w) throws GameStateException {
        // arvaa sana w
        if (!isActive) {
            throw new GameStateException(
                    "There is currently no active word game!");
        } else {
            String lower = "";
            for (var c : w.toCharArray()) {
                lower += Character.toLowerCase(c);
            }
            if (this.state.realWord.contains(lower) && this.state.realWord.
                    length() ==
                    w.
                            length()) {
                this.state.missingChars = 0;
                this.state.word = this.state.realWord;
                isActive = false;
            } else {

                this.state.mistakes++;
            }
            if (this.state.mistakes > this.state.mistakeLimit) {
                this.state.word = this.state.realWord;
                isActive = false;
            }
        }
        return state;
    }
}
