import dev.drawethree.ultraprisoncore.UltraPrisonCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class IllicitAutosell extends JavaPlugin {
    private static IllicitAutosell instance;
    private UltraPrisonCore ultraPrisonCore;

    public void onEnable() {
        instance = this;
        if (!Bukkit.getPluginManager().isPluginEnabled("UltraPrisonCore")) {
            this.getLogger().warning("Unable to hook into UltraPrisonCore! Disabling...");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.ultraPrisonCore = UltraPrisonCore.getInstance();
        getLogger().info("IllicitAutosell enabled successfully.");
    }
    public void onDisable() {
        getLogger().info("IllicitAutosell disabled.");
    }
    public static IllicitAutosell getInstance() {
        return instance;
    }
    public UltraPrisonCore getUltraPrisonCore() { return ultraPrisonCore; }
}