/* 0001 */ package trintadois.cap8;
/* 0002 */ public class CasamentoAproximado {
/* 0003 */   private static final int maxChar = 256; /*(p1)*/
/* 0004 */   public static void shiftAndAproximado (String T,int n,String P,int m, int k) {
/* 0005 */     // @{\it Pr\'e-processamento do padr\~ao}@
/* 0006 */     int R[] = new int[k+1];
/* 0007 */     int M[] = new int[maxChar];
/* 0008 */     for (int i = 0; i < maxChar; i++) M[i] = 0;
/* 0009 */     for (int j = 0; j < m; j++) 
/* 0010 */       M[(int)P.charAt (j)] = M[(int)P.charAt (j)] | (1 << (m-j-1));
/* 0011 */     // @{\it Pesquisa}@
/* 0012 */     int Ri =  1 << (m-1); R[0] = 0;
/* 0013 */     for (int j = 1; j <= k; j++) R[j] = (1 << (m-j)) | R[j-1]; /*(p4)->13*/
/* 0014 */     for (int i = 0; i < n; i++) {
/* 0015 */       int Rant = R[0];
/* 0016 */       int RNovo = ((Rant >> 1) | Ri) & M[(int)T.charAt (i)];
/* 0017 */       R[0] = RNovo;
/* 0018 */       for (int j = 1; j <= k; j++) {
/* 0019 */        /*(p4) -> 16*/ RNovo = ((R[j] >> 1) & M[(int)T.charAt (i)]) | Rant | 
/* 0020 */                 ((Rant | RNovo) >> 1);
/* 0021 */         Rant = R[j]; /*(p4) -> 15*/
/* 0022 */         R[j] = RNovo | Ri; /*(p4) -> 22*/
/* 0023 */       }      
/* 0024 */       if ((RNovo & 1) != 0) 
/* 0025 */         System.out.println ("Casamento na posicao: " + T.charAt(i));
/* 0026 */     }
/* 0027 */   }
/* 0028 */ }