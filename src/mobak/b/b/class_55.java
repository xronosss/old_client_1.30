package mobak.b.b;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import mobak.a.SocketListener;
import mobak.b.b.a.class_51;
import mobak.b.b.a.class_52;
import mobak.b.b.a.class_53;
import mobak.b.b.a.class_54;
import mobak.text.class_62;

// $FF: renamed from: mobak.b.b.q
public final class class_55 extends class_50 {

   // $FF: renamed from: a mobak.c.a
   private static class_62 field_410;
   // $FF: renamed from: b mobak.c.a
   private static class_62 field_411;
   // $FF: renamed from: a int
   public int field_412;
   // $FF: renamed from: b int
   public int field_413;
   // $FF: renamed from: c int
   public int field_414;
   // $FF: renamed from: d int
   public int field_415;
   // $FF: renamed from: c short
   private short field_416;
   // $FF: renamed from: d short
   private short field_417;
   // $FF: renamed from: b boolean
   private boolean field_418;
   // $FF: renamed from: a mobak.c.a[]
   private static class_62[] field_419;
   // $FF: renamed from: k int
   private static final int field_420;
   // $FF: renamed from: e short
   private short field_421;
   // $FF: renamed from: f short
   private short field_422;
   // $FF: renamed from: g short
   private short field_423;
   // $FF: renamed from: b byte
   private static byte field_424;
   // $FF: renamed from: a java.util.Vector
   private Vector field_425;
   // $FF: renamed from: l int
   private int field_426;
   // $FF: renamed from: m int
   private int field_427;
   // $FF: renamed from: c byte
   private byte field_428;
   // $FF: renamed from: e int
   public int field_429;
   // $FF: renamed from: c boolean
   private boolean field_430;
   // $FF: renamed from: n int
   private int field_431;
   // $FF: renamed from: d boolean
   private boolean field_432;


   // $FF: renamed from: <init> (short, short, short, short, boolean, boolean, boolean) void
   public class_55(short var1, short var2, short var3, short var4, boolean var5, boolean var6, boolean var7) {
      super();
      this.field_412 = 0;
      this.field_413 = 0;
      this.field_414 = 0;
      this.field_415 = 0;
      this.field_423 = 0;
      this.field_428 = 20;
      this.field_430 = false;
      this.field_431 = -1;
      super.field_385 = 10;
      this.method_468(var2);
      this.field_416 = var3;
      this.field_417 = var4;
      this.field_418 = false;
      this.field_422 = this.field_421 = 0;
      this.field_430 = true;
      this.field_425 = new Vector();
      if(!this.field_430) {
         this.field_418 = true;
      }

   }

