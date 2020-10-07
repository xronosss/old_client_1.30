package mobak.text;

import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;
import mobak.a.SocketListener;

// $FF: renamed from: mobak.c.e
public final class RMSManager {

   // $FF: renamed from: a javax.microedition.rms.RecordStore
   public RecordStore recordStore;
   // $FF: renamed from: a byte[]
   private byte[] recordIndex;


   // $FF: renamed from: <init> () void
   public RMSManager() {
      super();
      this.recordIndex = new byte[1];

      try {
         this.recordStore = RecordStore.openRecordStore("LM", true);
      } catch (Exception var2) {
         SocketListener.logMessage("RMSManager " + var2.toString());
      }
   }

   // $FF: renamed from: a (byte, int) boolean
   public final boolean setInt(byte var1, int value) {
      byte[] data = new byte[4];
      data[3] = (byte) value;
      data[2] = (byte)(value >> 8);
      data[1] = (byte)(value >> 16);
      data[0] = (byte)(value >>> 24);
      return this.writeData(var1, data);
   }

   // $FF: renamed from: a (byte, byte) boolean
   public final boolean setByte(byte var1, byte value) {
      return this.writeData(var1, new byte[]{value});
   }

   // $FF: renamed from: a (byte, java.lang.String) boolean
   public final boolean setString(byte var1, String value) {
      if(value != null && !value.trim().equals("")) {
         try {
            byte[] data;
            if(SocketListener.encoding != null && !SocketListener.encoding.equals("")) {
               data = value.getBytes(SocketListener.encoding);
            } else {
               data = value.getBytes();
            }

            return this.writeData(var1, data);
         } catch (Exception var3) {
            SocketListener.logMessage("setString" + var3.toString());
            return false;
         }
      } else {
         return false;
      }
   }

   // $FF: renamed from: a (java.lang.String) int
   public final int getRecordId(String var1) {
      try {
         byte[] data = var1.getBytes();
         LMRecordFilter lmRecordFilter = new LMRecordFilter(this, data);
         RecordEnumeration recordEnumeration = this.recordStore.enumerateRecords(lmRecordFilter, (RecordComparator)null, false);
         if(recordEnumeration.numRecords() > 0) {
            return recordEnumeration.nextRecordId();
         }
      } catch (Exception var2) {
         ;
      }

      return -1;
   }

   // $FF: renamed from: a (java.lang.String, byte[]) boolean
   public final boolean setFile(String var1, byte[] var2) {
      if(var1 != null && !var1.equals("") && var2 != null) {
         try {
            int var3 = this.getRecordId(var1);
            if(var3 > 0) {
               this.recordStore.deleteRecord(var3);
            }

            byte[] var5 = var1.getBytes();
            byte[] var6 = new byte[1 + var5.length + var2.length];
            var6[0] = 95;
            System.arraycopy(var5, 0, var6, 1, var5.length);
            System.arraycopy(var2, 0, var6, 1 + var5.length, var2.length);
            this.recordStore.addRecord(var6, 0, var6.length);
            return true;
         } catch (Exception var4) {
            ;
         }
      } else {
         SocketListener.logMessage("RMSManager.setFile() ERROR");
      }

      return false;
   }

   // $FF: renamed from: a (java.lang.String) byte[]
   public final byte[] getFile(String fileName) {
      try {
         if(fileName != null && !fileName.equals("")) {
            byte[] prefix = fileName.getBytes();
            int recordId = this.getRecordId(fileName);
            if(recordId != -1) {
               byte[] record = this.recordStore.getRecord(recordId);
               byte[] newData = new byte[record.length - prefix.length - 1];
               System.arraycopy(record, prefix.length + 1, newData, 0, newData.length);
               return newData;
            }
         } else {
            System.out.println("RMSManager.getFile() ERROR: name is wrong");
         }
      } catch (Exception var4) {
         SocketListener.logMessage("RMSManager.getFile() ERROR");
      }

      return null;
   }

