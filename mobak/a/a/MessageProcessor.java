package mobak.a.a;

import java.util.Vector;
import mobak.Main2;
import mobak.class_67;
import mobak.GlobalStorage;
import mobak.UserData;
import mobak.a.SocketListener;
import mobak.b.a.Thing;
import mobak.b.a.class_76;
import mobak.b.a.Item;
import mobak.b.a.Unit;
import mobak.b.a.Characteristic;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.StrategicScreen;
import mobak.b.b.BattleScreen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.MapObject;
import mobak.b.b.HeroObject;
import mobak.b.b.FormCreator;
import mobak.b.b.a.MenuScreen;
import mobak.b.b.a.MainMenuScreen;
import mobak.b.b.a.class_34;
import mobak.b.b.a.class_35;
import mobak.b.b.a.class_36;
import mobak.b.b.a.class_37;
import mobak.b.b.a.View;
import mobak.b.b.a.class_39;
import mobak.b.b.a.class_40;
import mobak.b.b.a.class_41;
import mobak.b.b.a.ViewHelp;
import mobak.b.b.a.class_43;
import mobak.b.b.a.PopupMenu;
import mobak.b.b.a.Button;
import mobak.c.class_1;
import mobak.c.MessagesContainer;
import mobak.c.class_64;
import mobak.c.PhraseCollection;

// $FF: renamed from: mobak.a.a.b
public final class MessageProcessor {

   // $FF: renamed from: a java.lang.String[]
   private static String[] messagesContainer;
   // $FF: renamed from: a short[]
   public static final short[] packetTypes;
   // $FF: renamed from: a mobak.b.b.g
   private static FormCreator formCreator;
   // $FF: renamed from: a mobak.i
   private static UserData userData;
   // $FF: renamed from: a mobak.c.b
   private static class_1 field_738;
   // $FF: renamed from: a java.util.Vector
   private static Vector field_739;


   // $FF: renamed from: a (short) short
   private static short getPacketTypeIndex(short var0) {
      for(short var1 = 0; var1 < packetTypes.length; ++var1) {
         if(packetTypes[var1] == var0) {
            return var1;
         }
      }

      return (short)-1;
   }

   // $FF: renamed from: a () boolean
   public static final boolean execute() throws Exception {
      byte var0 = -1;
      boolean var1 = false;
      PacketManager.skipReadingHeader();

      try {
         var1 = method_983(getPacketTypeIndex(PacketManager.getPacketType()));
      } catch (Exception var6) {
         StringBuffer var3 = new StringBuffer("MessageProcessor.execute() Executing error: ");
         if(var0 >= 0 && var0 < messagesContainer.length) {
            var3.append("message: ").append(messagesContainer[var0]).append(" ");
         } else {
            var3.append("index: ").append(var0).append(" ");
         }

         var3.append(var6.toString());
         SocketListener.logMessage(var3.toString());
         var6.printStackTrace();
      } finally {
         PacketManager.clearPacketData();
      }

      return var1;
   }

   // $FF: renamed from: a (short) boolean
   private static boolean method_983(short var0) throws Exception {
      String var1;
      int var3;
      boolean var4;
      String message;
      ScreenDrawer var12;
      boolean var13;
      BattleScreen var10001;
      byte var18;
      switch(var0) {
      case 0:
         Main2.self.saveLoginAndPass();
         createHero();
         PacketManager.readString();
         ScreenDrawer.self.menuScreen.method_160();
         var18 = PacketManager.readByte();
         byte var7 = PacketManager.readByte();
         if(var18 != 0 && var7 != 0) {
            Hero.self.setCoords(var18, var7);
            if(ScreenDrawer.self.strategicScreen != null) {
               ScreenDrawer.self.strategicScreen.method_83(var18, var7, true);
            }
         }

         var4 = true;
         break;
      case 1:
         var4 = true;
         break;
      case 2:
         var4 = true;
         break;
      case 3:
      case 4:
      case 9:
      case 12:
      case 25:
      case 28:
      case 29:
      case 30:
      case 36:
      case 37:
      case 39:
      case 40:
      case 42:
      case 43:
      case 44:
      case 45:
      case 51:
      case 58:
      case 59:
      case 60:
      case 66:
      case 67:
      case 68:
      case 71:
      case 72:
      case 73:
      case 74:
      case 77:
      case 78:
      case 82:
      case 83:
      case 84:
      case 85:
      case 87:
      case 88:
      case 89:
      case 90:
      case 92:
      case 93:
      case 95:
      case 96:
      case 119:
      default:
         throw new Exception("unknown packet");
      case 5:
         ScreenDrawer.self.method_352(false);
         message = PacketManager.readString();
         var1 = PacketManager.readString();
         int var10 = PacketManager.readInt();
         var3 = PacketManager.readInt();
         ScreenDrawer.method_332(message, var1, var10);
         if(var3 > 0) {
            OutputGameMessage var25 = new OutputGameMessage(packetTypes[5]);
            OutputGameMessage var27 = var25;
            var25.addToBody(var3);
            SocketListener.self.sendCommand(var27);
         }

         var4 = true;
         break;
      case 6:
         if(ScreenDrawer.self.battleScreen == null) {
            var12 = ScreenDrawer.self;
            var10001 = new BattleScreen();
            var12.battleScreen = var10001;
            ScreenDrawer.self.method_350(true);
         }

         if(Hero.self.field_702) {
            class_35.method_184();
         }

         byte[] var26 = null;
         PacketManager.readByte();
         if(PacketManager.getPacketBodySize() > 1) {
            PacketManager.copyBytesTo(var26 = new byte[PacketManager.getPacketBodySize() - 1]);
         }

         ScreenDrawer.self.battleScreen.method_285(var26);
         var4 = true;
         break;
      case 7:
         ScreenDrawer.field_293 = null;
         switch(PacketManager.readByte()) {
         case 0:
            ScreenDrawer.field_293 = readUnits(true);
            if(ScreenDrawer.self.method_342() != null) {
               ScreenDrawer.self.method_342().method_51();
            }

            View.field_224 = true;
            var13 = true;
            break;
         case 1:
            ScreenDrawer.field_293 = readItems(false);
            if(ScreenDrawer.self.method_342() != null) {
               ScreenDrawer.self.method_342().method_51();
            }

            View.field_224 = true;
            var13 = true;
            break;
         default:
            var13 = false;
         }

         var4 = var13;
         break;
      case 8:
         var4 = true;
         if(PacketManager.readByte() == 1 && PacketManager.readShort() == 128) {
            ScreenDrawer.self.method_340(getGateMenu(), true);
         }

         var4 = true;
         break;
      case 10:
         var4 = method_991(true);
         break;
      case 11:
         var4 = method_992();
         break;
      case 13:
         var4 = true;
         break;
      case 14:
         var4 = method_993();
         break;
      case 15:
         if(PacketManager.readByte() == 2) {
            ScreenDrawer.self.method_346();
            ScreenDrawer.method_330("Ошибка!", "Произошла ошибка, попробуйте еще раз.");
            if(Screen.method_49()) {
               SocketListener.self.method_534();
            }
         }

         var4 = true;
         break;
      case 16:
         var4 = createItems();
         break;
      case 17:
         var4 = createUnits();
         break;
      case 18:
         var4 = method_996();
         break;
      case 19:
         var4 = method_997();
         break;
      case 20:
         var4 = method_998();
         break;
      case 21:
         var4 = createMap();
         break;
      case 22:
         var4 = unitSetChange();
         break;
      case 23:
         var4 = method_1001();
         break;
      case 24:
         var4 = method_1002();
         break;
      case 26:
         var4 = method_1003();
         break;
      case 27:
         var4 = method_1004();
         break;
      case 31:
         var4 = method_1005();
         break;
      case 32:
         SocketListener.self.method_534();
         SocketListener.self.method_537(false);
         ScreenDrawer.self.setScreenId((byte)1);
         ScreenDrawer.self.menuScreen = MenuScreen.initMainMenu();
         message = PacketManager.readString();
         var1 = PacketManager.readString();
         ScreenDrawer.self.menuScreen.method_158(new String[][]{MainMenuScreen.method_151(), new String[0]});
         class_8 var24 = new class_8();
         class_8 var9 = var24;
         ScreenDrawer.method_334(MessagesContainer.getMessage(29), message, var1, var9);
         var4 = true;
         break;
      case 33:
         var12 = ScreenDrawer.self;
         ScreenDrawer.method_319();
         if(Hero.self.field_702) {
            class_35.method_184();
         }

         var18 = PacketManager.readByte();
         SocketListener.self.method_529(packetTypes[34], false);
         String var2;
         if(var18 == 0) {
            SocketListener.self.method_534();
            var1 = PacketManager.readString();
            var2 = PacketManager.readString();
            ScreenDrawer.method_330(var1, var2);
            Screen.method_48();
            ScreenDrawer.self.GetScreen().method_43((byte)0);
            var13 = true;
         } else if(var18 == 3) {
            PacketManager.readInt();
            var1 = PacketManager.readString();
            class_12 var14 = new class_12();
            class_12 var6 = var14;
            ScreenDrawer.method_334(MessagesContainer.getMessage(135), var1, MessagesContainer.getMessage(184), var6);
            ScreenDrawer.self.method_352(false);
            var13 = true;
         } else {
            if(ScreenDrawer.self.battleScreen == null) {
               var12 = ScreenDrawer.self;
               var10001 = new BattleScreen();
               var12.battleScreen = var10001;
            }

            Hero.self.field_688 = 0;
            BattleScreen var17 = ScreenDrawer.self.battleScreen;
            Hero hero = new Hero(false);
            var17.hero = hero;
            var1 = PacketManager.readString();
            var2 = PacketManager.readString();
            var3 = PacketManager.readInt();
            if(!var1.equals("") && !var2.equals("")) {
               ScreenDrawer.self.method_352(false);
               class_11 var19 = new class_11();
               class_11 var20 = var19;
               ScreenDrawer.method_333(var1, var2, var20, 15000);
            } else {
               ScreenDrawer.self.setScreenId((byte)3);
               ScreenDrawer.self.method_376();
            }

            ScreenDrawer.self.battleScreen.hero.heroId = var3;
            ScreenDrawer.self.battleScreen.hero.field_670 = PacketManager.readString();
            int var22;
            MapObject var23;
            if((var22 = GlobalStorage.method_686(var3, (byte)1)) >= 0 && (var23 = GlobalStorage.method_682(var22)) != null) {
               var23.method_429();
               class_67 var5 = GlobalStorage.method_714(var23.getType());

               for(byte var8 = 0; var8 < var5.field_540; ++var8) {
                  GlobalStorage.method_705((byte)(var23.method_418() + var5.field_541[var8][0]), (byte)(var23.method_419() + var5.field_541[var8][1]));
               }
            }

            SocketListener var21 = SocketListener.self;
            OutputGameMessage var16 = new OutputGameMessage(packetTypes[9]);
            var21.sendCommand(var16);
            var13 = true;
         }

         var4 = var13;
         break;
      case 34:
         var4 = activateUnit();
         break;
      case 35:
         var4 = method_1008();
         break;
      case 38:
         var4 = method_1009();
         break;
      case 41:
         var4 = method_1010();
         break;
      case 46:
         var4 = method_1028();
         break;
      case 47:
         var4 = method_1011();
         break;
      case 48:
         var4 = method_1031();
         break;
      case 49:
         var4 = method_1012();
         break;
      case 50:
         var4 = createHero();
         break;
      case 52:
         var4 = method_1014();
         break;
      case 53:
         var4 = method_1015();
         break;
      case 54:
         var4 = true;
         break;
      case 55:
         var4 = method_1029();
         break;
      case 56:
         var4 = method_1017();
         break;
      case 57:
         var4 = method_1022();
         break;
      case 61:
         var4 = method_1018();
         break;
      case 62:
         var4 = method_1019();
         break;
      case 63:
         var4 = method_1020();
         break;
      case 64:
         var4 = method_1021();
         break;
      case 65:
         var4 = method_1023();
         break;
      case 69:
         var4 = method_1024();
         break;
      case 70:
         var4 = method_1027();
         break;
      case 75:
         var4 = method_1030();
         break;
      case 76:
         var4 = method_1033();
         break;
      case 79:
         var4 = method_1035();
         break;
      case 80:
         var4 = method_1036();
         break;
      case 81:
         var4 = method_1037();
         break;
      case 86:
         var4 = method_1038();
         break;
      case 91:
         ScreenDrawer.self.method_346();
         var4 = true;
         break;
      case 94:
         var4 = method_1040();
         break;
      case 97:
         var4 = method_1039();
         break;
      case 98:
         var4 = readCharacteristicsNames();
         break;
      case 99:
         var4 = method_1042();
         break;
      case 100:
         var4 = method_1043();
         break;
      case 101:
         var4 = method_1045();
         break;
      case 102:
         var4 = method_1046();
         break;
      case 103:
         var4 = method_1047();
         break;
      case 104:
         var4 = method_1048();
         break;
      case 105:
         var4 = method_1049();
         break;
      case 106:
         var4 = method_1006();
         break;
      case 107:
         SocketListener.self.method_534();
         SocketListener.self.method_537(false);
         ScreenDrawer.self.setScreenId((byte)1);
         ScreenDrawer.self.menuScreen = MenuScreen.initMainMenu();
         message = PacketManager.readString();
         ScreenDrawer.self.menuScreen.method_158(new String[][]{MainMenuScreen.method_151(), new String[0]});
         String title = MessagesContainer.getMessage(29);
         RegistrationNotifyLabel registrationNotifyLabel = new RegistrationNotifyLabel();
         ScreenDrawer.createNotification(title, message, registrationNotifyLabel);
         var4 = true;
         break;
      case 108:
         Main2.method_859();
         var4 = true;
         break;
      case 109:
         var4 = method_1050();
         break;
      case 110:
         var4 = method_1051();
         break;
      case 111:
         var4 = method_1025();
         break;
      case 112:
         var4 = method_1026();
         break;
      case 113:
         var4 = method_1052();
         break;
      case 114:
         var4 = method_1053();
         break;
      case 115:
         PacketManager.readLong();
         var4 = true;
         break;
      case 116:
         var4 = method_1054();
         break;
      case 117:
         var4 = method_1055();
         break;
      case 118:
         var4 = true;
         break;
      case 120:
         var4 = getImagesVersion();
      }

      return var4;
   }

