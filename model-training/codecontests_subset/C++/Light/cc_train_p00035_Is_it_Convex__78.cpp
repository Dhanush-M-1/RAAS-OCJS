#include<iostream>
#include<math.h>

#define PI 3.14159265358979

using namespace std;

double cos(double x1, double y1, double x2, double y2,double x3, double y3)
{
	double xa,xb,ya,yb;
	xa=x2-x1;
	ya=y2-y1;
	xb=x2-x3;
	yb=y2-y3;
	return (xa*xb+ya*yb)/(sqrt(xa*xa+ya*ya)*sqrt(xb*xb+yb*yb));
}

int main(void)
{
	double xa,ya,xb,yb,xc,yc,xd,yd,theta;
	char c;
	while(cin>>xa>>c>>ya>>c>>xb>>c>>yb>>c>>xc>>c>>yc>>c>>xd>>c>>yd)
	{
		theta=0;
		theta+=acos(cos(xa,ya,xb,yb,xc,yc));
		theta+=acos(cos(xb,yb,xc,yc,xd,yd));
		theta+=acos(cos(xc,yc,xd,yd,xa,ya));
		theta+=acos(cos(xd,yd,xa,ya,xb,yb));
		if(theta<2*PI)
		{
			cout<<"NO"<<endl;
		}
		else
		{
			cout<<"YES"<<endl;
		}
	}
}