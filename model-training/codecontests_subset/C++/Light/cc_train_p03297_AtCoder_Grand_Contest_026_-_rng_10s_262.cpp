#include <iostream>
#define ll long long
using namespace std;

ll gcd(ll a, ll b){
	if(a%b>0) return gcd(b, a%b);
	return b;
}

bool judge(ll a, ll b, ll c, ll d){
	if(min(a, d)<b) return false;
	ll n=gcd(b, d);
	ll r=c/n;
	if(a%n>c%n) --r;
	return r+1 > b/n-1;
}

int main() {
	int T;
	cin >> T;
	ll A, B, C, D;
	for(int t=0; t<T; ++t){
		cin >> A >> B >> C >> D;
		if(judge(A, B, C, D)) cout << "Yes" << endl;
		else cout << "No" << endl;
	}
	return 0;
}