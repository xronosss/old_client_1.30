package mobak.a.a;

import mobak.a.SocketListener;
import mobak.b.a.Hero;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.a.a.c
final class class_12 extends NotifyLabel {

   // $FF: renamed from: <init> () void
   class_12() {
      super();
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[33], (short)5, MessageProcessor.packetTypes[6]);
      OutputGameMessage var1 = var10000;

      try {
         var1.addToBody(Hero.self.field_688);
         var1.addToBody((byte)1);
         SocketListener.self.sendCommand(var1);
      } catch (Exception var2) {
         SocketListener.logMessage(var2.getMessage());
      }

      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[33], (short)5, MessageProcessor.packetTypes[17]);
      OutputGameMessage var1 = var10000;

      try {
         var1.addToBody(Hero.self.field_688);
         var1.addToBody((byte)2);
         SocketListener.self.sendCommand(var1);
      } catch (Exception var2) {
         SocketListener.logMessage(var2.getMessage());
      }

      return true;
   }
}
