#include <cstdio>

using namespace std;

struct Point {
	double x, y;
	Point(double x = 0, double y = 0) : x(x), y(y){}
	Point operator - (Point p) {return (Point(x - p.x, y - p.y));}
};

double cross(Point a, Point b)
{
	return (a.x * b.y - a.y * b.x);
}

int ccw(Point x, Point y)
{
	if (cross(x, y) > 0) return (+1);
	return (0);
}

int main()
{
	Point a, b, c, d;
	
	while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &a.x, &a.y, &b.x, &b.y, &c.x, &c.y, &d.x, &d.y) != EOF){
		int dir = ccw(b - a, c - a) + ccw(c - b, d - b) + ccw(d - c, a - c) + ccw(a - d, b - d);
		printf("%s\n", dir % 4 ? "NO" : "YES");
	}
	return (0);
}