#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;
typedef pair<double, double> P;

double Helon(P pa, P pb, P pc)
{
	double a, b, c;
	a = sqrt((pb.first - pa.first) * (pb.first - pa.first) + (pb.second - pa.second) * (pb.second - pa.second));
	b = sqrt((pc.first - pb.first) * (pc.first - pb.first) + (pc.second - pb.second) * (pc.second - pb.second));
	c = sqrt((pa.first - pc.first) * (pa.first - pc.first) + (pa.second - pc.second) * (pa.second - pc.second));
	double s = (a + b + c) / 2;
	return(sqrt(s * (s - a) * (s - b) * (s - c)));
}

void solve()
{
	vector<P> p(4);
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &p[0].first, &p[0].second, &p[1].first, &p[1].second, &p[2].first, &p[2].second, &p[3].first, &p[3].second))
	{
		double S1, S2;
		S1 = Helon(p[0], p[1], p[2]);
		S1 += Helon(p[0], p[2], p[3]);

		S2 = Helon(p[0], p[1], p[3]);
		S2 += Helon(p[1], p[2], p[3]);
		if(fabs(S1 - S2) < 1e-10)
		{
			cout << "YES" << endl;
		}
		else
		{
			cout << "NO" << endl;
		}
	}
}

int main()
{
	solve();
	return(0);
}