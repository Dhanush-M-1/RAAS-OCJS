#include <bits/stdc++.h>
#define PI 3.14159265359
using namespace std;

int main() {
	typedef struct zahyou {
		double x, y;
	} z;

	z a, b, c, d;
	char ch;
	while (cin >> a.x) {
		cin >> ch >> a.y >> ch >> b.x >> ch >> b.y >> ch >> c.x >> ch >> c.y
		>> ch >> d.x >> ch >> d.y;
		//cout << a.x << ' ' << a.y << endl;
		//cout << b.x << ' ' << b.y << endl;
		//cout << c.x << ' ' << c.y << endl;
		//cout << d.x << ' ' << d.y << endl;

		int f = 0;
		double n, m;

		n = (a.x - c.x) * (b.y - a.y) - (a.y - c.y) * (b.x - a.x);
		m = (a.x - c.x) * (d.y - a.y) - (a.y - c.y) * (d.x - a.x);
		//cout << fixed << setprecision(4) << n << ' ' << m << endl;
		if (n * m > 0) f = 1;

		n = (b.x - d.x) * (a.y - b.y) - (b.y - d.y) * (a.x - b.x);
		m = (b.x - d.x) * (c.y - b.y) - (b.y - d.y) * (c.x - b.x);
		//cout << fixed << setprecision(4) << n << ' ' << m << endl;
		if (n * m > 0) f = 1;

		if (!f) {
			cout << "YES" << endl;
		}
		else {
			cout << "NO" << endl;
		}
	}
}
