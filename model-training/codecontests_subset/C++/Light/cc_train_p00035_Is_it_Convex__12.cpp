#include <iostream>
#include <stdio.h>
using namespace std;

class Vec
{
public:
	double x, y;
	Vec(double x, double y) : x(x), y(y){}
	Vec(){}

	Vec operator-(Vec v)
	{
		return Vec(x - v.x, y - v.y);
	}
	double GetCp(Vec v)
	{
		return (x * v.y - y * v.x);
	}
};

bool IsHit(Vec a, Vec b, Vec c, Vec p)
{
	double A = (b - a).GetCp(p - a);
	double B = (c - b).GetCp(p - b);
	double C = (a - c).GetCp(p - c);

	return (A >= 0 && B >= 0 && C >= 0) || (A <= 0 && B <= 0 && C <= 0);
}


int main()
{
	Vec v[4];
	while (true)
	{
		for (int i = 0; i < 4; i++)
		{
			if (scanf("%lf,", &(v[i].x)) == -1) return 0;
			if (scanf("%lf,", &(v[i].y)) == -1) return 0;
		}

		if (IsHit(v[0], v[1], v[2], v[3]) ||
			IsHit(v[3], v[0], v[1], v[2]) ||
			IsHit(v[2], v[3], v[0], v[1]) ||
			IsHit(v[1], v[2], v[3], v[0]))
		{
			cout << "NO" << endl;
		}
		else
		{
			cout << "YES" << endl;
		}
	}

	return 0;
}