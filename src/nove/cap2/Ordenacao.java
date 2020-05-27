/* 0001 */ package nove.cap2;
/* 0002 */ public class Ordenacao {
/* 0003 */   private static void merge (int v[], int i, int m, int j) {
/* 0004 */     int temp[] = new int [m-i+1];
/* 0005 */     int k;
/* 0006 */     for (k = i; k <= m; k++) temp[k-i] = v[k];
/* 0007 */     int esq = 0 /*(p1)*/, dir = m + 1; 
/* 0008 */     k = m-i+1;
/* 0009 */     while (esq < k && dir <= j) { /*(p3) 13*/
/* 0010 */       if (temp[esq] <= v[dir]) v[i++] = temp[esq++];  /*(P4) 7*/
/* 0011 */       else v[i++] = v[dir++];  /*(P4) 7*/
/* 0012 */     }   
/* 0013 */     while (esq < k) v[i++] = temp[esq++]; /*(p3) 9*/ /*(P4) 7*/
/* 0014 */   }
/* 0015 */   public static void mergeSort (int v[], int i, int j) {
/* 0016 */     if (i < j) {
/* 0017 */       int m = (i + j)/2;
/* 0018 */       mergeSort (v, i, m);
/* 0019 */       mergeSort (v, m + 1, j);
/* 0020 */       merge (v, i, m, j);  
/* 0021 */     }
/* 0022 */   }
/* 0023 */ }