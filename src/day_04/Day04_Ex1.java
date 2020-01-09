package day_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day04_Ex1 {
    public static void main(String[] args) {
        System.out.println("----------- START EXERCISE 1 ---------");
        List<String> fileContents = readFileContentAsList("test.txt");

        System.out.println("*** a. Print all contents of file: ***");
        printAllWords(fileContents);

        System.out.println("\n\n*** b. Print file content in reverse order ***");
        printAllWordsInReverseOrder(fileContents);

        System.out.println("\n\n*** c. Print all words ending with \"s\" ***");
        printAllWordsEndingWithS(fileContents);

        System.out.println("\n\n*** d. Remove all duplicate words and print the rest ***");
        removeAllDuplicatedWordsAndPrintTheRest(fileContents);

        System.out.println("\n\n*** e. Find all the duplicated words ***");
        findAllTheDuplicatedWords(fileContents);

        System.out.println("\n\n*** f. Print the words and the frequency ***");
        printTheWordAndFrequency(fileContents);

        System.out.println("\n\n*** g. Replace every word ending with an \"es\" with its lower version ***");
        replaceEveryWordEndingWithEsByItsLowerVersion(fileContents);

        System.out.println("\n\n*** h. Removes every word in the list ending with an \"as\", case-insensitively ***");
        removeEveryWordEndingWithAS(fileContents);

        System.out.println("\n\n*** i. Insert a \"*\" after each element ***");
        insertAStarAfterEachElement(fileContents);

        System.out.println("----------- END EXERCISE 1 ---------\n\n");
    }

    /**
     * Convert file content to list
     *
     * @param fileName
     * @return
     */
    static List<String> readFileContentAsList(String fileName) {
        List<String> contents = new ArrayList<String>();
        try {
            File file = new File(System.getProperty("user.dir") + "/src/" + fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (data != null && !data.isEmpty()) {
                    contents.addAll(Arrays.asList(data.split(" ")));
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return contents;
    }

    static void printAllWords(List<String> fileContents) {
        if (fileContents != null) {
            for (int i = 0; i < fileContents.size(); i++) {
                System.out.println(fileContents.get(i));
            }
        }
    }

    static void printAllWordsInReverseOrder(List<String> fileContents) {
        if (fileContents != null) {
            for (int i = fileContents.size() - 1; i >= 0; i--) {
                System.out.println(fileContents.get(i));
            }
        }
    }

    static void printAllWordsEndingWithS(List<String> fileContents) {
        if (fileContents != null) {
            for (int i = 0; i < fileContents.size(); i++) {
                if (fileContents.get(i).endsWith("s")) {
                    System.out.println(fileContents.get(i));
                }
            }
        }
    }

    private static void removeAllDuplicatedWordsAndPrintTheRest(List<String> fileContents) {
        List<String> nonDuplicatedWords = new ArrayList<String>();
        for (String s : fileContents) {
            if (!nonDuplicatedWords.contains(s)) {
                nonDuplicatedWords.add(s);
            }
        }

        printAllWords(nonDuplicatedWords);
    }

    private static void findAllTheDuplicatedWords(List<String> fileContents) {
        List<String> duplicatedWords = new ArrayList<String>();
        for (int i = 0; i < fileContents.size(); i++) {
            String word = fileContents.get(i);

            // Find last appearance
            int lastOccur = fileContents.lastIndexOf(word);

            if (lastOccur >= 0 && lastOccur != i && !duplicatedWords.contains(word)) {
                duplicatedWords.add(word);
            }
        }

        printAllWords(duplicatedWords);
    }

    private static void printTheWordAndFrequency(List<String> fileContents) {
        List<String> checkedWords = new ArrayList<String>();
        for (int i = 0; i < fileContents.size() - 1; i++) {
            String word = fileContents.get(i);
            if (!checkedWords.contains(word)) {
                checkedWords.add(word);
                int count = 1;
                for (int j = i + 1; j < fileContents.size(); j++) {
                    if (fileContents.get(j).equals(word)) {
                        count++;
                    }
                }
                System.out.println(String.format("%s appears %d times", word, count));
            }
        }
    }

    private static void replaceEveryWordEndingWithEsByItsLowerVersion(List<String> fileContents) {
        List<String> newWords = new ArrayList<String>();
        for (int i = 0; i < fileContents.size(); i++) {
            String word = fileContents.get(i);
            if (word.endsWith("es")) {
                newWords.add(word.toLowerCase() + " <----------");
            } else {
                newWords.add(word);
            }
        }

        printAllWords(newWords);
    }

    private static void removeEveryWordEndingWithAS(List<String> fileContents) {
        List<String> newWords = new ArrayList<String>();
        for (int i = 0; i < fileContents.size(); i++) {
            String word = fileContents.get(i);
            if (!word.endsWith("as")) {
                newWords.add(word);
            }
        }

        printAllWords(newWords);
    }

    private static void insertAStarAfterEachElement(List<String> fileContents) {
        List<String> newWords = new ArrayList<String>();
        for (int i = 0; i < fileContents.size(); i++) {
            String word = fileContents.get(i);
            newWords.add(word + "*");
        }

        printAllWords(newWords);
    }
}
