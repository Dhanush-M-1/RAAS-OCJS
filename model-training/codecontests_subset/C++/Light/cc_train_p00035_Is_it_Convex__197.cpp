#include<iostream>
#include<cstdlib>
#include<complex>
using namespace std;
typedef complex<double> Po;
 
double cross(Po a,Po b)
{
	return a.real()*b.imag() - a.imag()*b.real();
}
 
double area(Po a,Po b, Po c)
{
	return abs(cross(b-a,c-a))/2;
}
 
bool inter(Po a, Po b,Po c,Po x)
{
	return (fabs(area(a,b,x)+area(b,c,x)+area(c,a,x)-area(a,b,c))<1e-10);
}
 
int main()
{
	Po p[4];
	double a, b;
	char c, d;

	while(cin >> a >> c >> b){
		p[0] = Po(a, b);
		for(int i=1; i<4; i++)
		{
			cin >> c >> a >> d >> b;
			p[i] = Po(a, b);
		}
		if(inter(p[0],p[1],p[2],p[3]) || inter(p[0],p[2],p[3],p[1]) || inter(p[0],p[1],p[3],p[2]) || inter(p[1],p[2],p[3],p[0]))
			cout << "NO\n";
		else cout << "YES\n";
	}
}