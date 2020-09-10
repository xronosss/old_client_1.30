package mobak.c;

import javax.microedition.rms.RecordFilter;

// $FF: renamed from: mobak.c.g
final class class_74 implements RecordFilter {

   // $FF: renamed from: a byte[]
   private final byte[] field_573;


   // $FF: renamed from: <init> (mobak.c.e, byte[]) void
   public class_74(RMSManager var1, byte[] var2) {
      super();
      this.field_573 = var2;
   }

   public final boolean matches(byte[] var1) {
      if(var1 != null && var1.length != 0) {
         if(this.field_573 != null && this.field_573.length != 0) {
            if(var1.length < this.field_573.length) {
               return false;
            } else {
               for(short var2 = 0; var2 < this.field_573.length; ++var2) {
                  if(this.field_573[var2] != var1[var2]) {
                     return false;
                  }
               }

               return true;
            }
         } else {
            return true;
         }
      } else {
         return false;
      }
   }
}
