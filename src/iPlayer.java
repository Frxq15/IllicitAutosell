import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class iPlayer {
    private final UUID uuid;
    private boolean hasEnabled;

    private boolean inTimer;
    private final static Map<UUID, iPlayer> players = new HashMap<>();
    private double money;
    private int gems;
    private int tokens;

    public iPlayer(UUID uuid) {
        this.uuid = uuid;
        players.put(uuid, this);
    }
    public static void removePlayerData(UUID uuid) { players.remove(uuid); }
    public static Map<UUID, iPlayer> getAllPlayerData() {
        return players;
    }
    public boolean hasEnabled() {
        return hasEnabled;
    }
    public double getMoney() {
        return money;
    }
    public int getGems() {
        return gems;
    }
    public int getTokens() {
        return tokens;
    }
    public boolean isInTimer() {
        return inTimer;
    }
    public void addMoney(double amount) {
        this.money += amount;
    }
    public void addGems(int amount) {
        this.gems += amount;
    }
    public void addTokens(int amount) {
        this.tokens += amount;
    }
    public void setMoney(int amount) {
        this.money = amount;
    }
    public void setGems(int amount) {
        this.gems = amount;
    }
    public void setTokens(int amount) {
        this.tokens = amount;
    }
    public void setEnabled(boolean enabled) {
        hasEnabled = enabled;
    }
    public void setInTimer(boolean inTimer) {
        this.inTimer = inTimer;
    }
    public void startTimer() {}

    public static iPlayer getPlayerData(IllicitAutosell plugin, UUID uuid) {
        if (!players.containsKey(uuid)) {
            iPlayer iPlayer = new iPlayer(uuid);
            iPlayer.setEnabled(true);
            iPlayer.setMoney(0);
            iPlayer.setGems(0);
            iPlayer.setTokens(0);
        }
        return players.get(uuid);
    }
}