   // $FF: renamed from: <init> (short, short, short, short, boolean, boolean) void
   public class_55(short var1, short var2, short var3, short var4, boolean var5, boolean var6) {
      super();
      this.field_412 = 0;
      this.field_413 = 0;
      this.field_414 = 0;
      this.field_415 = 0;
      this.field_423 = 0;
      this.field_428 = 20;
      this.field_430 = false;
      this.field_431 = -1;
      super.field_385 = var1;
      this.method_468(var2);
      this.field_416 = var3;
      this.field_417 = var4;
      this.field_422 = this.field_421 = 0;
      this.field_418 = var5;
      this.field_425 = new Vector();
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, byte) void
   public final void method_484(Graphics var1, byte var2) {
      if(var1 != null && this.field_425 != null) {
         short var3 = (short) ScreenDrawer.method_386(var1);
         short var4 = (short) ScreenDrawer.method_387(var1);
         short var5 = (short) ScreenDrawer.method_388(var1);
         short var6 = (short) ScreenDrawer.method_389(var1);
         ScreenDrawer.method_368(var1, super.field_385 - 5, super.field_386, this.field_416 + 10, this.field_417 + 5);

         int var7;
         for(var7 = 0; var7 < this.field_425.size(); ++var7) {
            class_50 var8;
            if((var8 = (class_50)this.field_425.elementAt(var7)).field_391 >= 0) {
               int var9 = var8.field_391;
               int var10;
               int var11 = (var10 = var8.method_466() - this.field_422 - var9) - this.field_422 - var9;

               int var12;
               for(var12 = var7; var12 < this.field_425.size(); ++var12) {
                  class_53 var13;
                  if((var13 = (class_53)this.field_425.elementAt(var12)).field_393) {
                     var11 = var13.method_466() + var13.field_402 - this.field_422 - var9;
                     break;
                  }
               }

               var12 = ScreenDrawer.method_385(var1);
               ScreenDrawer.method_384(var1, var8.field_392);
               ScreenDrawer.method_393(var1, this.method_465(), var10, var9 << 1, var9 << 1);
               ScreenDrawer.method_393(var1, this.method_465() + this.field_416 - (var9 << 1), var10, var9 << 1, var9 << 1);
               ScreenDrawer.method_393(var1, this.method_465(), var11, var9 << 1, var9 << 1);
               ScreenDrawer.method_393(var1, this.method_465() + this.field_416 - (var9 << 1), var11, var9 << 1, var9 << 1);
               ScreenDrawer.method_394(var1, this.method_465() + var9, var10, this.field_416 - (var9 << 1), var11 - var10 + (var9 << 1));
               ScreenDrawer.method_394(var1, this.method_465(), var10 + var9, var9, var11 - var10);
               ScreenDrawer.method_394(var1, this.method_465() + this.field_416 - var9, var10 + var9, var9, var11 - var10);
               ScreenDrawer.method_384(var1, var12);
            }

            if(var8.field_385 <= super.field_385 + this.field_416 + 5 && var8.field_385 + var8.method_462() >= super.field_385 - 5 && var8.field_386 - this.field_422 <= super.field_386 + this.field_417 + 5 && var8.field_386 - this.field_422 + var8.method_463() >= super.field_386 - 5) {
               if(var8.field_389 == 0) {
                  var8.method_464(var1, (short)-10, this.field_422, var2);
               } else if(var8.field_389 == 1) {
                  var8.method_464(var1, (short)(-this.field_416 / 2), this.field_422, (byte)(var2 | 1 | 16));
               } else if(var8.field_389 == 2) {
                  var8.method_464(var1, (short)(-this.field_416), this.field_422, (byte)(var2 | 8 | 16));
               }
            }
         }

         if(this.field_418) {
            if(this.method_487()) {
               if(this.field_423 < 20) {
                  ++this.field_423;
               } else {
                  this.field_422 = 0;
                  this.field_423 = 0;
                  this.field_428 = 20;
               }
            } else if(this.field_422 == 0 && this.field_428 > 0) {
               --this.field_428;
            } else if(!this.method_487()) {
               this.field_422 = (short)(this.field_422 + field_420);
            }
         }

         var7 = ScreenDrawer.method_385(var1);
         ScreenDrawer.method_384(var1, 16773632);
         if(super.field_388 > 0 && super.field_387 != -16777216) {
            for(byte var14 = 1; var14 <= super.field_388; ++var14) {
               var1.drawRect(this.field_412 - var14, this.field_413 - var14 - this.field_422, this.field_414 + (var14 << 1), this.field_415 + (var14 << 1));
            }
         }

         ScreenDrawer.method_384(var1, var7);
         ScreenDrawer.method_368(var1, var3, var4, var5, var6);
      }
   }

   // $FF: renamed from: a () void
   public final void method_485() {
      int var1 = this.field_431;

      for(int var2 = this.field_431; var2 >= 0; --var2) {
         if(this.method_493(var2) != null && this.method_493(this.field_431).method_471() != this.method_493(var2).method_471() && this.method_493(var2).method_463() > 0) {
            var1 = var2;
            break;
         }
      }

      if(var1 >= 0 && var1 < this.field_425.size()) {
         if(!this.method_500(var1)) {
            this.field_422 = (short)(this.field_422 - field_420);
            return;
         }

         if(this.method_493(var1).method_471() > 0) {
            this.method_510(var1);
            return;
         }
      } else if(!this.method_500(0)) {
         this.field_422 = (short)(this.field_422 - field_420);
      }

   }

