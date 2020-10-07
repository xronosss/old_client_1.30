package mobak.b.b.a;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Thing;
import mobak.b.a.Item;
import mobak.b.a.Unit;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_55;
import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.y
public final class class_37 extends MenuScreen {

   // $FF: renamed from: e int
   private int field_189;
   // $FF: renamed from: a java.lang.String[][]
   private String[][] field_190;
   // $FF: renamed from: a byte[][]
   private byte[][] field_191;
   // $FF: renamed from: a short[]
   private short[] field_192;
   // $FF: renamed from: a byte[]
   private byte[] field_193;
   // $FF: renamed from: b short[]
   private short[] field_194;
   // $FF: renamed from: c byte
   private byte field_195;
   // $FF: renamed from: k short
   private short field_196;
   // $FF: renamed from: a boolean[][]
   private boolean[][] field_197;
   // $FF: renamed from: a mobak.b.a.a[][]
   private Thing[][] field_198;
   // $FF: renamed from: a java.util.Vector
   private Vector field_199;
   // $FF: renamed from: d byte
   private byte field_200;
   // $FF: renamed from: c short[]
   private short[] field_201;
   // $FF: renamed from: e byte
   private byte field_202;
   // $FF: renamed from: l short
   private short field_203;
   // $FF: renamed from: f byte
   private byte field_204;
   // $FF: renamed from: a boolean
   private boolean field_205;
   // $FF: renamed from: d boolean
   private boolean field_206;
   // $FF: renamed from: g boolean
   private boolean field_207;
   // $FF: renamed from: b java.util.Vector
   private Vector field_208;
   // $FF: renamed from: h boolean
   private boolean field_209;
   // $FF: renamed from: a mobak.b.b.a.v
   private Button field_210;
   // $FF: renamed from: b mobak.b.b.a.v
   private Button field_211;
   // $FF: renamed from: c mobak.b.b.a.v
   private Button field_212;
   // $FF: renamed from: d mobak.b.b.a.v
   private Button field_213;
   // $FF: renamed from: e mobak.b.b.a.v
   private Button field_214;
   // $FF: renamed from: f mobak.b.b.a.v
   private Button field_215;
   // $FF: renamed from: g mobak.b.b.a.v
   private Button field_216;
   // $FF: renamed from: h mobak.b.b.a.v
   private Button field_217;
   // $FF: renamed from: i mobak.b.b.a.v
   private Button field_218;
   // $FF: renamed from: j mobak.b.b.a.v
   private Button field_219;
   // $FF: renamed from: k mobak.b.b.a.v
   private Button field_220;
   // $FF: renamed from: l mobak.b.b.a.v
   private Button field_221;
   // $FF: renamed from: m mobak.b.b.a.v
   private Button field_222;
   // $FF: renamed from: n mobak.b.b.a.v
   private Button field_223;


   // $FF: renamed from: <init> (int, short) void
   public class_37(int var1, short var2) {
      super();
      this.field_195 = -1;
      this.field_196 = 0;
      this.field_205 = false;
      this.field_206 = false;
      this.field_207 = false;
      this.field_209 = false;
      this.field_199 = new Vector();
      if(super.field_53 == null) {
         short var4 = (short)(this.method_136() + 152 + 20);
         class_55 var10001 = new class_55((short)10, var4, (short)(ScreenDrawer.self.getWidth() - 20), (short)(ScreenDrawer.self.getHeight() - var4 - PopupMenu.method_583() - 11), true, false);
         super.field_53 = var10001;
      } else {
         super.field_53.method_495();
      }

      this.field_189 = var1;
      this.field_190 = new String[][]{null, null};
      this.field_191 = new byte[][]{{(byte)1, (byte)-1}, {(byte)10, (byte)-10}};
      this.field_192 = new short[]{(short)0, (short)0};
      this.field_193 = new byte[]{(byte)1, (byte)1};
      this.field_194 = new short[]{(short)0, (short)0};
      this.field_201 = new short[]{(short)-1, (short)-1};
      this.field_197 = new boolean[][]{{true, true}, {true, true}};
      this.field_198 = new Thing[][]{null, null};
      this.field_202 = -1;
      this.field_203 = -1;
      this.field_200 = -1;
      PopupMenu var5 = new PopupMenu();
      super.popupMenu = var5;
      super.popupMenu.method_595(false, (byte)55, PopupMenu.method_578((byte)55));
      Button var6 = new Button((byte)83, var2);
      this.field_212 = var6;
      super.popupMenu.method_594(false, this.field_212);
      if(this.method_203((byte)1)) {
         var6 = new Button((byte)78);
         this.field_214 = var6;
         this.field_214.method_656((short)191);
         this.field_214.method_650(true);
         super.popupMenu.method_594(false, this.field_214);
      }

      if(this.method_203((byte)2)) {
         var6 = new Button((byte)77);
         this.field_215 = var6;
         super.popupMenu.method_594(false, this.field_215);
      }

      if(this.method_203((byte)4)) {
         PopupMenu var10000 = super.popupMenu;
         Button var10002 = new Button((byte)49);
         var10000.method_594(false, var10002);
         var6 = new Button((byte)70);
         this.field_216 = var6;
         super.popupMenu.method_593((byte)0, this.field_216);
         var6 = new Button((byte)66);
         this.field_217 = var6;
         super.popupMenu.method_593((byte)0, this.field_217);
         var6 = new Button((byte)68);
         this.field_218 = var6;
         super.popupMenu.method_593((byte)0, this.field_218);
         var6 = new Button((byte)67);
         this.field_219 = var6;
         super.popupMenu.method_593((byte)0, this.field_219);
         var6 = new Button((byte)90);
         this.field_220 = var6;
         super.popupMenu.method_593((byte)0, this.field_220);
         var6 = new Button((byte)69);
         this.field_221 = var6;
         super.popupMenu.method_593((byte)0, this.field_221);
      }

      if(this.method_203((byte)8)) {
         var6 = new Button((byte)98);
         this.field_222 = var6;
         this.field_222.method_656((short)238);
         super.popupMenu.method_594(false, this.field_222);
      }

      if(this.method_203((byte)32)) {
         var6 = new Button((byte)48);
         this.field_223 = var6;
         this.field_223.method_656((short)(175 + (this.method_207() - 1)));
         super.popupMenu.method_594(false, this.field_223);
      }

      var6 = new Button((byte)95);
      this.field_211 = var6;
      super.popupMenu.method_594(false, this.field_211);
      var6 = new Button((byte)102);
      this.field_210 = var6;
      super.popupMenu.method_594(false, this.field_210);
      var6 = new Button((byte)81, PopupMenu.method_578((byte)81));
      this.field_213 = var6;
      this.field_213.method_656((short)7);
      this.field_213.method_648(false);
      super.popupMenu.method_594(true, this.field_213);
      if(this.method_207() == 2) {
         Item.method_779();
      }

      super.field_120 = false;
   }

