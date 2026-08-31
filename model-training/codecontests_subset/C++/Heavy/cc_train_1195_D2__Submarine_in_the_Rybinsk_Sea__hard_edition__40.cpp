#include <bits/stdc++.h>
using namespace std;
string ar[100005];
long long mod = 998244353;
long long F(string &x) {
  long long val = 0;
  for (int i = 0; i < x.size(); i++) {
    val *= 10;
    val %= mod;
    val += (x[i] - '0');
    val %= mod;
  }
  return val % mod;
}
long long L[15];
int main() {
  long long n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> ar[i];
    L[(long long)ar[i].size()]++;
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    for (int len = 0; len < 11; len++) {
      string tmpr = "";
      string tmp = ar[i];
      reverse(tmp.begin(), tmp.end());
      int tt = len;
      for (int j = 0; j < tmp.size(); j++) {
        tmpr += tmp[j];
        if (tt > 0) {
          tmpr += '0';
          tt--;
        }
      }
      tt = len;
      string tmpl = "";
      for (int j = 0; j < tmp.size(); j++) {
        if (tt > 0) {
          tt--;
          tmpl += '0';
        }
        tmpl += tmp[j];
      }
      reverse(tmpl.begin(), tmpl.end());
      reverse(tmpr.begin(), tmpr.end());
      long long val1 = F(tmpl);
      long long val2 = F(tmpr);
      long long ttt = ((val1 % mod) * (L[len] % mod)) % mod;
      long long ppp = ((val2 % mod) * (L[len] % mod)) % mod;
      ttt = ((ttt % mod) + (ppp % mod)) % mod;
      ans = ((ans % mod) + (ttt % mod)) % mod;
    }
  }
  cout << ans % mod << endl;
  return 0;
}
