#include <iostream>
#include <cstdio>

class Point{
public:
	Point();
	Point(double _x, double _y);
	double x, y;
};

Point::Point() : x(0), y(0){}
Point::Point(double _x, double _y) : x(_x), y(_y){}

class Vector{
	//private:

public:
	Vector();
	Vector(double _x, double _y);
	Vector(Point p1, Point p2);
	double x, y;
};

Vector::Vector() : x(0), y(0){}
Vector::Vector(double _x, double _y) : x(_x), y(_y){}
Vector::Vector(Point p1, Point p2) : x(p1.x-p2.x), y(p1.y-p2.y){}

int extproduct(Vector v1, Vector v2){
	return v1.x*v2.y - v1.y*v2.x;
}

int main(){
	Point ps[4];
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &ps[0].x, &ps[0].y, &ps[1].x, &ps[1].y, &ps[2].x, &ps[2].y, &ps[3].x, &ps[3].y)){
		int res = 0;
		for(int i=0;i<4;i++){
			int count = 0;
			Vector vs[4];
			vs[0] = Vector(ps[(i+1)%4], ps[(i+2)%4]);
			vs[1] = Vector(ps[(i+2)%4], ps[(i+3)%4]);
			vs[2] = Vector(ps[(i+1)%4], ps[(i+3)%4]);
			for(int j=0;j<3;j++){
				vs[3] = Vector(ps[(i+j+1)%4], ps[i]);
				if(extproduct(vs[j], vs[3]) > 0)count++;
				else count--;
			}
			if(count == 3 || count == -3)res++;
		}
		if(res == 4)puts("YES");
		else puts("NO");
	}
}