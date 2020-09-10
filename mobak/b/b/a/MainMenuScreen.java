package mobak.b.b.a;

import java.util.Random;
import javax.microedition.lcdui.Graphics;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.StrategicScreen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.MapObject;
import mobak.c.class_62;
import mobak.c.MessagesContainer;
import mobak.c.RMSManager;

// $FF: renamed from: mobak.b.b.a.f
public final class MainMenuScreen extends MenuScreen {

   // $FF: renamed from: a java.lang.String[]
   private static final String[] field_122;
   // $FF: renamed from: b java.lang.String[]
   private static final String[] field_123;
   // $FF: renamed from: a int[]
   private static final int[] field_124;
   // $FF: renamed from: d java.lang.String
   private static String field_125;
   // $FF: renamed from: c byte
   protected byte mainMenuType;
   // $FF: renamed from: a boolean
   private boolean field_127;
   // $FF: renamed from: a java.lang.String[][]
   String[][] field_128;
   // $FF: renamed from: a short[]
   short[] field_129;
   // $FF: renamed from: j mobak.c.a
   private class_62 field_130;
   // $FF: renamed from: d byte
   protected byte field_131;
   // $FF: renamed from: e byte
   protected byte field_132;
   // $FF: renamed from: a long[]
   private long[] field_133;
   // $FF: renamed from: f byte
   private byte field_134;
   // $FF: renamed from: g byte
   private byte field_135;
   // $FF: renamed from: d boolean
   private boolean field_136;
   // $FF: renamed from: g boolean
   private boolean field_137;
   // $FF: renamed from: h boolean
   private boolean field_138;
   // $FF: renamed from: i boolean
   private boolean field_139;
   // $FF: renamed from: j boolean
   private boolean field_140;
   // $FF: renamed from: b long
   private long field_141;
   // $FF: renamed from: k short
   private short field_142;
   // $FF: renamed from: l short
   private short field_143;


   // $FF: renamed from: <init> (short) void
   public MainMenuScreen(short var1) {
      super();
      this.field_127 = false;
      this.field_131 = -1;
      this.field_132 = -1;
      this.field_134 = 0;
      this.field_135 = 0;
      this.field_136 = false;
      this.field_137 = false;
      this.field_138 = false;
      this.field_139 = false;
      super.field_117 = Screen.nameOfMap;
      super.field_52 = var1;
      this.field_130 = Screen.field_30;
      super.raceId = (byte)(Math.abs((new Random()).nextInt()) % 5);
      this.field_142 = GlobalStorage.method_711("logo-240.gif");
      this.field_143 = GlobalStorage.method_711("split.gif");
   }

   // $FF: renamed from: c (int) void
   protected final void method_39(int var1) {
      var1 = ScreenDrawer.self.getGameAction(var1);
      if(this.mainMenuType == 5) {
         String var2 = field_125;
         synchronized(field_125) {
            if(var1 == 6) {
               if(this.field_139) {
                  ++this.field_135;
               }

               return;
            }

            if(var1 == 1) {
               if(this.field_138) {
                  --this.field_135;
               }

               return;
            }

            if(var1 == 2) {
               if(this.field_136) {
                  --this.field_134;
               }

               return;
            }

            if(var1 == 5) {
               if(this.field_137) {
                  ++this.field_134;
               }

               return;
            }
         }
      } else {
         int var3;
         if(var1 == 6) {
            if(this.field_132 < this.field_128[this.field_131].length - 1) {
               var3 = this.field_132 + 1;
               this.method_161(var3, false);
            } else {
               byte var6 = 0;
               this.method_161(var6, false);
            }
         } else if(var1 == 1) {
            if(this.field_132 > 0) {
               var3 = this.field_132 - 1;
               this.method_161(var3, false);
            } else {
               var3 = this.field_128[this.field_131].length - 1;
               this.method_161(var3, false);
            }
         }

         this.method_148();
         if(var1 == 8) {
            try {
               this.method_78();
               return;
            } catch (Exception var4) {
               SocketListener.logMessage("CityMenu2.executeFire " + var4);
            }
         }
      }

   }

