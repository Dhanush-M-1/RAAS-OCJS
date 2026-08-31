#include<iostream>
#include<cstdio>
using namespace std;
bool C(double a,double b,double c,double d){return a*d-b*c>=0;}
int main()
{
	double a,b,c,d,e,f,g,h;
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&a,&b,&c,&d,&e,&f,&g,&h))
	{
		int cnt=C(e-c,f-d,a-c,b-d)+C(g-e,h-f,c-e,d-f)+C(a-g,b-h,e-g,f-h)+C(c-a,d-b,g-a,h-b);
		cout<<(cnt==0||cnt==4?"YES":"NO")<<endl;
	}
}