   // $FF: renamed from: a (boolean) mobak.b.a.f[]
   private static final Unit[] readUnits(boolean var0) {
      try {
         if(PacketManager.PacketIsHeader()) {
            return null;
         } else {
            byte var1;
            Unit[] var2 = new Unit[var1 = PacketManager.readByte()];

            int var3;
            for(var3 = 0; var3 < var1; ++var3) {
               var2[var3] = null;
            }

            for(var3 = 0; !PacketManager.packetDataIsEmpty() && var3 < var1; ++var3) {
               var2[var3] = method_985();
               if(var0) {
                  var2[var3].method_823(false);
               }
            }

            return var2;
         }
      } catch (Exception var4) {
         return null;
      }
   }

   // $FF: renamed from: a () mobak.b.a.f
   private static final Unit method_985() {
      try {
         int var0 = PacketManager.readInt();
         boolean var1 = PacketManager.readByte() > 0;
         byte var2;
         byte var3;
         byte var4 = (byte)((var3 = var2 = PacketManager.readByte()) & 15);
         var3 = (byte)(var3 >> 4 & 15);
         Unit var10000 = new Unit();
         Unit var5 = var10000;
         var10000.method_810((byte)0);
         var5.method_815((byte)0);
         var5.setId(var0);
         var5.setIsOnHero(var1);
         var5.method_806(var2);
         var5.method_814(PacketManager.readShort());
         var5.method_813(PacketManager.readShort());
         var5.method_824(PacketManager.readShort());
         var5.method_812(PacketManager.readShort());
         var5.method_811(PacketManager.readShort());
         var5.method_825(var5.method_801());
         var5.method_816(PacketManager.readShort());
         var5.method_817(PacketManager.readShort());
         var5.method_818(PacketManager.readShort());
         var5.method_819(PacketManager.readShort());
         var5.method_820(PacketManager.readByte());
         var5.method_805((byte)0, PacketManager.readByte());
         var5.method_821(var5.method_800());
         var5.method_822(PacketManager.readByte());
         var5.setQuantity(PacketManager.readInt());
         var5.setName(PacketManager.readString());
         var5.setRaceId((byte)(var4 + 1));
         var5.setImageIndex(var3);
         byte var7 = PacketManager.readByte();
         var5.method_809((byte)(var7 >> 4 & 15));
         var5.method_808((byte)(var7 & 15));
         int[] var8;
         (var8 = new int[2])[0] = PacketManager.readInt();
         var8[1] = PacketManager.readInt();
         var5.method_751(var8);
         var5.setWhereIsLocated(PacketManager.readString());
         return var5;
      } catch (Exception var6) {
         return null;
      }
   }

   // $FF: renamed from: a () mobak.b.b.a.f
   private static final MainMenuScreen getCastleMenu() {
      try {
         MainMenuScreen mainMenuScreen = new MainMenuScreen((short)-104);
         short length = PacketManager.readShort();
         String[][] var2 = new String[1][length + 1];
         short[] var3 = new short[length];

         for(short i = 0; i < length; ++i) {
            var3[i] = PacketManager.readShort();
            var2[0][i] = PacketManager.readString();
         }

         mainMenuScreen.setMapName(PacketManager.readString());
         mainMenuScreen.setCurrentMenuName(PacketManager.readString());
         var2[0][length] = MessagesContainer.getMessage(125);
         byte raceId = PacketManager.readByte();
         mainMenuScreen.popupMenu = new PopupMenu((byte[])null, new byte[]{(byte)52, (byte)64, (byte)97, (byte)95, (byte)103, (byte)104}, (byte[][])null);
         mainMenuScreen.popupMenu.method_595(true, (byte)85, (short)93);
         mainMenuScreen.popupMenu.method_595(true, (byte)106, (short)299);
         mainMenuScreen.popupMenu.method_595(true, (byte)88, (short)52);
         mainMenuScreen.popupMenu.method_595(true, (byte)87, (short)95);
         mainMenuScreen.popupMenu.method_595(true, (byte)102, (short)181);
         mainMenuScreen.method_157((byte)0);
         mainMenuScreen.setMainMenuType((byte)2);
         mainMenuScreen.method_158(var2);
         mainMenuScreen.method_156(var3);
         mainMenuScreen.method_161((byte)length, true);
         mainMenuScreen.setRace(Hero.getRaceId(raceId));
         byte var7 = PacketManager.readByte();

         for(int i = 0; i < var7; ++i) {
            boolean var9 = PacketManager.readByte() != 0;
            String var11 = PacketManager.readString();
            short var5 = PacketManager.readShort();
            MessagesContainer.method_568(var5, var11);
            raceId = PopupMenu.method_635(var5);
            mainMenuScreen.popupMenu.method_595(var9, raceId, var5);
         }

         Screen.method_47();
         return mainMenuScreen;
      } catch (Exception var6) {
         SocketListener.logMessage("City Entry " + var6.getMessage());
         return null;
      }
   }

