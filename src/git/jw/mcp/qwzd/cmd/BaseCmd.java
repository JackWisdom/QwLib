package git.jw.mcp.qwzd.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class BaseCmd implements CommandExecutor {
    private boolean isAdminOnly=true;
    private boolean isConsoleOnly=true;
    private CmdConstruct struct;
    public BaseCmd(){
        struct=new CmdConstruct();
    }
    public BaseCmd(CmdConstruct cmdConstruct){
        this.struct=cmdConstruct;
    }

    public void setStruct(CmdConstruct struct) {
        this.struct = struct;
    }
    public CmdConstruct getStruct(){
        return struct;
    }
    public boolean isAdminOnly() {
        return isAdminOnly;
    }

    public void setAdminOnly(boolean adminOnly) {
        isAdminOnly = adminOnly;
    }

    public boolean isPlayerOnly() {
        return isConsoleOnly;
    }

    public void setPlayerOnly(boolean consoleOnly) {
        isConsoleOnly = consoleOnly;
    }
    public abstract boolean exec(CommandSender sender,String cmd,String[] args);
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(isAdminOnly&&!commandSender.isOp()){
            commandSender.sendMessage("OP ONLY");
            return true;
        }
        if(isPlayerOnly()&&!(commandSender instanceof Player)){
            commandSender.sendMessage("Player ONLY");
            return true;
        }
        if(!getStruct().Matches(strings)){
            commandSender.sendMessage("不对的参数哟");
        }

        return exec(commandSender,command.getName(),strings);
    }
}
