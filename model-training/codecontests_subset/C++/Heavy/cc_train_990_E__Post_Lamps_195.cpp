#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 2;
const long long inf = 1e13;
int n, m, k, p[N];
long long ans = inf, a[N];
bool is[N];
int main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int x;
    scanf("%d", &x);
    is[x] = 1;
  }
  for (int i = 1; i <= k; i++) scanf("%lld", &a[i]);
  if (is[0] == 1) {
    cout << -1 << endl;
    return 0;
  }
  for (int i = 0; i < n; i++) {
    p[i] = (is[i]) ? p[i - 1] : i;
  }
  for (int i = 1; i <= k; i++) {
    long long cnt = 0, t = 0;
    bool can = 1;
    while (t < n) {
      if (p[t] + i <= t) {
        can = 0;
        break;
      }
      cnt++;
      t = p[t] + i;
    }
    if (can) ans = min(ans, cnt * a[i]);
  }
  cout << ((ans < inf) ? ans : -1) << endl;
  return 0;
}
