package git.jw.mcp.qwzd;

import git.jw.mcp.qwzd.date.DateManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class QwLib extends JavaPlugin {
    static DateManager dm;
    public static DateManager getDataManger(){
        return dm;
    }
    @Override
    public void onEnable(){
        dm=new DateManager();
        startTimer(this, new BukkitRunnable() {
            @Override
            public void run() {
                dm.reflush();
            }
        },30*60);
    }
    public static void startTimer(Plugin plugin, BukkitRunnable runnable, int second){
        int time=second*20;

        runnable.runTaskTimerAsynchronously(plugin,0,time);
    }
    public static void startTask(Plugin plugin,BukkitRunnable runnable,int second){
        int time=second*20;
        runnable.runTaskLaterAsynchronously(plugin,time);
    }

}
