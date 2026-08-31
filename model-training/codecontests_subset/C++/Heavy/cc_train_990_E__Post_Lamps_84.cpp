#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 1e18;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, k;
  cin >> n >> m >> k;
  int block[m + 1], power[k + 1];
  int lst[2000100];
  for (int i = 1; i <= m; i++) {
    cin >> block[i];
  }
  for (int i = 1; i <= k; i++) {
    cin >> power[i];
  }
  if (m && block[1] == 0) {
    cout << "-1\n";
    return 0;
  }
  long long ans = MAXN;
  for (int i = 0; i < 2000100; i++) {
    lst[i] = i;
  }
  for (int i = 1; i <= m; i++) {
    lst[block[i]] = lst[block[i] - 1];
  }
  for (int i = 1; i <= k; i++) {
    long long sum = 0;
    int now = 0, pre = -1;
    while (now < n) {
      if (now <= pre) break;
      sum += power[i];
      pre = now;
      now = lst[now + i];
    }
    if (now < n) continue;
    ans = min(ans, sum);
  }
  if (ans == MAXN) {
    cout << "-1\n";
  } else {
    cout << ans << "\n";
  }
}
