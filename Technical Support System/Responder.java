
/**
 * Write a description of class Responder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Responder.java
 * Versi ringkas dengan 7 keyword utama.
 */
public class Responder {
    private Map<String, String> responses;
    private Random random;

    public Responder() {
        responses = new HashMap<>();
        random = new Random();
        fillResponses();
    }

    /**
     * Tambahkan daftar keyword penting dan responnya.
     */
    private void fillResponses() {
        responses.put("bug", "A bug? Could you describe what happens and how to reproduce it?");
        responses.put("install", "Installation issues? Please ensure you have permission and enough storage.");
        responses.put("error", "An error message? Please share the exact message text here.");
        responses.put("save", "You can't save? Try checking the file permissions or available disk space.");
        responses.put("crash", "It sounds like your app crashed. Can you tell me what caused it?");
        responses.put("slow", "Hmm, a slow system. Have you tried restarting your device?");
        responses.put("internet", "Internet problems? Please check your Wi-Fi connection or restart your router.");
    }

    /**
     * Menghasilkan respon berdasarkan input pengguna.
     */
    public String generateResponse(String input) {
        String lower = input.toLowerCase();
        for (String keyword : responses.keySet()) {
            if (lower.contains(keyword)) {
                return responses.get(keyword);
            }
        }

        String[] defaultResponses = {
            "That sounds interesting. Tell me more...",
            "Can you explain that in more detail?",
            "I see. What do you think caused that?",
            "Please continue, I’m listening."
        };
        return defaultResponses[random.nextInt(defaultResponses.length)];
    }
}
