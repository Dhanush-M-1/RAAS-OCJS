#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:100000000000,100000000000")
using namespace std;
const long long inf = 1e18 + 7;
const long long mod = 1e9 + 7;
const double eps = 1e-12;
const double PI = 2 * acos(0.0);
const double E = 2.71828;
string s;
long long ans[7];
set<pair<int, int> > was;
inline bool rec(int v, int add) {
  if (was.count(make_pair(v, add))) return false;
  was.insert(make_pair(v, add));
  if (v == s.size()) {
    return add == 0;
  }
  for (int zeroes = 0; zeroes < 7; zeroes++) {
    for (int fours = 0; fours + zeroes < 7; fours++) {
      int sevens = 6 - fours - zeroes;
      int val = sevens * 7 + fours * 4 + add;
      if (val % 10 == s[v] - '0') {
        if (rec(v + 1, val / 10)) {
          for (int i = 0; i < zeroes; i++) ans[i] *= 10;
          for (int i = zeroes; i < zeroes + fours; i++)
            ans[i] = ans[i] * 10 + 4;
          for (int i = zeroes + fours; i < 6; i++) ans[i] = ans[i] * 10 + 7;
          return true;
        }
      }
    }
  }
  return false;
}
void Solve() {
  cin >> s;
  reverse((s).begin(), (s).end());
  memset(ans, 0, sizeof ans);
  was.clear();
  if (rec(0, 0)) {
    for (long long(i) = 0; (i) < (long long)(6); (i)++) cout << ans[i] << " ";
    cout << endl;
  } else
    puts("-1");
}
int main(void) {
  int T;
  scanf("%d", &T);
  for (long long(i) = 0; (i) < (long long)(T); (i)++) Solve();
  return 0;
}
