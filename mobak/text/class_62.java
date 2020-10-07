package mobak.text;

import java.io.InputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.b.b.ScreenDrawer;

// $FF: renamed from: mobak.c.a
public final class class_62 {

   // $FF: renamed from: a java.lang.String[]
   private static final String[] field_496;
   // $FF: renamed from: a int[][]
   private static final int[][] field_497;
   // $FF: renamed from: a javax.microedition.lcdui.Image[]
   private Image[] field_498;
   // $FF: renamed from: a short[]
   private short[] field_499;
   // $FF: renamed from: a int
   public int field_500;


   // $FF: renamed from: <init> (byte, int) void
   public class_62(byte var1, int var2) {
      this(var1, var2, false);
   }

   // $FF: renamed from: <init> (byte, int, boolean) void
   public class_62(byte var1, int var2, boolean var3) {
      super();

      try {
         this.field_498 = new Image[field_497.length];
         int var4 = 0;

         int var5;
         for(var5 = 0; var5 < field_497.length; ++var5) {
            var4 += field_497[var5][1] - field_497[var5][0] + 1 << 1;
         }

         this.field_499 = new short[var4];
         var5 = 0;

         for(int var6 = 0; var6 < field_497.length; ++var6) {
            StringBuffer var7;
            (var7 = new StringBuffer()).append(var2);
            if(var3) {
               var7.append("bold");
            } else {
               var7.append("regular");
            }

            var7.append('_');
            var7.append(field_497[var6][0]);
            var7.append('-');
            var7.append(field_497[var6][1]);
            String var8 = var7.toString() + ".pngs";
            InputStream var12;
            byte[] var9 = Main2.method_862(var12 = Main2.self.getClass().getResourceAsStream("/mobak/res/" + var8));
            var12.close();
            byte[] var13 = var9;
            int var14 = var9.length / 3;

            for(int var10 = 0; var10 < var14 && var10 < var4 / 2; ++var10) {
               this.field_499[var5] = (short)(256 * (short)(var13[var10 * 3] & 255) + (short)(var13[var10 * 3 + 1] & 255));
               ++var5;
               this.field_499[var5] = (short)(var13[var10 * 3 + 2] & 255);
               ++var5;
            }

            var7.append('_');
            var7.append(field_496[var1]);
            this.field_498[var6] = GlobalStorage.method_712("/mobak/res/" + var7.toString() + ".png");
         }

         this.field_500 = ScreenDrawer.method_383(this.field_498[0]) - 1;
      } catch (Exception var11) {
         SocketListener.logMessage("Font loading error: " + var11.toString());
      }
   }

   // $FF: renamed from: a (java.lang.String) int
   public final int method_563(String var1) {
      if(var1 == null) {
         return 0;
      } else {
         int var2 = 0;

         for(int var3 = 0; var3 < var1.length(); ++var3) {
            var2 += this.method_565(var1.charAt(var3)) + 1;
         }

         return var2 - 1;
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, java.lang.String, int, int, int) void
   public final void method_564(Graphics var1, String var2, int var3, int var4, int var5) {
      if(var1 != null && var2 != null) {
         int var6 = ScreenDrawer.method_386(var1);
         int var7 = ScreenDrawer.method_387(var1);
         int var8 = ScreenDrawer.method_388(var1);
         int var9 = ScreenDrawer.method_389(var1);
         if((var5 & 1) == 1) {
            var3 -= this.method_563(var2) / 2;
         } else if((var5 & 8) == 8) {
            var3 -= this.method_563(var2);
         }

         if((var5 & 2) == 2) {
            var4 -= this.field_500 / 2;
         } else if((var5 & 32) == 32) {
            var4 -= this.field_500;
         }

         for(var5 = 0; var5 < var2.length(); ++var5) {
            var3 += this.method_566(var1, var2.charAt(var5), var3, var4) + 1;
         }

         ScreenDrawer.method_369(var1, var6, var7, var8, var9);
      }
   }

   // $FF: renamed from: a (char) int
   private int method_565(char var1) {
      while(true) {
         int var2 = 0;

         for(int var3 = 0; var3 < field_497.length; ++var3) {
            if(field_497[var3][0] <= var1 && field_497[var3][1] >= var1) {
               return this.field_499[(var2 + var1 - field_497[var3][0] << 1) + 1];
            }

            var2 += field_497[var3][1] - field_497[var3][0] + 1;
         }

         if(var1 == 63) {
            return 0;
         }

         var1 = 63;
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, char, int, int) int
   private final int method_566(Graphics var1, char var2, int var3, int var4) {
      while(true) {
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < field_497.length && (field_497[var6][0] > var2 || field_497[var6][1] < var2); ++var6) {
            var5 += field_497[var6][1] - field_497[var6][0] + 1;
         }

         if(var6 >= field_497.length) {
            if(var2 != 63) {
               var2 = 63;
               continue;
            }

            return 0;
         }

         int var7 = var5 + var2 - field_497[var6][0] << 1;
         short var8 = this.field_499[var7 + 1];
         ScreenDrawer.method_369(var1, var3, var4, var8 + 1, this.field_500);
         ScreenDrawer.method_370(var1, this.field_498[var6], var3 - this.field_499[var7], var4 - 1, 20);
         return var8;
      }
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_496 = new String[]{"FFFFFF", "999999", "FFCC00", "00FF00", "000000"};
      field_497 = new int[][]{{32, 64}, {65, 96}, {97, 127}, {160, 191}, {1040, 1070}, {1071, 1105}};
   }
}
