#include<cstdio>
#include<algorithm>
#include<vector>
#include<string>
#include<iostream>
#include<queue>
#include<map>
#include<set>
#include<complex>
#include<stack>
#include<cmath>

using namespace std;

#define reps(i,f,n) for(int i=f;i<int(n);i++)
#define rep(i,n) reps(i,0,n)

#define X real()
#define Y imag()
typedef complex<double> P;

double cross(P a,P b){return a.X*b.Y-a.Y*b.X;}
bool ccw(P a,P b,P c){return cross(b-a,c-a)>=0;}

int main(){
	
	double a[8];
	
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&a[0],&a[1],&a[2],&a[3],&a[4],&a[5],&a[6],&a[7])!=EOF){
		
		P b[4];
		rep(i,4)b[i]=P((double)a[i*2],(double)a[i*2+1]);
		
		bool ok = true;
		rep(i,4){
			if(!ccw(b[i],b[(i+1)%4],b[(i+2)%4]))ok=false;
		}
		
		bool ok2 = true;
		rep(i,4){
			if(!ccw(b[i],b[(i+3)%4],b[(i+2)%4]))ok2=false;
		}
		if(ok||ok2)puts("YES");
		else puts("NO");
	}
	
}