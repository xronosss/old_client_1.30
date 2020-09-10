package mobak.b.b.a;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Graphics;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Thing;
import mobak.b.a.Item;
import mobak.b.a.Unit;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_55;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.ac
public final class ViewHelp extends View {

   // $FF: renamed from: a mobak.b.a.e[]
   private Item[] field_244;


   // $FF: renamed from: b (javax.microedition.lcdui.Graphics, short, short) void
   public static void method_270(Graphics var0, short var1, short var2) {
      MenuScreen.method_131(var0, var1, var2, 0);
      byte var3 = (byte)(30 - GlobalStorage.method_718((byte)5, 4));
      ScreenDrawer.method_372(var0, Unit.method_796((byte)5), 300, 42, 61 - var3 - 2, 42, 0, var1 + var3, var2 + 5 + 1, 0);
   }

   // $FF: renamed from: c (javax.microedition.lcdui.Graphics, short, short) void
   public static void method_271(Graphics var0, short var1, short var2) {
      MenuScreen.method_131(var0, var1, var2, 0);
      ScreenDrawer.method_372(var0, Item.method_781(0), 0, 0, 55, 47, 0, var1 + 1, var2 + 3 + 1, 0);
   }

   // $FF: renamed from: b () void
   private void method_272() {
      if(this.field_244 == null) {
         this.field_244 = new Item[10];
      } else {
         for(byte var1 = 0; var1 < this.field_244.length; ++var1) {
            this.field_244[var1] = null;
         }
      }

      Hero.self.method_917(this.field_244);
      super.field_53.method_495();
   }

   // $FF: renamed from: a (short) mobak.b.b.a.ac
   public static ViewHelp method_273(short var0) throws IOException {
      String var10000 = String.valueOf(var0);
      boolean var10001;
      switch(var0) {
      case -5:
      case -2:
      case -1:
      case 4:
      case 8:
      case 32:
      case 64:
         var10001 = true;
         break;
      default:
         var10001 = false;
      }

      boolean var1 = var10001;
      String var8 = var10000;
      InputStream var9;
      if((var9 = Main2.self.getClass().getResourceAsStream("/mobak/help/" + var8)) == null) {
         return null;
      } else {
         byte[] var2 = Main2.method_862(var9);
         var9.close();
         ViewHelp var14 = new ViewHelp((short)-11);
         ViewHelp var10 = var14;
         var14.helpViewInit();
         String var11 = new String(var2, "UTF-8");

         while(var11 != null && !var11.equals("")) {
            String var3;
            if(var11.indexOf("\n") > 0) {
               var3 = var11.substring(0, var11.indexOf("\n") - 1);
               var11 = var11.substring(var11.indexOf("\n") + 1);
            } else {
               var3 = var11;
               var11 = null;
            }

            int var4;
            for(var4 = 0; var4 < var3.length() && !Character.isDigit(var3.charAt(var4)) && var3.charAt(var4) != 35 && var3.charAt(var4) != 47; ++var4) {
               ;
            }

            if(var4 >= var3.length()) {
               var3 = "";
            } else if(var4 > 0) {
               var3 = var3.substring(var4);
            }

            if(!var3.startsWith("#") && !var3.startsWith("//")) {
               short var12 = Short.parseShort(var3.substring(0, var3.indexOf(" ")));
               var3 = var3.substring(var3.indexOf(" "));
               if(var12 > 0) {
                  class_55 var13 = var10.field_53;
                  var10.field_53.field_429 += 5;
                  int var7 = var13.field_429;
                  var13.method_489(var3, Screen.field_26, (byte)66, false, -1);
                  var13.method_497(var12, (short)1, (short)var7, var1);
                  if(var13.field_429 < var7 + 8 + 53) {
                     var13.field_429 = var7 + 8 + 53;
                  }
               } else {
                  var10.field_53.field_429 += 5;
                  var10.field_53.method_490(var3, Screen.field_26, false, -1);
               }
            }
         }

         return var10;
      }
   }

