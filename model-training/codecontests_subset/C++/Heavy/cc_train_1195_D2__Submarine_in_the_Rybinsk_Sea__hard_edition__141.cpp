#include <bits/stdc++.h>
using namespace std;
const int MAX = 100000;
const int MOD = 998244353;
long long a[MAX + 10], s[50], sum[50], len[MAX + 10];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  s[0] = 1;
  for (int i = 1; i <= 20; ++i) {
    s[i] = s[i - 1] * 10 % MOD;
  }
  int n;
  cin >> n;
  int maxlen = 0, minlen = INT_MAX;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    long long t = a[i];
    int cnt = 0;
    while (t) {
      t /= 10;
      ++cnt;
    }
    ++sum[cnt];
    len[i] = cnt;
    maxlen = max(maxlen, cnt);
    minlen = min(minlen, cnt);
  }
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    int leni = len[i];
    for (int j = minlen; j <= maxlen; ++j) {
      int cnt = 0;
      long long tmp = a[i];
      while (tmp) {
        long long t = tmp % 10;
        if (cnt < 2 * min(leni, j)) {
          ans = (ans + t * s[cnt++] % MOD * sum[j]) % MOD;
          ans = (ans + t * s[cnt++] % MOD * sum[j]) % MOD;
        } else {
          ans = (ans + t * s[cnt++] % MOD * sum[j] * 2) % MOD;
        }
        tmp /= 10;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
