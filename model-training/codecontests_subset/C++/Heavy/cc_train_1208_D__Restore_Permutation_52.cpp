#include <bits/stdc++.h>
using namespace std;
vector<unsigned long long> t, lazy;
void build(unsigned long long a[], int v, int tl, int tr) {
  if (tl == tr) {
    t[v] = a[tl];
  } else {
    int tm = (tl + tr) / 2;
    build(a, v * 2 + 1, tl, tm);
    build(a, v * 2 + 2, tm + 1, tr);
    t[v] = min(t[v * 2 + 1], t[v * 2 + 2]);
  }
}
void add(int v, int tl, int tr, int l, int r, unsigned long long addend) {
  if (l > r) return;
  if (l == tl && tr == r) {
    t[v] += addend;
    lazy[v] += addend;
  } else {
    t[v * 2 + 1] += lazy[v];
    lazy[v * 2 + 1] += lazy[v];
    t[v * 2 + 2] += lazy[v];
    lazy[v * 2 + 2] += lazy[v];
    lazy[v] = 0;
    int tm = (tl + tr) / 2;
    add(v * 2 + 1, tl, tm, l, min(r, tm), addend);
    add(v * 2 + 2, tm + 1, tr, max(l, tm + 1), r, addend);
    t[v] = min(t[v * 2 + 1], t[v * 2 + 2]);
  }
}
int last_zero(int v, int l, int r) {
  if (l == r) {
    return l;
  } else {
    int m = (r + l) / 2;
    t[v * 2 + 1] += lazy[v];
    lazy[v * 2 + 1] += lazy[v];
    t[v * 2 + 2] += lazy[v];
    lazy[v * 2 + 2] += lazy[v];
    lazy[v] = 0;
    t[v] = min(t[v * 2 + 1], t[v * 2 + 2]);
    if (t[2 * v + 2]) {
      return last_zero(2 * v + 1, l, m);
    }
    return last_zero(2 * v + 2, m + 1, r);
  }
}
int main() {
  const unsigned long long INF = 1e16 + 239;
  int n;
  cin >> n;
  unsigned long long s[n];
  int p[n];
  t.assign(n * 4, INF);
  lazy.assign(n * 4, 0);
  for (int i = 0; i < n; i++) {
    cin >> s[i];
  }
  build(s, 0, 0, n - 1);
  for (int i = 1; i <= n; i++) {
    int pos = last_zero(0, 0, n - 1);
    p[pos] = i;
    add(0, 0, n - 1, pos, pos, INF);
    add(0, 0, n - 1, pos + 1, n - 1, -i);
  }
  for (int i = 0; i < n; i++) {
    cout << p[i] << ' ';
  }
}