   // $FF: renamed from: <init> (short) void
   public ViewHelp(short var1) {
      super(var1);
      this.field_244 = null;

      try {
         ScreenDrawer.self.method_364();
         Item.method_780();
         PopupMenu var10001;
         switch(var1) {
         case -11:
         case -7:
            this.method_57((short)10, (short)(this.method_136() + 8), (short)(ScreenDrawer.self.getWidth() - 20), (short)(ScreenDrawer.self.getHeight() - this.method_136() - PopupMenu.method_583() - 16 - 10), true);
            var10001 = new PopupMenu((byte[])null, new byte[]{(byte)55}, (byte[][])null);
            super.popupMenu = var10001;
            super.field_116 = MessagesContainer.getMessage(298);
         case -5:
            this.method_57((short)10, (short)(this.method_136() + 8), (short)(ScreenDrawer.self.getWidth() - 75), (short)(ScreenDrawer.self.getHeight() - this.method_136() - 16 - PopupMenu.method_583() - 10), true);

            try {
               var10001 = new PopupMenu(new byte[]{(byte)74, (byte)86}, new byte[]{(byte)51, (byte)55, (byte)95}, (byte[][])null);
               super.popupMenu = var10001;
               Button var10000 = new Button((byte)30);
               Button var6 = var10000;
               short var3 = MessageProcessor.packetTypes[90];
               var10000.field_544 = var3;
               var6.method_656((short)269);
               var3 = MessageProcessor.packetTypes[90];
               var6.field_545 = var3;
               super.popupMenu.method_594(false, var6);
            } catch (Exception var4) {
               SocketListener.logMessage("popupMenu create");
            }

            super.field_225 = this.method_144(true);
            super.field_116 = MessagesContainer.getMessage(93);
            super.field_229 = 0;
            super.field_228 = 0;
            this.method_51();
            break;
         default:
            return;
         }
      } catch (Exception var5) {
         SocketListener.logMessage("ViewHelp () " + var5);
      }

   }

   // $FF: renamed from: d (java.lang.String) void
   public final void method_274(String var1) {
      super.field_53.method_490(var1, Screen.field_26, false, -1);
   }

