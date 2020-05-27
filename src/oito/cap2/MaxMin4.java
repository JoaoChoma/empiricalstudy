/* 0001 */ package oito.cap2;
/* 0002 */ public class MaxMin4 {
/* 0003 */   public static int [] maxMin4 (int v[], int linf, int lsup) {
/* 0004 */     int maxMin[] = new int[2];
/* 0005 */     if (lsup - linf <= 1) { /*(p3) 6*/
/* 0006 */       if (v[linf] < v[lsup]) { maxMin[0] = v[lsup]; maxMin[1] = v[linf]; } /*(p3) 5*/
/* 0007 */       else { maxMin[0] = v[linf]; maxMin[1] = v[lsup]; }
/* 0008 */     }
/* 0009 */     else {
/* 0010 */       int meio = (linf + lsup)/2;
/* 0011 */       maxMin = maxMin4 (v, linf, meio);
/* 0012 */       int max1 = maxMin[0], min1 = maxMin[1];
/* 0013 */       maxMin = maxMin4 (v, meio + 1, lsup);
/* 0014 */       int max2 = maxMin[0], min2 = maxMin[1];
/* 0015 */       if (max1 > max2) maxMin[0] = max1; else maxMin[0] = max2; /*(p2)*/  /*(p4) 6-7*/
/* 0016 */       if (min1 < min2) maxMin[1] = min1; else maxMin[1] = min2; /*(p2)*/  /*(p4) 6-7*/
/* 0017 */     }
/* 0018 */     return maxMin;
/* 0019 */   }
/* 0020 */ }