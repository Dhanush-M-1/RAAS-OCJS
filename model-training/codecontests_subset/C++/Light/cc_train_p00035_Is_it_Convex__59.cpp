#include <iostream>
#include <stdio.h>

using namespace std;

bool check(double x1, double y1, double x2, double y2, double x3, double y3);

int main(void){
  double xa,ya,xb,yb,xc,yc,xd,yd;
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=EOF){
    if(check(xa,ya,xb,yb,xc,yc) && check(xb,yb,xc,yc,xd,yd) && check(xc,yc,xd,yd,xa,ya) && check(xd,yd,xa,ya,xb,yb)){
      cout<<"YES"<<endl;
    }
    else if(!check(xa,ya,xb,yb,xc,yc) && !check(xb,yb,xc,yc,xd,yd) && !check(xc,yc,xd,yd,xa,ya) && !check(xd,yd,xa,ya,xb,yb)){
      cout<<"YES"<<endl;
    }
    else{
      cout<<"NO"<<endl;
    }
  }
}

bool check(double x1, double y1, double x2, double y2, double x3, double y3){
  double z;
  z=(x1-x2)*(y3-y2)-(x3-x2)*(y1-y2);
  if(z>0){
    return true;
  }
  else{
    return false;
  }
}

