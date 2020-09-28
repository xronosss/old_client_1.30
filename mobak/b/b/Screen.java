package mobak.b.b;

import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Graphics;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.class_82;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Hero;
import mobak.b.b.a.MenuScreen;
import mobak.b.b.a.class_35;
import mobak.b.b.a.ViewHelp;
import mobak.b.b.a.PopupMenu;
import mobak.b.b.a.Button;
import mobak.c.class_1;
import mobak.c.class_62;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.b.j
public abstract class Screen implements class_1 {

   // $FF: renamed from: b boolean
   static boolean field_24;
   // $FF: renamed from: a mobak.c.a
   public static class_62 field_25;
   // $FF: renamed from: b mobak.c.a
   public static class_62 field_26;
   // $FF: renamed from: c mobak.c.a
   public static class_62 field_27;
   // $FF: renamed from: d mobak.c.a
   public static class_62 field_28;
   // $FF: renamed from: e mobak.c.a
   public static class_62 field_29;
   // $FF: renamed from: f mobak.c.a
   public static class_62 field_30;
   // $FF: renamed from: g mobak.c.a
   public static class_62 field_31;
   // $FF: renamed from: h mobak.c.a
   public static class_62 field_32;
   // $FF: renamed from: i mobak.c.a
   public static class_62 field_33;
   // $FF: renamed from: a int
   public static int field_34;
   // $FF: renamed from: b int
   public static int field_35;
   // $FF: renamed from: c int
   public static int field_36;
   // $FF: renamed from: d int
   public static int field_37;
   // $FF: renamed from: c boolean
   public static boolean field_38;
   // $FF: renamed from: a java.lang.String
   public static String nameOfMap;
   // $FF: renamed from: a mobak.b.b.g
   public FormCreator formCreator;
   // $FF: renamed from: a boolean
   private boolean field_41;
   // $FF: renamed from: d boolean
   private boolean field_42;
   // $FF: renamed from: e boolean
   private boolean field_43;
   // $FF: renamed from: a mobak.b.b.a.v
   private Button field_44;
   // $FF: renamed from: a mobak.b.b.a.u
   public PopupMenu popupMenu;
   // $FF: renamed from: a byte
   public byte field_46;
   // $FF: renamed from: c byte
   private byte field_47;
   // $FF: renamed from: d byte
   private byte field_48;
   // $FF: renamed from: b short
   private static short field_49;
   // $FF: renamed from: c short
   private short field_50;
   // $FF: renamed from: f boolean
   private boolean field_51;
   // $FF: renamed from: a short
   public short field_52;
   // $FF: renamed from: a mobak.b.b.q
   public class_55 field_53;
   // $FF: renamed from: b java.lang.String
   private String field_54;
   // $FF: renamed from: b byte
   public byte raceId;


   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   protected abstract void method_30(Graphics var1);

   // $FF: renamed from: b (javax.microedition.lcdui.Graphics) void
   public final void method_31(Graphics var1) {
      this.method_30(var1);
      if(this.field_44 != null) {
         Button var3;
         if(this.field_42) {
            this.field_42 = false;
            FormCreator var10001 = new FormCreator(MessagesContainer.getLine(9), this);
            this.formCreator = var10001;
            var3 = this.field_44;
            String[] var6 = this.field_44.field_547;
            var3 = this.field_44;
            short[] var7 = this.field_44.field_548;
            var3 = this.field_44;
            int[] var9 = this.field_44.field_549;

            for(short var4 = 0; var4 < var6.length; ++var4) {
               if(var7[var4] < 0) {
                  this.formCreator.createLabel(var6[var4], "", 100, var9[var4]);
               } else {
                  this.formCreator.createLabel(var6[var4], "", var7[var4], var9[var4]);
               }
            }

            this.formCreator.addCommand("OK");
            this.formCreator.addCommandAtIndex(MessagesContainer.getLine(34), 1);
            this.formCreator.setCurrentFormAsMain();
            return;
         }

         if(this.field_41 && !this.field_43) {
            this.field_43 = true;
            class_27 var10000 = new class_27(this);
            class_27 var5 = var10000;
            if(this.field_44.method_657()) {
               String[] var2 = new String[this.formCreator.method_442()];

               for(short var8 = 0; var8 < this.formCreator.method_442(); ++var8) {
                  var2[var8] = this.formCreator.method_443(var8);
               }

               var3 = this.field_44;
               ScreenDrawer.method_334("", MessagesContainer.method_571(this.field_44.field_546, var2), "", var5);
               return;
            }

            var3 = this.field_44;
            ScreenDrawer.method_334("", this.field_44.field_546, "", var5);
         }
      }

   }

