#include <iostream>
#include <cstdio>
#include <complex>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

const double EPS = 1e-10;
const double INF = 1e12;
#define EQ(n,m) (abs((n)-(m)) < EPS)
#define X real()
#define Y imag()

typedef complex<double> P;
typedef vector<P> VP;
double dot(P a, P b){
    return (conj(a)*b).X;
}
double cross(P a, P b){
    return (conj(a)*b).Y;
}

int ccw(P a, P b, P c){
    b -= a;
    c -= a;
    if(cross(b,c) > EPS) return +1; //ccw
    if(cross(b,c) <-EPS) return -1; //cw
    if(dot(b,c) < EPS) return +2; //c-a-b
    if(norm(b) < norm(c)) return -2; //a-b-c
    return 0; //a-c-b
}

int main(){
	double x[4], y[4];
	while(scanf("%lf,%lf", &x[0], &y[0])!=EOF){
		for(int i=1; i<4; i++){
			scanf(",%lf,%lf", &x[i], &y[i]);
		}
		VP quad(4);
		for(int i=0; i<4; i++){
			quad[i] = P(x[i], y[i]);
		}
		
		int judge=1;
		for(int i=0; i<4; i++){
			judge *= ccw(quad[i], quad[(i+1)%4], quad[(i+2)%4]);
		}
		if(judge==1){
			cout << "YES" << endl;
		}else{
			cout << "NO" << endl;
		}
	}
    return 0;
}