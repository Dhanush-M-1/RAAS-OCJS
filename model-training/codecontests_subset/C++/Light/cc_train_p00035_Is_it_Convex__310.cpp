#include<iostream>
#include<cstdio>
#include<algorithm>
#include<string>

struct point{
	double x;
	double y;
};

using namespace std;

int ch(point p1, point p2, point p3){
	double dx1=p2.x-p1.x, dy1=p2.y-p1.y;
	double dx2=p3.x-p1.x, dy2=p3.y-p1.y;
	if(dx1*dy2>dx2*dy1)
	return 0;
	else
	return 1;
}

int main(){
	point a,b,c,d;
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&a.x,&a.y,&b.x,&b.y,&c.x,&c.y,&d.x,&d.y)!=EOF){
		//scanf("%d,%d,%d,%d,%d,%d,%d,%d",&a.x,&a.y,&b.x,&b.y,&c.x,&c.y,&d.x,&d.y);
		if(ch(a,c,b)!=ch(a,c,d) && ch(b,d,a)!=ch(b,d,c))
		printf("YES\n");
		else
		printf("NO\n");
	}
}