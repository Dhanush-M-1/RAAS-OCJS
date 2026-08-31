#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int n, k, a, b, q;
long long tree[2][N << 1];
void update(int i, int x) {
  tree[0][i + n] = min(tree[0][i + n] + x, (long long)a);
  tree[1][i + n] = min(tree[1][i + n] + x, (long long)b);
  for (i += n; i; i >>= 1) {
    tree[0][i >> 1] = tree[0][i] + tree[0][i ^ 1];
    tree[1][i >> 1] = tree[1][i] + tree[1][i ^ 1];
  }
}
long long query(long long tree[], int a, int b) {
  long long ans = 0;
  for (a += n, b += n + 1; a < b; a >>= 1, b >>= 1) {
    if (a & 1) {
      ans += tree[a++];
    }
    if (b & 1) {
      ans += tree[--b];
    }
  }
  return ans;
}
int cmd, x, y;
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  while (q--) {
    scanf("%d", &cmd);
    if (cmd == 1) {
      scanf("%d%d", &x, &y);
      update(x - 1, y);
    } else {
      scanf("%d", &x);
      --x;
      printf("%I64d\n",
             query(tree[0], x + k, n - 1) + query(tree[1], 0, x - 1));
    }
  }
}