   // $FF: renamed from: d (int) void
   public void method_32(int var1) {
      Button var2 = null;
      if(this.popupMenu != null) {
         if(this.method_77() && ScreenDrawer.self.method_379(var1) && !this.popupMenu.method_612()) {
            this.method_78();
            return;
         }

         this.method_51();
         if((var2 = this.popupMenu.method_610(PopupMenu.method_630(var1), PopupMenu.method_629(var1), ScreenDrawer.self.method_379(var1))) == null && this.popupMenu.method_611()) {
            this.popupMenu.method_607(ScreenDrawer.self.getGameAction(var1));
            return;
         }
      }

      if(var2 == null || !this.method_37(var2)) {
         this.method_39(var1);
      }

   }

   // $FF: renamed from: c (byte) void
   public final void setRace(byte raceId) {
      this.raceId = raceId;
      if(this.popupMenu != null) {
         this.popupMenu.method_582(this.raceId);
      }

   }

   // $FF: renamed from: a (mobak.b.b.j) void
   public final void method_34(Screen var1) {
      this.raceId = var1.raceId;
      if(this.popupMenu != null) {
         this.popupMenu.method_582(this.raceId);
      }

   }

   // $FF: renamed from: a () byte
   public final byte method_35() {
      return this.raceId;
   }

   // $FF: renamed from: a () boolean
   public final boolean method_36() {
      Button var1;
      if(this.popupMenu != null && (var1 = this.popupMenu.method_610(false, true, false)) != null) {
         try {
            return this.method_37(var1);
         } catch (Exception var2) {
            SocketListener.logMessage("(Screen descendant).pushLeftPopupMenuButton () error: " + var2.toString());
         }
      }

      return false;
   }

