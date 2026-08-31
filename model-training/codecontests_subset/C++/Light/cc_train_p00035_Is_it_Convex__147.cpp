#include <bits/stdc++.h>

using namespace std;

#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define REP(i,a) FOR(i,0,a)

struct Point{
	double x,y;
	Point operator - (const Point a){
		Point res;
		res.x=x-a.x;
		res.y=y-a.y;
		return res;
	}
};

typedef Point Vector;

double cross(Vector a,Vector b){
	return a.x*b.y-a.y*b.x;
}

Vector v[4];

double c[4];

int main(){
	while (1){
		if (scanf("%lf,%lf,",&v[0].x,&v[0].y)==EOF) break;
		FOR(i,1,4){
			scanf("%lf,%lf,",&v[i].x,&v[i].y);
		}
		bool flg=true;
		REP(i,4){
			c[i]=cross(v[(i+1)%4]-v[i],v[(i+2)%4]-v[(i+1)%4]);
		}
		REP(i,4){
			if (c[i]*c[(i+1)%4]<0) flg=false;
		}
		if (flg){
			printf("YES\n");
		}
		else{
			printf("NO\n");
		}
	}
	return 0;
}