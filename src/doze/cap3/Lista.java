/* 0001 */ package doze.cap3;
/* 0002 */ public class Lista {
/* 0003 */   private static class Celula { Object item; Celula prox; }
/* 0004 */  
/* 0005 */   private Celula primeiro, ultimo, pos;
/* 0006 */   // @{\it Opera\c{c}\~oes}@
/* 0007 */   public Lista () { // @{\it Cria uma Lista vazia}@
/* 0008 */     this.primeiro = new Celula (); this.pos = this.primeiro;
/* 0009 */     this.ultimo = this.primeiro; this.primeiro.prox = null;
/* 0010 */   }
/* 0011 */   public void insere (Object x) {
/* 0012 */     this.ultimo.prox = new Celula (); this.ultimo = this.ultimo.prox; /*(p4) ultimo 9*/
/* 0013 */     this.ultimo.item = x; this.ultimo.prox = null;
/* 0014 */   }
/* 0015 */   public boolean vazia () { return (this.primeiro == this.ultimo); } 
/* 0016 */   public void imprime () {
/* 0017 */     Celula aux = this.primeiro.prox;
/* 0018 */     while (aux != null) {
/* 0019 */       System.out.println (aux.item.toString ()); aux = aux.prox;
/* 0020 */     }
/* 0021 */   }
/* 0022 */ }