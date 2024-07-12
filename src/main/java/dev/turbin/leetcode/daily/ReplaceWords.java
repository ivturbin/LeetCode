package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
 * replace all the derivatives in the sentence with the root forming it.
 * If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.
 */
@SpringBootTest
public class ReplaceWords {

    @Test
    void test1() {
        assertThat(replaceWords(List.of("cat","bat","rat"), "the cattle was rattled by the battery"))
                .isEqualTo("the cat was rat by the bat");
    }


    //Better
    public String replaceWords(List<String> dictionary, String sentence) {

        if (sentence.isEmpty() || dictionary.isEmpty()) {
            return sentence;
        }

        String[] split = sentence.split(" ");
        List<String> list = new ArrayList<>(dictionary.size());

        for (short i = 0; i < split.length; i++) {

            for (short j = 0; j < dictionary.size(); j++) {
                if (split[i].startsWith(dictionary.get(j))) {
                    list.add(dictionary.get(j));
                }
            }

            if (!list.isEmpty()) {
                list.sort(Comparator.comparing(String::length));
                split[i] = list.get(0);
                list = new ArrayList<>(dictionary.size());
            }
        }

        return String.join(" ", split);

    }

    public String replaceWords1(List<String> dictionary, String sentence) {

        if (sentence.isEmpty() || dictionary.isEmpty()) {
            return sentence;
        }

        StringBuilder result = new StringBuilder(sentence.length());

        int i = 0;
        int j = 0;

        sentence = sentence + " ";
        while (i < sentence.length()) {
            if (sentence.charAt(i) == ' ') {
                List<String> list = new ArrayList<>(dictionary.size());
                for (int k = 0; k < dictionary.size(); k++) {
                    if (sentence.substring(j, i).startsWith(dictionary.get(k))) {
                        list.add(dictionary.get(k));
                    }
                }

                if (!list.isEmpty()) {
                    list.sort(Comparator.comparing(String::length));
                    result.append(list.get(0));
                    result.append(" ");
                } else {
                    result.append(sentence, j, i);
                    result.append(" ");
                }

                j = ++i;
            } else {
                i++;
            }
        }

        return result.substring(0, result.length()-1);

    }
}
