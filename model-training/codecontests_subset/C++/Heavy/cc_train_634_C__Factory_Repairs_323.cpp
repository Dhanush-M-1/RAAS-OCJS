#include <bits/stdc++.h>
using namespace std;
const int max_n = (1 << 18);
int a, b;
struct Tree {
  vector<pair<int, int> > t;
  Tree() { t.resize(max_n * 2, {0, 0}); }
  int get(int l, int r, int tl, int tr, int v, int type) {
    if (l <= tl && tr <= r) {
      if (type) {
        return t[v].first;
      } else {
        return t[v].second;
      }
    }
    if (l > tr || r < tl) {
      return 0;
    }
    return get(l, r, tl, (tl + tr) / 2, v * 2, type) +
           get(l, r, (tl + tr) / 2 + 1, tr, v * 2 + 1, type);
  }
  void update(int c, int x) {
    c += max_n;
    t[c].first = min(t[c].first + x, a);
    t[c].second = min(t[c].second + x, b);
    c /= 2;
    while (c) {
      t[c].first = t[c * 2].first + t[c * 2 + 1].first;
      t[c].second = t[c * 2].second + t[c * 2 + 1].second;
      c /= 2;
    }
  }
};
int main() {
  int n, k, q;
  cin >> n >> k >> a >> b;
  cin >> q;
  int type;
  Tree T;
  for (int i = 0; i < q; i++) {
    cin >> type;
    if (type == 1) {
      int cnt, num;
      cin >> num >> cnt;
      T.update(num - 1, cnt);
    } else {
      int p;
      cin >> p;
      p--;
      int res = 0;
      res += T.get(0, p - 1, 0, max_n - 1, 1, 0);
      res += T.get(p + k, max_n - 1, 0, max_n - 1, 1, 1);
      cout << res << '\n';
    }
  }
  return 0;
}
