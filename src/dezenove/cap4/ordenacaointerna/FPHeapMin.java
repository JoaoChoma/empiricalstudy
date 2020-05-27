/* 0001 */ package dezenove.cap4.ordenacaointerna;
/* 0002 */ import dezenove.cap4.Item; // @{\it vide Programa~\ref{prog:interfaceitem}}@
/* 0003 */ public class FPHeapMin {
/* 0004 */   private Item v[];
/* 0005 */   private int  n;
/* 0006 */ 
/* 0007 */   public FPHeapMin (int maxTam) { 
/* 0008 */     this.v = new Item[maxTam + 1];
/* 0009 */     this.n = 0;
/* 0010 */   }
/* 0011 */ 
/* 0012 */   public FPHeapMin (Item v[]) { this.v = v; this.n = this.v.length - 1; }
/* 0013 */ 
/* 0014 */   public void refaz (int esq, int dir) {
/* 0015 */     int j = esq * 2;
/* 0016 */     Item x = this.v[esq];
/* 0017 */     while (j <= dir) { /*(p3)*/
/* 0018 */       if ((j < dir) && (this.v[j].compara (this.v[j + 1]) > 0)) j++; /*(p2) (p3) (p4) -> 15*/ 
/* 0019 */       if (x.compara (this.v[j]) <= 0) break; /*(p2)*/
/* 0020 */       this.v[esq] = this.v[j]; esq = j; j = esq * 2; /*(p4) -> 15*/ 
/* 0021 */     }
/* 0022 */     this.v[esq] = x; /*(p4) -> 20*/ 
/* 0023 */   }
/* 0024 */ 
/* 0025 */   public void constroi () {
/* 0026 */     int esq = n / 2 + 1;
/* 0027 */     while (esq > 1) { esq--; this.refaz (esq, this.n); } /*(p4) -> 26*/ 
/* 0028 */   }
/* 0029 */ 
/* 0030 */   public Item min () { return this.v[1]; }
/* 0031 */ 
/* 0032 */   public Item retiraMin () throws Exception {
/* 0033 */     Item minimo;
/* 0034 */     if (this.n < 1) throw new Exception ("Erro: heap vazio");
/* 0035 */     else {
/* 0036 */       minimo = this.v[1]; this.v[1] = this.v[this.n--]; /*(p4) n -> 9*/
/* 0037 */       refaz (1, this.n);
/* 0038 */     }
/* 0039 */     return minimo;
/* 0040 */   }
/* 0041 */ 
/* 0042 */ public void diminuiChave (int i, Object chaveNova) throws Exception {
/* 0043 */   Item x = this.v[i];
/* 0044 */   if (chaveNova == null)
/* 0045 */     throw new Exception ("Erro: chaveNova com valor null");
/* 0046 */   x.alteraChave (chaveNova);
/* 0047 */   while ((i > 1) && (x.compara (this.v[i / 2]) <= 0)) {
/* 0048 */     this.v[i] = this.v[i / 2]; i /= 2; /*(p4) i -> 42*/
/* 0049 */   }
/* 0050 */   this.v[i] = x;
/* 0051 */ }
/* 0052 */ 
/* 0053 */ public void insere (Item x) throws Exception {
/* 0054 */   this.n++; /*(p4) n -> 9*/
/* 0055 */   if (this.n == this.v.length) throw new Exception ("Erro: heap cheio");
/* 0056 */   Object chaveNova = x.recuperaChave (); this.v[this.n] = x;
/* 0057 */   this.v[this.n].alteraChave (new Integer (Integer.MAX_VALUE));
/* 0058 */   this.diminuiChave (this.n, chaveNova);
/* 0059 */ }
/* 0060 */ 
/* 0061 */   public void imprime () {
/* 0062 */     for (int i = 1; i <= this.n; i++)
/* 0063 */       System.out.print (this.v[i].toString () + " ");
/* 0064 */     System.out.println ();
/* 0065 */   }
/* 0066 */ 
/* 0067 */   public void copia (Item v[]) {
/* 0068 */     for (int i = 1; i < v.length; i++)
/* 0069 */       this.v[++this.n] = v[i]; /*(p4) n -> 9*/
/* 0070 */   }
/* 0071 */ }