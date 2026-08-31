#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, k;
  cin >> n >> k;
  vector<vector<long long>> b(4, vector<long long>(1, 0LL));
  for (int i = 0; i < n; i++) {
    long long t, x, y;
    cin >> t >> x >> y;
    b[x * 2 + y].push_back(t);
  }
  for (int i = 1; i < 4; i++) {
    sort(b[i].begin(), b[i].end());
    long long acc = 0LL;
    for (auto &j : b[i]) {
      long long x = j;
      j += acc;
      acc += x;
    }
  }
  long long ans = (k < (int)b[1].size() && k < (int)b[2].size())
                      ? b[1][k] + b[2][k]
                      : LONG_LONG_MAX;
  for (int i = 1; i < (int)b[3].size() && k - i >= 0; i++) {
    if (k - i == 0)
      ans = min(ans, b[3][i]);
    else if (k - i > 0) {
      if (k - i > (int)b[1].size() - 1 || k - i > (int)b[2].size() - 1)
        continue;
      else
        ans = min(ans, b[3][i] + b[1][k - i] + b[2][k - i]);
    }
  }
  if (ans == LONG_LONG_MAX)
    cout << -1 << "\n";
  else
    cout << ans << "\n";
}
