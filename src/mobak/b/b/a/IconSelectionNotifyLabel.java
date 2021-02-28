package mobak.b.b.a;

import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.b.ScreenDrawer;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.b.b.a.q
final class IconSelectionNotifyLabel extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.a.p
   private final class_41 field_21;


   // $FF: renamed from: <init> (mobak.b.b.a.p) void
   IconSelectionNotifyLabel(class_41 var1) {
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
         OutputGameMessage gameMessage = new OutputGameMessage(MessageProcessor.packetTypes[85]);
         gameMessage.addToBody(this.field_21.field_228);
         SocketListener.self.sendCommand(gameMessage);
         ScreenDrawer.self.method_346();
      } catch (Exception var2) {
         SocketListener.method_523(var2);
      }

      return true;
   }
}