   // $FF: renamed from: b (mobak.b.b.a.v) boolean
   public boolean method_37(Button var1) {
      boolean var2 = this.method_38(var1);
      if(var1 != null) {
         int var3 = var1.field_543;
         if((byte)var1.field_543 != 30 && var1.field_544 != 0) {
            SocketListener var10000 = SocketListener.self;
            OutputGameMessage var10001 = new OutputGameMessage(var1.field_544);
            var10000.sendCommand(var10001);
         }
      }

      return var2;
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public boolean method_38(Button var1) {
      if(var1 != null) {
         OutputGameMessage gameMessage;
         switch((byte)var1.field_543) {
         case 30:
            if(var1 != null) {
               this.method_68();
               this.field_44 = var1;
               boolean var7 = false;
               Button var3 = this.field_44;
               if(this.field_44.field_546 != null) {
                  this.field_41 = true;
                  var7 = true;
               }

               var3 = this.field_44;
               if(this.field_44.field_547 != null) {
                  this.field_42 = true;
                  var7 = true;
               }

               if(!var7) {
                  this.method_70();
               }
            }

            return true;
         case 64:
            class_28 var9 = new class_28(this);
            ScreenDrawer.method_334(MessagesContainer.getMessage(135), MessagesContainer.getMessage(185), "", var9);
            return true;
         case 71:
            this.method_76();
            return true;
         case 85:
            ScreenDrawer.self.method_340(MenuScreen.method_134(), true);
            return true;
         case 87:
            ScreenDrawer.self.method_340(MenuScreen.method_133((short)-2), true);
            return true;
         case 88:
            ScreenDrawer.self.method_340(MenuScreen.method_133((short)-3), true);
            return true;
         case 95:
            method_55(this.field_52);
            return true;
         case 97:
            class_35.method_173();
            return true;
         case 101:
            method_74();
            return true;
         case 102:
            Hero.method_926();
            return true;
         case 103:
            Main2.gotoUrl1(Main2.self.method_852());
            return true;
         case 104:
            Main2.gotoUrl1(Main2.self.method_851());
            return true;
         case 106:
            gameMessage = new OutputGameMessage(MessageProcessor.packetTypes[111], (short)0, MessageProcessor.packetTypes[111]);
            SocketListener.self.sendCommand(gameMessage);
            return true;
         default:
            short var5 = PopupMenu.method_636((byte)var1.field_543);
            gameMessage = new OutputGameMessage(var5);
            SocketListener.self.sendCommand(gameMessage);
         }
      }

      return false;
   }

   // $FF: renamed from: c (int) void
   protected void method_39(int var1) {}

   // $FF: renamed from: <init> () void
   public Screen() {
      super();
      this.field_41 = false;
      this.field_42 = false;
      this.field_43 = false;
      this.popupMenu = null;
      this.field_46 = 0;
      this.field_47 = -1;
      this.field_48 = -1;
      this.field_50 = -1;
      this.field_51 = true;
      this.raceId = 0;
      field_24 = false;
   }

   // $FF: renamed from: a (short) void
   public final void method_41(short var1) {
      this.field_52 = var1;
   }

   // $FF: renamed from: a (java.lang.String) void
   private void method_42(String var1) {
      try {
         this.field_50 = GlobalStorage.method_711(var1);
         this.field_47 = (byte)(ScreenDrawer.method_382(GlobalStorage.getImage(this.field_50)) / 34);
         this.field_48 = 0;
      } catch (Exception var2) {
         SocketListener.logMessage("loadAnimCursor" + var2.toString());
      }
   }

   // $FF: renamed from: d (byte) void
   public final void method_43(byte var1) {
      if(var1 != this.field_46) {
         this.field_46 = var1;
         Screen var4 = this;

         try {
            if(field_49 == -1) {
               field_49 = GlobalStorage.method_711("cursors.png");
            }

            if(var4.field_46 > 0) {
               byte var2 = -1;
               switch(var4.field_46) {
               case 1:
                  var2 = 0;
                  break;
               case 2:
                  var2 = 1;
                  break;
               case 3:
                  var2 = 3;
                  break;
               case 4:
                  var2 = 4;
                  break;
               case 5:
                  var2 = 5;
                  break;
               case 6:
                  var2 = 7;
                  break;
               case 7:
                  var2 = 10;
               case 8:
               default:
                  break;
               case 9:
                  var2 = 11;
                  break;
               case 10:
                  var2 = 12;
               }

               if(var2 >= 0) {
                  var4.field_48 = var2;
                  var4.field_47 = -1;
               }
            } else {
               if(var4.field_46 < 0) {
                  switch(var4.field_46) {
                  case -4:
                     var4.method_42("hand.png");
                     return;
                  case -3:
                     var4.method_42("herou-cursor.png");
                     break;
                  case -2:
                     var4.method_42("entry.png");
                     break;
                  case -1:
                     var4.method_42("clock.png");
                     break;
                  default:
                     return;
                  }
               } else {
                  var4.field_48 = -1;
                  var4.field_47 = -1;
               }

               return;
            }
         } catch (Exception var3) {
            SocketListener.logMessage("loadCursor " + var3.toString());
         }
      }

   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short) void
   protected final void method_44(Graphics var1, short var2, short var3) {
      this.method_45(var1, var2, var3, 0);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, int) void
   protected final void method_45(Graphics var1, short var2, short var3, int var4) {
      try {
         if(this.field_46 == 0) {
            return;
         }

         if(var2 < 0 || var3 < 0 || var2 > ScreenDrawer.self.getWidth() || var3 > ScreenDrawer.self.getHeight()) {
            return;
         }

         if(this.field_46 <= 0) {
            ScreenDrawer.method_372(var1, GlobalStorage.getImage(this.field_50), 34 * this.field_48, 0, 34, 34, 0, var2, var3, 0);
            ++this.field_48;
            if(this.field_48 >= this.field_47) {
               this.field_48 = 0;
            }

            return;
         }

         ScreenDrawer.method_372(var1, GlobalStorage.getImage(field_49), 34 * this.field_48, 0, 34, 34, 0, var2, var3, 0);
      } catch (Exception var5) {
         SocketListener.logMessage("drawCursor " + var5.toString());
      }

   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, byte, short, short, int) void
   public static void method_46(Graphics var0, byte var1, short var2, short var3, int var4) {
      if(field_49 == -1) {
         field_49 = GlobalStorage.method_711("cursors.png");
      }

      ScreenDrawer.method_372(var0, GlobalStorage.getImage(field_49), var1 * 34, 0, 34, 34, 0, var2, var3, 0);
   }

   // $FF: renamed from: e () void
   public static void method_47() {
      field_24 = false;
   }

   // $FF: renamed from: f () void
   public static void method_48() {
      field_24 = false;
   }

   // $FF: renamed from: b () boolean
   public static boolean method_49() {
      return field_24;
   }

   // $FF: renamed from: g () void
   public void helpViewInit() {
      try {
         ViewHelp var1;
         if(Main2.self.method_854(this.field_52) && (var1 = ViewHelp.method_273(this.field_52)) != null) {
            ScreenDrawer.self.method_340(var1, ScreenDrawer.self.GetScreen() == this);
         }

      } catch (Exception var2) {
         SocketListener.logMessage("HelpViewInit " + var2.getMessage());
      }
   }

   // $FF: renamed from: a () void
   public abstract void method_51();

   // $FF: renamed from: c () boolean
   public final boolean method_52() {
      return this.field_51;
   }

   // $FF: renamed from: a (boolean) void
   public final void method_53(boolean var1) {
      this.field_51 = var1;
   }

   // $FF: renamed from: h () void
   public final void method_54() {
      method_55(this.field_52);
   }

   // $FF: renamed from: b (short) void
   public static void method_55(short var0) {
      try {
         ViewHelp var1;
         if((var1 = ViewHelp.method_273(var0)) == null) {
            OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[49]);
            var10000.setNextCommandType(MessageProcessor.packetTypes[49]);
            var10000.addToBody(var0);
            SocketListener.self.sendCommand(var10000);
            return;
         }

         ScreenDrawer.self.method_340(var1, true);
      } catch (Exception var2) {
         SocketListener.logMessage("addToOrderRequest " + var2.toString());
      }

   }

