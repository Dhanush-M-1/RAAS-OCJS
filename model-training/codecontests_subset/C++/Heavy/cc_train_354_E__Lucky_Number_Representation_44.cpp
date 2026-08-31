#include <bits/stdc++.h>
using namespace std;
long long n;
long long p10[20];
bool vis[20][10];
vector<long long> dp[20][10];
vector<long long> dig[100];
vector<long long> go(int k, int p) {
  if (vis[k][p]) return dp[k][p];
  vis[k][p] = true;
  int cur = n / p10[k - 1] % 10 + p * 10;
  if (k == 1) return dig[cur];
  for (int i = 0, _n = (int)(10); i < _n; i++) {
    if (i > cur) break;
    if ((int((dig[cur - i]).size())) == 0) continue;
    vector<long long> tmp = go(k - 1, i);
    if ((int((tmp).size())) == 0) continue;
    for (int j = 0, _n = (int)(6); j < _n; j++)
      tmp[j] += dig[cur - i][j] * p10[k - 1];
    return dp[k][p] = tmp;
  }
  return dp[k][p] = vector<long long>();
}
int main() {
  ios_base::sync_with_stdio(false);
  p10[0] = 1;
  for (int i = (int)(1), _n = (int)(20); i < _n; i++) p10[i] = p10[i - 1] * 10;
  for (int i = 0, _n = (int)(3 * 3 * 3 * 3 * 3 * 3); i < _n; i++) {
    vector<long long> tmp;
    int x = i;
    for (int j = 0, _n = (int)(6); j < _n; j++)
      tmp.push_back(x % 3 == 0 ? 0 : x % 3 == 1 ? 4 : 7), x /= 3;
    long long sum = accumulate((tmp).begin(), (tmp).end(), 0);
    dig[sum] = tmp;
  }
  int TTT;
  for (cin >> TTT; TTT--;) {
    cin >> n;
    memset(vis, false, sizeof vis);
    vector<long long> ans = go(19, 0);
    if ((int((ans).size())) == 0)
      cout << -1 << endl;
    else {
      for (int i = 0, _n = (int)(6); i < _n; i++) cout << ans[i] << ' ';
      cout << endl;
    }
  }
  {
    int _;
    cin >> _;
    return 0;
  }
}
