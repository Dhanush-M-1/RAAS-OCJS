#include <iostream>
#include <complex>
#include <cmath>
using namespace std;

typedef complex <double> P;
#define X real()
#define Y imag()

double func(P p1, P p2, P p3, P p4){
	return  ( (p1.X-p2.X)*(p3.Y-p1.Y) + (p1.Y-p2.Y)*(p1.X-p3.X)) * ((p1.X-p2.X)*(p4.Y-p1.Y) + (p1.Y-p2.Y)*(p1.X-p4.X));
}

int main(void)
{
	double x1, x2, x3, x4, y1, y2, y3, y4;
	char a;
	
	while (cin>>x1>>a>>y1>>a>>x2>>a>>y2>>a>>x3>>a>>y3>>a>>x4>>a>>y4){
		P a(x1, y1);
		P b(x2, y2);
		P c(x3, y3);
		P d(x4, y4);
		
		if (0.0 < func(a, c, b, d) || 0.0 < func(b, d, a, c)) cout << "NO" << endl;
		else cout << "YES" << endl;
	}
	
	return 0;
}