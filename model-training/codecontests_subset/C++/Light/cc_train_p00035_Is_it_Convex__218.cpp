#include <stdio.h>
#define S(x,y,a,b,l,r) ((x*b+a*r+l*y-y*a-l*b-r*x)>0?0:((x*b+a*r+l*y-y*a-l*b-r*x)<0?1:2))
int main() {double a,b,c,d,o,p,q,r;while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&a,&b,&c,&d,&o,&p,&q,&r)!=EOF) {int T[4]={0,0,0,0};T[S(a,b,c,d,o,p)]++,T[S(c,d,o,p,q,r)]++,T[S(o,p,q,r,a,b)]++,T[S(q,r,a,b,c,d)]++;if (T[0]&&T[1]) puts("NO"); else puts("YES");} return 0;}