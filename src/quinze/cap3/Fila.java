/* 0001 */ package quinze.cap3;
/* 0002 */ public class Fila {
/* 0003 */   public Object item[];
/* 0004 */   public int frente, tras;
/* 0005 */   // @{\it Opera\c{c}\~oes}@
/* 0006 */   public Fila () { // @{\it Cria uma Fila vazia}@
/* 0007 */     this.item = new Object[1000];
/* 0008 */     this.frente = 0; /* não é (p1) pois é inicialização de variável*/
/* 0009 */     this.tras = this.frente;
/* 0010 */   }
/* 0011 */   public void enfileira (Object x) throws Exception {
/* 0012 */     if ((this.tras + 1) % this.item.length == this.frente)
/* 0013 */       throw new Exception ("Erro: A fila esta cheia");
/* 0014 */     this.item[this.tras] = x;
/* 0015 */     this.tras = (this.tras + 1) % this.item.length;  /* (P4) 9*/
/* 0016 */   }
/* 0017 */   public Object desenfileira () throws Exception {
/* 0018 */     if (this.vazia ())
/* 0019 */       throw new Exception ("Erro: A fila esta vazia");
/* 0020 */     Object item = this.item[this.frente];
/* 0021 */     this.frente = (this.frente + 1) % this.item.length;  /* (P4) 8*/
/* 0022 */     return item;
/* 0023 */   }
/* 0024 */   public boolean vazia () {
/* 0025 */     return (this.frente == this.tras);
/* 0026 */   }
/* 0027 */ }