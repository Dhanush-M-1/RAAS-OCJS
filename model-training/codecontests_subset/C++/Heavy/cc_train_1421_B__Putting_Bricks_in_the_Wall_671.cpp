#include <bits/stdc++.h>
using namespace std;
using LL = long long;
using ULL = unsigned long long;
using pii = pair<int, int>;
using PLL = pair<LL, LL>;
using UI = unsigned int;
const int mod = 1e9 + 7;
const int inf = 0x3f3f3f3f;
const double EPS = 1e-8;
const double PI = acos(-1.0);
const int N = 210;
int T, n;
char s[N][N];
vector<pii> ans;
void add(char ch, int x, int y) {
  if (s[x][y] == ch) ans.emplace_back(x, y);
}
int main() {
  scanf("%d", &T);
  while (T--) {
    scanf("%d", &n);
    for (int i = (1); i < (n + 1); ++i) scanf("%s", s[i] + 1);
    ans.clear();
    if (s[1][2] == s[2][1]) {
      add(s[1][2], n - 1, n);
      add(s[2][1], n, n - 1);
    } else if (s[n - 1][n] == s[n][n - 1]) {
      add(s[n][n - 1], 1, 2);
      add(s[n][n - 1], 2, 1);
    } else {
      add(s[2][1], 2, 1);
      add(s[1][2], n - 1, n);
      add(s[1][2], n, n - 1);
    }
    printf("%d\n", (int)ans.size());
    for (auto p : ans) printf("%d %d\n", p.first, p.second);
  }
  return 0;
}
