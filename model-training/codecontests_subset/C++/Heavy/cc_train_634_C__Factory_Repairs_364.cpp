#include <bits/stdc++.h>
using namespace std;
template <class A, class B>
inline bool mina(A &first, B second) {
  return (first > second) ? (first = second, 1) : 0;
}
template <class A, class B>
inline bool maxa(A &first, B second) {
  return (first < second) ? (first = second, 1) : 0;
}
const int MAXN = 2e5 + 5;
int N, K, A, B, Q;
int total[MAXN];
class SegmentTree {
 public:
  typedef struct segment_st {
    int numa, numb;
    int l, r;
  } TreeNode;
  vector<TreeNode> tree;
  int N;
  int tree_size;
  vector<int> leaves;
  SegmentTree(int n) { build_tree(n); }
  int query(int ll, int rr, int limit) { return query(1, ll, rr, limit); }
  void update(int at, int val) { internal_update(at, val); }

 private:
  void initialize_node(int at) {
    tree[at].numa = 0;
    tree[at].numb = 0;
  }
  void update_up(int at) {
    int left = at + at;
    int right = at + at + 1;
    tree[at].numa = tree[left].numa + tree[right].numa;
    tree[at].numb = tree[left].numb + tree[right].numb;
  }
  void update_result(int &res, int val) { res += val; }
  void update_leaf_value(int at, int &val, int d) {
    tree[at].numa = min(A, total[d]);
    tree[at].numb = min(B, total[d]);
  }
  int query(int at, int ll, int rr, int limit) {
    if (ll > tree[at].r || rr < tree[at].l) return 0;
    if (ll <= tree[at].l && tree[at].r <= rr) {
      if (limit == 0) {
        return tree[at].numb;
      } else {
        return tree[at].numa;
      }
    } else {
      int res = 0;
      update_result(res, query(at + at, ll, rr, limit));
      update_result(res, query(at + at + 1, ll, rr, limit));
      return res;
    }
  }
  void internal_update(int at, int &val) {
    int tmp = at;
    at = leaves[at];
    update_leaf_value(at, val, tmp);
    at >>= 1;
    while (at) {
      update_up(at);
      at >>= 1;
    }
  }
  void build_tree(int n) {
    N = n;
    int base = 1;
    while (base < N) base <<= 1;
    tree_size = base << 1;
    leaves.resize(N + 1);
    tree = vector<TreeNode>(tree_size);
    init(1, 1, n);
  }
  void init(int at, int ll, int rr) {
    tree[at].l = ll;
    tree[at].r = rr;
    initialize_node(at);
    if (ll == rr) {
      leaves[ll] = at;
    } else {
      int mid = (tree[at].l + tree[at].r) >> 1;
      init(at + at, tree[at].l, mid);
      init(at + at + 1, mid + 1, tree[at].r);
      update_up(at);
    }
  }
};
int main() {
  scanf("%d %d %d %d %d", &N, &K, &A, &B, &Q);
  SegmentTree tree(N);
  int c;
  for (int(i) = 0; (i) < (Q); ++(i)) {
    scanf("%d", &c);
    if (c == 1) {
      int d, a;
      scanf("%d %d", &d, &a);
      total[d] += a;
      tree.update(d, a);
    } else {
      int p;
      scanf("%d", &p);
      int res = 0;
      if (p - 1 >= 1) res += tree.query(1, p - 1, 0);
      p += K;
      if (p <= N) res += tree.query(p, N, 1);
      printf("%d\n", res);
    }
  }
  return 0;
}
