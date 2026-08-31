#include <bits/stdc++.h>
using namespace std;
template <class X, class Y>
bool minimize(X &x, const Y &y) {
  X eps = 1e-9;
  if (x > y + eps) {
    x = y;
    return true;
  } else
    return false;
}
template <class X, class Y>
bool maximize(X &x, const Y &y) {
  X eps = 1e-9;
  if (x + eps < y) {
    x = y;
    return true;
  } else
    return false;
}
template <class T>
T Abs(const T &x) {
  return (x < 0 ? -x : x);
}
class SegmentTree {
 private:
  int n;
  vector<pair<long long, int>> tree;
  vector<long long> lazy;
  void build(long long a[], int i, int l, int r) {
    if (l == r) {
      tree[i] = make_pair(a[l], -l);
      return;
    }
    int m = (l + r) >> 1;
    build(a, 2 * i, l, m);
    build(a, 2 * i + 1, m + 1, r);
    tree[i] = min(tree[2 * i], tree[2 * i + 1]);
  }
  void pushDown(int i) {
    for (int j = (2 * i), _b = (2 * i + 1); j <= _b; j++) {
      tree[j].first += lazy[i];
      lazy[j] += lazy[i];
    }
    lazy[i] = 0;
  }
  void update(int i, int l, int r, int u, int v, long long c) {
    if (l > v || r < u || l > r || v < u) return;
    if (u <= l && r <= v) {
      tree[i].first += c;
      lazy[i] += c;
      return;
    }
    pushDown(i);
    int m = (l + r) >> 1;
    update(2 * i, l, m, u, v, c);
    update(2 * i + 1, m + 1, r, u, v, c);
    tree[i] = min(tree[2 * i], tree[2 * i + 1]);
  }

 public:
  SegmentTree(int n = 0, long long a[] = NULL) {
    this->n = n;
    if (n > 0) {
      tree.assign(4 * n + 7, pair<long long, int>());
      lazy.assign(4 * n + 7, 0);
      build(a, 1, 1, n);
    }
  }
  void update(int l, int r, long long c) { update(1, 1, n, l, r, c); }
  int getZeroPos(void) const {
    return tree[1].first == 0 ? -tree[1].second : -1;
  }
};
const long long INF = (long long)1e18 + 7LL;
long long a[200200];
int perm[200200], n;
void process(void) {
  cin >> n;
  for (int i = (1), _b = (n); i <= _b; i++) cin >> a[i];
  SegmentTree myit(n, a);
  for (int i = (1), _b = (n); i <= _b; i++) {
    int pos = myit.getZeroPos();
    assert(pos > 0);
    perm[pos] = i;
    myit.update(pos + 1, n, -i);
    myit.update(pos, pos, INF);
  }
  for (int i = (1), _b = (n); i <= _b; i++) printf("%d ", perm[i]);
  printf("\n");
}
int main(void) {
  process();
  return 0;
}
