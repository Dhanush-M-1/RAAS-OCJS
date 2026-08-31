#include <bits/stdc++.h>
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("O3")
#pragma GCC optimize("fast-math")
#pragma GCC optimize("Ofast")
using namespace std;
const int INF = 1e9 + 10;
const long long INFll = 2e18;
const int BASE1 = 179;
const int BASE2 = 653;
const long long MOD = 998244353;
const int MAXA = 2000001;
const int MAXN = 2e5 + 1;
const int MAXLOG = 22;
const long long COST = 1000 * 1000 * 1000;
const long double PI = 3.1415926535;
const long double EPS = 1e-15;
struct SegmentTree {
  vector<pair<long long, long long> > tree;
  vector<long long> arr, add;
  SegmentTree(vector<long long>& a) {
    tree.resize(4 * ((int)(a).size()), make_pair(INF, -1));
    add.resize(4 * ((int)(a).size()), 0);
    arr = a;
    build(0, 0, ((int)(arr).size()));
  }
  void build(long long v, long long left, long long right) {
    if (left + 1 == right) {
      tree[v] = make_pair(arr[left], -left);
      return;
    }
    long long mid = (left + right) / 2;
    build(2 * v + 1, left, mid);
    build(2 * v + 2, mid, right);
    tree[v] = min(tree[2 * v + 1], tree[2 * v + 2]);
  }
  void push(long long v, long long left, long long right) {
    if (add[v] == 0) return;
    tree[v].first += add[v];
    if (left != right - 1) {
      add[2 * v + 1] += add[v];
      add[2 * v + 2] += add[v];
    }
    add[v] = 0;
  }
  void addval(long long v, long long left, long long right, long long lq,
              long long rq, long long val) {
    push(v, left, right);
    if (left >= rq || lq >= right) return;
    if (lq <= left && rq >= right) {
      add[v] += val;
      push(v, left, right);
      return;
    }
    long long mid = (left + right) / 2;
    addval(2 * v + 1, left, mid, lq, rq, val);
    addval(2 * v + 2, mid, right, lq, rq, val);
    tree[v] = min(tree[2 * v + 1], tree[2 * v + 2]);
  }
  pair<long long, long long> getMin(long long v, long long left,
                                    long long right, long long lq,
                                    long long rq) {
    push(v, left, right);
    if (left >= lq && right <= rq)
      return tree[v];
    else if (left >= rq || right <= lq)
      return make_pair(INF, -1);
    long long mid = (left + right) / 2;
    return min(getMin(2 * v + 1, left, mid, lq, rq),
               getMin(2 * v + 2, mid, right, lq, rq));
  }
};
void solve() {
  long long n;
  cin >> n;
  vector<long long> a(n);
  for (int i = 0; i < (n); i++) cin >> a[i];
  SegmentTree tree(a);
  vector<long long> p(n, -1);
  for (int i = 0; i < (n); i++) {
    auto pos = tree.getMin(0, 0, n, 0, n);
    p[-pos.second] = i + 1;
    tree.addval(0, 0, n, -pos.second, -pos.second + 1, INFll);
    tree.addval(0, 0, n, -pos.second + 1, n, -i - 1);
  }
  for (int i = 0; i < (n); i++) cout << p[i] << " ";
  cout << "\n";
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
