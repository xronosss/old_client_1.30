package mobak.b.b;

import javax.microedition.lcdui.Graphics;
import mobak.c.class_62;

// $FF: renamed from: mobak.b.b.r
public abstract class class_50 {

   // $FF: renamed from: a short
   public short field_385;
   // $FF: renamed from: b short
   public short field_386;
   // $FF: renamed from: f int
   public int field_387;
   // $FF: renamed from: g int
   public int field_388;
   // $FF: renamed from: h int
   public int field_389;
   // $FF: renamed from: a byte
   public byte field_390;
   // $FF: renamed from: i int
   public int field_391;
   // $FF: renamed from: j int
   public int field_392;
   // $FF: renamed from: a boolean
   public boolean field_393;


   // $FF: renamed from: <init> () void
   public class_50() {
      super();
      this.field_389 = 0;
      this.field_391 = -1;
      this.field_392 = 13939322;
      this.field_393 = false;
   }

   // $FF: renamed from: b () short
   public abstract short method_462();

   // $FF: renamed from: a () short
   public abstract short method_463();

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte) void
   public abstract void method_464(Graphics var1, short var2, short var3, byte var4);

   // $FF: renamed from: f () short
   public final short method_465() {
      return this.field_385;
   }

   // $FF: renamed from: g () short
   public final short method_466() {
      return this.field_386;
   }

   // $FF: renamed from: a (short) void
   public final void method_467(short var1) {
      this.field_385 = var1;
   }

   // $FF: renamed from: c (int) void
   public final void method_468(int var1) {
      this.field_386 = (short)var1;
   }

   // $FF: renamed from: b (int, int) void
   public void method_469(int var1, int var2) {
      this.field_387 = var1;
      this.field_388 = var2;
   }

   // $FF: renamed from: a (mobak.c.a) boolean
   public boolean method_470(class_62 var1) {
      return false;
   }

   // $FF: renamed from: c () int
   public int method_471() {
      return 0;
   }

   // $FF: renamed from: d (int) void
   public void method_472(int var1) {}
}
