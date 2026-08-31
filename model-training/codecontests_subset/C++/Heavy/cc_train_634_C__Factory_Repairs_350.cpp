#include <bits/stdc++.h>
using namespace std;
struct FenwickTree {
  vector<long long> tree;
  FenwickTree(int n) : tree(n + 1) {}
  long long sum(int pos) {
    ++pos;
    int ret = 0;
    while (pos > 0) {
      ret += tree[pos];
      pos &= (pos - 1);
    }
    return ret;
  }
  void add(int pos, long long val) {
    ++pos;
    while (pos < tree.size()) {
      tree[pos] += val;
      pos += (pos & -pos);
    }
  }
};
const int mx = 2e5 + 5;
vector<long long> v(mx, 0), w(mx, 0);
int main() {
  FenwickTree x(mx), y(mx);
  long long n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int t;
    cin >> t;
    if (t == 1) {
      long long di, ai;
      cin >> di >> ai;
      long long first = min(b - v[di], ai);
      long long second = min(a - w[di], ai);
      v[di] += first;
      w[di] += second;
      x.add(di, first);
      y.add(di, second);
    } else {
      int p;
      cin >> p;
      cout << x.sum(p - 1) + y.sum(n) - y.sum(p + k - 1) << endl;
    }
  }
  return 0;
}