   // $FF: renamed from: b () void
   public final void method_486() {
      boolean var1 = true;
      int var2 = this.field_431;
      class_55 var7 = this;
      int var10000;
      if(this.field_425 != null && var2 < this.field_425.size() - 1) {
         if(var2 <= 0) {
            ;
         }

         if(var2 < 0) {
            var2 = 0;
         }

         int var3 = var2;
         int var4 = ((class_50)this.field_425.elementAt(var2)).method_471();
         int var5 = var2;

         while(true) {
            if(var5 >= var7.field_425.size()) {
               if(var5 >= 0) {
                  ;
               }
               break;
            }

            class_50 var6 = (class_50)var7.field_425.elementAt(var5);
            if((var7.field_430 || var6.method_470(field_410) || var6.method_470(field_411)) && var6.method_471() > 0 && var5 != var2 && var4 != var6.method_471()) {
               var3 = var5;
               break;
            }

            ++var5;
         }

         var10000 = var3;
      } else {
         var10000 = -1;
      }

      int var8 = var10000;
      if(var10000 >= 0 && var8 < this.field_425.size()) {
         if(!this.method_500(var8)) {
            this.field_422 = (short)(this.field_422 + field_420);
            return;
         }

         if(this.method_493(var8).method_471() > 0) {
            this.method_510(var8);
            return;
         }
      } else if(!this.method_487()) {
         this.field_422 = (short)(this.field_422 + field_420);
      }

   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte) void
   public final void method_464(Graphics var1, short var2, short var3, byte var4) {
      var2 = super.field_385;
      short var5 = super.field_386;
      super.field_386 -= var3;

      try {
         if(var4 == 0) {
            this.method_484(var1, super.field_390);
         } else {
            this.method_484(var1, var4);
         }
      } catch (Exception var6) {
         SocketListener.logMessage("TextScreen2.draw()" + var6.toString());
      }

      super.field_385 = var2;
      super.field_386 = var5;
   }

   // $FF: renamed from: c () boolean
   private boolean method_487() {
      return this.field_429 - this.field_422 <= this.field_417;
   }

   // $FF: renamed from: a () short
   public final short method_463() {
      return this.field_417;
   }

   // $FF: renamed from: b () short
   public final short method_462() {
      return this.field_416;
   }

