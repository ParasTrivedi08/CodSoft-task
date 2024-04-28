    import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.Scanner;
    import java.util.HashMap;
    
    public class WordCounter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String text = "";
    
            System.out.println("Welcome to Word Counter!");
    
            // Step 1: Prompt the user to enter text or provide a file
            System.out.print("Enter 'text' to input text manually, or 'file' to provide a file: ");
            String inputMethod = scanner.nextLine();
    
            // Step 2: Read the input text or file and store it in a string
            if (inputMethod.equalsIgnoreCase("text")) {
                System.out.print("Enter your text: ");
                text = scanner.nextLine();
            } else if (inputMethod.equalsIgnoreCase("file")) {
                System.out.print("Enter the path to the file: ");
                String filePath = scanner.nextLine();
                try {
                    text = readFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found. Please check the file path and try again.");
                    return;
                }
            } else {
                System.out.println("Invalid input method. Please choose 'text' or 'file'.");
                return;
            }
    
            // Step 3: Split the string into an array of words using space or punctuation as delimiters
            String[] words = text.split("\\s+|\\p{Punct}+");
    
            // Step 4: Initialize a counter variable to keep track of the number of words
            int wordCount = 0;
    
            // Step 5: Iterate through the array of words and increment the counter for each word encountered
            HashMap<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount++;
                    // Step 8: Count the frequency of each word
                    wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
                }
            }
    
            // Step 6: Display the total count of words to the user
            System.out.println("Total number of words: " + wordCount);
    
            // Step 8: Display statistics like the number of unique words and frequency of each word
            System.out.println("Number of unique words: " + wordFrequency.size());
            System.out.println("Word frequency:");
            for (String word : wordFrequency.keySet()) {
                System.out.println(word + ": " + wordFrequency.get(word));
            }
        }
    
        // Method to read a file and return its content as a string
        private static String readFile(String filePath) throws FileNotFoundException {
            StringBuilder content = new StringBuilder();
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
            fileScanner.close();
            return content.toString();
        }
    }