   // $FF: renamed from: i () void
   public final void method_56() {
      if(this.field_53 != null) {
         this.field_53.method_495();
      }

   }

   // $FF: renamed from: a (short, short, short, short, boolean) void
   public final void method_57(short var1, short var2, short var3, short var4, boolean var5) {
      if(this.field_53 != null) {
         this.field_53 = null;
      }

      class_55 var10001 = new class_55(var1, var2, var3, var4, true, false);
      this.field_53 = var10001;
   }

   // $FF: renamed from: a () java.lang.String
   public String method_58() {
      return nameOfMap;
   }

   // $FF: renamed from: a (int, int) boolean
   protected abstract boolean method_59(int var1, int var2);

   // $FF: renamed from: b (int, int, int) boolean
   protected abstract boolean method_60(int var1, int var2, int var3);

   // $FF: renamed from: a (int, int, int) boolean
   protected abstract boolean method_61(int var1, int var2, int var3);

   // $FF: renamed from: b (int, int) boolean
   protected abstract boolean method_62(int var1, int var2);

   // $FF: renamed from: c (int, int) boolean
   public final boolean method_63(int var1, int var2) {
      try {
         if(this.popupMenu != null) {
            this.method_51();
            Button var4;
            if(PopupMenu.method_624(var1, var2)) {
               if((var4 = this.popupMenu.method_610(false, true, false)) != null) {
                  this.method_37(var4);
                  return true;
               }

               return false;
            }

            if(PopupMenu.method_625(var1, var2)) {
               if((var4 = this.popupMenu.method_610(true, false, false)) != null) {
                  this.method_37(var4);
                  return true;
               }

               return false;
            }

            if(this.popupMenu.method_611() && this.popupMenu.method_626(var1, var2)) {
               return false;
            }
         }

         this.method_59(var1, var2);
      } catch (Exception var3) {
         ;
      }

      return false;
   }

