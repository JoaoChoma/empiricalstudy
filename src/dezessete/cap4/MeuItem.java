/* 0001 */ package dezessete.cap4;
/* 0002 */ import java.io.*;
/* 0003 */ public class MeuItem implements Item {
/* 0004 */   private int chave;
/* 0005 */   // @{\it outros componentes do registro}@
/* 0006 */ 
/* 0007 */   public MeuItem (int chave) { this.chave = chave; }
/* 0008 */   
/* 0009 */   public int compara (Item it) {
/* 0010 */     MeuItem item = (MeuItem) it;
/* 0011 */     if (this.chave < item.chave) return -1; /*(p2)*/
/* 0012 */     else if (this.chave > item.chave) return 1; /*(p2)*/
/* 0013 */     return 0;
/* 0014 */   }
/* 0015 */   
/* 0016 */   public void alteraChave (Object chave) {
/* 0017 */     Integer ch = (Integer) chave; this.chave = ch.intValue (); /* (P4) 7*/
/* 0018 */   }
/* 0019 */   
/* 0020 */   public Object recuperaChave () { return new Integer (this.chave); }
/* 0021 */   
/* 0022 */   public String toString () { return "" + this.chave; }
/* 0023 */   
/* 0024 */   public void gravaArq (RandomAccessFile arq) throws IOException {
/* 0025 */     arq.writeInt (this.chave);
/* 0026 */   }
/* 0027 */   
/* 0028 */   public void leArq (RandomAccessFile arq) throws IOException {
/* 0029 */     this.chave = arq.readInt (); /* (P4) 7*/
/* 0030 */   }
/* 0031 */  
/* 0032 */   public static int tamanho () { return 4; }
/* 0033 */ }