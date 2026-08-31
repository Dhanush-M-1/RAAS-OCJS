#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef vector<int> VI;

const int SIZE = 1000001;

VI memo( SIZE, -2 );

int dfs ( int num )
{
	if ( memo[num] != -2 ) {
		return memo[num];
	}
	if ( num < 10 ) {
		return memo[num] = 0;
	}
	int m = 10,
		next = 0,
		res = -1;
	memo[num] = -1;
	while ( num >= m ) {
		next = max( next, ( num / m ) * ( num % m ) );
		m *= 10;
	}
	res = dfs( next );
	if ( res != -1 ) {
		++res;
	}
	return memo[num] = res;
}

int main ( void )
{
	int q;
	while ( cin >> q ) {
		for ( int i = 0; i < q; ++i ) {
			int n;
			cin >> n;

			cout << dfs( n ) << endl;
		}
	}
	return 0;
}