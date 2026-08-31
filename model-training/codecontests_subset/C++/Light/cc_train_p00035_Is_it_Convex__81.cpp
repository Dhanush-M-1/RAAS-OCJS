#include <iostream>
#include <stdio.h>
using namespace std;
int main() {
  double x[4],y[4];
  double x1,y1,x2,y2,x3,y3;
  int i;
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3])!=EOF) {
	  for (i=0;i<4;i++) {
		  x1=x[(i+2) % 4]-x[i]; y1=y[(i+2) % 4]-y[i];
		  x2=x[(i+2) % 4]-x[(i+3) % 4]; y2=y[(i+2) % 4]-y[(i+3) % 4];
          x3=x[(i+2) % 4]-x[(i+1) % 4]; y3=y[(i+2) % 4]-y[(i+1) % 4];
		  if ((x1*x2+y1*y2+x1*x3+y1*y3)<=0) { i=10; break; }
	  }
	  if (i<10) cout << "YES" << endl; else cout << "NO" << endl;
  }
  return 0;
  }