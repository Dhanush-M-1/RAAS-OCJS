#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000 + 10;
const int p = 1000000;
int n, m;
int a[maxn], maxa;
int res;
void solve() {
  if (n == 1) {
    res = min(a[1] - 1, abs(p - a[1]));
  } else {
    res = p;
    for (int i = 0; i < n; i++) {
      if (a[i + 1] > p) break;
      res = min(res, max(a[i] - 1, m + p - a[i + 1]));
    }
    res = min(res, a[n] - 1);
  }
  printf("%d\n", res);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    maxa = (a[i], maxa);
  }
  if (maxa > p) m = (maxa - p) * 2;
  solve();
  return 0;
}
