#include <bits/stdc++.h>
using namespace std;

int Hekomi(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {

	double A, B, C;
	A = (x2 - x1)*(y4 - y1) - (y2 - y1)*(x4 - x1);
	B = (x3 - x2)*(y4 - y2) - (y3 - y2)*(x4 - x2);
	C = (x1 - x3)*(y4 - y3) - (y1 - y3)*(x4 - x3);
	if ((A > 0 && B > 0 && C > 0) || (A < 0 && B < 0 && C < 0))
		return 0;
	else
		return 1;
}

int main() {

	double x1, x2, x3, x4, y1, y2, y3, y4;
	char a;
	vector<int> TF;

	while (cin >> x1 >> a  >> y1 >> a >> x2 >> a >> y2 >> a >> x3 >> a >> y3 >> a >> x4 >> a >> y4) {
		TF.push_back(1);
		if (Hekomi(x1, y1, x2, y2, x3, y3, x4, y4) == 0) {
			TF.pop_back(); 
			TF.push_back(0);
		}
		if (Hekomi(x1, y1, x2, y2, x4, y4, x3, y3) == 0){
			TF.pop_back(); 
			TF.push_back(0);
		}
		if (Hekomi(x1, y1, x4, y4, x3, y3, x2, y2) == 0){
			TF.pop_back(); 
			TF.push_back(0);
		}
		if (Hekomi(x4, y4, x2, y2, x3, y3, x1, y1) == 0){
			TF.pop_back(); 
			TF.push_back(0);
		}
		
	}
	for (int i = 0; i < TF.size(); i++) {
		if (TF[i])cout << "YES" << endl;
		else cout << "NO" << endl;
	}
	return 0;
}