   // $FF: renamed from: b () void
   public final void method_200() {
      super.popupMenu.method_595(false, (byte)101, (short)179);
   }

   // $FF: renamed from: a (byte, mobak.b.a.a[]) void
   public final void method_201(byte var1, Thing[] var2) {
      this.field_198[var1] = var2;
   }

   // $FF: renamed from: a (byte) byte
   public static byte method_202(byte var0) {
      byte var1 = 0;

      for(short var2 = 1; var2 < 129; var2 = (short)(var2 << 1)) {
         if((var0 & var2) != 0) {
            ++var1;
         }
      }

      return var1;
   }

   // $FF: renamed from: a (byte) boolean
   private boolean method_203(byte var1) {
      return (this.field_189 & var1) > 0;
   }

   // $FF: renamed from: a (byte, byte) boolean
   private boolean method_204(byte var1, byte var2) {
      if(var2 == 0) {
         var2 = this.method_205();
      } else {
         var2 = this.method_206();
      }

      return (var2 & var1) == var1;
   }

   // $FF: renamed from: b () byte
   public final byte method_205() {
      int var1 = this.field_189 >> 16;
      return (byte)(255 & var1);
   }

   // $FF: renamed from: c () byte
   public final byte method_206() {
      int var1 = this.field_189 >> 8;
      return (byte)(255 & var1);
   }

   // $FF: renamed from: d () byte
   public final byte method_207() {
      int var1 = this.field_189 >> 30;
      return (byte)(3 & var1);
   }

   // $FF: renamed from: a (java.lang.String[], int) void
   public final void method_208(String[] var1, int var2) {
      this.field_190[var2] = var1;
   }

   // $FF: renamed from: a (int, byte, byte) void
   public final void method_209(int var1, byte var2, byte var3) {
      this.field_191[var1][0] = var2;
      this.field_191[var1][1] = var3;
   }

   // $FF: renamed from: a (int, boolean, boolean) void
   public final void method_210(int var1, boolean var2, boolean var3) {
      this.field_197[var1][0] = var2;
      this.field_197[var1][0] = var3;
   }

   // $FF: renamed from: a (int, short) void
   public final void method_211(int var1, short var2) {
      this.field_192[var1] = var2;
   }

   // $FF: renamed from: a (int, byte) void
   public final void method_212(int var1, byte var2) {
      this.field_193[var1] = var2;
   }

   // $FF: renamed from: b (int, short) void
   public final void method_213(int var1, short var2) {
      this.field_194[var1] = var2;
   }

   // $FF: renamed from: e () boolean
   public final boolean method_214() {
      return (this.field_189 & 67108864) > 0;
   }

   // $FF: renamed from: f () boolean
   public final boolean method_215() {
      return (this.field_189 & 134217728) > 0;
   }

   // $FF: renamed from: a (byte) short
   private short method_216(byte var1) {
      if(var1 == 0 && this.method_215()) {
         switch(this.method_207()) {
         case 1:
            return (short)5;
         case 2:
            return (short)30;
         }
      }

      return this.field_194 != null && var1 >= 0 && var1 < this.field_194.length?this.field_194[var1]:0;
   }

   // $FF: renamed from: b (byte) boolean
   private boolean method_217(byte var1) {
      return var1 == 0?(this.field_189 & 268435456) > 0:(var1 == 1?(this.field_189 & 536870912) > 0:false);
   }

