package problemset;

public class ComputeArea {
	public int solution(int A, int B, int C, int D, int E, int F, int G, int H) {
		if ((C <= E) || (G <= A) || (D <= F) || (H <= B)) {
			return (C - A)*(D - B) + (G - E)*(H - F);
		} else {
			int left = Math.max(A, E);
			int right = Math.min(C, G);
			int bottom = Math.max(B, F);
			int top = Math.min(D, H);
			
			return (C - A)*(D - B) + (G - E)*(H - F) - (right - left)*(top - bottom);
		}
	}
}