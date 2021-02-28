package mobak.b.b.a;

import mobak.b.b.ScreenDrawer;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.b.b.a.m
final class class_24 extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.a.l
   private final class_34 field_20;


   // $FF: renamed from: <init> (mobak.b.b.a.l) void
   class_24(class_34 var1) {
      super();
      this.field_20 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      class_34.sendSelection(this.field_20);
      ScreenDrawer.self.method_346();
      class_34.method_172(this.field_20, 16773632);
      return true;
   }
}
