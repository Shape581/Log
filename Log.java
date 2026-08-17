import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.file.Files;

public class Log {
    private static JavaPlugin plugin;
    private static File logFile;

    public static void initialize(JavaPlugin plugin) {
        Log.plugin = plugin;
        logFile = new File(plugin.getDataFolder(), "logs.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String message) {
        try {
            Files.writeString(logFile.toPath(), "[" + java.time.LocalDateTime.now() + "] " + message + System.lineSeparator(), java.nio.file.StandardOpenOption.APPEND);
        } catch (Exception e) {
            plugin.getLogger().severe("Failed to write log line to logs.txt");
            e.printStackTrace();
        }
    }
}
