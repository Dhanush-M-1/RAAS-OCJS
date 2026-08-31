#define _USE_MATH_DEFINES
 
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int main(){
	double x[4];
	double y[4];
	char c;

	while(cin >> x[0] >> c >> y[0]){
		for(int i=1;i<4;i++){
			cin >> c >> x[i] >> c >> y[i];
		}
		bool flag1 = 0;
		bool flag2 = 0;
		
		for(int i=0;i<4;i++){
			if((x[(i+2)%4]-x[i%4])*(y[(i+1)%4]-y[i%4])-(y[(i+2)%4]-y[i%4])*(x[(i+1)%4]-x[i%4])>0){
				flag1=1;
			}
			else{
				flag2=1;
			}
		}

		if(flag1 && flag2){
			cout << "NO" << endl;
		}
		else if(flag1 || flag2){
			cout << "YES" <<endl;
		}
		else{
			cout << "NO" << endl;
		}
	}
	return 0;
}