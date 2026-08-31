#include <bits/stdc++.h>

#define PI 3.14159265358979

using namespace std;

double f(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4)
{
	return ((x1-x2)*(y3-y1)+(y1-y2)*(x1-x3))*((x1-x2)*(y4-y1)+(y1-y2)*(x1-x4));
}

int main()
{
	double x[4],y[4];

	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3])!=EOF)
	{
		if(f(x[0],y[0],x[2],y[2],x[1],y[1],x[3],y[3])>0 || f(x[1],y[1],x[3],y[3],x[0],y[0],x[2],y[2])>0)cout << "NO" << endl;
		else cout << "YES" << endl;
	}
	return 0;
}