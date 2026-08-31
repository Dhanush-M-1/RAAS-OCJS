#include <bits/stdc++.h>
using namespace std;
const int MaxN = 1e3 + 5;
vector<int> Ans, G[MaxN];
int id[MaxN], n, pos, cnt, x, last, num[MaxN], depth[MaxN];
bool dp[MaxN];
void Dfs(int u, int now, int dep) {
  id[u] = now;
  ++num[now];
  depth[u] = dep;
  int Size = G[u].size();
  for (int i = 0; i < Size; ++i) {
    Dfs(G[u][i], now, dep + 1);
  }
}
int main() {
  scanf("%d %d", &n, &x);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &last);
    G[last].push_back(i);
  }
  int Size = G[0].size();
  for (int i = 0; i < Size; ++i) {
    Dfs(G[0][i], i + 1, 1);
  }
  pos = id[x];
  dp[0] = true;
  for (int i = 0; i < Size; ++i) {
    if (id[G[0][i]] == pos) continue;
    int p = num[id[G[0][i]]];
    for (int j = n; j >= p; j--) {
      dp[j] |= dp[j - p];
    }
  }
  int p = num[id[x]];
  for (int j = n; j >= p; --j) {
    if (dp[j - p]) Ans.push_back(j - p + depth[x]);
  }
  sort(Ans.begin(), Ans.end());
  Size = Ans.size();
  for (int i = 0; i < Size; ++i) {
    printf("%d\n", Ans[i]);
  }
  return 0;
}
