#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, ans, mx, mxh, mnh, h, now, pmx, pnow, dl, dr, dp;
int a[N], pre[N];
vector<int> p[N];
struct Seg {
  int l, r, be, is;
} d[N + N];
void upd(int h, int x) {
  if (h < d[dp].l) --dp;
  if (h > d[dp].r) ++dp;
  if (d[dp].is)
    ans = max(ans, (min(p[mx][pmx], p[now][pnow]) - 1) - p[mx][h + d[dp].be]);
  else
    ans = max(ans, (min(p[mx][pmx], p[now][pnow]) - 1) - d[dp].be);
}
void doit(int l, int r) {
  for (int i = l, _e = r; i < _e; ++i)
    if (++h > mxh) {
      d[++dr] = (Seg){h, h + (r - i - 1), -h + i, 1};
      h = mxh = d[dr].r;
      pmx = r;
      break;
    } else
      ++pmx, upd(h, p[mx][i]);
}
int main() {
  scanf("%d", &n);
  for (int i = 1, _e = n; i <= _e; ++i)
    scanf("%d", &a[i]), p[a[i]].push_back(i);
  for (int i = 1, _e = n; i <= _e; ++i)
    if (p[i].size() > p[mx].size()) mx = i;
  int las = 1;
  p[mx].push_back(n + 1);
  for (int i = 0, _e = p[mx].size(); i < _e; ++i) {
    for (int j = las, _e = p[mx][i]; j < _e; ++j) pre[j] = i;
    las = p[mx][i] + 1;
  }
  for (int i = 1, _e = n; i <= _e; ++i)
    if (i != mx && p[i].size()) {
      now = i;
      mnh = mxh = h = 0;
      pmx = pnow = 0;
      p[i].push_back(n + 1);
      dp = dl = dr = n;
      d[n] = (Seg){0, 0, 0, 0};
      int las = 0;
      for (int k = 0, _e = p[i].size() - 1; k < _e; ++k) {
        int j = p[i][k], las2 = pre[j];
        doit(las, las2);
        ++pnow;
        if (--h < mnh)
          mnh = h, d[--dl] = (Seg){h, h, j, 0};
        else
          upd(h, j);
        las = las2;
      }
      doit(las, p[mx].size() - 1);
    }
  printf("%d\n", ans);
}
