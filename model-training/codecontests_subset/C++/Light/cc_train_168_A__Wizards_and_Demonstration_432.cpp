#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n, x, k;
  scanf("%d %d %d", &n, &x, &k);
  if (k > 100) {
    k -= 100;
    double percentage = (double)n * (double)k / 100.0;
    int v = ceil(percentage);
    v += n;
    printf("%d", x >= v ? 0 : abs(x - v));
  } else {
    double percentage = (double)n * (double)k / 100.0;
    int v = ceil(percentage);
    printf("%d", x >= v ? 0 : abs(x - v));
  }
}
