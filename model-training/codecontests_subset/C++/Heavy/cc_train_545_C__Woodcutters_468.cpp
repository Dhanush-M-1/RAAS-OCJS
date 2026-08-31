#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 100;
struct node {
  int x, h;
} g[maxn];
int main() {
  int n;
  while (cin >> n) {
    int ans = 0;
    for (int i = 0; i < n; i++) scanf("%d%d", &g[i].x, &g[i].h);
    int Max = 1e9 + 10;
    for (int i = 0; i < n; i++) {
      if (i == n - 1 || i == 0) {
        Max = g[i].x;
        ans++;
        continue;
      }
      if (g[i].x - g[i].h > Max)
        ans++, Max = g[i].x;
      else {
        if (g[i].x + g[i].h < g[i + 1].x) {
          ans++;
          Max = g[i].x + g[i].h;
        } else
          Max = g[i].x;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
