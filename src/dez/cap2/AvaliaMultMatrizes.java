/* 0001 */ package dez.cap2;
/* 0002 */ import java.io.*;
/* 0003 */ public class AvaliaMultMatrizes {
/* 0004 */  
/* 0005 */ 	public static void multmatrize (int n, int d[]) throws IOException {
/* 0006 */     int  maxn = n+1;
/* 0007 */ 
/* 0008 */     int m[][] = new int[maxn][maxn];
/* 0009 */   
/* 0010 */     for (int i = 0; i < n; i++)  m[i][i] = 0;
/* 0011 */     for (int h = 1; h < n; h++) { 
/* 0012 */       for (int i = 1; i <= n - h; i++) { 
/* 0013 */         int j = i + h;
/* 0014 */         m[i-1][j-1] = Integer.MAX_VALUE;
/* 0015 */         for (int k = i; k < j; k++) { 
/* 0016 */           int temp = m[i-1][k-1] + m[k][j-1] + d[i-1] * d[k] * d[j];
/* 0017 */           if (temp < m[i-1][j-1])  m[i-1][j-1] = temp;
/* 0018 */         }
/* 0019 */         System.out.print(" m[" +i+"]["+j+"]= "+ m[i-1][j-1]);
/* 0020 */       }
/* 0021 */       System.out.println();
/* 0022 */     }
/* 0023 */   }
/* 0024 */ }