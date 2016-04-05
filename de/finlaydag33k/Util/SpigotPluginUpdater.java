/*     */ package de.finlaydag33k.Util;
/*     */ 
/*     */ import de.finlaydag33k.BungeeSigns.BungeeSigns;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.plugin.PluginDescriptionFile;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpigotPluginUpdater
/*     */ {
/*     */   private URL url;
/*     */   private BungeeSigns plugin;
/*     */   private String pluginurl;
/*     */   
/*     */   public SpigotPluginUpdater(BungeeSigns plugin, String pluginurl)
/*     */   {
/*     */     try
/*     */     {
/*  35 */       this.url = new URL(pluginurl);
/*     */     } catch (MalformedURLException e) {
/*  37 */       plugin.getServer().broadcastMessage(plugin.getPrefix() + "Error in checking update for: '" + pluginurl + "' invalid Pluginname!");
/*  38 */       System.out.println(" -- StackTrace --");
/*  39 */       e.printStackTrace();
/*  40 */       System.out.println(" -- End of StackTrace --");
/*     */     }
/*  42 */     this.plugin = plugin;
/*  43 */     this.pluginurl = pluginurl;
/*     */   }
/*     */   
/*     */ 
/*  47 */   private String version = "";
/*  48 */   private String downloadURL = "";
/*  49 */   private String changeLOG = "";
/*     */   
/*  51 */   private boolean out = true;
/*     */   
/*     */ 
/*     */   public void enableOut()
/*     */   {
/*  56 */     this.out = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void disableOut()
/*     */   {
/*  63 */     this.out = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean needsUpdate()
/*     */   {
/*     */     try
/*     */     {
/*  73 */       URLConnection con = this.url.openConnection();
/*  74 */       InputStream _in = con.getInputStream();
/*  75 */       Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(_in);
/*     */       
/*  77 */       Node nod = doc.getElementsByTagName("item").item(0);
/*  78 */       NodeList children = nod.getChildNodes();
/*     */       
/*  80 */       this.version = children.item(1).getTextContent();
/*  81 */       this.downloadURL = children.item(3).getTextContent();
/*  82 */       this.changeLOG = children.item(5).getTextContent();
/*  83 */       if (!this.version.replaceAll("[a-zA-z ]", "").equals(this.plugin.getDescription().getVersion())) {
/*  84 */         if (this.out) {
/*  85 */           this.plugin.getServer().broadcastMessage(this.plugin.getPrefix() + "Neue Version gefunden: " + this.version.replaceAll("[a-zA-z ]", ""));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  90 */         return true;
/*     */       }
/*     */     }
/*     */     catch (IOException|SAXException|ParserConfigurationException e) {
/*  94 */       this.plugin.getServer().broadcastMessage(this.plugin.getPrefix() + "Error in checking update for: '" + this.pluginurl + "' (invalid URL?) !");
/*  95 */       System.out.println(" -- StackTrace --");
/*  96 */       e.printStackTrace();
/*  97 */       System.out.println(" -- End of StackTrace --");
/*     */     }
/*     */     
/*     */ 
/* 101 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void update()
/*     */   {
/*     */     try
/*     */     {
/* 109 */       URL download = new URL(getFolder(this.pluginurl) + this.downloadURL);
/*     */       
/* 111 */       BufferedInputStream in = null;
/* 112 */       FileOutputStream fout = null;
/*     */       try {
/* 114 */         if (this.out)
/*     */         {
/* 116 */           this.plugin.getServer().broadcastMessage(this.plugin.getPrefix() + "Autoupdate gestartet!");
/*     */         }
/* 118 */         in = new BufferedInputStream(download.openStream());
/* 119 */         fout = new FileOutputStream("plugins/" + this.downloadURL);
/*     */         
/* 121 */         byte[] data = new byte['Ѐ'];
/*     */         int count;
/* 123 */         while ((count = in.read(data, 0, 1024)) != -1) {
/* 124 */           fout.write(data, 0, count);
/*     */         }
/*     */       } finally {
/* 127 */         if (in != null) {
/* 128 */           in.close();
/*     */         }
/* 130 */         if (fout != null) {
/* 131 */           fout.close();
/*     */         }
/*     */       }
/*     */       
/* 135 */       if (this.out)
/*     */       {
/* 137 */         this.plugin.getServer().broadcastMessage(this.plugin.getPrefix() + "Fertig!");
/* 138 */         this.plugin.getServer().broadcastMessage(this.plugin.getPrefix() + "Um alle neuen Funktionen zu erhalten, restarten sie den Server!");
/*     */       }
/*     */     } catch (IOException e) {
/* 141 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String getFolder(String s)
/*     */   {
/* 151 */     String path = s;
/* 152 */     int lastslash = path.lastIndexOf("/");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */     String folder = path.substring(0, lastslash + 1);
/* 160 */     return folder;
/*     */   }
/*     */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Util\SpigotPluginUpdater.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */