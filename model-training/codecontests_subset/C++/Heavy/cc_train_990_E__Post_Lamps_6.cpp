#include <bits/stdc++.h>
using namespace std;
long long INF = 1e18;
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> prev_ok(n + 1);
  for (int i = 0; i <= n; i++) {
    prev_ok[i] = i;
  }
  for (int i = 0; i < m; i++) {
    int a;
    scanf("%d", &a);
    if (a == 0) {
      cout << -1 << endl;
      return 0;
    }
    prev_ok[a] = prev_ok[a - 1];
  }
  long long ans = INF;
  for (int p = 1; p <= k; p++) {
    int s;
    scanf("%d", &s);
    int i = 0;
    bool ok = true;
    int cur = 1;
    while (i + p < n) {
      int prev_i = i;
      i += p;
      i = prev_ok[i];
      if (i == prev_i) {
        ok = false;
        break;
      }
      cur++;
    }
    if (ok) {
      ans = min(ans, (long long)cur * s);
    }
  }
  if (ans == INF) {
    cout << -1;
  } else {
    cout << ans << endl;
  }
}
