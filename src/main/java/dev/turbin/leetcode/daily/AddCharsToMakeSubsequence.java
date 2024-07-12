package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given two strings s and t consisting of only lowercase English letters.
 * Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
 */
@SpringBootTest
public class AddCharsToMakeSubsequence {

    @Test
    void test1() {
        assertThat(appendCharacters("coaching", "coding")).isEqualTo(4);
    }

    @Test
    void test2() {
        assertThat(appendCharacters("abcde", "a")).isEqualTo(0);
    }

    @Test
    void test3() {
        assertThat(appendCharacters("z", "abcde")).isEqualTo(5);
    }

    @Test
    void test4() {
        assertThat(appendCharacters("kmeqwbmaymnouefjdkqdzkgznooulizyerzqrelyrdlgvvtywugwhsvuhqwwzrogsxdtdbjlqqhmbnwvrdxfvavfjkawvxxbsavymfjplbafoljfilxumdxkauhithnuryedfseqdzwqdtfpfhnhzriivjlvcuwxpcrkalvkrvkxvcouxwhawmjjdnmhctfkwxhoxjggplgcstjnuxhfhaoniqcfvkekzjcycjjdkbefxkzejzhsdgnttecmrmddpllqijvqfrlczvwtvrnlslfnesatavkdocvtgqhjjkiiwzyigzfobvmjjudvhhtusvqhpysmbcyypmiazjttkljbhzyfbwonwrqrunaamqsahvfihwnxjffipwbihutdaezfsoztrqctloljvvevvdyrkmkyubjdgtvbowjiswdrivrbxatkkcxirvhkzrfmuwbslzcjincffnanjbovxahubcnravizpibdeansgxsbjjdyvnuqzlsznjvaezehegyvosoatfnnqvpqhpxthrnqgkgchjxkdmlpygxpgmcorchqveyxjogzryhvcozqkasumkaaevscaetpxhewwoewmizvaoulpuefmoishuifkvqxrxuebwclzzmgfoexbmkkjcfusdsyuesvpdnthfgdtnawluahukgfbonzobhlgmcelekiekoelnedixcipqivsehyvktihucbxghftbuslgapezebsskzvzcvhcmjeibzglckbaymwrckmnvmojxrknuwsfqijfgpnpkoshhvmnotpzacgsfgitvujoiuscsiebgdgzgletaruamhntjtwzteltbfzkvmmpwzfmzpfqnjgblkrulagfufxiptcywuqxepcrvlvvhaxgvxjedvqywywtjqsfyzywzajlfee", "dhjexhsvmnlifeeibuirosaaoxcnipishzcvzpixjfrjxhyzepigqktjashiszxdpdbyeqhcjcthogczowbmbtqxwvtbpxbpqgxzwlbwvzzvbknlgytaerzfzxumfondridapbwodizbmitrlriclhvnwwsrkdyjhzqtckfgpciqghxoeuuybuivqhvwdwricrppltbfhraiwticbvrlncooksgeuqatttysuuwqbuivekxcdbtlxyxplhobrsspcfalcwvbbcavljocxbwwpnncrswxqbkhioywrknmthcsxxldyembvkibjdgbsoyrfnmeccwxbvsstekwciclgbiplgfbvbgasntgofipcvhspoieyytruyuyauroyjdjoeqshubpyoaigzochuyroepjpzduwhudmnkewphjwkpgevyaxcgwbsdlvzwvkcmzblibddtjcgbkmpkwefthqkuiqptdqkpnuwrbwwpuxlombjufdowbqixooenjkvnslhhpjnmikmqsgobnsimhszzrsrdmuvbjdiixvzzlcdmevhdajybnxhvtbbasgpvqangnhkcfutlsndfylikjmktzmdcypchehhwusrvvsldqfygwwcoleueklokqqrel")).isEqualTo(5);
    }

    public int appendCharacters(String s, String t) {

        int i = 0;
        int j = -2;

        while (true) {

            int buf = s.indexOf(t.charAt(i), j);

            if (j >= buf || buf == -1) {
                break;
            }

            j = buf;

            i++;

            if (i == t.length()) {
                return 0;
            }

        }

        return t.length() - i;
    }
}
