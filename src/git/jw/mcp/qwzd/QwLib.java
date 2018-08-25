package git.jw.mcp.qwzd;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class QwLib {
    public static void startTimer(Plugin plugin, BukkitRunnable runnable, int second){
        int time=second*20;
        runnable.runTaskTimerAsynchronously(plugin,0,second);
    }
    public static void startTask(Plugin plugin,BukkitRunnable runnable,int second){
        int time=second*20;
        runnable.runTaskLaterAsynchronously(plugin,second);
    }

}
