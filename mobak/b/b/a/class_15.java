package mobak.b.b.a;

import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.b.b.a.h
final class class_15 extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.a.f
   private final MainMenuScreen field_15;


   // $FF: renamed from: <init> (mobak.b.b.a.f) void
   class_15(MainMenuScreen var1) {
      super();
      this.field_15 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[30], (short)4, MessageProcessor.packetTypes[10]);
      OutputGameMessage var1 = var10000;

      try {
         var1.addToBody(this.field_15.field_132 + 1);
      } catch (Exception var3) {
         SocketListener.logMessage(var3.getMessage());
      }

      SocketListener.self.sendCommand(var1);
      GlobalStorage.method_699();
      return true;
   }
}
