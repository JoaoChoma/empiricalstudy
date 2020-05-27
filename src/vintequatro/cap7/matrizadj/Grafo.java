/* 0001 */ package vintequatro.cap7.matrizadj;
/* 0002 */ 
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
/* 0013 */   private int mat[][]; 
/* 0014 */   private int numVertices;
/* 0015 */   private int pos[];
/* 0016 */ 
/* 0017 */   public Grafo () {
/* 0018 */ 	 	final int  numVertices = 100; /*(p1)*/
/* 0019 */     this.mat = new int[numVertices][numVertices];
/* 0020 */     this.pos = new int[numVertices]; 
/* 0021 */     this.numVertices = numVertices; 
/* 0022 */     for (int i = 0; i < this.numVertices; i++) {
/* 0023 */       for (int j = 0; j < this.numVertices; j++) this.mat[i][j] = 0; 
/* 0024 */       this.pos[i] = -1;
/* 0025 */     }
/* 0026 */   }
/* 0027 */   
/* 0028 */   public void insereAresta (int v1, int v2, int peso) {
/* 0029 */     this.mat[v1][v2] = peso;  /*(p4)->23*/
/* 0030 */   }
/* 0031 */   public boolean existeAresta (int v1, int v2) {
/* 0032 */     return (this.mat[v1][v2] > 0);
/* 0033 */   }
/* 0034 */   public boolean listaAdjVazia (int v) {
/* 0035 */     for (int i =0; i < this.numVertices; i++)
/* 0036 */       if (this.mat[v][i] > 0) return false;
/* 0037 */     return true;
/* 0038 */   }
/* 0039 */   public Aresta primeiroListaAdj (int v) {
/* 0040 */     // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@ 
/* 0041 */     // @{\it {\bf null} se a lista de adjac\^encia de v for vazia}@
/* 0042 */     this.pos[v] = -1; return this.proxAdj (v); /*(p4)->24 pos[]*/
/* 0043 */   }
/* 0044 */   public Aresta proxAdj (int v) {
/* 0045 */     // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@ 
/* 0046 */     // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@ 
/* 0047 */     this.pos[v] ++; /*(p)->24*/
/* 0048 */     while ((this.pos[v] < this.numVertices) /*(p3)*/ && /* 0049 */ (this.mat[v][this.pos[v]] == 0)) this.pos[v]++; /*(p4)->24*/
/* 0050 */     if (this.pos[v] == this.numVertices /*(p3)*/) return null;
/* 0051 */     else return new Aresta (v, this.pos[v], this.mat[v][this.pos[v]]);
/* 0052 */   }
/* 0053 */   public Aresta retiraAresta (int v1, int v2) {
/* 0054 */     if (this.mat[v1][v2] == 0) return null;
/* 0055 */     else {
/* 0056 */       Aresta aresta = new Aresta (v1, v2, this.mat[v1][v2]);
/* 0057 */       this.mat[v1][v2] = 0; return aresta;
/* 0058 */     }
/* 0059 */   }
/* 0060 */   public void imprime () {
/* 0061 */     System.out.print ("   ");
/* 0062 */     for (int i = 0; i < this.numVertices; i++) /*(p2)*/
/* 0063 */       System.out.print (i + "   "); 
/* 0064 */     System.out.println ();
/* 0065 */     for (int i = 0; i < this.numVertices; i++) {  /*(p2)*/
/* 0066 */       System.out.print (i + "  ");
/* 0067 */       for (int j = 0; j < this.numVertices; j++) /*(p2)*/
/* 0068 */         System.out.print (this.mat[i][j] + "   ");
/* 0069 */       System.out.println ();
/* 0070 */     }
/* 0071 */   }
/* 0072 */ 
/* 0073 */   public Grafo grafoTransposto () {
/* 0074 */     Grafo grafoT = new Grafo (); 
/* 0075 */     for (int v = 0; v < this.numVertices; v++)
/* 0076 */       if (!this.listaAdjVazia (v)) {
/* 0077 */         Aresta adj = this.primeiroListaAdj (v);
/* 0078 */         while (adj != null) {
/* 0079 */           grafoT.insereAresta (adj.v2 (), adj.v1 (), adj.peso ());
/* 0080 */           adj = this.proxAdj (v);
/* 0081 */         }
/* 0082 */       }
/* 0083 */     return grafoT;
/* 0084 */   }
/* 0085 */ }