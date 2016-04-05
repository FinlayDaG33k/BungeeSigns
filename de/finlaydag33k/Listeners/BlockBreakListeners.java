/*    */ package de.finlaydag33k.Listeners;
/*    */ 
/*    */ import de.finlaydag33k.BungeeSigns.BungeeSigns;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.Sign;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ 
/*    */ public class BlockBreakListeners implements Listener
/*    */ {
/*    */   private final BungeeSigns plugin;
/*    */   
/*    */   public BlockBreakListeners(BungeeSigns BungeeSigns)
/*    */   {
/* 17 */     this.plugin = BungeeSigns;
/* 18 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/*    */   }
/*    */   
/*    */   @org.bukkit.event.EventHandler
/*    */   public void onSignBreak(BlockBreakEvent event)
/*    */   {
/* 24 */     if (!(event.getBlock().getState() instanceof Sign)) return;
/* 25 */     Sign sign = (Sign)event.getBlock().getState();
/* 26 */     if (sign.getLine(0).equalsIgnoreCase(this.plugin.getSignPrefixAndSuffix()))
/*    */     {
/* 28 */       Player player = event.getPlayer();
/* 29 */       if (!player.isSneaking())
/*    */       {
/* 31 */         player.sendMessage(this.plugin.getPrefix() + "Dieses Schild kannst du nur im sneaken abbauen!");
/* 32 */         event.setCancelled(true);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Listeners\BlockBreakListeners.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */