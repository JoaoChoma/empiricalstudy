package exemplo_1;
import cinco.cap4.Item;
public class exemplo_1{
	int chave;
	int res;
	public int problema(int chave){
		if (chave < Item.chave){/*(p2)*/
			res = res + 5;
		}else{ 
		    res = res - 5;
		}
		if (chave > Item.chave){/*(p2)*/
		    res = res + 1;
		}else{ 
		    res = res -1;
		}
		return res;
	}
}