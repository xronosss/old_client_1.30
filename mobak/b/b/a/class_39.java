package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Thing;
import mobak.b.a.Item;
import mobak.b.a.Characteristic;
import mobak.b.a.Hero;
import mobak.b.b.ScreenDrawer;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.c
public final class class_39 extends View {

   // $FF: renamed from: f byte
   private byte field_237;
   // $FF: renamed from: g boolean
   private boolean field_238;


   // $FF: renamed from: <init> (short) void
   public class_39(short var1) {
      super(var1);
      this.field_237 = -1;
      this.field_238 = false;
      this.method_57((short)81, (short)(this.method_136() + 8), (short)(ScreenDrawer.self.getWidth() - 32 - 61), (short)(ScreenDrawer.self.getHeight() - this.method_136() - PopupMenu.method_583() - 40), true);
      Item.method_780();
      super.field_227 = new short[]{(short)110};
      super.field_225 = this.method_144(true);
      PopupMenu var10001;
      Item[] var3;
      switch(var1) {
      case -12:
         super.field_116 = MessagesContainer.getMessage(95);
         super.field_227[0] = (short)(super.field_227[0] | 16);
         var10001 = new PopupMenu(new byte[]{(byte)81}, new byte[]{(byte)52, (byte)55, (byte)71, (byte)95, (byte)49}, new byte[][]{{(byte)70, (byte)68, (byte)67, (byte)90, (byte)69}});
         super.popupMenu = var10001;
         super.popupMenu.method_615((byte)71);
         break;
      case -6:
         super.field_116 = MessagesContainer.getMessage(95);
         var10001 = new PopupMenu(new byte[]{(byte)86, (byte)74}, new byte[]{(byte)55}, (byte[][])null);
         super.popupMenu = var10001;
         break;
      case -2:
         super.field_116 = MessagesContainer.getMessage(95);
         var10001 = new PopupMenu(new byte[]{(byte)51, (byte)86, (byte)74, (byte)79}, new byte[]{(byte)52, (byte)55, (byte)100, (byte)48, (byte)95, (byte)49}, new byte[][]{{(byte)70, (byte)68, (byte)67, (byte)90, (byte)69}});
         super.popupMenu = var10001;
         super.field_227[0] = (short)(super.field_227[0] | 4096);
         super.popupMenu.method_597((short)173, (byte)100);
         super.popupMenu.method_597((short)176, (byte)48);
         super.popupMenu.method_597((short)186, (byte)79);
         super.popupMenu.method_600((byte)48, true);
         if((var3 = Hero.self.method_882((byte)-1)) == null || var3.length == 0) {
            ScreenDrawer.method_330(MessagesContainer.getMessage(74), MessagesContainer.getMessage(133));
         }
         break;
      case -1:
         Item.method_779();
         super.field_116 = MessagesContainer.getMessage(71);
         var10001 = new PopupMenu(new byte[]{(byte)81}, new byte[]{(byte)55}, (byte[][])null);
         super.popupMenu = var10001;
         if((var3 = Hero.self.method_882((byte)1)) == null || var3.length == 0) {
            ScreenDrawer.method_330(MessagesContainer.getMessage(74), MessagesContainer.getMessage(132));
         }
      }

      super.field_229 = 0;
      super.field_228 = 0;
      this.method_51();
   }

   // $FF: renamed from: e () boolean
   protected final boolean method_254() {
      return super.method_255((short)0);
   }

   // $FF: renamed from: g () boolean
   private boolean method_262() {
      if(super.field_52 != -6 && super.field_52 != -2 && super.field_52 != -5) {
         return false;
      } else {
         Thing[] var1;
         if((var1 = this.method_250((byte)0)) != null && var1.length > super.field_228) {
            if(var1[super.field_228] == null) {
               return false;
            } else {
               Hero var10000 = Hero.self;
               Hero.method_921((Item)var1[super.field_228]);
               this.method_51();
               return true;
            }
         } else {
            return false;
         }
      }
   }

