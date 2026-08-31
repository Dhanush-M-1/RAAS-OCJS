#include <bits/stdc++.h>
using namespace std;
bool B[1000010] = {0};
int pre[1000010];
long long cost[1000010] = {0};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long n, m, k, a;
  cin >> n >> m >> k;
  for (int i = 0; i < m; ++i) cin >> a, B[a] = 1;
  for (int i = 0; i < k; ++i) cin >> a, cost[i + 1] = a;
  if (B[0] == 1) return cout << "-1\n", 0;
  for (int i = 0; i < n; ++i) {
    int &a = pre[i];
    if (not B[i])
      a = i;
    else if (i)
      a = pre[i - 1];
    else
      a = -1;
  }
  long long ans = 1ll << 60;
  for (int l = 1; l <= k; ++l) {
    bool fail = 0;
    long long cnt = 0;
    for (int i = 0; not fail and i < n;) {
      if (B[i]) {
        if (i - pre[i] >= l)
          fail = 1;
        else
          i = pre[i] + l, cnt += 1;
      } else {
        i = pre[i] + l, ++cnt;
      }
    }
    if (not fail) ans = min(ans, cnt * cost[l]);
  }
  if (ans == 1ll << 60)
    cout << "-1\n";
  else
    cout << ans << '\n';
}