   // $FF: renamed from: a (int, int) void
   public final void method_64(int var1, int var2) {
      try {
         if(this.popupMenu == null || (!this.popupMenu.method_611() || !this.popupMenu.method_626(var1, var2)) && !PopupMenu.method_624(var1, var2) && !PopupMenu.method_625(var1, var2)) {
            this.method_62(var1, var2);
         }
      } catch (Exception var3) {
         SocketListener.logMessage("Screen.pointerDragged: " + var3.getMessage());
      }
   }

   // $FF: renamed from: c (int, int, int) boolean
   public final boolean method_65(int var1, int var2, int var3) {
      try {
         if(this.popupMenu != null && ScreenDrawer.self != null && (field_35 > ScreenDrawer.self.getHeight() - PopupMenu.method_583() || this.popupMenu.method_611())) {
            Button var4;
            if(PopupMenu.method_624(var1, var2)) {
               if(var3 > 500 && (var4 = this.popupMenu.method_610(false, true, false)) != null) {
                  this.method_37(var4);
               }

               return true;
            }

            if(PopupMenu.method_625(var1, var2)) {
               if(var3 > 500 && (var4 = this.popupMenu.method_610(true, false, false)) != null) {
                  this.method_37(var4);
               }

               return true;
            }

            if(this.popupMenu.method_611()) {
               if(this.popupMenu.method_626(var1, var2)) {
                  if((var4 = this.popupMenu.method_610(false, false, true)) != null) {
                     this.method_37(var4);
                  }

                  return true;
               }

               this.popupMenu.method_609();
               return true;
            }
         }
      } catch (Exception var5) {
         ;
      }

      return this.method_60(var1, var2, var3);
   }

   // $FF: renamed from: a (int, int, int) void
   public final void method_66(int var1, int var2, int var3) {
      this.method_61(var1, var2, var3);
   }

   // $FF: renamed from: j () void
   public final void method_67() {}

   // $FF: renamed from: a (int) void
   public void onButtonClick(int var1) {
      if(var1 == 1) {
         ScreenDrawer.self.method_376();
         this.method_68();
      } else {
         if(var1 == 0) {
            for(short var2 = 0; var2 < this.formCreator.method_442(); ++var2) {
               if(this.formCreator.method_443(var2).equals("")) {
                  return;
               }
            }

            ScreenDrawer.self.method_376();
            if(this.field_44 == null || !this.field_44.method_651()) {
               this.method_70();
            }
         }

      }
   }

   // $FF: renamed from: k () void
   protected final void method_68() {
      this.field_44 = null;
      this.field_43 = false;
      this.formCreator = null;
   }

   // $FF: renamed from: a (int, int) java.lang.String[]
   private String[] method_69(int var1, int var2) {
      String var6 = "";
      String var3 = "num";
      String var7;
      String var9 = (var7 = this.method_72(var3 + String.valueOf(var1) + "-" + var2, (String)null)) == null?this.method_72(var3 + String.valueOf(var1) + var2, var6):var7;
      var3 = this.method_73("moneyName", var1, "");
      String var8 = this.method_73("smsprefix", var1, "mancer");
      String[] var10 = class_82.method_942(var9.trim(), ' ');
      return new String[]{var10[0], var10[1], var3, var10[2], var8, var10.length > 3?var10[3]:""};
   }

