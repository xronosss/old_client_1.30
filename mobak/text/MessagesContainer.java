package mobak.text;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import mobak.Main2;
import mobak.a.SocketListener;
import mobak.b.a.Hero;

// $FF: renamed from: mobak.c.d
public final class MessagesContainer {

   // $FF: renamed from: a mobak.c.h
   public static PhraseCollection field_501;
   // $FF: renamed from: b mobak.c.h
   public static PhraseCollection characteristicsNames;
   // $FF: renamed from: c mobak.c.h
   public static PhraseCollection field_503;


   // $FF: renamed from: a (int, java.lang.String) void
   public static void method_568(int var0, String var1) {
      try {
         if(var1.indexOf("<?") >= 0) {
            StringBuffer var2;
            for(var2 = new StringBuffer(); var1.indexOf("<?") >= 0; var1 = var1.substring(var1.indexOf("?>") + 2)) {
               var2.append(var1.substring(0, var1.indexOf("<?")));
               String var3;
               if((var3 = (var1 = var1.substring(var1.indexOf("<?") + 2)).substring(0, var1.indexOf("?>"))).equals("n")) {
                  var2.append("\n");
               } else {
                  int var5 = Integer.parseInt(var3);
                  var2.append(getLine(var5));
               }
            }

            if(var1.length() > 0) {
               var2.append(var1);
            }

            field_501.addPhraseWithID(var0, var2.toString());
            return;
         }

         field_501.addPhraseWithID(var0, var1);
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   // $FF: renamed from: a (int) java.lang.String
   public static String getMessage(int var0) {
      return getMessage(var0, (String[])null);
   }

   // $FF: renamed from: a (int, java.lang.String[]) java.lang.String
   public static String getMessage(int var0, String[] var1) {
      return method_571(getLine(var0), var1);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String[]) java.lang.String
   public static String method_571(String var0, String[] var1) {
      try {
         if(var0.indexOf("<%") < 0) {
            return var0;
         } else {
            StringBuffer var2;
            for(var2 = new StringBuffer(); var0.indexOf("<%") >= 0; var0 = var0.substring(var0.indexOf("%>") + 2)) {
               var2.append(var0.substring(0, var0.indexOf("<%")));
               String var3;
               if((var3 = (var0 = var0.substring(var0.indexOf("<%") + 2)).substring(0, var0.indexOf("%>"))).equals("login")) {
                  var2.append(Hero.self.login);
               } else if(var3.equals("heroid")) {
                  var2.append(Hero.self.heroId);
               } else if(var3.equals("n")) {
                  var2.append("\n");
               } else {
                  int var5 = Integer.parseInt(var3);
                  var2.append(var1[var5]);
               }
            }

            if(var0.length() > 0) {
               var2.append(var0);
            }

            return var2.toString();
         }
      } catch (Exception var4) {
         return "cannot getMessage";
      }
   }

   // $FF: renamed from: a (java.lang.String) int
   private static int method_572(String var0) {
      byte var1 = 0;
      if(var0.startsWith("?")) {
         var1 = 1;
      }

      int var2 = var0.indexOf(" ");

      try {
         return Integer.parseInt(var0.substring(var1, var2));
      } catch (Exception var3) {
         return 0;
      }
   }

   // $FF: renamed from: b (int) java.lang.String
   public static final String getLine(int var0) {
      try {
         if(field_501 == null) {
            InputStream var1 = Main2.self.getClass().getResourceAsStream("/mobak/help/Language.txt");
            byte[] var2 = null;

            try {
               var2 = Main2.method_862(var1);
            } catch (Exception var7) {
               ;
            }

            var1.close();
            Vector var10 = new Vector();
            String var12 = new String(var2, "UTF-8");
            String var3 = "\r\n";
            boolean var4 = false;
            int var5 = 0;

            int var15;
            for(boolean var6 = true; var5 < var12.length(); var5 = var15 + var3.length()) {
               if((var15 = var12.indexOf(var3, var5)) == -1) {
                  var15 = var12.length();
               }

               String var16 = var12.substring(var5, var15);
               if(var6) {
                  var6 = false;
               } else {
                  var10.addElement(var16);
               }

               method_572(var16);
            }

            PhraseCollection var10000 = new PhraseCollection();
            field_501 = var10000;

            for(var5 = 0; var5 < var10.size(); ++var5) {
               var12 = (String)var10.elementAt(var5);
               int var13;
               field_501.addPhraseWithID(method_572(var12), (var13 = var12.indexOf(" ")) < 0?var12:var12.substring(var13 + 1));
            }

            for(var5 = 0; var5 < var10.size(); ++var5) {
               PhraseCollection var14 = field_501;
               int var17 = field_501.ids != null && var5 < var14.ids.length?var14.ids[var5]:-1;
               var14 = field_501;
               method_568(var17, field_501.phrases != null && var5 < var14.phrases.length?var14.phrases[var5]:null);
            }
         }

         String var9;
         String var11;
         return (var11 = field_501.getPhrase(var0)) == null?((var9 = Main2.self.getAppProperty("" + var0)) == null?"":var9):var11;
      } catch (IOException var8) {
         SocketListener.logMessage("load Language String: " + var8);
         return "line not found";
      }
   }

   // $FF: renamed from: a (byte) java.lang.String
   public static String method_574(byte var0) {
      boolean var1;
      switch(var0) {
      case 1:
         var1 = true;
         return getMessage(19, (String[])null);
      case 2:
         var1 = true;
         return getMessage(20, (String[])null);
      case 3:
         var1 = true;
         return getMessage(21, (String[])null);
      case 4:
         var1 = true;
         return getMessage(22, (String[])null);
      case 5:
         var1 = true;
         return getMessage(23, (String[])null);
      default:
         return "";
      }
   }

   // $FF: renamed from: c (int) java.lang.String
   public static String method_575(int var0) {
      boolean var1;
      switch(var0) {
      case 1:
         var1 = true;
         return getMessage(24, (String[])null);
      case 2:
         var1 = true;
         return getMessage(25, (String[])null);
      case 3:
         var1 = true;
         return getMessage(26, (String[])null);
      case 4:
         var1 = true;
         return getMessage(27, (String[])null);
      case 5:
         var1 = true;
         return getMessage(28, (String[])null);
      default:
         return "";
      }
   }

   // $FF: renamed from: <clinit> () void
   static{
      PhraseCollection var10000 = new PhraseCollection();
      characteristicsNames = var10000;
      var10000 = new PhraseCollection();
      field_503 = var10000;
   }
}
