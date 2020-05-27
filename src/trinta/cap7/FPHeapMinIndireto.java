/* 0001 */ package trinta.cap7;
/* 0002 */ public class FPHeapMinIndireto { 
/* 0003 */   private double p[]; 
/* 0004 */   private int n, pos[], fp[];    
/* 0005 */ 
/* 0006 */   public FPHeapMinIndireto (double p[], int v[]) { 
/* 0007 */     this.p = p; this.fp = v; this.n = this.fp.length-1;
/* 0008 */     this.pos = new int[this.n];
/* 0009 */     for (int u = 0; u < this.n; u++) this.pos[u] = u+1;
/* 0010 */   }
/* 0011 */ 
/* 0012 */   public void refaz (int esq, int dir) {
/* 0013 */     int j = esq * 2;
/* 0014 */     int x = this.fp[esq];
/* 0015 */     while (j <= dir) { /*(p3)*/
/* 0016 */       if ((j < dir) && (this.p[fp[j]] > this.p[fp[j + 1]])) j++; /*(p3)*/
/* 0017 */       if (this.p[x] <= this.p[fp[j]]) break;
/* 0018 */       this.fp[esq] = this.fp[j]; this.pos[fp[j]] = esq;
/* 0019 */       esq = j; j = esq * 2; /*(p4) -> 12*/
/* 0020 */     }
/* 0021 */     this.fp[esq] = x; this.pos[x] = esq; /*(p4) -> 18*/
/* 0022 */   }
/* 0023 */ 
/* 0024 */   public void constroi () {
/* 0025 */     int esq = n / 2 + 1;
/* 0026 */     while (esq > 1) { esq--; /*(p4)-> 25*/ this.refaz (esq, this.n); }
/* 0027 */   }
/* 0028 */  
/* 0029 */   public int retiraMin () throws Exception {
/* 0030 */     int minimo;
/* 0031 */     if (this.n < 1) throw new Exception ("Erro: heap vazio");
/* 0032 */     else {
/* 0033 */       minimo = this.fp[1]; this.fp[1] = this.fp[this.n];
/* 0034 */       this.pos[fp[this.n--]] = 1; this.refaz (1, this.n); /*(p4) -> this.pos[]*/
/* 0035 */     }
/* 0036 */     return minimo;
/* 0037 */   }
/* 0038 */ 
/* 0039 */   public void diminuiChave (int i, double chaveNova) throws Exception {
/* 0040 */     i = this.pos[i]; int x = fp[i];
/* 0041 */     if (chaveNova < 0)
/* 0042 */       throw new Exception ("Erro: chaveNova com valor incorreto");
/* 0043 */     this.p[x] = chaveNova;
/* 0044 */     while ((i > 1) && (this.p[x] <= this.p[fp[i / 2]])) {
/* 0045 */       this.fp[i] = this.fp[i / 2]; this.pos[fp[i / 2]] = i; i /= 2; /*(p4) -> 40*/ /*(p4) this.pos[]*/
/* 0046 */     }
/* 0047 */     this.fp[i] = x; this.pos[x] = i;
/* 0048 */   }
/* 0049 */ 
/* 0050 */   boolean vazio () { return this.n == 0; }
/* 0051 */     
/* 0052 */   public void imprime () {
/* 0053 */     for (int i = 1; i <= this.n; i++)
/* 0054 */       System.out.print (this.p[fp[i]] + " ");
/* 0055 */     System.out.println ();
/* 0056 */   }
/* 0057 */ 
/* 0058 */ }
/* 0059 */ 