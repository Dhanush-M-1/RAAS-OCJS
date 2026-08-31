#include <bits/stdc++.h>
using namespace std;

int n,m,i,b;
long long int a[100005];

int main ()
{
	for ( i = 0 ; i <= 100004 ; ++ i )
	    a[i] = 1;
	
	cin >> n >> m;
	for ( i = 1 ; i <= m ; ++ i )
	{
		cin >> b;
		a[b] = 0;
	}
	
	for ( i = 2 ; i <= n ; ++ i )
		a[i] = ( a[i-1] + a[i-2] ) * a[i] % 1000000007;
	
	cout << a[n] << endl;
	
	return 0;
	
}