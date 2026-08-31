#include <bits/stdc++.h>
using namespace std;
struct bit {
  vector<int> tree;
  int N;
  bit(int _N) {
    N = _N + 1;
    tree = vector<int>(N, 0);
  }
  void update(int ind, int value) {
    ind++;
    while (ind < N) {
      tree[ind] += value;
      ind += (ind & -ind);
    }
  }
  int get(int ind) {
    int sum = 0;
    while (ind > 0) {
      sum += tree[ind];
      ind -= (ind & -ind);
    }
    return sum;
  }
  int get(int ind1, int ind2) {
    if (ind1 >= ind2) return 0;
    return get(ind2) - get(ind1);
  }
};
int main() {
  int n, k, a, b, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  bit bef(n + k + 10), aft(n + k + 10);
  vector<int> val(n + k + 10, 0);
  while (q--) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, ai;
      scanf("%d %d", &d, &ai);
      bef.update(d, -min(val[d], b));
      aft.update(d, -min(val[d], a));
      val[d] += ai;
      bef.update(d, min(val[d], b));
      aft.update(d, min(val[d], a));
    } else {
      int p;
      scanf("%d", &p);
      printf("%d\n", bef.get(p) + aft.get(p + k, n + 5));
    }
  }
  return 0;
}
