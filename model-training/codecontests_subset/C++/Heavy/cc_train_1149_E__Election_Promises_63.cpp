#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
vector<int> G[maxn];
int topo[maxn];
int sg[maxn], deg[maxn], mem[maxn];
int Xor[maxn];
long long h[maxn];
int main(void) {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) scanf("%lld", &h[i]);
  for (int i = 1; i <= m; ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    G[u].push_back(v);
    deg[v]++;
  }
  queue<int> q;
  int cnt = 1;
  for (int i = 1; i <= n; ++i)
    if (deg[i] == 0) q.push(i);
  while (!q.empty()) {
    int p = q.front();
    q.pop();
    topo[cnt++] = p;
    for (auto c : G[p]) {
      deg[c]--;
      if (deg[c] == 0) q.push(c);
    }
  }
  for (int i = n; i >= 1; --i) {
    int u = topo[i];
    for (auto c : G[u]) mem[sg[c]] = i;
    while (mem[sg[u]] == i) sg[u]++;
    Xor[sg[u]] ^= h[u];
  }
  int index = -1;
  for (int i = 0; i < maxn; ++i)
    if (Xor[i] != 0) index = i;
  if (index == -1) return 0 * puts("LOSE");
  for (int i = 1; i <= n; ++i) {
    if (sg[i] == index && ((h[i] ^ Xor[index]) < h[i])) {
      h[i] ^= Xor[index];
      for (auto c : G[i]) {
        h[c] ^= Xor[sg[c]];
        Xor[sg[c]] = 0;
      }
      break;
    }
  }
  puts("WIN");
  for (int i = 1; i <= n; ++i) printf("%lld ", h[i]);
  return 0;
}
