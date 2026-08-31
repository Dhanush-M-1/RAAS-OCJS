#include <iostream>
#include <vector>
using namespace std;
typedef vector <int> VI;
int main( void )
{
	int n;
	while ( cin >> n && n )
	{
		int swap_count = 0;
		VI E(n);
		for ( int i = 0; i < n; i++ ) cin >> E[i];
		for ( int i = 0; i < n; i++ )
		{
			for ( int j = 1; j < n-i; j++ )
			{
				if ( E[j-1] > E[j] )
				{
					swap( E[j-1], E[j] );
					swap_count ++;
				}
			}
		}
		cout << swap_count << endl;
	}

	return 0;
}