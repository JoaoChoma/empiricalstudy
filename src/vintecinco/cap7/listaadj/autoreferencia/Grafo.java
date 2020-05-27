/* 0001 */ package vintecinco.cap7.listaadj.autoreferencia;
/* 0002 */ import vintecinco.cap3.autoreferencia.Lista;
/* 0003 */ public class Grafo {
/* 0004 */   public static class Aresta {
/* 0005 */     private int v1, v2, peso;
/* 0006 */     public Aresta (int v1, int v2, int peso) {
/* 0007 */       this.v1 = v1; this.v2 = v2; this.peso = peso;
/* 0008 */     }
/* 0009 */     public int peso () { return this.peso; }
/* 0010 */     public int v1 () { return this.v1; }
/* 0011 */     public int v2 () { return this.v2; }
/* 0012 */   }  
/* 0013 */   private static class Celula {
/* 0014 */     int vertice, peso;
/* 0015 */     public Celula (int v, int p) {this.vertice = v; this.peso = p;}
/* 0016 */     public boolean equals (Object obj) {
/* 0017 */       Celula item = (Celula) obj;
/* 0018 */       return (this.vertice == item.vertice);
/* 0019 */     }
/* 0020 */   }  
/* 0021 */   private Lista adj[]; 
/* 0022 */   private int numVertices;
/* 0023 */   public Grafo () { 
/* 0024 */ 	  int numVertices = 100; /*(p1)*/
/* 0025 */     this.adj = new Lista[numVertices]; this.numVertices = numVertices; 
/* 0026 */     for (int i = 0; i < this.numVertices; i++) this.adj[i] = new Lista();
/* 0027 */   } 
/* 0028 */   public void insereAresta (int v1, int v2, int peso) {
/* 0029 */     Celula item = new Celula (v2, peso); 
/* 0030 */     this.adj[v1].insere (item); 
/* 0031 */   }  
/* 0032 */   public boolean existeAresta (int v1, int v2) {
/* 0033 */     Celula item = new Celula (v2, 0);
/* 0034 */     return (this.adj[v1].pesquisa (item) != null);
/* 0035 */   }
/* 0036 */   public boolean listaAdjVazia (int v) {
/* 0037 */     return this.adj[v].vazia ();
/* 0038 */   }
/* 0039 */   public Aresta primeiroListaAdj (int v) {
/* 0040 */     // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@
/* 0041 */     // @{\it {\bf NULL} se a lista de adjac\^encia de v for vazia}@ 
/* 0042 */     Celula item = (Celula) this.adj[v].primeiro ();
/* 0043 */     return item != null ? new Aresta (v, item.vertice, item.peso) : null; /*(p2)*/ //49
/* 0044 */   }
// primeiroListaAdj = proxAdj, isso pode dar algum problema?
/* 0045 */   public Aresta proxAdj (int v) {
/* 0046 */     // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@
/* 0047 */     // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@
/* 0048 */     Celula item = (Celula) this.adj[v].proximo ();    
/* 0049 */     return item != null ? new Aresta (v, item.vertice, item.peso) : null; /*(p2)*/ //43
/* 0050 */   }
/* 0051 */   public Aresta retiraAresta (int v1, int v2) throws Exception {
/* 0052 */     Celula chave = new Celula (v2, 0);
/* 0053 */     Celula item = (Celula) this.adj[v1].retira (chave);
/* 0054 */     return item != null ? new Aresta (v1, v2, item.peso) : null; /*(p2)*/ //43-49
/* 0055 */   }
/* 0056 */   public void imprime () {
/* 0057 */     for (int i = 0; i < this.numVertices; i++) { 
/* 0058 */       System.out.println ("Vertice " + i + ":");
/* 0059 */       Celula item = (Celula) this.adj[i].primeiro ();
/* 0060 */       while (item != null) {
/* 0061 */         System.out.println ("  " + item.vertice + " (" +item.peso+ ")");
/* 0062 */         item = (Celula) this.adj[i].proximo (); /*(p4)->59*/
/* 0063 */       }
/* 0064 */     }
/* 0065 */   }
/* 0066 */   public int numVertices () { return this.numVertices; }
/* 0067 */   public Grafo grafoTransposto () {
/* 0068 */     Grafo grafoT = new Grafo (); 
/* 0069 */     for (int v = 0; v < this.numVertices; v++)
/* 0070 */       if (!this.listaAdjVazia (v)) {
/* 0071 */         Aresta adj = this.primeiroListaAdj (v);
/* 0072 */         while (adj != null) {
/* 0073 */           grafoT.insereAresta (adj.v2 (), adj.v1 (), adj.peso ());
/* 0074 */           adj = this.proxAdj (v); /*(p4)->71*/
/* 0075 */         }
/* 0076 */       }
/* 0077 */     return grafoT;
/* 0078 */   } 
/* 0079 */ }