   // $FF: renamed from: a (byte, boolean) short
   private short method_218(byte var1, boolean var2) {
      short var3 = 0;
      if(var1 == 0 && this.method_215()) {
         switch(this.method_207()) {
         case 1:
            var3 = 5;
            break;
         case 2:
            var3 = 30;
         }
      } else {
         if(this.field_198 == null) {
            return (short)0;
         }

         if(var1 < 0) {
            return (short)0;
         }

         if(var1 >= this.field_198.length) {
            return (short)0;
         }

         if(this.field_198[var1] == null) {
            return (short)0;
         }

         var3 = (short)this.field_198[var1].length;
      }

      if(var2) {
         return var3;
      } else {
         short var6 = 0;

         for(short var4 = 0; var4 < var3; ++var4) {
            if(this.method_219(this.method_220(var1, var4))) {
               ++var6;
            }
         }

         return var6;
      }
   }

   // $FF: renamed from: a (mobak.b.a.a) boolean
   private boolean method_219(Thing var1) {
      return var1 == null?false:(!var1.method_771(this.field_200)?false:(!var1.method_772()?false:!this.field_207 || var1.isOnHero()));
   }

   // $FF: renamed from: a (byte, short) mobak.b.a.a
   private Thing method_220(byte var1, short var2) {
      if(var2 >= 0 && var2 < this.method_218(var1, true)) {
         if(var1 == 0 && this.method_215()) {
            switch(this.method_207()) {
            case 1:
               return Hero.self.method_880()[var2];
            case 2:
               return Hero.self.method_882((byte)-1)[var2];
            }
         }

         return (this.field_198 == null || var1 < 0 || var1 >= this.field_198.length) && var2 >= this.field_198[var1].length?null:this.field_198[var1][var2];
      } else {
         return null;
      }
   }

   // $FF: renamed from: a (byte, short) short
   private short method_221(byte var1, short var2) {
      short var3;
      if((var3 = this.method_218(var1, true)) >= 0 && var2 + 1 >= var3) {
         return (short)-1;
      } else {
         while(++var2 < var3 && !this.method_219(this.method_220(var1, var2))) {
            ;
         }

         return var2 >= var3?-1:var2;
      }
   }

   // $FF: renamed from: b (byte, short) short
   private short method_222(byte var1, short var2) {
      while(--var2 >= 0 && !this.method_219(this.method_220(var1, var2))) {
         ;
      }

      return var2;
   }

   // $FF: renamed from: a () void
   public final void method_51() {
      this.field_213.method_648(false);
      if(this.field_223 != null) {
         this.field_223.method_648(this.field_202 == 1);
      }

      boolean var1 = this.method_217(this.field_202);
      Thing var2 = this.method_220(this.field_202, this.field_203);
      if(this.field_215 != null) {
         boolean var3 = var1 && this.method_219(var2);
         if(this.method_204((byte)8, this.field_202)) {
            var3 &= this.method_236(this.field_202, this.field_203);
         }

         this.field_215.method_650(var3);
      }

      if(this.field_214 != null) {
         this.field_214.method_650(this.method_218((byte)1, true) > 0);
      }

      this.field_212.method_650(this.method_232());
      if(var1) {
         if(var2 != null && (var2.isOnHero() || !this.method_204((byte)8, this.field_202))) {
            this.field_213.method_648(true);
            if(this.field_215 != null) {
               this.field_215.method_650(this.method_217(this.field_202));
            }

         }
      }
   }

   // $FF: renamed from: c (int) void
   protected final synchronized void method_39(int var1) {
      var1 = ScreenDrawer.self.getGameAction(var1);
      if(this.field_205) {
         switch(var1) {
         case 1:
            this.method_225(this.field_191[0][0], true, this.field_203);
            break;
         case 2:
            this.method_225(this.field_191[1][1], true, this.field_203);
            break;
         case 5:
            this.method_225(this.field_191[1][0], true, this.field_203);
         case 3:
         case 4:
         default:
            return;
         case 6:
            this.method_225(this.field_191[0][1], true, this.field_203);
         }
      } else {
         switch(var1) {
         case 1:
            this.method_223(true);
            break;
         case 2:
            this.method_224(false);
         case 3:
         case 4:
         default:
            break;
         case 5:
            this.method_224(true);
            break;
         case 6:
            this.method_223(false);
         }

         this.field_206 = false;
      }

   }

   // $FF: renamed from: d (boolean) void
   private void method_223(boolean var1) {
      byte var2 = this.field_202;
      if(var1) {
         --var2;
      } else {
         ++var2;
      }

      if(this.method_218(var2, false) > 0) {
         this.field_202 = var2;
         short var5 = this.field_201[this.field_202];
         short var6 = this.method_218(this.field_202, true);
         byte var3 = 0;

         for(short var4 = this.field_201[this.field_202]; var4 < var6 && var4 >= 0; var4 = this.method_221(this.field_202, var4)) {
            if(this.method_219(this.method_220(this.field_202, var4))) {
               var5 = var4;
               if(var3 == this.field_204) {
                  break;
               }

               ++var3;
            }
         }

         this.field_203 = var5;
      }
   }

