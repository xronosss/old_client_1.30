package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.b.a.Thing;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.text.class_1;
import mobak.text.class_62;
import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.t
public abstract class MenuScreen extends Screen implements class_1 {

   // $FF: renamed from: a long
   protected long field_85;
   // $FF: renamed from: e boolean
   protected boolean field_86;
   // $FF: renamed from: b short
   public static short field_87;
   // $FF: renamed from: k short
   private static short field_88;
   // $FF: renamed from: l short
   private static short field_89;
   // $FF: renamed from: m short
   private static short field_90;
   // $FF: renamed from: n short
   private static short field_91;
   // $FF: renamed from: c short
   protected static short field_92;
   // $FF: renamed from: d short
   protected static short field_93;
   // $FF: renamed from: e short
   protected static short field_94;
   // $FF: renamed from: f short
   protected static short field_95;
   // $FF: renamed from: o short
   private static short field_96;
   // $FF: renamed from: p short
   private static short field_97;
   // $FF: renamed from: g short
   protected static short field_98;
   // $FF: renamed from: h short
   protected static short field_99;
   // $FF: renamed from: q short
   private static short field_100;
   // $FF: renamed from: i short
   protected static short field_101;
   // $FF: renamed from: r short
   private static short field_102;
   // $FF: renamed from: j short
   protected static short field_103;
   // $FF: renamed from: s short
   private static short field_104;
   // $FF: renamed from: t short
   private static short field_105;
   // $FF: renamed from: u short
   private static short field_106;
   // $FF: renamed from: v short
   private static short field_107;
   // $FF: renamed from: w short
   private static short field_108;
   // $FF: renamed from: x short
   private static short field_109;
   // $FF: renamed from: y short
   private static short field_110;
   // $FF: renamed from: z short
   private static short field_111;
   // $FF: renamed from: A short
   private static short field_112;
   // $FF: renamed from: B short
   private static short field_113;
   // $FF: renamed from: C short
   private static short field_114;
   // $FF: renamed from: D short
   private static short field_115;
   // $FF: renamed from: b java.lang.String
   protected String name;
   // $FF: renamed from: c java.lang.String
   protected String field_117;
   // $FF: renamed from: f int
   protected int field_118;
   // $FF: renamed from: a java.lang.Short
   private Short field_119;
   // $FF: renamed from: f boolean
   protected boolean field_120;
   // $FF: renamed from: e int
   private int field_121;