   // $FF: renamed from: c () void
   private void method_148() {
      int var1 = this.method_150();
      class_62 var2 = this.field_130;
      int var3 = this.field_130.field_500 + 5;
      if(ScreenDrawer.self.method_380()) {
         var3 = ScreenDrawer.method_378(MenuScreen.field_101);
      }

      var3 = (ScreenDrawer.self.getHeight() - this.method_149() - PopupMenu.method_583() - var3) / var3;
      if(this.field_132 < super.field_118) {
         super.field_118 = this.field_132;
      }

      if(this.field_132 > super.field_118 + var3) {
         super.field_118 = this.field_132 - var3;
      }

      if(super.field_118 < 0) {
         super.field_118 = 0;
      }

      if(var3 < var1 && super.field_118 + var3 > var1) {
         super.field_118 = var1 - var3;
      }

   }

   // $FF: renamed from: b () short
   private short method_149() {
      switch(this.mainMenuType) {
      case 1:
      case 4:
         return (short)((ScreenDrawer.self.getHeight() - this.method_150() * ScreenDrawer.method_378(MenuScreen.field_101)) / 2);
      default:
         return this.method_136();
      }
   }

   // $FF: renamed from: b () int
   private int method_150() {
      String[] var1;
      return (var1 = this.field_128 != null?this.field_128[this.field_131]:null) != null?var1.length:0;
   }