   // $FF: renamed from: b (boolean) void
   protected final void method_224(boolean var1) {
      short var5;
      if(var1) {
         var5 = this.method_221(this.field_202, this.field_203);
      } else {
         var5 = this.method_222(this.field_202, this.field_203);
      }

      if(var5 >= 0) {
         this.field_203 = var5;
         var5 = this.method_218(this.field_202, false);
         byte var2 = this.method_144(false);
         int var3 = 0;

         for(int var4 = this.method_221(this.field_202, (short)-1); var4 < this.field_203; ++var4) {
            if(this.method_220(this.field_202, (short)var4) == null) {
               ++var3;
            }
         }

         short var6;
         if((var6 = (short)(this.field_203 - var2 / 2 - var3)) > 0) {
            if(var6 + var2 < var5) {
               this.field_201[this.field_202] = var6;
            } else {
               this.field_201[this.field_202] = (short)(var5 - var2);
            }
         } else {
            this.field_201[this.field_202] = 0;
         }

         if(this.field_201[this.field_202] < 0) {
            this.field_201[this.field_202] = 0;
         }

         if(this.field_201[this.field_202] + var2 > var5) {
            this.field_201[this.field_202] = (short)(var5 - var2);
         }

      }
   }

   // $FF: renamed from: a (int, boolean, short) void
   private void method_225(int var1, boolean var2, short var3) {
      this.method_226(var1, var2, this.field_202, var3);
   }

   // $FF: renamed from: a (int, boolean, byte, short) void
   private void method_226(int var1, boolean var2, byte var3, short var4) {
      Thing var5;
      if((var5 = this.method_220(var3, var4)) != null) {
         if(var1 < 0) {
            var5.method_745(var1, this.field_197[var3][0], this.field_197[var3][1]);
         } else {
            byte var6 = 0;
            class_37 var7;
            Thing var9;
            short var11;
            int var10000;
            if(this.method_204((byte)1, var3)) {
               var7 = this;
               if((var9 = this.method_220(var3, var4)) == null) {
                  var10000 = 0;
               } else {
                  long var12 = 0L;
                  var11 = this.method_218((byte)0, true);
                  short var18;
                  byte var14 = (byte)(((var18 = this.field_192[0]) >> 8) - 1);

                  short var16;
                  Thing var17;
                  for(var16 = 0; var16 < var11; ++var16) {
                     if((var17 = var7.method_220((byte)0, var16)) != null && var17.method_739() > 0) {
                        var12 += (long)(var7.field_193[0] * var17.method_752(var14) * var17.method_739());
                     }
                  }

                  var11 = var7.method_218((byte)1, true);
                  var14 = (byte)(((var18 = var7.field_192[1]) >> 8) - 1);

                  for(var16 = 0; var16 < var11; ++var16) {
                     if((var17 = var7.method_220((byte)1, var16)) != null && var17.method_739() > 0) {
                        var12 += (long)(var7.field_193[1] * var17.method_752(var14) * var17.method_739());
                     }
                  }

                  long var31 = (Hero.self.method_896(var7.field_120) - var12) / (long)var9.method_752((byte)((var7.field_192[var7.field_202] >> 8) - 1));
                  var10000 = (int)Math.min((long)var1, var31);
               }

               var1 = var10000;
               if(var10000 <= 0) {
                  if(var2) {
                     if(super.field_120) {
                        Main2.method_859();
                        return;
                     }

                     if(!ScreenDrawer.self.method_366()) {
                        ScreenDrawer.method_330(MessagesContainer.getMessage(105), this.field_190[var3][0]);
                     }
                  }

                  return;
               }

               var6 = 1;
            }

            short var13;
            byte var22;
            Thing var28;
            if(this.method_204((byte)2, var3)) {
               boolean var34;
               label223: {
                  var7 = this;
                  Thing var10;
                  if((var10 = this.method_220(var3, var4)) != null) {
                     if(var10.method_739() > 0) {
                        var34 = true;
                        break label223;
                     }

                     byte var21 = (byte)(this.field_202 == 0?1:0);
                     if(this.method_216(var21) == -1) {
                        var34 = true;
                        break label223;
                     }

                     short var23 = this.method_218(var21, true);
                     var22 = var21;
                     class_37 var19 = this;
                     short var26;
                     short var30;
                     if((var13 = this.method_218(var21, true)) < 0) {
                        var30 = -1;
                     } else {
                        var26 = 0;

                        for(short var15 = 0; var15 < var13; ++var15) {
                           if(var19.method_220(var22, var15) != null) {
                              ++var26;
                           }
                        }

                        var30 = var26;
                     }

                     var13 = var30;
                     if(var23 > 0) {
                        for(var11 = 0; var11 < var23; ++var11) {
                           if((var28 = var7.method_220(var21, var11)) != null && var10.method_755(var28) && var28.method_739() != var28.getQuantity()) {
                              var34 = true;
                              break label223;
                           }

                           if(var28 != null && var28.method_739() == var28.getQuantity()) {
                              --var13;
                           }
                        }
                     } else {
                        var13 = 0;
                     }

                     if(var7.method_216(var21) > 0) {
                        var23 = var7.method_216(var21);
                     }

                     var11 = var7.method_218(var7.field_202, true);

                     for(var26 = 0; var26 < var11; ++var26) {
                        Thing var32;
                        if((var32 = var7.method_220(var7.field_202, var26)) != null && var32.method_739() != 0) {
                           boolean var33 = false;

                           for(short var20 = 0; var20 < var13; ++var20) {
                              if((var10 = var7.method_220(var21, var26)) != null && var10.method_739() != var10.getQuantity() && var10.method_755(var32)) {
                                 var33 = true;
                                 break;
                              }
                           }

                           if(!var33) {
                              ++var13;
                           }
                        }
                     }

                     if(var13 < var23) {
                        var34 = true;
                        break label223;
                     }
                  }

                  var34 = false;
               }

               if(!var34) {
                  if(var2 && !ScreenDrawer.self.method_366()) {
                     ScreenDrawer.method_330(MessagesContainer.getMessage(105), this.field_190[var3][var6]);
                  }

                  return;
               }

               ++var6;
            }

            if(this.method_204((byte)4, var3)) {
               var7 = this;
               if((var9 = this.method_220(var3, var4)) == null) {
                  var10000 = 0;
               } else {
                  int var25 = 0;

                  for(byte var27 = 0; var27 < 5; ++var27) {
                     Unit var24;
                     if((var24 = Hero.self.method_880()[var27]) != null) {
                        var25 += (var24.getQuantity() - var24.method_739()) * var24.method_756();
                     }
                  }

                  var13 = this.method_218((byte)1, true);

                  for(var22 = 0; var22 < var13; ++var22) {
                     if((var28 = var7.method_220((byte)1, (short)var22)) != null) {
                        var25 += var28.method_739() * var28.method_756();
                     }
                  }

                  int var29 = (Hero.self.method_893(Hero.self.skills, (byte)14, 0) * 100 - var25) / var9.method_756();
                  var10000 = Math.min(var1, var29);
               }

               var1 = var10000;
               if(var10000 <= 0) {
                  if(var2 && !ScreenDrawer.self.method_366()) {
                     ScreenDrawer.method_330(MessagesContainer.getMessage(105), this.field_190[var3][var6]);
                  }

                  return;
               }

               ++var6;
            }

            if(this.method_204((byte)8, var3) && !this.method_236(var3, var4)) {
               if(var2 && !ScreenDrawer.self.method_366()) {
                  ScreenDrawer.method_330(MessagesContainer.getMessage(105), this.field_190[var3][var6]);
               }

            } else {
               if(var1 > 0) {
                  var5.method_745(var1, this.field_197[var3][0], this.field_197[var3][1]);
               }

            }
         }
      }
   }

