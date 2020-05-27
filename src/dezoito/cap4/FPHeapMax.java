/* 0001 */ package dezoito.cap4;
/* 0002 */ import dezoito.cap4.Item; // @{\it vide Programa~\ref{prog:interfaceitem}}@
/* 0003 */ public class FPHeapMax {
/* 0004 */   private Item v[];
/* 0005 */   private int  n;
/* 0006 */   public FPHeapMax (int maxTam) { // @{\it Cria uma fila de prioridades vazia}@
/* 0007 */     this.v = new Item[maxTam + 1]; this.n = 0;
/* 0008 */   }
/* 0009 */   public void refaz (int esq, int dir) {
/* 0010 */     int j = esq * 2; Item x = this.v[esq];
/* 0011 */     while (j <= dir) { /*(p3)*/ // j<dir and j==dir então p3->12
/* 0012 */       if ((j < dir) && (this.v[j].compara (this.v[j + 1]) < 0)) j++; /*(p2) (p3)*/
/* 0013 */       if (x.compara (this.v[j]) >= 0) break; /*(p2)*/
/* 0014 */       this.v[esq] = this.v[j]; 
/* 0015 */       esq = j; j = esq * 2; /*(p4) 9*/
/* 0016 */     }
/* 0017 */     this.v[esq] = x; /*(P4) 14*/
/* 0018 */   }
/* 0019 */   public void constroi () {
/* 0020 */     int esq = n / 2 + 1;
/* 0021 */     while (esq > 1) {
/* 0022 */       esq--; this.refaz (esq, this.n); /*(P4) 20*/
/* 0023 */     }
/* 0024 */   }
/* 0025 */   public Item max () { return this.v[1]; }
/* 0026 */   public Item retiraMax () throws Exception {
/* 0027 */     Item maximo;
/* 0028 */     if (this.n < 1) throw new Exception ("Erro: heap vazio");
/* 0029 */     else {
/* 0030 */       maximo = this.v[1]; this.v[1] = this.v[this.n--]; 
/* 0031 */       refaz (1, this.n);
/* 0032 */     }
/* 0033 */     return maximo;
/* 0034 */   }
/* 0035 */   public void aumentaChave (int i, Object chaveNova) throws Exception {
/* 0036 */     Item x = this.v[i];
/* 0037 */     if (chaveNova == null) 
/* 0038 */       throw new Exception ("Erro: chaveNova com valor null");
/* 0039 */     x.alteraChave (chaveNova); /*(P4) 36*/
/* 0040 */     while ((i > 1) && (x.compara (this.v[i / 2]) >= 0)) {
/* 0041 */       this.v[i] = this.v[i / 2]; i /= 2;
/* 0042 */     }
/* 0043 */     this.v[i] = x; /*(P4) 36*/
/* 0044 */   }
/* 0045 */   public void insere (Item x) throws Exception {
/* 0046 */     this.n++; 
/* 0047 */     if (this.n == this.v.length) throw new Exception ("Erro: heap cheio");
/* 0048 */     Object chaveNova = x.recuperaChave ();
/* 0049 */     this.v[this.n] = x;
/* 0050 */     this.v[this.n].alteraChave (new Integer (Integer.MIN_VALUE)); // @$-\infty$@
/* 0051 */     this.aumentaChave (this.n, chaveNova);
/* 0052 */   }
/* 0053 */   public void imprime () {
/* 0054 */     for (int i = 1; i <= this.n; i++) System.out.print (this.v[i].toString () + " ");
/* 0055 */     System.out.println ();
/* 0056 */   }
/* 0057 */   
/* 0058 */   // metodo usado apenas para copiar o vetor para o heap, ignora-lo nos testes
/* 0059 */   public void copia (Item v[]) {
/* 0060 */ 	    for (int i = 1; i < v.length; i++) this.v[++this.n] = v[i];
/* 0061 */ 	  }
/* 0062 */ }