#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  vector<long long> v(n, 0);
  long long a = 0, b = 0;
  map<int, int> m;
  for (long long i = 0; i < n; i++) {
    cin >> v[i];
    m[log10(v[i]) + 1]++;
  }
  for (long long i = 0; i < n; i++) {
    for (auto j = m.begin(); j != m.end(); j++) {
      long long x = v[i];
      long long k = 10;
      long long y = 0;
      int s = j->first;
      while (x > 0) {
        if (s == 1) {
          y += x * k;
          y %= 998244353LL;
          break;
        }
        y += (x % 10) * k;
        x /= 10;
        k *= 100;
        k %= 998244353LL;
        y %= 998244353LL;
        s--;
      }
      y = y * (j->second);
      y %= 998244353LL;
      a += y;
      a %= 998244353LL;
      x = v[i];
      k = 1;
      y = 0;
      s = j->first;
      while (x > 0) {
        if (s == 0) {
          y += x * k;
          y %= 998244353LL;
          break;
        }
        y += (x % 10) * k;
        x /= 10;
        k *= 100;
        k %= 998244353LL;
        y %= 998244353LL;
        s--;
      }
      y = y * (j->second);
      y %= 998244353LL;
      a += y;
      a %= 998244353LL;
    }
  }
  cout << (a % 998244353LL);
  return 0;
}