   // $FF: renamed from: b () mobak.b.b.a.f
   private static final MainMenuScreen getGateMenu() {
      try {
         MainMenuScreen mainMenuScreen = new MainMenuScreen((short)-102);
         mainMenuScreen.setCurrentMenuName(MessagesContainer.getMessage(200));
         short var1;
         if((var1 = PacketManager.readShort()) > 0) {
            String[][] var2;
            (var2 = new String[2][var1 + 1])[0] = new String[]{MessagesContainer.getMessage(33), MessagesContainer.getMessage(32)};
            short[] var3 = new short[var1];
            long[] var4 = new long[var1];

            for(byte var5 = 0; var5 < var1 && !PacketManager.packetDataIsEmpty(); ++var5) {
               var3[var5] = PacketManager.readShort();
               var2[1][var5] = PacketManager.readString();
               var4[var5] = PacketManager.readLong();
            }

            var2[1][var1] = MessagesContainer.getMessage(34);
            mainMenuScreen.method_156(var3);
            mainMenuScreen.method_158(var2);
            mainMenuScreen.method_159(var4);
         } else {
            mainMenuScreen.method_158(new String[][]{{MessagesContainer.getMessage(32)}});
         }

         mainMenuScreen.setMainMenuType((byte)3);
         mainMenuScreen.method_157((byte)0);
         mainMenuScreen.method_162(0);
         mainMenuScreen.method_127(false);
         mainMenuScreen.popupMenu = new PopupMenu((byte[])null, new byte[]{(byte)55}, (byte[][])null);
         return mainMenuScreen;
      } catch (Exception var6) {
         return null;
      }
   }

   // $FF: renamed from: a () mobak.b.b.i
   private static final MapObject getMapObject() {
      try {
         boolean var1 = false;
         int var2 = PacketManager.readInt();
         byte typeId = PacketManager.readByte();
         int var0 = GlobalStorage.method_687(var2, typeId);
         Object mapObject;
         if((var0) == -1) {
            if(typeId == 1) {
               mapObject = new HeroObject(PacketManager.readByte());
            } else {
               mapObject = new MapObject();
            }

            var1 = true;
            ((MapObject)mapObject).method_406(var2);
            ((MapObject)mapObject).setType(typeId);
         } else {
            mapObject = GlobalStorage.method_682(var0);
            if(typeId == 1) {
               PacketManager.readByte();
            }
         }

         class_67 var9 = GlobalStorage.method_714(((MapObject)mapObject).getType());
         byte actionsCount;
         if((byte)((typeId = PacketManager.readByte()) & 1) == 1) {
            actionsCount = PacketManager.readByte();
            ((MapObject)mapObject).method_428(actionsCount);
         }

         if((byte)(typeId & 2) == 2) {
            ((MapObject)mapObject).method_425(PacketManager.readByte());
            ((MapObject)mapObject).method_426((byte)0);
         }

         if((byte)(typeId & 4) == 4) {
            ((MapObject)mapObject).setName(PacketManager.readString());
         }

         if((byte)(typeId & 8) == 8) {
            if((actionsCount = PacketManager.readByte()) == 0) {
               ((MapObject)mapObject).setActions((int[])null);
            } else {
               int[] actions = new int[actionsCount];

               for(byte b = 0; !PacketManager.packetDataIsEmpty() && b < actionsCount; ++b) {
                  actions[b] = PacketManager.readInt();
               }

               ((MapObject)mapObject).setActions(actions);
            }
         }

         if(var1 && var9 != null) {
            MapObject.method_421();
            MapObject.method_423();
            ((MapObject)mapObject).method_422(var9.field_539);
         }

         if((byte)(typeId & 16) == 16) {
            byte x = PacketManager.readByte();
            byte y = PacketManager.readByte();
            ((MapObject)mapObject).method_411(x, y, false);
         }

         if(var1) {
            GlobalStorage.method_689((MapObject)mapObject);
         }

         return (MapObject)mapObject;
      } catch (Exception var7) {
         SocketListener.logMessage("MessageProcessor.getMapObject()" + var7.getMessage());
         return null;
      }
   }

   // $FF: renamed from: a (boolean) mobak.b.a.e
   private static final Item createItem(boolean var0) {
      try {
         Item item = new Item(var0);
         item.method_791(PacketManager.readInt());
         item.setIsOnHero(PacketManager.readByte() > 0);
         item.setMagicOrItem(PacketManager.readByte());
         item.setImageIndex(PacketManager.readInt());
         item.setRaceId(PacketManager.readByte());
         item.setName(PacketManager.readString());
         item.setDescription(PacketManager.readString());
         item.setId(PacketManager.readInt());
         item.setLvl(PacketManager.readShort());
         item.setQuantity(PacketManager.readInt());
         item.setPlace(PacketManager.readByte());
         item.setIsItemCanUse(PacketManager.readByte());
         item.setItemCategory(PacketManager.readByte());
         item.method_793(PacketManager.readByte());
         item.characteristics = new Characteristic[PacketManager.readByte()];
         if(item.characteristics.length > 0) {
            for(byte i = 0; i < item.characteristics.length && !PacketManager.packetDataIsEmpty(); ++i) {
               Characteristic[] characteristics = item.characteristics;
               Characteristic characteristic = new Characteristic();
               characteristics[i] = characteristic;
               item.characteristics[i].index = PacketManager.readInt();
               item.characteristics[i].name = MessagesContainer.characteristicsNames.getPhrase(item.characteristics[i].index);
               item.characteristics[i].value = (int) PacketManager.readPacket(PacketManager.readByte());
            }
         }

         int[] var4 = new int[3];
         var4[0] = PacketManager.readInt();
         var4[1] = PacketManager.readInt();
         var4[2] = PacketManager.readInt();
         item.method_751(var4);
         item.setWhereIsLocated(PacketManager.readString());
         return item;
      } catch (Exception var2) {
         return null;
      }
   }

   // $FF: renamed from: a (boolean) mobak.b.a.e[]
   private static final Item[] readItems(boolean var0) {
      try {
         byte itemsCount = PacketManager.readByte();
         if(itemsCount == 0) {
            return null;
         } else {
            Item[] items = new Item[itemsCount];

            for(byte i = 0; i < itemsCount && !PacketManager.packetDataIsEmpty(); ++i) {
               items[i] = createItem(var0);
            }

            return items;
         }
      } catch (Exception var4) {
         return null;
      }
   }

   // $FF: renamed from: a (boolean) boolean
   private static final boolean method_991(boolean var0) throws Exception {
      switch(PacketManager.readByte()) {
      case 0:
         ScreenDrawer.self.method_339(getCastleMenu(), var0);
         return true;
      case 1:
         SocketListener.self.method_534();
         ScreenDrawer.method_330(MessagesContainer.getMessage(119), MessagesContainer.getMessage(120));
         return true;
      default:
         return true;
      }
   }

   // $FF: renamed from: b () boolean
   private static final boolean method_992() throws Exception {
      if(Hero.self.field_702) {
         class_35.method_184();
      }

      class_10 var0 = new class_10();
      ScreenDrawer.method_334(PacketManager.readString(), PacketManager.readString(), PacketManager.readString(), var0);
      SocketListener.field_456 = PacketManager.readShort();
      ScreenDrawer.self.method_352(false);
      return true;
   }

   // $FF: renamed from: c () boolean
   private static final boolean method_993() {
      if(ScreenDrawer.self.battleScreen == null) {
         ScreenDrawer.self.battleScreen = new BattleScreen();
      }

      if(ScreenDrawer.self.battleScreen.hero == null) {
         BattleScreen battleScreen = ScreenDrawer.self.battleScreen;
         battleScreen.hero = new Hero(false);
      }

      Unit[] units = readUnits(false);
      if(units == null) {
         return true;
      } else {
         for(byte i = 0; i < units.length; ++i) {
            units[i].method_823(true);
            if(units[i] != null && units[i].getUnitPlace() >= 0 && units[i].getUnitPlace() < 5) {
               ScreenDrawer.self.battleScreen.hero.setUnit((byte)units[i].getUnitPlace(), units[i]);
            }
         }

         if(ScreenDrawer.self.battleScreen != null) {
            ScreenDrawer.self.battleScreen.method_294();
         }

         return true;
      }
   }

   // $FF: renamed from: d () boolean
   private static final boolean createUnits() throws Exception {
      Hero.self.method_907(PacketManager.readInt());
      Unit[] units = readUnits(true);
      if(units == null) {
         return false;
      } else {
         byte var1;
         for(var1 = 0; var1 < 5; ++var1) {
            Hero.self.setUnit(var1, (Unit)null);
         }

         for(var1 = 0; var1 < units.length; ++var1) {
            if(units[var1] != null && units[var1].getUnitPlace() >= 0 && units[var1].getUnitPlace() < 5) {
               Hero.self.setUnit((byte)units[var1].getUnitPlace(), units[var1]);
            }
         }

         ScreenDrawer.self.GetScreen().helpViewInit();
         if(ScreenDrawer.self.battleScreen != null) {
            ScreenDrawer.self.battleScreen.method_293();
         }

         View.field_224 = true;
         return true;
      }
   }

