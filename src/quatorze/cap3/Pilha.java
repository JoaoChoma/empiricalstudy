/* 0001 */ package quatorze.cap3;
/* 0002 */ public class Pilha {
/* 0003 */   private static class Celula {
/* 0004 */     Object item;
/* 0005 */     Celula prox;
/* 0006 */   }
/* 0007 */   private Celula topo;
/* 0008 */   private int tam;
/* 0009 */   // @{\it Opera\c{c}\~oes}@
/* 0010 */   public Pilha () { // @{\it Cria uma Pilha vazia}@
/* 0011 */     this.topo = null; this.tam = 0 /*(p1) inicialização e não atribuição*/;
/* 0012 */   }
/* 0013 */   public void empilha (Object x) {
/* 0014 */     Celula aux = this.topo;
/* 0015 */     this.topo = new Celula ();
/* 0016 */     this.topo.item = x;
/* 0017 */     this.topo.prox = aux;
/* 0018 */     this.tam++; /*(p4) 11*/
/* 0019 */   }
/* 0020 */   public Object desempilha () throws Exception {
/* 0021 */     if (this.vazia ())
/* 0022 */       throw new Exception ("Erro: A pilha esta vazia");
/* 0023 */     Object item = this.topo.item;
/* 0024 */     this.topo = this.topo.prox;    
/* 0025 */     this.tam--; /*(p4) 11*/
/* 0026 */     return item;
/* 0027 */   }
/* 0028 */   public boolean vazia () {
/* 0029 */     return (this.topo == null);
/* 0030 */   }
/* 0031 */   public int tamanho () {
/* 0032 */     return this.tam;
/* 0033 */   }
/* 0034 */ }