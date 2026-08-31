#include <bits/stdc++.h>
const long long llinf = 0x3f3f3f3f3f3f3f3f;
const int inf = 0x3f3f3f3f;
using namespace std;
const int maxn(5e5 + 10);
string ss;
int main() {
  getline(cin, ss, '\n');
  string s = "+";
  for (int i = 0; i < ss.size(); i++) {
    if (isspace(ss[i])) continue;
    s.push_back(ss[i]);
  }
  int n;
  int zheng(0), fu(0);
  int le(0), ri(0);
  for (int i = 0; i < s.size(); i++) {
    switch (s[i]) {
      case '+':
        ++i;
        ++zheng;
        break;
      case '-':
        ++i;
        ++fu;
        break;
      case '=':
        ++i;
        sscanf(&s[i], "%d", &n);
        goto Over;
    }
  }
Over:;
  ri += zheng * n;
  le += zheng;
  le -= fu * n;
  ri -= fu;
  bool flag = (le <= n && ri >= n);
  cout << (flag ? "Possible" : "Impossible") << endl;
  if (flag) {
    int base0(1), base1(-n), now = zheng + (-n) * fu, left = n - now;
    int cut, nextout;
    if (left >= n - 1)
      cut = n - 1;
    else
      cut = left;
    left -= cut;
    nextout = cut + base0;
    for (int i = 0; i < ss.size(); i++) {
      switch (ss[i]) {
        case '+':
          if (left >= n - 1)
            cut = n - 1;
          else
            cut = left;
          left -= cut;
          nextout = cut + base0;
          cout << ss[i];
          break;
        case '-':
          if (left >= n - 1)
            cut = n - 1;
          else
            cut = left;
          left -= cut;
          nextout = -(cut + base1);
          cout << ss[i];
          break;
        case '?':
          cout << nextout;
          break;
        default:
          cout << ss[i];
      }
    }
    cout << endl;
  }
  return 0;
}
