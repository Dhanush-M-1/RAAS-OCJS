#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 9;
long long s[maxn];
int p[maxn];
int vis[maxn];
int temp;
struct node {
  int l, r;
  long long minn, lazy;
} tree[maxn << 2];
void BT(int p, int l, int r) {
  tree[p].l = l, tree[p].r = r;
  if (l == r) {
    tree[p].minn = s[l];
    tree[p].lazy = 0;
    return;
  }
  int mid = (l + r) >> 1;
  BT(p << 1, l, mid);
  BT(p << 1 | 1, mid + 1, r);
  tree[p].minn = min(tree[p << 1].minn, tree[p << 1 | 1].minn);
  tree[p].lazy = 0;
}
void spread(int p) {
  tree[p << 1].lazy += tree[p].lazy;
  tree[p << 1].minn -= tree[p].lazy;
  tree[p << 1 | 1].lazy += tree[p].lazy;
  tree[p << 1 | 1].minn -= tree[p].lazy;
  tree[p].lazy = 0;
}
void Query(int p) {
  if (tree[p].l == tree[p].r) {
    tree[p].minn = 0x3f3f3f3f3f3f3f3f;
    temp = tree[p].l;
    return;
  }
  spread(p);
  if (tree[p << 1 | 1].minn == 0) {
    Query(p << 1 | 1);
  } else
    Query(p << 1);
  tree[p].minn = min(tree[p << 1].minn, tree[p << 1 | 1].minn);
}
void Update(int p, int l, int r, int v) {
  if (tree[p].l >= l && tree[p].r <= r) {
    tree[p].lazy += v;
    tree[p].minn -= v;
    return;
  }
  spread(p);
  int mid = (tree[p].l + tree[p].r) >> 1;
  if (l > mid) {
    Update(p << 1 | 1, l, r, v);
  } else if (r <= mid)
    Update(p << 1, l, r, v);
  else {
    Update(p << 1 | 1, l, r, v);
    Update(p << 1, l, r, v);
  }
  tree[p].minn = min(tree[p << 1].minn, tree[p << 1 | 1].minn);
}
int main() {
  int n;
  while (scanf("%d", &n) != EOF) {
    memset(vis, 0, sizeof(vis));
    for (int i = 1; i <= n; i++) {
      scanf("%lld", &s[i]);
    }
    BT(1, 1, n);
    for (int i = 1; i <= n; i++) {
      Query(1);
      p[temp] = i;
      if (temp < n) Update(1, temp + 1, n, i);
    }
    for (int i = 1; i <= n; i++) {
      if (i == 1)
        printf("%d", p[i]);
      else
        printf(" %d", p[i]);
    }
    printf("\n");
  }
}
