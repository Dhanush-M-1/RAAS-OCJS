#include <bits/stdc++.h>
using namespace std;
long long bigmod(long long b, long long p) {
  if (p == 0) return 1;
  long long my = bigmod(b, p / 2);
  my *= my;
  my %= 1000000007;
  if (p & 1) my *= b, my %= 1000000007;
  return my;
}
int setb(int n, int pos) { return n = n | (1 << pos); }
int resb(int n, int pos) { return n = n & ~(1 << pos); }
bool checkb(int n, int pos) { return (bool)(n & (1 << pos)); }
int n, k, A, B, q;
int tree[4 * 200005][2], ara[200005];
inline int max(int a, int b) { return (a > b) ? a : b; }
inline int min(int a, int b) { return (a < b) ? a : b; }
void U(int ind, int b, int e, int i, int x) {
  if (b == e) {
    tree[ind][0] = min(x, B);
    tree[ind][1] = min(x, A);
    return;
  }
  int mid = (b + e) / 2, l = 2 * ind, r = l + 1;
  if (i <= mid)
    U(l, b, mid, i, x);
  else
    U(r, mid + 1, e, i, x);
  tree[ind][0] = tree[l][0] + tree[r][0];
  tree[ind][1] = tree[l][1] + tree[r][1];
}
int Q(int ind, int b, int e, int i, int j, int f) {
  if (i > j) return 0;
  if (b == i && e == j) return tree[ind][f];
  int mid = (b + e) / 2, l = 2 * ind, r = l + 1;
  return Q(l, b, mid, i, min(j, mid), f) +
         Q(r, mid + 1, e, max(mid + 1, i), j, f);
}
int cnt, c;
int fun(int p) {
  int l, r, ret = 0;
  l = 1;
  r = p - 1;
  if (l <= r) ret += Q(1, 1, n, l, r, 0);
  l = p + k;
  r = n;
  if (l <= r) ret += Q(1, 1, n, l, r, 1);
  return ret;
}
int main() {
  int i, j, ins, x, y;
  scanf("%d %d", &n, &k);
  scanf("%d %d", &A, &B);
  scanf("%d", &q);
  for (i = 1; i <= q; i++) {
    c++;
    scanf("%d", &ins);
    if (ins == 1) {
      scanf("%d %d", &x, &y);
      ara[x] += y;
      U(1, 1, n, x, ara[x]);
    } else {
      scanf("%d", &x);
      int my = 0;
      my = fun(x);
      printf("%d", my);
      printf("\n");
    }
  }
  return 0;
}
