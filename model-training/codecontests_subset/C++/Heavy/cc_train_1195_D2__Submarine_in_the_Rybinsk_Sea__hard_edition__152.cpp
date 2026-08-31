#include <bits/stdc++.h>
const int INF = (int)1e9;
using namespace std;
int MOD = 998244353;
long long shuffle(string s, int k, bool flag) {
  long long num = 0;
  long long p = ((flag) ? 10 : 1);
  for (int i = (int)s.size() - 1, j = 1; i >= 0; i--, j++) {
    num += (s[i] - '0') * p;
    p *= ((j > k - (flag)) ? 10 : 100);
    num %= MOD, p %= MOD;
  }
  return num;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  vector<string> a(n);
  vector<int> len(11);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    len[(int)a[i].size()]++;
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 1; j <= 10; j++) {
      long long f = shuffle(a[i], j, false);
      long long s = shuffle(a[i], j, true);
      f %= MOD, s %= MOD;
      ans += (len[j] * f) % MOD + (len[j] * s) % MOD;
      ans %= MOD;
    }
  }
  cout << ans << '\n';
  return 0;
}
