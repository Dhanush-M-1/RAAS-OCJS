#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target( \
    "avx,avx2,fma,sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
long long MOD = 1e9 + 7;
long long intt(string s) {
  long long res = 0;
  long long cur = 1;
  for (int i = s.size() - 1; i > -1; i--) {
    res += (s[i] - '0') * cur;
    cur *= 10;
  }
  return res;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0),
      cout << fixed << setprecision(20);
  long long lst = 0;
  long long kol[2] = {0, 0};
  long long n = 0;
  vector<char> c;
  while (true) {
    string s;
    cin >> s;
    if (s.size() > 1 || ('0' <= s[0] && s[0] <= '9')) {
      n = intt(s);
      break;
    } else {
      if (s[0] == '?') {
        kol[lst]++;
      } else {
        if (s[0] == '=') continue;
        c.push_back(s[0]);
        if (s[0] == '-')
          lst = 1;
        else
          lst = 0;
      }
    }
  }
  for (int i = 1; i <= min(2000000ll, n); i++) {
    if ((n + kol[1] * i) / kol[0] > 0 &&
        (n + kol[1] * i + kol[0] - 1) / kol[0] <= n) {
      cout << "Possible" << endl;
      cout << (n + kol[1] * i + kol[0] - 1) / kol[0] << " ";
      long long koll = 1;
      for (auto j : c) {
        if (j == '+') {
          if (koll >= (n + kol[1] * i) % kol[0]) {
            cout << j << " " << (n + kol[1] * i) / kol[0] << " ";
          } else {
            koll++;
            cout << j << " " << (n + kol[1] * i + kol[0] - 1) / kol[0] << " ";
          }
        } else {
          cout << j << " " << i << " ";
        }
      }
      cout << "= ";
      cout << n;
      exit(0);
    }
  }
  cout << "Impossible";
}
