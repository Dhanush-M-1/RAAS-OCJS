#include <bits/stdc++.h>
using namespace std;
const long long maxn = 6e6;
const long long inf = 1e9;
const long long maxv = 2e8 + 100;
void init() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
}
struct point {
  long long x, v;
  point() {}
};
vector<point> foo;
unordered_map<long long, pair<long long, long long>> tree(maxn);
const long long toadd = 1e8 + 1;
inline long long f(long long i) { return i & (i + 1); }
void inc(long long st) {
  long long ind = foo[st].v + toadd;
  while (ind < maxv) {
    tree[ind].first++;
    tree[ind].second += foo[st].x;
    ind |= (ind + 1);
  }
}
pair<long long, long long> operator+(const pair<long long, long long> &a,
                                     const pair<long long, long long> &b) {
  return {a.first + b.first, a.second + b.second};
}
pair<long long, long long> prefsum(long long ind) {
  pair<long long, long long> res = {0, 0};
  while (ind >= 0) {
    res = res + tree[ind];
    ind = f(ind) - 1;
  }
  return res;
}
int main() {
  init();
  tree.rehash(maxn);
  long long n;
  cin >> n;
  foo.resize(n);
  for (long long i = 0; i < n; i++) {
    cin >> foo[i].x;
  }
  for (long long i = 0; i < n; i++) {
    cin >> foo[i].v;
  }
  sort(foo.begin(), foo.end(),
       [&](point &p1, point &p2) { return p1.x < p2.x; });
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    auto cur = prefsum(foo[i].v + toadd);
    ans += (cur.first * foo[i].x - cur.second);
    inc(i);
  }
  cout << ans << endl;
  return 0;
}
