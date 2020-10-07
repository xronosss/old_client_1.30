package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.Main2;
import mobak.a.SocketListener;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_55;
import mobak.b.b.a.a.class_0;
import mobak.b.b.a.a.class_59;
import mobak.text.class_62;

// $FF: renamed from: mobak.b.b.a.x
public final class class_36 extends MenuScreen {

   // $FF: renamed from: k short
   private short field_184;
   // $FF: renamed from: c byte
   private byte field_185;
   // $FF: renamed from: a java.lang.String[]
   private String[] field_186;
   // $FF: renamed from: a int[]
   private int[] field_187;
   // $FF: renamed from: j mobak.c.a
   private class_62 field_188;


   // $FF: renamed from: <init> (java.lang.String, java.lang.String, java.lang.String) void
   public class_36(String var1, String var2, String var3) {
      super();
      this.field_184 = 0;
      this.field_184 = -108;
      Screen.nameOfMap = var1;
      super.name = var2;
      class_55 var10001 = new class_55((short)10, (short)(this.method_136() + 8), (short)(ScreenDrawer.self.getWidth() - 20), (short)(ScreenDrawer.self.getHeight() - this.method_136() - 22 - PopupMenu.method_583()), false, false, true);
      super.field_53 = var10001;
      this.field_188 = Screen.field_26;
      super.field_53.method_490(var3, this.field_188, false, -1);

      for(int var4 = 0; var4 < super.field_53.method_509(); ++var4) {
         if(super.field_53.method_493(var4).method_471() > 0) {
            super.field_53.method_510(super.field_53.method_498(var4));
            break;
         }
      }

      PopupMenu var5 = new PopupMenu();
      super.popupMenu = var5;
   }

   // $FF: renamed from: <init> (java.lang.String, java.lang.String, java.lang.String[], int[]) void
   public class_36(String var1, String var2, String[] var3, int[] var4) {
      super();
      this.field_184 = 0;
      this.field_184 = -109;
      Screen.nameOfMap = var1;
      super.name = var2;
      boolean var5 = false;

      int var7;
      for(var7 = 0; var7 < var4.length; ++var7) {
         var5 = var5 || var4[var7] == 280 || var4[var7] == 286 || var4[var7] == 316 || var4[var7] == 310 || var4[var7] == 66666;
      }

      if(var5) {
         var7 = 0;

         int var6;
         for(var6 = 0; var6 < var4.length; ++var6) {
            if(method_197(var4[var6])) {
               ++var7;
            }
         }

         this.field_186 = new String[var7];
         this.field_187 = new int[var7];
         var7 = 0;

         for(var6 = 0; var6 < var4.length; ++var6) {
            if(method_197(var4[var6])) {
               this.field_186[var7] = var3[var6];
               this.field_187[var7] = var4[var6];
               ++var7;
            }
         }

         class_0[] var8;
         if((var8 = class_59.method_553()) != null && var8.length > 0) {
            var7 = 0;

            for(int var9 = 0; var9 < var8.length; ++var9) {
               if(method_197(var8[var9].method_0())) {
                  ++var7;
               }
            }

            class_0[] var10 = new class_0[var7];

            int var11;
            for(var11 = 0; var11 < var7; ++var11) {
               if(method_197(var8[var11].method_0())) {
                  var10[0] = var8[var11];
               }
            }

            var11 = this.field_186.length;
            this.field_186 = Main2.method_864(this.field_186, var11 + var10.length);
            this.field_187 = Main2.method_865(this.field_187, var11 + var10.length);

            for(var6 = 0; var6 < var10.length; ++var6) {
               class_0 var12 = var10[var6];
               this.field_186[var11 + var6] = var12.method_1();
               this.field_187[var11 + var6] = var12.method_0();
            }
         }
      } else {
         this.field_186 = var3;
         this.field_187 = var4;
      }

      this.field_185 = 0;
      PopupMenu var10001 = new PopupMenu();
      super.popupMenu = var10001;
      this.field_188 = Screen.field_30;
   }

