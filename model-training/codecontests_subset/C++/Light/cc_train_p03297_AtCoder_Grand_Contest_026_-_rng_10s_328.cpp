#include <iostream>
using namespace std;

long long gcd(long long x, long long y){
	if (y == 0)
		return x;
	return gcd(y, x % y);
}
int main(){
	int T;
	cin >> T;
	while (T --){
		long long a, b, c, d;
		cin >> a >> b >> c >> d;
		if (a < b)
			cout << "No" << endl;
		else if (b > d)
			cout << "No" << endl;
		else if (c >= b - 1)
			cout << "Yes" << endl;
		else{
		//	a %= b, c %= b, d %= b;
			long long g = gcd(d, b);
			if ((a - b) / g < (a - c - 1) / g)
				cout << "No" << endl;
			else
				cout << "Yes" << endl;
		}
	}
}