   // $FF: renamed from: h () boolean
   private boolean method_263() {
      if(super.field_52 != -6 && super.field_52 != -2) {
         return false;
      } else {
         Thing[] var1;
         if((var1 = this.method_250((byte)0)) != null && var1.length > super.field_228) {
            if(var1[super.field_228] == null) {
               return false;
            } else if(!var1[super.field_228].isOnHero()) {
               ScreenDrawer.method_330(MessagesContainer.getMessage(105), MessagesContainer.getMessage(57));
               return false;
            } else {
               Hero var10000 = Hero.self;
               Hero.method_920((Item)var1[super.field_228]);
               if(super.field_52 == -6) {
                  super.method_255((short)0);
               } else {
                  this.method_51();
               }

               return true;
            }
         } else {
            return false;
         }
      }
   }

   // $FF: renamed from: a (byte) mobak.b.a.a[]
   protected final Thing[] method_250(byte var1) {
      if(var1 != 0) {
         return null;
      } else {
         switch(super.field_52) {
         case -12:
            return MenuScreen.method_141(Hero.self.method_882(this.field_237));
         case -6:
            return MenuScreen.method_141(Hero.self.method_889(this.field_237));
         case -2:
            if(!this.field_238) {
               return MenuScreen.method_141(Hero.self.method_882(this.field_237));
            }

            return MenuScreen.method_141(ScreenDrawer.field_293);
         case -1:
            return MenuScreen.method_141(Hero.self.method_882((byte)1));
         default:
            return null;
         }
      }
   }

   // $FF: renamed from: f () boolean
   protected final boolean method_257() {
      if(super.field_52 == -1) {
         Thing[] var1;
         if((var1 = this.method_250(super.field_229)) != null && var1.length != 0 && var1.length > super.field_228 && var1[super.field_228] != null) {
            if(((Item)var1[super.field_228]).method_784() <= Hero.self.method_893(Hero.self.skills, Characteristic.field_665, 0)) {
               ScreenDrawer.self.battleScreen.field_264 = (Item)var1[super.field_228];
               super.method_255((short)0);
            } else {
               ScreenDrawer.method_330("", MessagesContainer.getMessage(123));
            }
         }

         return true;
      } else if(super.field_52 == -12) {
         super.field_230 = !super.field_230;
         return true;
      } else {
         return super.method_257();
      }
   }

   // $FF: renamed from: a (mobak.b.a.a, short) void
   protected final void method_247(Thing var1, short var2) {
      if(super.field_52 == -1) {
         var1.getDescription(super.field_53, MessagesContainer.getMessage(277, new String[]{String.valueOf(((Item)var1).method_784()), String.valueOf(Hero.self.method_893(Hero.self.skills, Characteristic.field_665, 0))}), var2);
      } else {
         var1.getDescription(super.field_53, (String)null, var2);
      }
   }

