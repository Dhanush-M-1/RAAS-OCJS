#include<iostream>
#include<complex>
#include<vector>
using namespace std;
typedef complex < double > P;
typedef vector< P > G;
struct L:public vector< P >{ // L:線分
  L(const P& a,const P& b){push_back(a);push_back(b);}
};
const double EPS = 1e-8;
const double INF = 1e12;
double cross(const P& a,const P& b){
  return imag(conj(a) * b);
}
double dot(const P& a,const P& b){
  return real(conj(a) * b);
}
int ccw(P a,P b,P c){
  b -= a; c -= a;
  if(cross(b,c) > 0) return 1;
  if(cross(b,c) < 0) return -1;
  if(dot(b,c) < 0) return 2; // c--a--b
  if(norm(b) < norm(c)) return -2; // a--b--c
  return 0; // a--c--b
}
bool intersect(const L& s,const L& t){
  return ccw(s[0],s[1],t[0]) * ccw(s[0],s[1],t[1]) <= 0 &&
    ccw(t[0],t[1],s[0]) * ccw(t[0],t[1],s[1]) <= 0;
}
bool isconvex(const G& g){
  return intersect(L(g[0],g[2]),L(g[1],g[3])) && intersect(L(g[1],g[3]),L(g[0],g[2]));
}
int main(){
  double x1,y1,x2,y2,x3,y3,x4,y4;
  char o;
  while(cin >> x1 >> o >> y1 >> o >> x2 >> o >> y2 >> o >> x3 >> o >> y3 >> o >> x4 >> o >> y4){
    G g(4);
    g[0] = P(x1,y1);
    g[1] = P(x2,y2);
    g[2] = P(x3,y3);
    g[3] = P(x4,y4);
    cout << (isconvex(g) ? "YES" : "NO") << endl;
  }
}