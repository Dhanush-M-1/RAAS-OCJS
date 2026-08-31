#include <bits/stdc++.h>
using namespace std;
int cas = 1, T;
int n, k, a, b, q;
int c[200000 + 100][2];
int A[200000 + 100];
int lowbit(int x) { return x & (-x); }
void update(int x, int y, int z) {
  for (int i = x; i < 200000 + 100; i += lowbit(i)) c[i][z] += y;
}
int query(int x, int z) {
  int res = 0;
  for (int i = x; i; i -= lowbit(i)) res += c[i][z];
  return res;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  while (q--) {
    int op;
    scanf("%d", &op);
    if (op == 1) {
      int x, y;
      scanf("%d%d", &x, &y);
      int temp = A[x];
      A[x] += y;
      update(x, min(b, A[x]) - min(b, temp), 0);
      update(x, min(a, A[x]) - min(a, temp), 1);
    } else {
      int x;
      scanf("%d", &x);
      printf("%d\n", query(x - 1, 0) + query(n, 1) - query(x + k - 1, 1));
    }
  }
  return 0;
}
