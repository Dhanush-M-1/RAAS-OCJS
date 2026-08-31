#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
long long ara[400000];
string str[400000];
long long koyta[30];
void convert(long long pos) {
  long long val = ara[pos];
  long long cc = 0;
  while (val) {
    val = val / 10;
    cc++;
  }
  str[pos].resize(cc);
  koyta[cc]++;
  val = ara[pos];
  cc--;
  while (val) {
    str[pos][cc] = '0' + val % 10;
    val = val / 10;
    cc--;
  }
  reverse(str[pos].begin(), str[pos].end());
}
long long pwr10[40];
int main() {
  pwr10[0] = 1;
  for (long long i = 1; i <= 30; i++) pwr10[i] = (pwr10[i - 1] * 10) % mod;
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    scanf("%lld", &ara[i]);
    convert(i);
  }
  for (long long i = 0; i <= 20; i++) koyta[i] += koyta[i - 1];
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    for (long long j = 0; j < str[i].size(); j++) {
      for (long long k = 1; k < j; k++) {
        long long curpos = j + k;
        long long tmp = ((str[i][j] - '0') * pwr10[curpos]) % mod;
        tmp = (tmp * (koyta[k] - koyta[k - 1])) % mod;
        ans = ans + tmp;
        if (ans >= mod) ans -= mod;
      }
      long long curpos = j + j;
      long long tmp = ((str[i][j] - '0') * pwr10[curpos]) % mod;
      if (j != 0)
        tmp = (tmp * (koyta[20] - koyta[j - 1])) % mod;
      else
        tmp = (tmp * (koyta[20])) % mod;
      ans = ans + tmp;
      if (ans >= mod) ans -= mod;
    }
    for (long long j = 0; j < str[i].size(); j++) {
      for (long long k = 1; k <= j; k++) {
        long long curpos = j + k;
        long long tmp = ((str[i][j] - '0') * pwr10[curpos]) % mod;
        tmp = (tmp * (koyta[k] - koyta[k - 1])) % mod;
        ans = ans + tmp;
        if (ans >= mod) ans -= mod;
      }
      long long curpos = j + j + 1;
      long long tmp = ((str[i][j] - '0') * pwr10[curpos]) % mod;
      tmp = (tmp * (koyta[20] - koyta[j])) % mod;
      ans = ans + tmp;
      if (ans >= mod) ans -= mod;
    }
  }
  cout << ans << endl;
  return 0;
}
