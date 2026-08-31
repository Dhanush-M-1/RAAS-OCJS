#include<bits/stdc++.h>
#define _ ios_base::sync_with_stdio(0);cin.tie(0);
#define REP(i,n) for(int i=0;i<(int)(n);i++)

using namespace std;

typedef long double ld;
typedef complex<ld> Point;
const ld eps = 1e-8, pi = acos(-1.0);
bool eq(ld a, ld b){return (abs(b-a)<eps);}
ld dot(Point a, Point b){return real(conj(a)*b);}
ld cross(Point a, Point b){ return imag(conj(a)*b);}
int ccw(Point a, Point b, Point c){
  b-=a;c-=a;
  if(cross(b,c)>eps) return 1;//countor_crockwise
  if(cross(b,c)<-eps) return -1;//crockwise
  if(dot(b,c)<0) return 2;//c,a,b
  if(norm(b)<norm(c)) return -2;//a,b,c
  return 0;//a,c,b
}

int main(){
  ld xa,ya,xb,yb,xc,yc,xd,yd;
  Point a,b,c,d;
  while(scanf("%Lf,%Lf,%Lf,%Lf,%Lf,%Lf,%Lf,%Lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=-1){
    a=Point(xa,ya);
    b=Point(xb,yb);
    c=Point(xc,yc);
    d=Point(xd,yd);
    int abc = ccw(a,b,c);
    int bcd = ccw(b,c,d);
    int cda = ccw(c,d,a);
    int dab = ccw(d,a,b);
    if((abc==1&&bcd==1&&cda==1&&dab==1)||(abc==-1&&bcd==-1&&cda==-1&&dab==-1))
      cout<<"YES"<<endl;
    else
      cout<<"NO"<<endl;
  }
}