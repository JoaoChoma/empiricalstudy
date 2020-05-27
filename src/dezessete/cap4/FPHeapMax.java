/* 0001 */ package dezessete.cap4;
/* 0002 */ public class FPHeapMax {
/* 0003 */   private Item v[];
/* 0004 */   private int  n;
/* 0005 */ 
/* 0006 */   public FPHeapMax (Item v[]) { // @{\it Cria uma fila de prioridades vazia}@
/* 0007 */     this.v = v; this.n = this.v.length - 1;
/* 0008 */   }
/* 0009 */   public void refaz (int esq, int dir) {
/* 0010 */     int j = esq * 2; Item x = this.v[esq];
/* 0011 */     while (j <= dir) { // j < dir and j == dir então /*(p2)*/ 12                          /*(p3) 11-12*/
/* 0012 */       if ((j < dir) && (this.v[j].compara (this.v[j + 1]) < 0)) j++; /*(p2)*/ //13
/* 0013 */       if (x.compara (this.v[j]) >= 0) break; /*(p2)*/
/* 0014 */       this.v[esq] = this.v[j]; /* (P4) 7*/
/* 0015 */       esq = j; j = esq * 2; /*(p4) 9*/
/* 0016 */     }
/* 0017 */     this.v[esq] = x;  /* (P4) 7*/
/* 0018 */   }
/* 0019 */   public void constroi () {
/* 0020 */     int esq = n / 2 + 1;
/* 0021 */     while (esq > 1) {
/* 0022 */       esq--; this.refaz (esq, this.n); /* (P4) 20*/
/* 0023 */     }
/* 0024 */   }
/* 0025 */ }