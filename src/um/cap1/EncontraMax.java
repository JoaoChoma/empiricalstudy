/* 0001*/ package um.cap1;
/* 0002 */ public class EncontraMax {  
/* 0003 */ 	public static void main (String[] args) {
/* 0004 */ 		MeuItem itens[] = new MeuItem[2]; 
/* 0005 */		itens[0] = new MeuItem (3); 
/* 0005 */		itens[1] = new MeuItem (10);
/* 0006 */ 		MeuItem max = (MeuItem) Max.max (itens, 2);
/* 0007 */		System.out.println ("Maior chave: " + max.chave);
/* 0008 */   }
/* 0009 */ }