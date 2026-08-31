#include <bits/stdc++.h>
using namespace std;
int N, D, A, B, Q, op, p, v;
int tree[2][200100], lo[200100], hi[200100];
void update(int *Tree, int p, int v) {
  assert(p > 0);
  while (p < 200100) {
    Tree[p] += v;
    p += p & -p;
  }
}
int query(int *Tree, int p) {
  int ret = 0;
  while (p > 0) {
    ret += Tree[p];
    p -= p & (-p);
  }
  return ret;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> N >> D >> A >> B >> Q;
  for (int q = 0; q < Q; q++) {
    cin >> op;
    if (op == 1) {
      cin >> p >> v;
      int lo2 = min(B, lo[p] + v);
      update(tree[0], p, lo2 - lo[p]);
      lo[p] = lo2;
      int hi2 = min(A, hi[p] + v);
      update(tree[1], p, hi2 - hi[p]);
      hi[p] = hi2;
    } else {
      cin >> p;
      cout << query(tree[0], p - 1) + query(tree[1], N) -
                  query(tree[1], p + D - 1)
           << "\n";
    }
  }
}