   // $FF: renamed from: e () boolean
   protected final boolean method_254() {
      if(super.field_52 != -7 && super.field_52 != -11) {
         super.method_255((short)0);
      } else {
         ScreenDrawer.self.method_346();
      }

      return true;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      try {
         super.method_30(var1);
         if(super.field_52 == -5) {
            try {
               this.method_261(var1);
               if(super.field_53.method_496()) {
                  StringBuffer var2 = new StringBuffer();

                  try {
                     var2.append(Hero.self.method_890());
                     super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                     (var2 = var2.delete(0, var2.toString().length())).append(MessagesContainer.getMessage(18)).append(": ").append(MessagesContainer.method_574(Hero.self.race));
                     super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                     (var2 = var2.delete(0, var2.toString().length())).append(MessagesContainer.getMessage(102)).append(": ").append(Hero.self.method_905());
                     super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                     (var2 = var2.delete(0, var2.toString().length())).append(MessagesContainer.getMessage(101, new String[]{String.valueOf(Hero.self.method_902()), String.valueOf(Hero.self.method_906() + 1)}));
                     super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                     var2 = var2.delete(0, var2.toString().length());
                     String[] var3 = Hero.self.method_928();

                     for(byte var4 = 0; var4 < var3.length; ++var4) {
                        var2.append(var3[var4]);
                        super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                        var2 = var2.delete(0, var2.toString().length());
                     }
                  } catch (Exception var7) {
                     SocketListener.logMessage("1 " + var7);
                  }

                  byte currentCharacteriscticNumber;
                  int additionalValue;
                  try {
                     if(Hero.self.characteristics != null && Hero.self.characteristics.length > 0) {
                        var2.append("\n").append(MessagesContainer.getMessage(103)).append(": ");
                        super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                        var2 = var2.delete(0, var2.toString().length());

                        for(currentCharacteriscticNumber = 0; currentCharacteriscticNumber < Hero.self.characteristics.length; ++currentCharacteriscticNumber) {
                           var2.append(Hero.self.characteristics[currentCharacteriscticNumber].name).append(": ").append(Hero.self.characteristics[currentCharacteriscticNumber].value);
                           if((additionalValue = Hero.getAddedCharacteristicsValue((short) Hero.self.characteristics[currentCharacteriscticNumber].index)) > 0) {
                              var2.append(" \f7").append("+").append(Math.abs(additionalValue));
                           } else if(additionalValue < 0) {
                              var2.append(" \f2").append("-").append(Math.abs(additionalValue));
                           }

                           if((additionalValue = Hero.self.method_893(Hero.self.characteristics, (byte) Hero.self.characteristics[currentCharacteriscticNumber].index, 0) - (Hero.self.characteristics[currentCharacteriscticNumber].value + additionalValue)) != 0) {
                              if(additionalValue > 0) {
                                 var2.append(" \f7").append("+").append(Math.abs(additionalValue));
                              } else if(additionalValue < 0) {
                                 var2.append(" \f2").append("-").append(Math.abs(additionalValue));
                              }
                           }

                           var2.append("\f1\n");
                           super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                           var2 = var2.delete(0, var2.toString().length());
                        }
                     }
                  } catch (Exception var6) {
                     SocketListener.logMessage("2: " + var6);
                  }

                  try {
                     if(Hero.self.skills != null && Hero.self.skills.length > 0) {
                        var2.append("\n").append(MessagesContainer.getMessage(104)).append(": ");
                        super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                        var2 = var2.delete(0, var2.toString().length());

                        for(currentCharacteriscticNumber = 0; currentCharacteriscticNumber < Hero.self.skills.length; ++currentCharacteriscticNumber) {
                           var2.append(Hero.self.skills[currentCharacteriscticNumber].name).append(": ").append(Hero.self.skills[currentCharacteriscticNumber].value);
                           if((additionalValue = Hero.getAddedCharacteristicsValue((short) Hero.self.skills[currentCharacteriscticNumber].index)) > 0) {
                              var2.append(" \f7").append("+").append(Math.abs(additionalValue));
                           } else if(additionalValue < 0) {
                              var2.append(" \f2").append("-").append(Math.abs(additionalValue));
                           }

                           if((additionalValue = Hero.self.method_893(Hero.self.skills, (byte) Hero.self.skills[currentCharacteriscticNumber].index, 0) - (Hero.self.skills[currentCharacteriscticNumber].value + additionalValue)) != 0) {
                              if(additionalValue > 0) {
                                 var2.append(" \f7").append("+").append(Math.abs(additionalValue));
                              } else if(additionalValue < 0) {
                                 var2.append(" \f2").append("-").append(Math.abs(additionalValue));
                              }
                           }

                           var2.append("\f1\n");
                           super.field_53.method_490(var2.toString(), Screen.field_26, false, -1);
                           var2 = var2.delete(0, var2.toString().length());
                        }
                     }
                  } catch (Exception var5) {
                     SocketListener.logMessage("3: " + var5);
                  }
               }
            } catch (Exception var8) {
               SocketListener.logMessage("PopupMenu text " + var8.getMessage());
            }
         } else if(super.field_53 != null) {
            super.field_53.method_484(var1, (byte)0);
         }

         super.popupMenu.method_604(var1);
      } catch (Exception var9) {
         SocketListener.logMessage("ViewHelp " + var9.getMessage());
      }
   }

   // $FF: renamed from: c (int) void
   protected final void method_39(int var1) {
      if(super.field_52 != -7 && super.field_52 != -11) {
         super.method_39(var1);
      } else {
         if(ScreenDrawer.self.getGameAction(var1) == 6) {
            super.field_53.method_486();
            return;
         }

         if(ScreenDrawer.self.getGameAction(var1) == 1) {
            super.field_53.method_485();
            return;
         }
      }

   }

