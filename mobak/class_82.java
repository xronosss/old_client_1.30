package mobak;

import java.util.Vector;
import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;
import mobak.b.b.ScreenDrawer;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.j
public final class class_82 implements Runnable {

   // $FF: renamed from: a java.lang.Thread
   private Thread field_711;
   // $FF: renamed from: a boolean
   private static boolean field_712;
   // $FF: renamed from: a java.lang.String
   private String field_713;
   // $FF: renamed from: b java.lang.String
   private String field_714;
   // $FF: renamed from: c java.lang.String
   private String field_715;


   // $FF: renamed from: <init> (java.lang.String, java.lang.String, java.lang.String) void
   private class_82(String var1, String var2, String var3) {
      super();
      this.field_711 = new Thread(this);
      this.field_713 = var1;
      this.field_715 = var2;
      this.field_714 = var3;
      this.field_711.start();
   }

   public final void run() {
      MessageConnection var1 = null;

      try {
         TextMessage var2;
         (var2 = (TextMessage)(var1 = (MessageConnection)Connector.open("sms://" + this.field_713, 2)).newMessage("text")).setPayloadText(this.field_715);
         var1.send(var2);
         if(!field_712) {
            ScreenDrawer.method_330("", MessagesContainer.getMessage(188));
         }

         field_712 = true;
         return;
      } catch (Exception var9) {
         if(!field_712) {
            ScreenDrawer.method_330("", MessagesContainer.getMessage(189, new String[]{String.valueOf(this.field_713), this.field_714}));
         }

         field_712 = true;
      } finally {
         if(var1 != null) {
            try {
               var1.close();
            } catch (Exception var8) {
               ;
            }
         }

      }

   }

   // $FF: renamed from: a () int
   private static int method_939() {
      try {
         Class.forName("javax.wireless.messaging.Message");
         return 1;
      } catch (Exception var0) {
         return 0;
      }
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String) void
   public static final void method_940(String var0, String var1, String var2) {
      if(method_939() != 0) {
         new class_82(var1, var0, var2);
      }
   }

   // $FF: renamed from: a () void
   public static final void method_941() {
      field_712 = false;
   }

   // $FF: renamed from: a (java.lang.String, char) java.lang.String[]
   public static final String[] method_942(String var0, char var1) {
      Vector var5 = new Vector();
      int var2 = -1;

      while(var2 < var0.length() - 1) {
         int var3 = var2;
         if((var2 = var0.indexOf(32, var2 + 1)) == -1) {
            var2 = var0.length();
         }

         if(var2 - var3 - 1 > 0) {
            var5.addElement(var0.substring(var3 + 1, var2));
         }
      }

      if(var5.size() <= 0) {
         return new String[0];
      } else {
         String[] var6 = new String[var5.size()];

         for(int var4 = 0; var4 < var5.size(); ++var4) {
            var6[var4] = (String)var5.elementAt(var4);
         }

         return var6;
      }
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_712 = false;
   }
}
