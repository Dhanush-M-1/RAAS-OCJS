#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/stack:16000000")
#pragma warning(disable : 4996)
const int inf = 1 << 25;
const double eps = 1e-9;
map<pair<int, int>, vector<int> > Y;
const int MAXN = 101000;
int gcd(int a, int b) { return !b ? a : gcd(b, a % b); }
int revMemo[MAXN];
int rev(int x) {
  int& ret = revMemo[x];
  if (ret != -1) return ret;
  ret = 0;
  while (x > 0) {
    ret = ret * 10 + x % 10;
    x /= 10;
  }
  return ret;
}
int add[MAXN];
bool cmp(const pair<int, int>& A, const pair<int, int>& B) {
  return (long long)A.first * A.second < (long long)B.first * B.second;
}
int main() {
  memset((revMemo), (-1), sizeof(revMemo));
  for (int i = (1); i < (100010); ++i) {
    int y = i;
    int yrev = rev(y);
    int d = gcd(y, yrev);
    y /= d, yrev /= d;
    Y[pair<int, int>(yrev, y)].push_back(i);
  }
  int maxX, maxY, w;
  cin >> maxX >> maxY >> w;
  pair<int, int> ans(inf, inf);
  int cury = 0;
  int cs = 0;
  memset((add), (0), sizeof(add));
  for (int i = (1); i < (maxX + 1); ++i) {
    int x = i;
    int xrev = rev(x);
    int d = gcd(x, xrev);
    x /= d, xrev /= d;
    vector<int>& a = Y[pair<int, int>(x, xrev)];
    for (int j = (0); j < ((int)a.size()); ++j) {
      int y = a[j];
      if (y <= cury) ++cs;
      ++add[y];
    }
    if (cs >= w) {
      while (cs - add[cury] >= w) cs -= add[cury], --cury;
    } else {
      while (cury < maxY && cs < w) cs += add[++cury];
    }
    if (cs >= w) ans = min(ans, pair<int, int>(i, cury), cmp);
  }
  if (ans.first == inf)
    printf("-1\n");
  else
    printf("%d %d\n", ans.first, ans.second);
  return 0;
}