   // $FF: renamed from: e () boolean
   private static final boolean createItems() throws Exception {
      Hero.self.method_910(PacketManager.readInt());
      Item[] items = readItems(false);
      if(items != null && items.length != 0) {
         Item[] itemsInBag = new Item[30];

         for(int i = 0; i < items.length; ++i) {
            if(items[i] != null) {
               itemsInBag[items[i].getPlace()] = items[i];
            }
         }

         if(Hero.self == null) {
            Hero.self = new Hero(true);
         }

         Hero.self.addItemsToBag(itemsInBag);
         ScreenDrawer.self.GetScreen().helpViewInit();
      } else {
         Hero.self.addItemsToBag((Item[])null);
      }

      items = readItems(false);
      Hero.self.addItemsToHero(items);
      View.field_224 = true;
      return true;
   }

   // $FF: renamed from: f () boolean
   private static final boolean method_996() throws Exception {
      if(Hero.self == null) {
         Hero.self = new Hero(true);
      }

      Hero.self.setCoords(PacketManager.readByte(), PacketManager.readByte());
      if(ScreenDrawer.self.strategicScreen != null) {
         ScreenDrawer.self.strategicScreen.method_83(Hero.self.getPositionX(), Hero.self.getPositionY(), true);

         try {
            ScreenDrawer.self.strategicScreen.createWaveMatrix();
         } catch (Exception var0) {
            ;
         }
      }

      return true;
   }

   // $FF: renamed from: g () boolean
   private static final boolean method_997() throws Exception {
      if(ScreenDrawer.self.strategicScreen != null) {
         ScreenDrawer.self.method_357(PacketManager.readString(), PacketManager.readString());
      }

      return true;
   }

   // $FF: renamed from: h () boolean
   private static final boolean method_998() {
      if(ScreenDrawer.self.strategicScreen == null) {
         ScreenDrawer.self.strategicScreen = new StrategicScreen();
      }

      SocketListener var0 = SocketListener.self;
      synchronized(SocketListener.self) {
         try {
            if(PacketManager.readByte() == 1) {
               GlobalStorage.method_692();
            }

            short mapObjectsCount = PacketManager.readShort();

            for(int i = 0; i < mapObjectsCount; ++i) {
               getMapObject();
            }

            short var7 = PacketManager.readShort();
            if(var7 > 0) {
               for(int i = 0; !PacketManager.packetDataIsEmpty() && i < var7; ++i) {
                  GlobalStorage.method_691(PacketManager.readInt(), PacketManager.readByte());
               }
            }
         } catch (Exception var4) {
            ;
         }
      }

      if(ScreenDrawer.self.strategicScreen != null && Hero.self != null) {
         ScreenDrawer.self.strategicScreen.createWaveMatrix();
      }

      ScreenDrawer.self.strategicScreen.createWaveMatrix();
      return true;
   }

   // $FF: renamed from: i () boolean
   private static final boolean createMap() throws Exception {
      if(ScreenDrawer.self == null) {
         ScreenDrawer.self = new ScreenDrawer();
      }

      if(ScreenDrawer.self.strategicScreen != null) {
         ScreenDrawer.self.strategicScreen.method_53(false);
      }

      byte x = PacketManager.readByte();
      byte y = PacketManager.readByte();
      if(x != 0 && y != 0 && Hero.self != null) {
         Hero.self.setCoords(x, y);
         if(ScreenDrawer.self.strategicScreen != null) {
            ScreenDrawer.self.strategicScreen.method_83(x, y, true);
         }
      }

      String nameOfMap = PacketManager.readString();
      int mapId = PacketManager.readInt();
      if(PacketManager.getPacketBodySize() + OutputGameMessage.headerSize - PacketManager.readDataCount < 2500) {
         throw new Exception("Map not full");
      } else {
         byte[] mapCode = new byte[GlobalStorage.getMapDataSize()];
         PacketManager.copyBytesTo(mapCode);
         GlobalStorage.createMap(mapCode);
         Screen.nameOfMap = nameOfMap;
         if(ScreenDrawer.self.strategicScreen != null && Hero.self != null) {
            ScreenDrawer.self.strategicScreen.createWaveMatrix();
         }

         if(mapId > 0) {
            byte[] mapData = PacketManager.getMapData(2);
            if(Main2.self.rmsManager.writeData((byte)8, mapData)) {
               Main2.self.rmsManager.setInt((byte)9, mapId);
            }
         }

         GlobalStorage.method_692();
         if(ScreenDrawer.self.strategicScreen != null) {
            ScreenDrawer.self.strategicScreen.method_53(true);
         }

         return true;
      }
   }

   // $FF: renamed from: j () boolean
   private static final boolean unitSetChange() throws Exception {
      byte var0;
      byte var1 = (byte)((var0 = (byte)(PacketManager.readByte() - 1)) + 1);
      Hero var2 = Hero.self;
      if(var0 >= 50) {
         var0 = (byte)(var0 - 50);
         if(ScreenDrawer.self.battleScreen != null) {
            var2 = ScreenDrawer.self.battleScreen.hero;
         }
      }

      if(var2 == null) {
         return false;
      } else {
         Unit var3 = var2.method_878(var0);
         if(var0 >= 5) {
            if(var2 == Hero.self) {
               var3 = ScreenDrawer.self.battleScreen.method_301((byte)(var0 + 1));
            } else {
               var3 = ScreenDrawer.self.battleScreen.method_301((byte)(var0 + 51));
            }
         }

         if(var3 == null) {
            return false;
         } else {
            synchronized(var3) {
               byte var11 = var1;
               Unit var10 = var3;
               if(var3 != null) {
                  try {
                     short var12 = PacketManager.readShort();
                     int var4 = var10.getQuantity();
                     boolean var5 = false;

                     byte var6;
                     for(var6 = 0; var12 != -32768 && !PacketManager.packetDataIsEmpty(); var12 = PacketManager.readShort()) {
                        if(var12 == 1) {
                           var10.method_805(PacketManager.readByte(), PacketManager.readByte());
                        } else if(var12 == 2) {
                           var12 = PacketManager.readShort();
                           var10.method_818(var12);
                        } else if(var12 == 4) {
                           var4 = PacketManager.readInt();
                           var6 = (byte)(PacketManager.readByte() & 3);
                           var5 = true;
                        } else if(var12 == 8) {
                           var5 = true;
                        } else if(var12 == 16) {
                           var10.method_824(PacketManager.readShort());
                        } else if(var12 == 32) {
                           byte var13;
                           byte var7 = (byte)((var13 = PacketManager.readByte()) >> 4 & 15);
                           var13 = (byte)(var13 & 15);
                           if(ScreenDrawer.self.battleScreen != null) {
                              ScreenDrawer.self.battleScreen.method_308(var10.method_797(), var10.method_798(), var7, var13);
                           }

                           var10.method_809(var7);
                           var10.method_808(var13);
                        } else if(var12 == 64) {
                           var10.method_815(PacketManager.readByte());
                           var10.method_817(PacketManager.readShort());
                           var10.method_816(PacketManager.readShort());
                        } else if(var12 == 128) {
                           var10.method_810(PacketManager.readByte());
                           var10.method_811(PacketManager.readShort());
                           var10.method_812(PacketManager.readShort());
                           var10.method_813(PacketManager.readShort());
                           var10.method_814(PacketManager.readShort());
                        } else if(var12 == 256) {
                           var10.method_833(PacketManager.readByte());
                           var10.method_834();
                           var12 = PacketManager.readShort();

                           for(short var14 = 0; var14 < var12; ++var14) {
                              var10.method_829(PacketManager.readString());
                           }
                        } else if(var12 == 512) {
                           var5 = false;
                           var10.setRaceId(PacketManager.readByte());
                           var10.setImageIndex(PacketManager.readInt());
                           var10.method_806(PacketManager.readByte());
                           var10.method_820(PacketManager.readByte());
                           var10.method_819(PacketManager.readShort());
                        } else if(var12 == 1024) {
                           ScreenDrawer.self.battleScreen.method_307(false, var10.method_797(), var10.method_798());
                        }
                     }

                     if(var5 && ScreenDrawer.self.battleScreen != null) {
                        ScreenDrawer.self.battleScreen.method_305(var11, var4, var6);
                     } else {
                        var10.setQuantity(var4);
                     }
                  } catch (Exception var8) {
                     SocketListener.logMessage("unitSetChange: " + var8.getMessage());
                  }
               }
            }

            if((var0 = PacketManager.readByte()) == 1) {
               unitSetChange();
            } else if(var0 == 2) {
               activateUnit();
            }

            return true;
         }
      }
   }

   // $FF: renamed from: k () boolean
   private static final boolean method_1001() {
      SocketListener var10000 = SocketListener.self;
      OutputGameMessage var10001 = new OutputGameMessage(packetTypes[23], (short)0, (short)0);
      var10000.sendCommand(var10001);
      System.gc();
      return true;
   }

   // $FF: renamed from: l () boolean
   private static final boolean method_1002() throws Exception {
      class_9 var0 = new class_9();
      String var1 = PacketManager.readString();
      if(var1.trim().equals("")) {
         var1 = MessagesContainer.getMessage(31);
      }

      ScreenDrawer.createNotification(MessagesContainer.getMessage(1), var1, var0);
      return true;
   }

