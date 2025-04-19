import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "input.txt"; // Replace with your actual file path

        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Normalize and split line into words
                String[] words = line.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Display total word count
            int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Total words: " + totalWords);

            // Sort by frequency (descending)
            List<Map.Entry<String, Integer>> sorted = new ArrayList<>(wordCount.entrySet());
            sorted.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Display top 5 frequent words
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sorted.size()); i++) {
                Map.Entry<String, Integer> entry = sorted.get(i);
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
