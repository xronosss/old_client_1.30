package mobak.b.b.a;

import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.v
public final class Button {

   // $FF: renamed from: a int
   public int field_543;
   // $FF: renamed from: a short
   public short packetType;
   // $FF: renamed from: b short
   public short nextPacketType;
   // $FF: renamed from: a java.lang.String
   public String field_546;
   // $FF: renamed from: a java.lang.String[]
   public String[] field_547;
   // $FF: renamed from: a short[]
   public short[] field_548;
   // $FF: renamed from: a int[]
   public int[] field_549;


   // $FF: renamed from: a (int) short
   public static final short method_640(int var0) {
      return (short)(var0 >> 8);
   }

   // $FF: renamed from: a (int, short) int
   private static final int method_641(int var0, short var1) {
      var0 &= -16776961;
      int var2 = var1 << 8;
      return var0 | var2;
   }

   // $FF: renamed from: a (int, boolean, byte) int
   private static final int method_642(int var0, boolean var1, byte var2) {
      return var1?var0 | var2 << 24:var0 & ~(var2 << 24);
   }

   // $FF: renamed from: a (short, byte) int
   public static final int method_643(short var0, byte var1) {
      byte var2 = var1;
      boolean var3 = false;
      return method_641(0 & -256 | var2, var0);
   }

   // $FF: renamed from: <init> (byte) void
   public Button(byte var1) {
      super();
      int var10002 = this.field_543;
      this.field_543 = this.field_543 & -256 | var1;
      this.field_543 = method_641(this.field_543, PopupMenu.method_578(var1));
      boolean var3 = true;
      int var2 = this.field_543;
      this.field_543 = method_642(this.field_543, var3, (byte)-128);
      var3 = true;
      var2 = this.field_543;
      this.field_543 = method_642(this.field_543, var3, (byte)64);
   }

   // $FF: renamed from: <init> (byte, short) void
   public Button(byte var1, short var2) {
      super();
      int var10002 = this.field_543;
      this.field_543 = this.field_543 & -256 | var1;
      this.field_543 = method_641(this.field_543, var2);
      boolean var3 = true;
      int var4 = this.field_543;
      this.field_543 = method_642(this.field_543, var3, (byte)-128);
      var3 = true;
      var4 = this.field_543;
      this.field_543 = method_642(this.field_543, var3, (byte)64);
   }

   // $FF: renamed from: <init> (int) void
   public Button(int var1) {
      super();
      this.field_543 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean method_647() {
      int var1 = this.field_543;
      return (this.field_543 >> 24 & -128) == -128;
   }

   // $FF: renamed from: a (boolean) void
   public final void method_648(boolean var1) {
      int var10002 = this.field_543;
      this.field_543 = method_642(this.field_543, var1, (byte)-128);
   }

   // $FF: renamed from: b () boolean
   public final boolean method_649() {
      int var1 = this.field_543;
      return (this.field_543 >> 24 & 64) == 64;
   }

   // $FF: renamed from: b (boolean) void
   public final void method_650(boolean var1) {
      int var10002 = this.field_543;
      this.field_543 = method_642(this.field_543, var1, (byte)64);
   }

   // $FF: renamed from: c () boolean
   public final boolean method_651() {
      int var1 = this.field_543;
      return (this.field_543 >> 24 & 16) == 16;
   }

   // $FF: renamed from: a () byte
   public final byte method_652() {
      int var1 = this.field_543;
      return (byte)this.field_543;
   }

   // $FF: renamed from: a () java.lang.String
   public final String method_653() {
      return MessagesContainer.getLine(method_640(this.field_543));
   }

   // $FF: renamed from: a (java.lang.String) void
   public final void method_654(String var1) {
      this.field_546 = var1;
      boolean var3 = true;
      boolean var2 = true;
      int var4 = this.field_543;
      this.field_543 = method_642(this.field_543, var2, (byte)16);
   }

   // $FF: renamed from: a (java.lang.String[]) void
   public final void method_655(String[] var1) {
      this.field_547 = var1;
      this.field_543 = method_642(this.field_543, true, (byte)8);
   }

   // $FF: renamed from: a (short) void
   public final void method_656(short var1) {
      this.field_543 = method_641(this.field_543, var1);
   }

   // $FF: renamed from: d () boolean
   public final boolean method_657() {
      int var1 = this.field_543;
      return (this.field_543 >> 24 & 8) == 8;
   }

   // $FF: renamed from: e () boolean
   public final boolean method_658() {
      int var1 = this.field_543;
      return (this.field_543 >> 24 & 4) == 4;
   }

   // $FF: renamed from: c (boolean) void
   public final void method_659(boolean var1) {
      boolean var2 = true;
      int var3 = this.field_543;
      this.field_543 = method_642(this.field_543, var2, (byte)4);
   }
}
