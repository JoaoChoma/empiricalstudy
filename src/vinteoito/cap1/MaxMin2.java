package vinteoito.cap1;
public class MaxMin2 {
  public static int [] maxMin2 (int v[], int n) {
    int max = v[0], min = v[0]; 
    for (int i = 1; i < n; i++) {
      if (v[i] > max) max = v[i];
      else if (v[i] < min) min = v[i];
    }
    int maxMin[] = new int[2]; 
    maxMin[0] = max; maxMin[1] = min;
    return maxMin;
  }
  
}
