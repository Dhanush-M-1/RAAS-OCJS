#include <bits/stdc++.h>
using namespace std;
const int N = 1e5;
const int M = 1e6;
int a[N + 5], n;
int s = 1, t = M;
int ans = M;
int main() {
  scanf("%d", &n);
  a[0] = 1, a[n + 1] = M;
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 0; i <= n; i++) ans = min(ans, max(a[i] - s, t - a[i + 1]));
  printf("%d", ans);
  return 0;
}
