#include <iostream>
#define llint long long

using namespace std;

llint T;

llint gcd(llint a, llint b)
{
	if(b == 0) return a;
	return gcd(b, a%b);
}

int main(void)
{
	cin >> T;
	llint a, b, c, d;
	llint g, i, mx;
	for(int t = 0; t < T; t++){
		cin >> a >> b >> c >> d;
		if(a < b) goto ng;
		if(d < b) goto ng;
		
		g = gcd(b, d);
		i = a % b;
		mx = ((b-1)-i)/g*g + i;
		if(mx > c) goto ng;
		else goto ok;
		
		ok:
		cout << "Yes" << endl;
		continue;
		ng:
		cout << "No" << endl;
		continue;
	}
	return 0;
}