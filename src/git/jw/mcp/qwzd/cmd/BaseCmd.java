package git.jw.mcp.qwzd.cmd;

import git.jw.mcp.qwzd.QwLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class BaseCmd implements CommandExecutor {
    private boolean isAdminOnly=true;
    private boolean isPlayerOnly =false;
    protected abstract String getName();
    public BaseCmd(JavaPlugin plugin){
        plugin.getCommand(getName()).setExecutor(this);
    }
    public short getArgLength() {
        return argLength;
    }

    public void setArgLength(short argLength) {
        this.argLength = argLength;
    }

    private short argLength=0;
    public boolean isAdminOnly() {
        return isAdminOnly;
    }

    public void setAdminOnly(boolean adminOnly) {
        isAdminOnly = adminOnly;
    }

    public boolean isPlayerOnly() {
        return isPlayerOnly;
    }

    public void setPlayerOnly(boolean consoleOnly) {
        isPlayerOnly = consoleOnly;
    }
    public abstract boolean exec(CommandSender sender, String[] args);
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!command.getName().equalsIgnoreCase(getName())){
            return true;
        }

        if(isAdminOnly&&!commandSender.isOp()){
            commandSender.sendMessage("OP ONLY");
            return true;
        }
        if(isPlayerOnly()){
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("Player ONLY");
                return true;
            }
        if(strings.toString().length()>=30){
                ((Player) commandSender).kickPlayer("Fuck You Hacker");
        }
        }
       // System.out.println("Atesting"+command.getName());
        if(getArgLength()!=strings.length){
            commandSender.sendMessage("不对的参数哟");
            return false;
        }
    //    System.out.println("Btesting"+command.getName());
        return exec(commandSender, strings);
    }
}
