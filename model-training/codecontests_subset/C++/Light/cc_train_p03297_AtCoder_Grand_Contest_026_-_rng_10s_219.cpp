#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll gcd(ll x, ll y){
	if(x < y)
		return gcd(y, x);
	if(y == 0)
		return x;
	return gcd(y, x%y);
}

int main(){
	long long a, b, c, d;
	int t;
	cin >> t;
	while(t--){
		cin >> a >> b >> c >> d;
		ll g = gcd(d, b);	
		ll r = a - (a/g)*g - g;
		if(a < b || d < b || c < b-1 && c-b < r)
			cout << "No\n";
		else cout << "Yes\n";
	}
	return 0;
}