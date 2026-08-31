#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, ans, mx, mxh, mnh, h, ts, now;
int a[N], dl, dr, dp;
vector<int> p[N];
struct Seg {
  int l, r, be, is;
} d[N + N];
int nx(int y) {
  int o = (upper_bound(p[mx].begin(), p[mx].end(), y) - p[mx].begin()),
      u = (upper_bound(p[now].begin(), p[now].end(), y) - p[now].begin());
  o = o == p[mx].size() ? n + 1 : p[mx][o];
  u = u == p[now].size() ? n + 1 : p[now][u];
  return min(o, u) - 1;
}
void upd(int h, int x) {
  if (h < d[dp].l) --dp;
  if (h > d[dp].r) ++dp;
  if (d[dp].is)
    ans = max(ans, nx(x) - p[mx][h + d[dp].be]);
  else
    ans = max(ans, nx(x) - d[dp].be);
}
void doit(int l, int r) {
  for (int i = l, _e = r; i < _e; ++i)
    if (++h > mxh) {
      d[++dr] = (Seg){h, h + (r - i - 1), -h + i, 1};
      h = mxh = d[dr].r;
      break;
    } else
      upd(h, p[mx][i]);
}
int main() {
  scanf("%d", &n);
  for (int i = 1, _e = n; i <= _e; ++i)
    scanf("%d", &a[i]), p[a[i]].push_back(i);
  for (int i = 1, _e = n; i <= _e; ++i)
    if (p[i].size() > p[mx].size()) mx = i;
  for (int i = 1, _e = n; i <= _e; ++i)
    if (i != mx && p[i].size()) {
      now = i;
      mnh = mxh = h = 0;
      upd(0, 0);
      dp = dl = dr = n;
      d[n] = (Seg){0, 0, 0, 0};
      int las = 0;
      for (int j : p[i]) {
        int las2 = (upper_bound(p[mx].begin(), p[mx].end(), j) - p[mx].begin());
        doit(las, las2);
        if (--h < mnh)
          mnh = h, d[--dl] = (Seg){h, h, j, 0};
        else
          upd(h, j);
        las = las2;
      }
      doit(las, p[mx].size());
    }
  printf("%d\n", ans);
}
