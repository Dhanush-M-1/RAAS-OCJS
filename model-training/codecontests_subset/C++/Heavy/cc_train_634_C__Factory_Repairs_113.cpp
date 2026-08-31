#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q;
struct Fenwick {
  int sum(int i) {
    if (i < 1 || i > n) return 0;
    int s = 0;
    while (i > 0) s += tree[i], i -= i & -i;
    return s;
  }
  void add(int i, int x) {
    int cur = sum(i) - sum(i - 1);
    if (cur + x > lim) x = lim - cur;
    while (i <= n) tree[i] += x, i += i & -i;
  }
  int tree[223456], lim;
};
Fenwick pre, suf;
int main() {
  cin >> n >> k >> a >> b >> q;
  pre.lim = b;
  suf.lim = a;
  for (int i(0); i < q; i++) {
    int t;
    cin >> t;
    ;
    if (t == 1) {
      int di;
      cin >> di;
      int ai;
      cin >> ai;
      ;
      pre.add(di, ai);
      suf.add(n - di + 1, ai);
    } else {
      int pi;
      cin >> pi;
      int tot = 0, en = pi + k;
      tot += pre.sum(pi - 1);
      tot += suf.sum(n - en + 1);
      cout << tot << endl;
    }
  }
  return 0;
}
