#include <bits/stdc++.h>
using namespace std;
vector<int> getdig(int x) {
  vector<int> ans;
  while (x) {
    ans.push_back(x % 10);
    x /= 10;
  }
  return ans;
}
int main() {
  vector<long long> p10(30);
  p10[0] = 1;
  for (int i = 1; i < p10.size(); i++) p10[i] = (p10[i - 1] * 10) % 998244353;
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<int> a(n), cnt(20);
  vector<vector<int>> dig(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    dig[i] = getdig(a[i]);
    cnt[dig[i].size()]++;
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < dig[i].size(); j++) {
      int rest = n;
      for (int k = 0; k < j; k++) {
        rest -= cnt[k];
        ans += p10[j + k] * (dig[i][j] * cnt[k]) % 998244353;
        ans %= 998244353;
      }
      ans += p10[2 * j] * (dig[i][j] * rest) % 998244353;
      ans %= 998244353;
      rest = n;
      for (int k = 0; k <= j; k++) {
        rest -= cnt[k];
        ans += p10[j + k] * (dig[i][j] * cnt[k]) % 998244353;
        ans %= 998244353;
      }
      ans += p10[2 * j + 1] * (dig[i][j] * rest) % 998244353;
      ans %= 998244353;
    }
  }
  cout << ans << "\n";
}
