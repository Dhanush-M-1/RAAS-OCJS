#include <bits/stdc++.h>
using namespace std;
const int maxN = 200000 + 5;
int n;
class FTree {
 protected:
  int* t;
  int sumR(int r) {
    int res = 0;
    for (; r >= 0; r = (r & (r + 1)) - 1) {
      res += t[r];
    }
    return res;
  }

 public:
  FTree() {
    t = new int[maxN];
    for (int i = 0; i < maxN; i++) {
      t[i] = 0;
    }
  }
  void update(int i, int delta) {
    for (; i < n; i = i | (i + 1)) {
      t[i] += delta;
    }
  }
  int sum(int l, int r) { return sumR(r) - sumR(l - 1); }
};
int val[maxN] = {0};
int main() {
  int k, a, b, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  FTree f, s;
  int type, x, y;
  while (q--) {
    scanf("%d", &type);
    if (type == 1) {
      scanf("%d %d", &x, &y);
      f.update(x - 1, max(0, min(b, val[x - 1] + y) - val[x - 1]));
      s.update(x - 1, max(0, min(a, val[x - 1] + y) - val[x - 1]));
      val[x - 1] += y;
    } else {
      scanf("%d", &x);
      printf("%d\n", f.sum(0, x - 2) + s.sum(x + k - 1, n - 1));
    }
  }
  return 0;
}
