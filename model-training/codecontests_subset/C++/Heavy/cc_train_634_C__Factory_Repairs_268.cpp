#include <bits/stdc++.h>
using namespace std;
class Tree {
 private:
  int limit;
  vector<long long> v;
  long long get(int r) {
    long long res = 0;
    while (r > 0) {
      res += v[r];
      r = (r & (r + 1)) - 1;
    }
    return res;
  }

 public:
  Tree(int n, int lim) : limit(lim) { v.resize((size_t)n + 1, 0); }
  void update(long long val, int pos) {
    val = min(val, limit - range(pos, pos));
    while (pos < v.size()) {
      v[pos] += val;
      pos = pos | (pos + 1);
    }
  }
  long long range(int l, int r) { return get(r) - get(l - 1); }
};
void solve() {
  int n, k, a, b, q, type, pos, val;
  cin >> n >> k >> a >> b >> q;
  Tree before(n, b), after(n, a);
  for (int i = 0; i < q; ++i) {
    cin >> type;
    if (type == 1) {
      cin >> pos >> val;
      before.update(val, pos);
      after.update(val, pos);
    } else {
      cin >> pos;
      int l = 1, r = pos - 1;
      long long res = 0;
      if (l <= r) {
        res += before.range(l, r);
      }
      l = pos + k;
      r = n;
      if (l <= r) {
        res += after.range(l, r);
      }
      cout << res << endl;
    }
  }
}
int main() {
  solve();
  return 0;
}
