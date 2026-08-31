//0035 s it Convex

//http://www5d.biglobe.ne.jp/~tomoya03/shtml/algorithm/Intersection.htm ±±©çl¦qØ

#include<iostream>
using namespace std;

struct Point
{
	double x, y;
	Point(double x,double y):x(x), y(y){}
	Point(){}
};

inline double AngleFromLine(const Point &p1, const Point &p2, const Point &to)
{
	//(x1-x2)*(y-y1)+(y1-y2)*(x1-x)=0@ª¼üÌ®
	return ((p1.x-p2.x)*(to.y-p1.y)+(p1.y-p2.y)*(p1.x-to.x));
}

int main(void)
{
	const int N = 4;
	while(1)
	{
		Point p[N];
		char dummy;
		int i;
		for(i = 0; i < N; i++)
		{
			if(i)
				cin >> dummy;
			cin >> p[i].x >> dummy >> p[i].y;
		}
		if(!cin)
			break;

		double last = 0;	//OñÌü«»èÌÊ@0Í¼üó¾©ç¡ñÌâèÅÍ¶ÝµÈ¢
		double current;
		bool isConvex = true;	//ÊH
		for(i = 0; i < N; i++)
		{
			current = AngleFromLine(p[i], p[(i+1)%N], p[(i+2)%N]);
			//OñÆü«ªá¦ÎAÏÍ}CiXÉÈé
			if(last * current < 0)
			{
				isConvex = false;
				break;
			}
			last = current;
		}

		cout << (isConvex ? "YES": "NO") << endl;
	}
	return 0;
}