   // $FF: renamed from: a (int) boolean
   private static boolean method_197(int var0) {
      return var0 != 310 && var0 != 66666;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      synchronized(this) {
         super.method_30(var1);
         switch(this.field_184) {
         case -109:
            this.method_139(var1, this.method_198(), this.field_186, this.field_185, this.field_188);
            break;
         case -108:
            super.field_53.method_484(var1, (byte)0);
         }

         super.popupMenu.method_604(var1);
      }
   }

   // $FF: renamed from: a () void
   public final void method_51() {
      if(this.field_184 == -109) {
         super.popupMenu.method_617(true, false);
         if(this.method_71() >= 0) {
            super.popupMenu.method_617(true, true);
         }
      }

   }

   // $FF: renamed from: b () short
   private short method_198() {
      return (short)(this.method_136() + 10);
   }

   // $FF: renamed from: a (int, int, int) boolean
   protected final boolean method_61(int var1, int var2, int var3) {
      if(System.currentTimeMillis() - super.field_85 > 200L && Screen.field_38 && !super.field_86) {
         super.field_86 = true;
         if(this.field_186 != null && this.field_186.length > 0) {
            class_62 var10001 = this.field_188;
            byte var4;
            if((var4 = this.method_140(this.field_186.length, this.method_198(), var2)) >= 0 && var4 < this.field_186.length) {
               this.field_185 = (byte)var4;
            }
         }
      }

      return false;
   }

