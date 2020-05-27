package vintedois.cap5.listaenc;

import junit.framework.TestCase;

public class ConjuntoTeste extends TestCase {

	 TabelaHash tabela;
	 
	 public void setUp()
	 {		 
		 tabela = new TabelaHash ();
	 }
	 
	public void test1_1() {
		 tabela = new TabelaHash ();
		assertEquals(tabela != null,true);
	}
	
	public void test2_1() {
		Object obj;
		
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
		 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		 obj = tabela.pesquisa("sdhg");
		 		 
		 assertEquals(obj != null,true);
	}
	
	public void test2_2() {
		Object obj;
		
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
		 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		 obj = tabela.pesquisa("sdhgd");
		 		 
		 assertNull(obj);
	}
	
	public void test3_1e3() {
		Object obj;
		
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
		 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		 tabela.insere("teste","teste");
		 		 
		 obj = tabela.pesquisa("teste");
		 
		 assertEquals(obj != null,true);
	}
	
	public void test3_2() {
		Object obj;
		
		 tabela = new TabelaHash ();
		 
		 tabela.insere("teste","teste");
		 		 
		 obj = tabela.pesquisa("teste");
		 
		 assertEquals(obj != null,true);
	}
	
	public void test3_4() {
		Object obj;
		
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
		 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		 tabela.insere("sdhg","sdhg");
		 		 
		 obj = tabela.pesquisa("sdhg");
		 
		 assertEquals(obj != null,true);
		 // verificar erro na saida padrao: Registro ja esta presente
	}
	
	public void test4_1e3() {
		 Object obj1,obj2;
		
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
		 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		 obj1 = tabela.pesquisa("sdhg");
		 try {
			tabela.retira("sdhg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		 		 
		 obj2 = tabela.pesquisa("sdhg");
		 
		 assertEquals(obj1 != null && obj2 == null,true);
	}
	
	public void test4_2() {
		Object obj;
		
		 tabela = new TabelaHash ();
		 
		 try {
				tabela.retira("sdhg");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		 		 
		 obj = tabela.pesquisa("sdhg");
		 
		 assertEquals(obj == null,true);
	}
	
	public void test4_4() {
		 Object obj1,obj2;
			
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
		 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		 obj1 = tabela.pesquisa("teste");
		 try {
			tabela.retira("teste");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		 		 
		 obj2 = tabela.pesquisa("teste");
		 
		 assertEquals(obj1 == null && obj2 == null,true);
	}
	
	public void test5_1() {
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
		 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		
		 tabela.imprime(); 		 
		 // verifica a impressao;
	}
	
	public void test5_2() {
		tabela = new TabelaHash ();
		 
		 tabela.imprime(); 		 
		 // verifica a impressao;
	}
	/*AVL************************************************AVL***************************************************AVL*/ 
	
	
	public void testFC1() {
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
	//	 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		 tabela.pesquisa("asdf");
		 tabela.imprime(); 		 
		 // verifica a impressao;
	}
	
	
	public void testFC2() {
		
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("dafa","fsdfa");
	//	 tabela.insere ("asdf","asdf");
		 tabela.insere ("sdhg","sdhg");
		 tabela.insere ("sdfhdd","sdfhdd");
		 tabela.insere ("jkhgfd","jkhgfd");
		 
		 try {
			 tabela.retira("sdhg");
		} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
		}		 
		 // verifica a impressao;
	}
	
	public void testFD1() {
		
		 tabela = new TabelaHash ();
		 
		 tabela.insere ("a","fsdfa");
		 tabela.insere ("b","asdf");
		 tabela.insere ("c","sdhg");
		 tabela.insere ("d","sdfhdd");
		 tabela.insere ("e","jkhgfd");
		 
		 try {
			 tabela.pesquisa("f");
		} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
		}		 
		 // verifica a impressao;
	}
	
}

