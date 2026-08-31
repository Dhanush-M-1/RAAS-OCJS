#include <bits/stdc++.h>
using namespace std;
int setBit(int n, int pos) { return n = n | (1 << pos); }
int resetBit(int n, int pos) { return n = n & ~(1 << pos); }
bool checkBit(int n, int pos) { return (bool)(n & (1 << pos)); }
const int MAX = 1e5 + 10;
struct node {
  int mn, mx;
} tree[4 * MAX];
int ara[MAX], cum[MAX];
vector<int> ck;
int lazy[4 * MAX];
node Merge(node a, node b) {
  node ret;
  ret.mn = min(a.mn, b.mn);
  ret.mx = max(a.mx, b.mx);
  return ret;
}
void lazyUpdate(int node, int st, int ed) {
  if (lazy[node]) {
    tree[node].mn += lazy[node];
    tree[node].mx += lazy[node];
    if (st != ed) {
      int left = node << 1, right = left | 1;
      lazy[left] += lazy[node];
      lazy[right] += lazy[node];
    }
    lazy[node] = 0;
  }
}
void build(int node, int st, int ed) {
  lazy[node] = 0;
  int left = node << 1, right = left | 1, mid = (st + ed) >> 1;
  if (st == ed) {
    tree[node].mn = tree[node].mx = cum[st];
    return;
  }
  build(left, st, mid);
  build(right, mid + 1, ed);
  tree[node] = Merge(tree[left], tree[right]);
}
void update(int node, int st, int ed, int i, int j, int v) {
  int left = node << 1, right = left | 1, mid = (st + ed) >> 1;
  lazyUpdate(node, st, ed);
  if (st > j || ed < i) return;
  if (st >= i && ed <= j) {
    lazy[node] += v;
    lazyUpdate(node, st, ed);
    return;
  }
  update(left, st, mid, i, j, v);
  update(right, mid + 1, ed, i, j, v);
  tree[node] = Merge(tree[left], tree[right]);
}
node query(int node, int st, int ed, int i, int j) {
  lazyUpdate(node, st, ed);
  int left = node << 1, right = left | 1, mid = (st + ed) >> 1;
  if (st >= i && ed <= j) return tree[node];
  if (i > mid)
    return query(right, mid + 1, ed, i, j);
  else if (j <= mid)
    return query(left, st, mid, i, j);
  else
    return Merge(query(right, mid + 1, ed, i, j), query(left, st, mid, i, j));
}
int main() {
  int n, d, i;
  scanf("%d %d", &n, &d);
  cum[0] = 0;
  for (i = 1; i <= n; i++) {
    scanf("%d", &ara[i]);
    cum[i] = cum[i - 1] + ara[i];
    if (ara[i] == 0) ck.push_back(i);
  }
  build(1, 1, n);
  int last = 1, cnt = 0;
  node now, lala;
  int y, x;
  for (i = 0; i < ck.size(); i++) {
    x = ck[i];
    now = query(1, 1, n, x, x);
    if (now.mn < 0) {
      lala = query(1, 1, n, x, n);
      y = d - lala.mx;
      if (y + now.mn >= 0) {
        update(1, 1, n, x, n, y);
        cnt++;
      } else {
        puts("-1");
        return 0;
      }
    }
  }
  now = query(1, 1, n, 1, n);
  if (now.mx > d) {
    printf("-1\n");
  } else
    printf("%d\n", cnt);
  return 0;
}