   // $FF: renamed from: a (byte) void
   private void method_227(byte var1) {
      if(var1 != -1 && this.field_200 != -1) {
         if((this.field_200 & var1) > 0) {
            this.field_200 = (byte)(this.field_200 & ~var1);
         } else {
            this.field_200 |= var1;
         }
      } else {
         this.field_200 = var1;
      }

      this.method_234();
   }

   // $FF: renamed from: a (mobak.a.a.l, byte) boolean
   private boolean method_228(OutputGameMessage var1, byte var2) {
      if(var1 == null) {
         return false;
      } else {
         short var3;
         if((var3 = this.method_218(var2, true)) < 0) {
            return false;
         } else {
            boolean var4 = false;

            for(short var5 = 0; var5 < var3; ++var5) {
               Thing var6;
               if((var6 = this.method_220(var2, var5)) != null && var6.method_739() > 0) {
                  try {
                     var1.addToBody(var6.getId());
                     var1.addToBody(var6.method_739());
                     var4 = true;
                  } catch (Exception var7) {
                     SocketListener.logMessage("addToOrderRequest" + var7.toString());
                  }
               }
            }

            return var4;
         }
      }
   }

   // $FF: renamed from: b (byte) void
   private void method_229(byte var1) {
      short var2;
      if((var2 = this.method_218(var1, true)) >= 0) {
         for(short var3 = 0; var3 < var2; ++var3) {
            Thing var4;
            if((var4 = this.method_220(var1, var3)) != null && var4.method_739() > 0) {
               var4.method_740(0);
            }
         }

      }
   }

   // $FF: renamed from: o () void
   private void method_230() {
      if(this.field_208 != null && this.field_208.size() > 0) {
         try {
            OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[83], (short)200, (short)0);
            OutputGameMessage var1 = var10000;

            for(short var2 = 0; var2 < this.field_208.size(); ++var2) {
               Thing var3 = (Thing)this.field_208.elementAt(var2);
               var1.addToBody(var3.getId());
            }

            SocketListener.self.sendCommand(var1);
         } catch (Exception var4) {
            ;
         }
      }

