package mobak.b.b;

import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.b.b.b
final class class_29 extends NotifyLabel {

   // $FF: renamed from: <init> (mobak.b.b.a) void
   class_29(BattleScreen var1) {
      super();
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      SocketListener var10000 = SocketListener.self;
      OutputGameMessage var10001 = new OutputGameMessage(MessageProcessor.packetTypes[39], (short)0, (short)0);
      var10000.sendCommand(var10001);
      return true;
   }
}
