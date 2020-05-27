/* 0001 */ package dezenove.cap4.ordenacaointerna;
/* 0002 */ import dezenove.cap4.Item;
/* 0003 */ 
/* 0004 */ public class OrdenacaoParcial {
/* 0005 */   private static class LimiteParticoes { int i; int j; }
/* 0006 */   private static LimiteParticoes particao (Item v[], int esq, int dir) {
/* 0007 */     LimiteParticoes p = new LimiteParticoes ();
/* 0008 */     p.i = esq; p.j = dir;
/* 0009 */     Item x = v[(p.i + p.j) / 2];
/* 0010 */     do {
/* 0011 */       while (x.compara (v[p.i]) > 0) p.i++; /*(p2) (p4)->8*/
/* 0012 */       while (x.compara (v[p.j]) < 0) p.j--; /*(p2) (p4)->8*/
/* 0013 */       if (p.i <= p.j) { /*(p3) -> 17*/
/* 0014 */         Item w = v[p.i]; v[p.i] = v[p.j]; v[p.j] = w; /*(p4)-> "v[]" -> 6*/
/* 0015 */         p.i++; p.j--; /*(p4) ->8*/
/* 0016 */       }
/* 0017 */     } while (p.i <= p.j); /*(p3) -> 13*/
/* 0018 */     return p;
/* 0019 */   }
/* 0020 */   private static void ordena (Item v[], int esq, int dir, int k) {
/* 0021 */     LimiteParticoes p = particao (v, esq, dir);
/* 0022 */     if (p.j - esq >= k - 1) { /*(p3) -> 23*/
/* 0023 */       if (esq < p.j) ordena (v, esq, p.j, k); /*(p3) -> 22*/
/* 0024 */       return;
/* 0025 */     }
/* 0026 */     if (esq < p.j) ordena (v, esq, p.j, k);
/* 0027 */     if (p.i < dir) ordena (v, p.i, dir, k);
/* 0028 */   }
/* 0029 */   public static void selecaoParcial (Item v[], int n, int k) {
/* 0030 */     for (int i = 1; i <= k; i++) {
/* 0031 */       int min = i;
/* 0032 */       for (int j = i + 1; j <= n; j++)
/* 0033 */         if (v[j].compara (v[min]) < 0) min = j; /*(p4)->31*/
/* 0034 */       Item x = v[min]; v[min] = v[i]; v[i] = x;
/* 0035 */     }
/* 0036 */   }
/* 0037 */   public static void insercaoParcial (Item v[], int n, int k) {
/* 0038 */     int j;
/* 0039 */     for (int i = 2; i <= n; i++) {
/* 0040 */       Item x = v[i];
/* 0041 */       if (i > k) j = k; else j = i - 1;
/* 0042 */       v[0] = x; 
/* 0043 */       while (x.compara (v[j]) < 0) {
/* 0044 */         v[j + 1] = v[j]; j--; /*(p4)->41*/ /*(p4)->37*/ 
/* 0045 */       }
/* 0046 */       v[j + 1] = x; /*(p4)->37*/
/* 0047 */     }
/* 0048 */   }
/* 0049 */   public static void insercaoParcial2 (Item v[], int n, int k) { 
/* 0050 */     int j;
/* 0051 */     for (int i = 2; i <= n; i++) {
/* 0052 */       Item x = v[i];
/* 0053 */       if (i > k) { 
/* 0054 */         j = k; 
/* 0055 */         if (x.compara (v[k]) < 0) v[i] = v[k]; /*(p4)->49*/
/* 0056 */       }
/* 0057 */       else j = i - 1;
/* 0058 */       v[0] = x;
/* 0059 */       while (x.compara (v[j]) < 0) {
/* 0060 */         if (j < k) v[j + 1] = v[j]; /*(p2) -> 63*/ /*(p4)->49*/
/* 0061 */         j--; 
/* 0062 */       }
/* 0063 */       if (j < k) v[j + 1] = x; /*(p2) -> 60*/ /*(p4)->49*/
/* 0064 */     }
/* 0065 */   }
/* 0066 */   public static void quicksortParcial (Item v[], int n, int k) {
/* 0067 */     ordena (v, 1, n, k);
/* 0068 */   }
/* 0069 */   public static void heapsortParcial (Item v[], int n, int k) {
/* 0070 */     // @{\it Coloca menor em v[n], segundo em v[n-1],...,k-esimo em v[n-k]}@
/* 0071 */     FPHeapMin fpHeap = new FPHeapMin (v);
/* 0072 */     int dir = n, aux = 0;
/* 0073 */     fpHeap.constroi (); // @{\it constroi o heap}@
/* 0074 */     while (aux < k) { // @{\it ordena o vetor}@
/* 0075 */       Item x = v[1]; v[1] = v[dir]; v[dir] = x; /*(p4)->69*/
/* 0076 */       dir--; aux++; /*(p4)->72*/
/* 0077 */       fpHeap.refaz (1, dir);
/* 0078 */     }
/* 0079 */   }
/* 0080 */ }