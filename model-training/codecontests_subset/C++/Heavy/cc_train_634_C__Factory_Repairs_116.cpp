#include <bits/stdc++.h>
using namespace std;
const int NMAX = 200005;
int n, k, a, b, q, sol;
int A[4 * NMAX], B[4 * NMAX], v[NMAX];
void update(int node, int l, int r, int poz, int val) {
  if (l == r) {
    v[l] += val;
    A[node] = min(v[l], a);
    B[node] = min(v[l], b);
    return;
  }
  int m = (l + r) / 2;
  int ls = 2 * node;
  int rs = 2 * node + 1;
  if (poz <= m)
    update(ls, l, m, poz, val);
  else
    update(rs, m + 1, r, poz, val);
  A[node] = A[ls] + A[rs];
  B[node] = B[ls] + B[rs];
}
int queryA(int node, int l, int r, int x, int y) {
  if (l >= x && r <= y) {
    return A[node];
  }
  int m = (l + r) / 2;
  int ls = 2 * node;
  int rs = 2 * node + 1;
  int X = 0;
  int Y = 0;
  if (x <= m) X = queryA(ls, l, m, x, y);
  if (y > m) Y = queryA(rs, m + 1, r, x, y);
  return X + Y;
}
int queryB(int node, int l, int r, int x, int y) {
  if (l >= x && r <= y) {
    return B[node];
  }
  int m = (l + r) / 2;
  int ls = 2 * node;
  int rs = 2 * node + 1;
  int X = 0;
  int Y = 0;
  if (x <= m) X = queryB(ls, l, m, x, y);
  if (y > m) Y = queryB(rs, m + 1, r, x, y);
  return X + Y;
}
int main() {
  cin.sync_with_stdio(false);
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  swap(a, b);
  for (; q; q--) {
    int op;
    scanf("%d", &op);
    if (op == 1) {
      int d, x;
      scanf("%d%d", &d, &x);
      update(1, 1, n, d, x);
    } else {
      int x;
      scanf("%d", &x);
      sol = 0;
      if (x - 1 >= 1) sol += queryA(1, 1, n, 1, x - 1);
      if (x + k <= n) sol += queryB(1, 1, n, x + k, n);
      printf("%d\n", sol);
    }
  }
  return 0;
}
