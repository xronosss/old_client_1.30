package mobak.a.a;

import mobak.a.SocketListener;
import mobak.b.b.ScreenDrawer;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.a.a.d
final class class_11 extends NotifyLabel {

   // $FF: renamed from: <init> () void
   class_11() {
      super();
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return false;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      if(SocketListener.self.field_472 == MessageProcessor.packetTypes[34]) {
         ScreenDrawer.self.method_352(false);
      }

      ScreenDrawer.self.setScreenId((byte)3);
      if(ScreenDrawer.self.method_358()) {
         ScreenDrawer.self.method_350(true);
      }

      ScreenDrawer.self.method_376();
      return true;
   }
}
