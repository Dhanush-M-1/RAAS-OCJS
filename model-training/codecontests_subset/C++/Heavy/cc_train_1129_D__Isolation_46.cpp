#include <bits/stdc++.h>
using namespace std;
void read(int &x) {
  char ch = getchar();
  x = 0;
  while (ch < '0' || ch > '9') ch = getchar();
  while (ch >= '0' && ch <= '9')
    x = (x << 1) + (x << 3) + ch - 48, ch = getchar();
}
struct Arr {
  int x, y;
} b[100000 + 1], c[320 + 1];
int a[100000 + 1], s[100000 + 1], add[320 + 1], pre[100000 + 1][2],
    num[100000 + 1];
int f[100000 + 1], sum[100000 + 1];
int n, m, tot, sq;
bool Cmp(Arr a, Arr b) { return a.x < b.x; }
int Max(int x, int y) { return x > y ? x : y; }
int Min(int x, int y) { return x < y ? x : y; }
void Rebuild(int k, int l, int r, int ad) {
  for (int i = c[k].x; i <= c[k].y; i++) s[i] += add[k];
  for (int i = l; i <= r; i++) s[i] += ad;
  add[k] = 0;
  for (int i = c[k].x; i <= c[k].y; i++) b[i] = (Arr){s[i], f[i - 1]};
  sort(b + c[k].x, b + 1 + c[k].y, Cmp);
  sum[c[k].x] = b[c[k].x].y;
  for (int i = c[k].x + 1; i <= c[k].y; i++)
    sum[i] = (sum[i - 1] + b[i].y) % 998244353;
}
void Add(int l, int r, int ad) {
  for (int i = 1; i <= tot; i++) {
    if (c[i].x > r) break;
    if (c[i].y >= l && c[i].x <= r) {
      if (c[i].x < l)
        Rebuild(i, l, Min(c[i].y, r), ad);
      else if (c[i].y > r)
        Rebuild(i, Max(i, c[i].x), r, ad);
      else
        (add[i] += ad);
    }
  }
}
int Get(int l, int r, int g) {
  int mid = 0, w = 0;
  while (l <= r) {
    mid = l + r >> 1;
    b[mid].x <= g ? l = (w = mid) + 1 : r = mid - 1;
  }
  return w;
}
int main() {
  read(n), read(m);
  for (int i = 1; i <= n; i++) read(a[i]);
  sq = sqrt(n);
  tot = n / sq + (n % sq > 0);
  for (int i = 1; i <= n; i++) num[i] = (i - 1) / sq + 1;
  for (int i = 1; i <= n; i++)
    if (num[i] > num[i - 1]) c[num[i]].x = i, c[num[i - 1]].y = i - 1;
  c[num[n]].y = n;
  for (int i = 0; i <= n; i++) f[i] = 0;
  f[0] = 1;
  for (int i = 1; i <= n; i++) {
    int k = num[i];
    if (pre[a[i]][0]) {
      if (pre[a[i]][1] + 1 >= c[k].x) {
        for (int j = pre[a[i]][1] + 1; j <= pre[a[i]][0]; j++) --s[j];
        for (int j = pre[a[i]][0] + 1; j <= i; j++) ++s[j];
        Rebuild(k, 1, 0, 0);
      } else if (pre[a[i]][0] >= c[k].x) {
        Add(pre[a[i]][1] + 1, c[k].x - 1, -1);
        for (int j = c[k].x; j <= pre[a[i]][0]; j++) --s[j];
        for (int j = pre[a[i]][0] + 1; j <= i; j++) ++s[j];
        Rebuild(k, 1, 0, 0);
      } else {
        Add(pre[a[i]][1] + 1, pre[a[i]][0], -1),
            Add(pre[a[i]][0] + 1, c[k].x - 1, 1);
        for (int j = c[k].x; j <= i; j++) ++s[j];
        Rebuild(k, 1, 0, 0);
      }
    } else {
      Add(1, c[k].x - 1, 1);
      for (int j = c[k].x; j <= i; j++) ++s[j];
      Rebuild(k, 1, 0, 0);
    }
    pre[a[i]][1] = pre[a[i]][0], pre[a[i]][0] = i;
    for (int j = c[k].x; j <= i; j++)
      if (s[j] + add[k] <= m) (f[i] += f[j - 1]) %= 998244353;
    for (int j = k - 1; j >= 1; j--) {
      if (b[c[j].x].x + add[j] <= m)
        (f[i] += sum[Get(c[j].x, c[j].y, m - add[j])]) %= 998244353;
    }
    if (i == c[k].y) Rebuild(k, 1, 0, 0);
  }
  printf("%d\n", f[n]);
  return 0;
}
