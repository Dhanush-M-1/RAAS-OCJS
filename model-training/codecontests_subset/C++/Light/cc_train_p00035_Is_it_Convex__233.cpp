#include <iostream>
#include <stdio.h>

using namespace std;

bool check(double X1,double Y1,double X2,double Y2,double X3,double Y3,double X4,double Y4)
{
	return((X1 - X2) * (Y3 - Y1) - (Y1 - Y2) * (X3 - X1)) * ((X1 - X2) *(Y4 - Y1) - (Y1 - Y2) * (X4 - X1)) > 0.0;
}

void solve()
{
	double xa, ya, xb, yb, xc, yc, xd, yd;
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) )
	if(check(xa,ya,xc,yc,xb,yb,xd,yd) || check(xb,yb,xd,yd,xa,ya,xc,yc))
	{
		cout << "NO" << endl;
	}
	else
	{
		cout << "YES" << endl;
	}
}

int main()
{
	solve();
	return(0);
}