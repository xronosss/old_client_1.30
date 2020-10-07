package mobak.b.b;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Hero;
import mobak.b.b.a.MenuScreen;
import mobak.b.b.a.PopupMenu;
import mobak.b.b.a.Button;
import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.p
public final class StrategicScreen extends Screen {

   // $FF: renamed from: c byte
   private static byte field_56;
   // $FF: renamed from: d byte
   private static byte field_57;
   // $FF: renamed from: e byte
   private static byte field_58;
   // $FF: renamed from: f byte
   private static byte field_59;
   // $FF: renamed from: f int
   private static int field_60;
   // $FF: renamed from: g int
   private static int field_61;
   // $FF: renamed from: h int
   private static int field_62;
   // $FF: renamed from: i int
   private static int field_63;
   // $FF: renamed from: g byte
   private static byte field_64;
   // $FF: renamed from: a boolean
   private static boolean field_65;
   // $FF: renamed from: d boolean
   private static boolean field_66;
   // $FF: renamed from: e boolean
   private static boolean field_67;
   // $FF: renamed from: h byte
   private byte heroPosiyionX;
   // $FF: renamed from: i byte
   private byte heroPositionY;
   // $FF: renamed from: b short
   private static short field_70;
   // $FF: renamed from: c short
   private static short field_71;
   // $FF: renamed from: d short
   private static short field_72;
   // $FF: renamed from: e short
   private static short field_73;
   // $FF: renamed from: f short
   private static short field_74;
   // $FF: renamed from: g short
   private static short field_75;
   // $FF: renamed from: h short
   private static short field_76;
   // $FF: renamed from: a byte[][]
   private byte[][] field_77;
   // $FF: renamed from: b byte[][]
   private byte[][] field_78;
   // $FF: renamed from: j byte
   private byte field_79;
   // $FF: renamed from: j int
   private int field_80;
   // $FF: renamed from: f boolean
   private boolean field_81;
   // $FF: renamed from: k byte
   private byte field_82;
   // $FF: renamed from: l byte
   private static byte field_83;
   // $FF: renamed from: e int
   public static int field_84;


