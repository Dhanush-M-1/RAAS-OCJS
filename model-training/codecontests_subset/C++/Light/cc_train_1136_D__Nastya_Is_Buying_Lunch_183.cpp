#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
vector<int> g[N];
int cnt[N], og[N];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    int a;
    scanf("%d", &a);
    og[a] = i;
  }
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    x = og[x];
    y = og[y];
    g[y].push_back(x);
  }
  int ans = 0;
  for (int i = n; i >= 1; i--) {
    if (cnt[i] == n - i - ans && i < n) {
      ans++;
    } else {
      for (auto& y : g[i]) {
        cnt[y]++;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
