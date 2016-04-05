/*    */ package de.finlaydag33k.Commands;
/*    */ 
/*    */ import de.finlaydag33k.BungeeSigns.BungeeSigns;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CreateSignCommand implements org.bukkit.command.CommandExecutor
/*    */ {
/*    */   private BungeeSigns plugin;
/*    */   
/*    */   public CreateSignCommand(BungeeSigns BungeeSigns)
/*    */   {
/* 14 */     this.plugin = BungeeSigns;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     if (!(sender instanceof Player))
/*    */     {
/* 21 */       sender.sendMessage(this.plugin.getPrefix() + "This command can only be ran by a player!");
/* 22 */       return true;
/*    */     }
/* 24 */     Player player = (Player)sender;
/*    */     
/* 26 */     if (args.length < 2)
/*    */     {
/* 28 */       player.sendMessage(this.plugin.getPrefix() + "Please provide the proper arguments!: /createsign /createsign <Name of the Sign> <Name of the Server> <IP> <Port>");
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     if (!this.plugin.creatingPlayer.isFinish())
/*    */     {
/* 34 */       player.sendMessage(this.plugin.getPrefix() + "Another player is already using that sign!");
/* 35 */       return true;
/*    */     }
/*    */     
/* 38 */     String signName = args[0];
/* 39 */     String serverName = args[1];
/*    */     
/* 41 */     player.sendMessage(this.plugin.getPrefix() + "Click on a sign");
/* 42 */     this.plugin.creatingPlayer.initialise(player, signName, serverName);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Commands\CreateSignCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */