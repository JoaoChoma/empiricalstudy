/* 0001 */ package trintadois.cap8;
/* 0002 */ public class CasamentoExato {
/* 0003 */   private static final int maxChar = 256; /*(p1)*/
/* 0004 */   public static void forcaBruta (String T, int n, String P, int m) {
/* 0005 */     // @{\it Pesquisa P[0..m-1] em T[0..n-1]}@
/* 0006 */     for (int i = 0; i < (n - m + 1); i ++) {
/* 0007 */       int k = i; int j = 0; /*(p1)*/
/* 0008 */       while ((j < m) && (T.charAt (k) == P.charAt (j))) { j++; k++; } /*(p3)*/
/* 0009 */       if (j == m) System.out.println ("Casamento na posicao: " + i); /*(p3)*/
/* 0010 */     }
/* 0011 */   }
/* 0012 */   public static void shiftAndExato (String T, int n, String P, int m) {
/* 0013 */     int R = 0; /*(p1)*/
/* 0014 */     // @{\it Pr\'e-processamento do padr\~ao}@
/* 0015 */     int M[] = new int[maxChar];
/* 0016 */     for (int i = 0; i < maxChar; i++) M[i] = 0; /*(p1)*/
/* 0017 */     for (int j = 0; j < m; j++) 
/* 0018 */       M[(int)P.charAt (j)] = M[(int)P.charAt (j)] | (1 << (m - j - 1));
/* 0019 */     // @{\it Pesquisa}@
/* 0020 */     for (int i = 0; i < n; i++) {
/* 0021 */       R = ((R >> 1) | (1 << (m - 1))) & M[(int)T.charAt (i)]; /*(p4)->13*/
/* 0022 */       if ((R & 1) != 0) 
/* 0023 */         System.out.println ("Casamento na posicao: " + (i - m + 1));
/* 0024 */     }
/* 0025 */   }
				// void bmh == void bmhs
/* 0026 */   public static void bmh (String T, int n, String P, int m) {
/* 0027 */     // @{\it Pr\'e-processamento do padr\~ao}@
/* 0028 */     int d[] = new int[maxChar];
/* 0029 */     for (int j = 0; j < maxChar; j++) d[j] = m;
/* 0030 */     for (int j = 0; j < (m-1); j++) d[(int)P.charAt (j)] = m - j - 1;
/* 0031 */     int i = m - 1;
/* 0032 */     while (i < n) {  /*(p3)*/ //35
/* 0033 */       int k = i; int j = m - 1;
/* 0034 */       while ((j >= 0) && (T.charAt (k) == P.charAt (j))) { j--; k--; } /*(p3)*/
/* 0035 */       if (j < 0) /*(p3)*/ //34
/* 0036 */         System.out.println ("Casamento na posicao: " + (k + 1));
/* 0037 */       i = i + d[(int)T.charAt (i)]; /*(p4)->31*/
/* 0038 */     }
/* 0039 */   }
				//void bmh == void bmhs
/* 0040 */   public static void bmhs (String T, int n, String P, int m) {
/* 0041 */     // @{\it Pr\'e-processamento do padr\~ao}@
/* 0042 */     int d[] = new int[maxChar];
/* 0043 */     for (int j = 0; j < maxChar; j++) d[j] = m + 1;
/* 0044 */     for (int j = 0; j < m; j++) d[(int)P.charAt (j)] = m - j;
/* 0045 */     int i = m - 1;
/* 0046 */     while (i < n) { /*(p3)*/ //49
/* 0047 */       int k = i; int j = m - 1;
/* 0048 */       while ((j >= 0) && (T.charAt (k) == P.charAt (j))) { j--; k--; } /*(p3)*/
/* 0049 */       if (j < 0) /*(p3)*/ //48
/* 0050 */         System.out.println ("Casamento na posicao: " + (k + 1));
/* 0051 */       i += i != (n-1) ? d[(int)T.charAt (i+1)] : 1; /*(p4)->45*/
/* 0052 */     }    
/* 0053 */   }
/* 0054 */ }