   // $FF: renamed from: b (int, int) boolean
   protected final boolean method_62(int var1, int var2) {
      if(Math.abs(Screen.field_36 - Screen.field_34) > 20 || Math.abs(Screen.field_37 - Screen.field_35) > 20) {
         Screen.field_38 = false;
      }

      int var6;
      if(this.field_184 == -109) {
         if(super.field_86) {
            class_62 var10001 = this.field_188;
            byte var3;
            if((var3 = this.method_140(this.field_186.length, this.method_198(), var2)) >= 0 && var3 < this.field_186.length) {
               this.field_185 = (byte)var3;
            }
         } else {
            if((var6 = this.field_186.length) > 0) {
               int var10000 = Screen.field_37 - var2;
               class_62 var4 = this.field_188;
               int var7 = var10000 / (this.field_188.field_500 + 5);
               if(ScreenDrawer.self.method_380()) {
                  var7 = (Screen.field_37 - var2) / ScreenDrawer.method_378(MenuScreen.field_101);
               }

               if(var7 != 0) {
                  int var5;
                  if((var5 = (ScreenDrawer.self.getHeight() - this.method_198() - PopupMenu.method_583()) / ScreenDrawer.method_378(MenuScreen.field_101)) < var6) {
                     super.field_118 += var7;
                  }

                  if(super.field_118 < 0) {
                     super.field_118 = 0;
                  }

                  if(var5 < var6 && super.field_118 + var5 > var6) {
                     super.field_118 = var6 - var5;
                  }

                  Screen.field_37 = var2;
               }
            }

            Screen.field_36 = var1;
         }
      } else if(this.field_184 == -108) {
         var6 = var2 - Screen.field_37;
         if(super.field_53.method_507()) {
            super.field_53.method_503(super.field_53.method_502() - var6);
            Screen.field_37 = var2;
         }
      }

      return true;
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      Screen.field_38 = true;
      Screen.field_34 = var1;
      Screen.field_35 = var2;
      Screen.field_36 = var1;
      Screen.field_37 = var2;
      super.field_85 = System.currentTimeMillis();
      super.field_86 = false;
      if(this.field_184 != -109 && this.field_184 == -108) {
         if(super.field_53.method_493(super.field_53.method_501(var2)) != null && super.field_53.method_493(super.field_53.method_501(var2)).method_471() > 0) {
            this.field_185 = (byte)super.field_53.method_501(var2);
         }

         super.field_53.method_506(var1, var2);
         Screen.field_37 = var2;
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      if(Screen.field_38 && this.field_184 == -109) {
         class_62 var10001 = this.field_188;
         byte var5;
         if((var5 = this.method_140(this.field_186.length, this.method_198(), var2)) >= 0 && var5 < this.field_186.length) {
            this.field_185 = (byte)var5;
         }

         if(super.popupMenu != null) {
            this.method_51();
            Button var6 = super.popupMenu.method_610(false, false, true);

            try {
               this.method_37(var6);
            } catch (Exception var4) {
               SocketListener.logMessage("TextMenuScreen.pointReleased: " + var4.toString());
            }
         }

         return true;
      } else {
         if(this.field_184 == -108) {
            super.field_53.method_508();
         }

         return false;
      }
   }

   // $FF: renamed from: a () int
   public final int method_71() {
      switch(this.field_184) {
      case -109:
         if(this.field_187 != null && this.field_185 >= 0 && this.field_185 < this.field_187.length) {
            return this.field_187[this.field_185];
         }

         return super.method_71();
      case -108:
         return super.field_53.method_492();
      default:
         return 0;
      }
   }

   // $FF: renamed from: a () java.lang.String
   public final String method_58() {
      return Screen.nameOfMap;
   }

   // $FF: renamed from: c (int) void
   protected final void method_39(int var1) {
      switch(this.field_184) {
      case -109:
         if(var1 != 6 && 6 != ScreenDrawer.self.getGameAction(var1)) {
            if(var1 == 1 || 1 == ScreenDrawer.self.getGameAction(var1)) {
               if(this.field_185 > 0) {
                  var1 = this.field_185 - 1;
                  this.field_185 = (byte)var1;
               } else {
                  var1 = this.field_186.length - 1;
                  this.field_185 = (byte)var1;
               }
            }
         } else if(this.field_185 < this.field_186.length - 1) {
            var1 = this.field_185 + 1;
            this.field_185 = (byte)var1;
         } else {
            this.field_185 = 0;
         }

         var1 = this.field_186.length;
         class_62 var2 = this.field_188;
         int var3 = this.field_188.field_500 + 5;
         if(ScreenDrawer.self.method_380()) {
            var3 = ScreenDrawer.method_378(MenuScreen.field_101);
         }

         var3 = (ScreenDrawer.self.getHeight() - this.method_198() - PopupMenu.method_583() - var3) / var3;
         if(this.field_185 < super.field_118) {
            super.field_118 = this.field_185;
         }

         if(this.field_185 > super.field_118 + var3) {
            super.field_118 = this.field_185 - var3;
         }

         if(super.field_118 < 0) {
            super.field_118 = 0;
         }

         if(var3 < var1 && super.field_118 + var3 > var1) {
            super.field_118 = var1 - var3;
         }
         break;
      case -108:
         if(var1 == 6 || 6 == ScreenDrawer.self.getGameAction(var1)) {
            super.field_53.method_486();
            return;
         }

         if(var1 == 1 || 1 == ScreenDrawer.self.getGameAction(var1)) {
            super.field_53.method_485();
            return;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String) void
   public final void method_129(String var1) {
      synchronized(this) {
         super.field_53.method_495();
         super.field_53.method_490(var1, Screen.field_26, false, -1);
      }
   }

   // $FF: renamed from: b (mobak.b.b.a.v) boolean
   public final boolean method_37(Button var1) {
      if(this.field_187 != null && this.field_185 >= 0 && this.field_185 < this.field_187.length) {
         if(class_59.method_552(this.field_187[this.field_185]) == null) {
            return super.method_37(var1);
         }

         if(var1.method_652() != 55) {
            return true;
         }
      }

      return super.method_37(var1);
   }
}