   // $FF: renamed from: a (byte, byte[]) boolean
   public final boolean writeData(byte recordIndex, byte[] data) {
      try {
         if(this.recordStore == null) {
            return false;
         } else {
            try {
               if(data != null && data.length != 0) {
                  class_74 var10001 = new class_74(this, new byte[]{recordIndex});
                  RecordEnumeration recordEnumeration = this.recordStore.enumerateRecords(var10001, (RecordComparator)null, false);
                  byte[] newData = new byte[1 + data.length];
                  this.recordIndex[0] = recordIndex;
                  System.arraycopy(this.recordIndex, 0, newData, 0, 1);
                  System.arraycopy(data, 0, newData, 1, data.length);
                  if(recordEnumeration.numRecords() > 0) {
                     int recordId = recordEnumeration.nextRecordId();
                     if(this.recordStore.getSizeAvailable() + this.recordStore.getRecordSize(recordId) < newData.length) {
                        throw new Exception("no available space");
                     } else {
                        this.recordStore.setRecord(recordId, newData, 0, newData.length);
                        return true;
                     }
                  } else if(this.recordStore.getSizeAvailable() < newData.length) {
                     throw new Exception("no available space");
                  } else {
                     this.recordStore.addRecord(newData, 0, newData.length);
                     return true;
                  }
               } else {
                  return this.delete(recordIndex);
               }
            } catch (RecordStoreNotOpenException var5) {
               SocketListener.logMessage("RecordStoreNotOpenException" + var5.toString());
               return false;
            } catch (InvalidRecordIDException var6) {
               SocketListener.logMessage("InvalidRecordIDException" + var6.toString());
               return false;
            } catch (RecordStoreException var7) {
               SocketListener.logMessage("RecordStoreException" + var7.toString());
               return false;
            }
         }
      } catch (Exception var8) {
         SocketListener.logMessage("cannot write data to RMS" + var8.toString());
         return false;
      }
   }

   // $FF: renamed from: a (byte, long) long
   public final long getLong(byte var1, long cancelValue) {
      try {
         byte[] var8;
         if((var8 = this.method_673(var1)) != null && var8.length == 8) {
            long var5 = 0L;

            for(byte var4 = 0; var4 < 8; ++var4) {
               var5 |= (long)(var8[var4] & 127);
               if(var8[var4] < 0) {
                  var5 |= 128L;
               }

               if(var4 < 7) {
                  var5 <<= 8;
               }
            }

            return var5;
         } else {
            return cancelValue;
         }
      } catch (Exception var7) {
         SocketListener.logMessage("getLong" + var7.toString());
         return cancelValue;
      }
   }

   // $FF: renamed from: a (byte, int) int
   public final int getInt(byte var1, int cancelValue) {
      try {
         byte[] var6;
         if((var6 = this.method_673(var1)) != null && var6.length == 4) {
            int var3 = 0;

            for(byte var4 = 0; var4 < 4; ++var4) {
               var3 |= var6[var4] & 127;
               if(var6[var4] < 0) {
                  var3 |= 128;
               }

               if(var4 < 3) {
                  var3 <<= 8;
               }
            }

            return var3;
         } else {
            return cancelValue;
         }
      } catch (Exception var5) {
         SocketListener.logMessage("getInt" + var5.toString());
         return cancelValue;
      }
   }

   // $FF: renamed from: a (byte, short) short
   public final short getShort(byte var1, short cancelValue) {
      try {
         byte[] var5;
         if((var5 = this.method_673(var1)) != null && var5.length == 2) {
            cancelValue = 0;

            for(byte var3 = 0; var3 < 2; ++var3) {
               cancelValue = (short)(cancelValue | var5[var3] & 127);
               if(var5[var3] < 0) {
                  cancelValue = (short)(cancelValue | 128);
               }

               if(var3 <= 0) {
                  cancelValue = (short)(cancelValue << 8);
               }
            }

            return cancelValue;
         } else {
            return cancelValue;
         }
      } catch (Exception var4) {
         SocketListener.logMessage("getShort" + var4.toString());
         return cancelValue;
      }
   }

   // $FF: renamed from: a (byte, byte) byte
   public final byte getByte(byte var1, byte cancelValue) {
      try {
         byte[] var4 = this.method_673(var1);
         return var4 != null && var4.length == 1?var4[0]:cancelValue;
      } catch (Exception var3) {
         SocketListener.logMessage("getByte" + var3.toString());
         return cancelValue;
      }
   }

   // $FF: renamed from: a (byte, java.lang.String) java.lang.String
   public final String getString(byte var1, String cancelValue) {
      byte[] var4;
      if((var4 = this.method_673(var1)) == null) {
         return cancelValue;
      } else {
         try {
            return SocketListener.encoding != null && !SocketListener.encoding.equals("")?new String(var4, SocketListener.encoding):new String(var4);
         } catch (Exception var3) {
            SocketListener.logMessage(var3.getMessage());
            return cancelValue;
         }
      }
   }

   // $FF: renamed from: a (byte) byte[]
   public final byte[] method_673(byte var1) {
      if(this.recordStore == null) {
         return null;
      } else {
         try {
            this.recordIndex[0] = var1;
            RecordStore var10000 = this.recordStore;
            class_74 var10001 = new class_74(this, this.recordIndex);
            RecordEnumeration var7;
            if((var7 = var10000.enumerateRecords(var10001, (RecordComparator)null, false)).numRecords() > 0) {
               byte[] var8;
               byte[] var2 = new byte[(var8 = var7.nextRecord()).length - 1];
               System.arraycopy(var8, 1, var2, 0, var2.length);
               return var2;
            } else {
               return null;
            }
         } catch (RecordStoreNotOpenException var3) {
            SocketListener.logMessage("RecordStoreNotOpenException" + var3.toString());
            return null;
         } catch (InvalidRecordIDException var4) {
            SocketListener.logMessage("InvalidRecordIDException" + var4.toString());
            return null;
         } catch (RecordStoreException var5) {
            SocketListener.logMessage("RecordStoreException" + var5.toString());
            return null;
         } catch (Exception var6) {
            SocketListener.logMessage("RMS Exception" + var6.toString());
            return null;
         }
      }
   }

