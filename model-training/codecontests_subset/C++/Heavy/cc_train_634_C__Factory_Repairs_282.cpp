#include <bits/stdc++.h>
using namespace std;
class SEG_TREE {
 private:
  struct node {
    node *left, *right;
    int val = 0;
  };
  node* root;
  int N;
  void build(int start, int end, node*& r) {
    r = new node;
    int mid = (start + end) / 2;
    if (start != end) {
      build(start, mid, r->left);
      build(mid + 1, end, r->right);
    }
  }
  void up(int start, int end, node*& x, int i, int v, int l) {
    int mid = (start + end) / 2;
    if (start == end) {
      x->val = min(x->val + v, l);
      return;
    } else if (i <= mid) {
      up(start, mid, x->left, i, v, l);
    } else {
      up(mid + 1, end, x->right, i, v, l);
    }
    x->val = x->left->val + x->right->val;
  }
  int qu(int start, int end, node*& x, int a, int b) {
    int mid = (start + end) / 2;
    if (start >= a && end <= b) {
      return x->val;
    } else if (start > b || end < a) {
      return 0;
    } else
      return qu(start, mid, x->left, a, b) + qu(mid + 1, end, x->right, a, b);
  }

 public:
  SEG_TREE(int n) {
    N = n;
    build(1, n, root);
  }
  void update(int i, int v, int l) { up(1, N, root, i, v, l); }
  int query(int a, int b) {
    if (b < a) {
      return 0;
    }
    return qu(1, N, root, a, b);
  }
};
int main() {
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  SEG_TREE* t1 = new SEG_TREE(n);
  SEG_TREE* t2 = new SEG_TREE(n);
  int type;
  int d, v, p;
  while (q--) {
    cin >> type;
    if (type == 1) {
      cin >> d >> v;
      t1->update(d, v, a);
      t2->update(d, v, b);
    } else {
      cin >> p;
      cout << t2->query(1, p - 1) + t1->query(p + k, n) << endl;
    }
  }
  return 0;
}
