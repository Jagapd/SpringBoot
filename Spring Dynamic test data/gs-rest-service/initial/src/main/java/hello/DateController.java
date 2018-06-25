package hello;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Date controller.
 */
@RestController
public class DateController {


    /**
     * Current date int [ ].
     *
     * @return the int [ ]
     */
    @RequestMapping("/getcurrentdate")
    public int[] currentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
        String currentdate = dateOnly.format(cal.getTime());
        String[] sep = currentdate.split("/");
        int[] array = Arrays.asList(sep).stream().mapToInt(Integer::parseInt).toArray();
        return array;

    }

    /**
     * Get previous date int [ ].
     *
     * @param days the days
     * @return the int [ ]
     */
    @RequestMapping("/getpreviousdate")
    public int[] getPreviousDate(@RequestParam(value = "date") int days) {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Today's date is " + dateFormat.format(cal.getTime()));
        cal.add(Calendar.DATE, Integer.parseInt("-" + days));
        String previousDate = dateFormat.format(cal.getTime());
        String[] pre = previousDate.split("/");
        int[] array = Arrays.asList(pre).stream().mapToInt(Integer::parseInt).toArray();
        return array;
    }

    /**
     * Get future date int [ ].
     *
     * @param days the days
     * @return the int [ ]
     */
    @RequestMapping("/getfuturedate")
    public int[] getFutureDate(@RequestParam(value = "date") int days) {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Today's date is " + dateFormat.format(cal.getTime()));
        cal.add(Calendar.DATE, Integer.parseInt("+" + days));
        String previousDate = dateFormat.format(cal.getTime());
        String[] pre = previousDate.split("/");
        int[] array = Arrays.asList(pre).stream().mapToInt(Integer::parseInt).toArray();
        return array;
    }

    /**
     * Gets randome string.
     *
     * @param count     the count
     * @param fromCount the from count
     * @param toCount   the to count
     * @param letters   the letters
     * @param numbers   the numbers
     * @param model     the model
     * @return the randome string
     */
/*  @RequestMapping("/getRandomString")
      public String getRandomeString(@RequestParam(value="count") int count)
      {
          String result;
          result = RandomStringUtils.randomAlphabetic(count);
          return result;
      }
  */
    @RequestMapping("/getRandomString")
    public String getRandomeString(@RequestParam int count, @RequestParam int fromCount, @RequestParam int toCount, @RequestParam boolean letters, @RequestParam boolean numbers, Model model) {
        model.addAttribute("count", count);
        model.addAttribute("fromCount", fromCount);
        model.addAttribute("toCount", toCount);
        model.addAttribute("letters", letters);
        model.addAttribute("numbers", numbers);
        String result;
        result = RandomStringUtils.random(count, fromCount, toCount, letters, numbers);
        return result;
    }

    /**
     * Gets random string.
     *
     * @param fromCount the from count
     * @param toCount   the to count
     * @param model     the model
     * @return the random string
     */
    @RequestMapping("/getRandomStringinrange")
    public String getRandomString(@RequestParam int fromCount, @RequestParam int toCount, Model model) {
        model.addAttribute("fromCount", fromCount);
        model.addAttribute("toCount", toCount);
        String result = RandomStringUtils.randomAlphabetic(fromCount, toCount);
        return result;
    }

    /**
     * Gets random string.
     *
     * @param count the count
     * @return the random string
     */
    @RequestMapping("/getRandomStringwithSpecialCharacter")
    public String getRandomString(@RequestParam int count) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String result = RandomStringUtils.random(count, characters);
        return result;
    }


    /**
     * Get random words string [ ].
     *
     * @param wordlength the wordlength
     * @return the string [ ]
     */
    @RequestMapping("/getRandomWords")
    public String[] getRandomWords(@RequestParam int wordlength)
    {
        String[] randomStrings = new String[wordlength];
        Random random = new Random();
        for (int i = 0; i < wordlength; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }


}



