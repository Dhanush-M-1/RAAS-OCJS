#include <bits/stdc++.h>
using namespace std;
long long BIG = 1e14;
vector<int> block;
vector<int> street;
vector<int> dp;
vector<int> price;
int main() {
  ios::sync_with_stdio(0);
  int n;
  int m;
  int k;
  cin >> n >> m >> k;
  block.resize(m, 0);
  street.resize(n + 1, 0);
  dp.resize(n + 1, -1);
  price.resize(k);
  for (int i = 0; i < m; i++) {
    cin >> block[i];
    street[block[i]] = 1;
  }
  for (int i = 1; i <= n; i++) {
    if (street[i] == 0) {
      dp[i] = i;
    } else {
      dp[i] = dp[i - 1];
    }
  }
  for (int i = 0; i < k; i++) {
    cin >> price[i];
  }
  long long ans = BIG;
  if (!street[0]) {
    for (int i = 1; i <= k; i++) {
      int cur = 1;
      int x = 0;
      while (x + i < n) {
        cur++;
        if (x < dp[x + i]) {
          x = dp[x + i];
        } else {
          cur = 0;
          break;
        }
      }
      if (cur) {
        if (ans > (long long)cur * price[i - 1]) {
          ans = (long long)cur * price[i - 1];
        }
      }
    }
  }
  if (ans == BIG) {
    cout << -1 << endl;
  } else {
    cout << ans;
  }
  return 0;
}
