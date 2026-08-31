#include <bits/stdc++.h>
using namespace std;
int n, f[105][10005];
int sum1 = 0, sum2 = 0;
int ans1 = 0, ans2 = -1;
struct node {
  int w;
  int v;
} a[105];
int cmp(node a, node b) { return a.v > b.v; }
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].w;
    sum1 += a[i].w;
  }
  for (int i = 1; i <= n; i++) {
    cin >> a[i].v;
    sum2 += a[i].v;
  }
  memset(f, 0xff, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = n; j >= 1; j--) {
      for (int k = sum2; k >= a[i].v; k--) {
        if (f[j - 1][k - a[i].v] != -1) {
          f[j][k] = max(f[j][k], f[j - 1][k - a[i].v] + a[i].w);
        }
      }
    }
  }
  ans2 = -1;
  for (int j = 1; j <= n; j++) {
    for (int k = sum1; k <= sum2; k++) ans2 = max(ans2, f[j][k]);
    if (ans2 != -1) {
      cout << j << ' ' << sum1 - ans2 << endl;
      break;
    }
  }
}
