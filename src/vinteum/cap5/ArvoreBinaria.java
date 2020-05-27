/* 0001 */ package vinteum.cap5;
/* 0002 */ import vinteum.cap4.Item; // @{\it vide Programa~\ref{prog:interfaceitem}}@
/* 0003 */ public class ArvoreBinaria {
/* 0004 */   private static class No { 
/* 0005 */     Item reg; 
/* 0006 */     No esq, dir; 
/* 0007 */   }
/* 0008 */   private No raiz;
/* 0009 */   private void central (No p) {
/* 0010 */     if (p != null) { /*(p2) -> 17, 24, 39, 68*/
/* 0011 */       central (p.esq);
/* 0012 */       System.out.println (p.reg.toString());
/* 0013 */       central (p.dir);
/* 0014 */     }
/* 0015 */   }
/* 0016 */   private Item pesquisa (Item reg, No p) {//
/* 0017 */     if (p == null) return null; // @{\it Registro n\~ao econtrado}@ /*(p2) -> 10*/
/* 0018 */     else if (reg.compara (p.reg) < 0) return pesquisa (reg, p.esq); /*(p2)*/
/* 0019 */     else if (reg.compara (p.reg) > 0) return pesquisa (reg, p.dir); /*(p2)*/
/* 0020 */     else return p.reg;
/* 0021 */   }
/* 0022 */   
/* 0023 */   private No insere (Item reg, No p) {//
/* 0024 */     if (p == null) { /*(p2) -> 10*/
/* 0025 */       p = new No (); p.reg = reg; 
/* 0026 */       p.esq = null; p.dir = null;
/* 0027 */     } 
/* 0028 */     else if (reg.compara (p.reg) < 0) p.esq = insere (reg, p.esq); /*(p2)*/ /*(p4) -> 23 or 25*/ 
/* 0029 */     else if (reg.compara (p.reg) > 0) p.dir = insere (reg, p.dir); /*(p2)*/ /*(p4) -> 23 or 25*/
/* 0030 */     else System.out.println ("Erro: Registro ja existente");
/* 0031 */     return p; 
/* 0032 */   }
/* 0033 */   private No antecessor (No q, No r) {
/* 0034 */     if (r.dir != null) r.dir = antecessor (q, r.dir);
/* 0035 */     else { q.reg = r.reg; r = r.esq; }
/* 0036 */     return r;
/* 0037 */   }
/* 0038 */   private No retira (Item reg, No p) {
/* 0039 */     if (p == null) System.out.println ("Erro: Registro nao encontrado"); /*(p2) -> 10*/
/* 0040 */     else if (reg.compara (p.reg) < 0) p.esq = retira (reg, p.esq); /*(p2)*/ /*(p4) -> 38*/
/* 0041 */     else if (reg.compara (p.reg) > 0) p.dir = retira (reg, p.dir); /*(p2)*/ /*(p4) -> 38*/
/* 0042 */     else {
/* 0043 */       if (p.dir == null) p = p.esq; /*(p4) -> 38*/
/* 0044 */       else if (p.esq == null) p = p.dir; /*(p4) -> 38*/
/* 0045 */       else p.esq = antecessor (p, p.esq); /*(p4) -> 38*/
/* 0046 */     }
/* 0047 */     return p; 
/* 0048 */   }
/* 0049 */ 
/* 0050 */   public ArvoreBinaria () {//
/* 0051 */     this.raiz = null;
/* 0052 */   }
/* 0053 */   
/* 0054 */   public Item pesquisa (Item reg) {
/* 0055 */     return this.pesquisa (reg, this.raiz);
/* 0056 */   }
/* 0057 */ 
/* 0058 */   public void insere (Item reg) {
/* 0059 */     this.raiz = this.insere (reg, this.raiz);
/* 0060 */   }
/* 0061 */ 
/* 0062 */   public void retira (Item reg) {
/* 0063 */     this.raiz = this.retira (reg, this.raiz);
/* 0064 */   }
/* 0065 */   
/* 0066 */   // @{\it M\'etodo para testar o funcionamento da classe}@
/* 0067 */   private void testa (No p) { 
/* 0068 */     if (p == null) return; /*(p2) -> 10*/		
/* 0069 */     if (p.esq != null) { 
/* 0070 */       if (p.reg.compara (p.esq.reg) < 0) { 
/* 0071 */         System.out.println ("Erro: Pai " + p.reg.toString() + " menor que filho a esquerda " + p.esq.reg.toString());
/* 0072 */         System.exit(1);
/* 0073 */       }
/* 0074 */     }
/* 0075 */     if (p.dir != null) { 
/* 0076 */       if (p.reg.compara (p.dir.reg) > 0 ) { 
/* 0077 */         System.out.println ("Erro: Pai " + p.reg.toString() + " maior que filho a direita " + p.dir.reg.toString());
/* 0078 */         System.exit(1);
/* 0079 */       }
/* 0080 */     }
/* 0081 */     testa(p.esq);
/* 0082 */     testa(p.dir);
/* 0083 */   }
/* 0084 */   public void testa () { 
/* 0085 */     this.testa (this.raiz);
/* 0086 */   }
/* 0087 */ 
/* 0088 */ }