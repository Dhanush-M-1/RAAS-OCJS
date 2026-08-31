#include <bits/stdc++.h>
using namespace std;
int _;
template <class P, class Q>
void smin(P &a, Q b) {
  if (b < a) a = b;
}
template <class P, class Q>
void smax(P &a, Q b) {
  if (b > a) a = b;
}
template <class P, class Q>
bool in(const P &a, const Q &b) {
  return a.find(b) != a.end();
}
const int MAXN = 1001 * 1000;
string words[MAXN];
int n, r, c;
int nx[MAXN][20];
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> r >> c;
  for (int i = (0); i < int(n); ++i) cin >> words[i];
  int tot = 0, pt = -1;
  for (int i = (0); i < int(n); ++i) {
    while (pt < n && tot - 1 <= c) {
      ++pt;
      if (pt < n) tot += ((int)(words[pt]).size()) + 1;
    }
    nx[i][0] = pt;
    tot -= ((int)(words[i]).size()) + 1;
  }
  nx[n][0] = n;
  for (int j = (1); j < int(20); ++j)
    for (int i = (0); i < int(n + 1); ++i) nx[i][j] = nx[nx[i][j - 1]][j - 1];
  pair<int, int> best(-1, -1);
  for (int i = (0); i < int(n); ++i) {
    int pos = i;
    for (int j = (0); j < int(20); ++j)
      if (r & (1 << j)) pos = nx[pos][j];
    smax(best, pair<int, int>(pos - i, i));
  }
  int len = 0;
  for (int i = (best.second); i < int(best.second + best.first); ++i) {
    len += ((int)(words[i]).size()) + (len ? 1 : 0);
    bool nl = false;
    if (len > c) {
      nl = true;
      len = ((int)(words[i]).size());
    }
    if (nl) putchar('\n');
    if (len != ((int)(words[i]).size())) putchar(' ');
    printf("%s", words[i].c_str());
  }
  return 0;
}
