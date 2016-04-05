/*    */ package de.finlaydag33k.Listeners;
/*    */ 
/*    */ import de.finlaydag33k.Managers.SettingsManager;
/*    */ import de.finlaydag33k.BungeeSigns.BungeeSigns;
/*    */ import de.finlaydag33k.Util.CreatingPlayer;
/*    */ import de.finlaydag33k.Util.SignScheduler;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.Sign;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class CreateSignListeners implements org.bukkit.event.Listener
/*    */ {
/*    */   private BungeeSigns plugin;
/*    */   
/*    */   public CreateSignListeners(BungeeSigns BungeeSigns)
/*    */   {
/* 22 */     this.plugin = BungeeSigns;
/* 23 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @EventHandler
/*    */   public void onPlayerInteract(PlayerInteractEvent event)
/*    */   {
/* 31 */     Player player = event.getPlayer();
/*    */     
/* 33 */     if ((this.plugin.creatingPlayer.getPlayer() != player) || (this.plugin.creatingPlayer.isFinish())) { return;
/*    */     }
/* 35 */     if (event.getAction() != org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) return;
/* 36 */     if ((!(event.getClickedBlock().getState() instanceof Sign)) || (!(event.getClickedBlock().getState() instanceof Sign))) { return;
/*    */     }
/* 38 */     Sign sign = (Sign)event.getClickedBlock().getState();
/*    */     
/*    */ 
/* 41 */     sign.setLine(0, this.plugin.getSignPrefixAndSuffix());
/* 42 */     sign.setLine(3, this.plugin.getSignPrefixAndSuffix());
/* 43 */     sign.setLine(1, this.plugin.creatingPlayer.getSignName());
/* 44 */     sign.update();
/*    */     
/* 46 */     SettingsManager.createSign(this.plugin.creatingPlayer.getSignName(), this.plugin.creatingPlayer.getServerName(), sign.getLocation());
/*    */     
/*    */ 
/* 49 */     org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*    */     {
/*    */ 
/* 52 */       public void run() { CreateSignListeners.this.plugin.creatingPlayer.heFinished(); } }, 5L);
/*    */     
/*    */ 
/*    */ 
/* 56 */     SignScheduler.createSignScheduler(sign, SettingsManager.getIp(sign.getLine(1)), SettingsManager.getPort(sign.getLine(1)));
/*    */     
/* 58 */     player.sendMessage(this.plugin.getPrefix() + "Das Sign wurde erstellt! Bearbeite nur noch in der Config den Port und die IP des Servers und schon werden auch die Informationen angezeigt!");
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Listeners\CreateSignListeners.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */