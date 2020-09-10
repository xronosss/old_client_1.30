package mobak.b.b.a;

import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.c.class_62;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.u
public final class PopupMenu {

   // $FF: renamed from: a int
   private static int field_512;
   // $FF: renamed from: b int
   private static int field_513;
   // $FF: renamed from: a int[]
   private static final int[] field_514;
   // $FF: renamed from: b int[]
   private static final int[] field_515;
   // $FF: renamed from: a short
   private static short field_516;
   // $FF: renamed from: b short
   private static short field_517;
   // $FF: renamed from: c short
   private static short field_518;
   // $FF: renamed from: d short
   private static short field_519;
   // $FF: renamed from: e short
   private static short field_520;
   // $FF: renamed from: f short
   private static short field_521;
   // $FF: renamed from: g short
   private static short field_522;
   // $FF: renamed from: h short
   private static short field_523;
   // $FF: renamed from: a javax.microedition.lcdui.Image
   private static Image field_524;
   // $FF: renamed from: a byte
   private static byte field_525;
   // $FF: renamed from: b javax.microedition.lcdui.Image
   private static Image field_526;
   // $FF: renamed from: b byte
   private static byte field_527;
   // $FF: renamed from: a java.util.Vector
   private Vector field_528;
   // $FF: renamed from: b java.util.Vector
   private Vector field_529;
   // $FF: renamed from: a java.util.Vector[]
   private Vector[] field_530;
   // $FF: renamed from: c byte
   private byte field_531;
   // $FF: renamed from: d byte
   private byte field_532;
   // $FF: renamed from: e byte
   private byte field_533;
   // $FF: renamed from: a java.util.Hashtable
   private static final Hashtable field_534;


   // $FF: renamed from: a (byte) short
   public static short method_578(byte var0) {
      switch(var0) {
      case -2:
         return (short)62;
      case -1:
      case 0:
      case 3:
      case 6:
      case 7:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 80:
      case 82:
      case 91:
      case 92:
      case 105:
      default:
         Short var1;
         if((var1 = (Short)field_534.get(new Byte(var0))) != null) {
            return var1.shortValue();
         }

         return (short)0;
      case 1:
         return (short)69;
      case 2:
         return (short)70;
      case 4:
         return (short)71;
      case 5:
         return (short)47;
      case 8:
         return (short)94;
      case 47:
         return (short)203;
      case 48:
         return (short)175;
      case 49:
         return (short)207;
      case 50:
         return (short)1;
      case 51:
         return (short)72;
      case 52:
         return (short)73;
      case 53:
         return (short)74;
      case 54:
         return (short)76;
      case 55:
         return (short)1;
      case 56:
         return (short)106;
      case 57:
         return (short)77;
      case 58:
         return (short)63;
      case 59:
         return (short)79;
      case 60:
         return (short)81;
      case 61:
         return (short)82;
      case 62:
         return (short)83;
      case 63:
         return (short)39;
      case 64:
         return (short)85;
      case 65:
         return (short)86;
      case 66:
         return (short)71;
      case 67:
         return (short)54;
      case 68:
         return (short)87;
      case 69:
         return (short)88;
      case 70:
         return (short)64;
      case 71:
         return (short)84;
      case 72:
         return (short)65;
      case 73:
         return (short)89;
      case 74:
         return (short)90;
      case 75:
         return (short)74;
      case 76:
         return (short)100;
      case 77:
         return (short)130;
      case 78:
         return (short)131;
      case 79:
         return (short)68;
      case 81:
         return (short)7;
      case 83:
         return (short)92;
      case 84:
         return (short)8;
      case 85:
         return (short)93;
      case 86:
         return (short)91;
      case 87:
         return (short)95;
      case 88:
         return (short)52;
      case 89:
         return (short)98;
      case 90:
         return (short)53;
      case 93:
         return (short)68;
      case 94:
         return (short)38;
      case 95:
         return (short)298;
      case 96:
         return (short)106;
      case 97:
         return (short)81;
      case 98:
         return (short)187;
      case 99:
         return (short)74;
      case 100:
         return (short)172;
      case 101:
         return (short)179;
      case 102:
         return (short)181;
      case 103:
         return (short)275;
      case 104:
         return (short)274;
      case 106:
         return (short)299;
      }
   }

   // $FF: renamed from: <init> (byte) void
   private PopupMenu(byte var1) {
      super();
      this.field_531 = 0;
      this.field_532 = -1;
      this.field_533 = var1;
   }

   // $FF: renamed from: <init> () void
   public PopupMenu() {
      super();
      this.field_531 = 0;
      this.field_532 = -1;
      this.field_528 = new Vector();
      this.field_529 = new Vector();
      byte var2 = 0;
      this.field_533 = var2;
   }

   // $FF: renamed from: <init> (byte[], byte[], byte[][]) void
   public PopupMenu(byte[] var1, byte[] var2, byte[][] var3) {
      super();
      this.field_531 = 0;
      this.field_532 = -1;
      int i;
      if(var1 != null) {
         this.field_528 = new Vector(var1.length);

         for(i = 0; i < var1.length; ++i) {
            this.method_595(true, var1[i], method_578(var1[i]));
         }
      } else {
         this.field_528 = new Vector();
      }

      if(var2 != null) {
         this.field_529 = new Vector(var2.length);

         for(i = 0; i < var2.length; ++i) {
            this.method_595(false, var2[i], method_578(var2[i]));
         }
      } else {
         this.field_529 = new Vector();
      }

      if(var3 != null) {
         this.field_530 = new Vector[var3.length];

         for(i = 0; i < var3.length; ++i) {
            this.field_530[i] = new Vector();

            for(int var5 = 0; var5 < var3[i].length; ++var5) {
               method_592(this.field_530[i], var3[i][var5], method_578(var3[i][var5]));
            }
         }
      }

      this.field_532 = -1;
      byte var6 = 0;
      this.field_533 = var6;
   }

   // $FF: renamed from: a (byte) void
   public final void method_582(byte var1) {
      this.field_533 = var1;
   }

   // $FF: renamed from: a () int
   public static int method_583() {
      return method_585();
   }

   // $FF: renamed from: b () int
   private static int method_584() {
      int var0;
      if((var0 = ScreenDrawer.self.getWidth() / 2) < 120) {
         var0 = 120;
      }

      if(var0 > 400) {
         var0 = 400;
      }

      return var0;
   }

   // $FF: renamed from: c () int
   private static int method_585() {
      if(ScreenDrawer.self.method_380()) {
         int var0;
         if((var0 = ScreenDrawer.self.getHeight() / 8) < 28) {
            var0 = 28;
         }

         if(var0 > 88) {
            var0 = 88;
         }

         return var0;
      } else {
         return ScreenDrawer.method_378(field_517);
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, mobak.c.a, java.lang.String, java.lang.String) void
   private void method_586(Graphics var1, class_62 var2, String var3, String var4) {
      int var5;
      int var6 = ((var5 = ScreenDrawer.self.getWidth()) - (method_584() << 1)) / 2;
      int var7 = ScreenDrawer.self.getHeight();
      int var11 = var7 - method_585();
      int var12 = method_584();
      this.method_587(var1, var6, var11, var12);
      this.method_587(var1, var6 + var12, var11, var12);
      if(var3 != null && !var3.equals("")) {
         var2.method_564(var1, var3, var6 + (method_584() << 1) / 4, var7 - method_585() / 2, 3);
      }

      if(var4 != null && !var4.equals("")) {
         var2.method_564(var1, var4, var5 - var6 - (method_584() << 1) / 4, var7 - method_585() / 2, 3);
      }

   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int) void
   private void method_587(Graphics var1, int var2, int var3, int var4) {
      if(!ScreenDrawer.self.method_380()) {
         int var5 = ScreenDrawer.method_377(field_516) / 5;
         int var6 = ScreenDrawer.method_378(field_516);
         int var7 = ScreenDrawer.method_377(field_518) / 5;
         int var8 = ScreenDrawer.method_378(field_518);
         ScreenDrawer.method_374(var1, field_516, this.field_533 * var5, 0, var5, var6, 0, var2, var3, 0);
         ScreenDrawer.method_375(var1, field_517, 5, this.field_533, var2 + var5, var3, var2 + var4 - var5, true, 16);
         var2 += var4 - var5;
         ScreenDrawer.method_374(var1, field_518, this.field_533 * var7, 0, var7, var8, 0, var2, var3, 0);
      } else {
         if(field_524 == null || field_525 != this.field_533) {
            field_524 = this.method_588(false);
         }

         ScreenDrawer.method_370(var1, field_524, var2, var3, 0);
      }
   }

   // $FF: renamed from: a (boolean) javax.microedition.lcdui.Image
   private Image method_588(boolean var1) {
      try {
         Image var15;
         int var2 = ScreenDrawer.method_382(var15 = GlobalStorage.getImage(var1?field_523:field_522)) / 5;
         int var3 = ScreenDrawer.method_383(var15);
         int var4 = method_584();
         int var5 = method_585();
         Image var6;
         Graphics var7 = (var6 = ScreenDrawer.method_390(var4, var5)).getGraphics();
         int var8 = var4 > 40?41:40;
         int var9 = var5 > 29?15:14;
         int var10 = var5 > 28?15:14;
         int var11 = ScreenDrawer.method_383(var6) / 2;
         field_525 = this.field_533;
         int var12 = -var2 * this.field_533;
         int var13 = var11 - var9;
         ScreenDrawer.method_369(var7, 0, var13, 40, var9);
         ScreenDrawer.method_370(var7, var15, var12, var13, 0);
         ScreenDrawer.method_369(var7, 40, var13, var8, var9);
         ScreenDrawer.method_370(var7, var15, var12 - var2 + 40 + var8, var13, 0);
         ScreenDrawer.method_369(var7, 0, var11, 40, var10);
         ScreenDrawer.method_370(var7, var15, var12, var13 - var3 + var9 + var10, 0);
         ScreenDrawer.method_369(var7, 40, var11, var8, var10);
         ScreenDrawer.method_370(var7, var15, var12 - var2 + 40 + var8, var13 - var3 + var9 + var10, 0);
         if((var2 = var4 - 40 - var8) != 0) {
            var15 = ScreenDrawer.method_391(var6);

            for(var3 = 1; var3 <= var2; ++var3) {
               ScreenDrawer.method_369(var7, var3 + 40, var13, var4 - 40, var9 + var10);
               ScreenDrawer.method_370(var7, var15, var3, 0, 0);
            }
         }

         if((var2 = var5 - var11 - var10) != 0) {
            var15 = ScreenDrawer.method_391(var6);

            for(var3 = 1; var3 <= var2; ++var3) {
               ScreenDrawer.method_369(var7, 0, var11 + var3, var4, var5 - var11);
               ScreenDrawer.method_370(var7, var15, 0, var3, 0);
            }
         }

         if((var2 = var11 - var9) != 0) {
            var15 = ScreenDrawer.method_391(var6);

            for(var3 = 1; var3 <= var2; ++var3) {
               ScreenDrawer.method_369(var7, 0, var11 - var3 - var9, var4, var9);
               ScreenDrawer.method_370(var7, var15, 0, -var3, 0);
            }
         }

         return ScreenDrawer.method_392(var6, 16777215);
      } catch (Exception var14) {
         var14.printStackTrace();
         return null;
      }
   }

   // $FF: renamed from: b (javax.microedition.lcdui.Graphics, int, int, int) void
   private void method_589(Graphics var1, int var2, int var3, int var4) {
      if(!ScreenDrawer.self.method_380()) {
         int var5 = ScreenDrawer.method_377(field_519) / 5;
         int var6 = ScreenDrawer.method_378(field_519);
         int var7 = ScreenDrawer.method_377(field_521) / 5;
         int var8 = ScreenDrawer.method_378(field_521);
         ScreenDrawer.method_374(var1, field_519, this.field_533 * var5, 0, var5, var6, 0, var2, var3, 0);
         ScreenDrawer.method_375(var1, field_520, 5, this.field_533, var2 + var5, var3, var2 + var4 - var5, true, 0);
         var2 += var4 - var5;
         ScreenDrawer.method_374(var1, field_521, this.field_533 * var7, 0, var7, var8, 0, var2, var3, 0);
      } else {
         if(field_526 == null || this.field_533 != 0) {
            field_526 = this.method_588(true);
         }

         ScreenDrawer.method_370(var1, field_526, var2, var3, 0);
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, byte) void
   public static final void method_590(Graphics var0, byte var1) {
      if(var0 != null) {
         PopupMenu var10000 = new PopupMenu(var1);
         var10000.method_586(var0, Screen.field_26, MessagesContainer.getMessage(42), MessagesContainer.getMessage(43));
      }
   }

   // $FF: renamed from: b (javax.microedition.lcdui.Graphics, byte) void
   public static final void method_591(Graphics var0, byte var1) {
      if(var0 != null) {
         PopupMenu var10000 = new PopupMenu(var1);
         var10000.method_586(var0, Screen.field_26, MessagesContainer.getMessage(146), (String)null);
      }
   }

   // $FF: renamed from: a (java.util.Vector, byte, short) void
   private static void method_592(Vector var0, byte var1, short var2) {
      if(var1 != 52 && var1 != 51) {
         if(var0 != null) {
            Button var10001 = new Button(var1, var2);
            var0.addElement(var10001);
         }
      }
   }

   // $FF: renamed from: a (byte, mobak.b.b.a.v) void
   public final void method_593(byte var1, Button var2) {
      if(this.field_530 == null) {
         this.field_530 = new Vector[1];
         this.field_530[0] = new Vector();
      }

      if(this.field_530[0] == null) {
         this.field_530[0] = new Vector();
      }

      this.field_530[0].addElement(var2);
   }

   // $FF: renamed from: a (boolean, mobak.b.b.a.v) void
   public final void method_594(boolean var1, Button var2) {
      if(var1) {
         if(!this.field_528.contains(var2)) {
            this.field_528.addElement(var2);
            return;
         }
      } else if(!this.field_529.contains(var2)) {
         this.field_529.addElement(var2);
      }

   }

   // $FF: renamed from: a (boolean, byte, short) void
   public final void method_595(boolean var1, byte var2, short var3) {
      if(var1) {
         method_592(this.field_528, var2, var3);
      } else {
         method_592(this.field_529, var2, var3);
      }
   }

   // $FF: renamed from: b (java.util.Vector, byte, short) void
   private static void method_596(Vector var0, byte var1, short var2) {
      if(var0 != null) {
         for(int var3 = 0; var3 < var0.size(); ++var3) {
            Button var4;
            if((byte)(var4 = (Button)var0.elementAt(var3)).field_543 == var1) {
               var4.method_656(var2);
            }
         }

      }
   }

   // $FF: renamed from: a (short, byte) void
   public final void method_597(short var1, byte var2) {
      method_596(this.field_528, var2, var1);
      method_596(this.field_529, var2, var1);
   }

   // $FF: renamed from: a (java.util.Vector, int, boolean, boolean, boolean) void
   private void method_598(Vector var1, int var2, boolean var3, boolean var4, boolean var5) {
      if(var1 != null) {
         boolean var6 = false;

         for(int i = 0; i < var1.size(); ++i) {
            Button button;
            if((byte)(button = (Button)var1.elementAt(i)).field_543 == (byte)var2) {
               if(Button.method_640(button.field_543) != Button.method_640(var2) && var5) {
                  button.method_656(Button.method_640(var2));
               }

               var6 = true;
               button.method_648(!var3);
            }
         }

         if(!var6 && var4) {
            if((byte)var2 != 52 && (byte)var2 != 51 && var1 != null) {
               Button button = new Button(var2);
               var1.addElement(button);
            }

            if(var3) {
               ((Button)var1.elementAt(var1.size() - 1)).method_648(false);
            }
         }

      }
   }

   // $FF: renamed from: a (byte, boolean, boolean) void
   public final void method_599(byte var1, boolean var2, boolean var3) {
      int var4 = Button.method_643(method_578((byte)100), (byte)100);
      this.method_598(this.field_529, var4, var2, false, false);
   }

   // $FF: renamed from: a (byte, boolean) void
   public final void method_600(byte var1, boolean var2) {
      int var3 = Button.method_643(method_578(var1), var1);
      this.method_598(this.field_528, var3, var2, true, false);
      this.method_598(this.field_529, var3, var2, false, false);
   }

   // $FF: renamed from: a (java.util.Vector) int
   private static int method_601(Vector var0) {
      if(var0 == null) {
         return 0;
      } else {
         int var1 = 0;

         for(int var2 = 0; var2 < var0.size(); ++var2) {
            if(((Button)var0.elementAt(var2)).method_647()) {
               ++var1;
            }
         }

         return var1;
      }
   }

   // $FF: renamed from: a (int, java.util.Vector, int) int
   private static int method_602(int var0, Vector var1, int var2) {
      if(var1 == null) {
         return -1;
      } else if(var1.size() <= var0) {
         return -1;
      } else {
         int var3 = 0;

         for(var0 = var0; var0 < var1.size(); ++var0) {
            if(((Button)var1.elementAt(var0)).method_647()) {
               if(var3 == var2) {
                  return var0;
               }

               ++var3;
            }
         }

         return -1;
      }
   }

   // $FF: renamed from: b (int, java.util.Vector, int) int
   private static int method_603(int var0, Vector var1, int var2) {
      if(var1 == null) {
         return -1;
      } else if(var1.size() <= 0) {
         return -1;
      } else {
         for(var0 = 0; var0 < var1.size(); ++var0) {
            Button var3;
            if((var3 = (Button)var1.elementAt(var0)).method_647() && var3.method_649()) {
               return var0;
            }
         }

         return -1;
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_604(Graphics var1) {
      if(var1 != null) {
         try {
            ScreenDrawer.self.method_355(var1);
            String var2 = null;
            int var3;
            if((var3 = method_601(this.field_528)) > 0) {
               if(var3 > 1) {
                  if(this.method_612()) {
                     var2 = MessagesContainer.getMessage(146);
                  } else {
                     var2 = MessagesContainer.getMessage(72);
                  }
               } else {
                  var2 = ((Button)this.field_528.elementAt(method_602(0, this.field_528, 0))).method_653();
               }
            }

            String var4 = null;
            if((var3 = method_601(this.field_529)) > 0) {
               if(var3 > 1) {
                  if(this.method_613()) {
                     var4 = MessagesContainer.getMessage(146);
                  } else {
                     var4 = MessagesContainer.getMessage(73);
                  }
               } else {
                  var4 = ((Button)this.field_529.elementAt(method_602(0, this.field_529, 0))).method_653();
               }
            }

            this.method_586(var1, Screen.field_26, var2, var4);
            if(this.field_531 != 0) {
               boolean var13 = this.field_531 < 0;
               Graphics var14 = var1;
               PopupMenu var12 = this;
               if(var1 != null) {
                  int var15 = method_584();
                  int var5 = ScreenDrawer.self.getWidth() / 2;
                  Vector var6 = this.field_529;
                  if(var13) {
                     var5 = ScreenDrawer.self.getWidth() / 2 - method_584();
                     var6 = this.field_528;
                     if(var5 < 0) {
                        var5 = 0;
                     }
                  } else if(var5 + method_584() > ScreenDrawer.self.getWidth()) {
                     var5 = ScreenDrawer.self.getWidth() - method_584();
                  }

                  if(var6 == null) {
                     this.field_531 = 0;
                     return;
                  }

                  int var7 = ScreenDrawer.self.getHeight() - method_585() - method_585();

                  for(int var8 = method_602(0, var6, 0); var8 >= 0; var8 = method_602(var8, var6, 0)) {
                     Button var9 = (Button)var6.elementAt(var8);
                     if(Math.abs(var12.field_531) - 1 == var8) {
                        var12.method_589(var14, var5, var7, var15);
                     } else {
                        var12.method_587(var14, var5, var7, var15);
                     }

                     (method_606(var9)? Screen.field_26: Screen.field_31).method_564(var14, var9.method_653(), var5 + var15 / 2, var7 + method_585() / 2, 3);
                     var7 -= method_585();
                     ++var8;
                  }

                  Button var17 = null;
                  if(Math.abs(var12.field_531) > 0) {
                     var17 = (Button)var6.elementAt(Math.abs(var12.field_531) - 1);
                  }

                  if(var17 != null) {
                     int var16 = var17.field_543;
                     byte var18;
                     if((byte)var17.field_543 == 49 && (var13 || var12.field_530 != null) && (var18 = var12.method_605((byte)Math.abs(var12.field_531))) >= 0 && (var6 = var12.field_530[var18]) != null && var6.size() > 0) {
                        if(var13) {
                           var5 += var15;
                        } else {
                           var5 -= var15;
                        }

                        var7 = ScreenDrawer.self.getHeight() - method_585() - method_585();

                        for(byte var10 = 0; var10 < var6.size(); ++var10) {
                           if(var10 == var12.field_532) {
                              var12.method_589(var14, var5, var7, var15);
                           } else {
                              var12.method_587(var14, var5, var7, var15);
                           }

                           (method_606(var17 = (Button)var6.elementAt(var10))? Screen.field_26: Screen.field_31).method_564(var14, var17.method_653(), var5 + var15 / 2, var7 + method_585() / 2, 3);
                           var7 -= method_585();
                        }
                     }
                  }
               }
            }

         } catch (Exception var11) {
            SocketListener.logMessage("PopupMenu " + var11.getMessage());
         }
      }
   }

   // $FF: renamed from: a (byte) byte
   private byte method_605(byte var1) {
      if(var1 < 0) {
         return (byte)-1;
      } else if(this.field_529 == null) {
         return (byte)-1;
      } else {
         byte var2 = -1;

         for(byte var3 = 0; var3 < var1; ++var3) {
            if((byte)((Button)this.field_529.elementAt(var3)).field_543 == 49) {
               ++var2;
            }
         }

         return var2;
      }
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   private static boolean method_606(Button var0) {
      return var0.method_649();
   }

   // $FF: renamed from: a (int) void
   public final void method_607(int var1) {
      Vector var3;
      byte var4;
      boolean var5;
      byte var6;
      Button var7;
      byte var10001;
      byte var10003;
      if(var1 == 1 && this.method_611() && this.field_531 != 0) {
         var3 = this.field_531 < 0?this.field_528:this.field_529;
         if(this.field_532 < 0) {
            var4 = this.field_531;
            if(this.field_531 < 0) {
               var4 = (byte)Math.abs(this.field_531);
            }

            --var4;
            var5 = false;

            for(var6 = 1; var4 + var6 < var3.size(); ++var6) {
               if(method_606(var7 = (Button)var3.elementAt(var4 + var6)) && var7.method_647()) {
                  var5 = true;
                  break;
               }
            }

            if(var5) {
               if(this.field_531 < 0) {
                  this.field_531 -= var6;
               } else {
                  this.field_531 += var6;
               }
            }
         } else {
            var10001 = this.field_531;
            var10001 = (byte)(this.field_532 + 1);
            var10003 = this.field_531;
            if((var4 = this.method_623(var10001, this.method_605((byte)Math.abs(this.field_531)))) != -1) {
               this.field_532 = var4;
            }
         }
      }

      if(var1 == 6 && this.method_611() && this.field_531 != 0) {
         var3 = this.field_531 < 0?this.field_528:this.field_529;
         if(this.field_532 < 0) {
            var4 = this.field_531;
            if(this.field_531 < 0) {
               var4 = (byte)Math.abs(this.field_531);
            }

            --var4;
            var5 = false;

            for(var6 = 1; var4 - var6 >= 0; ++var6) {
               if(method_606(var7 = (Button)var3.elementAt(var4 - var6)) && var7.method_647()) {
                  var5 = true;
                  break;
               }
            }

            if(var5) {
               if(this.field_531 < 0) {
                  this.field_531 += var6;
               } else {
                  this.field_531 -= var6;
               }
            }
         } else {
            byte var10000;
            label118: {
               var10001 = this.field_531;
               var10001 = (byte)(this.field_532 - 1);
               var10003 = this.field_531;
               byte var8 = this.method_605((byte)Math.abs(this.field_531));
               var4 = var10001;
               if(this.field_530 != null && (var3 = this.field_530[var8]) != null) {
                  for(var4 = var4; var4 >= 0; --var4) {
                     if(method_606(method_608(var3, var4))) {
                        var10000 = var4;
                        break label118;
                     }
                  }
               }

               var10000 = -1;
            }

            var4 = var10000;
            if(var10000 != -1) {
               this.field_532 = var4;
            }

            var10001 = this.field_531;
            if(this.method_605((byte)Math.abs(this.field_531)) < 0) {
               ;
            }
         }
      }

      if((var1 == 5 || var1 == 2) && this.method_611()) {
         if(this.field_532 < 0) {
            if(this.field_531 > 0 && var1 == 2 || this.field_531 < 0 && var1 == 5) {
               byte var10002 = this.field_531;
               byte var10004 = this.field_531;
               this.field_532 = this.method_623((byte)0, this.method_605((byte)Math.abs(this.field_531)));
               return;
            }
         } else {
            this.field_532 = -1;
         }
      }

   }

   // $FF: renamed from: a (java.util.Vector, int) mobak.b.b.a.v
   private static Button method_608(Vector var0, int var1) {
      return (Button)var0.elementAt(var1);
   }

   // $FF: renamed from: a () mobak.b.b.a.v
   public final Button method_609() {
      return this.method_612()?this.method_610(false, true, false):(this.method_613()?this.method_610(true, false, false):null);
   }

   // $FF: renamed from: a (boolean, boolean, boolean) mobak.b.b.a.v
   public final Button method_610(boolean var1, boolean var2, boolean var3) {
      if(var1 && method_601(this.field_529) == 1 && this.field_531 == 0) {
         return method_608(this.field_529, method_602(0, this.field_529, 0));
      } else if(var1) {
         this.field_532 = -1;
         if(this.field_531 > 0) {
            this.field_531 = 0;
         } else {
            this.field_531 = (byte)(method_603(0, this.field_529, 0) + 1);
         }

         return null;
      } else if((var2 || var3) && method_601(this.field_528) == 1 && this.field_531 == 0) {
         return method_608(this.field_528, method_602(0, this.field_528, 0));
      } else if(!var2 && (!var3 || this.method_611())) {
         if(this.field_532 < 0 && this.field_531 != 0 && var3) {
            Button var5;
            if(this.field_531 < 0) {
               var5 = method_608(this.field_528, Math.abs(this.field_531) - 1);
            } else {
               var5 = method_608(this.field_529, Math.abs(this.field_531) - 1);
            }

            int var7 = var5.field_543;
            if((byte)var5.field_543 != 49) {
               this.field_531 = 0;
            }

            return var5;
         } else if(this.field_532 >= 0 && this.field_531 != 0 && var3) {
            byte var10001 = this.field_531;
            byte var4 = this.method_605((byte)Math.abs(this.field_531));
            byte var6 = this.field_532;
            this.field_532 = -1;
            this.field_531 = 0;
            return method_608(this.field_530[var4], var6);
         } else {
            return null;
         }
      } else {
         this.field_532 = -1;
         if(this.field_531 < 0) {
            this.field_531 = 0;
         } else {
            this.field_531 = (byte)(-method_603(0, this.field_528, 0) - 1);
         }

         return null;
      }
   }

   // $FF: renamed from: a () boolean
   public final boolean method_611() {
      return this.field_531 != 0;
   }

   // $FF: renamed from: b () boolean
   public final boolean method_612() {
      return this.field_531 < 0;
   }

   // $FF: renamed from: c () boolean
   public final boolean method_613() {
      return this.field_531 > 0;
   }

   // $FF: renamed from: a (java.util.Vector, byte, boolean) void
   private void method_614(Vector var1, byte var2, boolean var3) {
      if(var1 != null) {
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            Button var5;
            if((byte)(var5 = method_608(var1, var4)).field_543 == var2) {
               var5.method_650(var3);
            }
         }

      }
   }

   // $FF: renamed from: b (byte) void
   public final void method_615(byte var1) {
      this.method_614(this.field_528, var1, false);
      this.method_614(this.field_529, var1, false);
   }

   // $FF: renamed from: c (byte) void
   public final void method_616(byte var1) {
      this.method_614(this.field_528, var1, true);
      this.method_614(this.field_529, var1, true);
   }

   // $FF: renamed from: a (boolean, boolean) void
   public final void method_617(boolean var1, boolean var2) {
      if(this.field_528 != null) {
         for(int var4 = 0; var4 < this.field_528.size(); ++var4) {
            method_608(this.field_528, var4).method_648(var2);
         }

      }
   }

   // $FF: renamed from: a (java.util.Vector, byte) void
   private void method_618(Vector var1, byte var2) {
      if(var1 != null) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            Button var4;
            if((byte)(var4 = method_608(var1, var3)).field_543 == var2) {
               var4.method_656(method_578(var2));
            }
         }

      }
   }

   // $FF: renamed from: d (byte) void
   public final void method_619(byte var1) {
      this.method_618(this.field_528, (byte)var1);
      this.method_618(this.field_529, (byte)var1);
   }

   // $FF: renamed from: a (byte[], boolean) void
   public final void method_620(byte[] var1, boolean var2) {
      this.method_621(var1, false, true, false);
   }

   // $FF: renamed from: a (byte[], boolean, boolean, boolean) void
   public final void method_621(byte[] var1, boolean var2, boolean var3, boolean var4) {
      if(var1 != null && var1.length != 0) {
         for(byte var5 = 0; var5 < var1.length; ++var5) {
            this.method_598(this.field_528, Button.method_643(method_578(var1[var5]), var1[var5]), var2, true, false);
            if(var4) {
               this.method_598(this.field_529, Button.method_643(method_578(var1[var5]), var1[var5]), var2, true, false);
            }
         }

      }
   }

   // $FF: renamed from: a (int[], boolean) void
   public final void method_622(int[] var1, boolean var2) {
      if(var1 != null && var1.length != 0) {
         for(byte i = 0; i < var1.length; ++i) {
            this.method_598(this.field_528, var1[i], var2, true, true);
         }

      }
   }

   // $FF: renamed from: a (byte, byte) byte
   private byte method_623(byte var1, byte var2) {
      if(this.field_530 == null) {
         return (byte)-1;
      } else {
         Vector var4;
         if((var4 = this.field_530[var2]) == null) {
            return (byte)-1;
         } else {
            for(var1 = var1; var1 < var4.size(); ++var1) {
               if(method_606(method_608(var4, var1))) {
                  return var1;
               }
            }

            return (byte)-1;
         }
      }
   }

   // $FF: renamed from: a (int, int) boolean
   public static final boolean method_624(int var0, int var1) {
      return var1 >= ScreenDrawer.self.getHeight() - method_585() && var0 >= (ScreenDrawer.self.getWidth() - (method_584() << 1)) / 2 && var0 <= ScreenDrawer.self.getWidth() / 2;
   }

   // $FF: renamed from: b (int, int) boolean
   public static final boolean method_625(int var0, int var1) {
      return var1 >= ScreenDrawer.self.getHeight() - method_585() && var0 >= ScreenDrawer.self.getWidth() / 2 && var0 < (ScreenDrawer.self.getWidth() + (method_584() << 1)) / 2;
   }

   // $FF: renamed from: c (int, int) boolean
   public final boolean method_626(int var1, int var2) {
      boolean var3 = (var1 >= (ScreenDrawer.self.getWidth() - (method_584() << 1)) / 2 && var1 <= ScreenDrawer.self.getWidth() / 2) & (var2 <= ScreenDrawer.self.getHeight() - method_585() && var2 >= ScreenDrawer.self.getHeight() - method_585() - method_601(this.field_528) * method_585()) & this.method_612();
      boolean var4 = (var1 >= ScreenDrawer.self.getWidth() / 2 && var1 <= (ScreenDrawer.self.getWidth() + (method_584() << 1)) / 2) & (var2 <= ScreenDrawer.self.getHeight() - method_585() && var2 >= ScreenDrawer.self.getHeight() - method_585() - method_601(this.field_529) * method_585()) & this.method_613();
      int var5 = (ScreenDrawer.self.getHeight() - method_585() - var2) / method_585();
      boolean var6 = false;
      Button var7 = null;
      if(this.method_613() && this.field_529 != null && this.field_529.size() >= this.field_531 && this.field_529.elementAt(this.field_531 - 1) != null) {
         var7 = (Button)this.field_529.elementAt(this.field_531 - 1);
      }

      if(var7 != null && (byte)var7.field_543 == 49) {
         var6 = true;
      }

      Vector var10 = null;
      if(var6) {
         var10 = this.field_530[0];
         var6 = var6 & var1 <= ScreenDrawer.self.getWidth() / 2 & var1 >= (ScreenDrawer.self.getWidth() - (method_584() << 1)) / 2 & var2 <= ScreenDrawer.self.getHeight() - method_585() & var2 >= ScreenDrawer.self.getHeight() - method_585() - method_585() * var10.size();
      }

      if(var3 || var4 || var6) {
         if(var6) {
            if(var10 != null && var5 >= 0 && var5 < var10.size()) {
               this.field_532 = (byte)var5;
            }

            return true;
         }

         byte var8;
         Button var9;
         if(this.method_612()) {
            var8 = (byte)(-method_602(0, this.field_528, var5) - 1);
            if((var9 = this.method_627(var8)) != null && var9.method_649()) {
               this.field_531 = var8;
               return true;
            }

            return false;
         }

         if(this.method_613()) {
            var8 = (byte)(method_602(0, this.field_529, var5) + 1);
            if((var9 = this.method_627(var8)) != null && var9.method_649()) {
               this.field_531 = var8;
               return true;
            }

            return false;
         }
      }

      return false;
   }

   // $FF: renamed from: a (int) mobak.b.b.a.v
   private Button method_627(int var1) {
      return var1 < 0?(Button)this.field_528.elementAt(Math.abs(var1) - 1):(var1 > 0?(Button)this.field_529.elementAt(Math.abs(var1) - 1):null);
   }

   // $FF: renamed from: a () void
   public final void method_628() {
      if(this.field_528 != null) {
         this.field_528.removeAllElements();
      }

      if(this.field_529 != null) {
         this.field_529.removeAllElements();
      }

      this.field_531 = 0;
   }

   // $FF: renamed from: a (int) boolean
   public static boolean method_629(int var0) {
      if(var0 == field_512) {
         return true;
      } else {
         if(field_512 == field_514[0]) {
            for(int var1 = 1; var1 < field_514.length; ++var1) {
               if(var0 == field_514[var1]) {
                  return true;
               }
            }
         }

         return var0 == 42;
      }
   }

   // $FF: renamed from: b (int) boolean
   public static final boolean method_630(int var0) {
      if(var0 == field_513) {
         return true;
      } else {
         if(field_513 == field_515[0]) {
            for(int var1 = 0; var1 < field_515.length; ++var1) {
               if(var0 == field_515[var1]) {
                  return true;
               }
            }
         }

         return var0 == 35;
      }
   }

   // $FF: renamed from: b (int) void
   public static void method_631(int var0) {
      field_512 = var0;
   }

   // $FF: renamed from: c (int) void
   public static void method_632(int var0) {
      field_513 = var0;
   }

   // $FF: renamed from: b () void
   public static void method_633() {
      Main2.self.rmsManager.setInt((byte)11, field_512);
      Main2.self.rmsManager.setInt((byte)12, field_513);
   }

   // $FF: renamed from: c () void
   public static void method_634() {
      field_512 = Main2.self.rmsManager.getInt((byte)11, field_512);
      field_513 = Main2.self.rmsManager.getInt((byte)12, field_513);
   }

   // $FF: renamed from: a (short) byte
   public static byte method_635(short var0) {
      byte var1 = (byte)(127 - field_534.size());
      field_534.put(new Byte(var1), new Short(var0));
      return var1;
   }

   // $FF: renamed from: b (byte) short
   public static short method_636(byte var0) {
      Short var1;
      return (var1 = (Short)field_534.get(new Byte(var0))) != null?var1.shortValue():-1;
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_512 = -6;
      field_513 = -7;
      field_514 = new int[]{-6, 21, -202, '\ue001'};
      field_515 = new int[]{-7, 22, -203, '\ue002'};
      field_516 = -1;
      field_517 = -1;
      field_518 = -1;
      field_519 = -1;
      field_520 = -1;
      field_521 = -1;
      field_522 = -1;
      field_523 = -1;
      field_524 = null;
      field_525 = 0;
      field_526 = null;
      field_527 = 0;
      field_516 = GlobalStorage.method_711("popup_menu_item_left_x.png");
      field_517 = GlobalStorage.method_711("popup_menu_item_center_x.png");
      field_518 = GlobalStorage.method_711("popup_menu_item_right_x.png");
      field_519 = GlobalStorage.method_711("popup_menu_selected_item_left_x.png");
      field_520 = GlobalStorage.method_711("popup_menu_selected_item_center_x.png");
      field_521 = GlobalStorage.method_711("popup_menu_selected_item_right_x.png");
      field_522 = GlobalStorage.method_711("popup_menu_item.png");
      field_523 = GlobalStorage.method_711("popup_menu_selected_item.png");
      field_534 = new Hashtable();
   }
}