   // $FF: renamed from: a () void
   public final void method_51() {
      if(super.field_52 == -12) {
         super.popupMenu.method_615((byte)71);
         Item[] var3 = Hero.self.method_882((byte)-1);

         for(short var2 = 0; var2 < var3.length; ++var2) {
            if(var3[var2] != null && var3[var2].method_739() > 0) {
               super.popupMenu.method_616((byte)71);
               return;
            }
         }

      } else {
         super.popupMenu.method_617(true, false);
         if(!this.field_238) {
            Thing thing;
            if((thing = this.method_256()) != null && thing.isOnHero()) {
               if(super.field_52 != -2 && super.field_52 != -6) {
                  if(super.field_52 == -1) {
                     super.popupMenu.method_600((byte)81, false);
                  }
               } else {
                  if(thing.getCategory() > 0) {
                     if(thing.isCanUse() <= 0) {
                        super.popupMenu.method_600((byte)74, false);
                        return;
                     }

                     super.popupMenu.method_600((byte)86, false);
                  }

               }
            }
         }
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      try {
         if(super.field_52 == -2 && !this.field_238) {
            if(Hero.self.method_912() <= 0) {
               super.popupMenu.method_600((byte)100, true);
            } else {
               super.popupMenu.method_600((byte)100, false);
            }
         }

         if(this.method_256() != null) {
            this.method_51();
         }

         this.method_259(var1);
         if(super.field_230) {
            this.method_145(var1, ScreenDrawer.self.getHeight() / 2);
         }

      } catch (Exception var2) {
         SocketListener.logMessage("BagView " + var2.getMessage());
      }
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button var1) {
      int var2 = var1.field_543;
      OutputGameMessage var10000;
      OutputGameMessage var6;
      switch((byte)var1.field_543) {
      case 48:
         return this.method_264();
      case 66:
         this.method_265((byte)1);
         return true;
      case 67:
         this.method_265((byte)4);
         return true;
      case 68:
         this.method_265((byte)2);
         return true;
      case 69:
         this.method_265((byte)16);
         return true;
      case 70:
         this.method_265((byte)-1);
         return true;
      case 71:
         try {
            var10000 = new OutputGameMessage(MessageProcessor.packetTypes[44]);
            var6 = var10000;
            var10000.addToBody(Hero.self.field_688);
            Hero.self.field_688 = -1;
            this.method_265((byte)-1);
            Item[] var7 = Hero.self.method_882((byte)-1);
            View.method_251(var6, var7);

            for(short var3 = 0; var3 < var7.length; ++var3) {
               if(var7[var3] != null && var7[var3].method_739() > 0) {
                  var7[var3].method_740(0);
               }
            }

            SocketListener.self.sendCommand(var6);
         } catch (Exception var5) {
            SocketListener.logMessage(var5.getMessage());
         }

         return super.method_255((short)0);
      case 74:
         return this.method_263();
      case 86:
         return this.method_262();
      case 90:
         this.method_265((byte)8);
         return true;
      case 100:
         if(!this.field_238) {
            try {
               super.popupMenu.method_597((short)95, (byte)100);
               var10000 = new OutputGameMessage(MessageProcessor.packetTypes[67], (short)0, MessageProcessor.packetTypes[7]);
               var6 = var10000;
               var10000.addToBody((byte)2);
               SocketListener.self.sendCommand(var6);
            } catch (Exception var4) {
               SocketListener.logMessage(var4.getMessage());
            }
         } else {
            super.popupMenu.method_597((short)173, (byte)100);
         }

         this.field_238 = !this.field_238;
         if(this.field_238) {
            super.popupMenu.method_600((byte)48, false);
         } else {
            super.popupMenu.method_600((byte)48, true);
         }

         this.method_56();
         this.method_260(super.field_229, 0);
         super.field_228 = 0;
         return true;
      default:
         return super.method_38(var1);
      }
   }

   // $FF: renamed from: i () boolean
   private boolean method_264() {
      try {
         Thing var1;
         if((var1 = this.method_256()) == null) {
            return true;
         }

         OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[68]);
         OutputGameMessage var2 = var10000;
         if(!this.field_238) {
            var2.addToBody((byte)3);
            Hero.self.method_913((byte)var1.getPlace(), (Item)null);
         } else {
            var2.addToBody((byte)4);
            Hero.self.method_911(-1);
         }

         var1.setQuantity(0);
         this.method_56();
         var2.addToBody(var1.getId());
         SocketListener.self.sendCommand(var2);
      } catch (Exception var3) {
         SocketListener.logMessage("thing dismiss: " + var3.getMessage());
      }

      return true;
   }

   // $FF: renamed from: a (byte) void
   public final void method_265(byte var1) {
      super.field_228 = 0;
      this.method_260(super.field_229, 0);
      this.field_237 = var1;
   }
}
