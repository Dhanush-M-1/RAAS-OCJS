#include <iostream>
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <vector>
#include <string>
#include <map>
#include <queue>
#include <stack>
#include <algorithm>

#define rep(i,j) REP((i), 0, (j))
#define REP(i,j,k) for(int i=(j);(i)<(k);++i)
#define between(a,x,b) ((a)<=(x)&&(x)<=(b))
using namespace std;

typedef struct POINT_tag{ double x, y;}POINT_t;
typedef struct LINE_tag{ POINT_t a, b;}LINE_t;

int side(POINT_t *p, LINE_t *e){
  POINT_t p1 = *p;
  POINT_t p2 = e->a;
  POINT_t p3 = e->b;

  const int n = p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y);
  if (n > 0) return 1;
  else if(n < 0) return -1;
  else return 0;
}

int main(){
  POINT_t a, b, c, d;
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&a.x,&a.y,&b.x,&b.y,&c.x,&c.y,&d.x,&d.y) != EOF){
    LINE_t ac, bd;
    ac.a = a; ac.b = c;
    bd.a = b; bd.b = d;
    if(side(&a, &bd) != side(&c, &bd) && side(&b, &ac) != side(&d, &ac)) puts("YES");
    else puts("NO");
  }
  return 0;
}