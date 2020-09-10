package mobak.c;

import javax.microedition.rms.RecordFilter;

// $FF: renamed from: mobak.c.f
final class LMRecordFilter implements RecordFilter {

   // $FF: renamed from: a byte[]
   private final byte[] candidate;


   // $FF: renamed from: <init> (mobak.c.e, byte[]) void
   LMRecordFilter(RMSManager var1, byte[] candidate) {
      super();
      this.candidate = candidate;
   }

   public final boolean matches(byte[] candidate) {
      for(int i = 0; i < this.candidate.length; ++i) {
         if(candidate[i + 1] != this.candidate[i]) {
            return false;
         }
      }

      return true;
   }
}