   // $FF: renamed from: m () boolean
   private static final boolean method_1003() {
      if(SocketListener.self.method_533()) {
         SocketListener.self.method_534();
      }

      return true;
   }

   // $FF: renamed from: n () boolean
   private static final boolean method_1004() {
      if(SocketListener.self.method_533()) {
         SocketListener.self.method_534();
      }

      ScreenDrawer.method_330(MessagesContainer.getMessage(29), MessagesContainer.getMessage(35));
      return true;
   }

   // $FF: renamed from: o () boolean
   private static final boolean method_1005() throws Exception {
      if(ScreenDrawer.self == null && ScreenDrawer.self.strategicScreen == null) {
         return false;
      } else {
         String var0 = PacketManager.readString();
         String var1 = PacketManager.readString();
         ScreenDrawer.self.method_357(var0, var1);
         return true;
      }
   }

   // $FF: renamed from: p () boolean
   private static final boolean method_1006() throws Exception {
      ScreenDrawer.self.method_350(true);
      Screen screen = ScreenDrawer.self.GetScreen();
      if(screen != null) {
         long var1 = PacketManager.readLong();
         String var3 = null;
         if(PacketManager.readByte() != 0) {
            var3 = PacketManager.readString();
         }

         screen.method_75(var1, var3);
      }

      return true;
   }

   // $FF: renamed from: q () boolean
   private static final boolean activateUnit() {
      try {
         if(ScreenDrawer.self.battleScreen == null) {
            return false;
         }

         byte var0 = PacketManager.readByte();
         ScreenDrawer.self.battleScreen.setActiveUnit(var0, PacketManager.readInt());
         if(ScreenDrawer.self.battleScreen.field_261) {
            byte var1 = PacketManager.readByte();
            byte[] var2 = null;
            if(var1 != 0) {
               PacketManager.copyBytesTo(var2 = new byte[var1]);
            }

            var1 = PacketManager.readByte();
            ScreenDrawer.self.battleScreen.reassureActiveUnitPosition(var0, BattleScreen.method_286(var1), BattleScreen.method_287(var1));
            ScreenDrawer.self.battleScreen.method_288(var2);
         }
      } catch (Exception var3) {
         SocketListener.logMessage("activateUnit " + var3.toString());
      }

      return true;
   }

   // $FF: renamed from: r () boolean
   private static final boolean method_1008() throws Exception {
      if(ScreenDrawer.self.battleScreen == null) {
         return false;
      } else {
         byte[] var0;
         PacketManager.copyBytesTo(var0 = new byte[PacketManager.readByte()]);
         ScreenDrawer.self.battleScreen.method_291(var0);
         switch(PacketManager.readByte()) {
         case 1:
            unitSetChange();
            break;
         case 2:
            activateUnit();
         }

         return true;
      }
   }

   // $FF: renamed from: s () boolean
   private static final boolean method_1009() throws Exception {
      if(!ScreenDrawer.self.method_362()) {
         ScreenDrawer var10000 = ScreenDrawer.self;
         ScreenDrawer.method_337();
         ScreenDrawer.self.method_363();
      }

      byte var0 = PacketManager.readByte();
      SocketListener.self.method_534();
      byte var1;
      if((var0 & 1) == 1) {
         if((var0 & 2) == 2) {
            method_1015();
         }

         if((var0 & 4) == 4) {
            method_991(false);
         }
      } else {
         if((short)(var0 & 4) == 4) {
            GlobalStorage.method_699();
         }

         PacketManager.readByte();
         ScreenDrawer.self.method_340(getCastleMenu(), false);
         var1 = PacketManager.readByte();
         byte var2 = PacketManager.readByte();
         if(var1 != 0 && var2 != 0) {
            Hero.self.setCoords(var1, var2);
         }
      }

      var1 = 0;
      if((byte)(var0 & 1) == 1) {
         var1 = 2;
      }

      if((var0 & 6) != 0 || (var0 & 1) == 0) {
         var1 = (byte)((var1 = (byte)(var1 << 4)) | 4);
      }

      if(ScreenDrawer.self.method_322() != 3) {
         ScreenDrawer.self.setScreenId((byte)3);
      }

      ScreenDrawer.self.battleScreen.method_278(var1);
      ScreenDrawer.self.strategicScreen.createWaveMatrix();
      return true;
   }

   // $FF: renamed from: t () boolean
   private static final boolean method_1010() throws Exception {
      byte var0;
      if((var0 = PacketManager.readByte()) == 1 || var0 == 2) {
         MenuScreen var1 = ScreenDrawer.self.method_342();
         ScreenDrawer.self.method_352(false);
         if(var0 == 1) {
            ScreenDrawer.method_330(MessagesContainer.getMessage(29), MessagesContainer.getMessage(44));
         } else {
            ScreenDrawer.method_330(MessagesContainer.getMessage(83), MessagesContainer.getMessage(45));
         }

         if(var1 == null) {
            return true;
         }

         ScreenDrawer.self.setScreenId((byte)2);
      }

      return true;
   }

   // $FF: renamed from: u () boolean
   private static final boolean method_1011() throws Exception {
      byte var0 = PacketManager.readByte();
      Unit var1 = method_985();
      if(var0 != 1) {
         var1.method_823(true);
      } else {
         var1.method_823(false);
      }

      int var2 = PacketManager.readInt();
      if(ScreenDrawer.self.battleScreen != null) {
         ScreenDrawer.self.battleScreen.method_298(var0 == 1, var1, var2);
      }

      return true;
   }

   // $FF: renamed from: v () boolean
   private static final boolean method_1012() throws Exception {
      ScreenDrawer.self.method_340(MenuScreen.method_135(PacketManager.readString()), true);
      return true;
   }

   // $FF: renamed from: w () boolean
   private static final boolean createHero() throws Exception {
      if(Hero.self == null) {
         Hero.self = new Hero(true);
      }

      Hero.self.heroId = PacketManager.readInt();
      Hero.self.setHeroName(PacketManager.readString());
      Hero.self.setLvl(PacketManager.readShort());
      Hero.self.setExp(PacketManager.readInt());
      Hero.self.setGoldValue(PacketManager.readLong());
      Hero.self.setGemsValue(PacketManager.readInt());
      GlobalStorage.gemToGoldValue = PacketManager.readInt();
      Hero.self.race = PacketManager.readByte();
      Hero.self.setHeroImageId(PacketManager.readShort());
      short count = PacketManager.readShort();
      Characteristic[] characteristics;
      Characteristic characteristic;
      short curCharacteristic;
      if(count > 0) {
         characteristics = new Characteristic[count];

         for(curCharacteristic = 0; curCharacteristic < count; ++curCharacteristic) {
            characteristic = new Characteristic();
            characteristics[curCharacteristic] = characteristic;
            characteristics[curCharacteristic].index = PacketManager.readInt();
            characteristics[curCharacteristic].name = MessagesContainer.characteristicsNames.getPhrase(characteristics[curCharacteristic].index);
            characteristics[curCharacteristic].value = (int) PacketManager.readPacket(PacketManager.readByte());
         }

         Hero.self.characteristics = characteristics;
      }

      if((count = PacketManager.readShort()) > 0) {
         characteristics = new Characteristic[count];

         for(curCharacteristic = 0; curCharacteristic < count; ++curCharacteristic) {
            characteristic = new Characteristic();
            characteristics[curCharacteristic] = characteristic;
            characteristics[curCharacteristic].index = PacketManager.readInt();
            characteristics[curCharacteristic].name = MessagesContainer.characteristicsNames.getPhrase(characteristics[curCharacteristic].index);
            characteristics[curCharacteristic].value = (int) PacketManager.readPacket(PacketManager.readByte());
         }

         Hero.self.skills = characteristics;
      }

      String[] statusMessages = new String[(short) PacketManager.readByte()];

      for(byte i = 0; i < statusMessages.length; ++i) {
         statusMessages[i] = PacketManager.readString();
      }

      Hero.self.setStatus(statusMessages);
      Button[] buttons = new Button[(short) PacketManager.readByte()];

      for(byte i = 0; i < buttons.length; ++i) {
         buttons[i] = method_1034();
      }

      Hero.self.addButtons(buttons);
      if((GlobalStorage.ArmyByGemsCost = PacketManager.readInt()) <= 0) {
         GlobalStorage.ArmyByGemsCost = 1;
      }

      ScreenDrawer.self.method_341();
      return true;
   }

   // $FF: renamed from: x () boolean
   private static final boolean method_1014() {
      try {
         short var0 = PacketManager.readShort();
         if(SocketListener.self.field_472 == var0) {
            SocketListener.self.method_535();
         }

         return true;
      } catch (Exception var1) {
         return false;
      }
   }

   // $FF: renamed from: y () boolean
   private static final boolean method_1015() {
      try {
         method_1016(false);
         return true;
      } catch (Exception var1) {
         SocketListener.method_523(var1);
         return false;
      }
   }

   // $FF: renamed from: a (boolean) void
   private static void method_1016(boolean var0) throws Exception {
      int var1 = PacketManager.readInt();
      int var2 = PacketManager.readInt();
      class_34 var10000;
      class_34 var6;
      if(!var0) {
         var10000 = new class_34(var1);
         var6 = var10000;
      } else {
         var10000 = new class_34(0, var1);
         var6 = var10000;
      }

      ScreenDrawer.self.method_340(var6, var2 == 1);
      byte var7 = PacketManager.readByte();
      var6.method_167(var7);

      for(byte var8 = 0; var8 < var7 && !PacketManager.packetDataIsEmpty(); ++var8) {
         byte var3 = PacketManager.readByte();
         int[][] var4 = new int[PacketManager.readByte()][2];

         for(byte var5 = 0; var5 < var4.length && !PacketManager.packetDataIsEmpty(); ++var5) {
            var4[var5][0] = PacketManager.readInt();
            var4[var5][1] = PacketManager.readInt();
         }

         var6.method_168(var8, var3, var4);
      }

   }

