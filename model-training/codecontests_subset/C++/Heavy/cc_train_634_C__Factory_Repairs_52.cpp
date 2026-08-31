#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 100;
long long a[N];
struct node {
  int l, r;
  long long sum;
} tree1[N * 4], tree2[N * 4];
long long aa, bb;
void pushup1(int cur) {
  tree1[cur].sum = tree1[cur * 2].sum + tree1[cur * 2 + 1].sum;
}
void pushup2(int cur) {
  tree2[cur].sum = tree2[cur * 2].sum + tree2[cur * 2 + 1].sum;
}
void build1(int cur, int l, int r) {
  tree1[cur].l = l;
  tree1[cur].r = r;
  if (tree1[cur].l == tree1[cur].r) {
    tree1[cur].sum = 0;
    return;
  }
  int mid = (l + r) / 2;
  build1(cur * 2, l, mid);
  build1(cur * 2 + 1, mid + 1, r);
  pushup1(cur);
}
void build2(int cur, int l, int r) {
  tree2[cur].l = l;
  tree2[cur].r = r;
  if (tree2[cur].l == tree2[cur].r) {
    tree2[cur].sum = 0;
    return;
  }
  int mid = (l + r) / 2;
  build2(cur * 2, l, mid);
  build2(cur * 2 + 1, mid + 1, r);
  pushup2(cur);
}
void updata1(int cur, int x, long long y) {
  if (tree1[cur].l == tree1[cur].r) {
    tree1[cur].sum = min(tree1[cur].sum + y, bb);
    return;
  }
  if (x <= tree1[cur * 2].r)
    updata1(cur * 2, x, y);
  else
    updata1(cur * 2 + 1, x, y);
  pushup1(cur);
}
void updata2(int cur, int x, long long y) {
  if (tree2[cur].l == tree2[cur].r) {
    tree2[cur].sum = min(tree2[cur].sum + y, aa);
    return;
  }
  if (x <= tree2[cur * 2].r)
    updata2(cur * 2, x, y);
  else
    updata2(cur * 2 + 1, x, y);
  pushup2(cur);
}
long long query1(int cur, int x, int y) {
  if (x <= tree1[cur].l && tree1[cur].r <= y) return tree1[cur].sum;
  long long res = 0;
  if (x <= tree1[cur * 2].r) res += query1(cur * 2, x, y);
  if (y >= tree1[cur * 2 + 1].l) res += query1(cur * 2 + 1, x, y);
  return res;
}
long long query2(int cur, int x, int y) {
  if (x <= tree2[cur].l && tree2[cur].r <= y) return tree2[cur].sum;
  long long res = 0;
  if (x <= tree2[cur * 2].r) res += query2(cur * 2, x, y);
  if (y >= tree2[cur * 2 + 1].l) res += query2(cur * 2 + 1, x, y);
  return res;
}
int main() {
  int n, k;
  int q;
  int op;
  int x;
  long long z;
  long long ans;
  while (~scanf("%d%d%lld%lld%d", &n, &k, &aa, &bb, &q)) {
    build1(1, 1, n);
    build2(1, 1, n);
    while (q--) {
      scanf("%d", &op);
      if (op == 1) {
        scanf("%d%lld", &x, &z);
        updata1(1, x, z);
        updata2(1, x, z);
      } else {
        scanf("%d", &x);
        ans = 0;
        if (x - 1 >= 1) ans += query1(1, 1, x - 1);
        if (x + k <= n) ans += query2(1, x + k, n);
        printf("%lld\n", ans);
      }
    }
  }
  return 0;
}
