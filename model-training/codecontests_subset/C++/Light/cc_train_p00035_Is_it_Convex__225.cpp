#include <iostream>
#include <cstdio>
#include <cmath>
using namespace std;
double EPS=1e-10;
double add(double a, double b)
{
	if(abs(a+b)<EPS*(abs(a)+abs(b))) return 0;
	return a+b;
}
double x[5],y[5];
bool input()
{
	bool suc=false;
	for(int i=0;i<4;i++) 
	{
		if(!i && scanf("%lf,%lf",&x[i],&y[i])!=EOF) suc=true;
		else if(i && scanf(",%lf,%lf",&x[i],&y[i])!=EOF) suc=true;
	}
	if(suc) return true;
	else return false;
}
int main()
{
	while(input())
	{
		bool failed=false; x[4]=x[0],y[4]=y[0];
		double vx[5],vy[5];
		for(int i=0;i<4;i++) vx[i]=x[i+1]-x[i],vy[i]=y[i+1]-y[i];
		vx[4]=vx[0],vy[4]=vy[0];
		bool plus=true;
		if(add(vx[0]*vy[1],-vy[0]*vx[1])<0) plus=false;
		for(int i=0;i<4;i++)
		{
			if(plus && add(vx[i]*vy[i+1],-vy[i]*vx[i+1])<0 ) failed=true;
			else if(!plus && add(vx[i]*vy[i+1],-vy[i]*vx[i+1])>0 ) failed=true;
		}
		if(failed) cout << "NO" << '\n' ;
		else cout << "YES" << '\n' ;
	}
}