   // $FF: renamed from: z () boolean
   private static final boolean method_1017() {
      try {
         byte var0;
         boolean var1 = ((var0 = PacketManager.readByte()) & 4) == 4;
         boolean var2 = (byte)(var0 & 2) == 2;
         boolean var3 = (byte)(var0 & 1) == 1;
         boolean var4 = (byte)(var0 & 16) == 16;
         boolean var12 = (byte)(var0 & 8) == 8;
         short var5;
         String[] var6 = new String[var5 = PacketManager.readShort()];
         String[] var7 = new String[var5];
         int[] var8 = new int[var5];
         int[] var9 = new int[var5];

         for(short var10 = 0; !PacketManager.packetDataIsEmpty() && var10 < var5; ++var10) {
            var8[var5 - 1 - var10] = PacketManager.readInt();
            var6[var10] = PacketManager.readString();
            var7[var10] = PacketManager.readString();
            var9[var10] = PacketManager.readInt();
         }

         if(!var1 && !var12) {
            class_35.method_173().method_187(var6, var7, var8, var9);
         } else if(var1) {
            class_35.method_173().method_189(var6, var7, var8, var9, var2, var3, var4);
         } else if(var12) {
            class_35.method_173().method_190(var6, var7, var8, var9);
         }

         return true;
      } catch (Exception var11) {
         SocketListener.logMessage("MessageProcessor.chatMessages() " + var11.getMessage());
         return false;
      }
   }

   // $FF: renamed from: A () boolean
   private static final boolean method_1018() {
      try {
         byte var0 = PacketManager.readByte();
         short var1 = PacketManager.readShort();
         String[] var7;
         if(var0 == 1) {
            var7 = new String[var1];
            int[] var2 = new int[var1];

            for(int var3 = 0; var3 < var1 && !PacketManager.packetDataIsEmpty(); ++var3) {
               var2[var3] = PacketManager.readInt();
               var7[var3] = PacketManager.readString();
            }

            class_35.method_173().method_175(var7, var2);
         } else if(var0 == 2) {
            var7 = new String[var1];
            String[] var9 = new String[var1];
            int[] var10 = new int[var1];
            int[] var4 = new int[var1];

            for(int var5 = 0; var5 < var1 && !PacketManager.packetDataIsEmpty(); ++var5) {
               var7[var5] = PacketManager.readString();
               var9[var5] = PacketManager.readString();
               var10[var5] = PacketManager.readInt();
               var4[var5] = PacketManager.readInt();
            }

            byte var11 = PacketManager.readByte();
            byte var8 = PacketManager.readByte();
            class_35.method_173().method_177(var7, var9, var10, var4, var11 == 1, var8 == 1);
         }

         return true;
      } catch (Exception var6) {
         SocketListener.logMessage(var6.getMessage());
         return false;
      }
   }

   // $FF: renamed from: B () boolean
   private static final boolean method_1019() {
      try {
         short var0;
         class_76[] var1 = new class_76[var0 = PacketManager.readShort()];

         for(short var2 = 0; var2 < var0 && !PacketManager.packetDataIsEmpty(); ++var2) {
            int var3 = PacketManager.readInt();
            short var4 = PacketManager.readShort();
            byte var5 = PacketManager.readByte();
            byte var6 = PacketManager.readByte();
            byte var7 = PacketManager.readByte();
            String var8 = PacketManager.readString();
            class_76 var10002 = new class_76(var4, var5, var6, var7, var8, var3);
            var1[var2] = var10002;
         }

         ScreenDrawer var10000 = ScreenDrawer.self;
         class_41 var10001 = new class_41(var1);
         var10000.method_340(var10001, true);
      } catch (Exception var9) {
         SocketListener.logMessage("invitation " + var9.getMessage());
      }

      return true;
   }

   // $FF: renamed from: C () boolean
   private static final boolean method_1020() {
      SocketListener.self.method_534();

      try {
         String var0 = PacketManager.readString();
         String var1;
         if((var1 = PacketManager.readString()) != null && !var1.equals("")) {
            ScreenDrawer.method_330(var0, var1);
         }

         short var3;
         if((var3 = PacketManager.readShort()) == 0) {
            ScreenDrawer.self.method_352(false);
         } else {
            SocketListener.self.method_529(var3, false);
         }
      } catch (Exception var2) {
         SocketListener.logMessage("cancel: " + var2.getMessage());
      }

      return true;
   }

   // $FF: renamed from: D () boolean
   private static final boolean method_1021() {
      ErrorUserDataNotifyLabel notifyLabel = new ErrorUserDataNotifyLabel();
      SocketListener.self.method_537(false);
      ScreenDrawer.createNotification(MessagesContainer.getMessage(135), MessagesContainer.getMessage(168), notifyLabel);
      return true;
   }

   // $FF: renamed from: E () boolean
   private static final boolean method_1022() {
      try {
         PacketManager.readInt();
         int var0 = PacketManager.readInt();
         int var1 = PacketManager.readInt();
         class_35.method_173().method_176(var0, var1);
      } catch (Exception var2) {
         SocketListener.logMessage(var2.getMessage());
      }

      return true;
   }

   // $FF: renamed from: F () boolean
   private static final boolean method_1023() throws Exception {
      Hero.self.setGoldValue(PacketManager.readLong());
      return true;
   }

   // $FF: renamed from: G () boolean
   private static final boolean method_1024() throws Exception {
      String var0 = PacketManager.readString();
      GlobalStorage.field_563 = PacketManager.readInt();
      int var1;
      if((var1 = PacketManager.readInt()) == 0) {
         var1 = Integer.MAX_VALUE;
      }

      ScreenDrawer var10000 = ScreenDrawer.self;
      class_43 var10001 = new class_43(var0, var1);
      var10000.method_340(var10001, true);
      return true;
   }

   // $FF: renamed from: H () boolean
   private static final boolean method_1025() throws Exception {
      String var0 = PacketManager.readString();
      String var1 = MessagesContainer.getMessage(299);
      String var2 = MessagesContainer.getMessage(300);
      class_36 var10000 = new class_36(var1, var2, var0);
      class_36 var3 = var10000;
      PopupMenu var10001 = new PopupMenu((byte[])null, new byte[]{(byte)55, (byte)103}, (byte[][])null);
      var10000.popupMenu = var10001;
      ScreenDrawer.self.method_340(var3, true);
      return true;
   }

   // $FF: renamed from: I () boolean
   private static final boolean method_1026() throws Exception {
      String var0 = PacketManager.readString();
      String var1 = PacketManager.readString();
      Main2.self.rmsManager.setString((byte)17, var0);
      Main2.self.rmsManager.setString((byte)2, var1);
      return true;
   }

   // $FF: renamed from: J () boolean
   private static final boolean method_1027() throws Exception {
      byte var0 = PacketManager.readByte();
      method_991(true);
      if(var0 == 1) {
         GlobalStorage.method_699();
      }

      return true;
   }

   // $FF: renamed from: K () boolean
   private static final boolean method_1028() throws Exception {
      if(ScreenDrawer.self.battleScreen != null) {
         ScreenDrawer.self.battleScreen.method_306((byte)1);
         byte var0;
         if((var0 = PacketManager.readByte()) != 3) {
            if(var0 != 2) {
               ScreenDrawer.self.battleScreen.method_307(var0 == 1, (byte)-1, (byte)-1);
            }
         } else {
            var0 = PacketManager.readByte();
            byte var1 = PacketManager.readByte();
            ScreenDrawer.self.battleScreen.method_307(false, var0, var1);
         }
      }

      return true;
   }

   // $FF: renamed from: L () boolean
   private static final boolean method_1029() throws Exception {
      switch(PacketManager.readByte()) {
      case 1:
         ScreenDrawer.self.method_352(true);
         break;
      case 2:
         ScreenDrawer.self.method_352(false);
         break;
      case 3:
         method_1002();
      }

      return true;
   }

   // $FF: renamed from: M () boolean
   private static final boolean method_1030() throws Exception {
      short var0 = PacketManager.readShort();

      for(short var1 = 0; var1 < var0; ++var1) {
         short var2 = PacketManager.readShort();
         int var3 = PacketManager.readInt();
         int var4 = PacketManager.readDataCount;
         method_983(getPacketTypeIndex(var2));
         if(PacketManager.readDataCount != var4 + var3) {
            SocketListener.logMessage("WARNING: bad multiple part length");
            PacketManager.readDataCount = var4 + var3;
         }

         if(SocketListener.self.method_521(var2)) {
            SocketListener.self.method_534();
         }
      }

      return true;
   }

   // $FF: renamed from: N () boolean
   private static final boolean method_1031() {
      Item var0 = createItem(false);
      Hero.self.method_925(var0);
      return true;
   }

   // $FF: renamed from: a (mobak.b.b.a.t) void
   private static final void method_1032(MenuScreen var0) throws Exception {
      short var1;
      short var2;
      if((var1 = PacketManager.readShort()) > 0) {
         for(var2 = 0; var2 < var1; ++var2) {
            var0.popupMenu.method_594(true, method_1034());
         }
      }

      if((var1 = PacketManager.readShort()) > 0) {
         for(var2 = 0; var2 < var1; ++var2) {
            var0.popupMenu.method_594(false, method_1034());
         }
      }

   }

