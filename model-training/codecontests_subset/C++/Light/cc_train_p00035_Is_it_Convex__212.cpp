#include<iostream>
using namespace std;

struct Point{
  double x,y;
  void init(double a,double b){x=a;y=b;}
  bool turn(Point p){return (x*p.y - y*p.x)>=0;}
};

int main()
{
  Point A,B,C,D,AB,BC,CD,DA;
  while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&A.x,&A.y,&B.x,&B.y,&C.x,&C.y,&D.x,&D.y)){
    AB.init(B.x-A.x,B.y-A.y);
    BC.init(C.x-B.x,C.y-B.y);
    CD.init(D.x-C.x,D.y-C.y);
    DA.init(A.x-D.x,A.y-D.y);
    if( (AB.turn(BC)==BC.turn(CD))&&(BC.turn(CD)==CD.turn(DA))&&(CD.turn(DA)==DA.turn(AB)) )puts("YES");
    else puts("NO");
  }
}