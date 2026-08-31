#include <iostream>
using namespace std;

class Vector2{
public:
	Vector2() : x( 0 ), y( 0 ){}
	Vector2( Vector2& a ){
		x = a.x;
		y = a.y;
	}
	Vector2( Vector2& a, Vector2& b ){
		x = b.x - a.x;
		y = b.y - a.y;
	}

	double cross( Vector2& a ){
		return ( x * a.y ) - ( y * a.x );
	}

	double x, y;
};

int main(){
	Vector2 a, b, c, d;
	char s;

	while ( cin >> a.x >> s >> a.y >> s >> b.x >> s >> b.y >> s
				>> c.x >> s >> c.y >> s >> d.x >> s >> d.y ){

		Vector2 ab( a, b ), bc( b, c ), cd( c, d ), da( d, a );
		double ap, bp, cp, dp;

		ap = da.cross( ab );
		bp = ab.cross( bc );
		cp = bc.cross( cd );
		dp = cd.cross( da );

		if ( ( ap > 0 && bp > 0 && cp > 0 && dp > 0 ) || ( ap < 0 && bp < 0 && cp < 0 && dp < 0 ) ){
			cout << "YES" << endl;
		}else{
			cout << "NO" << endl;
		}
		
	}
	return 0;
}