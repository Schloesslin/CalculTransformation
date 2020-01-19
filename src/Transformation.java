import java.util.ArrayList;

public class Transformation {

	ArrayList<String> theta;
	ArrayList<String> alpha;
	ArrayList<String> d;
	ArrayList<String> r;
	
	public Transformation() {
		this.theta = new ArrayList<String>();
		this.alpha = new ArrayList<String>();
		this.d = new ArrayList<String>();
		this.r = new ArrayList<String>();
		
		this.alpha.add("0");
		this.alpha.add("0");
		this.alpha.add("0");
		this.alpha.add("-90");
		this.alpha.add("90");
		this.alpha.add("-90");
		this.alpha.add("90");
		
		this.theta.add("0");
		this.theta.add("q1");
		this.theta.add("0");
		this.theta.add("q3");
		this.theta.add("q4");
		this.theta.add("q5");
		this.theta.add("0");
		
		this.d.add("0");
		this.d.add("0");
		this.d.add("0");
		this.d.add("0.22");
		this.d.add("1");
		this.d.add("1");
		this.d.add("q6");
		
		this.r.add("0");
		this.r.add("0");
		this.r.add("q2");
		this.r.add("0");
		this.r.add("0");
		this.r.add("0");
		this.r.add("0");
	}
	
	@SuppressWarnings("deprecation")
	public ArrayList<ArrayList<String>> makeTransformation(int i, int j) {
		ArrayList<ArrayList<String>> transformation = new ArrayList<ArrayList<String>>();
		ArrayList<String> line1 = new ArrayList<String>();
		ArrayList<String> line2 = new ArrayList<String>();
		ArrayList<String> line3 = new ArrayList<String>();
		ArrayList<String> line4 = new ArrayList<String>();

		Boolean alphaBool;
		Boolean thetaBool;
		Boolean dBool;
		Boolean rBool;
		
		double alpha = 0;
		double theta = 0;
		double d = 0;
		double r = 0;
		
		try {
			alpha = Double.parseDouble(this.alpha.get(j));
			alphaBool = true;
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			alphaBool = false;
		}
		
		try {
			theta =Double.parseDouble(this.theta.get(j));
			thetaBool = true;
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			thetaBool = false;
		}
		
		try {
			d = Double.parseDouble(this.d.get(j));
			dBool = true;
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			dBool = false;
		}
		
		try {
			r = Double.parseDouble(this.r.get(j));
			rBool = true;
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			rBool = false;
		}
		
		if(thetaBool) {
			line1.add(new Double(Math.cos(this.convert(theta))).toString());
			line1.add(new Double(-Math.sin(this.convert(theta))).toString());
		}
		else {
			line1.add("cos(" + this.theta.get(j) + ")");
			line1.add("-sin(" + this.theta.get(j) + ")");
		}
		line1.add("0");
		
		if(dBool) {
			line1.add(new Double(d).toString());
		}
		else {
			line1.add(this.d.get(j));
		}
		
		if(alphaBool && thetaBool) {
			line2.add(new Double(Math.cos(this.convert(alpha))*Math.sin(this.convert(theta))).toString());
			line2.add(new Double(Math.cos(this.convert(alpha))*Math.cos(this.convert(theta))).toString());
			line2.add(new Double(-Math.sin(this.convert(alpha))).toString());
			line3.add(new Double(Math.sin(this.convert(alpha))*Math.sin(this.convert(theta))).toString());
			line3.add(new Double(Math.sin(this.convert(alpha))*Math.cos(this.convert(theta))).toString());
			line3.add(new Double(Math.cos(this.convert(alpha))).toString());

		}
		else if(alphaBool) {
			if(alpha == 0) {
				line2.add("sin(" + this.theta.get(j) + ")");
				line2.add("cos(" + this.theta.get(j) + ")");
				line2.add("0");
				line3.add("0");
				line3.add("0");
				line3.add("1");
			}
			else if(alpha == 90){
				line2.add("0");
				line2.add("0");
				line2.add("-1");
				line3.add("sin(" + this.theta.get(j) + ")");
				line3.add("cos(" + this.theta.get(j) + ")");
				line3.add("0");
			}
			else {
				line2.add("0");
				line2.add("0");
				line2.add("1");
				line3.add("-sin(" + this.theta.get(j) + ")");
				line3.add("-cos(" + this.theta.get(j) + ")");
				line3.add("0");
			}
		}
		else if(thetaBool) {
			if(theta == 0) {
				line2.add("0");
				line2.add("cos(" + this.alpha.get(j) + ")");
				line2.add("-sin(" + this.alpha.get(j) + ")");
				line3.add("0");
				line3.add("sin(" + this.alpha.get(j) + ")");
				line3.add("cos(" + this.alpha.get(j) + ")");
			}
			else if(theta == 90){
				line2.add("cos(" + this.alpha.get(j) + ")");
				line2.add("0");
				line2.add("-sin(" + this.alpha.get(j) + ")");
				line3.add("sin(" + this.alpha.get(j) + ")");
				line3.add("0");
				line3.add("cos(" + this.alpha.get(j) + ")");
			}
			else {
				line2.add("-cos(" + this.alpha.get(j) + ")");
				line2.add("0");
				line2.add("-sin(" + this.alpha.get(j) + ")");
				line3.add("-sin(" + this.alpha.get(j) + ")");
				line3.add("0");
				line3.add("cos(" + this.alpha.get(j) + ")");
			}
		}
		else {
			line2.add("cos(" + this.alpha.get(j) + ")*sin(" + this.theta.get(j) + ")");
			line2.add("cos(" + this.alpha.get(j) + ")*cos(" + this.theta.get(j) + ")");
			line2.add("-sin(" + this.alpha.get(j) + ")");
			line3.add("sin(" + this.alpha.get(j) + ")*sin(" + this.theta.get(j) + ")");
			line3.add("sin(" + this.alpha.get(j) + ")*cos(" + this.theta.get(j) + ")");
			line3.add("cos(" + this.alpha.get(j) + ")");
		}
		
		if (rBool && alphaBool) {
			line2.add(new Double(-r*Math.sin(this.convert(alpha))).toString());
			line3.add(new Double(r*Math.cos(this.convert(alpha))).toString());
		}
		else if(alphaBool) {
			if(alpha == 0) {
				line2.add("0");
				line3.add(this.r.get(j));
			}
			else if(alpha == 90){
				line2.add("-" + this.r.get(j));
				line3.add("0");
			}
			else {
				line2.add(this.r.get(j));
				line3.add("0");
			}
		}
		else if(rBool) {
			if(r == 0){
				line2.add("0");
				line3.add("0");
			}
			else {
				line2.add("-" + this.r.get(j) + "sin(" + this.alpha.get(j) + ")");
				line3.add(this.r.get(j) + "cos(" + this.alpha.get(j) + ")");
			}
		}
		
		line4.add("0");
		line4.add("0");
		line4.add("0");
		line4.add("1");
		
		transformation.add(line1);
		transformation.add(line2);
		transformation.add(line3);
		transformation.add(line4);
		return transformation;
	}
	
