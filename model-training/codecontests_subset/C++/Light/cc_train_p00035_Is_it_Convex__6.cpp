#include<iostream>
#include<cstdio>
using namespace std;
struct POS{
  double x;
  double y;
};
bool cross(POS a, POS b, POS c, POS d);
int main(){
  POS a,b,c,d;
  for(;;){
    if(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&(a.x),&(a.y),&(b.x),&(b.y),&(c.x),&(c.y),&(d.x),&(d.y)) == EOF) break;
    if(cross(a,c,b,d) && cross(b,d,a,c)) cout <<"YES"<<endl;
    else cout<<"NO"<<endl;
  }
  return 0;
}
bool cross(POS a, POS b, POS c, POS d){
  POS v,w,u;
  v.x = a.x-b.x;
  v.y = a.y-b.y;
  w.x = c.x-b.x;
  w.y = c.y-b.y;
  u.x = d.x-b.x;
  u.y = d.y-b.y;
  return (v.x*w.y-v.y*w.x)*(v.x*u.y-v.y*u.x)<0;
}