   // $FF: renamed from: <init> () void
   public StrategicScreen() {
      super();
      this.field_79 = -1;
      this.field_80 = -1;
      this.field_81 = false;
      this.field_82 = 0;
      Screen.field_24 = true;
      field_60 = 0;
      field_61 = 0;
      Screen.field_36 = 0;
      Screen.field_37 = 0;
      field_67 = false;
      Screen.field_38 = true;
      field_70 = GlobalStorage.method_711("decorWater.png");
      field_71 = GlobalStorage.method_711("decorRocks.png");
      field_72 = GlobalStorage.method_711("decorSand.png");
      field_73 = GlobalStorage.method_711("decorSnow.png");
      field_74 = GlobalStorage.method_711("decorGrass.png");
      field_75 = GlobalStorage.method_711("decorStone.png");
      field_76 = GlobalStorage.method_711("animDecorLava.png");
      PopupMenu var10001 = new PopupMenu();
      super.popupMenu = var10001;
      super.popupMenu.method_595(true, (byte)8, (short)94);
      super.popupMenu.method_595(true, (byte)1, (short)69);
      super.popupMenu.method_595(true, (byte)85, (short)93);
      super.popupMenu.method_595(true, (byte)88, (short)52);
      super.popupMenu.method_595(true, (byte)87, (short)95);
      super.popupMenu.method_595(true, (byte)102, (short)181);
      super.popupMenu.method_595(false, (byte)64, (short)1);
      super.popupMenu.method_595(false, (byte)89, (short)98);
      super.popupMenu.method_595(false, (byte)94, (short)38);
      super.popupMenu.method_595(false, (byte)95, (short)298);
      super.popupMenu.method_595(false, (byte)97, (short)81);
      super.popupMenu.method_595(false, (byte)98, (short)77);
      this.method_43((byte)9);
      super.field_52 = -100;
      if(Hero.self != null) {
         this.setRace(Hero.self.method_932());
      }

   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      try {
         if(GlobalStorage.method_698()) {
            byte var2;
            byte var5;
            if(Hero.self.method_888() && this.field_78 != null && this.field_78.length > 0 && this.field_79 >= 0 && this.field_79 < this.field_78.length) {
               if(this.field_79 == 0) {
                  field_64 = method_125(Hero.self.field_684, Hero.self.field_685);
               }

               if(method_125(Hero.self.field_684, Hero.self.field_685) == -1) {
                  method_84(Hero.self.field_684 + 25, Hero.self.field_685 + 25);
               }

               if(Hero.self.method_936() >= field_84) {
                  Hero.self.setCoords(this.field_78[this.field_79][0], this.field_78[this.field_79][1]);
                  Hero.self.method_935(field_84 + 1);
                  ++this.field_79;
                  Hero.self.method_937(0);
               } else {
                  Hero.self.method_937(Hero.self.method_936() + 1);
               }

               if((var2 = method_125(Hero.self.field_684, Hero.self.field_685)) == -1 || var2 != field_64) {
                  if((field_64 & 2) == (var2 & 2)) {
                     field_65 = true;
                  }

                  if((field_64 & 1) == (var2 & 1)) {
                     field_66 = true;
                  }

                  field_64 = var2;
               }

               if(field_65 || field_66) {
                  int var3 = Hero.self.field_684 + 25;
                  int var4 = Hero.self.field_685 + 25;
                  if(field_65) {
                     field_60 = var3;
                     var5 = (byte)(ScreenDrawer.self.getWidth() / 50);
                     field_60 -= var5 / 2 * 50;
                  }

                  if(field_66) {
                     field_61 = var4;
                     var5 = (byte)((ScreenDrawer.self.getHeight() - PopupMenu.method_583()) / 50);
                     field_61 -= var5 / 2 * 50;
                  }

                  method_85();
               }
            } else if(this.field_78 != null && this.field_79 >= this.field_78.length) {
               try {
                  this.method_86();
                  if((field_64 = method_125(Hero.self.field_684, Hero.self.field_685)) == -1) {
                     method_84(Hero.self.field_684 + 25, Hero.self.field_685 + 25);
                  }

                  field_65 = false;
                  field_66 = false;
                  method_84(Hero.self.field_684 + 25, Hero.self.field_685 + 25);
                  this.method_82((byte[][])null);
                  Screen.field_24 = false;
                  this.createWaveMatrix();
               } catch (Exception var6) {
                  SocketListener.logMessage("hero moveEnd: " + var6.getMessage());
               }
            }

            if((var2 = (byte)(field_60 / 50 - 1)) < 0) {
               var2 = 0;
            }

            byte var8;
            if((var8 = (byte)(field_61 / 50)) < 0) {
               var8 = 0;
            }

            byte var9;
            if((var9 = (byte)(var2 + ScreenDrawer.self.method_327() + 1)) >= 50) {
               var9 = 49;
            }

            if((var5 = (byte)(var8 + ScreenDrawer.self.method_328() + 1)) >= 50) {
               var5 = 49;
            }

            if(var5 >= 47) {
               ScreenDrawer.method_384(var1, 0);
               var1.fillRect(0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
            }

            method_103(var1, var2, var8, var9, var5);
            this.method_87(var1);
            this.method_51();
            this.method_44(var1, (short)(this.method_104() - 17 - field_62), (short)(this.method_105() - 17 - field_63));
            super.popupMenu.method_604(var1);
         }
      } catch (Exception var7) {
         SocketListener.logMessage("StrategicScreen.drawScreen(Graphics) " + var7.toString());
         var7.printStackTrace();
      }
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button button) {
      int var2 = button.field_543;
      OutputGameMessage var10000;
      MapObject var5;
      OutputGameMessage var6;
      OutputGameMessage var7;
      switch((byte) button.field_543) {
      case -2:
         this.method_120((byte)1);
         return true;
      case 1:
         this.method_120((byte)0);
         return true;
      case 3:
      case 10:
         return true;
      case 8:
         this.method_120((byte)3);
         return true;
      case 47:
         this.method_120((byte)4);
         return true;
      case 58:
         this.method_120((byte)2);
         return true;
      case 59:
         this.method_118();
         return true;
      case 71:
         if((var5 = GlobalStorage.method_682(this.field_80)) != null && var5.getType() == 1) {
            Hero.self.field_688 = var5.method_417();
            ScreenDrawer.self.method_340(MenuScreen.method_133((short)-12), true);
         }

         return true;
      case 75:
         if((var5 = GlobalStorage.method_683(this.heroPosiyionX, this.heroPositionY)) != null) {
            if(var5.getType() == 2) {
               var10000 = new OutputGameMessage(MessageProcessor.packetTypes[84]);
               var7 = var10000;
               var10000.setNextCommandType(MessageProcessor.packetTypes[5]);
               var7.addToBody(var5.method_417());
               SocketListener.self.sendCommand(var7);
            } else {
               var5.method_432();
            }
         }

         return true;
      case 76:
         try {
            var10000 = new OutputGameMessage(MessageProcessor.packetTypes[51], (short)0, (short)0);
            var6 = var10000;
            SocketListener.self.sendCommand(var6);
         } catch (Exception var4) {
            SocketListener.logMessage("keyPressedSS2" + var4.toString());
         }

         return true;
      case 89:
         this.method_83(Hero.self.getPositionX(), Hero.self.getPositionY(), true);
         return true;
      case 94:
         ScreenDrawer.self.method_340(MenuScreen.method_132(), true);
         return true;
      case 98:
         try {
            var10000 = new OutputGameMessage(MessageProcessor.packetTypes[62], (short)0, MessageProcessor.packetTypes[62]);
            var6 = var10000;
            var10000.addToBody((byte)3);
            SocketListener.self.sendCommand(var6);
         } catch (Exception var3) {
            SocketListener.logMessage("keyPressed: " + var3.getMessage());
         }

         return true;
      case 99:
         if((var5 = GlobalStorage.method_682(this.field_80)) != null) {
            var10000 = new OutputGameMessage(MessageProcessor.packetTypes[66], (short)0, MessageProcessor.packetTypes[5]);
            var7 = var10000;
            var10000.addToBody(var5.method_417());
            SocketListener.self.sendCommand(var7);
         }

         return true;
      case 102:
         Hero.method_926();
         return true;
      default:
         return super.method_38(button);
      }
   }

   // $FF: renamed from: c (int) void
   protected final void method_39(int var1) {
      if(!Hero.self.method_888()) {
         if(ScreenDrawer.self.getGameAction(var1) == 1) {
            --this.heroPositionY;
            if(this.heroPositionY < 0) {
               this.heroPositionY = 0;
            }

            if(this.method_105() < field_61 && (field_61 -= 50) < 0) {
               field_61 = 0;
            }
         } else if(ScreenDrawer.self.getGameAction(var1) == 6) {
            ++this.heroPositionY;
            if(this.heroPositionY >= 50) {
               this.heroPositionY = 49;
            }

            if(this.method_105() > field_61 + (ScreenDrawer.self.getHeight() - PopupMenu.method_583()) && (field_61 += 50) + ScreenDrawer.self.getHeight() - PopupMenu.method_583() > 2500) {
               field_61 = 2500 - ScreenDrawer.self.getHeight() + PopupMenu.method_583();
            }
         } else if(ScreenDrawer.self.getGameAction(var1) == 2) {
            --this.heroPosiyionX;
            if(this.heroPosiyionX < 0) {
               this.heroPosiyionX = 0;
            }

            if(this.method_104() < field_60 && (field_60 -= 50) < 0) {
               field_60 = 0;
            }
         } else if(ScreenDrawer.self.getGameAction(var1) == 5) {
            ++this.heroPosiyionX;
            if(this.heroPosiyionX >= 50) {
               this.heroPosiyionX = 49;
            }

            if(this.method_104() > field_60 + ScreenDrawer.self.getWidth() && (field_60 += 50) + ScreenDrawer.self.getWidth() > 2500) {
               field_60 = 2500 - ScreenDrawer.self.getWidth();
            }
         }

         this.method_81();
      }
   }

   // $FF: renamed from: o () void
   private void method_81() {
      this.method_82((byte[][])null);
      this.createWaveMatrix();
      if(this.heroPosiyionX != Hero.self.getPositionX() || this.heroPositionY != Hero.self.getPositionY()) {
         if(GlobalStorage.method_688(this.heroPosiyionX, this.heroPositionY) >= 0) {
            this.method_82((byte[][])null);
            if((Math.abs(this.heroPosiyionX - Hero.self.getPositionX()) != 1 || this.heroPositionY - Hero.self.getPositionY() != 0) && (Math.abs(this.heroPositionY - Hero.self.getPositionY()) != 1 || this.heroPosiyionX - Hero.self.getPositionX() != 0)) {
               if(this.field_77 == null) {
                  return;
               }

               short var1 = this.method_108((short)this.heroPosiyionX);
               short var2 = this.method_109((short)this.heroPositionY);
               if(var1 >= 0 && var1 < this.field_77.length) {
                  if(var2 >= 0 && var2 < this.field_77[var1].length) {
                     byte[] var3 = new byte[]{(byte)-1, (byte)-1, (byte)-1, (byte)-1};
                     if(var1 - 1 >= 0) {
                        var3[0] = this.field_77[var1 - 1][var2];
                     }

                     if(var1 + 1 < this.field_77.length) {
                        var3[1] = this.field_77[var1 + 1][var2];
                     }

                     if(var2 + 1 < this.field_77[var1].length) {
                        var3[2] = this.field_77[var1][var2 + 1];
                     }

                     if(var2 - 1 >= 0) {
                        var3[3] = this.field_77[var1][var2 - 1];
                     }

                     byte var4 = 0;

                     for(byte var5 = 0; var5 < var3.length; ++var5) {
                        if(var3[var5] < var3[var4] && var3[var5] > 0) {
                           var4 = var5;
                        }
                     }

                     if(var3[var4] < 0) {
                        return;
                     }

                     byte[][] var6 = null;
                     switch(var4) {
                     case 0:
                        var6 = this.method_115((byte)(this.heroPosiyionX - 1), this.heroPositionY);
                        break;
                     case 1:
                        var6 = this.method_115((byte)(this.heroPosiyionX + 1), this.heroPositionY);
                        break;
                     case 2:
                        var6 = this.method_115(this.heroPosiyionX, (byte)(this.heroPositionY + 1));
                        break;
                     case 3:
                        var6 = this.method_115(this.heroPosiyionX, (byte)(this.heroPositionY - 1));
                     }

                     this.method_82(var6);
                     return;
                  }

                  return;
               }

               return;
            }

            this.method_82(new byte[][]{{Hero.self.getPositionX(), Hero.self.getPositionY()}});
            return;
         }

         if(!GlobalStorage.method_709(GlobalStorage.method_702((short)this.heroPosiyionX, (short)this.heroPositionY))) {
            this.method_82((byte[][])null);
            return;
         }

         this.method_82(this.method_115(this.heroPosiyionX, this.heroPositionY));
      }

   }

   // $FF: renamed from: a (byte[][]) void
   private void method_82(byte[][] var1) {
      Hero var2 = Hero.self;
      synchronized(Hero.self) {
         this.field_78 = var1;
         if(this.field_78 != null) {
            this.field_79 = 0;
         } else {
            this.field_79 = -1;
         }

      }
   }

   // $FF: renamed from: a (byte, byte, boolean) void
   public final void method_83(byte var1, byte var2, boolean var3) {
      this.heroPosiyionX = var1;
      this.heroPositionY = var2;
      this.method_82(this.method_115(this.heroPosiyionX, this.heroPositionY));
      field_60 = var1 * 50;
      field_61 = var2 * 50;
      var1 = (byte)(ScreenDrawer.self.getWidth() / 50);
      var2 = (byte)((ScreenDrawer.self.getHeight() - PopupMenu.method_583()) / 50);
      field_60 -= var1 / 2 * 50;
      field_61 -= var2 / 2 * 50;
      method_85();
   }

   // $FF: renamed from: b (int, int) void
   private static void method_84(int var0, int var1) {
      field_60 = var0;
      field_61 = var1;
      byte var2 = (byte)(ScreenDrawer.self.getWidth() / 50);
      byte var3 = (byte)((ScreenDrawer.self.getHeight() - PopupMenu.method_583()) / 50);
      field_60 -= var2 / 2 * 50;
      field_61 -= var3 / 2 * 50;
      method_85();
   }

   // $FF: renamed from: p () void
   private static void method_85() {
      if(field_60 < 0) {
         field_60 = 0;
      }

      if(field_61 < 0) {
         field_61 = 0;
      }

      if(field_60 + ScreenDrawer.self.getWidth() > 2500) {
         field_60 = 2500 - ScreenDrawer.self.getWidth();
      }

      if(field_61 + ScreenDrawer.self.getHeight() - PopupMenu.method_583() > 2500) {
         field_61 = 2500 - ScreenDrawer.self.getHeight() + PopupMenu.method_583();
      }

   }

   // $FF: renamed from: e () boolean
   private boolean method_86() {
      try {
         byte var1 = this.field_78[this.field_78.length - 1][0];
         byte var2 = this.field_78[this.field_78.length - 1][1];
         Hero.self.setCoords(var1, var2);
         Hero.self.method_887(false);
         this.method_43((byte)0);
         OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[18], (short)2, (short)0);
         OutputGameMessage var3 = var10000;
         if(this.field_82 == 1) {
            Hero.self.setCoords(var1, var2);
         }

         var3.addToBody(Hero.self.getPositionX());
         var3.addToBody(Hero.self.getPositionY());
         SocketListener.self.sendCommand(var3);
         if(this.field_82 != 0) {
            var1 = this.field_82;
            byte var8 = 0;
            this.field_82 = var8;
            switch(var1) {
            case 1:
               this.method_117();
               this.field_81 = false;
               return true;
            case 2:
               this.method_119();
               this.field_81 = false;
               this.method_83(Hero.self.getPositionX(), Hero.self.getPositionY(), true);
               return true;
            case 3:
               StrategicScreen var6 = this;

               try {
                  var10000 = new OutputGameMessage(MessageProcessor.packetTypes[29], (short)3, MessageProcessor.packetTypes[21], true);
                  OutputGameMessage var7 = var10000;
                  if(var6.heroPosiyionX == 0) { //лево
                     var7.addToBody((byte)8);
                  } else if(var6.heroPositionY == 0) { //верх
                     var7.addToBody((byte)9);
                  } else if(var6.heroPosiyionX == 49) { //право
                     var7.addToBody((byte)10);
                  } else {
                     var7.addToBody((byte)11); //низ
                  }

                  var7.addToBody(var6.heroPosiyionX);
                  var7.addToBody(var6.heroPositionY);
                  Screen.field_24 = true;
                  SocketListener.self.sendCommand(var7);
               } catch (Exception var4) {
                  SocketListener.logMessage(var4.getMessage());
               }

               this.field_81 = false;
               return true;
            case 4:
               this.method_116();
               this.field_81 = false;
               return true;
            }
         }

         return false;
      } catch (Exception var5) {
         SocketListener.logMessage("heroMotionEnd" + var5.toString());
         return false;
      }
   }

