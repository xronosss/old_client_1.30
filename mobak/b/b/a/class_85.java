package mobak.b.b.a;

import mobak.Main2;

// $FF: renamed from: mobak.b.b.a.g
final class class_85 implements Runnable {

   // $FF: renamed from: a mobak.b.b.a.f
   private final MainMenuScreen field_727;


   // $FF: renamed from: <init> (mobak.b.b.a.f) void
   class_85(MainMenuScreen var1) {
      super();
      this.field_727 = var1;
   }

   public final void run() {
      Main2.self.method_844((byte)1);
      this.field_727.mainMenuType = 1;
   }
}