   // $FF: renamed from: a (byte, int) void
   private static void method_275(byte var0, int var1) {
      Item[] var6 = Hero.self.method_889(var0);
      Item[] var2 = new Item[var1];
      short var3 = 0;

      short i;
      for(i = 0; i < var6.length; ++i) {
         if(var6[i] != null && var6[i].isOnHero() && var6[i].isCanUse() == 0) {
            if(var2[var3] == null) {
               var2[var3] = var6[i];
               if(++var3 >= var1) {
                  var3 = 0;
               }
            } else {
               for(short var5 = 0; var5 < var1; ++var5) {
                  if(var2[var5].method_752((byte)1) < var6[i].method_752((byte)1)) {
                     var2[var5] = var6[i];
                     break;
                  }
               }
            }
         }
      }

      for(i = 0; i < var1; ++i) {
         Hero.method_920(var2[i]);
      }

   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button var1) {
      switch(var1.method_652()) {
      case 48:
         method_275((byte)3, 1);
         method_275((byte)4, 1);
         method_275((byte)2, 1);
         method_275((byte)5, 1);
         method_275((byte)1, 2);
         method_275((byte)6, 4);
         this.method_272();
         return true;
      case 74:
         Item[] items = Hero.self.method_889(method_276(super.field_228));
         boolean var2 = false;
         if(items != null) {
            for(byte i = 0; i < items.length; ++i) {
               if(items[i] != null && items[i].isCanUse() <= 0) {
                  var2 = true;
                  break;
               }
            }
         }

         if(!var2) {
            ScreenDrawer.method_330(MessagesContainer.getMessage(74), MessagesContainer.getMessage(126));
            return true;
         } else {
            ScreenDrawer var9 = ScreenDrawer.self;
            byte var6 = method_276(super.field_228);
            class_39 var10001 = new class_39((short)-6);
            class_39 var7 = var10001;
            var10001.method_265(var6);
            var7.method_51();
            var9.method_340(var7, true);
            this.method_56();
            return true;
         }
      case 86:
         try {
            throw new Exception();
         } catch (Exception var4) {
            var4.printStackTrace();
            Thing[] var3;
            if((var3 = this.method_250((byte)0)) != null && var3.length > super.field_228) {
               if(var3[super.field_228] == null) {
                  return false;
               }

               Hero var10000 = Hero.self;
               Hero.method_921((Item)var3[super.field_228]);
               this.method_272();
               this.method_51();
               this.method_56();
               return true;
            }

            return false;
         }
      default:
         return super.method_38(var1);
      }
   }

   // $FF: renamed from: a () void
   public final void method_51() {
      super.popupMenu.method_617(true, false);
      if(super.field_52 == -5) {
         if(this.method_256() == null) {
            super.popupMenu.method_600((byte)74, false);
            return;
         }

         super.popupMenu.method_600((byte)86, false);
      }

   }

   // $FF: renamed from: a (byte) byte
   private static byte method_276(byte var0) {
      switch(var0) {
      case 0:
         return (byte)3;
      case 1:
      case 2:
      case 3:
      case 4:
         return (byte)6;
      case 5:
      case 6:
         return (byte)1;
      case 7:
         return (byte)4;
      case 8:
         return (byte)2;
      case 9:
         return (byte)5;
      default:
         return (byte)-1;
      }
   }

   // $FF: renamed from: a (byte) mobak.b.a.a[]
   protected final Thing[] method_250(byte var1) {
      switch(super.field_52) {
      case -5:
         return this.field_244;
      default:
         return super.method_250(var1);
      }
   }

   // $FF: renamed from: b (boolean) void
   protected final void method_249(boolean var1) {
      if(super.field_52 == -5) {
         byte var2;
         if((var2 = var1?(byte)(super.field_228 + 1):(byte)(super.field_228 - 1)) < 0 || var2 >= 10) {
            return;
         }

         super.field_228 = var2;
         if(super.field_226[super.field_229] > super.field_228) {
            this.method_260(super.field_229, super.field_228);
         }

         if(super.field_228 - super.field_226[super.field_229] >= super.field_225) {
            this.method_260(super.field_229, (byte)(super.field_228 - super.field_225 + 1));
         }
      }

   }

   // $FF: renamed from: g () void
   public final void helpViewInit() {
      switch(super.field_52) {
      case -5:
         this.method_272();
         this.method_51();
         super.helpViewInit();
      default:
      }
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      if(super.field_52 == -5) {
         return super.method_59(var1, var2);
      } else {
         super.field_53.method_506(var1, var2);
         Screen.field_34 = var1;
         Screen.field_35 = var2;
         Screen.field_36 = var1;
         Screen.field_37 = var2;
         Screen.field_38 = true;
         return false;
      }
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      if(var2 < ScreenDrawer.self.getHeight() - PopupMenu.method_583()) {
         if(super.field_52 == -5) {
            return super.method_60(var1, var2, var3);
         }

         if(super.field_52 == -7 || super.field_52 == -11) {
            super.field_53.method_508();
            super.field_235 = 0;
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: b (int, int) boolean
   protected final boolean method_62(int var1, int var2) {
      if(super.field_52 == -5) {
         return super.method_62(var1, var2);
      } else {
         var1 = var2 - Screen.field_37;
         if(super.field_53.method_507()) {
            super.field_53.method_503(super.field_53.method_502() - var1);
            Screen.field_37 = var2;
         }

         return false;
      }
   }
}
