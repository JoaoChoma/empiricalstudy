/* 0001 */ package vintenove.cap7;
/* 0002 */ import vintenove.cap7.listaadj.autoreferencia.Grafo;
/* 0003 */ public class BuscaEmProfundidade {
/* 0004 */   public static final byte branco = 0; /*(p1)*/
/* 0005 */   public static final byte cinza  = 1; /*(p1)*/
/* 0006 */   public static final byte preto  = 2; /*(p1)*/
/* 0007 */   private int d[], t[], antecessor[];
/* 0008 */   private Grafo grafo;
/* 0009 */   public BuscaEmProfundidade (Grafo grafo) {
/* 0010 */     this.grafo = grafo; int n = this.grafo.numVertices();
/* 0011 */     d = new int[n]; t = new int[n]; antecessor = new int[n];
/* 0012 */   }
/* 0013 */   private int visitaDfs (int u, int tempo, int cor[]) {
/* 0014 */     cor[u] = cinza; /*(p1)*/ this.d[u] = ++tempo; /*(p4)->14*/
/* 0015 */ //    System.out.println ("Visita "+u+" Descoberta:"+this.d[u]+" cinza");
/* 0016 */     if (!this.grafo.listaAdjVazia (u)) {
/* 0017 */       Grafo.Aresta a = this.grafo.primeiroListaAdj (u);
/* 0018 */       while (a != null) {
/* 0019 */         int v = a.v2 ();
/* 0020 */         if (cor[v] == branco) {
/* 0021 */           this.antecessor[v] = u;
/* 0022 */           tempo = this.visitaDfs (v, tempo, cor);
/* 0023 */         }
/* 0024 */         a = this.grafo.proxAdj (u); /*(p4)->17*/
/* 0025 */       }
/* 0026 */     }
/* 0027 */     cor[u] = preto; /*(p4) -> 14*/ this.t[u] = ++tempo; /*(p4)->27*/
/* 0028 */ //    System.out.println ("Visita " +u+ " Termino:" +this.t[u]+ " preto");
/* 0029 */     return tempo;
/* 0030 */   }
/* 0031 */   public void buscaEmProfundidade () {
/* 0032 */     int tempo = 0; /*(p1)*/ int cor[] = new int[this.grafo.numVertices ()]; 
/* 0033 */     for (int u = 0; u < grafo.numVertices (); u++) { /*(p2)*/ // 36
/* 0034 */       cor[u] = branco; /*(p1)*/ this.antecessor[u] = -1; /*(p1)*/ /*(p4)->21*/
/* 0035 */     }     
/* 0036 */     for (int u = 0; u < grafo.numVertices (); u++) /*(p2)*/ // 33
/* 0037 */       if (cor[u] == branco) tempo = this.visitaDfs (u, tempo, cor);
/* 0038 */   }
/* 0039 */   public int d (int v) { return this.d[v]; }
/* 0040 */   public int t (int v) { return this.t[v]; }
/* 0041 */   public int antecessor (int v) { return this.antecessor[v]; }
/* 0042 */ }