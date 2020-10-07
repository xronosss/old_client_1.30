package mobak.a.a;

import mobak.a.SocketListener;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.a.a.e
final class class_10 extends NotifyLabel {

   // $FF: renamed from: <init> () void
   class_10() {
      super();
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      try {
         OutputGameMessage var10000 = new OutputGameMessage(SocketListener.field_456, (short)1, (short)0);
         OutputGameMessage var1 = var10000;
         var10000.addToBody((byte)1);
         SocketListener.self.sendCommand(var1);
      } catch (Exception var2) {
         ;
      }

      return true;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      try {
         OutputGameMessage var10000 = new OutputGameMessage(SocketListener.field_456, (short)1, (short)0);
         OutputGameMessage var1 = var10000;
         var10000.addToBody((byte)2);
         SocketListener.self.sendCommand(var1);
      } catch (Exception var2) {
         ;
      }

      return true;
   }
}
