/* 0001 */ package um.cap1;
/* 0002 */ public class Max { 
/* 0003 */   public static Item max (Item v[], int n) { 
/* 0004 */     Item max = v[0];
/* 0005 */     for (int i = 1; i < n; i++) 
/* 0006 */			if (max.compara (v[i]) < 0) max = v[i]; /*(p4) - 4*/
/* 0007 */     return max;
/* 0008 */   }
/* 0009 */ }