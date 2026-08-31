#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	const double PI = acos(-1);
	double x[4], y[4];
	char c;

	while (cin >> x[0] >> c >> y[0] >> c >> x[1] >> c >> y[1] >> c
				>> x[2] >> c >> y[2] >> c >> x[3] >> c >> y[3]) {

		bool f = 1;
		int s = 0;

		double t = atan2(y[2] - y[1], x[2] - x[1]) - atan2(y[1] - y[0], x[1] - x[0]);

		if (t > 0)
			s = 1;

		for (int i = 1; i < 4; i++) {
			int j = (i + 1) % 4, k = (i + 2) % 4;
			t = atan2(y[k] - y[j], x[k] - x[j]) - atan2(y[j] - y[i], x[j] - x[i]);

			if (t < -PI)
				t += PI * 2;
			else if (t > PI)
				t -= PI * 2;

			if (!((s == 1 && t > 0) || (s == 0 && t < 0))) {
				f = 0;
				break;
			}
		}

		if (f)
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}

	return 0;
}
