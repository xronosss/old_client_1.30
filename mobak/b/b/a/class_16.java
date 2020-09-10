package mobak.b.b.a;

import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.b.b.a.e
final class class_16 extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.a.d
   private final class_35 field_16;


   // $FF: renamed from: <init> (mobak.b.b.a.d) void
   class_16(class_35 var1) {
      super();
      this.field_16 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      int var1;
      if((var1 = Math.abs(class_35.method_194(this.field_16).method_493(class_35.method_193(this.field_16) + 1).method_471())) != 0) {
         try {
            OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[82], (short)4, (short)0);
            OutputGameMessage var2 = var10000;
            var10000.addToBody(var1);
            SocketListener.self.sendCommand(var2);
         } catch (Exception var3) {
            SocketListener.method_523(var3);
         }
      }

      return true;
   }
}
