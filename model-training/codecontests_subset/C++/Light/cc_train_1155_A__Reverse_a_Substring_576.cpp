#include <bits/stdc++.h>
using namespace std;
const int N = 105001;
const int SQRTN = 320;
const int LOGN = 20;
const long double PI = acos(-1);
const long double TAU = 2 * PI;
string s, x;
signed main() {
  int aaa;
  cin >> aaa;
  cin >> s;
  x = s;
  sort(x.begin(), x.end());
  if (s == x) return puts("NO");
  puts("YES");
  int n;
  n = s.size();
  for (int i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      return printf("%d %d", i, i + 1), 0;
    }
  }
}
