public class Predictor9999 extends Predictor {
	
	private Table p1, p2;
	private int n, k, n1, bit, temp1, entry, entry2, entry3, rand;

	private int shift_op(int c) {
		int tp = (1<<c);
		return tp;
	}

	public Predictor9999() {
		n = 7;
		k = 4;
		n1 = 8;
		bit = 3;
		temp1 = n+k;
		entry = shift_op(temp1);
		entry2 = shift_op(n1);
		p1 = new Table(entry, bit);
		p2 = new Table(entry2, k);

		entry3 = shift_op(bit);
		rand = (int)(Math.random()*entry3);

		for(int i=0; i<entry; i++) {
			p1.setInteger(i, 0, bit-1, rand);
		}
		
	}

	private int updatedvalue(int g, boolean outcome, int tmp3) {
		g = g>>1;
		if(outcome == true) {
			int tmp7 = shift_op(tmp3);
			g = g + tmp7;
		}
		return g;
	}

	private int  updatednew_ent(int x, boolean outcome) {
		if(outcome == false) {
			x = x-1;
		}
		else {
			x = x+1;
		}
		return x;
	}

	private boolean get_res(int a, int b) {
		return p1.getBit(a, b);
	}

	private int numupdate(long address, int tmp0) {
		int x = ((int)address) & (tmp0);
		return x;
	}

	public void Train(long address, boolean outcome, boolean predict) {
		int tmp0 = (shift_op(n))-1;
		int tmp1 = (shift_op(n1))-1;
		int tmp3 = k-1;
		int lnum = numupdate(address, tmp0);
		int lnum1 = numupdate(address, tmp1);
		int gvalue = p2.getInteger(lnum1, 0, tmp3);
		int tmp4 = (shift_op(k))*lnum;
		int indice = (tmp4 +  gvalue);

		int tmp5 = bit-1;
		int new_ent = p1.getInteger(indice, 0, tmp5);

		new_ent = updatednew_ent(new_ent, outcome);

		int tmp6 = (shift_op(bit))-1;
		new_ent = Math.min(tmp6, new_ent);
		new_ent = Math.max(0, new_ent);
		p1.setInteger(indice, 0, tmp5 ,new_ent);

		int gindex = ((int)address) & (tmp1);
		int g = p2.getInteger(gindex, 0, tmp3);
		g = updatedvalue(g, outcome, tmp3);

		p2.setInteger(gindex, 0, tmp3, g);

	}
	

	public boolean predict(long address){
		int tmp0 = (shift_op(n))-1;
		int tmp1 = (shift_op(n1))-1;
		int tmp3 = k-1;
		int lnum = numupdate(address, tmp0);
		int lnum1 = numupdate(address, tmp1);
		int gvalue = p2.getInteger(lnum1, 0, tmp3);
		int tmp4 = (shift_op(k))*lnum;
		int indice = (tmp4 +  gvalue);
		return get_res(indice, 0);
	}

}
