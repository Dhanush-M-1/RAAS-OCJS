#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10, mod = 1e9 + 7;
int cost;
int n, m, k;
int best[N];
int cal(int x) {
  int co = 1;
  int cu = x;
  while (cu < n) {
    auto it = best[cu];
    if (it + x <= cu) return -1;
    co++;
    cu = it + x;
  }
  return co;
}
bool notgood[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int x;
    cin >> x;
    notgood[x] = 1;
  }
  for (int i = 1; i < n; i++) {
    if (notgood[i])
      best[i] = best[i - 1];
    else
      best[i] = i;
  }
  if (notgood[0]) {
    cout << -1 << "\n";
    return 0;
  }
  long long ans = -1;
  for (int i = 1; i <= k; i++) {
    cin >> cost;
    long long co = cal(i);
    if (co != -1) {
      if (ans == -1)
        ans = co * cost;
      else
        ans = min(ans, co * cost);
    }
  }
  cout << ans << "\n";
  return 0;
}
