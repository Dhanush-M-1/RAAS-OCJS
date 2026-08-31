#include <iostream>
#include <cmath>
#include <vector>

using namespace std;
typedef pair<double, double> P;

double Helon(P a, P b, P c)
{
	double square = 0;
	double x, y, z;
	x = sqrt((b.first - a.first) * (b.first - a.first) + (b.second - a.second) * (b.second - a.second));
	y = sqrt((c.first - a.first) * (c.first - a.first) + (c.second - a.second) * (c.second - a.second));
	z = sqrt((c.first - b.first) * (c.first - b.first) + (c.second - b.second) * (c.second - b.second));
	double s = (x + y + z) / 2;
	square = sqrt(s * (s - x) * (s - y) * (s - z));
	return(square);
}

void solve()
{
	vector<P> Vec(4);
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &Vec[0].first, &Vec[0].second, 
													&Vec[1].first, &Vec[1].second, 
													&Vec[2].first, &Vec[2].second, 
													&Vec[3].first, &Vec[3].second))
	{
		double square1 = 0;
		square1 += Helon(Vec[0], Vec[1], Vec[2]);
		square1 += Helon(Vec[0], Vec[2], Vec[3]);
		double square2 = 0;
		square2 += Helon(Vec[0], Vec[1], Vec[3]);
		square2 += Helon(Vec[1], Vec[2], Vec[3]);
		if(fabs(square1 - square2) < 0.00000000001)
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