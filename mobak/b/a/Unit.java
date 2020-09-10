package mobak.b.a;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.GlobalStorage;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_55;
import mobak.b.b.a.MenuScreen;
import mobak.c.MessagesContainer;
import mobak.c.RMSManager;

// $FF: renamed from: mobak.b.a.f
public final class Unit extends Thing {

   // $FF: renamed from: a short
   private static short field_607;
   // $FF: renamed from: b short
   private static short field_608;
   // $FF: renamed from: c short
   private static short field_609;
   // $FF: renamed from: d short
   private static short field_610;
   // $FF: renamed from: b byte
   private static byte field_611;
   // $FF: renamed from: e short
   private static short field_612;
   // $FF: renamed from: c byte
   private static byte field_613;
   // $FF: renamed from: d byte
   private static byte field_614;
   // $FF: renamed from: e byte
   private static byte field_615;
   // $FF: renamed from: f byte
   private byte field_616;
   // $FF: renamed from: f short
   private short field_617;
   // $FF: renamed from: g byte
   private byte field_618;
   // $FF: renamed from: h byte
   private byte field_619;
   // $FF: renamed from: i byte
   private byte field_620;
   // $FF: renamed from: j byte
   private byte field_621;
   // $FF: renamed from: g short
   private short field_622;
   // $FF: renamed from: h short
   private short field_623;
   // $FF: renamed from: i short
   private short field_624;
   // $FF: renamed from: j short
   private short field_625;
   // $FF: renamed from: k short
   private short field_626;
   // $FF: renamed from: l short
   private short field_627;
   // $FF: renamed from: m short
   private short field_628;
   // $FF: renamed from: n short
   private short field_629;
   // $FF: renamed from: b boolean
   private boolean field_630;
   // $FF: renamed from: k byte
   private byte field_631;
   // $FF: renamed from: o short
   private short field_632;
   // $FF: renamed from: d java.lang.String
   private String field_633;
   // $FF: renamed from: l byte
   private byte field_634;
   // $FF: renamed from: c boolean
   private boolean field_635;
   // $FF: renamed from: m byte
   private byte field_636;
   // $FF: renamed from: n byte
   private byte field_637;
   // $FF: renamed from: o byte
   private byte field_638;
   // $FF: renamed from: a java.util.Vector
   private Vector field_639;
   // $FF: renamed from: p byte
   private byte field_640;
   // $FF: renamed from: p short
   private short field_641;
   // $FF: renamed from: q short
   private short field_642;
   // $FF: renamed from: f int
   private int field_643;
   // $FF: renamed from: g int
   private int field_644;


   // $FF: renamed from: b (byte) java.lang.String
   private static String method_795(byte var0) {
      return var0 == 1?"\f7":(var0 == 2?"\f2":"\f1");
   }

   // $FF: renamed from: a (byte) javax.microedition.lcdui.Image
   public static Image method_796(byte var0) {
      if(var0 <= 3) {
         if(field_607 == -1) {
            field_607 = GlobalStorage.method_711("unites1.png");
         }

         return GlobalStorage.getImage(field_607);
      } else {
         if(field_608 == -1) {
            field_608 = GlobalStorage.method_711("unites2.png");
         }

         return GlobalStorage.getImage(field_608);
      }
   }

   // $FF: renamed from: <init> () void
   public Unit() {
      super();
      this.field_622 = 0;
      this.field_623 = 0;
      this.field_624 = 0;
      this.field_625 = 0;
      this.field_626 = 0;
      this.field_627 = 0;
      this.field_628 = 0;
      this.field_631 = -1;
      this.field_633 = "0";
      this.field_635 = false;
      this.field_643 = 0;
   }

   // $FF: renamed from: e () byte
   public final byte method_797() {
      return this.field_620;
   }

   // $FF: renamed from: f () byte
   public final byte method_798() {
      return this.field_621;
   }

   // $FF: renamed from: g () byte
   public final byte method_799() {
      return this.field_619;
   }

