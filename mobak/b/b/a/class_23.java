package mobak.b.b.a;

import mobak.b.b.ScreenDrawer;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.b.b.a.n
final class class_23 extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.a.l
   private final class_34 field_19;


   // $FF: renamed from: <init> (mobak.b.b.a.l) void
   class_23(class_34 var1) {
      super();
      this.field_19 = var1;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      class_34.sendSelection(this.field_19);
      ScreenDrawer.self.method_346();
      class_34.method_172(this.field_19, 16773632);
      return true;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }
}
