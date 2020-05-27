/* 0001 */ package trinta.cap7;
/* 0002 */ import trinta.cap7.listaadj.autoreferencia.Grafo;
/* 0003 */ public class AgmPrim {
/* 0004 */   private int antecessor[];
/* 0005 */   private double p[];
/* 0006 */   private Grafo grafo;
/* 0007 */ 
/* 0008 */   public AgmPrim (Grafo grafo) { this.grafo = grafo; }  
/* 0009 */   public void obterAgm (int raiz) throws Exception {
/* 0010 */     int n = this.grafo.numVertices();
/* 0011 */     this.p = new double[n];
/* 0012 */     int vs[] = new int[n+1];
/* 0013 */     boolean itensHeap[] = new boolean[n]; this.antecessor = new int[n];
/* 0014 */     for (int u = 0; u < n; u ++) {
/* 0015 */       this.antecessor[u] = -1; /* não é (p1) inicializador e não atribuição de variável*/
/* 0016 */       p[u] = Double.MAX_VALUE; 
/* 0017 */       vs[u+1] = u;
/* 0018 */       itensHeap[u] = true; /* não é (p1) inicializador e não atribuição de variável */
/* 0019 */     }
/* 0020 */     p[raiz] = 0; /*(p1)*/
/* 0021 */     FPHeapMinIndireto heap = new FPHeapMinIndireto (p, vs); 
/* 0022 */     heap.constroi ();
/* 0023 */     while (!heap.vazio ()) {
/* 0024 */       int u = heap.retiraMin (); itensHeap[u] = false; /*(p4) -> 18*/
/* 0025 */       if (!this.grafo.listaAdjVazia (u)) {
/* 0026 */         Grafo.Aresta adj = grafo.primeiroListaAdj(u);
/* 0027 */         while (adj != null) {
/* 0028 */           int v = adj.v2 ();
/* 0029 */           if (itensHeap[v] && (adj.peso () < this.peso (v))) {
/* 0030 */             antecessor[v] = u; heap.diminuiChave (v, adj.peso ()); /*(P4) 15*/
/* 0031 */           }
/* 0032 */           adj = grafo.proxAdj (u); /*(p4)->26*/
/* 0033 */         }
/* 0034 */       }
/* 0035 */     }
/* 0036 */   }
/* 0037 */   public int antecessor (int u) { return this.antecessor[u]; }
/* 0038 */   public double peso (int u) { return this.p[u]; }
/* 0039 */   public void imprime () {
/* 0040 */     for (int u = 0; u < this.p.length; u++)
/* 0041 */       if (this.antecessor[u] != -1) 
/* 0042 */         System.out.println ("(" +antecessor[u]+ "," +u+ ") -- p:" +
/* 0043 */                             peso (u));
/* 0044 */   }
/* 0045 */ }