   // $FF: renamed from: c (javax.microedition.lcdui.Graphics) void
   private void method_87(Graphics var1) {
      try {
         Hero var2 = Hero.self;
         synchronized(Hero.self) {
            if(this.field_78 != null && this.field_78.length > 0 && !Hero.self.method_888() && this.field_79 < this.field_78.length) {
               for(byte var5 = 0; var5 < this.field_78.length; ++var5) {
                  if(this.field_78[var5][0] != Hero.self.getPositionX() || this.field_78[var5][1] != Hero.self.getPositionY()) {
                     short var3 = (short)(this.field_78[var5][0] * 50 + 8 - field_60);
                     short var4 = (short)(this.field_78[var5][1] * 50 + 8 - field_61);
                     Screen.method_46(var1, (byte)13, var3, var4, 0);
                  }
               }
            }
         }
      } catch (Exception var7) {
         SocketListener.logMessage("drawHeroWay: " + var7.getMessage());
      }

   }

   // $FF: renamed from: a (byte, byte, byte, byte) byte
   private static final byte method_88(byte var0, byte var1, byte var2, byte var3) {
      return GlobalStorage.method_721(var1) < GlobalStorage.method_721(var3)?-1:(GlobalStorage.method_721(var1) > GlobalStorage.method_721(var0) && GlobalStorage.method_721(var1) > GlobalStorage.method_721(var2)? GlobalStorage.method_720(var1):-1);
   }

   // $FF: renamed from: a (byte, byte) byte
   private static final byte method_89(byte var0, byte var1) {
      return GlobalStorage.method_721(var0) <= GlobalStorage.method_721(var1) && (GlobalStorage.method_721(var0) != 6 && GlobalStorage.method_721(var0) != 7 || GlobalStorage.method_721(var1) != 8 && GlobalStorage.method_721(var1) != 9)?-1: GlobalStorage.method_720(var0);
   }

   // $FF: renamed from: a (byte, byte, byte) byte
   private static final byte method_90(byte var0, byte var1, byte var2) {
      return (GlobalStorage.method_721(var1) != GlobalStorage.method_721(var0) || GlobalStorage.method_721(var0) <= GlobalStorage.method_721(var2)) && (GlobalStorage.method_721(var1) != GlobalStorage.method_721(var0) || GlobalStorage.method_721(var2) != 8 && GlobalStorage.method_721(var2) != 9 || GlobalStorage.method_721(var0) != 6 && GlobalStorage.method_721(var0) != 7)?-1: GlobalStorage.method_720(var0);
   }

   // $FF: renamed from: b (byte, byte, byte, byte) byte
   private static final byte method_91(byte var0, byte var1, byte var2, byte var3) {
      boolean var4;
      return (!(var4 = GlobalStorage.method_721(var0) == GlobalStorage.method_721(var1) && GlobalStorage.method_721(var1) == GlobalStorage.method_721(var2)) || GlobalStorage.method_721(var2) <= GlobalStorage.method_721(var3)) && (!var4 || GlobalStorage.method_721(var2) != 6 && GlobalStorage.method_721(var2) != 7 || GlobalStorage.method_721(var2) != 8 && GlobalStorage.method_721(var2) != 9)?-1: GlobalStorage.method_720(var0);
   }

