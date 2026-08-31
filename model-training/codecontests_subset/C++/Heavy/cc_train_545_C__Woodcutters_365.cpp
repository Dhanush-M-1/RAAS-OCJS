#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int x[n];
  int h[n];
  int o[n];
  int trees = 1;
  if (n == 1) {
    printf("1\n");
    return 0;
  }
  for (int i = 0; i < (n); i++) {
    scanf("%d %d", &(x[i]), &(h[i]));
    o[i] = 0;
  }
  o[0] = -1;
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > x[i - 1] + o[i - 1] * h[i - 1] &&
        x[i] - h[i] > x[i - 1]) {
      trees++;
      o[i] = -1;
    } else {
      if (x[i] + h[i] < x[i + 1]) {
        o[i] = 1;
        trees++;
      } else {
        if (x[i] - h[i] > x[i - 1]) {
          o[i] = -1;
        }
      }
    }
  }
  trees++;
  printf("%d\n", trees);
  return 0;
}
