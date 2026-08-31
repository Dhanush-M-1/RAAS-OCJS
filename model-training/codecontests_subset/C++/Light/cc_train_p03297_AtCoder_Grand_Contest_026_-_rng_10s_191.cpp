#include <iostream>
#include <algorithm>
using namespace std;

long long gcd(long long p, long long q) {
	if (q == 0)
		return p;
	else
		gcd(q, p % q);
}

int main()
{
	int t;
	long long a, b, c, d;

	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> a >> b >> c >> d;

		long long g = gcd(b, d);

		if (a >= b && b <= d && g >= b - c && a % g <= c)
			cout << "Yes" << endl;
		else
			cout << "No" << endl;
	}

	return 0;
}