   // $FF: renamed from: h () byte
   public final byte method_800() {
      return this.field_618;
   }

   // $FF: renamed from: b () short
   public final short method_801() {
      return this.field_626;
   }

   // $FF: renamed from: c () short
   public final short getUnitPlace() {
      return (byte)super.place;
   }

   // $FF: renamed from: c () boolean
   public final boolean method_803() {
      return (this.field_624 != 0 || this.field_625 != 0) && this.field_626 > 0;
   }

   // $FF: renamed from: c (boolean) void
   public final void method_804(boolean var1) {
      this.field_630 = var1;
   }

   // $FF: renamed from: a (byte, byte) void
   public final void method_805(byte var1, byte var2) {
      this.field_638 = var1;
      this.field_618 = var2;
   }

   // $FF: renamed from: b (byte) void
   public final void method_806(byte var1) {
      this.field_616 = var1;
   }

   // $FF: renamed from: d (boolean) void
   public final void method_807(boolean var1) {}

   // $FF: renamed from: c (byte) void
   public final void method_808(byte var1) {
      this.field_621 = var1;
   }

   // $FF: renamed from: d (byte) void
   public final void method_809(byte var1) {
      this.field_620 = var1;
   }

   // $FF: renamed from: e (byte) void
   public final void method_810(byte var1) {
      this.field_636 = var1;
   }

   // $FF: renamed from: a (short) void
   public final void method_811(short var1) {
      this.field_622 = var1;
   }

   // $FF: renamed from: b (short) void
   public final void method_812(short var1) {
      this.field_623 = var1;
   }

   // $FF: renamed from: c (short) void
   public final void method_813(short var1) {
      this.field_624 = var1;
   }

   // $FF: renamed from: d (short) void
   public final void method_814(short var1) {
      this.field_625 = var1;
   }

   // $FF: renamed from: f (byte) void
   public final void method_815(byte var1) {
      this.field_637 = var1;
   }

   // $FF: renamed from: e (short) void
   public final void method_816(short var1) {
      this.field_627 = var1;
   }

   // $FF: renamed from: f (short) void
   public final void method_817(short var1) {
      this.field_628 = var1;
   }

   // $FF: renamed from: g (short) void
   public final void method_818(short var1) {
      this.field_617 = var1;
   }

   // $FF: renamed from: h (short) void
   public final void method_819(short var1) {
      this.field_629 = var1;
   }

   // $FF: renamed from: g (byte) void
   public final void method_820(byte var1) {
      this.field_619 = var1;
   }

   // $FF: renamed from: h (byte) void
   public final void method_821(byte var1) {}

   // $FF: renamed from: i (byte) void
   public final void method_822(byte var1) {
      super.place = var1;
   }

   // $FF: renamed from: e (boolean) void
   public final void method_823(boolean var1) {
      this.field_635 = var1;
   }

   // $FF: renamed from: i (short) void
   public final void method_824(short var1) {
      this.field_626 = var1;
   }

   // $FF: renamed from: j (short) void
   public final void method_825(short var1) {}

   // $FF: renamed from: f (int) void
   public final void method_826(int var1) {
      this.field_632 = RMSManager.method_679(this.getQuantity() - var1);
      this.field_633 = String.valueOf(this.field_632);
   }

   // $FF: renamed from: j (byte) void
   public final void method_827(byte var1) {
      this.field_631 = var1;
   }

   // $FF: renamed from: i () byte
   public final byte method_828() {
      return this.field_631;
   }