   // $FF: renamed from: a (java.lang.String, mobak.c.a, short, short, byte) java.util.Vector
   private static Vector method_488(String var0, class_62 var1, short var2, short var3, byte var4) {
      Vector var5 = new Vector();
      if(var0 != null && var1 != null) {
         short var6 = var2;
         short var7 = 0;
         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         class_53 var10000 = new class_53(var2, (short)0);
         class_53 var11 = var10000;
         int var12 = 0;
         String var13 = "";
         int var14 = 0;

         class_52 var10001;
         while(var14 < var0.length()) {
            if(var14 < var0.length() && (var0.substring(var14, var14 + 1).equals("\r") || var0.substring(var14, var14 + 1).equals("\t"))) {
               if(var14 > var10) {
                  var13 = var13 + var0.substring(var10, var14);
               }

               ++var14;
               var10 = var14;
            } else {
               int var15;
               int var18;
               if(var14 <= var0.length() - 5 && var0.substring(var14, var14 + 4).toLowerCase().equals("\\img")) {
                  if(var14 > var10) {
                     var13 = var13 + var0.substring(var10, var14);
                  }

                  if(var13.length() > 0) {
                     var10001 = new class_52(var13, (short)0, (short)0, var1, var12);
                     var6 = var11.method_477(var10001);
                  }

                  var13 = "";
                  var12 = 0;
                  var14 += 4;
                  var15 = -1;
                  if(!var0.substring(var14, var14 + 1).equals("=")) {
                     var15 = Integer.parseInt(var0.substring(var14, var14 + 1));
                  }

                  ++var14;
                  var10 = var14;
                  if((var18 = var0.indexOf(" ", var14)) != -1) {
                     var14 = var18;
                  } else {
                     var14 = var0.length();
                  }

                  String var17 = var0.substring(var10, var14);
                  class_54 var19;
                  class_54 var20;
                  if(var15 >= 0) {
                     var19 = new class_54(var17, 0, 0, var15);
                     var20 = var19;
                  } else {
                     var19 = new class_54(var17, 0, 0);
                     var20 = var19;
                  }

                  if(var6 + var20.method_462() >= var3 - 5) {
                     if(var11.field_401 > 0) {
                        var5.addElement(var11);
                     }

                     var7 = (short)(var7 + var11.field_402 + var4);
                     var10000 = new class_53(var2, var7);
                     var11 = var10000;
                     var10000.field_389 = var8;
                     var11.field_399 = var9;
                     var11.method_478();
                  }

                  var6 = var11.method_477(var20);
                  if(var14 < var0.length()) {
                     ++var14;
                  }

                  var10 = var14;
                  if(var14 < var0.length() && var0.substring(var14, var14 + 1).equals("\"")) {
                     var10 = var14 + 1;
                     if((var14 = var0.indexOf("\"", var10)) < 0) {
                        var14 = var0.length();
                     }

                     var17 = var0.substring(var10, var14);
                     var10001 = new class_52(var17, (short)0, (short)0, var1);
                     var20.field_404 = var10001;
                     ++var14;
                     var10 = var14;
                  }
               } else if(var14 <= var0.length() - 3 && var0.substring(var14, var14 + 3).toLowerCase().equals("\\a=")) {
                  var14 += 3;
                  if((var8 = Integer.parseInt(var0.substring(var14, var14 + 1))) < 0 || var8 > 2) {
                     var8 = 0;
                  }

                  var11.field_389 = var8;
                  var11.field_399 = var9;
                  ++var14;
                  var10 = var14;
               } else if(var14 <= var0.length() - 3 && var0.substring(var14, var14 + 3).toLowerCase().equals("\\v=")) {
                  var14 += 3;
                  if((var9 = Integer.parseInt(var0.substring(var14, var14 + 1))) < 0 || var9 > 2) {
                     var9 = 0;
                  }

                  var11.field_399 = var9;
                  ++var14;
                  var10 = var14;
               } else if(var14 <= var0.length() - 5 && var0.substring(var14, var14 + 5).toLowerCase().equals("\\bgr=")) {
                  var14 += 5;
                  if(var0.indexOf(" ", var14) != -1) {
                     var15 = var0.indexOf(" ", var14);
                  } else {
                     var15 = var0.length();
                  }

                  var18 = Integer.parseInt(var0.substring(var14, var15));
                  var11.field_391 = var18;
                  var10 = var14 = var15 + (var15 < var0.length()?1:0);
               } else if(var14 <= var0.length() - 5 && var0.substring(var14, var14 + 5).toLowerCase().equals("\\bgc=")) {
                  var14 += 5;
                  if(var0.indexOf(" ", var14) != -1) {
                     var15 = var0.indexOf(" ", var14);
                  } else {
                     var15 = var0.length();
                  }

                  if(var0.indexOf("\n", var14) != -1 && var0.indexOf("\n", var14) < var15) {
                     var15 = var0.indexOf("\n", var14);
                  }

                  var18 = Integer.parseInt(var0.substring(var14, var15));
                  var11.field_392 = var18;
                  if(var11.field_391 < 0) {
                     var11.field_391 = 0;
                  }

                  var10 = var14 = var15 + (var15 < var0.length()?1:0);
               } else if(var14 <= var0.length() - 4 && var0.substring(var14, var14 + 4).toLowerCase().equals("\\bge")) {
                  var11.field_393 = true;
                  var14 += 4;
                  var10 = var14;
               } else if(var14 < var0.length() && var0.substring(var14, var14 + 1).equals("\f")) {
                  if(var14 > var10) {
                     var13 = var13 + var0.substring(var10, var14);
                  }

                  if(var13.length() > 0) {
                     var10001 = new class_52(var13, (short)0, (short)0, var1, var12);
                     var6 = var11.method_477(var10001);
                  }

                  var13 = "";
                  ++var14;
                  var15 = Integer.parseInt(var0.substring(var14, var14 + 1));
                  var1 = field_419[var15];
                  ++var14;
                  var10 = var14;
               } else if(var14 <= var0.length() - 3 && var0.substring(var14, var14 + 3).toLowerCase().equals("\\id")) {
                  if(var14 > var10) {
                     var13 = var13 + var0.substring(var10, var14);
                  }

                  var10 = var14 + 3;
                  if((var15 = var0.indexOf(" ", var10)) != -1) {
                     var14 = var15;
                  } else {
                     var14 = var0.length();
                  }

                  var18 = Integer.parseInt(var0.substring(var10, var14));
                  if(var12 != var18) {
                     if(var13.length() > 0) {
                        var10001 = new class_52(var13, (short)0, (short)0, var1, var12);
                        var6 = var11.method_477(var10001);
                     }

                     var13 = "";
                  }

                  var12 = var18;
                  if(var14 < var0.length()) {
                     ++var14;
                  }

                  var10 = var14;
               } else if(var14 < var0.length() && var0.substring(var14, var14 + 1).equals(" ")) {
                  var13 = var13 + var0.substring(var10, var14 + 1);
                  ++var14;
                  var10 = var14;
                  if((var15 = var0.indexOf(" ", var14)) == -1 || var0.indexOf("\n", var14) != -1 && var0.indexOf("\n", var14) < var15) {
                     var15 = var0.indexOf("\n", var14);
                  }

                  if(var15 == -1) {
                     var15 = var0.length();
                  }

                  String var16;
                  if(!(var16 = var0.substring(var14, var15)).startsWith("\\img") && var6 + var1.method_563(var13 + " " + var16) + 10 > var3) {
                     if(var13.length() > 0) {
                        var10001 = new class_52(var13, (short)0, (short)0, var1, var12);
                        var11.method_477(var10001);
                     }

                     var6 = var2;
                     var7 = (short)(var7 + var11.field_402 + var4);
                     if(var11.field_401 > 0) {
                        var5.addElement(var11);
                     }

                     var10000 = new class_53(var2, var7);
                     var11 = var10000;
                     var10000.field_389 = var8;
                     var11.field_399 = var9;
                     var13 = "";
                  }
               } else if(var14 < var0.length() && var0.substring(var14, var14 + 1).equals("\n")) {
                  if(var14 > var10) {
                     var13 = var13 + var0.substring(var10, var14);
                  }

                  if(var13.length() > 0) {
                     var10001 = new class_52(var13, (short)0, (short)0, var1, var12);
                     var11.method_477(var10001);
                  }

                  var13 = "";
                  if(var11.field_402 > 0) {
                     var7 = (short)(var7 + var11.field_402 + var4);
                  } else {
                     var7 = (short)(var7 + var1.field_500 + var4);
                  }

                  var5.addElement(var11);
                  var6 = var2;
                  var12 = 0;
                  var8 = 0;
                  var9 = 0;
                  var10000 = new class_53(var2, var7);
                  var11 = var10000;
                  ++var14;
                  var10 = var14;
               } else {
                  ++var14;
               }
            }
         }

         if((var14 = var0.length()) > var10) {
            var13 = var13 + var0.substring(var10, var14);
         }

         if(var13.length() > 0) {
            var10001 = new class_52(var13, (short)0, (short)0, var1, var12);
            var11.method_477(var10001);
         }

         var11.field_393 = true;
         var5.addElement(var11);
      }

      return var5;
   }

