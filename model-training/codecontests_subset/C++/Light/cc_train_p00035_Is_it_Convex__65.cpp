#include <iostream>
#include <cstdio>

using namespace std;

class Vector{
public:
	double x,y;

	Vector(){}
	Vector( double dx, double dy ){
		x = dx;
		y = dy;
	}
	Vector operator-( const Vector& hoge ){
		return Vector( x - hoge.x, y - hoge.y );
	}

	Vector operator-( const Vector& hoge ) const{
		return Vector( x - hoge.x, y - hoge.y );
	}
};

double crossConduct( const Vector& lhs, const Vector& rhs )
{
	return lhs.x * rhs.y - lhs.y * rhs.x;
}

double line( const Vector& a, const Vector& b, const Vector& p )
{
	Vector hoge = b - a;
	Vector piyo = p - a;

	return crossConduct( hoge, piyo );
}

int main(int argc, char const* argv[])
{
	Vector A,B,C,D;
	char comma;

	while( cin >> A.x >> comma >> A.y >> comma >> B.x >> comma >> B.y >> comma >> C.x >> comma >> C.y >> comma >> D.x >> comma >> D.y ){
		double a,b,c,d;
		a = line( A, B, C );
		b = line( B, C, D );
		c = line( C, D, A );
		d = line( D, A, B );
		if( ( a > 0 && b > 0 && c > 0 && d > 0 ) || ( a < 0 && b < 0 && c < 0 && d < 0 ) ) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
	return 0;


}