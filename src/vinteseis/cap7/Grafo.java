/* 0001 */ package vinteseis.cap7;
/* 0002 */ public class Grafo {
/* 0003 */   public static class Aresta {
/* 0004 */     private int v1, v2, peso;
/* 0005 */     public Aresta (int v1, int v2, int peso) {
/* 0006 */       this.v1 = v1; this.v2 = v2; this.peso = peso;
/* 0007 */     }
/* 0008 */     public int peso () { return this.peso; }
/* 0009 */     public int v1 () { return this.v1; }
/* 0010 */     public int v2 () { return this.v2; }
/* 0011 */   }
/* 0012 */   public int cab[], prox[], peso[];
/* 0013 */   private int pos[]; 
/* 0014 */   private int numVertices, proxDisponivel;
/* 0015 */   
/* 0016 */   public Grafo (int numVertices) {
/* 0017 */     int numArestas = 4500; /*(p1)*/
/* 0018 */     int tam = numVertices + 2*numArestas;
/* 0019 */     this.cab  = new int[tam]; this.prox = new int[tam];
/* 0020 */     this.peso = new int[tam]; this.numVertices = numVertices;
/* 0021 */     this.pos = new int[this.numVertices];
/* 0022 */     for (int i = 0; i < this.numVertices; i++) {
/* 0023 */       this.prox[i] = 0; this.cab[i] = i; 
/* 0024 */       this.peso[i] = 0; this.pos[i] = i; 
/* 0025 */     }
/* 0026 */     this.proxDisponivel = this.numVertices;
/* 0027 */   } 
/* 0028 */   /*public Grafo (int numVertices, int numArestas) {
/* 0029 */   /*  int tam = numVertices + 2*numArestas;
/* 0030 */   /*  this.cab  = new int[tam]; this.prox = new int[tam];
/* 0031 */   /*  this.peso = new int[tam]; this.numVertices = numVertices;
/* 0032 */   /*  this.pos = new int[this.numVertices];
/* 0033 */   /*  for (int i = 0; i < this.numVertices; i++) {
/* 0034 */   /*    this.prox[i] = 0; this.cab[i] = i; 
/* 0035 */   /*    this.peso[i] = 0; this.pos[i] = i; 
/* 0036 */   /*  }
/* 0037 */   /*  this.proxDisponivel = this.numVertices;
/* 0038 */   /*}*/
/* 0039 */   public void insereAresta (int v1, int v2, int peso) {
/* 0040 */     if (this.proxDisponivel == this.cab.length)
/* 0041 */       System.out.println ("Nao ha espaco disponivel para a aresta");
/* 0042 */     else {
/* 0043 */       int ind = this.proxDisponivel++; 
/* 0044 */       this.prox[this.cab[v1]] = ind; /*(p4)->19*/
/* 0045 */       this.cab[ind] = v2; this.cab[v1] = ind; /*(p4)->19*/
/* 0046 */       this.prox[ind] = 0; /*(p4)->23*/ this.peso[ind] = peso;  /*(p4)->24*/
/* 0047 */     }
/* 0048 */   } 
/* 0049 */   public boolean existeAresta (int v1, int v2) {
/* 0050 */     for (int i = this.prox[v1]; i != 0; i = this.prox[i])
/* 0051 */       if (this.cab[i] == v2) return true;
/* 0053 */		return false;   } //@\lstcontinue@
/* 0054 */  /*-- @{\it Operadores para obter a lista de adjacentes}@ --*/
/* 0055 */   public boolean listaAdjVazia (int v) {
/* 0056 */     return (this.prox[v] == 0); /*(p4)->19*/
/* 0057 */   }
/* 0058 */   public Aresta primeiroListaAdj (int v) {
/* 0059 */     // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@
/* 0060 */     // @{\it {\bf null} se a lista de adjac\^encia de v for vazia}@
/* 0061 */     this.pos[v] = v; /*(p4)->21*/
/* 0062 */     return this.proxAdj (v);
/* 0063 */   }
/* 0064 */   public Aresta proxAdj (int v) {
/* 0065 */     // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@
/* 0066 */     // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@
/* 0067 */     this.pos[v] = this.prox[this.pos[v]]; /*(p4)->21*/
/* 0068 */     if (this.pos[v] == 0) return null;
/* 0069 */     else return new Aresta (v,this.cab[pos[v]],this.peso[pos[v]]);     
/* 0070 */   }
/* 0071 */   public Aresta retiraAresta (int v1, int v2) {
/* 0072 */     int i;
/* 0073 */     for (i = v1; this.prox[i] != 0; i = this.prox[i])
/* 0074 */       if (this.cab[this.prox[i]] == v2) break;
/* 0075 */     int ind = this.prox[i];
/* 0076 */     if (this.cab[ind] == v2) {
/* 0077 */       Aresta aresta = new Aresta(v1, v2, this.peso[ind]);
/* 0078 */       this.cab[ind] = this.cab.length;
/* 0079 */       if (this.prox[ind] == 0) this.cab[v1] = i; 
/* 0080 */       this.prox[i] = this.prox[ind]; /*(p4)->19*/
/* 0081 */       return aresta;
/* 0082 */     } else return null;
/* 0083 */   }
/* 0084 */   public void imprime () {
/* 0085 */     for (int i = 0; i < this.numVertices; i++) { 
/* 0086 */       System.out.println ("Vertice " + i + ":");
/* 0087 */       for (int j = this.prox[i]; j != 0; j = this.prox[j])
/* 0088 */         System.out.println ("  " + this.cab[j]+" (" +this.peso[j]+ ")");
/* 0089 */     }
/* 0090 */   }
/* 0091 */   public int numVertices () { return this.numVertices; }
/* 0092 */   public Grafo grafoTransposto () {
/* 0093 */     Grafo grafoT = new Grafo (this.numVertices); 
/* 0094 */     for (int v = 0; v < this.numVertices; v++)
/* 0095 */       if (!this.listaAdjVazia (v)) {
/* 0096 */         Aresta adj = this.primeiroListaAdj (v);
/* 0097 */         while (adj != null) {
/* 0098 */           grafoT.insereAresta (adj.v2 (), adj.v1 (), adj.peso ());
/* 0099 */           adj = this.proxAdj (v); /*(p4)->96*/
/* 0100 */         }
/* 0101 */       }
/* 0102 */     return grafoT;
/* 0103 */   } 
/* 0104 */ }