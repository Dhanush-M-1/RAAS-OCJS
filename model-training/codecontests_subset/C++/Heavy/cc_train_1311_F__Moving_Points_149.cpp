#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 1000;
const long long M = 1e5 + 10;
const long long inf = 1e9 + 7;
const long long Mod = 1e9 + 7;
const double eps = 1e-6;
int T;
pair<int, int> a[N];
int b[N];
int n;
pair<long long, long long> sg[4 * N];
void build(int k, int l, int r) {
  if (l == r) {
    sg[k].first = 0;
    sg[k].second = 0;
    return;
  }
  build(2 * k, l, (l + r) / 2);
  build(2 * k + 1, (l + r) / 2 + 1, r);
}
void up(int k) {
  sg[k].first = sg[2 * k].first + sg[2 * k + 1].first;
  sg[k].second = sg[2 * k].second + sg[2 * k + 1].second;
}
void modify(int k, int l, int r, int pos, int val) {
  if (l == r) {
    sg[k].first += val;
    sg[k].second++;
    return;
  }
  if (pos <= (l + r) / 2)
    modify(2 * k, l, (l + r) / 2, pos, val);
  else if (pos > (l + r) / 2)
    modify(2 * k + 1, (l + r) / 2 + 1, r, pos, val);
  up(k);
}
pair<long long, long long> query(int k, int l, int r, int L, int R) {
  if (L <= l && r <= R) return sg[k];
  pair<long long, long long> res{0, 0};
  pair<long long, long long> cur;
  if (L <= (l + r) / 2) {
    cur = query(2 * k, l, (l + r) / 2, L, R);
    res.first += cur.first;
    res.second += cur.second;
  };
  if (R > (l + r) / 2) {
    cur = query(2 * k + 1, (l + r) / 2 + 1, r, L, R);
    res.first += cur.first;
    res.second += cur.second;
  }
  return res;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].first);
  }
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].second);
    b[i] = a[i].second;
  }
  sort(a + 1, a + n + 1);
  sort(b + 1, b + n + 1);
  int len = unique(b + 1, b + n + 1) - b - 1;
  build(1, 1, len);
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    int id = lower_bound(b + 1, b + len + 1, a[i].second) - b;
    pair<long long, long long> cur = query(1, 1, n, 1, id);
    ans -= cur.first - cur.second * a[i].first;
    modify(1, 1, n, id, a[i].first);
  }
  printf("%lld", ans);
  return 0;
}
