#include <bits/stdc++.h>
using namespace std;

typedef complex<double> P;

double cross(P a,P b){
	return imag(a*conj(b));
}

P in(stringstream &cin){
	double x,y;
	if(cin >> x >> y) return P(x,y);
	exit(0);
}

int main(){
	string l;
	while(getline(cin,l)){
		for( auto &&c : l )
			if( c == ',' )
				c = ' ';
		stringstream ss(l);
		P p[6];
		for(int i = 0 ; i < 4 ; i++)
			p[i] = in(ss);
		p[4] = p[0];
		p[5] = p[1];
		int bit = 0;
		for(int i = 0 ; i < 4 ; i++){
			bit |= 1<<(cross(p[i+1]-p[i],p[i+2]-p[i])>0);
		}
		if( bit == 3 ){
			cout << "NO" << endl;
		}else{
			cout << "YES" << endl;
		}
			
		
	}
	
	
}