   // $FF: renamed from: a (java.lang.String, mobak.c.a, byte, boolean, int) short
   public final short method_489(String var1, class_62 var2, byte var3, boolean var4, int var5) {
      short var10003 = (short)var3;
      int var7 = var5;
      boolean var6 = var4;
      short var20 = this.field_416;
      short var18 = var10003;
      class_55 var13 = this;
      if(var1 != null && !var1.equals("") && var2 != null) {
         short var8 = 0;
         Vector var15 = method_488(var1, var2, var18, var20, field_424);
         short var17 = 0;

         for(int var19 = 0; var19 < var15.size(); ++var19) {
            class_50 var22;
            (var22 = (class_50)var15.elementAt(var19)).method_472(var7);
            boolean var9 = true;
            if(var19 == 0) {
               var17 = var22.method_466();
            } else {
               var9 = var17 != var22.method_466();
            }

            if(var9) {
               var8 += var22.method_463();
            }

            if(!var6) {
               if(var13.field_429 == 0 || var13.field_425.size() == 0) {
                  var13.field_429 = 5;
               }

               var22.method_468((short)(var22.method_466() + var13.field_429));
               var13.method_491(var22);
            } else {
               var22.field_386 = (short)(var22.field_386 + 5);
               class_50 var24 = var22;
               class_55 var23 = var13;
               if(var22 != null) {
                  if(var13.field_425 == null) {
                     var13.field_425 = new Vector();
                  }

                  var22.field_385 += var13.field_385;
                  var22.method_468((short)(var22.method_466() + var13.field_386));
                  var13.field_425.insertElementAt(var22, var19);
                  if(var22.method_470(field_410) || var22.method_470(field_411)) {
                     var13.field_430 = false;
                  }

                  if(var9) {
                     for(int var10 = var19 + 1; var10 < var23.field_425.size(); ++var10) {
                        class_50 var12;
                        class_50 var10000 = var12 = (class_50)var23.field_425.elementAt(var10);
                        var10000.field_386 = (short)(var10000.field_386 + var24.method_463() + field_424);
                        if(var23.field_427 < var12.field_386 + var12.method_463() - var23.field_386) {
                           var23.field_427 = var12.field_386 + var12.method_463() - var23.field_386;
                        }
                     }
                  }

                  if(var23.field_426 < var24.field_385 + var24.method_462() - var23.field_385) {
                     var23.field_426 = var24.field_385 + var24.method_462() - var23.field_385;
                  }

                  if(var9) {
                     var23.field_429 += var24.method_463() + field_424;
                  }
               }
            }
         }

         if(var15.size() > 0) {
            class_50 var21 = (class_50)var15.lastElement();
            if(!var6) {
               var13.field_429 = var21.method_466() + var21.method_463() - var13.method_466() + field_424;
            }
         }

         return var8;
      } else {
         return (short)0;
      }
   }

   // $FF: renamed from: a (java.lang.String, mobak.c.a, boolean, int) short
   public final short addText(String var1, class_62 var2, boolean var3, int var4) {
      return this.method_489(var1, var2, (byte)0, var3, var4);
   }

   // $FF: renamed from: a (mobak.b.b.r) void
   public final void method_491(class_50 var1) {
      if(var1 != null) {
         if(this.field_425 == null) {
            this.field_425 = new Vector();
         }

         var1.field_385 += super.field_385;
         var1.method_468((short)(var1.method_466() + super.field_386));
         this.field_425.addElement(var1);
         if(var1.method_470(field_410) || var1.method_470(field_411)) {
            this.field_430 = false;
         }

         if(this.field_427 < var1.field_386 + var1.method_463() - super.field_386) {
            this.field_427 = var1.field_386 + var1.method_463() - super.field_386;
         }

         if(this.field_426 < var1.field_385 + var1.method_462() - super.field_385) {
            this.field_426 = var1.field_385 + var1.method_462() - super.field_385;
         }

      }
   }

   // $FF: renamed from: a () int
   public final int method_492() {
      class_50 var1;
      return (var1 = this.method_493(this.field_431)) != null?var1.method_471():-1;
   }

   // $FF: renamed from: a (int) mobak.b.b.r
   public final class_50 method_493(int var1) {
      return var1 >= 0 && var1 < this.field_425.size()?(class_50)this.field_425.elementAt(var1):null;
   }

   // $FF: renamed from: a (int) int
   public final int method_494(int var1) {
      int var2 = -1;

      for(int var3 = 0; var3 < this.field_425.size() && ((class_50)this.field_425.elementAt(var3)).method_466() <= var1; ++var3) {
         class_50 var4;
         if((var4 = (class_50)this.field_425.elementAt(var3)).method_470(field_410) || var4.method_470(field_411)) {
            var2 = var3;
         }
      }

      return var2;
   }

   // $FF: renamed from: c () void
   public final void method_495() {
      this.field_428 = 20;
      this.field_423 = 0;
      if(this.field_425 != null) {
         this.field_425.removeAllElements();
      }

      this.field_427 = this.field_426 = 0;
      this.field_429 = 0;
   }

   // $FF: renamed from: a () boolean
   public final boolean method_496() {
      return this.field_425 == null || this.field_425.isEmpty();
   }

   // $FF: renamed from: a (short, short, short, boolean) void
   public final void method_497(short var1, short var2, short var3, boolean var4) {
      class_51 var10000 = new class_51(var1, (short)1, var3);
      class_51 var5 = var10000;
      if(var4) {
         var5.field_390 = 1;
      }

      this.method_491(var5);
   }

   // $FF: renamed from: b (int) int
   public final int method_498(int var1) {
      int var2 = var1 + 1;
      if(this.field_425 == null) {
         return -1;
      } else {
         int var3 = 0;
         if(this.method_493(var1) != null) {
            var3 = this.method_493(var1).method_471();
         }

         for(var2 = var2; var2 < this.field_425.size(); ++var2) {
            class_50 var4;
            if((var4 = this.method_493(var2)) != null && (var4.method_470(field_410) || var4.method_470(field_411)) && var3 != var4.method_471()) {
               return var2;
            }
         }

         return var1;
      }
   }

   // $FF: renamed from: c (int) int
   public final int method_499(int var1) {
      int var2 = var1 - 1;
      if(this.field_425 == null) {
         return -1;
      } else {
         int var3 = 0;
         if(this.method_493(var1) != null) {
            var3 = this.method_493(var1).method_471();
         }

         for(var2 = var2; var2 >= 0; --var2) {
            class_50 var4;
            if((var4 = this.method_493(var2)) != null && (var4.method_470(field_410) || var4.method_470(field_411)) && var3 != var4.method_471()) {
               return var2;
            }
         }

         return var1;
      }
   }

   // $FF: renamed from: a (int) boolean
   private boolean method_500(int var1) {
      class_50 var2;
      return (var2 = this.method_493(var1)) == null?false:(var2.field_385 > super.field_385 + this.field_416 + 5?false:(var2.field_385 + var2.method_462() < super.field_385 - 5?false:(var2.field_386 - this.field_422 - 2 < super.field_386?false:var2.field_386 - this.field_422 + var2.method_463() <= super.field_386 + this.field_417)));
   }

   // $FF: renamed from: d (int) int
   public final int method_501(int var1) {
      if(this.field_425 != null) {
         for(int var2 = 0; var2 < this.field_425.size(); ++var2) {
            class_50 var3 = (class_50)this.field_425.elementAt(var2);
            if((this.field_430 || var3.method_470(field_410) || var3.method_470(field_411)) && this.method_500(var2) && var1 >= var3.field_386 - this.field_422 && var1 <= var3.field_386 - this.field_422 + var3.method_463()) {
               this.method_510(var2);
               return this.field_431;
            }
         }
      }

      return this.field_431;
   }

   // $FF: renamed from: c () short
   public final short method_502() {
      return this.field_422;
   }

   // $FF: renamed from: a (int) void
   public final void method_503(int var1) {
      this.field_422 = (short)var1;
   }

   // $FF: renamed from: d () short
   public final short method_504() {
      return this.field_416;
   }

   // $FF: renamed from: e () short
   public final short method_505() {
      return this.field_417;
   }

   // $FF: renamed from: a (int, int) void
   public final void method_506(int var1, int var2) {
      if(var1 >= this.method_465() && var1 <= this.method_465() + this.field_416 && var2 >= this.method_466() && var2 <= this.method_466() + this.field_417) {
         this.field_432 = true;
         boolean var4 = false;
         this.field_418 = false;
      } else {
         this.field_432 = false;
      }
   }

   // $FF: renamed from: b () boolean
   public final boolean method_507() {
      return this.field_432;
   }

   // $FF: renamed from: d () void
   public final void method_508() {
      if(this.field_422 <= 0 || this.field_422 + this.field_417 >= this.field_429) {
         if(this.field_422 >= 0 && this.field_429 >= this.field_417) {
            if(this.field_429 > this.field_417 && this.field_422 + this.field_417 > this.field_429) {
               this.field_422 = (short)(this.field_429 - this.field_417);
            }

         } else {
            this.field_422 = 0;
         }
      }
   }

   // $FF: renamed from: b () int
   public final int method_509() {
      return this.field_425.size();
   }

   // $FF: renamed from: b (int) void
   public final void method_510(int var1) {
      if(this.method_493(var1) == null || this.method_493(var1).method_471() != 0) {
         super.field_388 = 2;
         super.field_387 = 16773632;
         this.field_431 = var1;
         class_50 var2 = (class_50)this.field_425.elementAt(this.field_431);
         this.field_412 = this.method_465();
         this.field_414 = this.field_416;
         this.field_415 = 0;
         int var5 = var2.method_471();

         for(int var3 = var1; var3 >= 0; var1 = var3--) {
            int var4 = ((class_53)this.field_425.elementAt(var3)).method_471();
            if(var5 != var4) {
               break;
            }
         }

         for(this.field_413 = ((class_53)this.field_425.elementAt(var1)).method_466(); var1 < this.field_425.size() && ((class_53)this.field_425.elementAt(var1)).method_471() == var5; ++var1) {
            short var6 = ((class_53)this.field_425.elementAt(this.field_431)).field_402;
            this.field_415 += var6;
         }

      }
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_410 = Screen.field_32;
      field_411 = Screen.field_33;
      field_419 = new class_62[]{Screen.field_25, Screen.field_26, Screen.field_27, Screen.field_28, Screen.field_29, Screen.field_30, Screen.field_31, Screen.field_32};
      field_420 = Math.max(1, Screen.field_26.field_500 / 6);
      field_424 = 2;
   }
}