	public ArrayList<ArrayList<String>> mult(ArrayList<ArrayList<String>> t1, ArrayList<ArrayList<String>> t2){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> line = new ArrayList<String>();
		@SuppressWarnings("deprecation")
		Double tmpD = new Double(0);
		String tmp = new String("");
		Boolean a,b;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					
					try {
						Double.parseDouble(t1.get(i).get(k));
						a = true;
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						a = false;
					}
					try {
						Double.parseDouble(t2.get(k).get(j));
						b = true;
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						b = false;
					}
					
					if(a && b) {
						tmpD += Double.parseDouble(t1.get(i).get(k))*Double.parseDouble(t2.get(k).get(j));
						
						
					}
					else if(a) {
						if(Double.parseDouble(t1.get(i).get(k))==1) {
							tmp+=t2.get(k).get(j)+"+";
						}
						else if(Double.parseDouble(t1.get(i).get(k))==0) {
							
						}
						else {
							tmp+=t1.get(i).get(k) + "*" + t2.get(k).get(j)+"+";
						}
					}
					else if(b) {
						if(Double.parseDouble(t2.get(k).get(j))==1) {
							tmp+=t1.get(i).get(k)+"+";
						}
						else if(Double.parseDouble(t2.get(k).get(j))==0) {
							
						}
						else {
							tmp+=t1.get(i).get(k) + "*" + t2.get(k).get(j)+"+";
						}
					}
					else {
						tmp +=t1.get(i).get(k)+"*"+t2.get(k).get(j)+"+";
					}
				}
				if(tmpD!=0) {
					tmp+=tmpD.toString()+"+";
				}
				if(tmp.equals("")) {
					tmp = "0";
				}
				else {
					tmp = tmp.substring(0, tmp.length()-1);
				}
				line.add(tmp);
				tmp = "";
				tmpD = (double) 0;
			}
			
			res.add(line);
			//line.clear();
			line= new ArrayList<String>();
		}
		return res;
	}
	
	public double convert(double degres) {
		return Math.PI*degres/180;
	}
	
	public void print(ArrayList<ArrayList<String>> transfo) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				
				System.out.print(transfo.get(i).get(j)+"   ");
			}
			System.out.println("");
		}
	}

}
