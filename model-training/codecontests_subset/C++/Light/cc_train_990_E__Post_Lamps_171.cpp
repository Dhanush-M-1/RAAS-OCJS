#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll inf = 1e14;
const int maxn = 1e6 + 5;
bool yes[maxn];
int l[maxn];
int a, n, m, k;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  memset(yes, 1, sizeof yes);
  for (int i = 1; i <= m; i++) {
    int x;
    cin >> x;
    yes[x] = 0;
  }
  for (int i = 0; i <= n; i++) {
    if (yes[i])
      l[i] = i;
    else
      l[i] = l[i - 1];
  }
  ll ans = inf;
  for (int i = 1; i <= k; i++) {
    cin >> a;
    if (yes[0]) {
      ll cnt = 1;
      bool f = 1;
      int st = 0;
      while (st < n) {
        if (st + i >= n) {
          break;
        }
        if (yes[st + i]) {
          st = st + i;
          cnt++;
        } else if (l[st + i] > st) {
          st = l[st + i];
          cnt++;
        } else {
          f = 0;
          break;
        }
      }
      if (f) ans = min(ans, cnt * a);
    }
  }
  if (ans == inf) ans = -1;
  cout << ans << endl;
}
