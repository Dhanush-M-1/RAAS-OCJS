#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
const int MAXN = 2e5 + 20;
const int SIZE = (1 << 19) + 20;
long long s[MAXN];
int ans[MAXN];
struct Segment_tree {
  struct Node {
    int sl, sr;
    long long val;
  } tree[SIZE];
  inline void update(int root) {
    tree[root].val = tree[(root << 1)].val + tree[(root << 1 | 1)].val;
  }
  inline void build(int root, int l, int r) {
    tree[root].sl = l;
    tree[root].sr = r;
    if (l == r) {
      tree[root].val = l;
      return;
    }
    build((root << 1), l, ((tree[root].sl + tree[root].sr) >> 1));
    build((root << 1 | 1), ((tree[root].sl + tree[root].sr) >> 1) + 1, r);
    update(root);
  }
  inline int find(int root, long long v) {
    if (tree[root].sl == tree[root].sr) {
      tree[root].val = 0;
      return tree[root].sl;
    }
    int res = 0;
    if (tree[(root << 1)].val > v) {
      res = find((root << 1), v);
    } else {
      res = find((root << 1 | 1), v - tree[(root << 1)].val);
    }
    update(root);
    return res;
  }
} Tree;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  int n;
  cin >> n;
  for (register int i = (1); i <= (n); ++i) {
    cin >> s[i];
  }
  Tree.build(1, 1, n);
  for (register int i = (n); i >= (1); --i) {
    ans[i] = Tree.find(1, s[i]);
  }
  for (register int i = (1); i <= (n); ++i) {
    cout << ans[i] << ' ';
  }
  cout << '\n';
  return 0;
}
