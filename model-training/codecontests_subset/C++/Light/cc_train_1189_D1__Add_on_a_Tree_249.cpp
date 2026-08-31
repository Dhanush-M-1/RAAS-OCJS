#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> G[100005];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n - 1; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    G[u].push_back(v);
    G[v].push_back(u);
  }
  for (int i = 1; i <= n; i++)
    if (G[i].size() == 2) {
      printf("NO\n");
      return 0;
    }
  printf("YES\n");
  return 0;
}