      this.field_208 = null;
   }

   // $FF: renamed from: p () void
   private void method_231() {
      if(this.field_205) {
         this.field_213.method_656((short)7);
      } else {
         this.field_213.method_656((short)106);
      }

      this.field_205 = !this.field_205;
   }

   // $FF: renamed from: g () boolean
   private boolean method_232() {
      short var1;
      short var2;
      Thing var3;
      if((var1 = this.method_218((byte)0, true)) > 0) {
         for(var2 = 0; var2 < var1; ++var2) {
            if((var3 = this.method_220((byte)0, var2)) != null && var3.method_739() > 0) {
               return true;
            }
         }
      }

      if((var1 = this.method_218((byte)1, true)) > 0) {
         for(var2 = 0; var2 < var1; ++var2) {
            if((var3 = this.method_220((byte)1, var2)) != null && var3.method_739() > 0) {
               return true;
            }
         }
      }

      return false;
   }

   // $FF: renamed from: c () void
   protected final void method_233() {
      this.method_230();
      this.method_229((byte)0);
      this.method_229((byte)1);
      OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[15]);
      OutputGameMessage var1 = var10000;
      SocketListener.self.sendCommand(var1);
      ScreenDrawer.self.method_346();
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button button) {
      switch(button.method_652()) {
      case 48:
         class_26 var12 = new class_26(this);
         class_26 var6 = var12;
         ScreenDrawer.method_334(MessagesContainer.getLine(135), MessagesContainer.getLine((short)(246 + this.method_207() - 1)), "", var6);
         return true;
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 56:
      case 57:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 65:
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
      case 76:
      case 79:
      case 80:
      case 82:
      case 84:
      case 85:
      case 86:
      case 87:
      case 88:
      case 89:
      case 91:
      case 92:
      case 93:
      case 94:
      case 95:
      case 96:
      case 97:
      default:
         return super.method_38(button);
      case 55:
         boolean var11;
         if(this.method_232()) {
            class_21 var10 = new class_21(this);
            class_21 var7 = var10;
            ScreenDrawer.method_334(MessagesContainer.getMessage(135), MessagesContainer.getMessage(192), "", var7);
            var11 = true;
         } else {
            this.method_233();
            var11 = true;
         }

         return true;
      case 66:
         this.method_227((byte)1);
         return true;
      case 67:
         this.method_227((byte)4);
         return true;
      case 68:
         this.method_227((byte)2);
         return true;
      case 69:
         this.method_227((byte)16);
         return true;
      case 70:
         this.method_227((byte)-1);
         return true;
      case 77:
         if(this.method_220(this.field_202, this.field_203) != null) {
            this.method_225(Integer.MAX_VALUE, false, this.field_203);
         }

         return true;
      case 78:
         class_37 var5 = this;
         short var8;
         if((var8 = this.method_218((byte)1, true)) > 0) {
            for(short var9 = 0; var9 < var8 && var9 >= 0 && var5.method_220((byte)1, var9) != null; var9 = var5.method_221((byte)1, var9)) {
               var5.method_226(Integer.MAX_VALUE, false, (byte)1, var9);
            }
         }

         return true;
      case 81:
         this.method_231();
         return true;
      case 83:
         OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[25], (short)200, (short)0);
         OutputGameMessage var2 = var10000;
         switch(this.method_207()) {
         case 1:
            var2.setNextCommandType(MessageProcessor.packetTypes[17]);
            break;
         case 2:
            var2.setNextCommandType(MessageProcessor.packetTypes[16]);
         }

         boolean var3 = this.method_228(var2, (byte)0);
         boolean var4 = this.method_228(var2, (byte)1);
         this.method_230();
         if(var3 || var4) {
            SocketListener.self.sendCommand(var2);
         }

         this.method_233();
         return true;
      case 90:
         this.method_227((byte)8);
         return true;
      case 98:
         if(this.field_207) {
            this.field_222.method_656((short)238);
         } else {
            this.field_222.method_656((short)239);
         }

         this.field_207 = !this.field_207;
         this.method_234();
         return true;
      }
   }

   // $FF: renamed from: q () void
   private void method_234() {
      this.field_201[0] = this.method_221((byte)0, (short)-1);
      this.field_201[1] = this.method_221((byte)1, (short)-1);
      this.field_203 = this.field_201[this.field_202];
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final synchronized void method_30(Graphics var1) {
      super.method_30(var1);
      this.method_51();
      short var2 = (short)(this.method_136() + 5);
      this.field_199.removeAllElements();
      this.method_235(var1, (short)(var2 - 2), (byte)0);
      var2 = (short)(var2 + 76);
      this.method_235(var1, var2, (byte)1);
      if(this.field_205 && this.method_217(this.field_202)) {
         int var3;
         if((var3 = ScreenDrawer.self.getHeight() / 2) < this.method_136() + 152 + 20) {
            var3 = this.method_136() + 152 + 20;
         }

         this.method_145(var1, var3);
      }

      super.popupMenu.method_604(var1);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, byte) void
   private void method_235(Graphics var1, short var2, byte var3) {
      byte var4 = this.method_144(false);
      short var5 = (short)((ScreenDrawer.self.getWidth() - var4 * 61) / 2);
      if(this.field_201[var3] < 0) {
         this.field_201[var3] = 0;
      }

      short var6 = this.method_218(var3, false);
      if(this.method_222(var3, this.field_201[var3]) >= 0) {
         Image var7;
         int var8 = ScreenDrawer.method_382(var7 = GlobalStorage.getImage(MenuScreen.field_94));
         int var9 = ScreenDrawer.method_383(var7);
         ScreenDrawer.method_372(var1, var7, 0, 0, var8, var9, 0, var5 - var8, var2 + 26, 3);
      }

      short var13;
      short var14 = var13 = this.method_221(var3, (short)-1);
      Thing var15 = null;
      ScreenDrawer.method_368(var1, var5, var2, this.method_144(false) * 61 + 1, 77);

      for(short var10 = 0; var10 < var6 && var13 >= 0; ++var10) {
         Thing var11;
         if((var11 = this.method_220(var3, var13)) != null) {
            if(this.field_202 < 0) {
               this.field_202 = var3;
            }

            if(this.field_203 < 0) {
               this.field_203 = var13;
            }

            Vector var10000 = this.field_199;
            class_84 var10001 = new class_84(var5 - this.field_201[var3] * 61, var2, 61, 53, var3, var13);
            var10000.addElement(var10001);
            if(this.field_202 == var3 && this.field_203 == var13) {
               this.field_204 = (byte)var13;
               short var12 = 257;
               if(this.field_205) {
                  var12 = 1281;
               }

               if(this.field_195 == var3) {
                  var11.method_758(var1, (short)(var5 - this.field_201[var3] * 61 + this.field_196), var2, (short)(this.field_192[var3] | var12));
               } else {
                  var11.method_758(var1, (short)(var5 - this.field_201[var3] * 61), var2, (short)(this.field_192[var3] | var12));
               }

               if(!this.field_206) {
                  var15 = var11;
               }
            } else if(this.field_195 == var3) {
               var11.method_758(var1, (short)(var5 - this.field_201[var3] * 61 + this.field_196), var2, (short)(this.field_192[var3] | 256));
            } else {
               var11.method_758(var1, (short)(var5 - this.field_201[var3] * 61), var2, (short)(this.field_192[var3] | 256));
            }
         } else {
            byte var20 = (byte)(8 - var3);
            if(this.field_195 == var3) {
               ScreenDrawer.method_373(var1, MenuScreen.field_98, 9, 1, var20, 0, (short)(var5 - this.field_201[var3] * 61 + this.field_196), var2);
            } else {
               ScreenDrawer.method_373(var1, MenuScreen.field_98, 9, 1, var20, 0, (short)(var5 - this.field_201[var3] * 61), var2);
            }
         }

         if(var13 >= 0) {
            var14 = var13;
            if((var13 = this.method_221(var3, var13)) >= 0) {
               var5 = (short)(var5 + 61);
            }
         }
      }

      if(var6 < var4) {
         int var16;
         byte var17;
         if(var6 > 0) {
            var5 = (short)(var5 + 61);

            for(var16 = var6 + 1; var16 <= var4; ++var16) {
               var17 = (byte)(8 - var3);
               if(this.field_195 == var3) {
                  ScreenDrawer.method_373(var1, MenuScreen.field_98, 9, 1, var17, 0, (short)(var5 - this.field_201[var3] * 61 + this.field_196), var2);
               } else {
                  ScreenDrawer.method_373(var1, MenuScreen.field_98, 9, 1, var17, 0, (short)(var5 - this.field_201[var3] * 61), var2);
               }

               var5 = (short)(var5 + 61);
            }
         } else {
            for(var16 = var6 + 1; var16 <= var4; ++var16) {
               var17 = (byte)(8 - var3);
               if(this.field_195 == var3) {
                  ScreenDrawer.method_373(var1, MenuScreen.field_98, 9, 1, var17, 0, (short)(var5 + this.field_196), var2);
               } else {
                  ScreenDrawer.method_373(var1, MenuScreen.field_98, 9, 1, var17, 0, var5, var2);
               }

               var5 = (short)(var5 + 61);
            }
         }
      }

      ScreenDrawer.method_368(var1, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
      if(var15 != null) {
         super.field_53.method_495();
         var15.getDescription(super.field_53, (String)null, this.field_192[var3]);
         this.field_206 = true;
      }

      if(super.field_53 != null && var3 == 0) {
         super.field_53.method_484(var1, (byte)0);
      }

      if(this.method_221(var3, var14) > 0) {
         Image var18;
         int var19 = ScreenDrawer.method_382(var18 = GlobalStorage.getImage(MenuScreen.field_95));
         int var21 = ScreenDrawer.method_383(var18);
         ScreenDrawer.method_372(var1, var18, 0, 0, var19, var21, 0, var5 + var19, var2 + 26, 3);
      }

   }

   // $FF: renamed from: a (byte, short) boolean
   private boolean method_236(byte var1, short var2) {
      Thing var3;
      return (var3 = this.method_220(var1, var2)) == null?false:var3.isOnHero();
   }

   // $FF: renamed from: g () void
   public final void helpViewInit() {
      super.helpViewInit();
      this.method_51();
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      super.field_53.method_506(var1, var2);
      Screen.field_34 = var1;
      Screen.field_35 = var2;
      Screen.field_36 = var1;
      Screen.field_37 = var2;
      Screen.field_38 = true;
      this.field_209 = false;
      byte var3;
      if((var3 = this.method_146(var1, var2)) != 1 && var3 != 2) {
         class_84 var6 = null;

         for(int var4 = 0; var4 < this.field_199.size() && var6 == null; ++var4) {
            class_84 var5;
            if((var5 = (class_84)this.field_199.elementAt(var4)).method_946(var1, var2)) {
               var6 = var5;
            }
         }

         if(var6 == null) {
            return false;
         } else {
            this.field_195 = var6.field_725;
            this.field_202 = var6.field_725;
            return false;
         }
      } else {
         return true;
      }
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      try {
         super.field_53.method_508();
         if(this.field_195 >= 0) {
            if(this.field_196 > 0) {
               this.field_196 = (short)(this.field_196 + 30);
            } else {
               this.field_196 = (short)(this.field_196 - 30);
            }

            this.field_201[this.field_195] = (short)(this.field_201[this.field_195] - this.field_196 / 61);
         }

         this.field_196 = 0;
         this.field_195 = -1;
         class_84 var4 = null;

         for(int var5 = 0; var5 < this.field_199.size() && var4 == null; ++var5) {
            class_84 var6;
            if((var6 = (class_84)this.field_199.elementAt(var5)).method_946(var1, var2)) {
               var4 = var6;
            }
         }

         if(Screen.field_38 && this.field_205) {
            byte var9 = this.method_146(var1, var2);
            if(this.method_217(this.field_202)) {
               if(var9 == 1) {
                  if(!this.field_209 || var3 >= 300) {
                     this.method_225(this.field_191[0][0] * MenuScreen.method_128(var3, 300), true, this.field_203);
                  }
               } else if(var9 == 2 && (!this.field_209 || var3 >= 300)) {
                  this.method_225(this.field_191[0][1] * MenuScreen.method_128(var3, 300), true, this.field_203);
               }
            }
         }

         short var10 = this.method_218(this.field_202, false);
         byte var8 = this.method_144(false);
         if(var4 == null && this.field_196 == 0) {
            if(this.field_201[this.field_202] < 0) {
               this.field_201[this.field_202] = 0;
            }

            if(this.field_201[this.field_202] + var8 > var10) {
               this.field_201[this.field_202] = (short)(var10 - var8);
            }

            Screen.field_38 = true;
            Screen.field_38 = true;
            return false;
         }

         if(Screen.field_38) {
            if(this.field_202 == var4.field_725 && this.field_203 == var4.field_726) {
               this.method_231();
            } else {
               if(this.field_205) {
                  this.method_231();
               }

               this.field_202 = var4.field_725;
               this.field_203 = var4.field_726;
            }

            this.field_206 = false;
         }

         if(this.field_201[this.field_202] < 0) {
            this.field_201[this.field_202] = 0;
         }

         if(this.field_201[this.field_202] + var8 > var10) {
            this.field_201[this.field_202] = (short)(var10 - var8);
         }

         Screen.field_38 = true;
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      return true;
   }

   // $FF: renamed from: a (int, int, int) boolean
   protected final boolean method_61(int var1, int var2, int var3) {
      class_84 var4 = null;

      for(int var5 = 0; var5 < this.field_199.size() && var4 == null; ++var5) {
         class_84 var6;
         if((var6 = (class_84)this.field_199.elementAt(var5)).method_946(var1, var2)) {
            var4 = var6;
         }
      }

      if(Screen.field_38) {
         byte var7 = this.method_146(var1, var2);
         if(this.method_217(this.field_202)) {
            if(var7 == 1) {
               if(var3 <= 300) {
                  if(!this.field_209) {
                     this.method_225(1, true, this.field_203);
                  }
               } else {
                  this.method_225(this.field_191[0][0] * MenuScreen.method_128(var3, 300), true, this.field_203);
               }

               this.field_209 = true;
            } else if(var7 == 2) {
               if(var3 <= 300) {
                  if(!this.field_209) {
                     this.method_225(-1, true, this.field_203);
                  }
               } else {
                  this.method_225(this.field_191[0][1] * MenuScreen.method_128(var3, 300), true, this.field_203);
               }

               this.field_209 = true;
            }
         }

         return true;
      } else if(var4 == null) {
         return false;
      } else {
         if(this.field_202 == var4.field_725 && this.field_203 == var4.field_726 && !this.field_205 && Screen.field_38) {
            this.method_231();
         }

         return false;
      }
   }

   // $FF: renamed from: b (int, int) boolean
   protected final boolean method_62(int var1, int var2) {
      if(Math.abs(Screen.field_36 - Screen.field_34) > 20 || Math.abs(Screen.field_37 - Screen.field_35) > 20) {
         Screen.field_38 = false;
      }

      int var3 = var1 - Screen.field_36;
      int var4 = var2 - Screen.field_37;
      this.field_196 = (short)(this.field_196 + var3);
      if(super.field_53.method_507()) {
         super.field_53.method_503(super.field_53.method_502() - var4);
         Screen.field_37 = var2;
      }

      Screen.field_36 = var1;
      if(this.field_195 < 0) {
         int var10000 = Screen.field_35;
         Math.abs((Screen.field_34 - var1) / 30);
      }

      return true;
   }

   // $FF: renamed from: a (mobak.b.b.a.y) java.util.Vector
   static Vector method_237(class_37 var0) {
      return var0.field_208;
   }

   // $FF: renamed from: a (mobak.b.b.a.y, java.util.Vector) java.util.Vector
   static Vector method_238(class_37 var0, Vector var1) {
      return var0.field_208 = var1;
   }

   // $FF: renamed from: a (mobak.b.b.a.y) byte
   static byte method_239(class_37 var0) {
      return var0.field_202;
   }

   // $FF: renamed from: a (mobak.b.b.a.y) short
   static short method_240(class_37 var0) {
      return var0.field_203;
   }

   // $FF: renamed from: a (mobak.b.b.a.y, byte, short) mobak.b.a.a
   static Thing method_241(class_37 var0, byte var1, short var2) {
      return var0.method_220(var1, var2);
   }

   // $FF: renamed from: a (mobak.b.b.a.y, byte, boolean) short
   static short method_242(class_37 var0, byte var1, boolean var2) {
      return var0.method_218(var1, false);
   }

   // $FF: renamed from: a (mobak.b.b.a.y, boolean) void
   static void method_243(class_37 var0, boolean var1) {
      var0.method_223(true);
   }

   // $FF: renamed from: a (mobak.b.b.a.y) short[]
   static short[] method_244(class_37 var0) {
      return var0.field_201;
   }
}
