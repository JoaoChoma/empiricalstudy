/* 0001 */ package quatro.cap1;
/* 0002 */ public class MaxMin3 {
/* 0003 */   public static int [] maxMin3 (int v[], int n) {
/* 0004 */     int max, min, FimDoAnel;
/* 0005 */     if ((n % 2) > 0) { v[n] = v[n-1]; FimDoAnel = n;} 
/* 0006 */     else FimDoAnel = n-1; 
/* 0007 */     if (v[0] > v[1]) { max = v[0];  min = v[1];} 
/* 0008 */     else { max = v[1]; min = v[0];}
/* 0009 */     int i = 2; /*(p1)*/
/* 0010 */     while (i < FimDoAnel) { 
/* 0011 */       if (v[i] > v[i+1]) { /*(p2) -> 7*/
/* 0012 */         if (v[i] > max) max = v[i]; /*(p2) -> 17 */     /*(P4) 7*/
/* 0013 */         if (v[i+1] < min) min = v[i+1]; /*(p2) -> 16 */   /*(P4) 7*/
/* 0014 */       }
/* 0015 */       else {
/* 0016 */         if (v[i] < min) min = v[i]; /*(p2) -> 13 */     /*(P4) 7*/
/* 0017 */         if (v[i+1] > max) max = v[i+1]; /*(p2) -> 12 */    /*(P4) 7*/
/* 0018 */       }
/* 0019 */       i = i + 2; /*(p4) 9*/
/* 0020 */     }    
/* 0021 */     int maxMin[] = new int[2];
/* 0022 */     maxMin[0] = max; maxMin[1] = min;
/* 0023 */     return maxMin;
/* 0024 */   }
/* 0025 */ }