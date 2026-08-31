#include<iostream>
#include<cstdio>
#define dff 1e-19
using namespace std;
struct vec{
  double x;
  double y;
};
bool cross(vec a, vec b, vec x, vec y);
int main(){
  for(;;){
    vec a,b,c,d;
    if(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&(a.x),&(a.y),&(b.x),&(b.y),&(c.x),&(c.y),&(d.x),&(d.y)) == EOF) break;
    if(cross(a,c,b,d) && cross(b,d,a,c)) cout <<"YES"<<endl;
    else cout <<"NO"<<endl;
  }
  return 0;
}
bool cross(vec a, vec b, vec x, vec y){
  vec p,q,r;
  p.x = b.x-a.x;
  p.y = b.y-a.y;
  q.x = x.x-a.x;
  q.y = x.y-a.y;
  r.x = y.x-a.x;
  r.y = y.y-a.y;
  if((p.x*q.y-p.y*q.x)*(p.x*r.y-p.y*r.x)<dff) return true;
  return false;
}