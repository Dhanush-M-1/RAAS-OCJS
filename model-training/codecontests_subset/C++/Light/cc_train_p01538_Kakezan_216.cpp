#include <bits/stdc++.h>
using namespace std;

#define FOR( i, m, n )  for( int (i) = (m); (i) < (n); (i)++ )
#define REP( i, n )     FOR( i, 0, n )
#define ALL( a )        (a).begin(), (a).end()             

int main() {
	int n; cin >> n;

	int r, a, b, ma , cnt;
	REP( i, n ) {
		cin >> r;
		cnt = 0;
		
		if( r < 10 ) cnt = 0;
		else {

			int j;
			ma = 0;
			
			while( 1 ) {
				j = 10;
				while( 1 ) {
					a = r % j;
					b = r / j;
					
					if( a == r ) break;
					
					ma = max( a * b, ma );
					j *= 10;
				}
				cnt++;
				r = ma;
				ma = 0;
				if( r < 10 ) break;
			}
		}

		cout << cnt << endl;
	}
}
