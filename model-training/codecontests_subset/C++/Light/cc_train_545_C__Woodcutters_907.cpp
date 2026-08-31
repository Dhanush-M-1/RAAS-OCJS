#include <bits/stdc++.h>
using namespace std;
int n, t[1 << 17], h[1 << 17], w;
int dp(int i, int &l) {
  l = t[i];
  if (i == n - 1) return 1;
  int r, m = dp(i + 1, r);
  if (!i || t[i] + h[i] < r) return m + 1;
  if (t[i] - h[i] <= t[i - 1]) return m;
  l = t[i] - h[i];
  return m + 1;
}
int main(void) {
  scanf("%d", &n);
  for (int i(0); i < n; ++i) scanf("%d%d", &t[i], &h[i]);
  printf("%d\n", dp(0, w));
  return 0;
}
