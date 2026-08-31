#include <cstdio>

using namespace std;

int main(){
  float p[4][2];
  while(scanf("%f,%f,%f,%f,%f,%f,%f,%f"
	      ,&p[0][0],&p[0][1],&p[1][0],&p[1][1],&p[2][0],&p[2][1],&p[3][0],&p[3][1])>0){
    for(int i=0;i<4;i++){
      int n,m;
      float a1,a2,b1,b2,xp,yp,A,B;
      a1=p[(i+1)%4][0]-p[i%4][0];
      a2=p[(i+1)%4][1]-p[i%4][1];
      b1=p[(i+3)%4][0]-p[i%4][0];
      b2=p[(i+3)%4][1]-p[i%4][1];
      xp=p[(i+2)%4][0]-p[i%4][0];
      yp=p[(i+2)%4][1]-p[i%4][1];
      A=(b1*yp-b2*xp)/(a2*b1-a1*b2);
      B=(a2*xp-a1*yp)/(a2*b1-a1*b2);
      if(A+B<1&&A>0&&B>0){
	printf("NO\n");
	break;
      }
      if(i==3) printf("YES\n");
    }
  }
    return 0;
  }