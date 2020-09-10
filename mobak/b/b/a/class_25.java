package mobak.b.b.a;

import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.b.ScreenDrawer;
import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.b.b.a.q
final class class_25 extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.a.p
   private final class_41 field_21;


   // $FF: renamed from: <init> (mobak.b.b.a.p) void
   class_25(class_41 var1) {
      super();
      this.field_21 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      ScreenDrawer.self.method_346();
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      try {
         OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[85]);
         OutputGameMessage var1 = var10000;
         var10000.addToBody(this.field_21.field_228);
         SocketListener.self.sendCommand(var1);
         ScreenDrawer.self.method_346();
      } catch (Exception var2) {
         SocketListener.method_523(var2);
      }

      return true;
   }
}
