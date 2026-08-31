#include <iostream>
using namespace std;

int main(){
  double x[4], y[4];
  double xa, ya, xb, yb;
  char c;
  int checkConvex;
  int i;

  while(cin>>x[0]>>c>>y[0]){
    for(i=1; i<4; i++) cin>>c>>x[i]>>c>>y[i];

    checkConvex=0;
    for(i=1; i<=4; i++){
      xa=x[i-1]-x[i%4]; ya=y[i-1]-y[i%4];
      xb=x[(i+1)%4]-x[i%4]; yb=y[(i+1)%4]-y[i%4];
      if(xa*yb-ya*xb>0) checkConvex++;
      else checkConvex--;
    }
    if(checkConvex==4 || checkConvex==-4) printf("YES\n");
    else printf("NO\n");
  }

  return 0;
}