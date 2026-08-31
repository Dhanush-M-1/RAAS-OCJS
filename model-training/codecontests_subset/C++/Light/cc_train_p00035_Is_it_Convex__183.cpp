#include <iostream>
#include <complex>
#include <cstdio>
using namespace std;

int main(){
	float xa, ya, xb, yb, xc, yc, xd, yd;
	
	while(scanf("%f,%f,%f,%f,%f,%f,%f,%f", &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) != EOF){
		float x[4] = {xa,xb,xc,xd};
		float y[4] = {ya,yb,yc,yd};
		float s[4];
		bool allp = true, alln = true;
		
		
		for(int i = 0; i < 4; ++i){
			s[i] = (x[(i+1)%4] - x[i]) * (y[(i+2)%4] - y[(i+1)%4]) - (x[(i+2)%4] - x[(i+1)%4]) * (y[(i+1)%4] - y[i]);
		}
		
		for(int i = 0; i < 4; ++i){
			if(s[i] < 0){
				allp = false;
				break;
			}
		}
		for(int i = 0; i < 4; ++i){
			if(s[i] > 0){
				alln = false;
				break;
			}
		}
		
		if(allp || alln){
			cout << "YES" << endl;
		}else{
			cout << "NO" << endl;
		}
	}
	return 0;
}