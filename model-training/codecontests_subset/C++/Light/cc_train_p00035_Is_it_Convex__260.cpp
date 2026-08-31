#include <cstdio>
#include <cmath>

using namespace std;

int main(void){
  double x[4], y[4];
  double p[4];
  
  while (scanf("%lf,%lf,", &x[0], &y[0])>0){
    scanf("%lf,%lf,%lf,%lf,%lf,%lf", &x[1], &y[1], &x[2], &y[2], &x[3], &y[3]);
    for (int i=0; i<4; i++){
      int j=(i+1)%4;
      int k=(i+2)%4;
      p[i] = (x[j]-x[i])*(y[k]-y[j])-(x[k]-x[j])*(y[j]-y[i]);
      //printf("%lf\n", p[i]);
    }
    puts(p[0]*p[1]<0||p[1]*p[2]<0||p[2]*p[3]<0||p[3]*p[0]<0 ? "NO": "YES");
  }
  return 0;
}