   // $FF: renamed from: a (mobak.b.b.q, java.lang.String, short) void
   public final void getDescription(class_55 var1, String var2, short var3) {
      if(var1 != null) {
         var1.method_495();
         StringBuffer info = new StringBuffer();
         info.append(super.name);
         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         info.append(MessagesContainer.getMessage(18)).append(": ").append(MessagesContainer.method_574(this.getRaceId()));
         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         var1.field_429 += Screen.field_26.field_500 / 2;
         if(var2 != null && !var2.equals("")) {
            info.append(var2).append("\n");
            var1.method_490(info.toString(), Screen.field_26, false, -1);
            info.delete(0, info.length());
         }

         var1.field_429 += Screen.field_26.field_500 / 2;
         if(!this.GetLocation().equals("") && (short)(var3 & 4096) == 4096) {
            info.append(MessagesContainer.getMessage(174)).append(": ").append(this.GetLocation());
            var1.method_490(info.toString(), Screen.field_26, false, -1);
            info.delete(0, info.length());
         }

         if((short)(var3 & 2048) == 2048) {
            info.append(MessagesContainer.getMessage(108)).append(": ").append(this.field_617).append(" ").append(MessagesContainer.getMessage(110)).append(" ").append(this.field_629);
         } else {
            info.append(MessagesContainer.getMessage(108)).append(": ").append(this.field_617);
         }

         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         info.append(MessagesContainer.getMessage(109)).append(": ");
         if(this.field_638 != 0) {
            info.append(method_795(this.field_638));
         }

         info.append(this.field_618);
         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         info.append(MessagesContainer.getMessage(111)).append(": ");
         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         if(this.field_619 > 0 && this.field_619 <= 3) {
            StringBuffer var5;
            (var5 = new StringBuffer()).append(this.field_619);
            info.append("  ").append(MessagesContainer.getMessage(112, new String[]{var5.toString()}));
         }

         if(this.field_619 == -1) {
            info.append("  ").append(MessagesContainer.getMessage(114));
         }

         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         info.append(MessagesContainer.getMessage(47)).append(": ");
         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         var2 = method_795(this.field_636);
         if(this.field_624 != 0 || this.field_625 != 0) {
            info.append("  - ").append(MessagesContainer.getMessage(115)).append(": ").append(var2).append(this.field_624).append(" - ").append(this.field_625);
            var1.method_490(info.toString(), Screen.field_26, false, -1);
            info.delete(0, info.length());
            info.append("     ").append(MessagesContainer.getMessage(163)).append(": ");
            info.append(this.field_626);
            var1.method_490(info.toString(), Screen.field_26, false, -1);
            info.delete(0, info.length());
         }

         info.append("  - ").append(MessagesContainer.getMessage(116)).append(": ").append(var2).append(this.field_622).append(" - ").append(this.field_623);
         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         info.append(MessagesContainer.getMessage(117)).append(": ");
         if(this.field_637 != 0) {
            info.append(method_795(this.field_637));
         }

         info.append(this.field_628).append(" - ").append(this.field_627);
         var1.method_490(info.toString(), Screen.field_26, false, -1);
         info.delete(0, info.length());
         if(this.field_639 != null && this.field_639.size() > 0) {
            info.append(MessagesContainer.getMessage(71)).append(": ");
            var1.method_490(info.toString(), Screen.field_26, false, -1);
            info.delete(0, info.length());

            for(var3 = 0; var3 < this.field_639.size(); ++var3) {
               if(this.field_639.elementAt(var3) != null && !(var2 = this.field_639.elementAt(var3).toString()).equals("")) {
                  info.append("   ").append(var2);
                  var1.method_490(info.toString(), Screen.field_26, false, -1);
                  info.delete(0, info.length());
               }
            }
         }

      }
   }

   // $FF: renamed from: c (java.lang.String) void
   public final void method_829(String var1) {
      if(this.field_639 == null) {
         this.field_639 = new Vector();
      }

      this.field_639.addElement(var1);
   }

   // $FF: renamed from: a (mobak.b.a.a) boolean
   public final boolean method_755(Thing var1) {
      Unit var2;
      return var1 == null?false:(!(var1 instanceof Unit)?false:(var2 = (Unit)var1).field_616 == this.field_616);
   }

   // $FF: renamed from: b () byte
   public final byte method_754() {
      return (byte)1;
   }

