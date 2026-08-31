#include <bits/stdc++.h>
using namespace std;
int gi() {
  int x = 0, w = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') w = 0, ch = getchar();
  while (ch >= '0' && ch <= '9')
    x = (x << 3) + (x << 1) + ch - '0', ch = getchar();
  return w ? x : -x;
}
const int N = 1e5 + 5;
const int B = 350;
const int mod = 998244353;
int n, k, bl[N], L[B], R[B], tag[B], mn[B], mx[B], pre[N], lst[N], f[N], num[N];
vector<int> ans[B];
inline void add(int &x, int y) {
  x += y;
  x >= mod ? x -= mod : x;
}
void rebuild(int x) {
  mn[x] = 1 << 30;
  mx[x] = -1 << 30;
  for (int i = L[x]; i <= R[x]; ++i) {
    num[i] += tag[x];
    mn[x] = min(mn[x], num[i]);
    mx[x] = max(mx[x], num[i]);
  }
  tag[x] = 0;
  ans[x].clear();
  ans[x].resize(mx[x] - mn[x] + 1);
  for (int i = L[x]; i <= R[x]; ++i) add(ans[x][num[i] - mn[x]], f[i - 1]);
  for (int i = 1; i <= mx[x] - mn[x]; ++i) add(ans[x][i], ans[x][i - 1]);
}
int cal(int x) {
  int t = k - tag[x];
  if (t < mn[x]) return 0;
  return ans[x][min(t - mn[x], mx[x] - mn[x])];
}
void modify(int l, int ed, int v) {
  while (l <= ed) {
    int x = bl[l], r = min(R[x], ed);
    if (l == L[x] && r == R[x])
      tag[x] += v;
    else {
      for (int i = l; i <= r; ++i) num[i] += v;
      rebuild(x);
    }
    l = r + 1;
  }
}
int query(int l, int ed) {
  int res = 0;
  while (l <= ed) {
    int x = bl[l], r = min(R[x], ed);
    if (l == L[x] && r == R[x])
      add(res, cal(x));
    else {
      rebuild(x);
      for (int i = l; i <= r; ++i)
        if (num[i] <= k) add(res, f[i - 1]);
    }
    l = r + 1;
  }
  return res;
}
int main() {
  n = gi();
  k = gi();
  f[0] = 1;
  for (int i = 1; i <= n; ++i) {
    bl[i] = (i - 1) / B + 1;
    if (!L[bl[i]]) L[bl[i]] = i;
    R[bl[i]] = i;
  }
  rebuild(1);
  for (int i = 1; i <= n; ++i) {
    int x = gi();
    pre[i] = lst[x];
    lst[x] = i;
    modify(pre[i] + 1, i, 1);
    if (pre[i]) modify(pre[pre[i]] + 1, pre[i], -1);
    f[i] = query(1, i);
    if (i < n) rebuild(bl[i + 1]);
  }
  printf("%d\n", f[n]);
  return 0;
}
