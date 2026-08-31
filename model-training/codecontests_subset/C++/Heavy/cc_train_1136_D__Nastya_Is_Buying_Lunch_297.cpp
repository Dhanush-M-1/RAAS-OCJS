#include <bits/stdc++.h>
using namespace std;
const int N = 500010;
int a[N], vis[N];
vector<int> v[N];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = (1); i <= (n); i++) scanf("%d", &a[i]);
  for (int i = (1); i <= (m); i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    v[x].push_back(y);
  }
  vis[a[n]] = 1;
  int ans = 0;
  int p = 1;
  for (int i = (n - 1); i >= (1); i--) {
    int tmp = p;
    int now = a[i];
    for (int j = (0); j <= (int(v[now].size()) - 1); j++) {
      int next = v[now][j];
      if (vis[next]) tmp--;
    }
    if (tmp == 0)
      ans++;
    else {
      vis[now] = 1;
      p++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
