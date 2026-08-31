#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int x[n], h[n];
  for (int i = 0; i < n; i++) scanf("%d %d", &x[i], &h[i]);
  if (n < 2) {
    printf("%d", n);
    return 0;
  }
  int ans = 2;
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > x[i - 1])
      ans++;
    else if (x[i] + h[i] < x[i + 1]) {
      x[i] = x[i] + h[i];
      ans++;
    }
  }
  printf("%d", ans);
  return 0;
}
