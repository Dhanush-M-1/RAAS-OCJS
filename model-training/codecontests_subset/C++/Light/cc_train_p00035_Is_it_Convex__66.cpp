#include <iostream>
#include <cassert>
#include <cmath>
#include <complex>
using namespace std;


typedef complex<double> P;

#define EPS			(1e-10)
#define PI			(3.14159265358979323846)


#define X(a)		( (a).real() )
#define Y(a)		( (a).imag() )
#define EQ(a,b)		( -EPS<(a)-(b) && (a)-(b)<EPS )
#define EQV(a,b)	( EQ(X(a),X(b)) && EQ(Y(a),Y(b)) )

#define unit(a)		( (a)/abs(a) )
#define normal(a)	( (a)*P(0,1) )
#define dot(a,b)	( X((a)*conj(b)) )
#define cross(a,b)	( Y(conj(a)*(b)) )

int ccw(P a, P b, P c)
{
	b -= a; c -= a;
	if(cross(b, c) > 0)   return +1;	// counter clockwise
	if(cross(b, c) < 0)   return -1;	// clockwise
	if(dot(b, c) < 0)     return +2;	// c--a--b on line
	if(norm(b) < norm(c)) return -2;	// a--b--c on line
	return 0;
}

int main()
{
	P p[4]; int a; double x,y; char c;
	while(cin >> x >> c >> y)
	{
		p[0]=P(x,y);

		for(int i=1; i<4; i++)
		{
			cin >> c >> x >> c >> y;
			p[i]=P(x,y);
		}

		a=0;
		for(int i=0; i<4; i++)
		{
			a+=ccw(p[i],p[(i+1)%4],p[(i+2)%4]);
		}

		cout << (a==4||a==-4 ? "YES":"NO") << endl;
	}

}