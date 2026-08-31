#include <iostream>
#include <sstream>
#include <string>
#include <algorithm>
using namespace std;

const double eps = 1e-12;
double x[4], y[4];

void rotate()
{
    double lx = x[3], ly = y[3];
    for ( int i = 2; i >= 0; i-- ) x[i+1] = x[i], y[i+1] = y[i];
    x[0] = lx, y[0] = ly;
}

double cross( double x1, double y1, double x2, double y2 )
{
    return x1 * y2 - y1 * x2;
}

bool check()
{
    double a = cross( x[1] - x[0], y[1] - y[0], x[3] - x[0], y[3] - y[0] );
    double b = cross( x[2] - x[1], y[2] - y[1], x[3] - x[1], y[3] - y[1] );
    double c = cross( x[0] - x[2], y[0] - y[2], x[3] - x[2], y[3] - y[2] );
    return ( a > 0 && b > 0 && c > 0 ) || ( a < 0 && b < 0 && c < 0 );
}

bool solve()
{
    for ( int i = 0; i < 4; i++ )
    {
        if ( check() ) return false;
        rotate();
    }
    return true;
}

int main( void )
{
    string input;
    while ( cin >> input )
    {
        replace( input.begin(), input.end(), ',', ' ' );
        istringstream is(input);

        for ( int i = 0; i < 4; i++ ) is >> x[i] >> y[i];

        cout << ( solve()? "YES" : "NO" ) << endl;
    }

    return 0;
}