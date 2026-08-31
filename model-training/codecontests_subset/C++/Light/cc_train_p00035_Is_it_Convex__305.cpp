#include <iostream>
#define N 4
using namespace std;
int main(){
	double x[N], y[N];
	char c;
	while(cin >> x[0] >> c >> y[0]){
		for(int i = 1; i < N; i++){
			cin >> c >> x[i] >> c >> y[i];
		}
		double r[N][2], z[4];
		for(int i = 0; i < N; i++){
			r[i][0] = x[(i+1)%N] - x[i];
			r[i][1] = y[(i+1)%N] - y[i];
		}
		for(int i = 0; i < N; i++){
			z[i] = r[i][0]*r[(i+1)%N][1]-r[(i+1)%N][0]*r[i][1];
		}
		if(z[0]*z[1]*z[2]*z[3] > 0) cout << "YES" << endl;	//??°???????¬????????????????????????°NO
		else cout << "NO" << endl;
	}
	return 0;
}