#include <bits/stdc++.h>
using namespace std;
const long long int maxN = 1e5 + 326;
long long int pa[maxN], wei[maxN], has[maxN], need[maxN], N, isLeaf[maxN],
    stillneed[maxN];
bool isViable[maxN];
vector<long long int> chi[maxN];
void dfs(long long int u = 0) {
  for (long long int v : chi[u]) {
    dfs(v);
    if (!isViable[v]) {
      isViable[u] = false;
      return;
    }
    if (stillneed[v]) {
      if (stillneed[v] >=
          ((long long int)1e17 + has[u] - need[u] + wei[v] - 1) / wei[v]) {
        isViable[u] = false;
        return;
      }
      has[u] -= stillneed[v] * wei[v];
      has[v] += stillneed[v];
    }
  }
  if (has[u] >= need[u]) {
    stillneed[u] = 0;
    if (pa[u] != u) has[pa[u]] += has[u] - need[u];
    has[u] = need[u];
  } else {
    stillneed[u] = need[u] - has[u];
  }
}
signed main() {
  cin >> N;
  fill(isViable, isViable + N, true);
  fill(isLeaf, isLeaf + N, true);
  for (long long int i = 0; i < N; i++) cin >> has[i];
  for (long long int i = 0; i < N; i++) cin >> need[i];
  for (long long int i = 1; i < N; i++) {
    cin >> pa[i] >> wei[i];
    pa[i]--;
    chi[pa[i]].push_back(i);
    isLeaf[pa[i]] = false;
  }
  dfs();
  cout << (has[0] >= need[0] && isViable[0] ? "YES" : "NO") << endl;
}
