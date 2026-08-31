#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
int vis[200005], sum[200005], pre[200005], n, start;
vector<int> v[200005];
queue<int> q;
void del(int x) {
  printf("%d\n", x);
  vis[x] = 1;
  for (int i = 0; i < v[x].size(); i++) {
    int y = v[x][i];
    sum[y]--;
    if (!vis[y] && y != pre[x] && sum[y] % 2 == 0) {
      del(y);
    }
  }
}
void dfs(int p, int x) {
  for (int i = 0; i < v[x].size(); i++) {
    int y = v[x][i];
    if (y != p) dfs(x, y);
  }
  q.push(x);
  pre[x] = p;
}
int main() {
  scanf("%d", &n);
  memset(sum, 0, sizeof(sum));
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x) {
      v[i].push_back(x);
      v[x].push_back(i);
      sum[i]++;
      sum[x]++;
    }
  }
  if (n & 1) {
    printf("YES\n");
    dfs(0, 1);
    while (!q.empty()) {
      int x = q.front();
      q.pop();
      if (sum[x] % 2 == 0) {
        del(x);
      }
    }
  } else {
    printf("NO\n");
  }
  return 0;
}