   // $FF: renamed from: O () boolean
   private static final boolean method_1033() throws Exception {
      short var0;
      short var3;
      String var10;
      class_36 var10000;
      switch(var0 = PacketManager.readShort()) {
      case -109:
         String var8 = PacketManager.readString();
         var10 = PacketManager.readString();
         short var11 = PacketManager.readShort();
         String[] var12 = new String[var3 = PacketManager.readShort()];
         int[] var13 = new int[var3];

         int var6;
         for(var6 = 0; var6 < var3; ++var6) {
            var12[var6] = PacketManager.readString();
         }

         for(var6 = 0; var6 < var3; ++var6) {
            var13[var6] = PacketManager.readInt();
         }

         var10000 = new class_36(var8, var10, var12, var13);
         class_36 var14 = var10000;
         var10000.method_41(var11);
         if(var11 != 0) {
            var14.popupMenu.method_595(false, (byte)95, (short)298);
         }

         method_1032(var14);
         ScreenDrawer.self.method_340(var14, true);
         return true;
      case -108:
         byte var7;
         if((var7 = PacketManager.readByte()) != 1 && var7 != 3) {
            var10 = PacketManager.readString();
            String var2 = PacketManager.readString();
            var3 = PacketManager.readShort();
            String var4 = PacketManager.readString();
            var10000 = new class_36(var10, var2, var4);
            class_36 var5 = var10000;
            var10000.method_41(var3);
            method_1032(var5);
            ScreenDrawer.self.method_340(var5, true);
            if(var3 != 0) {
               var5.popupMenu.method_595(false, (byte)95, (short)298);
            }
         } else {
            MenuScreen var1;
            (var1 = ScreenDrawer.self.method_342()).method_129(PacketManager.readString());
            if(var7 == 3) {
               var1.popupMenu.method_628();
               method_1032(var1);
            }
         }

         return true;
      case -100:
         ScreenDrawer.self.setScreenId((byte)2);
         return true;
      default:
         boolean var9 = true;
         ScreenDrawer var16;
         switch(var0) {
         case -13:
            var16 = ScreenDrawer.self;
            class_41 var19 = new class_41();
            var16.method_340(var19, true);
            break;
         case -12:
         case -2:
         case -1:
            var16 = ScreenDrawer.self;
            class_39 var18 = new class_39(var0);
            var16.method_340(var18, true);
         case -11:
         case -10:
         case -9:
         case -8:
         case -7:
         case -6:
         default:
            break;
         case -5:
            var16 = ScreenDrawer.self;
            ViewHelp var17 = new ViewHelp(var0);
            var16.method_340(var17, true);
            break;
         case -4:
         case -3:
            var16 = ScreenDrawer.self;
            class_40 var10001 = new class_40(var0);
            var16.method_340(var10001, true);
         }

         return true;
      }
   }

   // $FF: renamed from: a () mobak.b.b.a.v
   private static Button method_1034() throws Exception {
      Button var10000 = new Button(PacketManager.readInt());
      Button var0 = var10000;
      short var2 = PacketManager.readShort();
      var10000.field_544 = var2;
      int var1 = var0.field_543;
      if((var0.field_543 >> 24 & 32) == 32) {
         var2 = PacketManager.readShort();
         var0.field_545 = var2;
      }

      if(var0.method_651()) {
         var0.method_654(PacketManager.readString());
      }

      if(var0.method_657()) {
         byte var6;
         String[] var7 = new String[var6 = PacketManager.readByte()];
         short[] var3 = new short[var6];
         int[] var4 = new int[var6];

         for(byte var5 = 0; var5 < var6; ++var5) {
            var7[var5] = PacketManager.readString();
            var3[var5] = PacketManager.readShort();
            var4[var5] = PacketManager.readInt();
         }

         var0.method_655(var7);
         var0.field_548 = var3;
         var0.field_549 = var4;
      }

      return var0;
   }

   // $FF: renamed from: P () boolean
   private static boolean method_1035() throws Exception {
      short var0 = PacketManager.readShort();
      String var1 = PacketManager.readString();
      short var2 = PacketManager.readShort();
      byte var3;
      class_64[] var4 = new class_64[var3 = PacketManager.readByte()];

      for(byte var5 = 0; var5 < var3; ++var5) {
         byte var6 = PacketManager.readByte();
         byte var7 = PacketManager.readByte();
         String var8 = PacketManager.readString();
         class_64 var10002 = new class_64(var7, var6, var8);
         var4[var5] = var10002;
         if(var4[var5].field_505 == 2) {
            String[] var11 = new String[var6 = PacketManager.readByte()];
            boolean[] var14 = new boolean[var6];

            for(byte var9 = 0; var9 < var6; ++var9) {
               var11[var9] = PacketManager.readString();
               var14[var9] = PacketManager.readByte() == 1;
            }

            var4[var5].field_507 = var11;
            var4[var5].field_508 = var14;
         }

         class_64 var10000;
         if(var4[var5].field_505 == 1) {
            var10000 = var4[var5];
            int var15;
            int var12 = var15 = PacketManager.readInt();
            class_64 var10 = var10000;
            var10000.field_509 = var12;
            var10.field_510 = var15;
         }

         if(var4[var5].field_505 == 3) {
            var10000 = var4[var5];
            String var13 = PacketManager.readString();
            var10000.field_511 = var13;
         }
      }

      new FormCreator(var4, var1, var0, var2);
      return true;
   }

   // $FF: renamed from: Q () boolean
   private static boolean method_1036() throws Exception {
      StrategicScreen var10000;
      switch(PacketManager.readByte()) {
      case 2:
         var10000 = ScreenDrawer.self.strategicScreen;
      case 3:
         var10000 = ScreenDrawer.self.strategicScreen;
      case 4:
         ScreenDrawer.self.method_342();
      default:
         Screen var0;
         if((var0 = ScreenDrawer.self.GetScreen()) == null) {
            return false;
         } else {
            short var1 = PacketManager.readShort();

            short var2;
            for(var2 = 0; var2 < var1; ++var2) {
               var0.popupMenu.method_594(false, method_1034());
            }

            var1 = PacketManager.readShort();

            for(var2 = 0; var2 < var1; ++var2) {
               var0.popupMenu.method_594(true, method_1034());
            }

            return true;
         }
      }
   }

   // $FF: renamed from: R () boolean
   private static boolean method_1037() throws Exception {
      class_37 var10000 = new class_37(PacketManager.readInt(), PacketManager.readShort());
      class_37 var0 = var10000;
      var10000.method_41(PacketManager.readShort());
      var0.setCurrentMenuName(PacketManager.readString());
      String[] var1 = new String[class_37.method_202(var0.method_205())];

      short var2;
      for(var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = PacketManager.readString();
      }

      var0.method_208(var1, 0);
      var1 = new String[class_37.method_202(var0.method_206())];

      for(var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = PacketManager.readString();
      }

      var0.method_208(var1, 1);
      var0.method_209(0, PacketManager.readByte(), PacketManager.readByte());
      var0.method_209(1, PacketManager.readByte(), PacketManager.readByte());
      var0.method_211(0, PacketManager.readShort());
      var0.method_211(1, PacketManager.readShort());
      var0.method_212(0, PacketManager.readByte());
      var0.method_212(1, PacketManager.readByte());
      byte var4 = PacketManager.readByte();
      var0.method_210(0, (var4 & 8) > 0, (var4 & 4) > 0);
      var0.method_210(1, (var4 & 2) > 0, (var4 & 1) > 0);
      boolean var3;
      if(var3 = PacketManager.readByte() != 0) {
         var0.method_200();
      }

      Object var5;
      if(!var0.method_215()) {
         var0.method_213(0, PacketManager.readShort());
         var5 = null;
         switch(var0.method_207()) {
         case 1:
            var5 = readUnits(true);
            break;
         case 2:
            var5 = readItems(false);
         }

         var0.method_201((byte)0, (Thing[])var5);
      }

      var0.method_213(1, PacketManager.readShort());
      var5 = null;
      switch(var0.method_207()) {
      case 1:
         var5 = readUnits(true);
         break;
      case 2:
         var5 = readItems(var3);
      }

      var0.method_201((byte)1, (Thing[])var5);
      if(var0.method_214()) {
         ScreenDrawer.self.method_346();
      }

      var0.method_127(var3);
      ScreenDrawer.self.method_340(var0, true);
      return true;
   }

   // $FF: renamed from: S () boolean
   private static boolean method_1038() {
      try {
         method_1016(true);
      } catch (Exception var1) {
         SocketListener.method_523(var1);
      }

      return true;
   }

   // $FF: renamed from: T () boolean
   private static final boolean method_1039() {
      try {
         int itemId = PacketManager.readInt();
         int previousItemsCount = PacketManager.readInt();
         Item item = createItem(false);
         Hero.self.changeItemsInBag(itemId, previousItemsCount);
         Hero.self.addItemOnHero(item);
         ScreenDrawer.self.GetScreen().helpViewInit();
      } catch (Exception var3) {
         ;
      }

      return true;
   }

   // $FF: renamed from: U () boolean
   private static final boolean method_1040() {
      try {
         int removedItemId = PacketManager.readInt();
         Item item = createItem(false);
         Hero.self.method_922(removedItemId);
         Hero.self.addItemToBag(item);
         ScreenDrawer.self.GetScreen().helpViewInit();
      } catch (Exception var2) {
         ;
      }

      return true;
   }

