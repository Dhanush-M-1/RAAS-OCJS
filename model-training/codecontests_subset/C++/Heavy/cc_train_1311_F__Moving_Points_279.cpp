#include <bits/stdc++.h>
using namespace std;
struct tree {
  tree* l;
  tree* r;
  long long sum;
  long long cnt;
  tree() {
    l = r = nullptr;
    sum = cnt = 0;
  }
}* rt = new tree;
tree* get_l(tree* v) {
  if (!v->l) {
    v->l = new tree;
  }
  return v->l;
}
tree* get_r(tree* v) {
  if (!v->r) {
    v->r = new tree;
  }
  return v->r;
}
void add(tree* v, long long l, long long r, long long V, long long x) {
  v->cnt++;
  v->sum += x;
  if (l == r - 1) {
    return;
  }
  long long m = (l + r) / 2;
  if (V < m)
    add(get_l(v), l, m, V, x);
  else
    add(get_r(v), m, r, V, x);
}
pair<long long, long long> get_sum(tree* v, long long l, long long r,
                                   long long L, long long R) {
  if (r <= L || l >= R) return {0, 0};
  if (L <= l && r <= R) return {v->sum, v->cnt};
  long long m = (l + r) / 2;
  pair<long long, long long> t1 = get_sum(get_l(v), l, m, L, R);
  pair<long long, long long> t2 = get_sum(get_r(v), m, r, L, R);
  return {t1.first + t2.first, t1.second + t2.second};
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  vector<pair<long long, long long>> xv(n);
  for (long long i = 0; i < n; ++i) {
    cin >> xv[i].first;
  }
  for (long long i = 0; i < n; ++i) {
    cin >> xv[i].second;
    xv[i].second += 1e8;
  }
  long long MX_V = 2e8 + 10;
  sort(xv.begin(), xv.end());
  long long res = 0;
  for (long long i = 0; i < n; ++i) {
    pair<long long, long long> k = get_sum(rt, 0, MX_V, 0, xv[i].second + 1);
    res += xv[i].first * k.second - k.first;
    add(rt, 0, MX_V, xv[i].second, xv[i].first);
  }
  cout << res << endl;
  return 0;
}
