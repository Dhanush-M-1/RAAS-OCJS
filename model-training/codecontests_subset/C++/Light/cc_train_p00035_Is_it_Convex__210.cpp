#include <iostream>
#include <cstdio>
using namespace std;

int main(){
	double x[4],y[4];
	char c;
	while(cin>>x[0]>>c>>y[0]>>c>>x[1]>>c>>y[1]>>c>>x[2]>>c>>y[2]>>c>>x[3]>>c>>y[3]){
		double a[4],b[4];
		for(int i=0;i<4;i++){
			a[i] = x[(i+1)%4]-x[i];
			b[i] = y[(i+1)%4]-y[i];
		}
		double c[4];
		for(int i=0;i<4;i++) c[i] = a[i]*b[(i+1)%4] - a[(i+1)%4]*b[i];
		int d = 0;
		for(int i=0;i<4;i++) if(c[i]>0.0) d++;
		if(d==4 or d==0) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
}