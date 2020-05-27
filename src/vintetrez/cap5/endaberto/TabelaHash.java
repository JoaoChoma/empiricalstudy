/* 0001 */ package vintetrez.cap5.endaberto;
/* 0002 */ public class TabelaHash {
/* 0003 */   private static class Celula {
/* 0004 */     String chave; Object item; boolean retirado;
/* 0005 */     public Celula (String chave, Object item) {
/* 0006 */       this.chave = chave; this.item = item;
/* 0007 */       this.retirado = false;
/* 0008 */     }
/* 0009 */     public boolean equals (Object obj) {
/* 0010 */       Celula cel = (Celula)obj;
/* 0011 */       return chave.equals (cel.chave);
/* 0012 */     }
/* 0013 */     public String toString () {
/* 0014 */       return "  " + item.toString ();
/* 0015 */     }
/* 0016 */   }
/* 0017 */   private int M; 
/* 0018 */   private Celula tabela[];
/* 0019 */   private int pesos[];
/* 0020 */ 
/* 0021 */   private int[] geraPesos (int n) {
/* 0022 */     int p[] = new int[n];
/* 0023 */     java.util.Random rand = new java.util.Random ();
/* 0024 */     for (int i = 0; i < n; i++) p[i] = rand.nextInt(M) + 1;
/* 0025 */     return p;
/* 0026 */   }
/* 0027 */ 
/* 0028 */   private int h (String chave, int[] pesos) {
/* 0029 */     int soma = 0; /*(p1)*/
/* 0030 */     for (int i = 0; i < chave.length(); i++) 
/* 0031 */       soma = soma + ((int)chave.charAt (i)) * pesos[i]; 
/* 0032 */     return soma % this.M;
/* 0033 */   }
/* 0034 */   
/* 0035 */   public TabelaHash () {
/* 0036 */ 	  int m=7; /*(p1)*/
/* 0037 */ 	  int maxTamChave=11; /*(p1)*/
/* 0038 */     this.M = m; this.tabela = new Celula[this.M];
/* 0039 */     for (int i = 0; i < this.M; i++) this.tabela[i] = null;
/* 0040 */     this.pesos = this.geraPesos (maxTamChave);
/* 0041 */   }  
/* 0042 */    
/* 0043 */   private int pesquisaIndice (String chave) {
/* 0044 */     int inicial = this.h (chave, this.pesos);
/* 0045 */     int indice = inicial; int i = 0; /*(p1)*/
/* 0046 */    /*(p4) -> 39 tabela*/ while (this.tabela[indice] != null /*(p2) (p3)*/ && /* 0047 */ !chave.equals (this.tabela[indice].chave) /*(p2)*/ && /* 0048 */i < this.M)  indice = (inicial + (++i)) % this.M; /*(p4) -> 45*/
/* 0049 */     if (this.tabela[indice] != null /*(p2) (p3)*/ && /* 0050 */ chave.equals (this.tabela[indice].chave) /*(p2)*/) return indice;
/* 0051 */     else return this.M;
/* 0052 */   }
/* 0053 */   
/* 0054 */   public Object pesquisa (String chave) {
/* 0055 */     int indice = this.pesquisaIndice (chave);
/* 0056 */     if (indice < this.M) return this.tabela[indice].item;
/* 0057 */     else return null;  
/* 0058 */   }
/* 0059 */   
/* 0060 */   public void insere (String chave, Object item) {
/* 0061 */     if (this.pesquisa (chave) == null) {
/* 0062 */       int inicial = this.h (chave, this.pesos);
/* 0063 */       int indice = inicial; int i = 0;
/* 0064 */       while (this.tabela[indice] != null && /* 0065 */ !this.tabela[indice].retirado && /* 0066 */ i < this.M) indice = (inicial + (++i)) % this.M; /*(p4) -> 63*/
/* 0067 */       if (i < this.M) this.tabela[indice] = new Celula (chave, item);
/* 0068 */       else System.out.println ("Tabela cheia");      
/* 0069 */     } else System.out.println ("Registro ja esta presente");    
/* 0070 */   }
/* 0071 */   
/* 0072 */   public void retira (String chave) throws Exception {
/* 0073 */     int i = this.pesquisaIndice (chave);
/* 0074 */     if (i < this.M) {
/* 0075 */       this.tabela[i].retirado = true; this.tabela[i].chave = null;
/* 0076 */     } else System.out.println ("Registro nao esta presente");
/* 0077 */   }
/* 0078 */    
/* 0079 */   public Object[] recuperaItens () {
/* 0080 */     int n = 0; /*(p1)*/
/* 0081 */     for (int i = 0; i < this.M; i++)
/* 0082 */       if (this.tabela[i] != null && !this.tabela[i].retirado) n++; /*(p2)*/ //91
/* 0083 */     Object itens[] = new Object[n]; n = 0; /*(p1)*/
/* 0084 */     for (int i = 0; i < this.M; i++)
/* 0085 */       if (this.tabela[i] != null && !this.tabela[i].retirado) 
/* 0086 */         itens[n++] = this.tabela[i].item;   
/* 0087 */     return itens;
/* 0088 */   }
/* 0089 */   public void imprime () {
/* 0090 */     for (int i = 0; i < this.M; i++) {
/* 0091 */       if (this.tabela[i] != null && !this.tabela[i].retirado) { /*(p2)*/ //82
/* 0092 */         System.out.println ("Entrada["+i+"]:" + this.tabela[i]); 
/* 0093 */       }
/* 0094 */     }
/* 0095 */   }
/* 0096 */ }