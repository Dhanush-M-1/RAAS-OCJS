#include <bits/stdc++.h>
using namespace std;
long long int INF = 1e17;
int n, m, k, price[1001010], lst[1001010];
bool blocked[1001010];
long long int getMn(int power) {
  int at = 0, cnt = 0, atTmp;
  while (at < n) {
    atTmp = at;
    at += power;
    if (at >= n) return cnt + 1;
    at = lst[at];
    if (at <= atTmp) return INF;
    cnt++;
  }
  return cnt;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int x;
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> x;
    blocked[x] = true;
  }
  for (int i = 1; i <= k; i++) cin >> price[i];
  if (blocked[0]) {
    cout << "-1\n";
    return 0;
  }
  for (int i = 0; i <= n; i++) {
    if (blocked[i])
      lst[i] = lst[i - 1];
    else
      lst[i] = i;
  }
  long long int ans = INF;
  for (int i = 1; i <= k; i++) {
    long long int aux = getMn(i);
    if (aux < INF) ans = min(ans, (long long int)price[i] * aux);
  }
  if (ans == INF) ans = -1;
  cout << ans << "\n";
  return 0;
}
