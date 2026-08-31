#include <iostream>
#include <vector>
#include <cstdlib>
#include <cmath>
#include <algorithm>
#include <sstream>
using namespace std;
#define rep(i,n) for(int i=0;i<n;i++)
#define bitcount(b) __builtin_popcount(b)
#define all(n) n.begin(),n.end()
typedef pair<double,double> P;
#define x first
#define y second

double tri(P a,P b, P c){
	a.x -= c.x, a.y -= c.y;
	b.x -= c.x, b.y -= c.y;
	c.x -= c.x, c.y -= c.y;
	
	return fabs( b.x * a.y - a.x * b.y ) / 2.0;
}

int main(){
	vector<P> d(4);
	string line;
	while( getline(cin,line) ){
		while(~line.find(","))line[line.find(",")] = ' ';
		stringstream ss(line);
		rep(i,4)ss >> d[i].x >> d[i].y;
		
		double S = tri(d[0],d[2],d[1]) + tri(d[0],d[2],d[3]);
		
		bool flag = true;
		
		rep(i,4){
			double s = tri(d[0],d[2],d[1]) + tri(d[0],d[2],d[3]);
			if( s != S)flag = false;
			rotate(d.begin(),d.begin()+1,d.end());
		}
		cout << (flag?"YES":"NO") << endl;
	}
}