   // $FF: renamed from: b () void
   private void method_70() {
      OutputGameMessage var7;
      OutputGameMessage var10000;
      if(this.formCreator != null) {
         String var8;
         int var11;
         if(this.formCreator.method_439() == 10) {
            int var9 = this.formCreator.method_447(1);
            var11 = this.formCreator.method_447(0);
            if(var9 == 0) {
               return;
            }

            String[] var12 = this.method_69(var11 + 1, var9);
            if((var8 = this.method_73("smscoin", var11 + 1, (String)null)) != null) {
               var12[4] = var8;
               var8 = MessagesContainer.getMessage(302, var12);
            } else if(this.method_73("comviva", var11 + 1, (String)null) != null) {
               var12[4] = "";
               var8 = MessagesContainer.getMessage(308, var12);
            } else {
               var8 = MessagesContainer.getMessage(180, var12);
            }

            this.formCreator.method_458(MessagesContainer.getLine(135), var8, AlertType.CONFIRMATION, MessagesContainer.getLine(215));
            return;
         }

         if(this.formCreator.method_439() == 20) {
            if((var8 = this.formCreator.method_443(0)).trim().equals("")) {
               return;
            }

            try {
               var11 = Integer.parseInt(var8);
            } catch (NumberFormatException var5) {
               return;
            }

            if(Hero.self.method_897() < var11) {
               Main2.method_859();
               return;
            }

            if(var11 > 0) {
               try {
                  var10000 = new OutputGameMessage(MessageProcessor.packetTypes[77]);
                  var7 = var10000;
                  var10000.addToBody(var11);
                  SocketListener.self.sendCommand(var7);
               } catch (Exception var4) {
                  SocketListener.method_523(var4);
               }

               this.onButtonClick(1);
            }

            return;
         }
      }

      if(this.field_44 != null) {
         try {
            Button var2 = this.field_44;
            short var1 = this.field_44.field_544;
            var2 = this.field_44;
            short var10 = this.field_44.field_545;
            var10000 = new OutputGameMessage(var1);
            var7 = var10000;
            var10000.setNextCommandType(var10);
            if(this.field_44.method_658()) {
               var7.addToBody(this.method_71());
            }

            if(this.formCreator != null && this.formCreator.method_442() > 0) {
               for(short var3 = 0; var3 < this.formCreator.method_442(); ++var3) {
                  var7.addToBody(this.formCreator.method_443(var3));
               }
            }

            SocketListener.self.sendCommand(var7);
            this.method_68();
         } catch (Exception var6) {
            SocketListener.logMessage("" + var6);
         }
      }
   }

   // $FF: renamed from: a () int
   public int method_71() {
      return -1;
   }

   // $FF: renamed from: d () void
   public final void method_3() {
      if(this.formCreator.method_439() == 10) {
         int var1 = this.formCreator.method_447(1);
         int var2 = this.formCreator.method_447(0);
         String[] var5;
         if((var5 = this.method_69(var2 + 1, var1)) != null) {
            String var3 = var5[5] + var5[4];
            String var4;
            if((var4 = this.method_73("smscoin", var2 + 1, (String)null)) != null) {
               class_82.method_940(var5[5] + " " + var4 + " id" + Hero.self.heroId, var5[0], var3);
            } else if(this.method_73("comviva", var2 + 1, (String)null) != null) {
               class_82.method_940(var5[5] + "id" + Hero.self.heroId, var5[0], var3);
            } else {
               class_82.method_940(var3 + "id" + Hero.self.heroId, var5[0], var3);
            }
         }
      } else {
         this.formCreator.method_439();
      }

      this.onButtonClick(1);
   }

