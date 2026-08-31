#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int n, a[101];
	while( cin >> n , n ){
		for(int i=0 ; i < n ; i++ )
			cin >> a[i];
		int ans = 0;
		for(int j=n-1 ; j > 0 ; j-- ){
			for(int i=1 ; i <= j ; i++ ){
				if( a[i-1] > a[i] ){
					swap( a[i-1] , a[i] );
					ans++;
				}
			}
		}
		cout << ans << endl;
	}
}