   // $FF: renamed from: a (byte) short[]
   public final short[] method_674(byte var1) {
      if(this.recordStore == null) {
         return null;
      } else {
         try {
            this.recordIndex[0] = var1;
            RecordStore var10000 = this.recordStore;
            class_74 var10001 = new class_74(this, this.recordIndex);
            RecordEnumeration var9;
            if((var9 = var10000.enumerateRecords(var10001, (RecordComparator)null, false)).numRecords() <= 0) {
               return null;
            } else {
               byte[] var2;
               byte[] var10;
               short[] var3 = new short[(var2 = new byte[(var10 = var9.nextRecord()).length - 1]).length / 2];
               System.arraycopy(var10, 1, var2, 0, var2.length);
               short var11 = 0;

               for(short var4 = 0; var4 < var2.length; var4 = (short)(var4 + 2)) {
                  var3[var11] = (short)((short)(var2[var4] << 8 & '\uff00') | (short)(var2[var4 + 1] & 255));
                  ++var11;
               }

               return var3;
            }
         } catch (RecordStoreNotOpenException var5) {
            SocketListener.logMessage("RecordStoreNotOpenException" + var5.toString());
            return null;
         } catch (InvalidRecordIDException var6) {
            SocketListener.logMessage("InvalidRecordIDException" + var6.toString());
            return null;
         } catch (RecordStoreException var7) {
            SocketListener.logMessage("RecordStoreException" + var7.toString());
            return null;
         } catch (Exception var8) {
            SocketListener.logMessage("RMS Exception" + var8.toString());
            return null;
         }
      }
   }

   // $FF: renamed from: b (byte) boolean
   private boolean delete(byte var1) {
      try {
         this.recordIndex[0] = var1;
         RecordStore var10000 = this.recordStore;
         class_74 var10001 = new class_74(this, this.recordIndex);
         RecordEnumeration var3;
         if((var3 = var10000.enumerateRecords(var10001, (RecordComparator)null, false)).numRecords() > 0) {
            this.recordStore.deleteRecord(var3.nextRecordId());
         }

         return true;
      } catch (Exception var2) {
         SocketListener.logMessage("delete" + var2.toString());
         return false;
      }
   }

   // $FF: renamed from: a (byte) boolean
   public final boolean deleteAll(byte var1) {
      try {
         RecordStore var10000;
         class_74 var10001;
         RecordEnumeration var7;
         if(var1 != -1) {
            var10000 = this.recordStore;
            var10001 = new class_74(this, new byte[]{var1});
            var7 = var10000.enumerateRecords(var10001, (RecordComparator)null, false);
         } else {
            var10000 = this.recordStore;
            var10001 = new class_74(this, (byte[])null);
            var7 = var10000.enumerateRecords(var10001, (RecordComparator)null, false);
         }

         int var2 = var7.numRecords();

         for(int var3 = 0; var3 < var2; ++var3) {
            try {
               this.recordStore.deleteRecord(var7.nextRecordId());
            } catch (Exception var5) {
               SocketListener.logMessage("deleteOne" + var5.toString());
            }
         }

         return true;
      } catch (Exception var6) {
         SocketListener.logMessage("deleteAll" + var6.toString());
         return false;
      }
   }

   // $FF: renamed from: a (byte[], int, short) short
   public static short method_677(byte[] var0, int var1, short var2) {
      return var0 != null && var0.length - var1 >= 2?(short)((short)((255 & var0[var1]) << 8) | 255 & var0[var1 + 1]):var2;
   }

   // $FF: renamed from: a (byte[], int, int, java.lang.String) java.lang.String
   public static String getString(byte[] var0, int var1, int var2, String cancelValue) {
      try {
         if(var0 != null && var0.length - var1 >= var2) {
            byte[] var4 = new byte[var2];
            System.arraycopy(var0, var1, var4, 0, var2);
            return SocketListener.encoding != null && !SocketListener.encoding.equals("")?new String(var4, SocketListener.encoding):new String(var4);
         } else {
            return cancelValue;
         }
      } catch (Exception var5) {
         SocketListener.logMessage("RMSManager.getString " + var5.toString());
         return cancelValue;
      }
   }

   // $FF: renamed from: a (int) short
   public static final short method_679(int var0) {
      return var0 > 32767?32767:(var0 < -32768?-32768:(short)var0);
   }
}
