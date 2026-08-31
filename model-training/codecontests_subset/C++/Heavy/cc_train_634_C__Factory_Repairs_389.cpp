#include <bits/stdc++.h>
using namespace std;
struct Node {
  int sum, add, lo, hi;
  Node *le, *ri;
  static Node* Build(int lo, int hi) {
    Node* root = new Node();
    root->lo = lo, root->hi = hi;
    root->sum = root->add = 0;
    root->le = root->ri = NULL;
    if (lo != hi)
      root->le = Build(lo, (lo + hi) >> 1),
      root->ri = Build(((lo + hi) >> 1) + 1, hi);
    return root;
  }
  void PushDown() {
    if (add == 0) return;
    if (le) {
      le->add += add;
      ri->add += add;
      le->sum += add * (le->hi - le->lo + 1);
      ri->sum += add * (ri->hi - ri->lo + 1);
      add = 0;
    }
  }
  void Add(int fr, int to, int how) {
    if (to < lo || fr > hi) return;
    if (fr <= lo && hi <= to) {
      add += how;
      sum += (hi - lo + 1) * how;
    } else {
      PushDown();
      le->Add(fr, to, how);
      ri->Add(fr, to, how);
      sum = le->sum + ri->sum;
    }
  }
  int Get(int fr, int to) {
    if (fr > to) return 0;
    if (to < lo || fr > hi) return 0;
    if (fr <= lo && hi <= to) return sum;
    PushDown();
    return le->Get(fr, to) + ri->Get(fr, to);
  }
};
int main() {
  int n, k, a, b, q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  Node* pref = Node::Build(0, n - 1);
  Node* suff = Node::Build(0, n - 1);
  vector<int> pref_c(n, 0), suff_c(n, 0);
  for (int i = 0; i < q; ++i) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, add;
      scanf("%d%d", &d, &add);
      --d;
      int ptake = min(b - pref_c[d], add);
      int stake = min(a - suff_c[d], add);
      pref_c[d] += ptake;
      suff_c[d] += stake;
      pref->Add(d, n - 1, ptake);
      suff->Add(0, d, stake);
    } else {
      int p;
      scanf("%d", &p);
      --p;
      int ans = 0;
      if (p) ans += pref->Get(p - 1, p - 1);
      if (p + k < n) ans += suff->Get(p + k, p + k);
      printf("%d\n", ans);
    }
  }
  return 0;
}
