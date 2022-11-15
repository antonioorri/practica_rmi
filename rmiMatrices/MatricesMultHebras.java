

public class MatricesMultHebras implements Runnable {

	private int id,j;
	private int c[][], f[][];
	private int res = 0;
	private int C[][]= {};
	public MatricesMultHebras(int id,int j, int[][] c, int[][] f,int [][] C) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.c = c;// su columna
		this.f = f;// su fila
		//this.res=res;
		this.j=j;
		this.C=C;
	}
	@Override
	public void run() {

		for (int i = 0; i < f.length; i++) {
			res += c[id][i] * f[j][i];//System.out.println(res+" += "+c[i]+ " * "+f[i]);
		}
		C[id][j]=res;
	}
}
