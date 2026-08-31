#include <iostream>
using namespace std;

struct point{
	double x;
	double y;
};

int ccw(point p0, point p1, point p2){
	double dx1 = p1.x - p0.x, dy1 = p1.y - p0.y;
	double dx2 = p2.x - p0.x, dy2 = p2.y - p0.y;
	if(dy2 * dx1 > dy1 * dx2) return 1;
	else return -1;
}

int main(){
	point a, b, c, d;
	char ch;
	while(cin >> a.x >> ch >> a.y >> ch >> b.x >> ch >> b.y
		>> ch >> c.x >> ch >> c.y >> ch >> d.x >> ch >> d.y)
	{
		if((ccw(a,c,b) != ccw(a,c,d)) && (ccw(b,d,a) != ccw(b,d,c))){
			cout << "YES" << endl;
		} else {
			cout << "NO" << endl;
		}
	}
	return 0;
}