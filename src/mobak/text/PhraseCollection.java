package mobak.text;


// $FF: renamed from: mobak.c.h
public final class PhraseCollection {

   // $FF: renamed from: a java.lang.String[]
   String[] phrases;
   // $FF: renamed from: a int[]
   int[] ids;


   // $FF: renamed from: <init> () void
   public PhraseCollection() {
      super();
      this.phrases = new String[5];
      this.ids = new int[5];
   }

   // $FF: renamed from: a (int, java.lang.String) void
   public final void addPhraseWithID(int var1, String var2) {
      int var3;
      if((var3 = this.getPhrasePosition(var1)) < 0) {
         PhraseCollection var5 = this;
         int var10000;
         if(this.phrases != null && this.ids != null) {
            int var4 = 0;

            while(true) {
               if(var4 >= var5.ids.length) {
                  var10000 = -1;
                  break;
               }

               if(var5.phrases[var4] == null) {
                  var10000 = var4;
                  break;
               }

               ++var4;
            }
         } else {
            var10000 = -1;
         }

         var3 = var10000;
      }

      if(var3 < 0) {
         var3 = this.ids.length;
         int[] var6 = new int[this.ids.length + 5];
         System.arraycopy(this.ids, 0, var6, 0, this.ids.length);
         this.ids = var6;
         String[] var7 = new String[this.phrases.length + 5];
         System.arraycopy(this.phrases, 0, var7, 0, this.phrases.length);
         this.phrases = var7;
      }

      this.ids[var3] = var1;
      this.phrases[var3] = var2;
   }

   // $FF: renamed from: a (int) java.lang.String
   public final String getPhrase(int index) {
      return (index = this.getPhrasePosition(index)) >= 0?this.phrases[index]:null;
   }

   // $FF: renamed from: a (int) int
   private int getPhrasePosition(int var1) {
      if(this.phrases != null && this.ids != null) {
         for(int i = 0; i < this.ids.length; ++i) {
            if(this.ids[i] == var1) {
               return i;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }
}
