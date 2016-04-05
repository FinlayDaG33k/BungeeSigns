/*    */ package de.finlaydag33k.BungeeSigns;
/*    */ 
/*    */ import de.finlaydag33k.Listeners.BlockBreakListeners;
/*    */ import de.finlaydag33k.Listeners.SignInteractListeners;
/*    */ import de.finlaydag33k.Managers.SettingsManager;
/*    */ import de.finlaydag33k.Util.CreatingPlayer;
/*    */ import de.finlaydag33k.Util.PlayerSender;
/*    */ import de.finlaydag33k.Util.SignScheduler;
/*    */ import de.finlaydag33k.Util.SpigotPluginUpdater;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.block.Sign;
/*    */ import org.bukkit.command.ConsoleCommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.plugin.PluginDescriptionFile;
/*    */ 
/*    */ public class BungeeSigns extends org.bukkit.plugin.java.JavaPlugin
/*    */ {
/* 21 */   public CreatingPlayer creatingPlayer = new CreatingPlayer();
/*    */   private static BungeeSigns singplugin;
/*    */   
/*    */   public static BungeeSigns getSingplugin()
/*    */   {
/* 26 */     return singplugin;
/*    */   }
/*    */   
/* 29 */   private String signPrefixAndSuffix = ChatColor.DARK_GREEN + "---------------";
/*    */   
/* 31 */   public String getSignPrefixAndSuffix() { return this.signPrefixAndSuffix; }
/*    */   
/*    */   public void setSignPrefixAndSuffix(String signPrefixAndSuffix) {
/* 34 */     this.signPrefixAndSuffix = signPrefixAndSuffix;
/*    */   }
/*    */   
/* 37 */   private String prefix = ChatColor.DARK_PURPLE + "Sign" + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY;
/*    */   
/* 39 */   public String getPrefix() { return this.prefix; }
/*    */   
/*    */   public void setPrefix(String prefix) {
/* 42 */     this.prefix = prefix;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onEnable()
/*    */   {
/* 50 */     SpigotPluginUpdater spigotPluginUpdater = new SpigotPluginUpdater(this, "http://www.finlaydag33k.de/BungeeSigns.html");
/* 51 */     if (spigotPluginUpdater.needsUpdate()) {
/* 52 */       spigotPluginUpdater.update();
/*    */     }
/*    */     else {
/* 55 */       getServer().broadcastMessage(getPrefix() + "Neuste Version vorhanden! Version: " + getDescription().getVersion());
/*    */     }
/*    */     
/* 58 */     SettingsManager.setBungeeSigns(this);
/* 59 */     getConfig().options().copyDefaults(true);
/* 60 */     singplugin = this;
/* 61 */     SignScheduler.setPlugin(this);
/* 62 */     registerCommands();
/* 63 */     registerListeners();
/* 64 */     getServer().getConsoleSender().sendMessage(singplugin.getPrefix() + "BungeeSigns angeschaltet!");
/* 65 */     PlayerSender.setBungeeSigns(this);
/*    */     
/* 67 */     for (Map.Entry<Sign, String> entry : SettingsManager.getSigns().entrySet()) {
/* 68 */       Sign sign = (Sign)entry.getKey();
/* 69 */       String signName = (String)entry.getValue();
/* 70 */       SignScheduler.createSignScheduler(sign, SettingsManager.getIp(signName), SettingsManager.getPort(signName));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onDisable()
/*    */   {
/* 81 */     singplugin = null;
/* 82 */     SignScheduler.killSchedulers();
/* 83 */     SignScheduler.setPlugin(null);
/*    */   }
/*    */   
/* 86 */   private void registerCommands() { getCommand("createsign").setExecutor(new de.finlaydag33k.Commands.CreateSignCommand(this)); }
/*    */   
/*    */   private void registerListeners() {
/* 89 */     new de.finlaydag33k.Listeners.CreateSignListeners(this);
/* 90 */     new SignInteractListeners(this);
/* 91 */     new BlockBreakListeners(this);
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\BungeeSigns\BungeeSigns.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */