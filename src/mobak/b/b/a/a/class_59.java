package mobak.b.b.a.a;

import java.util.Vector;
import mobak.b.b.a.a.class_0;

// $FF: renamed from: mobak.b.b.a.a.b
public final class class_59 {

   // $FF: renamed from: a java.util.Vector
   private static final Vector field_480;


   // $FF: renamed from: a (int) mobak.b.b.a.a.a
   public static class_0 method_552(int var0) {
      class_0 var1 = null;
      int var2 = 0;

      while(var2 < field_480.size() && var1 == null) {
         class_0 var3;
         if((var3 = (class_0)field_480.elementAt(var2++)).method_0() == var0) {
            var1 = var3;
         }
      }

      return var1;
   }

   // $FF: renamed from: a () mobak.b.b.a.a.a[]
   public static class_0[] method_553() {
      int var0;
      if((var0 = field_480.size()) == 0) {
         return null;
      } else {
         class_0[] var1 = new class_0[var0];

         for(int var2 = 0; var2 < var0; ++var2) {
            var1[var2] = (class_0)field_480.elementAt(var2);
         }

         return var1;
      }
   }

   // $FF: renamed from: <clinit> () void
   static {
      field_480 = new Vector();
   }
}
