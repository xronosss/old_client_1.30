package mobak.b.b;

import mobak.text.NotifyLabel;
import mobak.text.class_62;

// $FF: renamed from: mobak.b.b.o
final class class_56 {

   // $FF: renamed from: a int
   int field_433;
   // $FF: renamed from: b int
   int field_434;
   // $FF: renamed from: c int
   int field_435;
   // $FF: renamed from: d int
   int field_436;
   // $FF: renamed from: a byte
   public byte field_437;
   // $FF: renamed from: a java.lang.String
   public String field_438;
   // $FF: renamed from: a mobak.b.b.q
   public class_55 field_439;
   // $FF: renamed from: a mobak.c.i
   public NotifyLabel field_440;
   // $FF: renamed from: e int
   public int field_441;
   // $FF: renamed from: a mobak.c.a
   class_62 field_442;


   // $FF: renamed from: <init> (byte, java.lang.String, java.lang.String, mobak.c.i, int) void
   public class_56(byte var1, String var2, String var3, NotifyLabel var4, int var5) {
      super();
      this.field_442 = Screen.field_31;
      this.field_437 = var1;
      this.field_438 = var2;
      this.field_433 = ScreenDrawer.method_395();
      this.field_434 = ScreenDrawer.method_396();
      this.field_435 = ScreenDrawer.method_397();
      this.field_436 = ScreenDrawer.method_398();
      short var6 = (short)(this.field_434 + (this.field_438 != null && !this.field_438.equals("")?50:30));
      class_55 var10001 = new class_55((short)(this.field_433 + 20), var6, (short)(this.field_435 - 30), (short)(this.field_436 - 20 - (var6 - this.field_434) - 10), true, false);
      this.field_439 = var10001;
      this.field_439.method_490(var3, this.field_442, false, -1);
      this.field_440 = var4;
      this.field_441 = var5;
   }
}
