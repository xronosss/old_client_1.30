package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Thing;
import mobak.b.a.Unit;
import mobak.b.a.Hero;
import mobak.b.b.ScreenDrawer;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.a
public final class class_40 extends View {

   // $FF: renamed from: a mobak.b.a.a[]
   private Thing[] field_239;
   // $FF: renamed from: g boolean
   private boolean field_240;


   // $FF: renamed from: <init> (short) void
   public class_40(short var1) {
      super(var1);
      this.field_239 = null;
      this.field_240 = true;
      this.method_57((short)81, (short)(this.method_136() + 8), (short)(ScreenDrawer.self.getWidth() - 32 - 61), (short)(ScreenDrawer.self.getHeight() - this.method_136() - PopupMenu.method_583() - 40), true);
      super.field_227 = new short[]{(short)46};
      super.field_225 = this.method_144(true);
      PopupMenu var10001;
      switch(var1) {
      case -4:
         super.field_116 = MessagesContainer.getMessage(52);
         var10001 = new PopupMenu((byte[])null, new byte[]{(byte)52, (byte)55, (byte)73, (byte)72, (byte)95}, (byte[][])null);
         super.popupMenu = var10001;
         super.popupMenu.method_615((byte)73);
         super.field_227[0] = (short)(super.field_227[0] | 2048);
         ScreenDrawer.field_293 = ScreenDrawer.self.battleScreen.hero.method_880();
      case -3:
         super.field_116 = MessagesContainer.getMessage(52);
         var10001 = new PopupMenu(new byte[]{(byte)79}, new byte[]{(byte)51, (byte)55, (byte)100, (byte)48, (byte)98, (byte)95}, (byte[][])null);
         super.popupMenu = var10001;
         super.field_227[0] = (short)(super.field_227[0] | 4096);
         super.field_227[0] = (short)(super.field_227[0] | 16);
         super.popupMenu.method_597((short)186, (byte)79);
         super.popupMenu.method_597((short)187, (byte)98);
         return;
      default:
      }
   }

   // $FF: renamed from: e () boolean
   protected final boolean method_254() {
      return this.method_255((short)0);
   }

