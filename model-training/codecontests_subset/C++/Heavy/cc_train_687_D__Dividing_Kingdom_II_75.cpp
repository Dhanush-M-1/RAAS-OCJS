#include <bits/stdc++.h>
using namespace std;
char buf[25];
const int maxn = 1010;
const int maxm = 500010;
struct edge {
  int x, y, v;
} e[maxm];
struct tree {
  int lc, rc;
  vector<int> v;
} t[maxm * 2];
vector<int> ans;
int f[maxn], w[maxn];
int n, m, q, rt, num, val;
int read() {
  int x = 0, f = 0;
  char ch;
  do {
    ch = getchar();
    if (ch == '-') f = 1;
  } while (ch < '0' || ch > '9');
  while (ch >= '0' && ch <= '9') {
    x = (x << 1) + (x << 3) + (ch ^ 48);
    ch = getchar();
  }
  return f ? -x : x;
}
void write(int x) {
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (!x) {
    putchar('0');
    return;
  }
  int cnt = 0;
  while (x) {
    buf[++cnt] = '0' + x % 10;
    x /= 10;
  }
  for (int i = cnt; i >= 1; --i) putchar(buf[i]);
}
int find(int x) {
  if (f[x] != x) {
    val ^= w[x];
    int tp = f[x];
    f[x] = find(f[x]);
    w[x] = w[x] ^ w[tp];
  }
  return f[x];
}
vector<int> merge(vector<int> a, vector<int> b) {
  if (a.size() == 0) return b;
  if (b.size() == 0) return a;
  vector<int> tp;
  tp.clear();
  int i = 0, j = 0;
  while (i <= a.size() - 1 && j <= b.size() - 1) {
    if (e[a[i]].v > e[b[j]].v)
      tp.push_back(a[i]), ++i;
    else
      tp.push_back(b[j]), ++j;
  }
  while (i <= a.size() - 1) tp.push_back(a[i]), ++i;
  while (j <= b.size() - 1) tp.push_back(b[j]), ++j;
  for (int i = 0; i <= tp.size() - 1; ++i) {
    int x = e[tp[i]].x, y = e[tp[i]].y;
    f[x] = x;
    f[y] = y;
    w[x] = w[y] = 0;
  }
  vector<int> v;
  v.clear();
  for (int i = 0; i <= tp.size() - 1; ++i) {
    int x = e[tp[i]].x, y = e[tp[i]].y;
    val = 0;
    int tx = find(x), ty = find(y);
    if (tx != ty) {
      f[tx] = f[ty];
      w[tx] = val ^ 1;
      v.push_back(tp[i]);
    } else {
      if (!val) {
        v.push_back(tp[i]);
        break;
      }
    }
  }
  return v;
}
int build(int l, int r) {
  int x = ++num;
  if (l == r) {
    t[x].v.push_back(l);
  } else {
    int mid = (l + r) >> 1;
    t[x].lc = build(l, mid);
    t[x].rc = build(mid + 1, r);
    t[x].v = merge(t[t[x].lc].v, t[t[x].rc].v);
  }
  return x;
}
void query(int x, int l, int r, int ql, int qr) {
  if (ql <= l && r <= qr) {
    ans = merge(ans, t[x].v);
    return;
  }
  int mid = (l + r) >> 1;
  if (ql <= mid) query(t[x].lc, l, mid, ql, qr);
  if (mid + 1 <= qr) query(t[x].rc, mid + 1, r, ql, qr);
}
int main() {
  n = read();
  m = read();
  q = read();
  for (int i = 1; i <= m; ++i) {
    e[i].x = read();
    e[i].y = read();
    e[i].v = read();
  }
  rt = build(1, m);
  for (int i = 1; i <= q; ++i) {
    int l = read(), r = read();
    ans.clear();
    query(rt, 1, m, l, r);
    for (int j = 1; j <= n; ++j) f[j] = j, w[j] = 0;
    int ANS = -1;
    for (int j = 0; j <= ans.size() - 1; ++j) {
      int x = e[ans[j]].x, y = e[ans[j]].y;
      val = 0;
      int tx = find(x), ty = find(y);
      if (tx != ty)
        f[tx] = f[ty], w[tx] = val ^ 1;
      else {
        if (val == 0) {
          ANS = e[ans[j]].v;
          break;
        }
      }
    }
    write(ANS);
    putchar('\n');
  }
  return 0;
}
