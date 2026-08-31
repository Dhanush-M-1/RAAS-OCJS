#include <iostream>
#include <vector>
#include <algorithm>

#define rep(i,n) for(int i=0;i<(int)(n);i++)

using namespace std;

int multi_max(int n)
{
	int k = 10;
	int maxi=0;
	while(n/k > 0){
		maxi = max(maxi, (n/k)*(n-n/k*k));
		k *= 10;
	}
	return maxi;
}

int main(void)
{
	int q;
	cin >> q;
	while(q--){
		int n, ans=0;
		cin >> n;
		while(n >= 10){
			n = multi_max(n);
			ans++;
		}
		cout << ans << endl;
	}
	return 0;
}