   // $FF: renamed from: a () java.lang.String[]
   public static String[] method_151() {
      String var0 = Main2.self.rmsManager.getString((byte)2, (String)null);
      String var1;
      return ((var1 = Main2.self.rmsManager.getString((byte)17, (String)null)) == null || var1.equals("")) && (var0 == null || var0.equals(""))?field_122:field_123;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      try {
         short var10000 = this.method_149();
         class_62 var2 = this.field_130;
         int var21 = var10000 - (this.field_130.field_500 + 5);
         if(ScreenDrawer.self.method_380()) {
            var21 = this.method_149() - ScreenDrawer.method_378(MenuScreen.field_101);
         }

         int var3 = this.method_150() * ScreenDrawer.method_378(MenuScreen.field_101) + ScreenDrawer.method_378(MenuScreen.field_101) + 10;
         int var5;
         int var6;
         int var7;
         if(this.mainMenuType != 1 && this.mainMenuType != 4) {
            super.method_30(var1);
         } else {
            if(!ScreenDrawer.self.method_347()) {
               StrategicScreen.method_102(var1, 300, 200);
            }

            ScreenDrawer.method_369(var1, 0, var21, ScreenDrawer.self.getWidth(), var3);
            MenuScreen.method_137(var1, MenuScreen.field_99, super.raceId);
            ScreenDrawer.method_369(var1, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
            int var4 = ScreenDrawer.method_377(this.field_143);
            var5 = ScreenDrawer.method_378(this.field_143);
            var6 = ScreenDrawer.self.getWidth() / ScreenDrawer.method_377(this.field_143) + 1;

            for(var7 = 0; var7 < var6; ++var7) {
               ScreenDrawer.method_374(var1, this.field_143, 0, 0, var4, var5, 0, var7 * var4, var21 - var5, 0);
               ScreenDrawer.method_374(var1, this.field_143, 0, 0, var4, var5, 0, var7 * var4, var21 + var3, 0);
            }

            var4 = ScreenDrawer.method_377(this.field_142);
            var5 = ScreenDrawer.method_378(this.field_142);
            ScreenDrawer.method_374(var1, this.field_142, 0, 0, var4, var5, 0, ScreenDrawer.self.getWidth() / 2 - var4 / 2, var21 - var5 / 2, 0);
         }

         switch(this.mainMenuType) {
         case 1:
         case 4:
            if(this.field_128 != null && this.field_131 >= 0 && this.field_132 >= 0 && this.field_128.length > this.field_131) {
               this.method_139(var1, this.method_149(), this.field_128[this.field_131], this.field_132, this.field_130);
            }
            break;
         case 2:
         case 3:
         default:
            if(this.field_128 != null && this.field_131 >= 0 && this.field_132 >= 0 && this.field_128.length > this.field_131) {
               this.method_139(var1, this.method_149(), this.field_128[this.field_131], this.field_132, this.field_130);
            }
            break;
         case 5:
            Graphics var24 = var1;
            MainMenuScreen var22 = this;
            var6 = this.method_136() + 5;
            var7 = PopupMenu.method_583() + 5;
            int var8 = ScreenDrawer.self.getWidth() - 20;
            int var9 = ScreenDrawer.self.getHeight() - var6 - var7;
            int var10;
            if((var10 = Math.min(var8 / 50, var9 / 50)) <= 0) {
               var10 = 1;
            }

            if(var1 != null) {
               byte var33 = this.field_134;
               boolean var11 = false;
               this.method_136();
               var33 = this.field_135;
               boolean var12 = false;
               short var13 = (short) ScreenDrawer.method_386(var1);
               short var14 = (short) ScreenDrawer.method_387(var1);
               short var15 = (short) ScreenDrawer.method_388(var1);
               short var16 = (short) ScreenDrawer.method_389(var1);
               ScreenDrawer.method_369(var1, 10, var6, var8, var9);
               this.field_139 = this.field_136 = this.field_138 = this.field_137 = false;
               String var26 = field_125;
               synchronized(field_125) {
                  int var18;
                  short var27;
                  short var29;
                  short var32;
                  if(GlobalStorage.method_698()) {
                     for(var27 = 0; var27 < GlobalStorage.getMapDataSize(); ++var27) {
                        byte var28 = (byte)(var27 % 50);
                        byte var30 = (byte)(var27 / 50);
                        var29 = method_154((short)var28, var10);
                        var32 = method_155((short)var30, var10, var6, var7);
                        if(var29 < ScreenDrawer.method_386(var24)) {
                           var22.field_136 = true;
                        }

                        if(var29 + var10 >= ScreenDrawer.method_386(var24) + ScreenDrawer.method_388(var24)) {
                           var22.field_137 = true;
                        }

                        if(var32 < ScreenDrawer.method_387(var24)) {
                           var22.field_138 = true;
                        }

                        if(var32 + var10 >= ScreenDrawer.method_387(var24) + ScreenDrawer.method_389(var24)) {
                           var22.field_139 = true;
                        }

                        byte var17 = (byte)(GlobalStorage.method_703(var27) & 15);
                        var18 = field_124[var17];
                        if(GlobalStorage.method_722(GlobalStorage.method_703(var27))) {
                           var18 = 16759803;
                        }

                        ScreenDrawer.method_384(var24, var18);
                        var24.fillRect(var29, var32, var10, var10);
                        if(!GlobalStorage.method_709(GlobalStorage.method_703(var27)) && var17 != 1 && var17 != 0 && var10 > 2) {
                           ScreenDrawer.method_384(var24, 89478485);
                           var24.fillRect(var29 + 1, var32 + 1, var10 - 2, var10 - 2);
                        }
                     }
                  }

                  if(Hero.self != null) {
                     ScreenDrawer.method_384(var24, 16451113);
                     var27 = method_154((short) Hero.self.getPositionX(), var10);
                     var29 = method_155((short) Hero.self.getPositionY(), var10, var6, var7);
                     var24.fillRect(var27, var29, var10, var10);
                     method_153(Hero.self.method_890(), var24, var27, (short)(var29 + var10), Hero.self.method_932());
                  }

                  if(GlobalStorage.method_681() > 0) {
                     for(var27 = 0; var27 < GlobalStorage.method_681(); ++var27) {
                        MapObject var31;
                        if((var31 = GlobalStorage.method_682(var27)) != null && var31.method_414()) {
                           var32 = method_154((short)var31.method_418(), var10);
                           short var34 = method_155((short)var31.method_419(), var10, var6, var7);
                           var18 = var31.getType() == 2?var31.method_424() + 1:5;
                           if(var31.getType() == 2) {
                              ScreenDrawer.method_384(var24, 1774063);
                              var24.fillRect(var32, var34 - var10, var10 << 1, var10 << 1);
                              method_153(var31.method_420(), var24, var32, (short)(var34 + var10), var18);
                           } else {
                              if(var31.getType() != 4 && var31.getType() != 5) {
                                 if(var31.getType() == 1) {
                                    ScreenDrawer.method_384(var24, 16451113);
                                 } else {
                                    ScreenDrawer.method_384(var24, 9636760);
                                 }
                              } else {
                                 ScreenDrawer.method_384(var24, 6678684);
                              }

                              var24.fillRect(var32, var34, var10, var10);
                              method_153(var31.method_420(), var24, var32, (short)(var34 + var10), var18);
                           }
                        }
                     }
                  }

                  ScreenDrawer.method_369(var24, var13, var14, var15, var16);
                  if(var22.field_138) {
                     ScreenDrawer.method_370(var24, GlobalStorage.getImage(MenuScreen.field_92), ScreenDrawer.self.getWidth() / 2, var22.method_136() + 2, 3);
                  }

                  if(var22.field_139) {
                     ScreenDrawer.method_370(var24, GlobalStorage.getImage(MenuScreen.field_93), ScreenDrawer.self.getWidth() / 2, ScreenDrawer.self.getHeight() - PopupMenu.method_583() - 3, 3);
                  }

                  if(var22.field_136) {
                     ScreenDrawer.method_370(var24, GlobalStorage.getImage(MenuScreen.field_94), 8, ScreenDrawer.method_383(GlobalStorage.getImage(MenuScreen.field_98)) + 8 + (ScreenDrawer.self.getHeight() - var22.method_136() - 32 - PopupMenu.method_583()) / 2, 3);
                  }

                  if(var22.field_137) {
                     ScreenDrawer.method_370(var24, GlobalStorage.getImage(MenuScreen.field_95), ScreenDrawer.self.getWidth() - 8, ScreenDrawer.method_383(GlobalStorage.getImage(MenuScreen.field_98)) + 8 + (ScreenDrawer.self.getHeight() - var22.method_136() - 32 - PopupMenu.method_583()) / 2, 3);
                  }
               }
            }
         }

         if(super.popupMenu != null) {
            super.popupMenu.method_604(var1);
         }

         if(this.mainMenuType == 1) {
            String var23 = MessagesContainer.getMessage(171) + ": ";
            Screen.field_26.method_564(var1, var23, 2, var21 + var3 - Screen.field_26.field_500 - 2, 0);
            var5 = 0 + 2 + Screen.field_26.method_563(var23);
            Main2 var10002 = Main2.self;
            Screen.field_29.method_564(var1, Main2.getVersion(), var5, var21 + var3 - Screen.field_26.field_500 - 2, 0);
            Main2 var10003 = Main2.self;
            var5 += 5 + Screen.field_29.method_563(Main2.getVersion());
            String var25;
            if((var25 = MessagesContainer.getMessage(307, (String[])null)) != null) {
               Screen.field_29.method_564(var1, var25, var5, var21 + var3 - Screen.field_26.field_500 - 2, 0);
            }
         }

      } catch (Exception var20) {
         SocketListener.logMessage("CityMenu2 " + var20.getMessage());
      }
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button var1) {
      int var2 = var1.field_543;
      switch((byte)var1.field_543) {
      case 55:
         OutputGameMessage var10000;
         OutputGameMessage var4;
         switch(this.mainMenuType) {
         case 2:
            if(!Hero.self.method_881()) {
               ScreenDrawer.method_330(MessagesContainer.getMessage(164) + "!", MessagesContainer.getMessage(165));
               return true;
            } else {
               if(!GlobalStorage.method_698()) {
                  ScreenDrawer.method_330(MessagesContainer.getMessage(36), MessagesContainer.getMessage(37));
                  return true;
               }

               try {
                  var10000 = new OutputGameMessage(MessageProcessor.packetTypes[28], (short)0, (short)0);
                  var4 = var10000;
                  SocketListener.self.sendCommand(var4);
               } catch (Exception var3) {
                  SocketListener.logMessage("executePopupMenuAction " + var3.toString());
               }

               return true;
            }
         case 3:
            var10000 = new OutputGameMessage(MessageProcessor.packetTypes[15], (short)0, (short)0);
            var4 = var10000;
            SocketListener.self.sendCommand(var4);
            ScreenDrawer.self.setScreenId((byte)2);
            ScreenDrawer.self.strategicScreen.method_83(Hero.self.getPositionX(), Hero.self.getPositionY(), true);
            ScreenDrawer.self.strategicScreen.createWaveMatrix();
            return true;
         default:
            ScreenDrawer.self.setScreenId((byte)2);
            ScreenDrawer.self.strategicScreen.method_83(Hero.self.getPositionX(), Hero.self.getPositionY(), true);
            return true;
         }
      default:
         return super.method_38(var1);
      }
   }

   // $FF: renamed from: d () boolean
   protected final boolean method_77() {
      return !super.popupMenu.method_611();
   }

   // $FF: renamed from: o () void
   private void method_152() {
      Main2.self.method_844((byte)1);
      this.mainMenuType = 1;
   }

   // $FF: renamed from: n () void
   public final void method_78() {
      byte var3;
      OutputGameMessage var6;
      OutputGameMessage var11;
      switch(this.mainMenuType) {
      case 1:
         if(!this.field_127) {
            byte var9 = this.field_132;
            boolean var8 = this.field_128[0] == field_123;
            Main2 var14;
            switch(var9) {
            case 0:
               if(var8) {
                  this.method_152();
               } else {
                  var14 = Main2.self;
                  class_85 var10001 = new class_85(this);
                  var14.field_661 = var10001;
                  Main2.self.changeForm((byte)3);
                  var3 = 0;
                  this.method_161(var3, false);
               }

               return;
            case 1:
               if(var8) {
                  String[][] var10;
                  (var10 = new String[1][6])[0][0] = MessagesContainer.getMessage(6);
                  var10[0][1] = MessagesContainer.getMessage(5);
                  var10[0][4] = MessagesContainer.getMessage(121);
                  var10[0][3] = MessagesContainer.getMessage(138);
                  var10[0][2] = MessagesContainer.getMessage(296);
                  var10[0][5] = MessagesContainer.getMessage(34);
                  this.field_128 = var10;
                  this.mainMenuType = 4;
                  var3 = 0;
                  this.method_161(var3, false);
               } else {
                  this.method_152();
               }

               return;
            case 2:
               if(var8) {
                  var14 = Main2.self;
                  Main2.gotoUrl1(Main2.self.method_850());
               }
            default:
               return;
            }
         } else {
            switch(this.field_132) {
            case 0:
               ScreenDrawer.self.method_345();
               return;
            case 1:
               SocketListener var15 = SocketListener.self;
               OutputGameMessage var13 = new OutputGameMessage(MessageProcessor.packetTypes[24], (short)0, (short)0);
               var15.sendCommand(var13);
               Main2.self.exit();
            default:
               return;
            }
         }
      case 2:
         if(this.field_132 < this.field_128[0].length - 1) {
            var11 = new OutputGameMessage(MessageProcessor.packetTypes[8], (short)8, MessageProcessor.packetTypes[7]);
            var6 = var11;
            var11.addToBody(this.field_129[this.field_132]);
            var6.addToBody(Hero.self.heroId);
            SocketListener.self.sendCommand(var6);
            return;
         }

         if(!Hero.self.method_881()) {
            ScreenDrawer.method_330(MessagesContainer.getMessage(164) + "!", MessagesContainer.getMessage(165));
            return;
         }

         if(!GlobalStorage.method_698()) {
            ScreenDrawer.method_330(MessagesContainer.getMessage(36), MessagesContainer.getMessage(37));
            return;
         }

         try {
            MapObject var12 = new MapObject();
            MapObject var7 = var12;
            var12.method_430();
            var7.setType((byte)4);
            var7.method_411(Hero.self.getPositionX(), Hero.self.getPositionY(), true);
            GlobalStorage.method_705(var7.method_418(), var7.method_419());
            Hero.self.setCoords(var7.method_418(), var7.method_419());
            var11 = new OutputGameMessage(MessageProcessor.packetTypes[28], (short)0, (short)0);
            OutputGameMessage var2 = var11;
            SocketListener.self.sendCommand(var2);
         } catch (Exception var4) {
            SocketListener.logMessage("CityMenu2.executeFire() cityentry " + var4.toString());
         }

         ScreenDrawer.self.setScreenId((byte)2);
         ScreenDrawer.self.strategicScreen.method_83(Hero.self.getPositionX(), Hero.self.getPositionY(), true);
         ScreenDrawer.self.strategicScreen.createWaveMatrix();
         break;
      case 3:
         if(this.field_131 == 0) {
            if(this.field_132 == this.field_128[0].length - 1) {
               var11 = new OutputGameMessage(MessageProcessor.packetTypes[30], (short)0, MessageProcessor.packetTypes[10]);
               var6 = var11;
               SocketListener.self.sendCommand(var6);
               return;
            }

            this.field_131 = 1;
            return;
         }

         if(this.field_132 != this.field_128[1].length - 1) {
            if(Hero.self.method_896(super.field_120) < this.field_133[this.field_132]) {
               if(super.field_120) {
                  Main2.method_859();
                  return;
               }

               ScreenDrawer.method_330(MessagesContainer.getMessage(135), MessagesContainer.getMessage(205));
               return;
            }

            class_15 var10000 = new class_15(this);
            class_15 var5 = var10000;
            ScreenDrawer.method_334(MessagesContainer.getMessage(135), MessagesContainer.getMessage(206, new String[]{this.field_128[1][this.field_132], String.valueOf(this.field_133[this.field_132])}), MessagesContainer.getMessage(41) + "?", var5);
            return;
         }

         this.field_131 = 0;
         return;
      case 4:
         switch(this.field_132) {
         case 0:
            Main2.self.changeForm((byte)3);
            break;
         case 1:
            Main2.self.changeForm((byte)4);
            break;
         case 2:
            Main2.self.changeForm((byte)8);
            break;
         case 3:
            ScreenDrawer.self.method_353();
            ScreenDrawer.method_330(MessagesContainer.getMessage(139), MessagesContainer.getMessage(140) + MessagesContainer.getMessage(141));
            break;
         case 4:
            RMSManager var1 = Main2.self.rmsManager;
            Main2.self.rmsManager.deleteAll((byte)-1);
            Main2.self.clearLoginAndPass();
            ScreenDrawer.method_330("", MessagesContainer.getMessage(305));
            break;
         case 5:
            this.field_128 = new String[][]{method_151()};
            this.mainMenuType = 1;
            var3 = 0;
            this.method_161(var3, false);
         default:
            return;
         }
      }

   }

   // $FF: renamed from: a () void
   public final void method_51() {}

   public final String toString() {
      StringBuffer var1 = new StringBuffer();
      switch(this.mainMenuType) {
      case 1:
         var1.append("screen: MainMenu\n");
         break;
      case 2:
         var1.append("screen: City\n");
         var1.append("name: ").append(super.field_116).append("\n");
         break;
      case 3:
         var1.append("screen: Teleport\n");
      case 4:
      default:
         break;
      case 5:
         var1.append("screen: LocationMap\n");
      }

      if(ScreenDrawer.self.GetScreen() == this) {
         var1.append("state: active");
      } else {
         var1.append("status: passive");
      }

      return var1.toString();
   }

   // $FF: renamed from: a (java.lang.String, javax.microedition.lcdui.Graphics, short, short, int) void
   private static void method_153(String var0, Graphics var1, short var2, short var3, int var4) {
      if(var0 != null && var0.length() > 0) {
         ScreenDrawer.method_384(var1, 0);
         int var5 = Screen.field_25.method_563(var0);
         MapObject.method_404(var1, var4, var2, var3, var5, Screen.field_25.field_500);
         Screen.field_25.method_564(var1, var0, var2, var3, 0);
      }

   }

   // $FF: renamed from: a (short, int) short
   private static short method_154(short var0, int var1) {
      return (short)(10 + (ScreenDrawer.self.getWidth() - 20) / 2 - (25 - var0) * var1);
   }

   // $FF: renamed from: a (short, int, int, int) short
   private static short method_155(short var0, int var1, int var2, int var3) {
      return (short)(var2 + (ScreenDrawer.self.getHeight() - var2 - var3) / 2 - (25 - var0) * var1);
   }

   // $FF: renamed from: a (short[]) void
   public final void method_156(short[] var1) {
      this.field_129 = var1;
   }

   // $FF: renamed from: a (byte) void
   public final void method_157(byte var1) {
      this.field_131 = 0;
   }

   // $FF: renamed from: a (java.lang.String[][]) void
   public final void method_158(String[][] var1) {
      this.field_128 = var1;
   }

   // $FF: renamed from: a (long[]) void
   public final void method_159(long[] var1) {
      this.field_133 = var1;
   }

   // $FF: renamed from: b () void
   public final void method_160() {
      String[][] var2 = new String[][]{{MessagesContainer.getMessage(34), MessagesContainer.getMessage(1)}, new String[0]};
      this.field_128 = var2;
      this.field_127 = true;
   }

   // $FF: renamed from: a (int, boolean) void
   public final void method_161(int var1, boolean var2) {
      this.field_132 = (byte)var1;
      if(var2) {
         this.method_148();
      }

   }

   // $FF: renamed from: e (int) void
   public final void method_162(int var1) {
      this.method_161(var1, false);
   }

   // $FF: renamed from: b (byte) void
   public final void setMainMenuType(byte type) {
      this.mainMenuType = type;
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      Screen.field_38 = true;
      Screen.field_34 = var1;
      Screen.field_35 = var2;
      Screen.field_36 = var1;
      Screen.field_37 = var2;
      this.field_141 = System.currentTimeMillis();
      this.field_140 = false;
      return false;
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      if(Screen.field_38 && (var1 = this.method_150()) > 0) {
         class_62 var10001 = this.field_130;
         byte var5;
         if((var5 = this.method_140(this.method_150(), this.method_149(), var2)) >= 0 && var5 < var1) {
            this.method_161(var5, false);

            try {
               this.method_78();
               return true;
            } catch (Exception var4) {
               var4.printStackTrace();
               SocketListener.logMessage(var4.getMessage());
            }
         }
      }

      return false;
   }

   // $FF: renamed from: a (int, int, int) boolean
   protected final boolean method_61(int var1, int var2, int var3) {
      if(System.currentTimeMillis() - this.field_141 > 200L && Screen.field_38 && !this.field_140) {
         this.field_140 = true;
         class_62 var10001 = this.field_130;
         byte var4;
         if((var4 = this.method_140(this.method_150(), this.method_149(), var2)) >= 0 && var4 < this.method_150()) {
            this.method_161(var4, false);
         }
      }

      return false;
   }

   // $FF: renamed from: b (int, int) boolean
   protected final boolean method_62(int var1, int var2) {
      if(Math.abs(Screen.field_36 - Screen.field_34) > 20 || Math.abs(Screen.field_37 - Screen.field_35) > 20) {
         Screen.field_38 = false;
      }

      if(this.field_140) {
         class_62 var10001 = this.field_130;
         byte var3;
         if((var3 = this.method_140(this.method_150(), this.method_149(), var2)) >= 0 && var3 < this.method_150()) {
            this.method_161(var3, false);
         }
      } else if(this.method_150() > 0) {
         class_62 var5 = this.field_130;
         int var6 = this.field_130.field_500 + 5;
         if(ScreenDrawer.self.method_380()) {
            var6 = ScreenDrawer.method_378(MenuScreen.field_101);
         }

         int var4;
         if((var4 = (Screen.field_37 - var2) / var6) != 0) {
            if((var6 = (ScreenDrawer.self.getHeight() - this.method_149() - PopupMenu.method_583()) / var6) < this.method_150()) {
               super.field_118 += var4;
            }

            if(super.field_118 < 0) {
               super.field_118 = 0;
            }

            if(var6 < this.method_150() && super.field_118 + var6 > this.method_150()) {
               super.field_118 = this.method_150() - var6;
            }

            Screen.field_37 = var2;
         }
      }

      Screen.field_36 = var1;
      return false;
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_122 = new String[]{MessagesContainer.getMessage(303), MessagesContainer.getMessage(304)};
      field_123 = new String[]{MessagesContainer.getMessage(2), MessagesContainer.getMessage(3), MessagesContainer.getMessage(204)};
      field_124 = new int[]{1114163, 9359084, 10053120, 16764006, 16777215, 6723891, 26112, 6699291, 13378048, 3355443};
      field_125 = "locationAncer";
   }
}
