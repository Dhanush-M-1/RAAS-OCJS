/*~Rainybunny~*/

#include <cstdio>
#include <cstring>

#define rep( i, l, r ) for ( int i = l, rep##i = r; i <= rep##i; ++i )
#define per( i, r, l ) for ( int i = r, per##i = l; i >= per##i; --i )


const int MAXN = 101, MOD = 1e9 + 7;
int n, c[MAXN + 5], b[MAXN + 5];
int sc[MAXN + 5], sb[MAXN + 5], sb2[MAXN + 5];
int h[MAXN + 5], ans[MAXN + 5];

inline void chkmax( int& a, const int b ) { a < b && ( a = b ); }
inline int imin( const int a, const int b ) { return a < b ? a : b; }
inline int imax( const int a, const int b ) { return a < b ? b : a; }
inline int sub( int a, const int b ) { return ( a -= b ) < 0 ? a + MOD : a; }
inline int add( int a, const int b ) { return ( a += b ) < MOD ? a : a - MOD; }

inline int solve( const int lim ) {
	static int f[MAXN * MAXN + 5], g[MAXN * MAXN + 5];
	memset( f, 0, sizeof f ), f[0] = 1;
	rep ( i, 1, n ) {
		g[0] = f[0];
		rep ( j, 1, sc[i] ) g[j] = add( g[j - 1], f[j] );
		rep ( j, 0, lim * i + sb[i - 1] - 1 ) f[j] = 0;
		rep ( j, imax( 0, lim * i + sb[i - 1] ), sc[i] ) {
			f[j] = sub( g[j], j > c[i] ? g[j - c[i] - 1] : 0 );
		}
	}
	int ret = 0;
	rep ( i, imax( 0, lim * n + sb[n - 1] ), sc[n] ) ret = add( ret, f[i] );
	return ret;
}

int main() {
	scanf( "%d", &n );
	rep ( i, 1, n ) scanf( "%d", &c[i] ), sc[i] = sc[i - 1] + c[i];
	rep ( i, 1, n - 1 ) scanf( "%d", &b[i] );
	
	int mx = 0xcfcfcfcf;
	rep ( i, 1, n ) sb[i] = sb[i - 1] + b[i];
	rep ( i, 1, n ) sb[i] += sb[i - 1];
	rep ( i, 1, n ) chkmax( mx, ( sb[i - 1] + i - 1 ) / i );
	
	rep ( i, 0, MAXN ) ans[i] = solve( i - mx );
	
	int q, x; scanf( "%d", &q );
	while ( q-- ) {
		scanf( "%d", &x ), x = imin( MAXN - mx, imax( x, -mx ) );
		printf( "%d\n", ans[x + mx] );
	}
	return 0;
}

