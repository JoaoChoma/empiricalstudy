/* 0001 */ package um.cap1;
/* 0002 */ public class MeuItem implements Item {
/* 0003 */   public int chave;
/* 0004 */   // @{\it outros componentes do registro}@
/* 0005 */  
/* 0006 */   public MeuItem (int chave) { this.chave = chave; }
/* 0007 */   
/* 0008 */   public int compara (Item it) {
/* 0009 */     MeuItem item = (MeuItem) it; 
/* 0010 */     if (this.chave < item.chave) return -1; /*(p2)*/
/* 0011 */     if (this.chave > item.chave) return 1; /*(p2)*/
/* 0012 */     return 0;
/* 0013 */   }
/* 0014 */ }
