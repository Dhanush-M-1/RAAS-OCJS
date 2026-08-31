#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s = "";
  cin >> s;
  long long int c1 = 0, c2 = 0, c3 = 0;
  for (long long int i = 0; i < s.size(); i = i + 2) {
    if (s[i] == '1')
      c1++;
    else if (s[i] == '2')
      c2++;
    else {
      c3++;
    }
  }
  string p = "";
  for (long long int i = 0; i < c1; i++) {
    p += "1+";
  }
  if (c2 || c3) {
    for (long long int i = 0; i < c2; i++) {
      p += "2+";
    }
    if (c3) {
      for (long long int i = 0; i < c3; i++) {
        if (i == c3 - 1) {
          p += "3";
          break;
        }
        p += "3+";
      }
    } else {
      p = p.substr(0, p.size() - 1);
    }
  } else {
    p = p.substr(0, p.size() - 1);
  }
  cout << p << '\n';
  cerr << "Time : "
       << 1000 * ((long double)clock()) / (long double)CLOCKS_PER_SEC << "ms\n";
  return 0;
}
