#include<cstdio>
#include<iostream>
#include<cmath>

using namespace std;

int main(void){

	double xa,ya,xb,yb,xc,yc,xd,yd;
	double sikaku;

	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=EOF){
		sikaku=abs(((xa*yb+xb*yc+xc*yd+xd*ya)-(xb*ya+xc*yb+xd*yc+xa*yd))/2);
		xb-=xa,xc-=xa,xd-=xa,xa=0;
		yb-=ya,yc-=ya,yd-=ya,ya=0;
		if(sikaku==(abs((xb*yc-yb*xc)/2)+abs((xc*yd-yc*xd)/2))){
			xa-=xd,xb-=xd,xc-=xd,xd=0;
			ya-=yd,yb-=yd,yc-=yd,yd=0;
			if(sikaku==(abs((xb*ya-yb*xa)/2)+abs((xc*yb-yc*xb)/2))) cout<<"YES"<<endl;
			else cout<<"NO"<<endl;
		}
		else cout<<"NO"<<endl;

	}

	return 0;
}