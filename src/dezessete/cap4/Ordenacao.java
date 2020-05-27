/* 0001 */ package dezessete.cap4;
/* 0002 */ public class Ordenacao {
/* 0003 */   private static class LimiteParticoes { int i; int j; }
/* 0004 */   private static LimiteParticoes particao (Item v[], int esq, int dir) {
/* 0005 */     LimiteParticoes p = new LimiteParticoes ();
/* 0006 */     p.i = esq;  p.j = dir;
/* 0007 */     Item x = v[(p.i + p.j) / 2]; 
/* 0008 */     do {
/* 0009 */       while (x.compara (v[p.i]) > 0) p.i++; /*(p2)*/ /* (P4) 6*/
/* 0010 */       while (x.compara (v[p.j]) < 0) p.j--; /*(p2)*/ /* (P4) 6*/
/* 0011 */       if (p.i <= p.j) {    /*(p3)*/ //15
/* 0012 */         Item w = v[p.i]; v[p.i] = v[p.j]; v[p.j] = w;
/* 0013 */         p.i++; p.j--; /* (P4) 6*/
/* 0014 */       }
/* 0015 */     } while (p.i <= p.j); /*(p3)*/
/* 0016 */     return p;
/* 0017 */   }
/* 0018 */   private static void ordena (Item v[], int esq, int dir) {
/* 0019 */     LimiteParticoes p = particao (v, esq, dir);
/* 0020 */     if (esq < p.j) ordena (v, esq, p.j);
/* 0021 */     if (p.i < dir) ordena (v, p.i, dir);
/* 0022 */   }
/* 0023 */   public static void selecao (Item v[], int n) {
/* 0024 */     for (int i = 1; i <= n - 1; i++) {
/* 0025 */       int min = i;
/* 0026 */       for (int j = i + 1; j <= n; j++)
/* 0027 */         if (v[j].compara (v[min]) < 0) min = j; /* (P4) 25*/
/* 0028 */       Item x = v[min]; v[min] = v[i]; v[i] = x;
/* 0029 */     }
/* 0030 */   }
/* 0031 */   public static void insercao (Item v[], int n) {
/* 0032 */     int j;
/* 0033 */     for (int i = 2; i <= n; i++) { /*(p4) 34 i é alterado*/
/* 0034 */       Item x = v[i]; j = i - 1; 
/* 0035 */       v[0] = x; // @{\it sentinela}@
/* 0036 */       while (x.compara (v[j]) < 0) {
/* 0037 */         v[j + 1] = v[j]; j--; /* (P4) 34*/
/* 0038 */       }
/* 0039 */       v[j + 1] = x;
/* 0040 */     }
/* 0041 */   }
/* 0042 */ 
/* 0043 */   public static void shellsort (Item v[], int n) {
/* 0044 */     int h = 1; /*não é (p1) pois inicializa a variável*/
/* 0045 */     do h = h * 3 + 1; while (h < n);
/* 0046 */     do {
/* 0047 */       h /= 3; /* (P4) 44*/
/* 0048 */       for (int i = h + 1; i <= n; i++) {
/* 0049 */         Item x = v[i]; int j = i;
/* 0050 */         while (v[j - h].compara (x) > 0) {
/* 0051 */           v[j] = v[j - h]; j -= h; /* (P4) 49*/
/* 0052 */           if (j <= h) break;
/* 0053 */         }
/* 0054 */         v[j] = x;
/* 0055 */       }
/* 0056 */     } while (h != 1);
/* 0057 */   }
/* 0058 */ 
/* 0059 */   public static void quicksort (Item v[], int n) { ordena (v, 1, n); }
/* 0060 */ 
/* 0061 */   public static void heapsort (Item v[], int n) {
/* 0062 */     // @{\it Usa a classe FPHeapMax do Programa~\ref{prog:fpheap}}@
/* 0063 */     FPHeapMax fpHeap = new FPHeapMax (v);
/* 0064 */     int dir = n;
/* 0065 */     fpHeap.constroi (); // @{\it constroi o heap}@
/* 0066 */     while (dir > 1) { // @{\it ordena o vetor}@
/* 0067 */       Item x = v[1]; v[1] = v[dir]; v[dir] = x;
/* 0068 */       dir--; fpHeap.refaz (1, dir); /* (P4) 64*/
/* 0069 */     }
/* 0070 */   }
/* 0071 */ }