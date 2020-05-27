/* 0001 */ package treze.cap3;
/* 0002 */ public class Pilha {
/* 0003 */   public Object item[];
/* 0004 */   public int topo;
/* 0005 */   // @{\it Opera\c{c}\~oes}@
/* 0006 */   public Pilha () { // @{\it Cria uma Pilha vazia}@
/* 0007 */     this.item = new Object[1000]; this.topo = 0 /* caso de inicialização e não atribuição*/;
/* 0008 */   }
/* 0009 */   public void empilha (Object x) throws Exception {//2
/* 0010 */     if (this.topo == this.item.length)
/* 0011 */       throw new Exception ("Erro: A pilha esta cheia");
/* 0012 */     else this.item[this.topo++] = x;  /*(P4) 7*/
/* 0013 */   }
/* 0014 */   public Object desempilha () throws Exception {//1
/* 0015 */     if (this.vazia())
/* 0016 */       throw new Exception ("Erro: A pilha esta vazia");    
/* 0017 */     return this.item[--this.topo]; /*(P4) 7*/
/* 0018 */   }
/* 0019 */   public boolean vazia () {//0
/* 0020 */     return (this.topo == 0);
/* 0021 */   }
/* 0022 */   public int tamanho () {
/* 0023 */     return this.topo;
/* 0024 */   } 
/* 0025 */ }
