#include <bits/stdc++.h>
using namespace std;
class segment_tree {
 public:
  long long l, r, sum, t, tm, limit;
  segment_tree *left, *right;
  segment_tree(long long _l, long long _r, long long _limit) {
    l = _l;
    r = _r;
    limit = _limit;
    tm = (l + r) / 2;
    left = NULL;
    right = NULL;
    sum = 0;
    t = 0;
  }
  void add() {
    if (left == NULL) left = new segment_tree(l, tm, limit);
    if (right == NULL) right = new segment_tree(tm + 1, r, limit);
  }
  void push() {
    left->t += t;
    right->t += t;
    sum += (r - l + 1) * t;
    t = 0;
  }
  void update_cell(long long pos, long long val) {
    if (l == r) {
      sum = min(sum + val, limit);
    } else {
      add();
      if (pos <= tm)
        left->update_cell(pos, val);
      else
        right->update_cell(pos, val);
      sum = left->sum + right->sum;
    }
  }
  long long get_sum(long long _l, long long _r) {
    if (_l > _r) return 0;
    add();
    push();
    if (l == _l && r == _r) return sum;
    return left->get_sum(_l, min(tm, _r)) + right->get_sum(max(_l, tm + 1), _r);
  }
};
int main() {
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  long long n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  segment_tree *t1 = new segment_tree(0, n - 1, b);
  segment_tree *t2 = new segment_tree(0, n - 1, a);
  for (int it = 0; it < q; it++) {
    int z;
    cin >> z;
    if (z == 1) {
      int d, a;
      cin >> d >> a;
      d--;
      t1->update_cell(d, a);
      t2->update_cell(d, a);
    } else {
      int p;
      cin >> p;
      p--;
      int v1 = 0, v2 = 0;
      if (p) {
        v1 = t1->get_sum(0, p - 1);
      }
      if (p + k <= n - 1) {
        v2 = t2->get_sum(p + k, n - 1);
      }
      cout << v1 + v2 << endl;
    }
  }
  return 0;
}