   // $FF: renamed from: c (boolean) void
   public final void method_127(boolean var1) {
      this.field_120 = var1;
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public boolean method_38(Button button) {
      int var2 = button.field_543;
      switch((byte) button.field_543) {
      case 55:
         if(ScreenDrawer.self.method_351() && !SocketListener.self.method_533()) {
            ScreenDrawer.self.method_352(false);
         }

         ScreenDrawer.self.method_346();
         ScreenDrawer.self.GetScreen().helpViewInit();
         return true;
      default:
         return super.method_38(button);
      }
   }

   // $FF: renamed from: a (int, int) boolean
   protected boolean method_59(int var1, int var2) {
      return false;
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected boolean method_60(int var1, int var2, int var3) {
      return false;
   }

   // $FF: renamed from: a (int, int, int) boolean
   protected boolean method_61(int var1, int var2, int var3) {
      return false;
   }

   // $FF: renamed from: b (int, int) boolean
   protected boolean method_62(int var1, int var2) {
      return false;
   }

   // $FF: renamed from: a (int, int) int
   protected static int method_128(int var0, int var1) {
      if((var0 = (var0 - 300) / 1000 + 1) < 0) {
         var0 = 0;
      }

      return var0;
   }

   // $FF: renamed from: a (java.lang.String) void
   public void method_129(String var1) {}

   // $FF: renamed from: <init> () void
   protected MenuScreen() {
      super();
      this.field_117 = Screen.nameOfMap;
   }

   // $FF: renamed from: a () mobak.b.b.a.f
   public static MainMenuScreen initMainMenu() {
      try {
         if(field_87 == -1) {
            field_87 = GlobalStorage.method_711("icons-of-races.png");
         }

         if(field_92 == -1) {
            field_92 = GlobalStorage.method_711("arrow_top.png");
         }

         if(field_93 == -1) {
            field_93 = GlobalStorage.method_711("arrow_bottom.png");
         }

         if(field_94 == -1) {
            field_94 = GlobalStorage.method_711("arrow_left.png");
         }

         if(field_95 == -1) {
            field_95 = GlobalStorage.method_711("arrow_right.png");
         }

         if(field_96 == -1) {
            field_96 = GlobalStorage.method_711("red_indicator.png");
         }

         if(field_97 == -1) {
            field_97 = GlobalStorage.method_711("green_indicator.png");
         }

         if(field_98 == -1) {
            field_98 = GlobalStorage.method_711("equipment.png");
         }

         if(field_99 == -1) {
            field_99 = GlobalStorage.method_711("tiles.png");
         }

         if(field_103 == -1) {
            field_103 = GlobalStorage.method_711("equipment_selected.png");
         }

         if(field_89 == -1) {
            field_89 = GlobalStorage.method_711("itemCell.png");
         }

         if(field_90 == -1) {
            field_90 = GlobalStorage.method_711("itemCell1.png");
         }

         if(field_91 == -1) {
            field_91 = GlobalStorage.method_711("itemCell2.png");
         }

         if(field_88 == -1) {
            field_88 = GlobalStorage.method_711("separator.png");
         }

         field_104 = GlobalStorage.method_711("bottom_corner.png");
         field_105 = GlobalStorage.method_711("top_corner.png");
         field_106 = GlobalStorage.method_711("horizontal.png");
         field_107 = GlobalStorage.method_711("horizontal_mid.png");
         field_108 = GlobalStorage.method_711("vertical.png");
         field_109 = GlobalStorage.method_711("vertical_mid.png");
         field_110 = GlobalStorage.method_711("money_x.png");
         field_111 = GlobalStorage.method_711("crystals_x.png");
         field_112 = GlobalStorage.method_711("money_crystals_x.png");
         field_113 = GlobalStorage.method_711("middle_tile_x.png");
         field_114 = GlobalStorage.method_711("crystals.png");
         field_115 = GlobalStorage.method_711("money.png");
         field_100 = GlobalStorage.method_711("menu_item_left_x.png");
         field_101 = GlobalStorage.method_711("menu_item_center_x.png");
         field_102 = GlobalStorage.method_711("menu_item_right_x.png");
      } catch (Exception var1) {
         SocketListener.logMessage("initMainMenu" + var1.toString());
      }

      MainMenuScreen var10000 = new MainMenuScreen((short)-103);
      MainMenuScreen var0 = var10000;
      var10000.name = null;
      var0.field_128 = new String[][]{MainMenuScreen.method_151()};
      var0.field_129 = null;
      var0.field_131 = 0;
      var0.field_132 = 0;
      var0.mainMenuType = 1;
      return var0;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int) void
   public static final void method_131(Graphics var0, int var1, int var2, int var3) {
      int var4 = ScreenDrawer.method_382(GlobalStorage.getImage(field_89));
      int var5 = ScreenDrawer.method_383(GlobalStorage.getImage(field_89));
      short var6 = field_89;
      if(var3 == 1) {
         var6 = field_90;
      } else if(var3 == 2) {
         var6 = field_91;
      }

      ScreenDrawer.method_372(var0, GlobalStorage.getImage(var6), 0, 0, var4, var5, 0, var1, var2, 0);
   }

   // $FF: renamed from: b () mobak.b.b.a.f
   public static final MainMenuScreen method_132() {
      MainMenuScreen var10000 = new MainMenuScreen((short)-105);
      MainMenuScreen var0 = var10000;
      var10000.name = MessagesContainer.getMessage(38);
      PopupMenu var10001 = new PopupMenu((byte[])null, new byte[]{(byte)55}, (byte[][])null);
      var0.popupMenu = var10001;
      var0.mainMenuType = 5;
      return var0;
   }

   // $FF: renamed from: a (short) mobak.b.b.a.j
   public static View method_133(short var0) {
      Object var1 = null;
      switch(var0) {
      case -12:
      case -2:
      case -1:
         class_39 var2 = new class_39(var0);
         var1 = var2;
      case -11:
      case -10:
      case -9:
      case -8:
      case -7:
      case -6:
      case -5:
      default:
         break;
      case -4:
      case -3:
         class_40 var10000 = new class_40(var0);
         var1 = var10000;
      }

      return (View)var1;
   }

   // $FF: renamed from: a () mobak.b.b.a.j
   public static View method_134() {
      ViewHelp var10000 = new ViewHelp((short)-5);
      ViewHelp var0 = var10000;
      var10000.field_228 = 0;
      return var0;
   }

   // $FF: renamed from: a (java.lang.String) mobak.b.b.a.j
   public static View method_135(String var0) {
      ViewHelp var10000 = new ViewHelp((short)-7);
      ViewHelp var1 = var10000;
      var10000.method_274(var0);
      return var1;
   }

   // $FF: renamed from: a () short
   protected final short method_136() {
      if(this.field_119 == null) {
         if(ScreenDrawer.self.getHeight() > 220) {
            this.field_119 = new Short((short)(ScreenDrawer.method_378(field_115) - ScreenDrawer.method_378(field_105)));
         } else {
            int var1 = ScreenDrawer.method_378(field_105);
            int var2 = ScreenDrawer.method_378(field_115);
            int var3 = ScreenDrawer.method_378(field_112);
            var1 += (var2 - var3) / 2;
            this.field_119 = new Short((short)(var1 + var3 + 5));
         }
      }

      return this.field_119.shortValue();
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public void method_30(Graphics var1) {
      try {
         ScreenDrawer.method_369(var1, 0, 0, (short) ScreenDrawer.self.getWidth(), (short) ScreenDrawer.self.getHeight());
         if(field_99 == -1) {
            field_99 = GlobalStorage.method_711("tiles.png");
         }

         method_137(var1, field_99, super.raceId);
         int var2 = ScreenDrawer.self.getWidth() / 2;
         int var10000 = Screen.field_26.field_500;
         int var3 = Screen.field_26.field_500 * 3 / 2 + 12;
         if(this.method_58() != null) {
            Screen.field_29.method_564(var1, this.method_58(), var2, 14, 17);
         }

         if(this.name != null) {
            Screen.field_26.method_564(var1, this.name, var2, var3, 17);
         }

         Graphics var21 = var1;
         byte var22 = 0;
         int var4 = ScreenDrawer.self.getWidth();
         int var5 = ScreenDrawer.self.getHeight();
         int var6 = ScreenDrawer.method_377(field_107) / 2;
         int var7 = ScreenDrawer.method_378(field_107);
         int var8 = (var4 - var6) / 2;
         ScreenDrawer.method_374(var1, field_107, 0, 0, var6, var7, 0, var8, var5, 36);
         ScreenDrawer.method_374(var1, field_107, var6, 0, var6, var7, 0, var8, 0, 0);
         var7 = ScreenDrawer.method_377(field_105) / 2;
         int var9 = ScreenDrawer.method_378(field_105);
         if(var22 > 0) {
            var7 = 0;
            var9 -= var22;
         }

         if(var6 + (var7 << 1) < var4) {
            ScreenDrawer.method_375(var1, field_106, 4, 2, var8, 0, var7, true, 16);
            ScreenDrawer.method_375(var1, field_106, 4, 3, var8 + var6, 0, var4 - var7, true, 16);
         }

         if(var22 == 0) {
            ScreenDrawer.method_374(var1, field_105, 0, 0, var7, var9, 0, 0, 0, 0);
            ScreenDrawer.method_374(var1, field_105, var7, 0, var7, var9, 0, var4 - var7, 0, 0);
         }

         var3 = ScreenDrawer.method_377(field_104) / 2;
         var7 = ScreenDrawer.method_378(field_104);
         if(var6 + (var3 << 1) < var4) {
            ScreenDrawer.method_375(var1, field_106, 4, 0, var8, var5, var3, true, 32);
            ScreenDrawer.method_375(var1, field_106, 4, 1, var8 + var6, var5, var4 - var3, true, 32);
         }

         var6 = ScreenDrawer.method_377(field_115);
         int var10 = ScreenDrawer.method_378(field_115);
         ScreenDrawer.method_374(var1, field_115, 0, 0, var6, var10, 0, 0, var9, 0);
         int var11 = ScreenDrawer.method_377(field_114);
         int var12 = ScreenDrawer.method_378(field_114);
         ScreenDrawer.method_374(var1, field_114, 0, 0, var11, var12, 0, var4 - var11, var9, 0);
         int var13 = ScreenDrawer.method_377(field_112) / 5;
         int var14 = ScreenDrawer.method_378(field_112);
         var8 = (var4 << 1) / 3 - var13;
         int var15 = var9 + (var10 - var14) / 2;
         ScreenDrawer.method_374(var1, field_112, super.raceId * var13, 0, var13, var14, 0, var8, var15, 0);
         int var16 = ScreenDrawer.method_377(field_110) / 5;
         int var17 = ScreenDrawer.method_378(field_110);
         ScreenDrawer.method_375(var1, field_113, 5, super.raceId, var8, var15, var6 + var16, true, 0);
         ScreenDrawer.method_374(var1, field_110, var16 * super.raceId, 0, var16, var17, 0, var6, var9 + (var10 - var17) / 2, 0);
         var6 = (var8 + var6 + var16) / 2;
         var16 = var15 + var14 / 2;
         var17 = ScreenDrawer.method_377(field_111) / 5;
         int var18 = ScreenDrawer.method_378(field_111);
         ScreenDrawer.method_375(var1, field_113, 5, super.raceId, var8 + var13, var15, var4 - var11 - var17, true, 0);
         ScreenDrawer.method_374(var1, field_111, var17 * super.raceId, 0, var17, var18, 0, var4 - var11 - var17, var9 + (var12 - var18) / 2, 0);
         int var20 = (var8 + var13 + var4 - var11 - var17) / 2;
         var8 = var15 + var14 / 2;
         var11 = ScreenDrawer.method_377(field_109) / 2;
         var13 = ScreenDrawer.method_378(field_109);
         ScreenDrawer.method_374(var21, field_109, 0, 0, var11, var13, 0, 0, var9 + var10, 0);
         ScreenDrawer.method_374(var21, field_109, var11, 0, var11, var13, 0, var4 - var11, var9 + var12, 0);
         if(var9 + var10 + var13 < var5 - var7) {
            ScreenDrawer.method_375(var21, field_108, 2, 0, 0, var9 + var10 + var13, var5 - var7, false, 4);
            ScreenDrawer.method_375(var21, field_108, 2, 1, var4, var9 + var12 + var13, var5 - var7, false, 8);
         }

         ScreenDrawer.method_374(var21, field_104, 0, 0, var3, var7, 0, 0, var5, 36);
         ScreenDrawer.method_374(var21, field_104, var3, 0, var3, var7, 0, var4 - var3, var5, 36);
         Screen.field_26.method_564(var21, Hero.self.method_901(), var20, var8, 3);
         Screen.field_26.method_564(var21, Hero.self.method_900(), var6, var16, 3);
      } catch (Exception var19) {
         SocketListener.logMessage("MenuScreen.drawScreen: " + var19.toString());
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, int) void
   protected static void method_137(Graphics var0, short var1, int var2) {
      Image var9;
      int var3 = ScreenDrawer.method_383(var9 = GlobalStorage.getImage(var1));
      int var4 = ScreenDrawer.method_383(var9);
      int var5 = ScreenDrawer.self.getWidth() / var3 + 1;
      int var6 = ScreenDrawer.self.getHeight() / var4 + 1;

      for(byte var7 = 0; var7 < var5; ++var7) {
         for(byte var8 = 0; var8 < var6; ++var8) {
            ScreenDrawer.method_372(var0, var9, var3 * var2, 0, var3, var4, 0, var7 * var3, var8 * var4, 0);
         }
      }

   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, boolean, boolean) void
   public static void method_138(Graphics var0, short var1, short var2, boolean var3, boolean var4) {
      if(var4) {
         ScreenDrawer.method_372(var0, GlobalStorage.getImage(field_97), 0, 0, ScreenDrawer.method_382(GlobalStorage.getImage(field_97)), ScreenDrawer.method_383(GlobalStorage.getImage(field_97)), 0, var1 + 45, var2 + 2 + ScreenDrawer.method_383(GlobalStorage.getImage(field_97)) / 2, 3);
      } else {
         if(var3) {
            ScreenDrawer.method_372(var0, GlobalStorage.getImage(field_96), 0, 0, ScreenDrawer.method_382(GlobalStorage.getImage(field_96)), ScreenDrawer.method_383(GlobalStorage.getImage(field_96)), 0, var1 + 45, var2 + 2 + ScreenDrawer.method_383(GlobalStorage.getImage(field_97)) / 2, 3);
         }

      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, java.lang.String[], byte, mobak.c.a) void
   protected final void method_139(Graphics var1, short var2, String[] var3, byte var4, class_62 var5) {
      int var6;
      int var8;
      if(var4 < this.field_118) {
         if(this.field_118 < 0) {
            this.field_118 = 0;
         }
      } else {
         var6 = var3.length;
         int var7 = var5.field_500 + 5;
         if(ScreenDrawer.self.method_380()) {
            var7 = ScreenDrawer.method_378(field_101);
         }

         if((var8 = (ScreenDrawer.self.getHeight() - var2 - PopupMenu.method_583() - var7 - 5) / var7) < var6 && this.field_118 + var8 > var6) {
            this.field_118 = var6 - var8;
         }
      }

      if(var1 != null && var3 != null && var3.length != 0 && var5 != null) {
         var6 = ScreenDrawer.self.getWidth();

         for(byte var15 = (byte)this.field_118; var15 < var3.length; ++var15) {
            var8 = var5.method_563(var3[var15]);
            if(var15 == var4) {
               int var9 = ScreenDrawer.method_377(field_100) / 5;
               int var10 = ScreenDrawer.method_378(field_100);
               int var11 = ScreenDrawer.method_377(field_102) / 5;
               int var12 = ScreenDrawer.method_378(field_102);
               int var13 = var6 < 176?5:15;
               int var14 = (var10 - var5.field_500) / 2;
               if(var6 - (var13 << 1) < var8 + (var9 + var11) / 2) {
                  var13 = (var6 - var8 - (var9 + var11) / 2) / 2;
               }

               if(var13 < 0) {
                  var13 = 0;
               }

               ScreenDrawer.method_374(var1, field_100, var9 * super.raceId, 0, var9, var10, 0, var13, var2 - var14, 0);
               ScreenDrawer.method_375(var1, field_101, 5, super.raceId, var13 + var9, var2 - var14, var6 - var13 - var11, true, 0);
               ScreenDrawer.method_374(var1, field_102, var11 * super.raceId, 0, var11, var12, 0, var6 - var13 - var11, var2 - var14, 0);
            }

            var5.method_564(var1, var3[var15], (ScreenDrawer.self.getWidth() - var8) / 2, var2, 0);
            if(!ScreenDrawer.self.method_380()) {
               var2 = (short)(var2 + var5.field_500 + 5);
            } else {
               var2 = (short)(var2 + ScreenDrawer.method_378(field_101));
            }
         }

      }
   }

   // $FF: renamed from: a (int, int, int) byte
   protected final byte method_140(int var1, int var2, int var3) {
      int var4 = ScreenDrawer.method_378(field_101);
      byte var5;
      if((var5 = (byte)((var3 - var2) / var4 + this.field_118)) < 0 || var5 >= var1) {
         var5 = -1;
      }

      return var5;
   }

   // $FF: renamed from: a (mobak.b.a.a[]) mobak.b.a.a[]
   public static Thing[] method_141(Thing[] var0) {
      if(var0 != null && var0.length != 0) {
         short var1 = 0;

         for(short var2 = 0; var2 < var0.length; ++var2) {
            if(var0[var2] != null && var0[var2].getQuantity() != 0) {
               ++var1;
            }
         }

         if(var1 == 0) {
            return null;
         } else if(var1 == var0.length) {
            return var0;
         } else {
            Thing[] var4 = new Thing[var1];
            var1 = 0;

            for(short var3 = 0; var3 < var0.length; ++var3) {
               if(var0[var3] != null && var0[var3].getQuantity() != 0) {
                  var4[var1] = var0[var3];
                  ++var1;
               }
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   // $FF: renamed from: b (java.lang.String) void
   public final void setCurrentMenuName(String var1) {
      this.name = var1;
   }

   // $FF: renamed from: c (java.lang.String) void
   public final void setMapName(String var1) {
      this.field_117 = var1;
   }

   // $FF: renamed from: a () java.lang.String
   public String method_58() {
      return this.field_117;
   }

   // $FF: renamed from: a (boolean) byte
   protected final byte method_144(boolean var1) {
      return var1?(byte)((ScreenDrawer.self.getHeight() - this.method_136() - 10 - ScreenDrawer.method_383(GlobalStorage.getImage(field_92)) - ScreenDrawer.method_383(GlobalStorage.getImage(field_93)) - PopupMenu.method_583()) / 55):(byte)((ScreenDrawer.self.getWidth() - 32) / 61);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int) void
   protected final void method_145(Graphics var1, int var2) {
      this.field_121 = var2;
      short var3;
      int var4 = ScreenDrawer.method_377(var3 = GlobalStorage.method_711("plus_minus.png")) / 2;
      int var5 = ScreenDrawer.method_378(var3);
      int var6 = ScreenDrawer.self.getWidth() - var4;
      ScreenDrawer.method_374(var1, var3, 0, 0, var4, var5, 0, var6, var2, 0);
      ScreenDrawer.method_374(var1, var3, var4, 0, var4, var5, 0, var6, var2 + var5, 0);
   }

   // $FF: renamed from: a (int, int) byte
   protected final byte method_146(int var1, int var2) {
      byte var3 = -1;
      int var4 = ScreenDrawer.self.getWidth() - 61;
      int var5 = this.field_121;
      if(var1 >= var4 && var1 <= var4 + 61 && var2 >= var5 && var2 <= var5 + 106) {
         if(var2 <= var5 + 53) {
            var3 = 1;
         } else {
            var3 = 2;
         }
      }

      return var3;
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_87 = -1;
      field_88 = -1;
      field_89 = -1;
      field_90 = -1;
      field_91 = -1;
      field_92 = -1;
      field_93 = -1;
      field_94 = -1;
      field_95 = -1;
      field_96 = -1;
      field_97 = -1;
      field_98 = -1;
      field_99 = -1;
      field_100 = -1;
      field_101 = -1;
      field_102 = -1;
      field_103 = -1;
      field_104 = -1;
      field_105 = -1;
      field_106 = -1;
      field_107 = -1;
      field_108 = -1;
      field_109 = -1;
      field_110 = -1;
      field_111 = -1;
      field_112 = -1;
      field_113 = -1;
      field_114 = -1;
      field_115 = -1;
   }
}
