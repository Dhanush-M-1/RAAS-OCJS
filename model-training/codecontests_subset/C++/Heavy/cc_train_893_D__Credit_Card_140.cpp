#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int n, d;
int a[N];
int pref[N];
void solve() {
  scanf("%d %d", &n, &d);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", a + i);
  }
  for (int i = 1; i <= n; ++i) {
    pref[i] += pref[i - 1] + a[i];
  }
  long long u = 0, v = 0;
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    u += a[i], v += a[i];
    if (u > d) {
      printf("-1\n");
      return;
    }
    v = min(v, 1LL * d);
    if (!a[i] and u < 0) {
      if (v < 0) {
        ans++;
        u = 0, v = d;
      } else {
        u = 0;
      }
    }
  }
  printf("%d\n", ans);
}
int main() {
  solve();
  return 0;
}
