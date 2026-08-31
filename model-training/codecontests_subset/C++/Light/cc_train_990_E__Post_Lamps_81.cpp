#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 100;
bool block[N];
int pre[N];
int n, m, k;
long long cnt = 1e18;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int x;
    cin >> x;
    block[x] = true;
  }
  if (block[0]) return cout << -1, 0;
  for (int i = 0; i < n; i++) {
    if (!block[i])
      pre[i] = i;
    else
      pre[i] = pre[i - 1];
  }
  for (int i = 1; i <= k; i++) {
    int cost, tmp = 0;
    cin >> cost;
    for (int j = 0;; j = pre[j + i]) {
      tmp++;
      if (j + i >= n) {
        cnt = min(cnt, 1LL * tmp * cost);
        break;
      }
      if (pre[j + i] == j) break;
    }
  }
  return cout << ((cnt == 1e18) ? -1 : cnt), 0;
}