   // $FF: renamed from: g (int) void
   public final void method_830(int var1) {
      this.field_644 = 3;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, short) void
   public final void method_758(Graphics var1, short var2, short var3, short var4) {
      if(var1 != null) {
         if(this.field_644 > 0) {
            this.field_641 = (short)(this.field_641 + (var2 - this.field_641) / this.field_644);
            this.field_642 = (short)(this.field_642 + (var3 - this.field_642) / this.field_644);
         } else {
            this.field_641 = var2;
            this.field_642 = var3;
         }

         if((var4 & 32) == 32) {
            method_831(var1, this, var2, var3, var4);
            if((var4 & 64) == 64) {
               MenuScreen.method_138(var1, var2, var3, !super.isOnHero, super.isOnHero);
            }
         } else {
            method_831(var1, this, this.field_641, this.field_642, var4);
         }

         --this.field_644;
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, mobak.b.a.f, short, short, short) void
   private static void method_831(Graphics var0, Unit var1, short var2, short var3, short var4) {
      boolean var5 = (var4 & 128) == 128;
      int var10 = Screen.field_25.method_563(var1.field_580);
      short var11 = (short) ScreenDrawer.method_386(var0);
      short var12 = (short) ScreenDrawer.method_387(var0);
      short var13 = (short) ScreenDrawer.method_388(var0);
      short var14 = (short) ScreenDrawer.method_389(var0);
      int var6;
      byte var7;
      int var8;
      int var9;
      if(var5) {
         var7 = 0;
         var6 = 0;
         var8 = 51 - var10;
         var9 = 42 - Screen.field_25.field_500;
      } else {
         if((var4 & 1) == 1) {
            MenuScreen.method_131(var0, var2, var3, 1);
         } else if((var4 & 1024) == 1024) {
            MenuScreen.method_131(var0, var2, var3, 2);
         } else {
            MenuScreen.method_131(var0, var2, var3, 0);
         }

         var6 = 30 - GlobalStorage.method_718(var1.getRaceId(), var1.method_737());
         var7 = 6;
         var8 = 61 - var10;
         var9 = 53 - Screen.field_25.field_500;
         ScreenDrawer.method_369(var0, var2 + 1, var3, 58, 53 + Screen.field_32.field_500);
      }

      Image var15;
      if(!var1.field_635 && var1.isOnHero) {
         var15 = method_796(var1.getRaceId());
      } else {
         Image var10000;
         if(var1.getRaceId() <= 3) {
            if(field_609 == -1) {
               field_609 = GlobalStorage.method_711("enemy1.png");
            }

            var10000 = GlobalStorage.getImage(field_609);
         } else {
            if(field_610 == -1) {
               field_610 = GlobalStorage.method_711("enemy2.png");
            }

            var10000 = GlobalStorage.getImage(field_610);
         }

         var15 = var10000;
      }

      byte var16;
      if((var16 = var1.getRaceId()) > 3) {
         var16 = (byte)(var16 - 4);
      } else {
         --var16;
      }

      ScreenDrawer.method_372(var0, var15, 75 * var1.method_737(), var16 * 42, 75, 42, 0, var2 + var6, var3 + var7, 0);
      if((var4 & 4) == 4) {
         Thing.method_767(var0, var2, var3, var1.getRaceId());
      }

      if((var4 & 2) == 2) {
         if(var5) {
            ScreenDrawer.method_384(var0, 0);
            var0.fillRect(var2 + var8 - 2, var3 + var9, var10 + 2, Screen.field_25.field_500);
            Screen.field_25.method_564(var0, var1.field_580, var2 + var8 - 2, var3 + var9, 0);
            ScreenDrawer.method_384(var0, 12496896);
            var0.drawLine(var2 + var8 - 2, var3 + var9 - 1, var2 + var8 + var10 - 1, var3 + var9 - 1);
            var0.drawLine(var2 + var8 - 2, var3 + var9 + Screen.field_25.field_500 - 1, var2 + var8 + var10 - 1, var3 + var9 + Screen.field_25.field_500 - 1);
            var0.drawLine(var2 + var8 - 3, var3 + var9, var2 + var8 - 3, var3 + var9 + Screen.field_25.field_500 - 2);
            var0.drawLine(var2 + var8 + var10, var3 + var9, var2 + var8 + var10, var3 + var9 + Screen.field_25.field_500 - 2);
         } else {
            Thing.method_764(var0, var2, var3, var1.field_580);
         }
      }

      if((var4 & 16) == 16 && var1.field_577 > 0) {
         Thing.method_765(var0, var2, var3, var1.field_578);
      }

      if((var4 & 768) != 0 && !var5) {
         byte var17 = (byte)(((var4 & 768) >> 8) - 1);
         Thing.method_768(var0, var2, var3, var1.method_753(var17), false);
      }

      if(var5) {
         if(var1.field_630) {
            var4 = (short)(var2 + 8);
            short var18 = (short)(var3 - 3 + field_611);
            Screen.method_46(var0, (byte)6, var4, var18, 0);
            if(++field_611 > 7) {
               field_611 = 0;
            }
         }

         if(var1.field_631 >= 0) {
            if(field_612 == -1) {
               field_614 = (byte) ScreenDrawer.method_378(field_612 = GlobalStorage.method_711("fight-slides_a.png"));
               field_615 = (byte) ScreenDrawer.method_378(field_612);
               field_613 = (byte)(ScreenDrawer.method_377(field_612) / field_615);
            }

            if(var1.field_631 < field_613 && var1.field_631 >= 0) {
               ScreenDrawer.method_374(var0, field_612, field_615 * var1.field_631, 0, field_615, field_614, 0, var2, var3, 0);
            }

            byte var19 = (byte)(51 - Screen.field_25.method_563(var1.field_633));
            byte var20 = (byte)(42 - Screen.field_25.field_500);
            if(var1.field_632 > 0) {
               ScreenDrawer.method_384(var0, 16711680);
            } else if(var1.field_632 < 0) {
               ScreenDrawer.method_384(var0, '\uff00');
            } else {
               ScreenDrawer.method_384(var0, 12171520);
            }

            var0.fillRect(var2 + var19 - 1, var3 + var20 - var1.field_634, Screen.field_25.method_563(var1.field_633) + 2, Screen.field_25.field_500);
            Screen.field_25.method_564(var0, var1.field_633, var2 + var19, var3 + var20 - var1.field_634, 0);
            ++var1.field_634;
         }
      }

      if(!var5) {
         ScreenDrawer.method_369(var0, var11, var12, var13, var14);
      } else {
         if((var1.field_640 & 1) == 1) {
            Screen.method_46(var0, (byte)2, (short)(var2 + var6), (short)(var3 + var7 + 10), 0);
         }

         if((var1.field_640 & 2) == 2) {
            Screen.method_46(var0, (byte)9, (short)(var2 + var6 + 5), (short)(var3 + var7 + 10), 0);
         }

      }
   }

   // $FF: renamed from: h (int) void
   public final void method_832(int var1) {
      this.method_742(var1, true);
      this.field_632 = 0;
      this.field_633 = "0";
      this.field_634 = 0;
   }

   public final String toString() {
      StringBuffer var1;
      (var1 = new StringBuffer()).append("unitGroup[").append(this.field_616).append("\n");
      var1.append("quantity[").append(super.field_579).append("\n");
      var1.append("raceId").append(super.raceId).append("\n");
      return var1.toString();
   }

   // $FF: renamed from: k (byte) void
   public final void method_833(byte var1) {
      this.field_640 = var1;
   }

   // $FF: renamed from: a () void
   public final void method_834() {
      if(this.field_639 != null) {
         this.field_639.removeAllElements();
      }

   }

   // $FF: renamed from: a () short
   public final short method_756() {
      return this.field_629;
   }

   // $FF: renamed from: f () int
   public final int method_835() {
      return this.field_643;
   }

   // $FF: renamed from: i (int) void
   public final void method_836(int var1) {
      this.field_643 = var1;
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_607 = -1;
      field_608 = -1;
      field_609 = -1;
      field_610 = -1;
      field_611 = 0;
      field_612 = -1;
   }
}
