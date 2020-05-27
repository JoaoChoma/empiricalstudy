/* 0001 */ package tres.cap1;
/* 0002 */ public class MaxMin2 {
/* 0003 */   public static int [] maxMin2 (int v[], int n) {
/* 0004 */     int max = v[0], min = v[0]; 
/* 0005 */     for (int i = 1; i < n; i++) {
/* 0006 */       if (v[i] > max) max = v[i]; /*(p2)*/ /*(P4) 4*/
/* 0007 */       else if (v[i] < min) min = v[i]; /*(p2)*/ /*(P4) 4*/
/* 0008 */     }
/* 0009 */     int maxMin[] = new int[2];
/* 0010 */     maxMin[0] = max; maxMin[1] = min;
/* 0011 */     return maxMin;
/* 0012 */   }
/* 0013 */   
/* 0014 */ }