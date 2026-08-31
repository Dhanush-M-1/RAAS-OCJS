#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimization("03")
#pragma GCC optimization("unroll-loops")
using namespace std;
const int maxn = 200001;
const int maxe = 20;
int a[maxn], b[maxn], c, k, pa[maxn], x, y, q, sol, d, d2, mod = 1000000007, j;
int m, n;
char h;
set<int> se;
string s;
pair<int, int> p[maxn + 1];
int rmq[maxn][maxe];
int st[4 * maxn], la[4 * maxn], ft[maxn], dt[maxn], dt2[maxn];
void build(int n) {
  for (int j = 1; (1 << j) <= n; j++) {
    for (int i = 1; i + (1 << j) - 1 <= n; i++) {
      rmq[i][j] = min(rmq[i][j - 1], rmq[i + (1 << (j - 1))][j - 1]);
    }
  }
}
int query(int a, int b) {
  int k = 31 - __builtin_clz(b - a + 1);
  return min(rmq[a][k], rmq[b - (1 << k) + 1][k]);
}
int fin(int i) {
  if (pa[i] == i) return i;
  return pa[i] = fin(pa[i]);
}
int bs(int l, int r) {
  while (l != r) {
    int mi = (l + r) / 2;
    if (a[mi] == x) return mi;
    if (a[mi] > x)
      r = mi;
    else
      l = mi + 1;
  }
  return l;
}
void crear(int l, int r, int nod) {
  if (l == r)
    st[nod] = a[l];
  else {
    int mi = (l + r) / 2;
    crear(l, mi, 2 * nod);
    crear(mi + 1, r, 2 * nod + 1);
    st[nod] = min(st[2 * nod], st[2 * nod + 1]);
  }
}
void upd(int l, int r, int nod) {
  if (l > x || r < x) return;
  if (la[nod] != 0) {
    st[nod] += la[nod];
    la[2 * nod] += la[nod];
    la[2 * nod + 1] += la[nod];
    la[nod] = 0;
  }
  if (l == r)
    st[nod] += y;
  else {
    int mi = (l + r) / 2;
    upd(l, mi, 2 * nod);
    upd(mi + 1, r, 2 * nod + 1);
    st[nod] = min(st[2 * nod], st[2 * nod + 1]);
  }
}
int qu(int l, int r, int nod) {
  if (l > y || r < x) return 100001;
  if (la[nod] != 0) {
    st[nod] += la[nod];
    la[2 * nod] += la[nod];
    la[2 * nod + 1] += la[nod];
    la[nod] = 0;
  }
  if (l >= x && r <= y)
    return st[nod];
  else {
    int mi = (l + r) / 2;
    return min(qu(l, mi, 2 * nod), qu(mi + 1, r, 2 * nod + 1));
  }
}
void lazy(int l, int r, int nod) {
  if (l > y || r < x) return;
  if (la[nod] != 0) {
    st[nod] += la[nod];
    la[2 * nod] += la[nod];
    la[2 * nod + 1] += la[nod];
    la[nod] = 0;
  }
  if (l >= x && r <= y) {
    st[nod] += q;
    if (l != r) {
      la[nod * 2] += q;
      la[2 * nod + 1] += q;
    }
  } else {
    int mi = (l + r) / 2;
    lazy(l, mi, 2 * nod);
    lazy(mi + 1, r, 2 * nod + 1);
    st[nod] = min(st[2 * nod], st[2 * nod + 1]);
  }
}
int ftq(int n) {
  int c = 0;
  while (n) {
    c += ft[n];
    n -= (n & -n);
  }
  return c;
}
void ftupd(int x) {
  for (int i = x; i <= n; i += (i & -i)) ft[i] += y;
}
void abi(int x) {
  for (int i = x; i <= n; i += (i & -i)) dt[i] += y;
}
void abi2(int x) {
  for (int i = x; i <= n; i += (i & -i)) dt2[i] += y;
}
int q1(int n) {
  int c = 0;
  while (n) {
    c += dt[n];
    n -= (n & -n);
  }
  return c;
}
int q2(int n) {
  int c = 0;
  while (n) {
    c += dt[n];
    n -= (n & -n);
  }
  return c;
}
void ini() {
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    y = a[i] - a[i - 1];
    abi(i);
    y = a[i] - a[i - 1] * i;
    abi2(i);
  }
}
int main() {
  ios_base::sync_with_stdio();
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  cin >> m;
  while (m--) {
    priority_queue<pair<int, int>> pq, sol;
    for (int i = 1; i <= n; i++) {
      pq.push({a[i], -i});
    }
    cin >> x >> y;
    while (x--) {
      sol.push({pq.top().second, pq.top().first});
      pq.pop();
    }
    while (y--) {
      d = sol.top().second;
      sol.pop();
    }
    cout << d << '\n';
  }
}
