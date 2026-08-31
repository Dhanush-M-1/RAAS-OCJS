//http://www5d.biglobe.ne.jp/~tomoya03/shtml/algorithm/Intersection.htm　参照
#include<cstdio>

using namespace std;

int main(void){
	float xa,ya,xb,yb,xc,yc,xd,yd;
	float ta,tb,tc,td;

	while((scanf("%f,%f,%f,%f,%f,%f,%f,%f",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd))!=EOF){
		ta=(xb-xd)*(ya-yb)+(yb-yd)*(xb-xa);
		tb=(xa-xc)*(yb-ya)+(ya-yc)*(xa-xb);
		tc=(xb-xd)*(yc-yb)+(yb-yd)*(xb-xc);
		td=(xa-xc)*(yd-ya)+(ya-yc)*(xa-xd);
		if(ta*tc<0 && tb*td<0)	printf("YES\n");
		else	printf("NO\n");
	}

	return 0;
}