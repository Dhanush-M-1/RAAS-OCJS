#include <stdio.h>

int main(void) {
  double x[4], y[4];
  int i, j;
  while(scanf("%lf,%lf", &x[0], &y[0]) != EOF) {
    for(i = 1; i < 4; ++i) scanf(",%lf,%lf", &x[i], &y[i]);
    int s, ans = 1;
    if((x[1] - x[0]) * (y[2] - y[0]) - (y[1] - y[0]) * (x[2] - x[0]) > 0) s = 1;
    else s = 0;
    for(i = 1; i < 4; ++i) {
      double tmp = (x[(i + 1) % 4] - x[i]) * (y[(i + 2) % 4] - y[i]) - (y[(i + 1) % 4] - y[i]) * (x[(i + 2) % 4] - x[i]);
      if((s && tmp < 0) || (!s && tmp > 0)) {
        ans = 0;
        break;
      }
    }
    if(ans) printf("YES\n");
    else printf("NO\n");
  }
  return 0;
}
