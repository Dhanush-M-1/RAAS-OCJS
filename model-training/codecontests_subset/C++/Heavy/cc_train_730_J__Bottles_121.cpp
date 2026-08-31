#include <bits/stdc++.h>
using namespace std;
inline int max(int x, int y) { return x > y ? x : y; }
int n;
struct node {
  int x, y;
  bool operator<(const node &rhs) const { return y > rhs.y; }
} p[250];
int d[250][250 * 250];
int main() {
  int sum = 0, aans = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    cin >> p[i].x;
    sum += p[i].x;
  }
  for (int i = 1; i <= n; i++) {
    cin >> p[i].y;
    aans += p[i].y;
  }
  sort(p + 1, p + 1 + n);
  int cnt = 1;
  int ssum = sum;
  while (ssum - p[cnt].y > 0) ssum -= p[cnt++].y;
  memset(d, -1, sizeof d);
  for (int i = 1; i <= n; i++) {
    for (int j = i; j >= 2; j--)
      for (int k = aans; k >= 1; k--) {
        if (d[j - 1][k] != -1) d[j][k] = d[j - 1][k];
        if (k >= p[i].y && d[j - 1][k - p[i].y] != -1)
          d[j][k] = max(d[j - 1][k - p[i].y] + p[i].x, d[j][k]);
      }
    d[1][p[i].y] = max(d[1][p[i].y], p[i].x);
  }
  int ans = 0;
  for (int i = aans; i >= sum; i--) {
    if (d[cnt][i] > ans) ans = d[cnt][i];
  }
  cout << cnt << ' ' << sum - ans << endl;
}
