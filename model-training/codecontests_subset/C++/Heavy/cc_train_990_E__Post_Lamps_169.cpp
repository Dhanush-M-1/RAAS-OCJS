#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  int block[m], cost[k + 1];
  int region[n];
  int nearest[n];
  for (int i = 0; i < n; i++) {
    region[i] = 0;
    nearest[i] = 0;
  }
  for (int i = 0; i < m; i++) {
    cin >> block[i];
    region[block[i]] = 1;
  }
  int prev = -1;
  for (int i = 0; i < n; i++) {
    if (region[i] == 0) {
      nearest[i] = i;
      prev = i;
    } else
      nearest[i] = prev;
  }
  long long int ans = LLONG_MAX;
  for (int i = 1; i <= k; i++) {
    int price;
    cin >> price;
    int step = i;
    int start = 0;
    long long int total = 0;
    int flag = 0;
    while (start < n) {
      if (region[start] == 0) {
        total += price;
        start += step;
        continue;
      }
      if (nearest[start] <= start - step or nearest[start] < 0) {
        flag = 1;
        break;
      } else {
        total += price;
        start = nearest[start] + step;
      }
    }
    if (flag == 0) {
      ans = min(ans, total);
    }
  }
  if (ans == LLONG_MAX)
    cout << -1 << endl;
  else
    cout << ans << endl;
}
