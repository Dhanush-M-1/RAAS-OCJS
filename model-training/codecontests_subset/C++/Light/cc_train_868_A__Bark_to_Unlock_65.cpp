#include <bits/stdc++.h>
using namespace std;
const int MAX = 100010;
const int MOD = 1000000007;
const int INF = 0x3f3f3f3f;
const long long LLINF = 0x3f3f3f3f3f3f3f3f;
const long double EPS = 1e-7;
int main() {
  int n;
  string p;
  cin >> p;
  cin >> n;
  bool win = false, p1 = false, p2 = false;
  for (int i = 0; i < (int)n; i++) {
    string s;
    cin >> s;
    if (p == s) win = true;
    if (s[1] == p[0]) p1 = true;
    if (s[0] == p[1]) p2 = true;
  }
  if (p1 and p2) win = true;
  if (win)
    cout << "YES" << '\n';
  else
    cout << "NO" << '\n';
  return 0;
}
