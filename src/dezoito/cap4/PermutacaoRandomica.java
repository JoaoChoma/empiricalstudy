/* 0001 */ package dezoito.cap4;
/* 0002 */ import java.util.Random;
/* 0003 */ public class PermutacaoRandomica {
/* 0004 */   public static double rand0a1 (Random rand) {
/* 0005 */     // @{\it utilizar o tempo como semente para o m\'etodo setSeed()}@
/* 0006 */     rand.setSeed (System.currentTimeMillis ());
/* 0007 */     // @{\it seleciona aleatoriamente um n\'umero no intervalo [0, 1)}@
/* 0008 */     return rand.nextDouble ();
/* 0009 */   }
/* 0010 */   public static void permut (Item v[], int n) {
/* 0011 */     Random rand = new Random ();
/* 0012 */     for (int i = n - 1; i > 0; i--) { /*(p2)*/ //19-26
/* 0013 */       int j = (int) (((double) i * rand0a1 (rand)) + 1.0);
/* 0014 */       Item b = v[i]; v[i] = v[j]; v[j] = b;
/* 0015 */     }
/* 0016 */   }
/* 0017 */   public static void permut (int v[], int n) {
/* 0018 */     Random rand = new Random ();
/* 0019 */     for (int i = n - 1; i > 0; i--) { /*(p2)*/ //12
/* 0020 */       int j = (int) (((double) i * rand0a1 (rand)) + 1.0);
/* 0021 */       int b = v[i]; v[i] = v[j]; v[j] = b;
/* 0022 */     }
/* 0023 */   }
/* 0024 */   public static void permut (char v[], int n) {
/* 0025 */     Random rand = new Random ();
/* 0026 */     for (int i = n - 1; i > 0; i--) { /*(p2)*/ // 12
/* 0027 */       int j = (int) (((double) i * rand0a1 (rand)) + 1.0);
/* 0028 */       char b = v[i]; v[i] = v[j]; v[j] = b;
/* 0029 */     }
/* 0030 */   }
/* 0031 */   public static void main (String[] args) {
/* 0032 */     int tam = 20, n =20; /*(p1)*/
/* 0033 */     MeuItem v[] = new MeuItem[tam + 1];
/* 0034 */     for (int i = 1; i <= n; i++) v[i] = new MeuItem (i); /*(p2)*/ // 36
/* 0035 */     permut (v, n); 
/* 0036 */     for (int i = 1; i <= n; i++) System.out.print (v[i].toString () + " "); /*(p2)*/ //34
/* 0037 */     System.out.println ();
/* 0038 */   }
/* 0039 */ }