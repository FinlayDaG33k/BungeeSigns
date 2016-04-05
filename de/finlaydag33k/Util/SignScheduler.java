/*    */ package de.finlaydag33k.Util;
/*    */ 
/*    */ import de.finlaydag33k.BungeeSigns.BungeeSigns;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.block.Sign;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ 
/*    */ public class SignScheduler
/*    */ {
/* 13 */   private static ArrayList<Integer> schedulers = new ArrayList();
/*    */   private static BungeeSigns plugin;
/*    */   
/* 16 */   public static void killSchedulers() { for (Integer scheduler : schedulers)
/*    */     {
/* 18 */       Bukkit.getScheduler().cancelTask(scheduler.intValue());
/*    */     }
/*    */   }
/*    */   
/*    */   public static void setPlugin(BungeeSigns plugin)
/*    */   {
/* 24 */     plugin = plugin;
/*    */   }
/*    */   
/*    */   public static void createSignScheduler(final Sign sign, String ip, Integer port) {
/* 28 */     if (port.intValue() == 99999)
/*    */     {
/* 30 */       sign.setLine(2, "Edit Config!");
/* 31 */       sign.update();
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     PingServer pingServer = new PingServer(ip, port.intValue());
/*    */     
/*    */ 
/* 38 */     int scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
/*    */     {
/*    */       public void run() {
/* 41 */         this.val$pingServer.update();
/* 42 */         if (!this.val$pingServer.isOnline())
/*    */         {
/* 44 */           sign.setLine(2, ChatColor.DARK_RED + "OFFLINE");
/* 45 */           sign.update();
/*    */         }
/*    */         else {
/* 48 */           sign.setLine(2, ChatColor.DARK_GREEN + this.val$pingServer.getOnline().toString() + ChatColor.BLACK + " / " + ChatColor.DARK_GREEN + this.val$pingServer.getMax().toString());
/* 49 */           sign.update(); } } }, 5L, 200L);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 58 */     schedulers.add(Integer.valueOf(scheduler));
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Util\SignScheduler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */