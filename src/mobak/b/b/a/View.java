package mobak.b.b.a;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.b.a.Thing;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.StrategicScreen;
import mobak.b.b.ScreenDrawer;

// $FF: renamed from: mobak.b.b.a.j
public abstract class View extends MenuScreen {

   // $FF: renamed from: a boolean
   public static boolean field_224;
   // $FF: renamed from: c byte
   protected byte field_225;
   // $FF: renamed from: a byte[]
   byte[] field_226;
   // $FF: renamed from: a short[]
   protected short[] field_227;
   // $FF: renamed from: d byte
   protected byte field_228;
   // $FF: renamed from: e byte
   protected byte field_229;
   // $FF: renamed from: d boolean
   protected boolean field_230;
   // $FF: renamed from: k short
   private short field_231;
   // $FF: renamed from: l short
   private short field_232;
   // $FF: renamed from: g boolean
   private boolean field_233;
   // $FF: renamed from: a java.util.Vector
   private Vector field_234;
   // $FF: renamed from: e int
   protected int field_235;
   // $FF: renamed from: h boolean
   private boolean field_236;


   // $FF: renamed from: <init> (short) void
   View(short var1) {
      super();
      this.field_226 = new byte[]{(byte)0, (byte)0};
      this.field_227 = new short[]{(short)0, (short)0};
      this.field_228 = -1;
      this.field_229 = -1;
      this.field_230 = false;
      this.field_231 = 0;
      this.field_232 = 0;
      this.field_233 = false;
      this.field_234 = new Vector();
      super.field_52 = var1;
      if(var1 != -7 && var1 != -11) {
         ScreenDrawer.field_293 = null;
      }

   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, mobak.b.a.a[], short, byte, short, short, short) void
   private void method_246(Graphics var1, Thing[] var2, short var3, byte var4, short var5, short var6, short var7) {
      if(var1 != null) {
         this.field_234.removeAllElements();
         short var8 = (short)(var6 - var4 * 55);
         this.field_231 = var5;
         this.field_232 = var6;
         byte var9 = 0;
         int var13;
         if(var2 == null) {
            for(var13 = 0; var13 < this.method_144(true); ++var13) {
               MenuScreen.method_131(var1, var5, var8 + this.field_235, 0);
               var8 = (short)(var8 + 55);
            }

            super.field_53.method_495();
         } else {
            ScreenDrawer.method_368(var1, var5, var6, 62, this.method_144(true) * 55);
            Vector var10000;
            class_84 var10001;
            if(var2 != null && var2.length != 0) {
               for(byte var10 = 0; var10 < var2.length; ++var10) {
                  if(super.field_52 != -5) {
                     if(var2 != null && var2.length > var4 && var9 < var2.length) {
                        if(var2[var9] != null) {
                           short var11 = var3;
                           if(var7 == var9) {
                              var11 = (short)(var3 | (this.field_230?1024:1));
                           }

                           var2[var9].method_758(var1, var5, (short)(var8 + this.field_235), var11);
                           var10000 = this.field_234;
                           var10001 = new class_84(var5, var8 + this.field_235, 61, 53, (byte)0, (short)var9);
                           var10000.addElement(var10001);
                        }
                     } else {
                        MenuScreen.method_131(var1, var5, var8 + this.field_235, 0);
                     }
                  } else {
                     byte var18;
                     switch(var9) {
                     case 0:
                        var18 = 5;
                        break;
                     case 1:
                     case 2:
                     case 3:
                     case 4:
                        var18 = 4;
                        break;
                     case 5:
                        var18 = 2;
                        break;
                     case 6:
                        var18 = 3;
                        break;
                     case 7:
                        var18 = 1;
                        break;
                     case 8:
                        var18 = 0;
                        break;
                     case 9:
                        var18 = 6;
                        break;
                     default:
                        var18 = -1;
                     }

                     byte var15 = var18;
                     short var12;
                     if(var18 >= 0 && var15 <= 6 && (var2 == null || var2.length <= var9 || var2[var9] == null)) {
                        var12 = var7 == var9? MenuScreen.field_103: MenuScreen.field_98;
                        ScreenDrawer.method_373(var1, var12, 9, 1, var15, 0, var5, var8 + this.field_235);
                     }

                     if(var2 != null && var2.length > var4 && var9 < var2.length && var2[var9] != null) {
                        var12 = var3;
                        if(var7 == var9) {
                           var12 = (short)(var3 | (this.field_230?1024:1));
                        }

                        var2[var9].method_758(var1, var5, (short)(var8 + this.field_235), var12);
                     }

                     var10000 = this.field_234;
                     var10001 = new class_84(var5, var8 + this.field_235, 61, 53, (byte)0, (short)var9);
                     var10000.addElement(var10001);
                  }

                  ++var9;
                  var8 = (short)(var8 + 55);
               }
            }

            if(var2.length < this.method_144(true)) {
               for(var13 = var9; var13 < this.method_144(true); ++var13) {
                  MenuScreen.method_131(var1, var5, var8 + this.field_235, 0);
                  var8 = (short)(var8 + 55);
               }
            }

            ScreenDrawer.method_368(var1, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
            if(var2 != null) {
               Image var14;
               int var16;
               int var17;
               if(var4 > 0) {
                  var16 = ScreenDrawer.method_382(var14 = GlobalStorage.getImage(MenuScreen.field_92));
                  var17 = ScreenDrawer.method_383(var14);
                  ScreenDrawer.method_372(var1, var14, 0, 0, var16, var17, 0, var5 + 30, var6 - var17, 33);
               }

               if(var4 + this.field_225 < var2.length && super.field_52 != -5) {
                  var16 = ScreenDrawer.method_382(var14 = GlobalStorage.getImage(MenuScreen.field_93));
                  var17 = ScreenDrawer.method_383(var14);
                  ScreenDrawer.method_372(var1, var14, 0, 0, var16, var17, 0, var5 + 30, var6 + 55 * this.field_225 + var17, 17);
               }

               if(super.field_52 == -5 && var4 + this.field_225 < 10) {
                  var16 = ScreenDrawer.method_382(var14 = GlobalStorage.getImage(MenuScreen.field_93));
                  var17 = ScreenDrawer.method_383(var14);
                  ScreenDrawer.method_372(var1, var14, 0, 0, var16, var17, 0, var5 + 30, var6 + 55 * this.field_225 + var17, 17);
               }

               if(super.field_52 != -5) {
                  var10000 = this.field_234;
                  var10001 = new class_84(var5, var6, 61, 53, (byte)0, (short)0);
                  var10000.addElement(var10001);
               }
            }

         }
      }
   }

   // $FF: renamed from: c (int) void
   protected void method_39(int var1) {
      Thing var2 = this.method_256();
      var1 = ScreenDrawer.self.getGameAction(var1);
      if(this.field_230) {
         switch(var1) {
         case 1:
            this.method_258((short)1);
            break;
         case 2:
            this.method_258((short)-10);
         case 3:
         case 4:
         default:
            break;
         case 5:
            this.method_258((short)10);
            break;
         case 6:
            this.method_258((short)-1);
         }
      } else if(super.field_52 > 0) {
         switch(var1) {
         case 1:
            this.method_248(true);
            break;
         case 2:
            this.method_249(false);
         case 3:
         case 4:
         default:
            break;
         case 5:
            this.method_249(true);
            break;
         case 6:
            this.method_248(false);
         }
      } else {
         switch(var1) {
         case 1:
            this.method_249(false);
            break;
         case 6:
            this.method_249(true);
         }
      }

      Thing var3 = this.method_256();
      if(super.field_52 != -5) {
         if(var2 != var3) {
            this.method_56();
         }

         if((var2 != var3 || super.field_53.method_496()) && var3 != null) {
            this.method_247(var3, this.field_227[this.field_229]);
         }
      }

      this.method_51();
   }

   // $FF: renamed from: a (mobak.b.a.a, short) void
   protected void method_247(Thing var1, short var2) {
      var1.getDescription(super.field_53, (String)null, var2);
   }

   // $FF: renamed from: d (boolean) void
   private void method_248(boolean var1) {
      short var2 = (short)this.field_226[this.field_229];
      byte var3 = this.field_229;
      if(var1) {
         --var3;
      } else {
         ++var3;
      }

      Thing[] var4;
      if((var4 = this.method_250(var3)) != null && var4.length != 0) {
         this.field_229 = var3;
         this.field_228 = (byte)(this.field_226[this.field_229] + (this.field_228 - var2));
         if(var4 != null && var4.length <= this.field_228) {
            this.field_228 = (byte)(var4.length - 1);
         }

      }
   }

   // $FF: renamed from: b (boolean) void
   protected void method_249(boolean var1) {
      Thing[] var2;
      if((var2 = this.method_250(this.field_229)) != null || super.field_52 == -5) {
         byte var3;
         if((var3 = var1?(byte)(this.field_228 + 1):(byte)(this.field_228 - 1)) >= 0 && var3 < var2.length) {
            this.field_228 = var3;
            if(this.field_226[this.field_229] > this.field_228) {
               this.method_260(this.field_229, this.field_228);
            }

            if(this.field_228 - this.field_226[this.field_229] >= this.field_225) {
               this.method_260(this.field_229, (byte)(this.field_228 - this.field_225 + 1));
            }

         }
      }
   }

   // $FF: renamed from: a (byte) mobak.b.a.a[]
   protected Thing[] method_250(byte var1) {
      return var1 < 0?null:(var1 == 1? ScreenDrawer.field_293:null);
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public boolean method_38(Button button) {
      int var2 = button.field_543;
      switch((byte) button.field_543) {
      case 55:
         return this.method_254();
      case 78:
         Thing[] var3;
         if((var3 = this.method_250((byte)0)) != null && var3.length != 0) {
            for(byte var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var3[var4].method_740(var3[var4].getQuantity());
               }
            }

            return true;
         }

         return false;
      case 81:
         return this.method_257();
      case 84:
         return this.method_252();
      case 95:
         this.method_54();
         return true;
      default:
         return super.method_38(button);
      }
   }

   // $FF: renamed from: a (mobak.a.a.l, mobak.b.a.a[]) boolean
   protected static boolean method_251(OutputGameMessage var0, Thing[] var1) {
      if(var0 == null) {
         return false;
      } else if(var1 != null && var1.length != 0) {
         boolean var2 = false;

         for(short var3 = 0; var3 < var1.length; ++var3) {
            if(var1[var3] != null && var1[var3].method_739() > 0) {
               try {
                  var0.addToBody(var1[var3].getId());
                  var0.addToBody(var1[var3].method_739());
                  var2 = true;
               } catch (Exception var5) {
                  SocketListener.logMessage("addToOrderRequest" + var5.toString());
               }
            }
         }

         return var2;
      } else {
         return false;
      }
   }

   // $FF: renamed from: g () boolean
   private boolean method_252() {
      try {
         method_253(this.method_250((byte)0));
         method_253(this.method_250((byte)1));
         super.popupMenu.method_615((byte)84);
         if(this.field_230) {
            this.method_257();
         }

         if(super.field_52 != 16384) {
            this.method_254();
         }

         return true;
      } catch (Exception var2) {
         SocketListener.logMessage("sendSaveRequest " + var2.toString());
         return false;
      }
   }

   // $FF: renamed from: a (mobak.b.a.a[]) void
   private static void method_253(Thing[] var0) {
      if(var0 != null && var0.length != 0) {
         for(int var1 = 0; var1 < var0.length; ++var1) {
            if(var0[var1] != null && var0[var1].method_739() > 0) {
               var0[var1].method_740(0);
            }
         }

      }
   }

   // $FF: renamed from: a () void
   public void method_51() {
      super.popupMenu.method_617(true, false);
      if(this.field_228 >= 0 && this.field_229 >= 0) {
         if(this.method_256() != null) {
            super.popupMenu.method_600((byte)81, false);
         }
      }
   }

   // $FF: renamed from: e () boolean
   protected abstract boolean method_254();

   // $FF: renamed from: a (short) boolean
   protected final boolean method_255(short var1) {
      if(this.field_230 && super.field_52 != -1) {
         this.method_257();
      }

      System.gc();
      if(ScreenDrawer.self.method_351() && !SocketListener.self.method_533()) {
         ScreenDrawer.self.method_352(false);
      }

      method_253(Hero.self.method_880());
      StrategicScreen var10000 = ScreenDrawer.self.strategicScreen;
      StrategicScreen.method_122();
      method_253(Hero.self.method_882((byte)-1));
      ScreenDrawer.self.method_346();
      ScreenDrawer.self.getScreen().helpViewInit();
      return true;
   }

   // $FF: renamed from: a () mobak.b.a.a
   protected Thing method_256() {
      Thing[] var1;
      return this.field_229 < 0?null:((var1 = this.method_250(this.field_229)) != null && var1.length != 0?(var1.length <= this.field_228?null:var1[this.field_228]):null);
   }

   // $FF: renamed from: f () boolean
   protected boolean method_257() {
      if(this.field_230) {
         super.popupMenu.method_597((short)7, (byte)81);
      } else {
         super.popupMenu.method_597((short)106, (byte)81);
      }

      this.field_230 = !this.field_230;
      return true;
   }

   // $FF: renamed from: b (short) boolean
   private boolean method_258(short var1) {
      Thing var2;
      if(this.field_230 && (var2 = this.method_256()) != null) {
         if(super.field_52 != 1 && (super.field_52 != 4 || this.field_229 != 1)) {
            var2.method_744(var1);
         } else {
            var2.method_745(var1, false, true);
         }

         super.popupMenu.method_616((byte)84);
         return true;
      } else {
         return false;
      }
   }

   public String toString() {
      StringBuffer var1;
      (var1 = new StringBuffer()).append("screen type[").append(super.field_52).append("]\n");
      return var1.toString();
   }

   // $FF: renamed from: c (javax.microedition.lcdui.Graphics) void
   protected final void method_259(Graphics var1) {
      if(var1 != null) {
         super.drawScreen(var1);
         Thing[] var3;
         if(this.field_228 < 0) {
            boolean var2 = false;
            if((var3 = this.method_250((byte)0)) != null && var3.length > 0) {
               this.field_229 = 0;
               this.field_228 = 0;
               var2 = true;
            }

            if(var2) {
               this.method_51();
            }
         }

         var3 = this.method_250((byte)0);
         short var4 = (short)(this.method_136() + 10);
         this.method_246(var1, var3, this.field_227[0], this.field_226[0], (short)16, var4, (short)this.field_228);
         Thing var5;
         if(super.field_53.method_496() && (var5 = this.method_256()) != null) {
            this.method_247(var5, this.field_227[this.field_229]);
         }

         if(super.field_53 != null) {
            super.field_53.method_484(var1, (byte)0);
         }

         super.popupMenu.method_604(var1);
      }
   }

   // $FF: renamed from: b (int, int) void
   public final void method_260(int var1, int var2) {
      this.field_226[var1] = (byte)var2;
   }

   // $FF: renamed from: d (javax.microedition.lcdui.Graphics) void
   protected final void method_261(Graphics var1) {
      if(var1 != null) {
         super.drawScreen(var1);
         if(this.field_228 < 0) {
            boolean var2 = false;
            Thing[] var3;
            if((var3 = this.method_250((byte)0)) != null && var3.length > 0) {
               this.field_229 = 0;
               this.field_228 = 0;
               var2 = true;
            }

            if(var2) {
               this.method_51();
            }
         }

         Thing[] var4 = this.method_250((byte)0);
         short var6 = (short)(ScreenDrawer.self.getWidth() - 16 - 61);
         short var5 = (short)(this.method_136() + 10);
         this.method_246(var1, var4, this.field_227[0], this.field_226[0], var6, var5, (short)this.field_228);
         if(super.field_53 != null) {
            super.field_53.method_484(var1, (byte)0);
         }

         super.popupMenu.method_604(var1);
      }
   }

   // $FF: renamed from: a (int, int) boolean
   protected boolean method_59(int var1, int var2) {
      super.field_53.method_506(var1, var2);
      Screen.field_34 = var1;
      Screen.field_35 = var2;
      Screen.field_36 = var1;
      Screen.field_37 = var2;
      Screen.field_38 = true;
      if(var1 >= this.field_231 && var1 <= this.field_231 + 61 && var2 >= this.field_232 && var2 <= this.field_232 + this.method_144(true) * 55) {
         this.field_236 = true;
      } else {
         this.field_236 = false;
      }

      this.field_233 = false;
      return false;
   }

   // $FF: renamed from: b (int, int) boolean
   protected boolean method_62(int var1, int var2) {
      var1 = var2 - Screen.field_37;
      if(super.field_53.method_507()) {
         super.field_53.method_503(super.field_53.method_502() - var1);
         Screen.field_37 = var2;
      }

      if(Math.abs(Screen.field_36 - Screen.field_34) > 20 || Math.abs(Screen.field_37 - Screen.field_35) > 20) {
         Screen.field_38 = false;
      }

      if(this.field_236) {
         this.field_235 += var1;
      }

      Screen.field_37 = var2;
      return false;
   }

   // $FF: renamed from: a (int, int, int) boolean
   protected final boolean method_61(int var1, int var2, int var3) {
      if(!Screen.field_38) {
         return false;
      } else {
         class_84 var4 = null;

         for(int var5 = 0; var5 < this.field_234.size() && var4 == null; ++var5) {
            class_84 var6;
            if((var6 = (class_84)this.field_234.elementAt(var5)).method_946(var1, var2)) {
               var4 = var6;
            }
         }

         if(this.field_230) {
            byte var7;
            if((var7 = this.method_146(var1, var2)) == 1) {
               if(var3 <= 300) {
                  if(!this.field_233) {
                     this.method_258((short)1);
                  }
               } else {
                  this.method_258((byte) MenuScreen.method_128(var3, 300));
               }

               this.field_233 = true;
            } else if(var7 == 2) {
               if(var3 <= 300) {
                  if(!this.field_233) {
                     this.method_258((short)-1);
                  }
               } else {
                  this.method_258((byte)(-1 * MenuScreen.method_128(var3, 300)));
               }

               this.field_233 = true;
            }

            return true;
         } else {
            return var4 == null?false:false;
         }
      }
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected boolean method_60(int var1, int var2, int var3) {
      super.field_53.method_508();
      if(this.field_235 > 0) {
         this.field_235 += 30;
      } else {
         this.field_235 -= 30;
      }

      this.field_226[0] = (byte)(this.field_226[0] - this.field_235 / 61);
      if(this.field_226[0] < 0) {
         this.field_226[0] = 0;
      }

      byte var4 = this.method_144(true);
      Thing[] var5 = this.method_250((byte)0);
      int var6 = 0;
      if(var5 != null) {
         var6 = var5.length;
      }

      if(this.field_226[0] + var4 > var6) {
         this.field_226[0] = (byte)(var6 - var4);
      }

      if(var4 >= var6 || var6 == 0) {
         this.field_226[0] = 0;
      }

      this.field_235 = 0;
      if(Screen.field_38 && this.field_234 != null && this.field_234.size() != 0) {
         class_84 var8 = null;

         for(int var9 = 0; var9 < this.field_234.size() && var8 == null; ++var9) {
            class_84 var10;
            if((var10 = (class_84)this.field_234.elementAt(var9)).method_946(var1, var2)) {
               var8 = var10;
            }
         }

         if(var8 == null) {
            if(!this.field_230) {
               return false;
            }

            byte var12;
            if((var12 = this.method_146(var1, var2)) == 1) {
               if(!this.field_233 || var3 >= 300) {
                  this.method_258((short)1);
               }
            } else if(var12 == 2 && (!this.field_233 || var3 >= 300)) {
               this.method_258((short)-1);
            }

            return true;
         }

         if(this.field_229 != var8.field_725 || this.field_228 != var8.field_726) {
            Thing var11 = this.method_256();
            this.field_228 = (byte)var8.field_726;
            Thing var7 = this.method_256();
            if(super.field_52 != -5) {
               if(var7 != null && var11 != var7) {
                  this.method_56();
               }

               if(var7 != null && (var11 != var7 || super.field_53.method_496())) {
                  this.method_247(var7, this.field_227[this.field_229]);
               }
            }

            this.method_51();
            return true;
         }

         if(!this.field_230) {
            this.method_36();
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: <clinit> () void
   static {
      field_224 = false;
   }
}
