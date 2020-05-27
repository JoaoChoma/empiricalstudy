/* 0001 */ package seis.cap2;
/* 0002 */ public class Fibonacci {
/* 0003 */    public static int fibIter (int n) {
/* 0004 */     int i = 1, f = 0; /*(p1)*/ 
/* 0005 */     for (int k = 1; k <= n; k++) {
/* 0006 */       f = i + f; /*(P4) 4*/
/* 0007 */       i = f - i; /*(P4) 4*/
/* 0008 */     }
/* 0009 */     return f;
/* 0010 */   }
/* 0011 */ }