#include <iostream>
#include <vector>
#define llint long long

using namespace std;

llint T;
llint a, b, c, d;

llint gcd(llint a, llint b){
	if(b == 0) return a;
	return gcd(b, a%b);
}

int main(void)
{
	cin >> T;
	for(int t = 0; t < T; t++){
		cin >> a >> b >> c >> d;
		if(d < b || a < b){
			cout << "No" << endl;
			continue;
		}
		if(c >= b){
			cout << "Yes" << endl;
			continue;
		}
		llint g = gcd(b, d);
		a = a%b%g;
		a = (a+b-g)%b;
		if(a > c) cout << "No" << endl;
		else cout << "Yes" << endl;
	}
	
	return 0;
}