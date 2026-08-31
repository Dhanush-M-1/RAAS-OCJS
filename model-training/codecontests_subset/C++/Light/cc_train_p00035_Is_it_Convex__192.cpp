#include <cstdio>
#include <iostream>
using namespace std;

double line(double x,double x1,double y1,double x2,double y2){
	return (y1-y2)/(x1-x2)*(x-x1)+y1;
}

int main(){
	double x1,x2,y1,y2,x3,y3,x4,y4;

	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x1,&y1,&x2,&y2,&x3,&y3,&x4,&y4)!=EOF){
		if((line(x2,x1,y1,x3,y3)-y2)*(line(x4,x1,y1,x3,y3)-y4)>0 || (line(x1,x2,y2,x4,y4)-y1)*(line(x3,x2,y2,x4,y4)-y3)>0){
			cout<<"NO"<<endl;
		}else{
			cout<<"YES"<<endl;
		}
	}

	return 0;
}