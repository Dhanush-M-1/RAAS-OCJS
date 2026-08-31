#include <iostream>
using namespace std;

int main()
{
	int n;
	while( cin >> n && n ){
		int a[ 100 ] = {0};
		for( int i = 0; i < n; ++i ){
			cin >> a[ i ];
		}

		int ans = 0;
		for( int i = 0; i < n - 1; ++i ){
			for( int j = 0; j < n - 1 - i; ++j ){
				if( a[ j ] > a[ j + 1 ] ){
					int t = a[ j + 1 ];
					a[ j + 1 ] = a[ j ];
					a[ j ] = t;
					++ans;
				}
			}
		}
		cout << ans << endl;
	}

	return 0;
}