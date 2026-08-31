#include<iostream>

int a[100];

int main()
{
	int n;
	while( std::cin >> n, n )
	{
		for( int i = 0; i != n; ++i )
			std::cin >> a[i];

		int ans = 0;
		for( int i = 0; i != n; ++i )
			for( int j = 0; j != n - i - 1; ++j )
				if( a[j] > a[j+1] )
					std::swap( a[j], a[j+1] ), ++ans;

		std::cout << ans << std::endl;
	}

	return 0;
}