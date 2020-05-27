/* 0001 */ package vintenove.cap7;
/* 0002 */ import vintenove.cap7.listaadj.autoreferencia.Grafo;
/* 0003 */ public class Cfc {
/* 0004 */   private static class TempoTermino {
/* 0005 */     private int numRestantes, t[];
/* 0006 */     private boolean restantes[];
/* 0007 */     public TempoTermino (int numVertices) {
/* 0008 */       t = new int[numVertices];      
/* 0009 */       restantes = new boolean[numVertices];
/* 0010 */       numRestantes = numVertices;
/* 0011 */     }
/* 0012 */     public int maxTT () {
/* 0013 */       int vMax = 0; /*(p1)*/
/* 0014 */       while (!this.restantes[vMax]) vMax++; /*(p4)-> 13*/
/* 0015 */       for (int i = 0; i < this.t.length; i ++) {
/* 0016 */         if (this.restantes[i]) {
/* 0017 */           if (this.t[i] > this.t[vMax]) vMax = i; /*(p4)-> 14*/
/* 0018 */         }
/* 0019 */       }
/* 0020 */       return vMax;
/* 0021 */     }
/* 0022 */   }
/* 0023 */   private Grafo grafo;
/* 0024 */   public Cfc (Grafo grafo) { this.grafo = grafo; }
/* 0025 */   private void visitaDfs (Grafo grafo, int u, TempoTermino tt) {
/* 0026 */     tt.restantes[u] = false; tt.numRestantes --;     /*(p4)-> 25*/
/* 0027 */     System.out.println ("  Vertice: "+u);
/* 0028 */     if (!grafo.listaAdjVazia (u)) {
/* 0029 */       Grafo.Aresta a = grafo.primeiroListaAdj (u);
/* 0030 */       while (a != null) {
/* 0031 */         int v = a.v2 ();
/* 0032 */         if (tt.restantes[v]) { this.visitaDfs (grafo, v, tt); }
/* 0033 */         a = grafo.proxAdj (u); /*(p4) -> 29*/
/* 0034 */       }
/* 0035 */     }
/* 0036 */   }
/* 0037 */   public void obterCfc () {
/* 0038 */     BuscaEmProfundidade dfs = new BuscaEmProfundidade (this.grafo);
/* 0039 */     dfs.buscaEmProfundidade ();
/* 0040 */     TempoTermino tt = new TempoTermino (this.grafo.numVertices ());
/* 0041 */     for (int u = 0; u < this.grafo.numVertices (); u++) {
/* 0042 */       tt.t[u] = dfs.t (u); tt.restantes[u] = true; /*(p4)-> 40*/
/* 0043 */     }   
/* 0044 */     System.out.println ();
/* 0045 */     Grafo grafoT = this.grafo.grafoTransposto ();
/* 0046 */     while (tt.numRestantes > 0) {
/* 0047 */       int vRaiz = tt.maxTT ();
/* 0048 */       System.out.println ("Raiz da proxima arvore: " + vRaiz);
/* 0049 */       this.visitaDfs (grafoT, vRaiz, tt);
/* 0050 */     }
/* 0051 */   }  
/* 0052 */ }