   // $FF: renamed from: b (int) void
   public void method_4(int var1) {
      if(this.formCreator.method_439() == 10) {
         if(var1 == 0) {
            this.formCreator.method_449(1);
            this.formCreator.method_454(0);
            var1 = this.formCreator.method_447(0);
            short var2;
            if((var2 = Short.parseShort(this.method_73("numCount", var1 + 1, "0").trim())) <= 0) {
               this.formCreator.method_457(MessagesContainer.getLine(135), MessagesContainer.getLine(216), 4);
               return;
            }

            String[] var3;
            (var3 = new String[var2 + 1])[0] = "";

            for(short var4 = 0; var4 < var2; ++var4) {
               String[] var5 = this.method_69(var1 + 1, var4 + 1);
               var3[var4 + 1] = var5[3] + " " + MessagesContainer.getLine(230) + " (" + var5[1] + " " + var5[2] + ")";
            }

            this.formCreator.method_444(MessagesContainer.getLine(214), 4, var3, (boolean[])null);
            this.formCreator.method_450(1);
            String var6;
            if((var6 = this.method_73("comment", var1 + 1, (String)null)) != null) {
               this.formCreator.addStringItem((String)null, var6);
            }
         } else if(var1 == 1) {
            if(this.formCreator.method_447(1) >= 0) {
               this.formCreator.method_454(0);
               this.formCreator.addCommandAtIndex(MessagesContainer.getLine(129), 0);
               return;
            }

            this.formCreator.method_454(0);
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) java.lang.String
   private String method_72(String var1, String var2) {
      var1 = var1 + ":";
      if(this.field_54 == null) {
         return var2;
      } else {
         int var3;
         if((var3 = this.field_54.indexOf(var1)) < 0) {
            return var2;
         } else {
            int var4 = var3 + var1.length();
            int var5;
            if((var5 = this.field_54.indexOf(13, var4)) == -1) {
               var5 = this.field_54.indexOf(10, var4);
            }

            return var5 == -1?this.field_54.substring(var4):this.field_54.substring(var4, var5);
         }
      }
   }

   // $FF: renamed from: a (java.lang.String, int, java.lang.String) java.lang.String
   private String method_73(String var1, int var2, String var3) {
      return this.method_72(var1 + String.valueOf(var2), var3);
   }

   // $FF: renamed from: l () void
   public static void method_74() {
      String var0 = Main2.self.rmsManager.getString((byte)20, "0");
      String var1;
      if((var1 = Main2.self.rmsManager.getString((byte)21, (String)null)) == null || var1.equals("")) {
         var0 = "0";
      }

      OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[106], OutputGameMessage.method_960(), MessageProcessor.packetTypes[106]);
      OutputGameMessage var2 = var10000;
      var10000.addToBody(Long.parseLong(var0));
      SocketListener.self.sendCommand(var2);
   }

   // $FF: renamed from: a (long, java.lang.String) void
   public final void method_75(long var1, String var3) {
      String var13;
      label44: {
         class_82.method_941();
         FormCreator var10001 = new FormCreator(MessagesContainer.getLine(212), this);
         this.formCreator = var10001;
         this.formCreator.method_440(10);
         this.formCreator.addStringItem((String)null, MessagesContainer.getLine(231));
         String var9 = var3;
         if(var3 != null && !var3.equals("")) {
            Main2.self.rmsManager.setString((byte)20, String.valueOf(var1));
            Main2.self.rmsManager.setString((byte)21, var3);
         } else {
            if((var9 = Main2.self.rmsManager.getString((byte)21, (String)null)) == null || var9.equals("")) {
               var13 = null;
               break label44;
            }

            var9 = var9;
         }

         var13 = var9;
      }

      this.field_54 = var13;
      if(this.field_54 != null && !this.field_54.equals("")) {
         short var10;
         String[] var2 = new String[var10 = Short.parseShort(this.method_72("count", "0").trim())];

         for(short var11 = 0; var11 < var10; ++var11) {
            var2[var11] = this.method_73("name", var11 + 1, "0");
         }

         this.formCreator.method_444(MessagesContainer.getLine(213), 4, var2, (boolean[])null);
         this.formCreator.addCommandAtIndex(MessagesContainer.getLine(34), 1);
         this.method_4(0);
         this.formCreator.setCurrentFormAsMain();
      } else {
         ScreenDrawer.method_330(MessagesContainer.getLine(135), MessagesContainer.getLine(278));
      }
   }

   // $FF: renamed from: m () void
   public final void method_76() {
      this.formCreator = new FormCreator(MessagesContainer.getLine(83), this);
      this.formCreator.method_440(20);
      this.formCreator.addCommand(MessagesContainer.getLine(83));
      this.formCreator.addCommandAtIndex(MessagesContainer.getLine(34), 1);
      this.formCreator.addStringItem((String)null, MessagesContainer.getMessage(232, new String[]{String.valueOf(GlobalStorage.gemToGoldValue)}));
      this.formCreator.createLabel(MessagesContainer.getMessage(83), "", 15, 2);
      this.formCreator.setCurrentFormAsMain();
   }

   // $FF: renamed from: d () boolean
   protected boolean method_77() {
      return false;
   }

   // $FF: renamed from: n () void
   public void method_78() {}

   // $FF: renamed from: b (mobak.b.b.j) void
   static void method_79(Screen var0) {
      var0.method_70();
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_24 = false;
      field_25 = null;
      field_26 = null;
      field_27 = null;
      field_28 = null;
      field_29 = null;
      field_30 = null;
      field_31 = null;
      field_32 = null;
      field_33 = null;
      nameOfMap = null;
      field_49 = -1;
   }
}
