/*    */ package de.finlaydag33k.Listeners;
/*    */ 
/*    */ import de.finlaydag33k.Managers.SettingsManager;
/*    */ import de.finlaydag33k.BungeeSigns.BungeeSigns;
/*    */ import de.finlaydag33k.Util.PingServer;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.Sign;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ 
/*    */ public class SignInteractListeners implements org.bukkit.event.Listener
/*    */ {
/*    */   private BungeeSigns plugin;
/*    */   
/*    */   public SignInteractListeners(BungeeSigns BungeeSigns)
/*    */   {
/* 20 */     this.plugin = BungeeSigns;
/* 21 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/*    */   }
/*    */   
/*    */ 
/*    */   @EventHandler
/*    */   public void onSignInteract(PlayerInteractEvent event)
/*    */   {
/* 28 */     Player player = event.getPlayer();
/* 29 */     if (event.getAction() != org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) return;
/* 30 */     if (!(event.getClickedBlock().getState() instanceof Sign)) { return;
/*    */     }
/* 32 */     Sign sign = (Sign)event.getClickedBlock().getState();
/*    */     
/* 34 */     if (!sign.getLine(0).equalsIgnoreCase(this.plugin.getSignPrefixAndSuffix())) { return;
/*    */     }
/*    */     
/* 37 */     if (SettingsManager.getPort(sign.getLine(1)).intValue() == 99999) return;
/* 38 */     if (!new PingServer(this.plugin.getServer().getIp(), SettingsManager.getPort(sign.getLine(1)).intValue()).isOnline()) {
/* 39 */       player.sendMessage(this.plugin.getPrefix() + "Der Server ist OFFLINE!");
/* 40 */       event.setCancelled(true);
/* 41 */       return;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 46 */     String signName = sign.getLine(1);
/* 47 */     if (!this.plugin.creatingPlayer.isFinish()) { event.setCancelled(true);return; }
/* 48 */     de.finlaydag33k.Util.PlayerSender.sendPlayerServer(player, SettingsManager.getServer(signName));
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Listeners\SignInteractListeners.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */