/* 0001 */ package vintedois.cap5.listaenc;
/* 0002 */ import vintedois.cap3.autoreferencia.Lista;
/* 0003 */ public class TabelaHash {
/* 0004 */   private static class Celula {
/* 0005 */     String chave;
/* 0006 */     Object item;
/* 0007 */     public Celula (String chave, Object item) {
/* 0008 */       this.chave = chave; this.item = item;
/* 0009 */     }
/* 0010 */     public boolean equals (Object obj) {
/* 0011 */       Celula cel = (Celula)obj;
/* 0012 */       return chave.equals (cel.chave);
/* 0013 */     }
/* 0014 */     public String toString () {
/* 0015 */       return "  " + item.toString ();
/* 0016 */     }
/* 0017 */   }
/* 0018 */   
/* 0019 */   private int M; // @{\it tamanho da tabela}@
/* 0020 */   private Lista tabela[];
/* 0021 */   private int pesos[];
/* 0022 */ 
/* 0023 */ private int[] geraPesos (int n) {
/* 0024 */   int p[] = new int[n];
/* 0025 */   java.util.Random rand = new java.util.Random ();
/* 0026 */   for (int i = 0; i < n; i++) p[i] = rand.nextInt(M) + 1;
/* 0027 */   return p;
/* 0028 */ }
/* 0029 */ 
/* 0030 */   private int h (String chave, int[] pesos) {
/* 0031 */     int soma = 0; /*(p1) falso inicialização*/ 
/* 0032 */     for (int i = 0; i < chave.length(); i++) 
/* 0033 */       soma = soma + ((int)chave.charAt (i)) * pesos[i]; 
/* 0034 */     return soma % this.M;
/* 0035 */   }
/* 0036 */   
/* 0037 */   public TabelaHash () {//modificado para valor de M e maxTamChave fixo = 7
/* 0038 */ 	int m = 7; /*(p1)*/
/* 0039 */ 	int maxTamChave = 7; /*(p1)*/
/* 0040 */     this.M = m; this.tabela = new Lista[this.M];
/* 0041 */     for (int i = 0; i < this.M; i++) this.tabela[i] = new Lista ();
/* 0042 */     this.pesos = this.geraPesos (maxTamChave);
/* 0043 */   }  
/* 0044 */    
/* 0045 */   public Object pesquisa (String chave) {
/* 0046 */     int i = this.h (chave, this.pesos);
/* 0047 */     if (this.tabela[i].vazia()) return null; /*(p2) -> 71*/
/* 0048 */     else {
/* 0049 */       Celula cel=(Celula)this.tabela[i].pesquisa(new Celula(chave,null));
/* 0050 */       if (cel == null) return null; /*(p2)*/ // 66
/* 0051 */       else return cel.item;
/* 0052 */     }
/* 0053 */   }
/* 0054 */   
/* 0055 */   public void insere (String chave, Object item) {
/* 0056 */     if (this.pesquisa (chave) == null) {
/* 0057 */       int i = this.h (chave, this.pesos);
/* 0058 */       this.tabela[i].insere (new Celula (chave, item));
/* 0059 */     }
/* 0060 */     else System.out.println ("Registro ja esta presente");    
/* 0061 */   }
/* 0062 */   
/* 0063 */   public void retira (String chave) throws Exception {
/* 0064 */     int i = this.h (chave, this.pesos);
/* 0065 */     Celula cel = (Celula)this.tabela[i].retira (new Celula (chave,null));
/* 0066 */     if (cel == null) System.out.println ("Registro nao esta presente"); /*(p2)*/ // 50
/* 0067 */   }
/* 0068 */   
/* 0069 */   public void imprime () {
/* 0070 */     for (int i = 0; i < this.M; i++) {
/* 0071 */       if (!this.tabela[i].vazia ()) { /*(p2) -> 47*/
/* 0072 */         System.out.println ("Entrada: " + i); 
/* 0073 */         this.tabela[i].imprime ();
/* 0074 */       }
/* 0075 */     }
/* 0076 */   }
/* 0077 */ }