   // $FF: renamed from: V () boolean
   private static final boolean readCharacteristicsNames() {
      addPhrases(MessagesContainer.characteristicsNames);
      return true;
   }

   // $FF: renamed from: W () boolean
   private static final boolean method_1042() {
      addPhrases(MessagesContainer.field_503);
      return true;
   }

   // $FF: renamed from: X () boolean
   private static final boolean method_1043() {
      addPhrases(MessagesContainer.field_501);
      return true;
   }

   // $FF: renamed from: a (mobak.c.h) void
   private static final void addPhrases(PhraseCollection phraseCollection) {
      try {
         short length = PacketManager.readShort();

         for(int i = 0; i < length; ++i) {
            int id = PacketManager.readInt();
            String phrase = PacketManager.readString();
            phraseCollection.addPhraseWithID(id, phrase);
         }

      } catch (Exception var5) {
         ;
      }
   }

   // $FF: renamed from: Y () boolean
   private static final boolean method_1045() throws Exception {
      Hero.self.setGemsValue(PacketManager.readInt());
      return true;
   }

   // $FF: renamed from: Z () boolean
   private static final boolean method_1046() {
      ScreenDrawer.self.GetScreen();
      Screen.method_74();
      return true;
   }

   // $FF: renamed from: aa () boolean
   private static final boolean method_1047() {
      ScreenDrawer.self.GetScreen().method_76();
      return true;
   }

   // $FF: renamed from: ab () boolean
   private static final boolean method_1048() {
      Button var10000 = new Button((byte)30);
      Button var0 = var10000;
      short var2 = packetTypes[86];
      var10000.field_544 = var2;
      var0.method_656((short)261);
      var0.method_655(new String[]{MessagesContainer.getMessage(262, new String[]{String.valueOf(GlobalStorage.field_563)})});
      short[] var3 = new short[]{(short)3};
      var0.field_548 = var3;
      int[] var4 = new int[]{2};
      var0.field_549 = var4;
      var0.method_654(MessagesContainer.getMessage(263));
      var2 = packetTypes[86];
      var0.field_545 = var2;
      ScreenDrawer.self.GetScreen().method_38(var0);
      return true;
   }

   // $FF: renamed from: ac () boolean
   private static final boolean method_1049() throws Exception {
      ScreenDrawer.self.GetScreen();
      Screen.method_55(PacketManager.readShort());
      return true;
   }

   // $FF: renamed from: ad () boolean
   private static final boolean method_1050() throws Exception {
      String var0 = PacketManager.readString();
      Main2.gotoUrl1(var0);
      return true;
   }

   // $FF: renamed from: ae () boolean
   private static final boolean method_1051() throws Exception {
      Characteristic[] var0 = null;
      short var1;
      Characteristic var10002;
      if((var1 = PacketManager.readShort()) > 0) {
         var0 = new Characteristic[var1];

         for(short var2 = 0; var2 < var1; ++var2) {
            var10002 = new Characteristic();
            var0[var2] = var10002;
            var0[var2].index = PacketManager.readInt();
            var0[var2].name = MessagesContainer.characteristicsNames.getPhrase(var0[var2].index);
            var0[var2].value = (int) PacketManager.readPacket(PacketManager.readByte());
         }
      }

      Characteristic[] var4 = null;
      if((var1 = PacketManager.readShort()) > 0) {
         var4 = new Characteristic[var1];

         for(short var3 = 0; var3 < var1; ++var3) {
            var10002 = new Characteristic();
            var4[var3] = var10002;
            var4[var3].index = PacketManager.readInt();
            var4[var3].name = MessagesContainer.characteristicsNames.getPhrase(var4[var3].index);
            var4[var3].value = (int) PacketManager.readPacket(PacketManager.readByte());
         }
      }

      Hero.self.method_892(var0, var4);
      return true;
   }

   // $FF: renamed from: af () boolean
   private static final boolean method_1052() {
      formCreator = new FormCreator(MessagesContainer.getLine(9), field_738);
      formCreator.createLabel(MessagesContainer.getMessage(280), userData != null? userData.heroName :"", 32, 0);
      formCreator.createLabel(MessagesContainer.getMessage(289), userData != null? userData.login :"", 32, 0);
      formCreator.createLabel(MessagesContainer.getMessage(291), userData != null? userData.password :"", 16, 0);
      formCreator.addCommandAtIndex(MessagesContainer.getLine(8), 0);
      formCreator.addCommandAtIndex(MessagesContainer.getLine(34), 1);
      formCreator.setCurrentFormAsMain();
      return true;
   }

   // $FF: renamed from: ag () boolean
   private static final boolean method_1053() throws Exception {
      SocketListener.self.method_534();
      boolean var0 = PacketManager.readByte() != 0;
      String var1 = PacketManager.readString();
      class_13 var10002 = new class_13(var0);
      ScreenDrawer.createNotification("", var1, var10002);
      if(var0 && userData != null) {
         Main2.self.rmsManager.setString((byte)17, userData.login);
         Main2.self.rmsManager.setString((byte)2, userData.password);
      }

      return true;
   }

   // $FF: renamed from: ah () boolean
   private static boolean method_1054() throws Exception {
      PacketManager.readByte();
      return true;
   }

   // $FF: renamed from: ai () boolean
   private static boolean method_1055() throws Exception {
      int var0 = PacketManager.readInt();

      for(int var1 = 0; var1 < var0; ++var1) {
         String var2 = PacketManager.readString();
         String var3 = PacketManager.readString();
         StringBuffer var4 = new StringBuffer();
         var4.append(var2).append(':').append(var3);
         field_739.addElement(var4.toString());
      }

      return true;
   }

   // $FF: renamed from: aj () boolean
   private static boolean getImagesVersion() {
      try {
         long var0 = PacketManager.readLong();
         Main2.self.rmsManager.getLong((byte)27, 0L);
         if(var0 != Main2.self.rmsManager.getLong((byte)27, 0L)) {
            Main2.self.rmsManager.deleteAll((byte)95);
            boolean needWrite = true;
            int length = PacketManager.readInt();

            for(int i = 0; i < length; ++i) {
               String var5 = PacketManager.readString();
               byte[] var6 = new byte[PacketManager.readInt()];
               PacketManager.copyBytesTo(var6);
               if(needWrite) {
                  needWrite = Main2.self.rmsManager.setFile(var5, var6);
               }
            }

            if(needWrite) {
               byte[] data = new byte[8];
               data[7] = (byte)((int)(var0 & 255L));
               data[6] = (byte)((int)(var0 >> 8 & 255L));
               data[5] = (byte)((int)(var0 >> 16 & 255L));
               data[4] = (byte)((int)(var0 >> 24 & 255L));
               data[3] = (byte)((int)(var0 >> 32 & 255L));
               data[2] = (byte)((int)(var0 >> 40 & 255L));
               data[1] = (byte)((int)(var0 >> 48 & 255L));
               data[0] = (byte)((int)(var0 >> 56 & 255L));
               Main2.self.rmsManager.writeData((byte)27, data);
            }
         }

         return false;
      } catch (Exception var14) {
         SocketListener.logMessage("MessageProcessor.getImagesVersion() ERROR");
         return false;
      }
   }

   // $FF: renamed from: a () mobak.b.b.g
   static FormCreator method_1057() {
      return formCreator;
   }

   // $FF: renamed from: a (mobak.i) mobak.i
   static UserData method_1058(UserData var0) {
      userData = var0;
      return var0;
   }

   // $FF: renamed from: a () mobak.i
   static UserData method_1059() {
      return userData;
   }

   // $FF: renamed from: <clinit> () void
   static{
      messagesContainer = new String[0];
      packetTypes = new short[]{(short)12, (short)10002, (short)10001, (short)3002, (short)10000, (short)18, (short)24, (short)74, (short)72, (short)63, (short)1012, (short)16, (short)26, (short)64, (short)21, (short)73, (short)25, (short)20, (short)61, (short)27, (short)65, (short)60, (short)22, (short)1, (short)100, (short)101, (short)102, (short)103, (short)104, (short)105, (short)106, (short)107, (short)108, (short)109, (short)110, (short)111, (short)112, (short)113, (short)114, (short)115, (short)116, (short)117, (short)118, (short)119, (short)120, (short)121, (short)122, (short)123, (short)124, (short)125, (short)126, (short)127, (short)128, (short)129, (short)130, (short)131, (short)132, (short)133, (short)134, (short)135, (short)136, (short)137, (short)138, (short)139, (short)140, (short)141, (short)142, (short)143, (short)144, (short)145, (short)146, (short)147, (short)148, (short)149, (short)150, (short)151, (short)153, (short)169, (short)170, (short)171, (short)173, (short)174, (short)175, (short)192, (short)193, (short)206, (short)208, (short)209, (short)199, (short)201, (short)213, (short)224, (short)225, (short)226, (short)227, (short)228, (short)229, (short)230, (short)231, (short)232, (short)233, (short)234, (short)235, (short)236, (short)237, (short)238, (short)10003, (short)10005, (short)10004, (short)10006, (short)10007, (short)10008, (short)10011, (short)10012, (short)10013, (short)10009, (short)10010, (short)10015, (short)10016, (short)10017, (short)10018};
      formCreator = null;
      userData = null;
      field_738 = new class_86();
      field_739 = new Vector();
   }
}
