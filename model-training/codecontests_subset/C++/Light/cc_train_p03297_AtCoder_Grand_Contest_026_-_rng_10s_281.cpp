#include <bits/stdc++.h>

using namespace std;

typedef unsigned long long ull;
typedef long long ll;

ll gcd(ll a, ll b){
	if(a<b) swap(a, b);
	if(b==0) return a;
	return gcd(b, a%b);
}

int main(){
	int t;
	cin >> t;
	for(int i=0; i<t; i++){
		ll a, b, c, d;
		cin >> a >> b >> c >> d;
		if(a<b || d<b) cout << "No" << endl;
		else if(b-1<=c) cout << "Yes" << endl;
		else{
			ll g=gcd(b, d);
			if(b-g+a%g<=c) cout << "Yes" << endl;
			else cout << "No" << endl;
		}
	}
	return 0;
}