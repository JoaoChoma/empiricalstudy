/* 0001 */ package cinco.cap1;
/* 0002 */ public class Ordenacao {
/* 0003 */   public static void ordena (int v[], int n) {
/* 0004 */     for (int i = 0; i < n - 1; i++) {
/* 0005 */       int min = i;
/* 0006 */       for (int j = i + 1; j < n; j++)
/* 0007 */         if (v[j] < v[min]) 
/* 0008 */           min = j; /*(P4) 5*/
/* 0009 */       /* @{\it Troca v[min] e v[i]}@ */
/* 0010 */       int x = v[min];
/* 0011 */       v[min] = v[i]; 
/* 0012 */       v[i] = x;
/* 0013 */     }
/* 0014 */   }
/* 0015 */ }