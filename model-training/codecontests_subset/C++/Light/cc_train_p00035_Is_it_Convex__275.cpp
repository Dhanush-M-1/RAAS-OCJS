#include <iostream>
#include <cstdio>
#include <cmath>
using namespace std;

struct Vec2d{
  double x,y;
};

double cross(Vec2d &A, Vec2d &B){
  return A.x*B.y - A.y*B.x;
}

int main(void){
  double x[4],y[4];
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3])!=EOF){
    bool f=true;
    for(int i=0;i<4;++i){
      double xx[3],yy[3];
      double xp = x[i], yp = y[i];
      int cnt=0;
      for(int j=0;j<4;++j){
        if(i==j) continue;
        xx[cnt] = x[j];
        yy[cnt] = y[j];
        ++cnt;
      }
      Vec2d AB,AP,BC,BP,CA,CP;
      AB.x = xx[1]-xx[0]; AB.y = yy[1]-yy[0];
      BC.x = xx[2]-xx[1]; BC.y = yy[2]-yy[1];
      CA.x = xx[0]-xx[2]; CA.y = yy[0]-yy[2];
      AP.x = xp-xx[0]; AP.y = yp-yy[0];
      BP.x = xp-xx[1]; BP.y = yp-yy[1];
      CP.x = xp-xx[2]; CP.y = yp-yy[2];
      if(cross(AB,AP)>0.0 && cross(BC,BP)>0.0 && cross(CA,CP)>0.0)
        f=false;
      else if(cross(AB,AP)<0.0 && cross(BC,BP)<0.0 && cross(CA,CP)<0.0)
        f=false;
      else ;
    }
    cout<<((f)?"YES":"NO")<<endl;
  }
  return 0;
}