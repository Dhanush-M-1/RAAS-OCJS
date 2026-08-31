#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	char trash;
	double x[4], y[4];
	while(cin >> x[0] >> trash >> y[0]){
		double a,b,c,d,e,f,t,r;
		for(int i = 1; i < 4; i++){
			cin >> trash >> x[i] >> trash >> y[i];
		}
		a = y[2]-y[0];
		b = -x[2]+x[0];
		e = -1*(y[0]*(x[2]-x[0])-x[0]*(y[2]-y[0]));
		c = y[3]-y[1];
		d = -x[3]+x[1];
		f = -1*(y[1]*(x[3]-x[1])-x[1]*(y[3]-y[1]));
		t = (e*d-b*f)/(a*d-b*c);
		r = (a*f-c*e)/(a*d-b*c);
		if(x[2] < x[0]){
			swap(x[0],x[2]);
		}
		if(x[3] < x[1]){
			swap(x[1],x[3]);
		}
		if(y[2] < y[0]){
			swap(y[0],y[2]);
		}
		if(y[3] < y[1]){
			swap(y[1],y[3]);
		}
		if((t >= x[0] && t <= x[2]) && (t >= x[1] && t <= x[3]) && (r >= y[0] && r <= y[2]) && (r >= y[1] && r <= y[3])){
			cout << "YES" << endl;
		}
		else{
			cout << "NO" << endl;
		}
	}
}