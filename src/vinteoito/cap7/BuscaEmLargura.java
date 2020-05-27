/* 0001 */ package vinteoito.cap7;
/* 0002 */ import vinteoito.cap3.autoreferencia.Fila; 
/* 0003 */ import vinteoito.cap7.listaadj.autoreferencia.Grafo;
/* 0004 */ public class BuscaEmLargura {
/* 0005 */   public static final byte branco = 0; /*(p1)*/
/* 0006 */   public static final byte cinza  = 1; /*(p1)*/
/* 0007 */   public static final byte preto  = 2; /*(p1)*/
/* 0008 */   private int d[], antecessor[];
/* 0009 */   private Grafo grafo;
/* 0010 */   public BuscaEmLargura (Grafo grafo) {
/* 0011 */     this.grafo = grafo; int n = this.grafo.numVertices();
/* 0012 */     this.d = new int[n]; this.antecessor = new int[n];
/* 0013 */   }
/* 0014 */   private void visitaBfs (int u, int cor[]) throws Exception {
/* 0015 */     cor[u] = cinza; /*(p1)*/ this.d[u] = 0 /*(p1)*/;
/* 0016 */     Fila fila = new Fila (); fila.enfileira (new Integer (u));
/* 0017 */ //    System.out.print ("Visita origem:"+u+" cor: cinza F:");
/* 0018 */ //    fila.imprime ();
/* 0019 */     while (!fila.vazia ()) {
/* 0020 */       Integer aux = (Integer)fila.desenfileira (); u = aux.intValue(); 
/* 0021 */       if (!this.grafo.listaAdjVazia (u)) {
/* 0022 */         Grafo.Aresta a = this.grafo.primeiroListaAdj (u);
/* 0023 */         while (a != null) {
/* 0024 */           int v = a.v2 ();
/* 0025 */           if (cor[v] == branco) {
/* 0026 */             cor[v] = cinza; this.d[v] = this.d[u] + 1;
/* 0027 */             this.antecessor[v] = u; fila.enfileira (new Integer (v));
/* 0028 */           }
/* 0029 */           a = this.grafo.proxAdj (u); /*(p4)-> 22*/
/* 0030 */         }
/* 0031 */       }
/* 0032 */       cor[u] = preto; /*(p4) -> 15*/
/* 0033 */       System.out.print("Visita "+u+" dist: "+this.d[u]+" cor: preto F:");
/* 0034 */       fila.imprime ();
/* 0035 */     }
/* 0036 */   }
/* 0037 */   public void buscaEmLargura () throws Exception {
/* 0038 */     int cor[] = new int[this.grafo.numVertices ()]; 
/* 0039 */     for (int u = 0; u < grafo.numVertices (); u++) { /*(p2)*/ //43
/* 0040 */       cor[u] = branco; this.d[u] = Integer.MAX_VALUE; 
/* 0041 */       this.antecessor[u] = -1; /*(p1)*/
/* 0042 */     }     
/* 0043 */     for (int u = 0; u < grafo.numVertices (); u++) /*(p2)*/ //39
/* 0044 */       if (cor[u] == branco) this.visitaBfs (u, cor);
/* 0045 */   }
/* 0046 */   public int d (int v) { return this.d[v]; }
/* 0047 */   public int antecessor (int v) { return this.antecessor[v]; }  
/* 0048 */   public void imprimeCaminho (int origem, int v) {
/* 0049 */     if (origem == v) System.out.println (origem);
/* 0050 */     else if (this.antecessor[v] == -1) 
/* 0051 */       System.out.println ("Nao existe caminho de " + origem + " ate " + v);
/* 0052 */     else {
/* 0053 */       imprimeCaminho (origem, this.antecessor[v]);
/* 0054 */       System.out.println (v);
/* 0055 */     }    
/* 0056 */   }
/* 0057 */ }