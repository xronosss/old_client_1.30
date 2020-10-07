package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.ab
public final class class_43 extends View {

   // $FF: renamed from: <init> (java.lang.String, int) void
   public class_43(String var1, int var2) {
      super((short)-10);
      this.method_57((short)10, (short)(this.method_136() + 8), (short)(ScreenDrawer.self.getWidth() - 20), (short)(ScreenDrawer.self.getHeight() - this.method_136() - PopupMenu.method_583() - 40), true);
      super.name = MessagesContainer.getMessage(181);
      this.helpViewInit();
      super.field_53.method_490(var1, Screen.field_26, false, -1);
      PopupMenu var10001 = new PopupMenu((byte[])null, new byte[]{(byte)51, (byte)55}, (byte[][])null);
      super.popupMenu = var10001;
      if((var2 & 1) == 1) {
         super.popupMenu.method_595(false, (byte)101, (short)179);
      }

      if((var2 & 2) == 2) {
         super.popupMenu.method_595(false, (byte)71, (short)83);
      }

      if((var2 & 8) == 8) {
         super.popupMenu.method_595(false, (byte)96, (short)259);
      }

      if((var2 & 16) == 16) {
         Button var10000 = new Button((byte)30);
         Button var4 = var10000;
         short var3 = MessageProcessor.packetTypes[86];
         var10000.packetType = var3;
         var4.method_656((short)261);
         var4.method_655(new String[]{MessagesContainer.getMessage(262, new String[]{String.valueOf(GlobalStorage.field_563)})});
         short[] var5 = new short[]{(short)3};
         var4.field_548 = var5;
         int[] var6 = new int[]{2};
         var4.field_549 = var6;
         var4.method_654(MessagesContainer.getMessage(263));
         var3 = MessageProcessor.packetTypes[86];
         var4.nextPacketType = var3;
         super.popupMenu.method_594(false, var4);
      }

   }

   // $FF: renamed from: e () boolean
   protected final boolean method_254() {
      ScreenDrawer.self.method_346();
      return true;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      super.method_30(var1);
      super.field_53.method_484(var1, (byte)0);
      super.popupMenu.method_604(var1);
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      super.field_53.method_506(var1, var2);
      Screen.field_37 = var2;
      return false;
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      super.field_53.method_508();
      return false;
   }

   // $FF: renamed from: a (int) void
   public final void onButtonClick(int var1) {
      while(var1 != 1) {
         if(var1 != 0 || super.formCreator.method_439() != 3) {
            super.onButtonClick(var1);
            return;
         }

         try {
            OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[78]);
            OutputGameMessage var3 = var10000;
            var10000.addToBody(super.formCreator.method_447(0));
            SocketListener.self.sendCommand(var3);
         } catch (Exception var2) {
            SocketListener.method_523(var2);
         }

         var1 = 1;
      }

      ScreenDrawer.self.method_376();
      super.formCreator = null;
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button button) {
      switch(button.method_652()) {
      case 96:
         ScreenDrawer var10000 = ScreenDrawer.self;
         class_41 var10001 = new class_41();
         var10000.method_340(var10001, true);
         return true;
      default:
         return super.method_38(button);
      }
   }
}