   // $FF: renamed from: a (byte) mobak.b.a.a[]
   protected final Thing[] method_250(byte var1) {
      Thing[] var2 = this.field_239;
      boolean var10000;
      if(View.field_224) {
         View.field_224 = false;
         var10000 = true;
      } else if(var2 == null) {
         var10000 = true;
      } else {
         short var3 = 0;

         while(true) {
            if(var3 >= var2.length) {
               var10000 = false;
               break;
            }

            if(var2[var3] == null) {
               var10000 = true;
               break;
            }

            if(var2[var3].getQuantity() == 0) {
               var10000 = true;
               break;
            }

            ++var3;
         }
      }

      if(var10000) {
         Thing[] var10001;
         label32: {
            if(var1 == 0) {
               switch(super.field_52) {
               case -4:
               case -3:
                  var10001 = this.field_240? MenuScreen.method_141(Hero.self.method_880()): MenuScreen.method_141(ScreenDrawer.field_293);
                  break label32;
               case -2:
               default:
                  break;
               case -1:
                  var10001 = MenuScreen.method_141(Hero.self.method_882((byte)1));
                  break label32;
               }
            }

            var10001 = null;
         }

         this.field_239 = var10001;
      }

      return this.field_239;
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button var1) {
      int var2 = var1.field_543;
      OutputGameMessage var10000;
      Thing var7;
      OutputGameMessage var9;
      switch((byte)var1.field_543) {
      case 48:
         class_19 var10 = new class_19(this);
         class_19 var8 = var10;
         ScreenDrawer.method_334(MessagesContainer.getLine(135), MessagesContainer.getLine(246), "", var8);
         return true;
      case 72:
         this.field_240 = false;
         this.field_239 = null;
         super.field_228 = 0;
         this.method_260(super.field_229, 0);
         this.method_56();
         super.popupMenu.method_616((byte)73);
         super.popupMenu.method_615((byte)72);
         this.setCurrentMenuName(ScreenDrawer.self.battleScreen.hero.method_890());
         return true;
      case 73:
         this.field_240 = true;
         this.field_239 = null;
         super.field_228 = 0;
         this.method_56();
         super.popupMenu.method_615((byte)73);
         super.popupMenu.method_616((byte)72);
         this.setCurrentMenuName(MessagesContainer.getMessage(52));
         return true;
      case 79:
         if(super.field_230) {
            try {
               if((var7 = this.method_256()).method_739() > 0) {
                  var10000 = new OutputGameMessage(MessageProcessor.packetTypes[71], (short)8, MessageProcessor.packetTypes[17]);
                  var9 = var10000;
                  var10000.addToBody(var7.getId());
                  var9.addToBody(var7.method_739());
                  var7.method_740(0);
                  SocketListener.self.sendCommand(var9);
               }
            } catch (Exception var5) {
               SocketListener.logMessage("" + var5);
            }
         }

         this.method_257();
         this.method_51();
         return true;
      case 98:
         try {
            var7 = this.method_256();
            var10000 = new OutputGameMessage(MessageProcessor.packetTypes[72], (short)8, MessageProcessor.packetTypes[17]);
            var9 = var10000;
            var10000.addToBody(var7.getId());
            SocketListener.self.sendCommand(var9);
         } catch (Exception var4) {
            SocketListener.logMessage("" + var4);
         }

         this.method_51();
         return true;
      case 100:
         if(this.field_240) {
            try {
               super.popupMenu.method_597((short)52, (byte)100);
               var10000 = new OutputGameMessage(MessageProcessor.packetTypes[67], (short)0, MessageProcessor.packetTypes[7]);
               OutputGameMessage var6 = var10000;
               var10000.addToBody((byte)1);
               SocketListener.self.sendCommand(var6);
            } catch (Exception var3) {
               SocketListener.logMessage(var3.getMessage());
            }
         } else {
            super.popupMenu.method_597((short)172, (byte)100);
         }

         this.field_240 = !this.field_240;
         this.field_239 = null;
         this.method_56();
         this.method_260(super.field_229, 0);
         super.field_228 = 0;
         return true;
      default:
         return super.method_38(var1);
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      try {
         if(super.field_52 == -3 && this.field_240) {
            this.method_51();
            if(Hero.self.method_909() <= 0) {
               super.popupMenu.method_599((byte)100, true, false);
            } else {
               super.popupMenu.method_599((byte)100, false, false);
            }
         }

         super.method_259(var1);
         if(super.field_230) {
            this.method_145(var1, ScreenDrawer.self.getHeight() / 2);
         }

      } catch (Exception var2) {
         SocketListener.logMessage("ArmyView " + var2.getMessage());
      }
   }

   // $FF: renamed from: a () void
   public final void method_51() {
      if(super.field_52 != -4) {
         super.popupMenu.method_617(true, false);
         if(super.field_52 == -3) {
            if(Hero.self.method_914() != 5 && this.field_240) {
               super.popupMenu.method_616((byte)79);
               super.popupMenu.method_600((byte)79, false);
            } else {
               super.popupMenu.method_615((byte)79);
            }

            Thing var1 = this.method_256();
            Unit[] var2 = Hero.self.method_880();
            short var3 = 0;

            boolean var10000;
            while(true) {
               if(var2 == null || var3 >= var2.length) {
                  var10000 = false;
                  break;
               }

               if(var2[var3] != null && var2[var3] != var1 && var2[var3].method_755(var1)) {
                  var10000 = true;
                  break;
               }

               ++var3;
            }

            if(var10000) {
               super.popupMenu.method_616((byte)98);
               super.popupMenu.method_600((byte)98, false);
            } else {
               super.popupMenu.method_615((byte)98);
            }
         }

         if(super.field_52 != -3 || super.field_229 != 0) {
            super.method_51();
         }
      }
   }

   // $FF: renamed from: g () void
   public final void helpViewInit() {
      this.field_239 = null;
      super.helpViewInit();
   }

   // $FF: renamed from: a (mobak.b.b.a.a) void
   static void method_266(class_40 var0) {
      Thing var1;
      if((var1 = var0.method_256()) != null) {
         OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[68]);
         OutputGameMessage var2 = var10000;
         if(!var0.field_240) {
            var2.addToBody((byte)2);
            Hero.self.method_908(-1);
         } else {
            if(Hero.self.method_914() <= 1) {
               ScreenDrawer.method_330(MessagesContainer.getMessage(135), MessagesContainer.getMessage(165));
               return;
            }

            var2.addToBody((byte)1);
            Hero.self.setUnit((byte)var1.getPlace(), (Unit)null);
         }

         if(var0.field_228 > 0) {
            --var0.field_228;
         }

         if(var0.field_228 < var0.field_226[var0.field_229]) {
            var0.method_260(var0.field_229, var0.field_228);
         }

         var1.setQuantity(0);
         var0.method_56();
         var2.addToBody(var1.getId());
         SocketListener.self.sendCommand(var2);
      }

   }
}
