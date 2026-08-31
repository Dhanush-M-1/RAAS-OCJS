#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, i, j;
  int sum, c;
  int ara[101];
  scanf("%d %d", &n, &k);
  for (i = 0; i < n; i++) {
    scanf("%d", &ara[i]);
  }
  sum = 10000;
  for (i = 0; i < n; i++) {
    if (k % ara[i] == 0) {
      c = k / ara[i];
    }
    if (c < sum) {
      sum = c;
    }
  }
  printf("%d\n", sum);
  return 0;
}
