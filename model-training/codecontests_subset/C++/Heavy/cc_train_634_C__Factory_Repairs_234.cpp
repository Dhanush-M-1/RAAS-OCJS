#include <bits/stdc++.h>
using namespace std;
int a1[200001];
int a2[200001];
int b1[200001];
int b2[200001];
void update(int* b, int x, int t, int n) {
  while (x <= n) {
    b[x] = b[x] + t;
    x = x + (x & (-x));
  }
}
int query(int* b, int x) {
  int ans = 0;
  while (x > 0) {
    ans = ans + b[x];
    x = x - (x & (-x));
  }
  return ans;
}
int main() {
  int n, k, a, b, q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  while (q--) {
    int t;
    scanf("%d", &t);
    int u, v;
    if (t == 1) {
      scanf("%d%d", &u, &v);
      int old1 = a1[u];
      a1[u] += v;
      a1[u] = min(a1[u], b);
      update(b1, u, a1[u] - old1, n);
      int old2 = a2[n - u + 1];
      a2[n - u + 1] += v;
      a2[n - u + 1] = min(a2[n - u + 1], a);
      update(b2, n - u + 1, a2[n - u + 1] - old2, n);
    } else {
      scanf("%d", &u);
      printf("%d\n", query(b1, u - 1) + query(b2, n - u - k + 1));
    }
  }
}
