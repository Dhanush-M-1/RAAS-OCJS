#include <bits/stdc++.h>
int solve(int n, int S) {
  int k = ((2 * S) / n) + 1;
  assert(n * k - S > S);
  assert(n * (k - 1) - S <= S);
  return k;
}
int main() {
  int n;
  scanf("%d", &n);
  int mx = -1;
  int S = 0;
  for (int i = 0; i < n; ++i) {
    int t;
    scanf("%d", &t);
    S += t;
    mx = std::max(mx, t);
  }
  printf("%d\n", std::max(mx, solve(n, S)));
  return 0;
}