   // $FF: renamed from: a (byte, byte, byte, byte, byte) byte
   private static final byte method_92(byte var0, byte var1, byte var2, byte var3, byte var4) {
      return GlobalStorage.method_721(var0) == GlobalStorage.method_721(var1) && GlobalStorage.method_721(var1) == GlobalStorage.method_721(var2) && GlobalStorage.method_721(var2) == GlobalStorage.method_721(var3) && GlobalStorage.method_721(var3) > GlobalStorage.method_721(var4)? GlobalStorage.method_720(var0):-1;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, byte, byte[], short, short, byte) void
   private static final void method_93(Graphics var0, byte var1, byte[] var2, short var3, short var4, byte var5) {
      byte var6 = var2[var1];
      var5 = GlobalStorage.method_720(var5);
      if(var6 != var5) {
         short var7 = 0;
         switch(var1) {
         case 12:
            var2[4] = var2[8] = var2[11] = -1;
            var2[5] = var2[7] = -1;
            var7 = 100;
            break;
         case 13:
            var2[5] = var2[8] = var2[9] = -1;
            var2[4] = var2[6] = -1;
            var7 = 0;
            break;
         case 14:
            var2[6] = var2[9] = var2[10] = -1;
            var2[5] = var2[7] = -1;
            var7 = 150;
            break;
         case 15:
            var2[7] = var2[11] = var2[10] = -1;
            var2[4] = var2[6] = -1;
            var7 = 50;
         }

         Image var8 = GlobalStorage.method_724(var6, var5, var1);
         ScreenDrawer.method_369(var0, var3, var4, 50, 50);
         ScreenDrawer.method_372(var0, var8, var7, 100, 50, 50, 0, var3, var4, 0);
         ScreenDrawer.method_369(var0, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
      }
   }

   // $FF: renamed from: b (javax.microedition.lcdui.Graphics, byte, byte[], short, short, byte) void
   private static final void method_94(Graphics var0, byte var1, byte[] var2, short var3, short var4, byte var5) {
      byte var6 = var2[var1];
      var5 = GlobalStorage.method_720(var5);
      if(var6 != var5) {
         short var7 = 0;
         byte var8 = 0;
         switch(var1) {
         case 8:
            if(var6 == 10) {
               var2[0] = -1;
            }

            var7 = 150;
            var8 = 50;
            break;
         case 9:
            if(var6 == 10) {
               var2[1] = -1;
            }

            var7 = 100;
            var8 = 50;
            break;
         case 10:
            if(var6 == 10) {
               var2[2] = -1;
            }

            var7 = 100;
            var8 = 0;
            break;
         case 11:
            if(var6 == 10) {
               var2[3] = -1;
            }

            if(var6 >= 6 && var6 != 9 && var6 != 8) {
               var2[3] = -1;
               var2[0] = -1;
            }

            var7 = 150;
            var8 = 0;
         }

         Image var9 = GlobalStorage.method_724(var6, var5, var1);
         ScreenDrawer.method_369(var0, var3, var4, 50, 50);
         ScreenDrawer.method_372(var0, var9, var7, var8, 50, 50, 0, var3, var4, 0);
         ScreenDrawer.method_369(var0, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
      }
   }

   // $FF: renamed from: c (javax.microedition.lcdui.Graphics, byte, byte[], short, short, byte) void
   private static final void method_95(Graphics var0, byte var1, byte[] var2, short var3, short var4, byte var5) {
      byte var6 = var2[var1];
      var5 = GlobalStorage.method_720(var5);
      if(var6 != var5 && var2[var1] >= 0) {
         byte var7 = 0;
         byte var8 = 0;
         byte var9 = 50;
         byte var10 = 50;
         byte var11 = 0;
         byte var12 = 0;
         switch(var1) {
         case 4:
            var8 = 50;
            if(var6 >= 6 && var6 != 9 && var6 != 8) {
               var2[3] = -1;
               var2[0] = -1;
            }

            var9 = 25;
            break;
         case 5:
            var8 = 0;
            var7 = 50;
            var10 = 25;
            break;
         case 6:
            var8 = 50;
            var9 = 25;
            var11 = 25;
            break;
         case 7:
            var7 = 50;
            var10 = 25;
            var12 = 25;
         }

         if(var6 == 6) {
            switch(var1) {
            case 4:
               var8 = 0;
               var7 = 100;
               break;
            case 5:
               var8 = 0;
               var7 = 50;
            case 6:
            default:
               break;
            case 7:
               var8 = 0;
               var7 = 0;
            }

            var9 = 50;
            var10 = 50;
            var11 = 0;
            var12 = 0;
         }

         if(var6 == 7 && var5 != 6) {
            switch(var1) {
            case 4:
               var8 = 0;
               var7 = 50;
            case 5:
            default:
               break;
            case 6:
               var8 = 0;
               var7 = 100;
               break;
            case 7:
               var8 = 0;
               var7 = 0;
            }

            var9 = 50;
            var10 = 50;
            var11 = 0;
            var12 = 0;
         }

         Image var13 = GlobalStorage.method_724(var6, var5, var1);
         ScreenDrawer.method_369(var0, var3 + var11, var4 + var12, var9, var10);
         ScreenDrawer.method_372(var0, var13, var7, var8, 50, 50, 0, var3, var4, 0);
         ScreenDrawer.method_369(var0, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
      }
   }

   // $FF: renamed from: d (javax.microedition.lcdui.Graphics, byte, byte[], short, short, byte) void
   private static final void method_96(Graphics var0, byte var1, byte[] var2, short var3, short var4, byte var5) {
      byte var9 = var2[var1];
      var5 = GlobalStorage.method_720(var5);
      if(var9 != var5) {
         byte var6 = 0;
         byte var7 = 0;
         switch(var1) {
         case 1:
            var6 = 25;
            ++var3;
            break;
         case 2:
            var6 = 25;
            var7 = 25;
            ++var3;
            ++var4;
            break;
         case 3:
            var7 = 25;
            ++var4;
         }

         Image var8 = GlobalStorage.method_724(var9, var5, var1);
         ScreenDrawer.method_369(var0, var3 + var6, var4 + var7, 25, 25);
         ScreenDrawer.method_372(var0, var8, 0, 0, 50, 50, 0, var3, var4, 0);
         ScreenDrawer.method_369(var0, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte, byte) void
   private static final void method_97(Graphics var0, short var1, short var2, byte var3, byte var4) {
      var4 = GlobalStorage.method_720(var4);
      if(var3 != var4) {
         Image var5 = GlobalStorage.method_724(var3, var4, (byte)-1);
         ScreenDrawer.method_369(var0, var1, var2, 50, 50);
         ScreenDrawer.method_372(var0, var5, 50, 50, 50, 50, 0, var1, var2, 0);
         ScreenDrawer.method_369(var0, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte[]) void
   private static final void method_98(Graphics var0, short var1, short var2, byte[] var3) {
      byte var4 = 0;
      if(var1 == 0) {
         var4 = 2;
      } else if(var1 == 49) {
         var4 = 5;
      } else if(var2 == 0) {
         var4 = 1;
      }

      if(var2 == 49) {
         var4 = 6;
      }

      Image var5 = GlobalStorage.getImage(GlobalStorage.method_711("steam.png"));
      int var6 = 0;
      switch(var4) {
      case 1:
         var6 = 1;
         if(!GlobalStorage.method_722(var3[7])) {
            --var6;
         }

         if(!GlobalStorage.method_722(var3[3])) {
            ++var6;
         }
         break;
      case 2:
         var6 = 7;
         if(!GlobalStorage.method_722(var3[5])) {
            --var6;
         }

         if(!GlobalStorage.method_722(var3[1])) {
            ++var6;
         }
      case 3:
      case 4:
      default:
         break;
      case 5:
         var6 = 4;
         if(!GlobalStorage.method_722(var3[5])) {
            --var6;
         }

         if(!GlobalStorage.method_722(var3[1])) {
            ++var6;
         }
         break;
      case 6:
         var6 = 10;
         if(!GlobalStorage.method_722(var3[7])) {
            --var6;
         }

         if(!GlobalStorage.method_722(var3[3])) {
            ++var6;
         }
      }

      short var7 = (short)(ScreenDrawer.method_382(var5) / 12);
      ScreenDrawer.method_372(var0, var5, var7 * var6, 0, var7, ScreenDrawer.method_383(var5), 0, method_99(var1), method_100(var2), 0);
   }

   // $FF: renamed from: a (int) short
   public static final short method_99(int var0) {
      return (short)(var0 * 50 - field_62);
   }

   // $FF: renamed from: b (int) short
   public static final short method_100(int var0) {
      return (short)(var0 * 50 - field_63 - 4);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte, byte[]) void
   private static void method_101(Graphics var0, short var1, short var2, byte var3, byte[] var4) {
      if(GlobalStorage.method_722(var3)) {
         method_98(var0, var1, var2, var4);
      }

      Hero.self.method_883(var0);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int) void
   public static void method_102(Graphics var0, int var1, int var2) {
      field_60 = 300;
      field_61 = 200;
      byte var5;
      if((var5 = (byte)(field_62 / 50)) < 0) {
         var5 = 0;
      }

      byte var6;
      if((var6 = (byte)(field_63 / 50)) < 0) {
         var6 = 0;
      }

      byte var3;
      if((var3 = (byte)(var5 + ScreenDrawer.self.method_327())) >= 50) {
         var3 = 49;
      }

      byte var4;
      if((var4 = (byte)(var6 + ScreenDrawer.self.method_328())) >= 50) {
         var4 = 49;
      }

      method_103(var0, var5, var6, var3, var4);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, byte, byte, byte, byte) void
   private static synchronized void method_103(Graphics var0, byte var1, byte var2, byte var3, byte var4) {
      field_62 = field_60;
      field_63 = field_61;
      byte[] var5 = new byte[8];
      boolean var6 = false;
      byte[] var7 = new byte[16];
      byte var8 = 0;
      byte[] var9 = null;
      Vector var10 = new Vector();

      for(int var11 = 0; var11 < GlobalStorage.method_681(); ++var11) {
         MapObject var12;
         if(GlobalStorage.method_682(var11) != null && (var12 = GlobalStorage.method_682(var11)).method_418() >= var1 - 1 && var12.method_418() <= var3 + 1 && var12.method_419() >= var2 - 1 && var12.method_419() <= var4 + 1) {
            var10.addElement(var12);
         }
      }

      short var32 = 0;
      short var33 = 0;
      short var13 = 0;
      short var14 = 0;
      byte var15 = 0;
      byte var16 = 0;
      byte var17 = 0;
      Vector var18 = new Vector();
      new Vector();
      Image var19 = null;

      short var20;
      for(short var29 = (short)(var3 + 1); var29 >= var1; --var29) {
         if(var29 >= 0 && var29 < 50) {
            for(var20 = (short)var2; var20 <= var4 + 1; ++var20) {
               if(var20 >= 0 && var20 < 50) {
                  boolean var21 = var29 == Hero.self.getPositionX() && var20 == Hero.self.getPositionY();
                  boolean var22 = false;
                  MapObject var23 = null;

                  short var24;
                  for(var24 = 0; var24 < var10.size(); ++var24) {
                     MapObject var25;
                     if((var25 = (MapObject)var10.elementAt(var24)) != null && var25.method_418() == var29 && var25.method_419() == var20) {
                        var23 = var25;
                        break;
                     }
                  }

                  var24 = method_99(var29);
                  short var38 = method_100(var20);
                  byte var31 = GlobalStorage.method_702(var29, var20);
                  var19 = GlobalStorage.method_725();
                  ScreenDrawer.method_369(var0, var24, var38, 50, 50);
                  byte var26 = (byte)(var31 & 15);
                  ScreenDrawer.method_372(var0, var19, var26 * 50, 0, 50, 50, 0, var24, var38, 0);
                  ScreenDrawer.method_369(var0, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
                  if(GlobalStorage.method_720(var31) != 10) {
                     var5[0] = GlobalStorage.method_702((short)(var29 - 1), (short)(var20 - 1));
                     var5[1] = GlobalStorage.method_702(var29, (short)(var20 - 1));
                     var5[2] = GlobalStorage.method_702((short)(var29 + 1), (short)(var20 - 1));
                     var5[3] = GlobalStorage.method_702((short)(var29 + 1), var20);
                     var5[4] = GlobalStorage.method_702((short)(var29 + 1), (short)(var20 + 1));
                     var5[5] = GlobalStorage.method_702(var29, (short)(var20 + 1));
                     var5[6] = GlobalStorage.method_702((short)(var29 - 1), (short)(var20 + 1));
                     var5[7] = GlobalStorage.method_702((short)(var29 - 1), var20);
                     var7[0] = method_88(var5[7], var5[0], var5[1], var31);
                     var7[1] = method_88(var5[1], var5[2], var5[3], var31);
                     var7[2] = method_88(var5[3], var5[4], var5[5], var31);
                     var7[3] = method_88(var5[5], var5[6], var5[7], var31);
                     var7[4] = method_89(var5[7], var31);
                     var7[5] = method_89(var5[1], var31);
                     var7[6] = method_89(var5[3], var31);
                     var7[7] = method_89(var5[5], var31);
                     var7[8] = method_90(var5[7], var5[1], var31);
                     var7[9] = method_90(var5[1], var5[3], var31);
                     var7[10] = method_90(var5[3], var5[5], var31);
                     var7[11] = method_90(var5[5], var5[7], var31);
                     var7[12] = method_91(var5[5], var5[7], var5[1], var31);
                     var7[13] = method_91(var5[7], var5[1], var5[3], var31);
                     var7[14] = method_91(var5[1], var5[3], var5[5], var31);
                     var7[15] = method_91(var5[3], var5[5], var5[7], var31);
                     byte var34;
                     Vector var37;
                     if((var34 = method_92(var5[7], var5[1], var5[3], var5[5], var31)) >= 0) {
                        method_97(var0, var24, var38, var34, var31);
                     } else {
                        for(var26 = 12; var26 <= 15; ++var26) {
                           if(var7[var26] >= 0) {
                              method_93(var0, var26, var7, var24, var38, var31);
                              break;
                           }
                        }

                        for(var26 = 0; var26 < 8; ++var26) {
                           var34 = -1;

                           for(byte var27 = 4; var27 <= 11; ++var27) {
                              if(var7[var27] >= 0 && (!var21 && var23 == null || var7[var27] < 6 || var7[var27] == 9 || var7[var27] == 8) && (var34 < 0 || var7[var27] < var7[var34])) {
                                 var34 = var27;
                              }
                           }

                           if(var34 < 0 || var7[var34] < 0) {
                              break;
                           }

                           if(var34 >= 4 && var34 <= 7) {
                              method_95(var0, var34, var7, var24, var38, var31);
                           } else {
                              method_94(var0, var34, var7, var24, var38, var31);
                           }

                           var7[var34] = -1;
                        }

                        if((var26 = GlobalStorage.method_697(var29, var20)) != -1) {
                           int var36 = (var26 & 192) >> 6;
                           var26 = (byte)(var26 & 63);
                           short var39 = -1;
                           switch(GlobalStorage.method_720(GlobalStorage.method_702(var29, var20))) {
                           case 1:
                              var39 = field_70;
                              break;
                           case 2:
                              var39 = field_71;
                              break;
                           case 3:
                              var39 = field_72;
                              break;
                           case 4:
                              var39 = field_73;
                              break;
                           case 5:
                              var39 = field_74;
                           case 6:
                           case 7:
                           default:
                              break;
                           case 8:
                              var39 = field_76;
                              break;
                           case 9:
                              var39 = field_75;
                           }

                           if(var26 >= ScreenDrawer.method_377(var39) / 50) {
                              var39 = -1;
                           }

                           if(var39 != -1) {
                              ScreenDrawer.method_374(var0, var39, var26 * 50, var36 * 50, 50, 50, 0, var24, var38, 0);
                           }
                        }

                        if(var23 != null || var21) {
                           method_95(var0, (byte)4, var7, var24, var38, var31);
                           method_95(var0, (byte)5, var7, var24, var38, var31);
                           method_95(var0, (byte)6, var7, var24, var38, var31);
                           method_94(var0, (byte)8, var7, var24, var38, var31);
                           method_94(var0, (byte)9, var7, var24, var38, var31);
                           if(var23 != null) {
                              (var37 = new Vector()).addElement(var23);
                              var37.addElement(new short[]{var24});
                              var37.addElement(new short[]{var38});
                              var37.addElement(new byte[]{var7[7]});
                              var37.addElement(new byte[]{var7[11]});
                              var37.addElement(new byte[]{var7[10]});
                              var37.addElement(new byte[]{var31});
                              var18.addElement(var37);
                              var23 = null;
                           }

                           if(var21) {
                              var32 = var29;
                              var33 = var20;
                              var8 = var31;
                              var9 = var5;
                              var13 = var24;
                              var14 = var38;
                              var16 = var7[7];
                              var15 = var7[11];
                              var17 = var7[10];
                              var22 = true;
                              var21 = false;
                           }

                           method_95(var0, (byte)7, var7, var24, var38, var31);
                           method_94(var0, (byte)11, var7, var24, var38, var31);
                           method_94(var0, (byte)10, var7, var24, var38, var31);
                        }
                     }

                     for(var26 = 0; var26 <= 3; ++var26) {
                        if(var7[var26] >= 0) {
                           if(var23 != null && (var7[var26] == 6 || var7[var26] == 7)) {
                              (var37 = new Vector()).addElement(var23);
                              var37.addElement(new short[]{var24});
                              var37.addElement(new short[]{var38});
                              var37.addElement(new byte[]{var7[7]});
                              var37.addElement(new byte[]{var7[11]});
                              var37.addElement(new byte[]{var7[10]});
                              var37.addElement(new byte[]{var31});
                              var18.addElement(var37);
                              var23 = null;
                           }

                           if(var21 && (var7[var26] == 6 || var7[var26] == 7)) {
                              var32 = var29;
                              var33 = var20;
                              var8 = var31;
                              var9 = var5;
                              var13 = var24;
                              var14 = var38;
                              var16 = var7[7];
                              var15 = var7[11];
                              var17 = var7[10];
                              var22 = true;
                              var21 = false;
                           }

                           method_96(var0, var26, var7, var24, var38, var31);
                        }
                     }

                     if(var23 != null) {
                        (var37 = new Vector()).addElement(var23);
                        var37.addElement(new short[]{var24});
                        var37.addElement(new short[]{var38});
                        var37.addElement(new byte[]{var7[7]});
                        var37.addElement(new byte[]{var7[11]});
                        var37.addElement(new byte[]{var7[10]});
                        var37.addElement(new byte[]{var31});
                        var18.addElement(var37);
                     }

                     if(var21) {
                        var32 = var29;
                        var33 = var20;
                        var8 = var31;
                        var9 = var5;
                        var13 = var24;
                        var14 = var38;
                        var16 = var7[7];
                        var15 = var7[11];
                        var17 = var7[10];
                        var22 = true;
                     }

                     if(!var22 && GlobalStorage.method_722(var31)) {
                        method_98(var0, var29, var20, var5);
                     }
                  }
               }
            }
         }
      }

      byte[] var30 = new byte[16];

      for(int var35 = 0; var35 < var18.size(); ++var35) {
         ((MapObject)((Vector)var18.elementAt(var35)).elementAt(0)).method_415(var0);
         var30[7] = ((byte[])((Vector)var18.elementAt(var35)).elementAt(3))[0];
         method_95(var0, (byte)7, var30, ((short[])((Vector)var18.elementAt(var35)).elementAt(1))[0], ((short[])((Vector)var18.elementAt(var35)).elementAt(2))[0], ((byte[])((Vector)var18.elementAt(var35)).elementAt(6))[0]);
         var30[11] = ((byte[])((Vector)var18.elementAt(var35)).elementAt(4))[0];
         method_94(var0, (byte)11, var30, ((short[])((Vector)var18.elementAt(var35)).elementAt(1))[0], ((short[])((Vector)var18.elementAt(var35)).elementAt(2))[0], ((byte[])((Vector)var18.elementAt(var35)).elementAt(6))[0]);
         var30[10] = ((byte[])((Vector)var18.elementAt(var35)).elementAt(5))[0];
         method_94(var0, (byte)10, var30, ((short[])((Vector)var18.elementAt(var35)).elementAt(1))[0], ((short[])((Vector)var18.elementAt(var35)).elementAt(2))[0], ((byte[])((Vector)var18.elementAt(var35)).elementAt(6))[0]);
      }

      var30 = new byte[16];
      method_101(var0, var32, var33, var8, var9);
      var30[7] = var16;
      method_95(var0, (byte)7, var30, var13, var14, var8);
      var30[11] = var15;
      method_94(var0, (byte)11, var30, var13, var14, var8);
      var30[10] = var17;
      method_94(var0, (byte)10, var30, var13, var14, var8);

      for(var20 = 0; var20 < var10.size(); ++var20) {
         if(var10.elementAt(var20) != null) {
            ((MapObject)var10.elementAt(var20)).method_416(var0);
         }
      }

      Hero.self.method_934(var0);
   }

   // $FF: renamed from: a () short
   private synchronized short method_104() {
      return (short)(this.heroPosiyionX * 50 + 25);
   }

   // $FF: renamed from: b () short
   private synchronized short method_105() {
      return (short)(this.heroPositionY * 50 + 25);
   }

   // $FF: renamed from: a (short, byte[][], byte) short
   private static final short method_106(short var0, byte[][] var1, byte var2) {
      if(var1 == null) {
         return (short)-1;
      } else {
         byte var3 = (byte)((var1.length - 1) / 2);
         return (short)(var0 - var2 + var3);
      }
   }

   // $FF: renamed from: b (short, byte[][], byte) short
   private static final short method_107(short var0, byte[][] var1, byte var2) {
      if(var1 != null && var1[0] != null) {
         byte var3 = (byte)((var1[0].length - 1) / 2);
         return (short)(var0 - var2 + var3);
      } else {
         return (short)-1;
      }
   }

   // $FF: renamed from: a (short) short
   private synchronized short method_108(short var1) {
      return method_106(var1, this.field_77, Hero.self.getPositionX());
   }

   // $FF: renamed from: b (short) short
   private synchronized short method_109(short var1) {
      return method_107(var1, this.field_77, Hero.self.getPositionY());
   }

   // $FF: renamed from: a () void
   public final synchronized void method_51() {
      if(!super.popupMenu.method_611()) {
         if(!this.field_81) {
            this.field_80 = -1;
         }

         super.popupMenu.method_617(true, false);
         if((this.field_78 == null || this.field_78 != null && this.field_79 > this.field_78.length + 1) && Hero.self.method_888()) {
            Hero.self.method_887(false);
         }

         if(!Hero.self.method_888()) {
            if(Math.abs(Hero.self.getPositionX() - this.heroPosiyionX) > method_112()) {
               this.method_43((byte)10);
            } else if(Math.abs(Hero.self.getPositionY() - this.heroPositionY) > method_113()) {
               this.method_43((byte)10);
            } else {
               byte var1;
               if(!GlobalStorage.method_709(GlobalStorage.method_702((short)this.heroPosiyionX, (short)this.heroPositionY))) {
                  var1 = 10;
               } else if(this.field_77 != null && this.field_77[this.method_108((short)this.heroPosiyionX)][this.method_109((short)this.heroPositionY)] == 127) {
                  var1 = 10;
               } else {
                  var1 = 9;
               }

               MapObject mapObject = GlobalStorage.method_684(this.heroPosiyionX, this.heroPositionY, true);
               if(this.field_78 != null && mapObject != null) {
                  super.popupMenu.method_622(mapObject.getActions(), false);
                  switch(mapObject.getType()) {
                  case 1:
                     if(mapObject.method_427() != 2) {
                        var1 = 10;
                     } else {
                        var1 = -3;
                     }
                     break;
                  case 3:
                     var1 = -4;
                     break;
                  default:
                     var1 = -2;
                  }

                  if(!this.field_81) {
                     this.field_80 = GlobalStorage.method_685(mapObject);
                  }
               } else if(var1 == 9) {
                  if(Hero.self.getPositionX() == this.heroPosiyionX && Hero.self.getPositionY() == this.heroPositionY) {
                     super.popupMenu.method_600((byte)85, false);
                     super.popupMenu.method_600((byte)87, false);
                     super.popupMenu.method_600((byte)88, false);
                     super.popupMenu.method_600((byte)102, false);
                     Button[] var4 = Hero.self.method_929();

                     for(byte var3 = 0; var4 != null && var3 < var4.length; ++var3) {
                        super.popupMenu.method_594(true, var4[var3]);
                        var4[var3].method_648(true);
                     }

                     var1 = -3;
                  } else if(GlobalStorage.method_722(GlobalStorage.method_702((short)this.heroPosiyionX, (short)this.heroPositionY))) {
                     var1 = -2;
                     super.popupMenu.method_600((byte)8, false);
                  } else {
                     super.popupMenu.method_600((byte)1, false);
                  }
               }

               this.method_43(var1);
            }
         }
      }
   }

   // $FF: renamed from: a (byte, byte, byte, byte) byte[][]
   public static final byte[][] method_110(byte var0, byte var1, byte var2, byte var3) {
      try {
         if(!GlobalStorage.method_698()) {
            return null;
         } else {
            byte[][] var11 = new byte[(field_56 << 1) + 1][(field_57 << 1) + 1];
            boolean var7 = true;
            var3 = (byte)(field_57 / field_56 * 127);

            short var4;
            for(var4 = 0; var4 < 2 * field_56 + 1; ++var4) {
               for(short var5 = 0; var5 < 2 * field_57 + 1; ++var5) {
                  var11[var4][var5] = var3;
               }
            }

            var11[field_56][field_57] = 0;
            int var13 = 0;

            while(var13++ < field_58) {
               for(short var12 = 0; var12 < 2 * field_56 + 1; ++var12) {
                  for(var4 = 0; var4 < 2 * field_57 + 1; ++var4) {
                     if(var12 != field_56 || var4 != field_57) {
                        byte var8;
                        short var15;
                        if(var11 == null) {
                           var15 = -1;
                        } else {
                           var8 = (byte)((var11.length - 1) / 2);
                           var15 = (short)(var0 + var12 - var8);
                        }

                        short var6 = var15;
                        if(var11 != null && var11[0] != null) {
                           var8 = (byte)((var11[0].length - 1) / 2);
                           var15 = (short)(var1 + var4 - var8);
                        } else {
                           var15 = -1;
                        }

                        short var14 = var15;
                        if(var6 >= 0 && var6 < 50 && var14 >= 0 && var14 < 50 && GlobalStorage.method_709(GlobalStorage.method_702((byte)var6, (byte)var14))) {
                           var8 = (byte)(var13 - 1);
                           byte var9 = var11[var12][var4];
                           if(var6 > 0 && var12 > 0 && GlobalStorage.method_709(GlobalStorage.method_702((byte)(var6 - 1), (byte)var14)) && var11[var12 - 1][var4] == var8) {
                              var9 = var11[var12 - 1][var4];
                           }

                           if(var6 < 49 && var12 < var11.length - 1 && GlobalStorage.method_709(GlobalStorage.method_702((byte)(var6 + 1), (byte)var14)) && var11[var12 + 1][var4] == var8) {
                              var9 = var11[var12 + 1][var4];
                           }

                           if(var14 > 0 && var4 > 0 && GlobalStorage.method_709(GlobalStorage.method_702((byte)var6, (byte)(var14 - 1))) && var11[var12][var4 - 1] == var8) {
                              var9 = var11[var12][var4 - 1];
                           }

                           if(var14 < 49 && var4 < var11[0].length - 1 && GlobalStorage.method_709(GlobalStorage.method_702((byte)var6, (byte)(var14 + 1))) && var11[var12][var4 + 1] == var8) {
                              var9 = var11[var12][var4 + 1];
                           }

                           if(var9 < 127 && var9 < var11[var12][var4] - 1) {
                              var11[var12][var4] = (byte)(var9 + 1);
                           }
                        }
                     }
                  }
               }
            }

            return var11;
         }
      } catch (Exception var10) {
         SocketListener.logMessage("getWaveMatrix: " + var10.getMessage());
         return null;
      }
   }

   // $FF: renamed from: b () void
   public final synchronized void createWaveMatrix() {
      this.field_77 = method_110(Hero.self.getPositionX(), Hero.self.getPositionY(), method_112(), method_113());
   }

   // $FF: renamed from: b () byte
   private static byte method_112() {
      return (byte)Math.min(field_56, ScreenDrawer.self.method_327());
   }

   // $FF: renamed from: c () byte
   private static byte method_113() {
      return (byte)Math.min(field_57, ScreenDrawer.self.method_328());
   }

   // $FF: renamed from: a (byte, byte, byte[][], byte, byte) byte[][]
   public static final byte[][] method_114(byte var0, byte var1, byte[][] var2, byte var3, byte var4) {
      if(!GlobalStorage.method_698()) {
         return null;
      } else if(var3 >= 0 && var4 >= 0) {
         MapObject var5;
         if((var5 = GlobalStorage.method_683(var3, var4)) != null && var5.method_414()) {
            return null;
         } else if(var3 < 50 && var4 < 50) {
            if(var2 == null) {
               return null;
            } else if(GlobalStorage.method_708(GlobalStorage.method_702((short)var3, (short)var4))) {
               return null;
            } else {
               short var9 = method_106((short)var3, var2, var0);
               short var6 = method_107((short)var4, var2, var1);
               if(var9 >= 0 && var6 >= 0) {
                  if(var9 < var2.length && var6 < var2[0].length) {
                     if(var2[var9][var6] == 127) {
                        return null;
                     } else {
                        byte[][] var10;
                        if((var10 = new byte[var2[var9][var6] + 1][2]).length == 0) {
                           return null;
                        } else {
                           var10[var10.length - 1][0] = var3;
                           var10[var10.length - 1][1] = var4;

                           for(int var7 = var10.length - 2; var7 >= 0; --var7) {
                              short var8 = method_106((short)var10[var7 + 1][0], var2, var0);
                              var6 = method_107((short)var10[var7 + 1][1], var2, var1);
                              if(var8 >= 0 && var6 >= 0) {
                                 if(var8 > 0 && var2[var8 - 1][var6] < var2[var8][var6]) {
                                    var10[var7][0] = (byte)(var10[var7 + 1][0] - 1);
                                    var10[var7][1] = var10[var7 + 1][1];
                                 } else if(var8 + 1 < var2.length && var2[var8 + 1][var6] < var2[var8][var6]) {
                                    var10[var7][0] = (byte)(var10[var7 + 1][0] + 1);
                                    var10[var7][1] = var10[var7 + 1][1];
                                 } else if(var6 > 0 && var2[var8][var6 - 1] < var2[var8][var6]) {
                                    var10[var7][1] = (byte)(var10[var7 + 1][1] - 1);
                                    var10[var7][0] = var10[var7 + 1][0];
                                 } else if(var6 + 1 < var2[0].length && var2[var8][var6 + 1] < var2[var8][var6]) {
                                    var10[var7][1] = (byte)(var10[var7 + 1][1] + 1);
                                    var10[var7][0] = var10[var7 + 1][0];
                                 }
                              }
                           }

                           var10[0][0] = var0;
                           var10[0][1] = var1;
                           return var10;
                        }
                     }
                  } else {
                     return null;
                  }
               } else {
                  return null;
               }
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   // $FF: renamed from: a (byte, byte) byte[][]
   private synchronized byte[][] method_115(byte var1, byte var2) {
      byte[][] var3;
      if((var3 = method_114(Hero.self.getPositionX(), Hero.self.getPositionY(), this.field_77, var1, var2)) != null && var3.length > 1) {
         byte[][] var4 = new byte[var3.length - 1][2];
         System.arraycopy(var3, 1, var4, 0, var4.length);
         return var4;
      } else {
         return null;
      }
   }

   // $FF: renamed from: f () boolean
   private boolean method_116() {
      try {
         MapObject var1 = GlobalStorage.method_682(this.field_80);

         try {
            if(var1 != null) {
               OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[74], (short)0, MessageProcessor.packetTypes[9]);
               OutputGameMessage var2 = var10000;
               var10000.addToBody(var1.method_417());
               SocketListener.self.sendCommand(var2);
               return true;
            }
         } catch (Exception var3) {
            ;
         }

         Screen.field_24 = false;
         return false;
      } catch (Exception var4) {
         return false;
      }
   }

   // $FF: renamed from: g () boolean
   private boolean method_117() {
      try {
         MapObject var1 = GlobalStorage.method_682(this.field_80);

         try {
            if(var1 != null) {
               short var2 = 0;
               if(var1.getType() != 3 && var1.getType() != 4) {
                  if(var1.getType() == 2) {
                     var2 = MessageProcessor.packetTypes[10];
                  } else if(var1.getType() == 5) {
                     var2 = MessageProcessor.packetTypes[8];
                  }
               } else {
                  var2 = MessageProcessor.packetTypes[7];
               }

               OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[10], (short)4, var2);
               OutputGameMessage var5 = var10000;
               var10000.addToBody(var1.method_417());
               SocketListener.self.sendCommand(var5);
               return true;
            }
         } catch (Exception var3) {
            var3.printStackTrace();
         }

         Screen.field_24 = false;
         return false;
      } catch (Exception var4) {
         return false;
      }
   }

   // $FF: renamed from: h () boolean
   private boolean method_118() {
      MapObject var1;
      if((var1 = GlobalStorage.method_682(this.field_80)) == null) {
         return false;
      } else {
         try {
            Main2.self.field_664 = var1.method_417();
            Main2.self.changeForm((byte)6);
         } catch (Exception var2) {
            SocketListener.logMessage(var2.getMessage());
         }

         return true;
      }
   }

   // $FF: renamed from: i () boolean
   private boolean method_119() {
      MapObject var1;
      if((var1 = GlobalStorage.method_682(this.field_80)) == null) {
         return false;
      } else {
         try {
            boolean var10000;
            label45: {
               StrategicScreen var2 = this;
               if(GlobalStorage.method_681() > 0) {
                  for(short var3 = 0; var3 < GlobalStorage.method_681(); ++var3) {
                     MapObject var4;
                     if((var4 = GlobalStorage.method_682(var3)) != null && var4.getType() == 2) {
                        byte var5 = (byte)Math.abs(var2.heroPosiyionX - var4.method_418());
                        byte var8 = (byte)Math.abs(var2.heroPositionY - var4.method_419());
                        if(var5 >= 0 && var8 >= 0 && var5 <= field_59 && var8 <= field_59) {
                           var10000 = true;
                           break label45;
                        }
                     }
                  }
               }

               var10000 = false;
            }

            if(var10000) {
               ScreenDrawer.method_330(MessagesContainer.getMessage(135), MessagesContainer.getMessage(166));
               return true;
            }

            OutputGameMessage var9 = new OutputGameMessage(MessageProcessor.packetTypes[33], (short)4, MessageProcessor.packetTypes[6]);
            OutputGameMessage var7 = var9;
            Hero.self.field_688 = var1.method_417();
            var7.addToBody(var1.method_417());
            SocketListener.self.sendCommand(var7);
            this.method_43((byte)-1);
         } catch (Exception var6) {
            SocketListener.logMessage(var6.getMessage());
         }

         return true;
      }
   }

   // $FF: renamed from: a (byte) boolean
   private boolean method_120(byte var1) {
      if(var1 != 0) {
         this.field_81 = true;
      }

      Screen.field_24 = true;
      this.method_43((byte)-1);
      this.field_82 = var1;
      short var3 = (short)this.heroPosiyionX;
      short var2 = (short)this.heroPositionY;
      if((var3 != Hero.self.getPositionX() || var2 != Hero.self.getPositionY()) && this.field_78 != null) {
         this.field_77 = null;
         Hero.self.method_887(true);
         return true;
      } else {
         return true;
      }
   }

   // $FF: renamed from: g () void
   public final void helpViewInit() {
      super.helpViewInit();

      try {
         this.createWaveMatrix();
      } catch (Exception var2) {
         SocketListener.method_522("reset strategical screen: " + var2.getMessage(), false);
      }

      this.method_43((byte)9);
   }

   // $FF: renamed from: a (byte, byte) boolean
   public final boolean method_121(byte by, byte by2) {
      if (this.field_78 == null || !Hero.self.method_888()) {
         return false;
      }
      Hero b2 = Hero.self;
      synchronized (b2) {
         for (int n2 = 0; n2 < this.field_78.length; n2 = ((short)(n2 + 1))) {
            if (this.field_78[n2][0] != by || this.field_78[n2][1] != by2) continue;
            return true;
         }
      }
      return false;
   }

   // $FF: renamed from: c () void
   public static void method_122() {
      if(!GlobalStorage.method_709(GlobalStorage.method_702((short) Hero.self.getPositionX(), (short) Hero.self.getPositionY()))) {
         for(byte var0 = 1; var0 < 3; ++var0) {
            for(byte var1 = (byte)(Hero.self.getPositionX() - var0); var1 < Hero.self.getPositionX() + var0; ++var1) {
               for(byte var2 = (byte)(Hero.self.getPositionY() - var0); var2 < Hero.self.getPositionY() + var0; ++var2) {
                  if(GlobalStorage.method_709(GlobalStorage.method_702((short) Hero.self.getPositionX(), (short) Hero.self.getPositionY())) && GlobalStorage.method_701((short) Hero.self.getPositionX(), (short) Hero.self.getPositionY())) {
                     Hero.self.setCoords(var1, var2);
                     return;
                  }
               }
            }
         }

      }
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      Screen.field_36 = var1;
      Screen.field_37 = var2;
      field_67 = true;
      Screen.field_38 = true;
      Screen.field_34 = var1;
      Screen.field_35 = var2;
      if(Hero.self != null && !Hero.self.method_888()) {
         this.heroPosiyionX = (byte)((field_60 + var1) / 50);
         this.heroPositionY = (byte)((field_61 + var2) / 50);
         this.method_81();
         this.method_51();
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: b (int, int) boolean
   protected final boolean method_62(int var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      if(field_67) {
         int var5 = var1 - Screen.field_36;
         int var6 = var2 - Screen.field_37;
         if(field_60 - var5 >= 0 && field_60 - var5 <= 2500 - ScreenDrawer.self.getWidth()) {
            field_60 -= var5;
         }

         if(field_61 - var6 >= 0 && field_61 - var6 <= 2500 - ScreenDrawer.self.getHeight() + PopupMenu.method_583()) {
            field_61 -= var6;
         }

         if(field_60 - var5 < 0 && var5 < 0) {
            field_60 -= var5;
         }

         if(field_60 - var5 > 2500 - ScreenDrawer.self.getWidth() && var5 > 0) {
            field_60 -= var5;
         }

         if(field_61 - var6 < 0 && var6 < 0) {
            field_61 -= var6;
         }

         if(field_61 - var6 > 2500 - ScreenDrawer.self.getHeight() + PopupMenu.method_583() && var6 > 0) {
            field_61 -= var6;
         }

         Screen.field_36 = var1;
         Screen.field_37 = var2;
         if(Math.abs(Screen.field_36 - Screen.field_34) > 25 || Math.abs(Screen.field_37 - Screen.field_35) > 25) {
            Screen.field_38 = false;
         }
      }

      return true;
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      field_67 = false;
      if(Screen.field_38 && Hero.self != null && !Hero.self.method_888()) {
         this.method_51();
         if(!PopupMenu.method_624(var1, var2) && !PopupMenu.method_625(var1, var2)) {
            this.method_36();
         }

         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: a (int, int, int) boolean
   protected final boolean method_61(int var1, int var2, int var3) {
      return false;
   }

   // $FF: renamed from: b () int
   public static int method_123() {
      return field_62;
   }

   // $FF: renamed from: c () int
   public static int method_124() {
      return field_63;
   }

   // $FF: renamed from: a (int, int) byte
   private static byte method_125(int var0, int var1) {
      byte var2 = -1;
      int var3 = ScreenDrawer.self.getWidth();
      int var4 = ScreenDrawer.self.getHeight() - PopupMenu.method_583();
      var0 = var0 - field_62 - 25;
      var1 = var1 - field_63 - 25;
      if(var0 >= 0 && var0 < var3 / 2 && var1 >= 0 && var1 < var4 / 2) {
         var2 = 0;
      }

      if(var0 >= var3 / 2 && var0 < var3 - 100 && var1 >= 0 && var1 < var4 / 2) {
         var2 = 1;
      }

      if(var0 >= 0 && var0 < var3 / 2 && var1 >= var4 / 2 && var1 < var4 - 100) {
         var2 = 2;
      }

      if(var0 >= var3 / 2 && var0 < var3 - 100 && var1 >= var4 / 2 && var1 < var4 - 100) {
         var2 = 3;
      }

      return var2;
   }

   // $FF: renamed from: e (int) void
   public static void method_126(int var0) {
      field_83 = (byte)(var0 * 10);
      field_84 = 10 / field_83;
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_56 = 15;
      field_57 = 15;
      field_58 = 25;
      field_59 = 5;
      field_64 = -1;
      field_65 = false;
      field_66 = false;
      field_70 = -1;
      field_71 = -1;
      field_72 = -1;
      field_73 = -1;
      field_74 = -1;
      field_75 = -1;
      field_76 = -1;
      field_83 = 10;
      field_84 = 10 / field_83;
   }
}
