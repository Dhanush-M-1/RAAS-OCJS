#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int dis[N], in, ans = 1e9, n;
int main() {
  scanf("%d", &n);
  dis[0] = 1;
  dis[n + 1] = 1e6;
  for (int i = 1; i <= n; i++) scanf("%d", dis + i);
  for (int i = 1; i <= n; i++)
    ans = min(ans, max(dis[i] - 1, dis[n + 1] - dis[i + 1]));
  ans = min(ans, min(dis[n] - 1, dis[n + 1] - dis[1]));
  printf("%d\n", ans);
}
